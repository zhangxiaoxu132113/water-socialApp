package com.water.db.service.impl;

import com.water.db.dao.UserMapper;
import com.water.db.model.User;
import com.water.db.model.UserCriteria;
import com.water.db.service.interfaces.UserService;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import com.water.utils.web.vo.UserDto;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    public User findUserByNameAndPwd(String login_username, String login_password) {
        if (StringUtils.isAnyBlank(login_username, login_password)) {
            throw new RuntimeException("参数不合法！");
        }
        UserCriteria userCriteria = new UserCriteria();
        UserCriteria.Criteria criteria = userCriteria.createCriteria();
        criteria.andAccountEqualTo(login_username);
        criteria.andPasswordEqualTo(login_password);
        List<User> userList = userMapper.selectByExample(userCriteria);
        if (userList != null && userList.size() > 0) {
            return userList.get(0);
        }
        return null;
    }

    public void addUser(UserDto userDto) {
        if (StringUtils.isAnyBlank(userDto.getAccount(),userDto.getPassword(),userDto.getEmail())) {
            throw new RuntimeException("参数不合法！");
        }
        userMapper.insert(userDto);
    }
}