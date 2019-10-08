package com.redcatt.service;

import com.redcatt.dao.RegistMapper;
import com.redcatt.service.sercice.RegistService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class RegistServiceImpl implements RegistService {

    @Resource
    RegistMapper registMapper;

    @Override
    @Transactional
    public void addUser(String userName, String passWord) {
        registMapper.addUser(userName, passWord);
    }
}
