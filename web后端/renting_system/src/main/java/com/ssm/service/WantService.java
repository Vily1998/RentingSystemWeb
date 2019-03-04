package com.ssm.service;

import java.util.List;

import com.ssm.model.Want;

public interface WantService {

	int findMaxWantID();

	int AddWant(Want want);

	List<Want> SelectWantByUserId(int user_id);

	List<Want> SelectWantByLandlordUserId(int user_id);

	List<Want> SelectWantByTenantUserId(int user_id);

	int Want2Agree(int want_id);

	Want SelectWantByWantId(int want_id);

	int UpdateWant(int want_id,  String start_month, int continual_month, String description);

	int DeleteWant(int want_id);

	int CheckWantNum(int user_id);

	int CheckAgreeNum(int user_id);

	int CheckDealNum(int user_id);

	int SetWantState(int user_id);
	

}
