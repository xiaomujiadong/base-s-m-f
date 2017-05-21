package com.cwd.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cwd.dao.IUserInfoDao;
import com.cwd.mybatis.mapper.IUserInfoMapper;
import com.cwd.pojo.UserInfo;

@Component 
public class UserInfoDaoImpl implements IUserInfoDao{
	@Autowired  
    private IUserInfoMapper userMapper;  
	
	public UserInfo getUserInfoById(int userId){
		return userMapper.getUserInfoById(userId);
	}
}
