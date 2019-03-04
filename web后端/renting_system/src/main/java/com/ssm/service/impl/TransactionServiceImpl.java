package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.mapper.TransactionMapper;
import com.ssm.mapper.WantMapper;
import com.ssm.model.AreaIncome;
import com.ssm.model.MonthIncome;
import com.ssm.model.Pay;
import com.ssm.model.Transaction;
import com.ssm.service.TransactionService;
import com.ssm.service.WantService;

@Service

public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
    private TransactionMapper transactionMapper;

	@Override
	public int Agree2Deal(int want_id) {
		return transactionMapper.Agree2Deal(want_id);
	}
	
	@Override
	public int AddTransaction(Transaction transaction) {
		return transactionMapper.AddTransaction(transaction);
	}
	
	
	@Override
	public int AddTotalFee(int user_id, float agency_fee) {
		return transactionMapper.AddTotalFee(user_id,agency_fee);
	}
	
	@Override
	public float FindTotalFee(int user_id) {
		return transactionMapper.FindTotalFee(user_id);
	}
	
	
	@Override
	public int SetLevel(int user_id, int level) {
		return transactionMapper.SetLevel(user_id,level);
	}
	
	@Override
	public List<Transaction> AllTransactionInfo() {
		return transactionMapper.AllTransactionInfo();
	}
	
	@Override
	public List<Transaction> FindTransactionByLandlordUserId(int user_id) {
		return transactionMapper.FindTransactionByLandlordUserId(user_id);
	}
	
	
	@Override
	public List<Transaction> FindTransactionByTenantUserId(int user_id) {
		return transactionMapper.FindTransactionByTenantUserId(user_id);
	}
	
	@Override
	public List<Transaction> SelectTransaction(String city_name, String low_start_time, String high_start_time,
			String low_terminate_time, String high_terminate_time, float low_agency_fee, float high_agency_fee) {
		return transactionMapper.SelectTransaction(city_name,low_start_time,high_start_time,low_terminate_time, high_terminate_time,low_agency_fee,high_agency_fee) ;
	}
	
	@Override
	public int findMaxTransactionID() {
		return transactionMapper.findMaxTransactionID();
	}
	
	@Override
	public int AddPay(Pay pay) {
		return transactionMapper.AddPay(pay);
	}
	
	
	
	@Override
	public int findMaxPayID() {
		return transactionMapper.findMaxPayID();
	}
	
	
	@Override
	public List<Pay> FindPayByUserID(int user_id) {
		return transactionMapper.FindPayByUserID(user_id);
	}
	
	
	@Override
	public int FinshPay(int pay_id) {
		return transactionMapper.FinshPay(pay_id);
	}
	
	@Override
	public int UpdateAreaIncome(String area, float fee) {
		return transactionMapper.UpdateAreaIncome( area, fee);
	}
	
	
	@Override
	public int UpdateMonthIncome(String year, int month, float fee) {
		return transactionMapper.UpdateMonthIncome(year,month,fee);
	}
	
	@Override
	public List<MonthIncome> AllMonthIncomeInfo(String year) {
		return transactionMapper.AllMonthIncomeInfo(year);
	}
	
	
	@Override
	public List<AreaIncome> AllAreaIncomeInfo() {
		return transactionMapper.AllAreaIncomeInfo();
	}
	
	@Override
	public int CheckPayNum(int user_id) {
		return transactionMapper.CheckPayNum( user_id);
	}
}
