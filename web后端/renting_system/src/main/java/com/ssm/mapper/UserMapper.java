package com.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.model.User;
/**
 * ����:�û�mapper�ӿ�<BR>
 * ������:<BR>
 * ʱ��:2017��7��10������6:14:22<BR>
 * @version
 */
public interface UserMapper {



    User findUserByUserName(String user_name);
    
    int findMaxUserID();
    
    int addUser(User user);
    
    int updateUser(@Param("user_name")String user_name,@Param("new_password")String new_password,@Param("new_mobile_num")String new_mobile_num);
    
    List<User> AllUserInfo();

	User findUserByUserID(int user_id);

	int findLevelByUserID(int user_id);

	int addFee(int user_id);
	


}
