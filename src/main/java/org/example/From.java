package org.example;

public class From {
    int id;
    String key;
    String name;
    String IP;
    int port;
    String path;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public From(int id, String key, String name, String IP, int port, String path) {
        this.id = id;
        this.key = key;
        this.name = name;
        this.IP = IP;
        this.port = port;
        this.path = path;
    }
}
