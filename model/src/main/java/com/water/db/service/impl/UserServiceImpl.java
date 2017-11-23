package com.water.db.service.impl;

import com.water.uubook.dao.TbUbUserMapper;
import com.water.uubook.model.TbUbUser;
import com.water.uubook.model.TbUbUserCriteria;
import com.water.db.service.interfaces.UserService;
import com.water.utils.web.vo.UserDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private TbUbUserMapper userMapper;

    public TbUbUser findUserByNameAndPwd(String login_username, String login_password) {
        if (StringUtils.isAnyBlank(login_username, login_password)) {
            throw new RuntimeException("参数不合法！");
        }
        TbUbUserCriteria userCriteria = new TbUbUserCriteria();
        TbUbUserCriteria.Criteria criteria = userCriteria.createCriteria();
        criteria.andAccountEqualTo(login_username);
        criteria.andPasswordEqualTo(login_password);
        List<TbUbUser> userList = userMapper.selectByExample(userCriteria);
        if (userList != null && userList.size() > 0) {
            return userList.get(0);
        }
        return null;
    }

    public void addUser(UserDto userDto) {
        if (StringUtils.isAnyBlank(userDto.getAccount(), userDto.getPassword(), userDto.getEmail())) {
            throw new RuntimeException("参数不合法！");
        }
        userMapper.insert(userDto);
    }
}