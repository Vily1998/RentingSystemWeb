package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.mapper.UserMapper;
import com.ssm.mapper.WantMapper;
import com.ssm.model.User;
import com.ssm.model.Want;
import com.ssm.service.UserService;
import com.ssm.service.WantService;
@Service

public class WantServiceImpl implements WantService{
	
	@Autowired
    private WantMapper wantMapper;
	
	@Override
	public int findMaxWantID() {
		return wantMapper.findMaxWantID();
	}
	
	@Override
	public int AddWant(Want want) {
		return wantMapper.AddWant(want);
	}
	
	@Override
	public List<Want> SelectWantByLandlordUserId(int user_id){
		return wantMapper.SelectWantByLandlordUserId(user_id);
	}
	
	@Override
	public List<Want> SelectWantByTenantUserId(int user_id){
		return wantMapper.SelectWantByTenantUserId(user_id);
	}
	
	@Override
	public Want SelectWantByWantId(int want_id) {
		return wantMapper.SelectWantByWantId(want_id);
	}
	
	@Override
	public int Want2Agree(int want_id) {
		return wantMapper.Want2Agree(want_id);
	}

	@Override
	public List<Want> SelectWantByUserId(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int UpdateWant(int want_id, String start_month, int continual_month, String description) {
		return wantMapper.UpdateWant(want_id,start_month, continual_month,description);
	}
	
	@Override
	public int DeleteWant(int want_id) {
    	return wantMapper.DeleteWant(want_id);
    }
	
	
	@Override
	public int CheckWantNum(int user_id) {
		return wantMapper.CheckWantNum(user_id);
	}
	
	@Override
	public int CheckAgreeNum(int user_id) {
		return wantMapper.CheckAgreeNum(user_id);
	}
	
	@Override
	public int CheckDealNum(int user_id) {
		return wantMapper.CheckDealNum(user_id);
	}
	
	@Override
	public int SetWantState(int user_id) {
		return wantMapper.SetWantState(user_id);
	}

}
