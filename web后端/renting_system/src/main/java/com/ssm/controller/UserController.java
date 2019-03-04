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
 * ����:�û�controller<BR>
 * ������:<BR>
 * ʱ��:2017��7��10������7:15:58<BR>
 * @version
 */
public class UserController {

    @Autowired
    private UserService userService;  
    
    
    /**
     * ����û����Ϸ�
     * @RequestMapping CheckUser
     * @param String user_name
     * @return 0 �û�����ʹ��
     * @return 1 �û����Ϸ�
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
     * ����û����������Ƿ�ƥ��
     * @RequestMapping CheckPassword
     * @param String user_name, String password
     * @return 0 ��¼ʧ��
     * @return 1 ��½�ɹ�
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
        	System.out.println(user.get_user_name()+"��½�ɹ�");
        	return 1;
        }
        else {
        	System.out.println(user.get_user_name()+"��¼ʧ��");
        	return 0;
        }
    }
    
    
    /**
     * ����û�
     * @RequestMapping AddUser
     * @param String user_name,String password,int user_type,String real_name,int certificate_type,String certificate_num,String mobile_num,int user_level,String register_city,String register_time,String modify_time
     * @return 0 ע��ʧ��
     * @return -1 �û����Ѵ���
     * @return id ע��ɹ���������û���ʶid
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
	    		System.out.println("ע��ɹ����û���ʶΪ��"+id);
	    		return id;
	    	}
	    	else return 0;
    	}
    	
    	
    }
    
    
    /**
     * �����������������Ƿ�����
     * @RequestMapping CheckPasswordSimilar
     * @param String user_name,String new_password
     * @return 0 ������
     * @return 1 ����
     */
    @RequestMapping("CheckPasswordSimilar")
    @ResponseBody
    public int CheckPasswordSimilar(String old_password,String new_password) {
    	//System.out.println("*********************");
    	
    	
    	String new_password_low = new_password.toLowerCase();
    	String old_password_low = old_password.toLowerCase();
    	int d[][]; // ����
        int n = new_password_low.length();
        int m = old_password_low.length();
        int i; // ����new_password��
        int j; // ����old_password��
        char ch1; // new_password��
        char ch2; // old_password��
        int temp; // ��¼��ͬ�ַ�,��ĳ������λ��ֵ������,����0����1
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        d = new int[n + 1][m + 1];
        for (i = 0; i <= n; i++) { // ��ʼ����һ��
            d[i][0] = i;
        }

        for (j = 0; j <= m; j++) { // ��ʼ����һ��
            d[0][j] = j;
        }

        for (i = 1; i <= n; i++) { // ����new_password
            ch1 = new_password_low.charAt(i - 1);
            // ȥƥ��old_passwordet
            for (j = 1; j <= m; j++) {
                ch2 = old_password_low.charAt(j - 1);
                if (ch1 == ch2) {
                    temp = 0;
                } 
                else {
                    temp = 1;
                }
                // ���+1,�ϱ�+1, ���Ͻ�+tempȡ��С
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
     * �����û�
     * @RequestMapping CheckPasswordSimilar
     * @param String user_name,String new_password
     * @return 0 �����������ֻ���δ���ģ����������
     * @return -1 ����ʧ��
     * @return 1 ���³ɹ�
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
     * ��ʾ�����û���Ϣ
     * @RequestMapping UserInformation
     * @param String user_name
     * @return User �û�ʵ����
     */
    @RequestMapping("UserInformation")
    @ResponseBody
    public User UserInformation(String user_name) {
    	//System.out.println("*********************");
    	User user=userService.findUserByUserName(user_name);
    	return user;
    }
    
    /**
     * ͨ��user_id��ѯuser
     * @RequestMapping FindUserByUserId
     * @param int user_id
     * @return User �û�ʵ����
     */
    @RequestMapping("FindUserByUserId")
    @ResponseBody
    public User FindUserByUserID(int user_id) {
    	//System.out.println("*********************");
    	User user=userService.findUserByUserID(user_id);
    	return user;
    }
    
    /**
     * ��ʾȫ���û���Ϣ
     * @RequestMapping UserInformation
     * @param String user_name
     * @return User �û�ʵ����
     */
    @RequestMapping("AllUserInfo")
    @ResponseBody
    public List<User> AllUserInfo() {
    	//System.out.println("*********************");
    	List<User> alluser=userService.AllUserInfo();
    	return alluser;
    }
    
    
  
}
