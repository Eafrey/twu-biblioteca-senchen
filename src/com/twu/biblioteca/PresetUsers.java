package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class PresetUsers {

    private Map<String, UserInfo> presetUserList = new HashMap<>();

    public PresetUsers() {
        initPresetUserList();
    }

    private void initPresetUserList() {
        presetUserList.put("1111-1111", new UserInfo(1, "1111-1111", "123456", "1@tw.com", "18812345678"));
        presetUserList.put("222-2222", new UserInfo(2, "2222-2222", "123456", "2@tw.com", "15512345678"));
        presetUserList.put("2222-2222", new UserInfo(3, "3333-3333", "123456", "3@tw.com", "13312345678"));
    }

    public boolean checkUser(String libraryNumber, String password) {
        return presetUserList.containsKey(libraryNumber) && presetUserList.get(libraryNumber).getPassword().equals(password);
    }


    public UserInfo getUserInfo(String libraryNumber) {
        return presetUserList.get(libraryNumber);
    }
}
