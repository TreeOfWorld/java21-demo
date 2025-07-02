package com.treeofworld.elf.service;

import com.treeofworld.elf.context.UserContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * UserInfoServiceImpl
 *
 * @author: elf
 * @data: 2025/7/2
 * @version: 1.0
 */
@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Override
    public UserContext.UserInfo getUserInfo() {
        log.info("getUserInfo in service: {}", UserContext.getContext().get());
        return UserContext.getContext().get();
    }

    @Override
    public UserContext.UserInfo getNewUserInfo() {
        ScopedValue<UserContext.UserInfo> userInfoContext = UserContext.getContext();
        ScopedValue.where(userInfoContext, new UserContext.UserInfo(STR."\{userInfoContext.get().username()}[new]",
                STR."\{userInfoContext.get().password()}[new]")).run(this::printUserInfo);
        return UserContext.getContext().get();
    }

    private void printUserInfo() {
        log.info("printUserInfo in service: {}", UserContext.getContext().get());
    }
}
