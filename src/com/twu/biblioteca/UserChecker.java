package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;

public class UserChecker {

    private Map<String, String> presetUserList = new HashMap<>();

    public UserChecker() {
        initPresetUserList();
    }

    private void initPresetUserList() {
        presetUserList.put("1111-1111", "123456");
        presetUserList.put("2222-2222", "123456");
        presetUserList.put("3333-3333", "123456");
    }

    public boolean checkUser(String libraryNumber, String password) {
        return presetUserList.containsKey(libraryNumber) && presetUserList.get(libraryNumber).equals(password);
    }
}
