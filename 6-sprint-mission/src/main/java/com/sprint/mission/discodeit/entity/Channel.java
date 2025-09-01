package com.sprint.mission.discodeit.entity;

import java.util.UUID;

public class Channel {
    private UUID id;
    private String name;     // 채널 이름
    private String topic;    // 채널 주제

    public Channel(String name, String topic) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.topic = topic;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTopic() {
        return topic;
    }

    public void updateName(String newName) {
        this.name = newName;
    }

    public void updateTopic(String newTopic) {
        this.topic = newTopic;
    }

    @Override
    public String toString() {
        return "Channel ( User id=" + id + ", name=" + name +
                ", topic=" + topic + ")";
    }
}