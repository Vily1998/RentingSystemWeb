package com.ssm.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.mapper.HouseMapper;
import com.ssm.mapper.RentMapper;
import com.ssm.model.House;
import com.ssm.model.Message;
import com.ssm.model.Rent;
import com.ssm.service.HouseService;
import com.ssm.service.RentService;
import com.ssm.service.UserService;

@Service
public class RentServiceImpl implements RentService{
	
	/**
     * ×¢ÈëHouseMapper½Ó¿Ú
     */
    @Autowired
    private RentMapper rentMapper;
    
    @Override
    public int findMaxRentID(){
    	return rentMapper.findMaxRentID();
    }
    
    

	@Override
	public int addRent(Rent rent) {
		// TODO Auto-generated method stub
		return rentMapper.addRent(rent);
	}
	
	
	@Override
	public List<Rent> SelectRentByUserId(int user_id) {
		return rentMapper.SelectRentByUserId(user_id);
	}

	
	@Override
	public List<Rent> SelectRent(String city_name, String community_name, int house_type, int house_floor, int is_elevator,
			String description, int payment_method, float low_rent_per_month, float high_rent_per_month) {
		return rentMapper.SelectRent(city_name, community_name, house_type,house_floor, is_elevator, description,payment_method,low_rent_per_month,high_rent_per_month);
	}
	
	
	@Override
	public int UpdateRent(int rent_id, String city_name, String community_name, int house_type, int house_floor,
			int is_elevator, String description, float deposit, int payment_method, float rent_per_month) {
    	return rentMapper.UpdateRent(rent_id,city_name,community_name,house_type,house_floor,is_elevator,description,deposit,payment_method,rent_per_month);
	}
	
	@Override
	public int DeleteRent(int rent_id) {
		return rentMapper.DeleteRent(rent_id);
	}
	
	@Override
	public Rent SelectRentByRentId(int rent_id) {
		return rentMapper.SelectRentByRentId(rent_id);
	}
	
	@Override
	public int findMaxMessageID() {
		return rentMapper.findMaxMessageID();
	}
	
	@Override
	public int AddMessaage(Message message) {
		return rentMapper.AddMessaage(message);
	}
	
	@Override
	public int CheckMessageNum(int user_id) {
		return rentMapper.CheckMessageNum(user_id);
	}
	
	
	@Override
	public int SetMessageState(int user_id) {
		return rentMapper.SetMessageState(user_id);
	}
	
	
	@Override
	public List<Message> FindMessageByUserId(int user_id) {
		return rentMapper.FindMessageByUserId(user_id);
	}
}
