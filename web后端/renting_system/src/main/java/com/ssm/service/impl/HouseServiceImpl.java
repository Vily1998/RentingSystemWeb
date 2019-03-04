package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.mapper.HouseMapper;
import com.ssm.model.House;
import com.ssm.model.Photo;
import com.ssm.service.HouseService;
import com.ssm.service.UserService;

@Service
public class HouseServiceImpl implements HouseService {
	
	/**
     * ×¢ÈëHouseMapper½Ó¿Ú
     */
    @Autowired
    private HouseMapper houseMapper;
    
    @Override
    public int findMaxHouseID() {
    	return houseMapper.findMaxHouseID();
    }
    
    @Override
    public int addHouse(House house) {
    	return houseMapper.addHouse(house);
    }
    
    @Override
    public List<House> SelectHouse(String city_name,String community_name,String house_num,int house_type,float min_house_area,float max_house_area,int house_floor,int is_elevator,String description,int payment_method,float low_rent_per_month,float high_rent_per_month,int state) {
    	return houseMapper.SelectHouse(city_name, community_name, house_num, house_type, min_house_area,max_house_area, house_floor, is_elevator, description,payment_method,low_rent_per_month,high_rent_per_month,state);
    }
    
    @Override
    public List<House> SelectHouse2(String city_name,String community_name,String house_num,int house_type,float min_house_area,float max_house_area,int house_floor,int is_elevator,String description,int payment_method,float low_rent_per_month,float high_rent_per_month,int state) {
    	return houseMapper.SelectHouse(city_name, community_name, house_num, house_type, min_house_area,max_house_area, house_floor, is_elevator, description,payment_method,low_rent_per_month,high_rent_per_month,state);
    }
    
    @Override
    public List<House> SelectHouseByUserId(int user_id) {
    	return houseMapper.SelectHouseByUserId(user_id);
    }
    
    @Override
    public int UpdateHouse(int house_id, String city_name, String community_name, String house_num, int house_type,
			float house_area, int house_floor, int is_elevator, String description, float deposit,
			int payment_method, float rent_per_month, int state) {
    	return houseMapper.UpdateHouse(house_id,city_name,community_name,house_num,house_type,house_area,house_floor,is_elevator,description,deposit,payment_method,rent_per_month,state);
    }
    
    @Override
    public int DeleteHouse(int house_id) {
    	return houseMapper.DeleteHouse(house_id);
    }
    
    @Override
	public int addPhoto(int house_id, String newFileName) {
    	return houseMapper.addPhoto(house_id,newFileName);
    }
    
    @Override
    public List<Photo> selectPhoto(int house_id) {
    	return houseMapper.selectPhoto(house_id);
    }
    
    @Override
    public int DeletePhoto(String photo) {
    	return houseMapper.DeletePhoto(photo);
    }
    
    @Override
    public House SelectHouseByHouseId(int house_id) {
    	return houseMapper.SelectHouseByHouseId(house_id);
    }
    
    @Override
    public int UpdateHouseState(int house_id) {
    	return houseMapper.UpdateHouseState(house_id);
    }

}
