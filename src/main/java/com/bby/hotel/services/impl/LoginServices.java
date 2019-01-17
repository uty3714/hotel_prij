package com.bby.hotel.services.impl;

import com.bby.hotel.dao.IUserDao;
import com.bby.hotel.model.TabUserInfoModel;
import com.bby.hotel.services.ILoginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServices implements ILoginServices {

    @Autowired
    private IUserDao mUserDao;
    @Override
    public TabUserInfoModel login(String account) throws Exception {
        return mUserDao.selectUserByAccount(account);
    }
}
