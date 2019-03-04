package com.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.model.House;
import com.ssm.model.Photo;

public interface HouseMapper {
	
	int findMaxHouseID();

	int addHouse(House house);
	
	List<House> SelectHouse(@Param("city_name")String city_name,@Param("community_name")String community_name,
			@Param("house_num")String house_num,@Param("house_type")int house_type,@Param("min_house_area")float min_house_area,
			@Param("max_house_area")float max_house_area, @Param("house_floor")int house_floor,
			@Param("is_elevator")int is_elevator,@Param("description")String description,
			@Param("payment_method")int payment_method,@Param("low_rent_per_month")float low_rent_per_month,
			@Param("high_rent_per_month")float high_rent_per_month, @Param("state")int state);

	List<House> SelectHouseByUserId(int user_id);

	int UpdateHouse(@Param("house_id")int house_id, @Param("city_name")String city_name, 
			@Param("community_name")String community_name, @Param("house_num")String house_num,
			@Param("house_type")int house_type,@Param("house_area")float house_area, 
			@Param("house_floor")int house_floor,@Param("is_elevator") int is_elevator, 
			@Param("description")String description, 
			@Param("deposit")float deposit,@Param("payment_method")int payment_method, 
			@Param("rent_per_month")float rent_per_month, @Param("state")int state);

	int DeleteHouse(int house_id);

	int addPhoto(@Param("house_id")int house_id, @Param("newFileName")String newFileName);

	List<Photo> selectPhoto(int house_id);

	int DeletePhoto(String photo);

	House SelectHouseByHouseId(int house_id);

	int UpdateHouseState(int house_id);
	
	

}
