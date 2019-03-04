
package com.ssm.service;

import java.util.List;

import com.ssm.model.User;
/**
 * 描述:用户service<BR>
 * 创建人:<BR>
 * 时间:2017年7月11日下午7:06:59<BR>
 * @version
 */
public interface UserService {



    User findUserByUserName(String user_name);
    
    int findMaxUserID();
    
    int addUser(User user);
    
    int updateUser(String user_name,String new_password,String new_mobile_num);
    
    List<User> AllUserInfo();

	User findUserByUserID(int user_id);
	
	int findLevelByUserID(int user_id);

}
