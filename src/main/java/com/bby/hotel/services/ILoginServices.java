package com.bby.hotel.services;

import com.bby.hotel.model.TabUserInfoModel;

public interface ILoginServices {

    /**
     * 登陆
     * @param account 账号
     * @return TabUserInfoModel 登陆用户信息
     * @throws Exception ex
     */
    TabUserInfoModel login(String account) throws Exception;



}
