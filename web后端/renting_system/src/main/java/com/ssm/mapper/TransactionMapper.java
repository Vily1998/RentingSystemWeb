package com.ssm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssm.model.AreaIncome;
import com.ssm.model.MonthIncome;
import com.ssm.model.Pay;
import com.ssm.model.Transaction;

public interface TransactionMapper {

	int Agree2Deal(int want_id);

	int AddTransaction(Transaction transaction);

	int AddTotalFee(@Param("user_id")int user_id, @Param("agency_fee")float agency_fee);

	float FindTotalFee(int user_id);

	int SetLevel(@Param("user_id")int user_id, @Param("level")int level);

	List<Transaction> AllTransactionInfo();

	List<Transaction> FindTransactionByLandlordUserId(int user_id);

	List<Transaction> FindTransactionByTenantUserId(int user_id);

	List<Transaction> SelectTransaction(@Param("city_name")String city_name, @Param("low_start_time")String low_start_time, @Param("high_start_time")String high_start_time,
			@Param("low_terminate_time")String low_terminate_time, @Param("high_terminate_time")String high_terminate_time, @Param("low_agency_fee")float low_agency_fee,
			@Param("high_agency_fee")float high_agency_fee);

	int findMaxTransactionID();

	int AddPay(Pay pay);

	int findMaxPayID();

	List<Pay> FindPayByUserID(int user_id);

	int FinshPay(int pay_id);

	int UpdateAreaIncome(@Param("area")String area, @Param("fee")float fee);

	int UpdateMonthIncome(@Param("year")String year,@Param("month") int month, @Param("fee")float fee);

	List<MonthIncome> AllMonthIncomeInfo(String year);

	List<AreaIncome> AllAreaIncomeInfo();

	int CheckPayNum(int user_id);
	
	
	

}
