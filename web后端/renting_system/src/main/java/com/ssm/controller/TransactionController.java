package com.ssm.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.model.AreaIncome;
import com.ssm.model.House;
import com.ssm.model.MonthIncome;
import com.ssm.model.Pay;
import com.ssm.model.Transaction;
import com.ssm.model.User;
import com.ssm.model.Want;
import com.ssm.service.HouseService;
import com.ssm.service.TransactionService;
import com.ssm.service.UserService;
import com.ssm.service.WantService;

import sun.util.calendar.LocalGregorianCalendar.Date;

@Controller
@RequestMapping("/transaction")

public class TransactionController {
	
	@Autowired
    private WantService wantService;  
	@Autowired
	private HouseService houseService;  
	@Autowired
	private UserService userService;  
	
	
	@Autowired
	private TransactionService transactionService;
    
	/**
     * 第三次握手 付款
     * @RequestMapping Agree2Deal
     * @param int want_id
     * @return 0 交易失败
     * @return transaction_id 交易成功
     */
    @RequestMapping("Agree2Deal")
    @ResponseBody
    public int Agree2Deal(int want_id) {
    	System.out.println("*********************");
    	int transaction_id=transactionService.findMaxTransactionID()+1;
    	System.out.println(transaction_id);
    	int flag_1=transactionService.Agree2Deal(want_id);
    	System.out.println("1*********************");
    	Want want=wantService.SelectWantByWantId(want_id);
    	Transaction transaction = new Transaction();
    	System.out.println("2*********************");
    	int house_id=want.get_house_id();
    	House house=houseService.SelectHouseByHouseId(house_id);
    	
    	String area=house.get_city_name();
    	
    	
    			
    			

    	
    	int landlord_user_id=want.get_landlord_user_id();
    	
    	int tenant_user_id=want.get_tenant_user_id();
    	
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
	    String transaction_date=df.format(System.currentTimeMillis());   
	    
	    String start_month=want.get_start_month();
	    int continual_month=want.get_continual_month();
	    int s_year = Integer.parseInt(start_month.substring(0,4));
	    int s_month = Integer.parseInt(start_month.substring(5,7));
	    int s_day = Integer.parseInt(start_month.substring(8,10));
	    int year=s_year+continual_month/12;
	    int month=s_month+continual_month%12;
	    if(month>12) {
	    	month=month%12;
	    	year++;
	    }
	    String terminate_month=String.valueOf(year)+'-'+String.valueOf(month)+'-'+String.valueOf(s_day);
	    
	    float deposit=house.get_deposit();
	    
	    int payment_method=house.get_payment_method();
	    
	    float rent_per_month=house.get_rent_per_month();
	    
	    float total_rent=continual_month*rent_per_month;
	    
	    System.out.println("3*********************");
	    int landlord_user_level=userService.findLevelByUserID(landlord_user_id);
	    int tenant_user_level=userService.findLevelByUserID(tenant_user_id);
	    
	    float landord_agency_fee,tenant_agency_fee;
	    
	    if(landlord_user_level==0) landord_agency_fee=(float) (total_rent*0.1);
	    else if(landlord_user_level==1) landord_agency_fee=(float) (total_rent*0.05);
	    else landord_agency_fee=(float) (total_rent*0.01);
	    
	    if(tenant_user_level==0) tenant_agency_fee=(float) (total_rent*0.1);
	    else if(tenant_user_level==1) tenant_agency_fee=(float) (total_rent*0.05);
	    else tenant_agency_fee=(float) (total_rent*0.01);
	    
	    transaction.set_transaction_id(transaction_id);
	    transaction.set_house_id(house_id);
	    transaction.set_landlord_user_id(landlord_user_id);
	    transaction.set_tenant_user_id(tenant_user_id);
	    transaction.set_transaction_date(transaction_date);
	    transaction.set_start_month(start_month);
	    transaction.set_terminate_month(terminate_month);
	    transaction.set_deposit(deposit);
	    
		transaction.set_payment_method(payment_method);
	    transaction.set_rent_per_month(rent_per_month);
	    transaction.set_total_rent(total_rent);
	    transaction.set_landord_agency_fee(landord_agency_fee);
	    transaction.set_tenant_agency_fee(tenant_agency_fee);
	    
	    
	    int flag_2=transactionService.AddTransaction(transaction);
	    
	    int a=transactionService.AddTotalFee(landlord_user_id,landord_agency_fee);
	    int b=transactionService.AddTotalFee(tenant_user_id,tenant_agency_fee);
	    int c;
	    float landlord_total_fee=transactionService.FindTotalFee(landlord_user_id);
	    float tenant_total_fee=transactionService.FindTotalFee(tenant_user_id);
	    
	    if(landlord_total_fee>200000&&landlord_user_level<2) {
	    	c=transactionService.SetLevel(landlord_user_id,2);
	    }
	    else if(landlord_total_fee>100000&&landlord_user_level<1){
	    	c=transactionService.SetLevel(landlord_user_id,1);
	    }
	    
	    if(tenant_total_fee>200000&&tenant_user_level<2) {
	    	c=transactionService.SetLevel(tenant_user_id,2);
	    }
	    else if(tenant_total_fee>100000&&tenant_user_level<1){
	    	c=transactionService.SetLevel(tenant_user_id,1);
	    }
	    
	    int flag_3;
	    Pay pay = new Pay();
	    pay.set_transaction_id(transaction_id);
	    pay.set_house_id(house_id);
	    pay.set_landlord_user_id(landlord_user_id);
	    pay.set_tenant_user_id(tenant_user_id);
	    pay.set_payment_method(payment_method);
	    pay.set_is_pay(0);
	    if(payment_method==1) {
	    	for(int i=0;i<continual_month;i++) {
	    		
	    		int c_year=s_year+i/12;
	    	    int c_month=s_month+i%12;
	    	    if(c_month>12) {
	    	    	c_month=c_month%12;
	    	    	c_year++;
	    	    }
	    	    String pay_date=String.valueOf(c_year)+'-'+String.valueOf(c_month)+'-'+String.valueOf(s_day);
	    		
	    	    pay.set_rent(rent_per_month);
	    		pay.set_pay_date(pay_date);
	    		int pay_id=transactionService.findMaxPayID()+1;
	    		pay.set_pay_id(pay_id);
	    		
	    		flag_3=transactionService.AddPay(pay);
	    	}
	    }
	    else if(payment_method==2) {
	    	for(int i=0;i<continual_month;i=i+3) {
	    		
	    		int c_year=s_year+i/12;
	    	    int c_month=s_month+i%12;
	    	    if(c_month>12) {
	    	    	c_month=c_month%12;
	    	    	c_year++;
	    	    }
	    	    String pay_date=String.valueOf(c_year)+'-'+String.valueOf(c_month)+'-'+String.valueOf(s_day);
	    		float c_rent=0;
	    	    if(continual_month-i>3)  c_rent=rent_per_month*3;
	    	    else c_rent=(continual_month-i)*rent_per_month;
	    	    pay.set_rent(c_rent);
	    		pay.set_pay_date(pay_date);
	    		int pay_id=transactionService.findMaxPayID()+1;
	    		pay.set_pay_id(pay_id);
	    		
	    		flag_3=transactionService.AddPay(pay);
	    	}
	    }
	    else if(payment_method==3) {
	    	for(int i=0;i<continual_month;i=i+12) {
	    		
	    		int c_year=s_year+i/12;
	    	    int c_month=s_month+i%12;
	    	    if(c_month>12) {
	    	    	c_month=c_month%12;
	    	    	c_year++;
	    	    }
	    	    String pay_date=String.valueOf(c_year)+'-'+String.valueOf(c_month)+'-'+String.valueOf(s_day);
	    	    float c_rent=0;
	    	    if(continual_month-i>12)  c_rent=rent_per_month*12;
	    	    else c_rent=(continual_month-i)*rent_per_month;
	    	    pay.set_rent(c_rent);
	    		pay.set_pay_date(pay_date);
	    		int pay_id=transactionService.findMaxPayID()+1;
	    		pay.set_pay_id(pay_id);
	    		
	    		flag_3=transactionService.AddPay(pay);
	    	}
	    }
	    
	    
	    int flag_4=transactionService.UpdateAreaIncome(area,landord_agency_fee+tenant_agency_fee);
	    int flag_5=transactionService.UpdateMonthIncome(start_month.substring(0,4),s_month,landord_agency_fee+tenant_agency_fee);
	    int flag_6=houseService.UpdateHouseState(house_id);
	    
	    
    	if(flag_1==1&&flag_2==1) {
    		System.out.println("交易成功,标识为"+transaction_id);
    		return transaction_id;
    	}
    	else return 0;		
    }
    
    /**
     * 显示全部交易信息
     * @RequestMapping AllTransactionInfo
     * @return Transaction 实体类
     */
    @RequestMapping("AllTransactionInfo")
    @ResponseBody
    public List<Transaction> AllTransactionInfo() {
    	//System.out.println("*********************");
    	List<Transaction> alltransaction=transactionService.AllTransactionInfo();
    	return alltransaction;
    }
    
    /**
     * 查询卖方成交记录
     * @RequestMapping FindTransactionByLandlordUserId
     * @return Transaction 实体类
     */
    @RequestMapping("FindTransactionByLandlordUserId")
    @ResponseBody
    public List<Transaction> FindTransactionByLandlordUserId(int user_id) {
    	//System.out.println("*********************");
    	List<Transaction> transaction=transactionService.FindTransactionByLandlordUserId(user_id);
    	return transaction;
    }
    
    /**
     * 查询买方成交记录
     * @RequestMapping FindTransactionByTenantUserId
     * @return Transaction 实体类
     */
    @RequestMapping("FindTransactionByTenantUserId")
    @ResponseBody
    public List<Transaction> FindTransactionByTenantUserId(int user_id) {
    	//System.out.println("*********************");
    	List<Transaction> transaction=transactionService.FindTransactionByTenantUserId(user_id);
    	return transaction;
    }
    
    
    /**
     * 条件查询成交记录
     * @RequestMapping SelectTransaction
     * @param String city_name,String low_start_time,String high_start_time,String low_terminate_time,String high_terminate_time,float low_agency_fee,float high_agency_fee
     * @return Transaction 实体类
     */
    @RequestMapping("SelectTransaction")
    @ResponseBody
    public List<Transaction> SelectTransaction(String city_name,String low_start_time,String high_start_time,String low_terminate_time,String high_terminate_time,float low_agency_fee,float high_agency_fee) {
    	//System.out.println("*********************");
    	List<Transaction> transaction=transactionService.SelectTransaction(city_name,low_start_time,high_start_time,low_terminate_time, high_terminate_time,low_agency_fee,high_agency_fee) ;
    	return transaction;
    }
    
    /**
     * 查询代付款
     * @RequestMapping FindPayByUserID
     * @param int user_id
     * @return Pay 实体类
     */
    @RequestMapping("FindPayByUserID")
    @ResponseBody
    public List<Pay> FindPayByUserID(int user_id) {
    	//System.out.println("*********************");
    	
    	List<Pay> allpay=transactionService.FindPayByUserID(user_id);
    	return allpay;
    }
    
    /**
     * 查询代付款数量
     * @RequestMapping FindPayByUserID
     * @param int user_id
     * @return Pay 实体类
     */
    @RequestMapping("CheckPayNum")
    @ResponseBody
    public int CheckPayNum(int user_id) {
    	//System.out.println("*********************");
    	
    	int allpay=transactionService.CheckPayNum(user_id);
    	return allpay;
    }
    
    
    /**
     * 付款
     * @RequestMapping FinshPay
     * @param int pay_id
     * @return 1 付款成功
     */
    @RequestMapping("FinshPay")
    @ResponseBody
    public int FinshPay(int pay_id) {
    	//System.out.println("*********************");
    	
    	int flag=transactionService.FinshPay(pay_id);
    	return flag;
    }
    
    
    /**
     * 显示一年中每月的统计信息
     * @RequestMapping AllTransactionInfo
     * * @param String year
     * @return MonthIncome 实体类
     */
    @RequestMapping("AllMonthIncomeInfo")
    @ResponseBody
    public List<MonthIncome> AllMonthIncomeInfo(String year) {
    	//System.out.println("*********************");
    	List<MonthIncome> allincome=transactionService.AllMonthIncomeInfo(year);
    	return allincome;
    }
    
    
    /**
     * 显示每个地区的统计信息
     * @RequestMapping AllAreaIncomeInfo
     * @return AreaIncome 实体类
     */
    @RequestMapping("AllAreaIncomeInfo")
    @ResponseBody
    public List<AreaIncome> AllAreaIncomeInfo() {
    	//System.out.println("*********************");
    	List<AreaIncome> allincome=transactionService.AllAreaIncomeInfo();
    	return allincome;
    }
    
    
    
    
    
    
    
    
    
    
    
    

}
