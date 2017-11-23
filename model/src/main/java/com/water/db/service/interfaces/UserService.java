package com.water.db.service.interfaces;

import com.water.uubook.model.TbUbUser;
import com.water.utils.web.vo.UserDto;

public interface UserService {
    TbUbUser findUserByNameAndPwd(String login_username, String login_password);

    void addUser(UserDto userDto);
}