package com.ssm.service;

import java.util.List;

import com.ssm.model.House;
import com.ssm.model.Message;
import com.ssm.model.Rent;

public interface RentService {

	int findMaxRentID();

	int addRent(Rent rent);

	List<Rent> SelectRentByUserId(int user_id);

	List<Rent> SelectRent(String city_name, String community_name, int house_type, int house_floor, int is_elevator,
			String description, int payment_method, float low_rent_per_month, float high_rent_per_month);

	int UpdateRent(int rent_id, String city_name, String community_name, int house_type, int house_floor,
			int is_elevator, String description, float deposit, int payment_method, float rent_per_month);

	int DeleteRent(int rent_id);

	Rent SelectRentByRentId(int rent_id);

	int findMaxMessageID();

	int AddMessaage(Message message);

	int CheckMessageNum(int user_id);

	int SetMessageState(int user_id);

	List<Message> FindMessageByUserId(int user_id);

}
