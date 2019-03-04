package com.ssm.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.model.House;
import com.ssm.model.User;
import com.ssm.model.Want;
import com.ssm.service.HouseService;
import com.ssm.service.UserService;
import com.ssm.service.WantService;

@Controller
@RequestMapping("/want")

public class WantController {
	
	@Autowired
    private WantService wantService;  
	@Autowired
	private HouseService houseService;  
	@Autowired
	private UserService userService;  
    
	/**
     * 我想租
     * @RequestMapping AddWant
     * @param int house_id, String tenant_user_name, String start_month, int continual_month, String description
     * @return 0 请求失败
     * @return want_id 请求成功，并获得标识id
     */
    @RequestMapping("AddWant")
    @ResponseBody
    public int AddWant(int house_id, String tenant_user_name, String start_month, int continual_month, String description) {
    	
		Want want = new Want();
		System.out.println("*********************");
    	int want_id=wantService.findMaxWantID()+1;
    	House house=houseService.SelectHouseByHouseId(house_id);
    	User user=userService.findUserByUserName(tenant_user_name);
    	int landlord_user_id=house.get_user_id();
    	
    	int tenant_user_id = user.get_user_id();
    	String real_name=user.get_real_name();
	    int state=1;
	    
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	    String modify_time=df.format(System.currentTimeMillis());   
	    
	    want.set_want_id(want_id);
	    want.set_landlord_user_id(landlord_user_id);
	    want.set_house_id(house_id);
	    want.set_tenant_user_id(tenant_user_id);
	    want.set_real_name(real_name);
	    want.set_start_month(start_month);
	    want.set_continual_month(continual_month);
	    want.set_description(description);
	    want.set_modify_time(modify_time);
	    want.set_state(state);
	    
	    int flag=wantService.AddWant(want);
    	if(flag==1) {
    		System.out.println("发布成功，want标识为："+want_id);
    		return want_id;
    	}
    	else return 0;	
    }
    
    /**
     * 查询自己收到的求租信息
     * @RequestMapping SelectWantByLandlordUserId
     * @param int user_id
     * @return null 无
     * @return List<House> want信息
     */
    @RequestMapping("SelectWantByLandlordUserId")
    @ResponseBody
    public List<Want> SelectWantByLandlordUserId(int user_id) {
    	System.out.println("*********************");
    	List<Want> allwant=wantService.SelectWantByLandlordUserId(user_id);
    	return allwant;
    }
    
    /**
     * 查询自己先祖的want信息
     * @RequestMapping SelectWantByTenantUserId
     * @param int user_id
     * @return null 无
     * @return List<House> want信息
     */
    @RequestMapping("SelectWantByTenantUserId")
    @ResponseBody
    public List<Want> SelectWantByTenantUserId(int user_id) {
    	System.out.println("*********************");
    	List<Want> allwant=wantService.SelectWantByTenantUserId(user_id);
    	return allwant;
    }
    
    /**
     * 通过want_id查询want信息
     * @RequestMapping SelectWantByTenantUserId
     * @param int want_id
     * @return null 无
     * @return List<House> want信息
     */
    @RequestMapping("SelectWantByWantId")
    @ResponseBody
    public Want SelectWantByWantId(int want_id) {
    	System.out.println("*********************");
    	Want want=wantService.SelectWantByWantId(want_id);
    	return want;
    }
    
    /**
     * 第二次握手 卖家同意
     * @RequestMapping Want2Agree
     * @param int want_id
     * @return 0 失败
     * @return 1 同意成功
     */
    @RequestMapping("Want2Agree")
    @ResponseBody
    public int Want2Agree(int want_id) {
    	System.out.println("*********************");
    	int flag=wantService.Want2Agree(want_id);
    	return flag;
    	
    }
    
    
    /**
     * 更新want信息
     * @RequestMapping UpdateWant
     * @param int want_id, String start_month, int continual_month, String description
     * @return 0 更新失败
     * @return 1 更新成功
     */
    @RequestMapping("UpdateWant")
    @ResponseBody
    public int UpdateWant(int want_id, String start_month, int continual_month, String description){
    	System.out.println("*********************");
    	int flag=wantService.UpdateWant(want_id,start_month, continual_month,description);
    	return flag;
    }
    
    /**
     * 删除want信息
     * @RequestMapping DeleteWant
     * @param int want_id
     * @return 0 删除失败
     * @return 1 删除成功
     */
    @RequestMapping("DeleteWant")
    @ResponseBody
    public int DeleteWant(int want_id){
    	System.out.println("*********************");
    	int flag=wantService.DeleteWant(want_id);
    	return flag;
    }
    
    /**
     * 查询申请租房消息数量
     * @RequestMapping AddMessage
     * @param int user_id
     * @return 0 无新消息
     * @return ans 消息数量
     */
    @RequestMapping("CheckWantNum")
    @ResponseBody
    public int CheckWantNum(int user_id) {
    	int ans=wantService.CheckWantNum(user_id);
    	return ans;
    }
    
    /**
     * 查询同意租房消息数量
     * @RequestMapping CheckAgreeNum
     * @param int user_id
     * @return 0 无新消息
     * @return ans 消息数量
     */
    @RequestMapping("CheckAgreeNum")
    @ResponseBody
    public int CheckAgreeNum(int user_id) {
    	int ans=wantService.CheckAgreeNum(user_id);
    	return ans;
    }
    
    /**
     * 查询成交消息数量
     * @RequestMapping CheckDealNum
     * @param int user_id
     * @return 0 无新消息
     * @return ans 消息数量
     */
    @RequestMapping("CheckDealNum")
    @ResponseBody
    public int CheckDealNum(int user_id) {
    	int ans=wantService.CheckDealNum(user_id);
    	int flag=wantService.SetWantState(user_id);
    	return ans;
    }
    
    
    

}
