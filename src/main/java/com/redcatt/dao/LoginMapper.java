package com.redcatt.dao;

import com.redcatt.pojo.User;

public interface LoginMapper {

    User getUserByAccount(String account);
}
