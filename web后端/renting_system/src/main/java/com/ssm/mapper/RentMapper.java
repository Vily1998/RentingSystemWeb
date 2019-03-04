package com.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.model.Message;
import com.ssm.model.Rent;

public interface RentMapper {

	int findMaxRentID();

	int addRent(Rent rent);

	List<Rent> SelectRentByUserId(int user_id);

	List<Rent> SelectRent(@Param("city_name")String city_name, @Param("community_name")String community_name, 
			@Param("house_type")int house_type, @Param("house_floor")int house_floor, @Param("is_elevator")int is_elevator,
			@Param("description")String description, @Param("payment_method")int payment_method, 
			@Param("low_rent_per_month")float low_rent_per_month, @Param("high_rent_per_month")float high_rent_per_month);

	int UpdateRent(@Param("rent_id")int rent_id, @Param("city_name")String city_name, 
			@Param("community_name")String community_name,@Param("house_type")int house_type, 
			@Param("house_floor")int house_floor,@Param("is_elevator") int is_elevator, 
			@Param("description")String description, @Param("deposit")float deposit,@Param("payment_method")int payment_method, 
			@Param("rent_per_month")float rent_per_month);

	int DeleteRent(int rent_id);

	Rent SelectRentByRentId(int rent_id);

	int findMaxMessageID();

	int AddMessaage(Message message);

	int CheckMessageNum(int user_id);

	int SetMessageState(int user_id);

	List<Message> FindMessageByUserId(int user_id);

}
