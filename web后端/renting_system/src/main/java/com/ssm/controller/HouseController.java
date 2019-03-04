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
     * 发布房屋：城市名称为：省+市
     * @RequestMapping AddHouse
     * @param int user_id,String city_name,String community_name,String house_num,int house_type,float house_area,int house_floor,int is_elevator,String description,String photo,float deposit,int payment_method,float rent_per_month,String register_time,String modify_time,int state
     * @return 0 注册失败
     * @return id 发布成功，并获得房屋标识id
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
    		System.out.println("发布成功，房屋标识为："+id);
    		return id;
    	}
    	else return 0;
    }
    
    /**
     * 通过相关条件房屋（未选择发送-1）：城市名称、社区名称、具体楼门号、房屋类型、最小房屋面积、最大房屋面积所在楼层、是否有电梯、描述、支付方式、最低月租金、最高月租金、状态
     * @RequestMapping SelectHouse
     * @param String city_name,String community_name,String house_num,int house_type,float house_area,int house_floor,int is_elevator,String description,int payment_method,float low_rent_per_month,float high_rent_per_month,int state
     * @return null 查询结果为空
     * @return List<House> 查询成功
     */
    @RequestMapping("SelectHouse")
    @ResponseBody
    public List<House> SelectHouse(String city_name,String community_name,String house_num,int house_type,float min_house_area,float max_house_area,int house_floor,int is_elevator,String description,int payment_method,float low_rent_per_month,float high_rent_per_month,int state) {
    	System.out.println("*********************");
    	List<House> allhouse=houseService.SelectHouse(city_name, community_name, house_num, house_type, min_house_area,max_house_area, house_floor, is_elevator, description,payment_method,low_rent_per_month,high_rent_per_month,state);
    	return allhouse;
    }
    
    /**
     * 通过相关条件房屋（未选择发送-1）：城市名称、社区名称、具体楼门号、房屋类型、最小房屋面积、最大房屋面积所在楼层、是否有电梯、描述、支付方式、最低月租金、最高月租金、状态
     * @RequestMapping SelectHouse
     * @param String city_name,String community_name,String house_num,int house_type,float house_area,int house_floor,int is_elevator,String description,int payment_method,float low_rent_per_month,float high_rent_per_month,int state
     * @return null 查询结果为空
     * @return List<House> 查询成功
     */
    @RequestMapping("SelectHouse2")
    @ResponseBody
    public List<House> SelectHouse2(String city_name,String community_name,String house_num,int house_type,float min_house_area,float max_house_area,int house_floor,int is_elevator,String description,int payment_method,float low_rent_per_month,float high_rent_per_month,int state) {
    	System.out.println("*********************");
    	List<House> allhouse=houseService.SelectHouse2(city_name, community_name, house_num, house_type, min_house_area,max_house_area, house_floor, is_elevator, description,payment_method,low_rent_per_month,high_rent_per_month,state);
    	return allhouse;
    }
    
    /**
     * 查询自己发布的所有房屋信息
     * @RequestMapping SelectHouseByUserId
     * @param int user_id
     * @return null 未发布房屋
     * @return List<House> 发布房屋信息
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
     * 更新房屋信息
     * @RequestMapping UpdateHouse
     * @param int house_id,String city_name,String community_name,String house_num,int house_type,float house_area,int house_floor,int is_elevator,String description,String photo,float deposit,int payment_method,float rent_per_month,int state
     * @return 0 更新失败
     * @return id 注册成功，并获得用户标识id
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
     * 删除房屋
     * @RequestMapping DeleteHouse
     * @param int house_id
     * @return 0 删除失败
     * @return 1 删除成功
     */
    @RequestMapping("DeleteHouse")
    @ResponseBody
    public int DeleteHouse(int house_id){
    	System.out.println("*********************");
    	int flag=houseService.DeleteHouse(house_id);
    	return flag;
    }
    
    /**
     * 上传一张图片
     * @param image
     * @param product
     * @param map
     * @return 返回house_id
     * @throws IOException
     */
    @RequestMapping("/upload")
    @ResponseBody
    public String fileUpload(MultipartFile file,int house_id) throws IOException {

        /**
         * 上传图片
         */
        //图片上传成功后，将图片的地址写到数据库
        String filePath = "E:/image";//保存图片的路径
        //获取原始图片的拓展名
        String originalFilename = file.getOriginalFilename();
        //新的文件名字
        //String newFileName = '['+house_id+']'+originalFilename+UUID.randomUUID();
        String newFileName = UUID.randomUUID()+"_"+originalFilename;
        //封装上传文件位置的全路径
        File targetFile = new File(filePath,newFileName);
        //把本地文件上传到封装上传文件位置的全路径
        file.transferTo(targetFile);
        newFileName="//localhost:8080/image/"+newFileName;
        int flag=houseService.addPhoto(house_id,newFileName);
        return newFileName; 
        
     
    }
    
    /**
     * 下载图片
     * @param image
     * @param product
     * @param map
     * @return house_id的所有上传图片的地址

     */
    @RequestMapping("/download")
    @ResponseBody
    public List<Photo> fileDownload(int house_id) {

       
        List<Photo> allphoto=houseService.selectPhoto(house_id);
        return allphoto; 
    }
    
    /**
     * 删除
     * @param image
     * @param product
     * @param map
     * @return house_id的所有上传图片的地址

     */
    @RequestMapping("/DeletePhoto")
    @ResponseBody
    public int DeletePhoto(String photo) {

    	System.out.println("*********************");
        int flag=houseService.DeletePhoto(photo);
        return flag; 
    }

}
