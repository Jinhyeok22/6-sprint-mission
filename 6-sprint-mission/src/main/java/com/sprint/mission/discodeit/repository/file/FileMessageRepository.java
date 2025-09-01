package com.sprint.mission.discodeit.repository.file;

import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.repository.MessageRepository;

import java.io.*;
import java.util.*;

public class FileMessageRepository implements MessageRepository {
    private final File file;

    public FileMessageRepository(String filename) {
        this.file = new File(filename);
    }

    private Map<UUID, Message> readStorage() {
        if (!file.exists()) return new HashMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Map<UUID, Message>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new HashMap<>();
        }
    }

    private void writeStorage(Map<UUID, Message> storage) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(storage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Message save(Message message) {
        Map<UUID, Message> storage = readStorage();
        storage.put(message.getId(), message);
        writeStorage(storage);
        return message;
    }

    @Override
    public Message findById(UUID id) {
        return readStorage().get(id);
    }

    @Override
    public List<Message> findAll() {
        return new ArrayList<>(readStorage().values());
    }

    @Override
    public void deleteById(UUID id) {
        Map<UUID, Message> storage = readStorage();
        storage.remove(id);
        writeStorage(storage);
    }
    @Override
    public void delete(UUID id) {
        Map<UUID, Message> storage = readStorage();
        storage.remove(id);
        writeStorage(storage);
    }

}

