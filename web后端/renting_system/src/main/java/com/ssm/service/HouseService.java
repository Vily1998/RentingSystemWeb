package com.ssm.service;

import java.util.List;

import com.ssm.model.House;
import com.ssm.model.Photo;
import com.ssm.model.User;

public interface HouseService {
	
	int findMaxHouseID();
	
	int addHouse(House house);
	
	List<House> SelectHouse(String city_name,String community_name,String house_num,int house_type,
			float min_house_area,float max_house_area, int house_floor,int is_elevator,String description,
			int payment_method,float low_rent_per_month,float high_rent_per_month, int state);

	List<House> SelectHouseByUserId(int user_id);

	int UpdateHouse(int house_id, String city_name, String community_name, String house_num, int house_type,
			float house_area, int house_floor, int is_elevator, String description, float deposit,
			int payment_method, float rent_per_month, int state);

	int DeleteHouse(int house_id);

	int addPhoto(int house_id, String newFileName);

	List<Photo> selectPhoto(int house_id);

	int DeletePhoto(String photo);

	House SelectHouseByHouseId(int house_id);

	int UpdateHouseState(int house_id);

	List<House> SelectHouse2(String city_name, String community_name, String house_num, int house_type,
			float min_house_area, float max_house_area, int house_floor, int is_elevator, String description,
			int payment_method, float low_rent_per_month, float high_rent_per_month, int state);
	
	
}
