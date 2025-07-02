package com.treeofworld.elf.context;

/**
 * UserContext
 *
 * @author: elf
 * @data: 2025/7/2
 * @version: 1.0
 */
public class UserContext {

    public record UserInfo(String username, String password) {

    }

    private static final ScopedValue<UserInfo> userInfo = ScopedValue.newInstance();

    public static ScopedValue<UserInfo> getContext() {
        return userInfo;
    }

}
