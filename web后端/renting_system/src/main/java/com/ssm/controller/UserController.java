package com.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.model.User;
import com.ssm.service.UserService;

@Controller
@RequestMapping("/user")
/**
 * 描述:用户controller<BR>
 * 创建人:<BR>
 * 时间:2017年7月10日下午7:15:58<BR>
 * @version
 */
public class UserController {

    @Autowired
    private UserService userService;  
    
    
    /**
     * 检查用户名合法
     * @RequestMapping CheckUser
     * @param String user_name
     * @return 0 用户名被使用
     * @return 1 用户名合法
     */

    @RequestMapping("CheckUser")
    @ResponseBody
    public int CheckUser(String user_name){
        if(userService.findUserByUserName(user_name)==null) {
        	return 0;
        }
        else {
        	return 1;
        }
    }

    
    /**
     * 检查用户名与密码是否匹配
     * @RequestMapping CheckPassword
     * @param String user_name, String password
     * @return 0 登录失败
     * @return 1 登陆成功
     */
    @RequestMapping("CheckPassword")
    @ResponseBody
    public int CheckPassword(String user_name, String password) {
    	System.out.println(user_name);
    	System.out.println(password);
    	User user=userService.findUserByUserName(user_name);
    	//System.out.println(user.get_user_name());
    	if(user==null) return 0;
        if(user.get_user_name().equals(user_name)&&user.get_password().equals(password)) {
        	System.out.println(user.get_user_name()+"登陆成功");
        	return 1;
        }
        else {
        	System.out.println(user.get_user_name()+"登录失败");
        	return 0;
        }
    }
    
    
    /**
     * 添加用户
     * @RequestMapping AddUser
     * @param String user_name,String password,int user_type,String real_name,int certificate_type,String certificate_num,String mobile_num,int user_level,String register_city,String register_time,String modify_time
     * @return 0 注册失败
     * @return -1 用户名已存在
     * @return id 注册成功，并获得用户标识id
     */
    @RequestMapping("AddUser")
    @ResponseBody
    public int AddUser(String user_name,String password,int user_type,String real_name,int certificate_type,String certificate_num,String mobile_num,int user_level,String register_city,String register_time,String modify_time) {
    	if(userService.findUserByUserName(user_name)!=null) {
    		return -1;
    	}
    	else {
    		User user = new User();
    		//System.out.println("*********************");
	    	int id=userService.findMaxUserID()+1;
	    	user.set_user_id(id);
	    	user.set_user_name(user_name);
	    	user.set_password(password);
	    	user.set_user_type(user_type);
	    	user.set_real_name(real_name);
	    	user.set_certificate_type(certificate_type);
	    	user.set_certificate_num(certificate_num);
	    	user.set_mobile_num(mobile_num);
	    	user.set_user_level(user_level);
	    	user.set_register_city(register_city);
	    	user.set_register_time(register_time);
	    	user.set_modify_time(modify_time);
	    	//System.out.println(id);
	    	int flag=userService.addUser(user);
	    	
	    	
	    	if(flag==1) {
	    		System.out.println("注册成功，用户标识为："+id);
	    		return id;
	    	}
	    	else return 0;
    	}
    	
    	
    }
    
    
    /**
     * 检查新密码与旧密码是否相似
     * @RequestMapping CheckPasswordSimilar
     * @param String user_name,String new_password
     * @return 0 不相似
     * @return 1 相似
     */
    @RequestMapping("CheckPasswordSimilar")
    @ResponseBody
    public int CheckPasswordSimilar(String old_password,String new_password) {
    	//System.out.println("*********************");
    	
    	
    	String new_password_low = new_password.toLowerCase();
    	String old_password_low = old_password.toLowerCase();
    	int d[][]; // 矩阵
        int n = new_password_low.length();
        int m = old_password_low.length();
        int i; // 遍历new_password的
        int j; // 遍历old_password的
        char ch1; // new_password的
        char ch2; // old_password的
        int temp; // 记录相同字符,在某个矩阵位置值的增量,不是0就是1
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        d = new int[n + 1][m + 1];
        for (i = 0; i <= n; i++) { // 初始化第一列
            d[i][0] = i;
        }

        for (j = 0; j <= m; j++) { // 初始化第一行
            d[0][j] = j;
        }

        for (i = 1; i <= n; i++) { // 遍历new_password
            ch1 = new_password_low.charAt(i - 1);
            // 去匹配old_passwordet
            for (j = 1; j <= m; j++) {
                ch2 = old_password_low.charAt(j - 1);
                if (ch1 == ch2) {
                    temp = 0;
                } 
                else {
                    temp = 1;
                }
                // 左边+1,上边+1, 左上角+temp取最小
                if(d[i - 1][j] + 1 <= d[i][j - 1] + 1&&d[i - 1][j] + 1 <= d[i - 1][j - 1] + temp) d[i][j] = d[i - 1][j] + 1;
                else if(d[i][j - 1] + 1 <= d[i - 1][j] + 1&&d[i][j - 1] + 1 <= d[i - 1][j - 1] + temp) d[i][j] = d[i][j - 1] + 1;
                else if(d[i - 1][j - 1] + temp <= d[i - 1][j] + 1&&d[i - 1][j - 1] + temp <= d[i][j - 1] + 1) d[i][j] = d[i - 1][j - 1] + temp;
            }
        }
        float ans=1 - (float) d[n][m] / Math.max(new_password.length(), old_password.length());
        if(ans<0.7) {
        	return 0;
        }
        else return 1;
    }
    
    /**
     * 更新用户
     * @RequestMapping CheckPasswordSimilar
     * @param String user_name,String new_password
     * @return 0 密码相似且手机号未更改，不允许更新
     * @return -1 更新失败
     * @return 1 更新成功
     */
    @RequestMapping("UpdateUser")
    @ResponseBody
    public int UpdateUser(String user_name,String old_password,String ordinary_password,String new_password,String new_mobile_num) {
    	//System.out.println("*********************");
    	
    	User user=userService.findUserByUserName(user_name);
    	
    	if(CheckPasswordSimilar(old_password,ordinary_password)==1&&user.get_mobile_num().equals(new_mobile_num)) return 0;
    	int flag=userService.updateUser(user_name, new_password, new_mobile_num);
    	if(flag>0) {
    		return flag;
    	}
    	else {
    		return -1;
    	}
    }
    
    
    /**
     * 显示单个用户信息
     * @RequestMapping UserInformation
     * @param String user_name
     * @return User 用户实体类
     */
    @RequestMapping("UserInformation")
    @ResponseBody
    public User UserInformation(String user_name) {
    	//System.out.println("*********************");
    	User user=userService.findUserByUserName(user_name);
    	return user;
    }
    
    /**
     * 通过user_id查询user
     * @RequestMapping FindUserByUserId
     * @param int user_id
     * @return User 用户实体类
     */
    @RequestMapping("FindUserByUserId")
    @ResponseBody
    public User FindUserByUserID(int user_id) {
    	//System.out.println("*********************");
    	User user=userService.findUserByUserID(user_id);
    	return user;
    }
    
    /**
     * 显示全部用户信息
     * @RequestMapping UserInformation
     * @param String user_name
     * @return User 用户实体类
     */
    @RequestMapping("AllUserInfo")
    @ResponseBody
    public List<User> AllUserInfo() {
    	//System.out.println("*********************");
    	List<User> alluser=userService.AllUserInfo();
    	return alluser;
    }
    
    
  
}
