package com.sprint.mission.discodeit.entity;

import java.util.UUID;

public class User {
    private final UUID id;
    private String username;
    private String nickname;
    private String email;

    // 생성자: 이메일을 선택적으로 넣을 수도 있음
    public User(String username, String nickname, String email) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.nickname = nickname;
        this.email = email;
    }

    public UUID getId() { return id; }
    public String getUsername() { return username; }
    public String getNickname() { return nickname; }
    public String getEmail() { return email; }

    public void updateNickname(String newNickname) { this.nickname = newNickname; }
    public void updateEmail(String newEmail) { this.email = newEmail; }

    @Override
    public String toString() {
        return "User id=" + id +
                ", username=" + username +
                ", nickname=" + nickname +
                ", email=" + email ;
    }
}