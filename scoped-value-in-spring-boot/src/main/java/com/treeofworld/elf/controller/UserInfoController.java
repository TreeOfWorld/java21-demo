package com.treeofworld.elf.controller;

import com.treeofworld.elf.context.UserContext;
import com.treeofworld.elf.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserInfoController
 *
 * @author: elf
 * @data: 2025/7/2
 * @version: 1.0
 */
@Slf4j
@RestController
public class UserInfoController {

    final UserInfoService userInfoService;

    UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @GetMapping("/user-info")
    public UserContext.UserInfo getUserInfo() {
        log.info("getUserInfo in controller: {}", UserContext.getContext().get());
        return this.userInfoService.getUserInfo();
    }

    /**
     * 尝试在service中对上下文中的ScopedValue进行修改，并在controller中获取修改后的ScopedValue
     */
    @GetMapping("/new-user-info")
    public UserContext.UserInfo getNewUserInfo() {
        log.info("getUserInfo in controller: {}", UserContext.getContext().get());
        UserContext.UserInfo newUserInfo = this.userInfoService.getNewUserInfo();
        log.info("getNewUserInfo in controller: {}", newUserInfo);
        return newUserInfo;
    }

}
