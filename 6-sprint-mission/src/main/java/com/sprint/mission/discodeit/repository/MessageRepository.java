package com.sprint.mission.discodeit.repository;

import com.sprint.mission.discodeit.entity.Message;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MessageRepository {
    Message save(Message message);               // 생성 & 수정
    Message findById(UUID id);         // 단건 조회
    List<Message> findAll();                     // 전체 조회
    void deleteById(UUID id);                    // 삭제
    void delete(UUID id);
}