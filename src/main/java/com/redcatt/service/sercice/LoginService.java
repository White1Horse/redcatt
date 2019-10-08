package com.redcatt.service.sercice;

import com.redcatt.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface LoginService {
    User getUserByAccount(@Param("account") String account);
}
