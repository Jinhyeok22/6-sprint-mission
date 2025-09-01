package com.sprint.mission.discodeit.repository.file;

import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.repository.UserRepository;

import java.io.*;
import java.util.*;

public class FileUserRepository implements UserRepository {
    private final File file;

    public FileUserRepository(String filename) {
        this.file = new File(filename);
    }

    private Map<UUID, User> readStorage() {
        if (!file.exists()) return new HashMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Map<UUID, User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new HashMap<>();
        }
    }

    private void writeStorage(Map<UUID, User> storage) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(storage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User save(User user) {
        Map<UUID, User> storage = readStorage();
        storage.put(user.getId(), user);
        writeStorage(storage);
        return user;
    }

    @Override
    public User findById(UUID id) {
        return readStorage().get(id);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(readStorage().values());
    }


        @Override
        public void delete(UUID id) {
            Map<UUID, User> storage = readStorage();
            storage.remove(id);
            writeStorage(storage);
        }

    }
