package com.ssm.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.model.House;
import com.ssm.model.Photo;
import com.ssm.model.User;
import com.ssm.service.HouseService;
import com.ssm.service.UserService;

@Controller
@RequestMapping("/house")

public class HouseController {
	
	@Autowired
    private HouseService houseService;
	
	/**
     * �������ݣ���������Ϊ��ʡ+��
     * @RequestMapping AddHouse
     * @param int user_id,String city_name,String community_name,String house_num,int house_type,float house_area,int house_floor,int is_elevator,String description,String photo,float deposit,int payment_method,float rent_per_month,String register_time,String modify_time,int state
     * @return 0 ע��ʧ��
     * @return id �����ɹ�������÷��ݱ�ʶid
     */
    @RequestMapping("AddHouse")
    @ResponseBody
    public int AddHouse(int user_id,String city_name,String community_name,String house_num,int house_type,float house_area,int house_floor,int is_elevator,String description,float deposit,int payment_method,float rent_per_month,String register_time,String modify_time,int state) {
    	
    	
		House house = new House();
		System.out.println("*********************");
    	int id=houseService.findMaxHouseID()+1;
    	
    	house.set_house_id(id);
    	house.set_user_id(user_id);
    	house.set_city_name(city_name);
    	house.set_community_name(community_name);
    	house.set_house_num(house_num);
    	house.set_house_type(house_type);
    	house.set_house_area(house_area);
    	house.set_house_floor(house_floor);
    	house.set_is_elevator(is_elevator);
    	house.set_description(description);
    	//house.set_photo(photo);
    	house.set_deposit(deposit);
    	house.set_payment_method(payment_method);
    	house.set_rent_per_month(rent_per_month);
    	house.set_register_time(register_time);
    	house.set_state(state);
    	
    	
    	
    	//System.out.println(id);
    	int flag=houseService.addHouse(house);
    	if(flag==1) {
    		System.out.println("�����ɹ������ݱ�ʶΪ��"+id);
    		return id;
    	}
    	else return 0;
    }
    
    /**
     * ͨ������������ݣ�δѡ����-1�����������ơ��������ơ�����¥�źš��������͡���С���������������������¥�㡢�Ƿ��е��ݡ�������֧����ʽ������������������״̬
     * @RequestMapping SelectHouse
     * @param String city_name,String community_name,String house_num,int house_type,float house_area,int house_floor,int is_elevator,String description,int payment_method,float low_rent_per_month,float high_rent_per_month,int state
     * @return null ��ѯ���Ϊ��
     * @return List<House> ��ѯ�ɹ�
     */
    @RequestMapping("SelectHouse")
    @ResponseBody
    public List<House> SelectHouse(String city_name,String community_name,String house_num,int house_type,float min_house_area,float max_house_area,int house_floor,int is_elevator,String description,int payment_method,float low_rent_per_month,float high_rent_per_month,int state) {
    	System.out.println("*********************");
    	List<House> allhouse=houseService.SelectHouse(city_name, community_name, house_num, house_type, min_house_area,max_house_area, house_floor, is_elevator, description,payment_method,low_rent_per_month,high_rent_per_month,state);
    	return allhouse;
    }
    
    /**
     * ͨ������������ݣ�δѡ����-1�����������ơ��������ơ�����¥�źš��������͡���С���������������������¥�㡢�Ƿ��е��ݡ�������֧����ʽ������������������״̬
     * @RequestMapping SelectHouse
     * @param String city_name,String community_name,String house_num,int house_type,float house_area,int house_floor,int is_elevator,String description,int payment_method,float low_rent_per_month,float high_rent_per_month,int state
     * @return null ��ѯ���Ϊ��
     * @return List<House> ��ѯ�ɹ�
     */
    @RequestMapping("SelectHouse2")
    @ResponseBody
    public List<House> SelectHouse2(String city_name,String community_name,String house_num,int house_type,float min_house_area,float max_house_area,int house_floor,int is_elevator,String description,int payment_method,float low_rent_per_month,float high_rent_per_month,int state) {
    	System.out.println("*********************");
    	List<House> allhouse=houseService.SelectHouse2(city_name, community_name, house_num, house_type, min_house_area,max_house_area, house_floor, is_elevator, description,payment_method,low_rent_per_month,high_rent_per_month,state);
    	return allhouse;
    }
    
    /**
     * ��ѯ�Լ����������з�����Ϣ
     * @RequestMapping SelectHouseByUserId
     * @param int user_id
     * @return null δ��������
     * @return List<House> ����������Ϣ
     */
    @RequestMapping("SelectHouseByUserId")
    @ResponseBody
    public List<House> SelectHouseByUserId(int user_id) {
    	System.out.println("*********************");
    	List<House> allhouse=houseService.SelectHouseByUserId(user_id);
    	return allhouse;
    	
    }
    
    
   
    @RequestMapping("SelectHouseByHouseId")
    @ResponseBody
    public House SelectHouseByHouseId(int house_id) {
    	System.out.println("*********************");
    	House house=houseService.SelectHouseByHouseId(house_id);
    	return house;
    }
    
    /**
     * ���·�����Ϣ
     * @RequestMapping UpdateHouse
     * @param int house_id,String city_name,String community_name,String house_num,int house_type,float house_area,int house_floor,int is_elevator,String description,String photo,float deposit,int payment_method,float rent_per_month,int state
     * @return 0 ����ʧ��
     * @return id ע��ɹ���������û���ʶid
     */
    @RequestMapping("UpdateHouse")
    @ResponseBody
    public String UpdateHouse(int house_id,String city_name,String community_name,String house_num,int house_type,float house_area,int house_floor,int is_elevator,String description,float deposit,int payment_method,float rent_per_month,int state){
    	System.out.println("*********************");
    	int flag=houseService.UpdateHouse(house_id,city_name,community_name,house_num,house_type,house_area,house_floor,is_elevator,description,deposit,payment_method,rent_per_month,state);
    	if(flag==1 ) {
    		//System.out.println("1111");
    		House house=houseService.SelectHouseByHouseId(house_id);
    		String update_time=house.get_modify_time();
    		return update_time;
    	}
    	return null;
    }
    
    /**
     * ɾ������
     * @RequestMapping DeleteHouse
     * @param int house_id
     * @return 0 ɾ��ʧ��
     * @return 1 ɾ���ɹ�
     */
    @RequestMapping("DeleteHouse")
    @ResponseBody
    public int DeleteHouse(int house_id){
    	System.out.println("*********************");
    	int flag=houseService.DeleteHouse(house_id);
    	return flag;
    }
    
    /**
     * �ϴ�һ��ͼƬ
     * @param image
     * @param product
     * @param map
     * @return ����house_id
     * @throws IOException
     */
    @RequestMapping("/upload")
    @ResponseBody
    public String fileUpload(MultipartFile file,int house_id) throws IOException {

        /**
         * �ϴ�ͼƬ
         */
        //ͼƬ�ϴ��ɹ��󣬽�ͼƬ�ĵ�ַд�����ݿ�
        String filePath = "E:/image";//����ͼƬ��·��
        //��ȡԭʼͼƬ����չ��
        String originalFilename = file.getOriginalFilename();
        //�µ��ļ�����
        //String newFileName = '['+house_id+']'+originalFilename+UUID.randomUUID();
        String newFileName = UUID.randomUUID()+"_"+originalFilename;
        //��װ�ϴ��ļ�λ�õ�ȫ·��
        File targetFile = new File(filePath,newFileName);
        //�ѱ����ļ��ϴ�����װ�ϴ��ļ�λ�õ�ȫ·��
        file.transferTo(targetFile);
        newFileName="//localhost:8080/image/"+newFileName;
        int flag=houseService.addPhoto(house_id,newFileName);
        return newFileName; 
        
     
    }
    
    /**
     * ����ͼƬ
     * @param image
     * @param product
     * @param map
     * @return house_id�������ϴ�ͼƬ�ĵ�ַ

     */
    @RequestMapping("/download")
    @ResponseBody
    public List<Photo> fileDownload(int house_id) {

       
        List<Photo> allphoto=houseService.selectPhoto(house_id);
        return allphoto; 
    }
    
    /**
     * ɾ��
     * @param image
     * @param product
     * @param map
     * @return house_id�������ϴ�ͼƬ�ĵ�ַ

     */
    @RequestMapping("/DeletePhoto")
    @ResponseBody
    public int DeletePhoto(String photo) {

    	System.out.println("*********************");
        int flag=houseService.DeletePhoto(photo);
        return flag; 
    }

}
