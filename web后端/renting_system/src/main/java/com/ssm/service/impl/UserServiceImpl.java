package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.mapper.UserMapper;
import com.ssm.model.User;
import com.ssm.service.UserService;
@Service
/**
 * ����:�û�serviceʵ����<BR>
 * ������:<BR>
 * ʱ��:2017��7��10������7:11:57<BR>
 * @version
 */
public class UserServiceImpl implements UserService {

    /**
     * ע��UserMapper�ӿ�
     */
    @Autowired
    private UserMapper userMapper;

    

    

    /**
     * ����user_name�����û�
     */
    @Override
    public User findUserByUserName(String user_name) {
        User user = userMapper.findUserByUserName(user_name);
        return user;
    }
    
    @Override
    public int findMaxUserID() {
    	return userMapper.findMaxUserID();
    }
    
    @Override
    public int addUser(User user) {
    	int user_id=user.get_user_id();
    	int flag=userMapper.addFee(user_id);
    	return userMapper.addUser(user);
    }
    
    @Override
    public int updateUser(String user_name,String new_password,String new_mobile_num) {
    	return userMapper.updateUser(user_name, new_password, new_mobile_num);
    }

    @Override
    public List<User> AllUserInfo() {
    	List<User> allUser = userMapper.AllUserInfo();
        return allUser;
    }
    
    @Override
    public User findUserByUserID(int user_id) {
    	User user = userMapper.findUserByUserID(user_id);
        return user;
    }
    
    @Override
    public int findLevelByUserID(int user_id) {
    	return userMapper.findLevelByUserID(user_id);
    }
    
    

}