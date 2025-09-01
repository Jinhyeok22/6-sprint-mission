package com.sprint.mission.discodeit;

import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.Message;

import com.sprint.mission.discodeit.service.jcf.*;
import com.sprint.mission.discodeit.repository.jcf.JCFUserRepository;
import com.sprint.mission.discodeit.repository.file.FileUserRepository;
import com.sprint.mission.discodeit.repository.file.FileChannelRepository;
import com.sprint.mission.discodeit.repository.file.FileMessageRepository;

public class JavaApplication {

    // ----------------- Setup Method -----------------
    static User setupUser(JCFUserService userService) {
        User user = new User("Woody", "WoodyNick", "woody@codeit.com");
        return userService.create(user);
    }

    public static void main(String[] args) {
        // ====== JCF 테스트 ======
        JCFUserService userService = new JCFUserService();
        User user1 = new User("정진혁", "진혁", "wlsgur8724@naver.com");
        userService.create(user1);

        System.out.println("All Users: " + userService.readAll());
        user1.updateNickname("지녀깅");
        user1.updateEmail("jin_hyeok@nate.com");
        userService.update(user1);
        System.out.println("Updated User: " + userService.read(user1.getId()));

        JCFChannelService channelService = new JCFChannelService();
        Channel channel1 = new Channel("로비", "잡담");
        channelService.create(channel1);

        System.out.println("All Channels: " + channelService.readAll());
        channel1.updateName("게임");  // 이름만 업데이트
        channel1.updateTopic("발로란트"); // 토픽 업데이트
        channelService.update(channel1);
        System.out.println("Updated Channel: " + channelService.read(channel1.getId()));

        JCFMessageService messageService = new JCFMessageService();
        Message msg1 = new Message(user1.getId(), channel1.getId(), "다들 잘 지냈어요?");
        messageService.create(msg1);

        System.out.println("All Messages: " + messageService.readAll());
        msg1.update("게임할사람 구합니다!");
        messageService.update(msg1);
        System.out.println("Updated Message: " + messageService.read(msg1.getId()));

        // 삭제 테스트
        userService.delete(user1.getId());
        channelService.delete(channel1.getId());
        messageService.delete(msg1.getId());

        System.out.println("\n삭제 후 확인");
        System.out.println("Users: " + userService.readAll());
        System.out.println("Channels: " + channelService.readAll());
        System.out.println("Messages: " + messageService.readAll());

        // ====== File 테스트 ======
        JCFUserService fileUserService = new JCFUserService(new FileUserRepository("user.dat"));
        JCFChannelService fileChannelService = new JCFChannelService(new FileChannelRepository("channel.dat"));
        JCFMessageService fileMessageService = new JCFMessageService(new FileMessageRepository("message.dat"));

        User fileUser = new User("Anna", "AnnaNick", "anna@codeit.com");
        fileUserService.create(fileUser);

        Channel fileChannel = new Channel("잡담", "자유 채널");
        fileChannelService.create(fileChannel);

        Message fileMsg = new Message(fileUser.getId(), fileChannel.getId(), "안녕하세요 여러분!");
        fileMessageService.create(fileMsg);

        System.out.println("\nFile 저장소 테스트");
        System.out.println("Users: " + fileUserService.readAll());
        System.out.println("Channels: " + fileChannelService.readAll());
        System.out.println("Messages: " + fileMessageService.readAll());

        // 파일 삭제 테스트
        fileUserService.delete(fileUser.getId());
        fileChannelService.delete(fileChannel.getId());
        fileMessageService.delete(fileMsg.getId());

        System.out.println("\nFile 삭제 후 확인");
        System.out.println("Users: " + fileUserService.readAll());
        System.out.println("Channels: " + fileChannelService.readAll());
        System.out.println("Messages: " + fileMessageService.readAll());

        // Repository 테스트
        JCFUserRepository userRepository = new JCFUserRepository();
        User user = setupUser(userService);
        System.out.println("\nRepository 유저 생성됨: " + user.getId());
    }
}


