package com.water.db.service.interfaces;

import com.water.db.model.User;
import com.water.utils.web.vo.UserDto;

public interface UserService {
    User findUserByNameAndPwd(String login_username, String login_password);

    void addUser(UserDto userDto);
}