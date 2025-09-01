package com.sprint.mission.discodeit.service.jcf;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.repository.file.FileChannelRepository;
import com.sprint.mission.discodeit.service.ChannelService;

import java.util.*;

public class JCFChannelService implements ChannelService {
    private final Map<UUID, Channel> data = new HashMap<>();
    private final FileChannelRepository channelRepository;

    public JCFChannelService() {
        this.channelRepository = null;
    }
    public JCFChannelService(FileChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    public void create(Channel channel) { data.put(channel.getId(), channel); }
    public Channel read(UUID id) { return data.get(id); }
    public List<Channel> readAll() { return new ArrayList<>(data.values()); }
    public void update(Channel channel) { data.put(channel.getId(), channel); }
    public void delete(UUID id) { data.remove(id); }
}
