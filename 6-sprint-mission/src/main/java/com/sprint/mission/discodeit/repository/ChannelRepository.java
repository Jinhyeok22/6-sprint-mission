package com.sprint.mission.discodeit.repository;

import com.sprint.mission.discodeit.entity.Channel;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChannelRepository {
    Channel save(Channel channel);              // 생성 & 수정
    Channel findById(UUID id);        // 단건 조회
    List<Channel> findAll();                    // 전체 조회
    void deleteById(UUID id);                   // 삭제
    void delete(UUID id);
}