package com.gamevox.Account;

public class Account {
    private String username;
    private String password;
    private String clientVersion;

    public Account(String username, String password, String clientVersion) {
        this.username = username;
        this.password = password;
        this.clientVersion = clientVersion;
    }

    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }
    public String getClientVersion() {
        return this.clientVersion;
    }
}
