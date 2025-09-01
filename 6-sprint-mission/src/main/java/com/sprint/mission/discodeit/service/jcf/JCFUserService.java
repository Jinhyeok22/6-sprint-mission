package com.sprint.mission.discodeit.service.jcf;

import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.repository.file.FileUserRepository;
import com.sprint.mission.discodeit.service.UserService;

import java.util.*;

public class JCFUserService implements UserService {
    private final Map<UUID, User> data = new HashMap<>();
    private final FileUserRepository userRepository;

    public JCFUserService() {
        userRepository = null;
    }

    public JCFUserService(FileUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) { data.put(user.getId(), user);
        return user;
    }
    public User read(UUID id) { return data.get(id); }
    public List<User> readAll() { return new ArrayList<>(data.values()); }
    public void update(User user) { data.put(user.getId(), user); }
    public void delete(UUID id) { data.remove(id); }
}
