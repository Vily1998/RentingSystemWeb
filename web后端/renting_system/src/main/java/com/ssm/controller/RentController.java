package com.ssm.controller;


import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.model.House;
import com.ssm.model.Message;
import com.ssm.model.User;
import com.ssm.model.Want;
import com.ssm.model.Rent;
import com.ssm.service.HouseService;
import com.ssm.service.UserService;
import com.ssm.service.RentService;


@Controller
@RequestMapping("/rent")

public class RentController {

	
	@Autowired
    private RentService rentService;
	
	
	/**
     * ����������Ϣ����������Ϊ��ʡ+��
     * @RequestMapping AddRent
     * @param int user_id,String city_name,String community_name,int house_type,int house_floor,int is_elevator,String description,float deposit,int payment_method,float rent_per_month,String register_time,String modify_time
     * @return 0 ����ʧ��
     * @return id �����ɹ�������������ʶid
     */
    @RequestMapping("AddRent")
    @ResponseBody
    public int AddHouse(int user_id,String city_name,String community_name,int house_type,int house_floor,int is_elevator,String description,float deposit,int payment_method,float rent_per_month,String register_time,String modify_time) {
    	
    	
		Rent rent = new Rent();
		System.out.println("*********************");
    	int id=rentService.findMaxRentID()+1;
    	
    	rent.set_rent_id(id);
    	rent.set_user_id(user_id);
    	rent.set_city_name(city_name);
    	rent.set_community_name(community_name);
    	rent.set_house_type(house_type);
    	rent.set_house_floor(house_floor);
    	rent.set_is_elevator(is_elevator);
    	rent.set_description(description);
    	rent.set_deposit(deposit);
    	rent.set_payment_method(payment_method);
    	rent.set_rent_per_month(rent_per_month);
    	rent.set_register_time(register_time);
    	
    
    	//System.out.println(id);
    	int flag=rentService.addRent(rent);
    	if(flag==1) {
    		System.out.println("�����ɹ��������ʶΪ��"+id);
    		return id;
    	}
    	else return 0;
    }
    
    
    /**
     * ��ѯ�Լ�����������������Ϣ
     * @RequestMapping SelectRentByUserId
     * @param int user_id
     * @return null δ����������Ϣ
     * @return List<House> �����ķ�����Ϣ
     */
    @RequestMapping("SelectRentByUserId")
    @ResponseBody
    public List<Rent> SelectRentByUserId(int user_id) {
    	System.out.println("*********************");
    	List<Rent> allhouse=rentService.SelectRentByUserId(user_id);
    	return allhouse;
    	
    }
    
    /**
     * ͨ�����������ѯ������Ϣ��δѡ����-1�����������ơ��������ơ�����¥�źš��������͡���С���������������������¥�㡢�Ƿ��е��ݡ�������֧����ʽ������������������״̬
     * @RequestMapping SelectRent
     * @param String city_name,String community_name,int house_type,int house_floor,int is_elevator,String description,int payment_method,float low_rent_per_month,float high_rent_per_month
     * @return null ��ѯ���Ϊ��
     * @return List<House> ��ѯ�ɹ�
     */
    
    
    @RequestMapping("SelectRent")
    @ResponseBody
    public List<Rent> SelectRent(String city_name,String community_name,int house_type,int house_floor,int is_elevator,String description,int payment_method,float low_rent_per_month,float high_rent_per_month) {
    	System.out.println("*********************");
    	List<Rent> allhouse=rentService.SelectRent(city_name, community_name, house_type,house_floor, is_elevator, description,payment_method,low_rent_per_month,high_rent_per_month);
    	return allhouse;
    }
    
    /**
     * ɾ������
     * @RequestMapping DeleteRent
     * @param int rent_id
     * @return 0 ɾ��ʧ��
     * @return 1 ɾ���ɹ�
     */
    @RequestMapping("DeleteRent")
    @ResponseBody
    public int DeleteRent(int rent_id){
    	System.out.println("*********************");
    	int flag=rentService.DeleteRent(rent_id);
    	return flag;
    }
    
    @RequestMapping("SelectRentByRentId")
    @ResponseBody
    public Rent SelectRentByRentId(int rent_id) {
    	System.out.println("*********************");
    	Rent rent=rentService.SelectRentByRentId(rent_id);
    	return rent;
    }
    
    /**
     * ���·�����Ϣ
     * @RequestMapping UpdateHouse
     * @param int house_id,String city_name,String community_name,String house_num,int house_type,float house_area,int house_floor,int is_elevator,String description,String photo,float deposit,int payment_method,float rent_per_month,int state
     * @return 0 ����ʧ��
     * @return id ע��ɹ���������û���ʶid
     */
    @RequestMapping("UpdateRent")
    @ResponseBody
    public String UpdateHouse(int rent_id,String city_name,String community_name,int house_type,int house_floor,int is_elevator,String description,float deposit,int payment_method,float rent_per_month){
    	System.out.println("*********************");
    	int flag=rentService.UpdateRent(rent_id,city_name,community_name,house_type,house_floor,is_elevator,description,deposit,payment_method,rent_per_month);
    	if(flag!=0) {
    		System.out.println("1111");
    		Rent rent=rentService.SelectRentByRentId(rent_id);
    		String update_time=rent.get_modify_time();
    		return update_time;
    	}
    	return null;
    }
    
    /**
     * ���������
     * @RequestMapping AddMessage
     * @param int landlord_user_id, int house_id, int rent_id, String content
     * @return 0 ����ʧ��
     * @return message_id ����ɹ�������ñ�ʶid
     */
    @RequestMapping("AddMessage")
    @ResponseBody
    public int AddMessage(int landlord_user_id, int house_id, int rent_id, String content) {
    	
		Message message = new Message();
		System.out.println("*********************");
    	int message_id=rentService.findMaxMessageID()+1;
    	Rent rent=rentService.SelectRentByRentId(rent_id);
    	int tenant_user_id=rent.get_user_id();

	    int state=0;
	    
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	    String modify_time=df.format(System.currentTimeMillis());   
	    
	    message.set_message_id(message_id);
	    message.set_house_id(house_id);
	    message.set_landlord_user_id(landlord_user_id);
	    message.set_tenant_user_id(tenant_user_id);
	    message.set_content(content);
	    message.set_state(state);
	    message.set_modify_time(modify_time);
	    
	    int flag=rentService.AddMessaage(message);
    	if(flag==1) {
    		System.out.println("�����ɹ���message��ʶΪ��"+message_id);
    		return message_id;
    	}
    	else return 0;	
    }
    
    /**
     * ��ѯ����Ϣ����
     * @RequestMapping AddMessage
     * @param int landlord_user_id, int house_id, int rent_id, String content
     * @return 0 ������Ϣ
     * @return ans ��Ϣ����
     */
    @RequestMapping("CheckMessageNum")
    @ResponseBody
    public int CheckMessageNum(int user_id) {
    	int ans=rentService.CheckMessageNum(user_id);
    	int flag=rentService.SetMessageState(user_id);
    	return ans;
    }
    
    /**
     * ͨ��user_id��ѯmessage
     * @RequestMapping FindMessageByUserId
     * @param int user_id
     * @return Message ʵ����
     */
    @RequestMapping("FindMessageByUserId")
    @ResponseBody
    public List<Message> FindMessageByUserId(int user_id) {
    	//System.out.println("*********************");
    	List<Message> allmessage=rentService.FindMessageByUserId(user_id);
    	return allmessage;
    }
    
    
    
    
}
