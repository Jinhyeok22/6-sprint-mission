package com.sprint.mission.discodeit.repository.file;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.repository.ChannelRepository;

import java.io.*;
import java.util.*;

public class FileChannelRepository implements ChannelRepository {
    private final File file;

    public FileChannelRepository(String filename) {
        this.file = new File(filename);
    }


    private Map<UUID, Channel> readStorage() {
        if (!file.exists()) return new HashMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Map<UUID, Channel>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new HashMap<>();
        }
    }

    private void writeStorage(Map<UUID, Channel> storage) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(storage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Channel save(Channel channel) {
        Map<UUID, Channel> storage = readStorage();
        storage.put(channel.getId(), channel);
        writeStorage(storage);
        return channel;
    }

    @Override
    public Channel findById(UUID id) {
        return readStorage().get(id);
    }

    @Override
    public List<Channel> findAll() {
        return new ArrayList<>(readStorage().values());
    }

    @Override
    public void delete(UUID id) {
        Map<UUID, Channel> storage = readStorage();
        storage.remove(id);
        writeStorage(storage);
    }
    @Override
    public void deleteById(UUID id) {
        delete(id); // delete(UUID id) 메서드 재사용
    }
}
