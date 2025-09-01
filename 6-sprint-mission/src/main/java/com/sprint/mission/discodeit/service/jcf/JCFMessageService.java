package com.sprint.mission.discodeit.service.jcf;

import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.repository.file.FileChannelRepository;
import com.sprint.mission.discodeit.repository.file.FileMessageRepository;
import com.sprint.mission.discodeit.service.MessageService;

import java.util.*;

public class JCFMessageService implements MessageService {
    private final Map<UUID, Message> data = new HashMap<>();
    private final FileMessageRepository MessageRepository;

    public JCFMessageService() {
        this.MessageRepository = null;
    }
    public JCFMessageService(FileMessageRepository MessageRepository) {
        this.MessageRepository = MessageRepository;
    }


    public void create(Message message) { data.put(message.getId(), message); }
    public Message read(UUID id) { return data.get(id); }
    public List<Message> readAll() { return new ArrayList<>(data.values()); }
    public void update(Message message) { data.put(message.getId(), message); }
    public void delete(UUID id) { data.remove(id); }
}