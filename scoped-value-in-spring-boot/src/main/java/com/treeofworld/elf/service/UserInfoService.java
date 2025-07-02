package com.treeofworld.elf.service;

import com.treeofworld.elf.context.UserContext;

/**
 * UserInfoService
 *
 * @author: elf
 * @data: 2025/7/2
 * @version: 1.0
 */
public interface UserInfoService {
    UserContext.UserInfo getUserInfo();

    UserContext.UserInfo getNewUserInfo();
}
