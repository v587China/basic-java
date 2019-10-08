package com.ultra.factory.device;

public interface NVR {

    Long login(String ip, int port, String username, String password);

    boolean ptzControl(Long userId, int channel, int preset);

}
