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
     * ������
     * @RequestMapping AddWant
     * @param int house_id, String tenant_user_name, String start_month, int continual_month, String description
     * @return 0 ����ʧ��
     * @return want_id ����ɹ�������ñ�ʶid
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
    		System.out.println("�����ɹ���want��ʶΪ��"+want_id);
    		return want_id;
    	}
    	else return 0;	
    }
    
    /**
     * ��ѯ�Լ��յ���������Ϣ
     * @RequestMapping SelectWantByLandlordUserId
     * @param int user_id
     * @return null ��
     * @return List<House> want��Ϣ
     */
    @RequestMapping("SelectWantByLandlordUserId")
    @ResponseBody
    public List<Want> SelectWantByLandlordUserId(int user_id) {
    	System.out.println("*********************");
    	List<Want> allwant=wantService.SelectWantByLandlordUserId(user_id);
    	return allwant;
    }
    
    /**
     * ��ѯ�Լ������want��Ϣ
     * @RequestMapping SelectWantByTenantUserId
     * @param int user_id
     * @return null ��
     * @return List<House> want��Ϣ
     */
    @RequestMapping("SelectWantByTenantUserId")
    @ResponseBody
    public List<Want> SelectWantByTenantUserId(int user_id) {
    	System.out.println("*********************");
    	List<Want> allwant=wantService.SelectWantByTenantUserId(user_id);
    	return allwant;
    }
    
    /**
     * ͨ��want_id��ѯwant��Ϣ
     * @RequestMapping SelectWantByTenantUserId
     * @param int want_id
     * @return null ��
     * @return List<House> want��Ϣ
     */
    @RequestMapping("SelectWantByWantId")
    @ResponseBody
    public Want SelectWantByWantId(int want_id) {
    	System.out.println("*********************");
    	Want want=wantService.SelectWantByWantId(want_id);
    	return want;
    }
    
    /**
     * �ڶ������� ����ͬ��
     * @RequestMapping Want2Agree
     * @param int want_id
     * @return 0 ʧ��
     * @return 1 ͬ��ɹ�
     */
    @RequestMapping("Want2Agree")
    @ResponseBody
    public int Want2Agree(int want_id) {
    	System.out.println("*********************");
    	int flag=wantService.Want2Agree(want_id);
    	return flag;
    	
    }
    
    
    /**
     * ����want��Ϣ
     * @RequestMapping UpdateWant
     * @param int want_id, String start_month, int continual_month, String description
     * @return 0 ����ʧ��
     * @return 1 ���³ɹ�
     */
    @RequestMapping("UpdateWant")
    @ResponseBody
    public int UpdateWant(int want_id, String start_month, int continual_month, String description){
    	System.out.println("*********************");
    	int flag=wantService.UpdateWant(want_id,start_month, continual_month,description);
    	return flag;
    }
    
    /**
     * ɾ��want��Ϣ
     * @RequestMapping DeleteWant
     * @param int want_id
     * @return 0 ɾ��ʧ��
     * @return 1 ɾ���ɹ�
     */
    @RequestMapping("DeleteWant")
    @ResponseBody
    public int DeleteWant(int want_id){
    	System.out.println("*********************");
    	int flag=wantService.DeleteWant(want_id);
    	return flag;
    }
    
    /**
     * ��ѯ�����ⷿ��Ϣ����
     * @RequestMapping AddMessage
     * @param int user_id
     * @return 0 ������Ϣ
     * @return ans ��Ϣ����
     */
    @RequestMapping("CheckWantNum")
    @ResponseBody
    public int CheckWantNum(int user_id) {
    	int ans=wantService.CheckWantNum(user_id);
    	return ans;
    }
    
    /**
     * ��ѯͬ���ⷿ��Ϣ����
     * @RequestMapping CheckAgreeNum
     * @param int user_id
     * @return 0 ������Ϣ
     * @return ans ��Ϣ����
     */
    @RequestMapping("CheckAgreeNum")
    @ResponseBody
    public int CheckAgreeNum(int user_id) {
    	int ans=wantService.CheckAgreeNum(user_id);
    	return ans;
    }
    
    /**
     * ��ѯ�ɽ���Ϣ����
     * @RequestMapping CheckDealNum
     * @param int user_id
     * @return 0 ������Ϣ
     * @return ans ��Ϣ����
     */
    @RequestMapping("CheckDealNum")
    @ResponseBody
    public int CheckDealNum(int user_id) {
    	int ans=wantService.CheckDealNum(user_id);
    	int flag=wantService.SetWantState(user_id);
    	return ans;
    }
    
    
    

}
