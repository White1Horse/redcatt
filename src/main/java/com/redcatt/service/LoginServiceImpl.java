package com.redcatt.service;

import com.redcatt.dao.LoginMapper;
import com.redcatt.pojo.User;
import com.redcatt.service.sercice.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    LoginMapper loginMapper;
    @Override
    public User getUserByAccount(String account) {
        return loginMapper.getUserByAccount(account);
    }
}
