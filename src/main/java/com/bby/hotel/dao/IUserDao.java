package com.bby.hotel.dao;


import com.bby.hotel.model.TabUserInfoModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "IUserDao")
public interface IUserDao {
    /**
     * 根据账号密码查询用户
     *
     * @param account 用户账号
     * @return 用户数据
     * @throws Exception ex
     */
    TabUserInfoModel selectUserByAccount(@Param("account") String account) throws Exception;



}
