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
     * 发布求租信息：城市名称为：省+市
     * @RequestMapping AddRent
     * @param int user_id,String city_name,String community_name,int house_type,int house_floor,int is_elevator,String description,float deposit,int payment_method,float rent_per_month,String register_time,String modify_time
     * @return 0 发布失败
     * @return id 发布成功，并获得求租标识id
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
    		System.out.println("发布成功，求租标识为："+id);
    		return id;
    	}
    	else return 0;
    }
    
    
    /**
     * 查询自己发布的所有求租信息
     * @RequestMapping SelectRentByUserId
     * @param int user_id
     * @return null 未发布求租信息
     * @return List<House> 发布的房屋信息
     */
    @RequestMapping("SelectRentByUserId")
    @ResponseBody
    public List<Rent> SelectRentByUserId(int user_id) {
    	System.out.println("*********************");
    	List<Rent> allhouse=rentService.SelectRentByUserId(user_id);
    	return allhouse;
    	
    }
    
    /**
     * 通过相关条件查询求租信息（未选择发送-1）：城市名称、社区名称、具体楼门号、房屋类型、最小房屋面积、最大房屋面积所在楼层、是否有电梯、描述、支付方式、最低月租金、最高月租金、状态
     * @RequestMapping SelectRent
     * @param String city_name,String community_name,int house_type,int house_floor,int is_elevator,String description,int payment_method,float low_rent_per_month,float high_rent_per_month
     * @return null 查询结果为空
     * @return List<House> 查询成功
     */
    
    
    @RequestMapping("SelectRent")
    @ResponseBody
    public List<Rent> SelectRent(String city_name,String community_name,int house_type,int house_floor,int is_elevator,String description,int payment_method,float low_rent_per_month,float high_rent_per_month) {
    	System.out.println("*********************");
    	List<Rent> allhouse=rentService.SelectRent(city_name, community_name, house_type,house_floor, is_elevator, description,payment_method,low_rent_per_month,high_rent_per_month);
    	return allhouse;
    }
    
    /**
     * 删除房屋
     * @RequestMapping DeleteRent
     * @param int rent_id
     * @return 0 删除失败
     * @return 1 删除成功
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
     * 更新房屋信息
     * @RequestMapping UpdateHouse
     * @param int house_id,String city_name,String community_name,String house_num,int house_type,float house_area,int house_floor,int is_elevator,String description,String photo,float deposit,int payment_method,float rent_per_month,int state
     * @return 0 更新失败
     * @return id 注册成功，并获得用户标识id
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
     * 我想租给你
     * @RequestMapping AddMessage
     * @param int landlord_user_id, int house_id, int rent_id, String content
     * @return 0 请求失败
     * @return message_id 请求成功，并获得标识id
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
    		System.out.println("发布成功，message标识为："+message_id);
    		return message_id;
    	}
    	else return 0;	
    }
    
    /**
     * 查询新消息数量
     * @RequestMapping AddMessage
     * @param int landlord_user_id, int house_id, int rent_id, String content
     * @return 0 无新消息
     * @return ans 消息数量
     */
    @RequestMapping("CheckMessageNum")
    @ResponseBody
    public int CheckMessageNum(int user_id) {
    	int ans=rentService.CheckMessageNum(user_id);
    	int flag=rentService.SetMessageState(user_id);
    	return ans;
    }
    
    /**
     * 通过user_id查询message
     * @RequestMapping FindMessageByUserId
     * @param int user_id
     * @return Message 实体类
     */
    @RequestMapping("FindMessageByUserId")
    @ResponseBody
    public List<Message> FindMessageByUserId(int user_id) {
    	//System.out.println("*********************");
    	List<Message> allmessage=rentService.FindMessageByUserId(user_id);
    	return allmessage;
    }
    
    
    
    
}
