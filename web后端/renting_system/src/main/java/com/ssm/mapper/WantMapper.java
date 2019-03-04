package com.ssm.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.model.Want;


public interface WantMapper {

	int findMaxWantID();

	int AddWant(Want want);

	List<Want> SelectWantByUserId(int user_id);

	List<Want> SelectWantByLandlordUserId(int user_id);

	List<Want> SelectWantByTenantUserId(int user_id);

	int Want2Agree(int want_id);

	Want SelectWantByWantId(int want_id);

	int UpdateWant(@Param("want_id")int want_id, @Param("start_month")String start_month,@Param("continual_month") int continual_month, @Param("description")String description);

	int DeleteWant(int want_id);

	int CheckWantNum(int user_id);

	int CheckAgreeNum(int user_id);

	int CheckDealNum(int user_id);

	int SetWantState(int user_id);

}
