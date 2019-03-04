package com.ssm.service;

import java.util.List;

import com.ssm.model.AreaIncome;
import com.ssm.model.MonthIncome;
import com.ssm.model.Pay;
import com.ssm.model.Transaction;

public interface TransactionService {

	int Agree2Deal(int want_id);

	int AddTransaction(Transaction transaction);

	int AddTotalFee(int user_id, float agency_fee);

	float FindTotalFee(int user_id);
	
	int SetLevel(int user_id, int level);

	List<Transaction> AllTransactionInfo();

	List<Transaction> FindTransactionByLandlordUserId(int user_id);

	List<Transaction> FindTransactionByTenantUserId(int user_id);

	List<Transaction> SelectTransaction(String city_name, String low_start_time, String high_start_time,
			String low_terminate_time, String high_terminate_time, float low_agency_fee, float high_agency_fee);

	int findMaxTransactionID();

	int AddPay(Pay pay);

	int findMaxPayID();

	List<Pay> FindPayByUserID(int user_id);

	int FinshPay(int pay_id);

	int UpdateAreaIncome(String area, float fee);

	int UpdateMonthIncome(String year, int month, float fee);

	List<MonthIncome> AllMonthIncomeInfo(String year);

	List<AreaIncome> AllAreaIncomeInfo();

	int CheckPayNum(int user_id);
	

}
