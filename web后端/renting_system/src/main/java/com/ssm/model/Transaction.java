package com.ssm.model;

public class Transaction {
	
	//主键 用户标识
	private int transaction_id;
	
	private int house_id;
    
    private int landlord_user_id;
    
    private int tenant_user_id;
    
    private String transaction_date;
    
    private String start_month;
    
    private String terminate_month;
    
    private float deposit;
     
    private int payment_method;
    
    private float rent_per_month;
    
    private float total_rent;
    
    private float landord_agency_fee;
    
    private float tenant_agency_fee;


    

    public Transaction() {
        super();
    }

    public Transaction(int transaction_id,int house_id, int landlord_user_id, int tenant_user_id, String transaction_date, String start_month,String terminate_month, 
    		float deposit,int payment_method,float rent_per_month,float total_rent,float landord_agency_fee,float tenant_agency_fee) {
    	
        super();
        
        
        this.transaction_id = transaction_id;
        this.house_id = house_id;
        this.landlord_user_id = landlord_user_id;
        this.tenant_user_id = tenant_user_id;
        this.transaction_date = transaction_date;
        this.start_month = start_month;
        this.terminate_month = terminate_month;
        this.deposit = deposit;
        this.payment_method = payment_method;
        this.rent_per_month = rent_per_month;
        this.total_rent = total_rent;
        this.landord_agency_fee = landord_agency_fee;
        this.tenant_agency_fee = tenant_agency_fee;
    }



    public int get_transaction_id() {
        return transaction_id;
    }

    public void set_transaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }
    
    
    
    public int get_house_id() {
        return house_id;
    }

    public void set_house_id(int house_id) {
        this.house_id = house_id;
    }
    

    public int get_landlord_user_id() {
        return landlord_user_id;
    }

    public void set_landlord_user_id(int landlord_user_id) {
        this.landlord_user_id = landlord_user_id;
    }
    
    
   
    
    public int get_tenant_user_id() {
        return tenant_user_id;
    }

    public void set_tenant_user_id(int tenant_user_id) {
        this.tenant_user_id = tenant_user_id;
    }

    
    public String get_transaction_date() {
        return transaction_date;
    }

    public void set_transaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }


    
    
    public String get_start_month() {
        return start_month;
    }

    public void set_start_month(String start_month) {
        this.start_month = start_month;
    }
    
    
    public String get_terminate_month() {
        return terminate_month;
    }

    public void set_terminate_month(String terminate_month) {
        this.terminate_month = terminate_month;
    }
    
    
    public float get_deposit() {
        return deposit;
    }

    public void set_deposit(float deposit) {
        this.deposit = deposit;
    }
    
    public int get_payment_method() {
        return payment_method;
    }

    public void set_payment_method(int payment_method) {
        this.payment_method = payment_method;
    }
    
    
    public float get_rent_per_month() {
        return rent_per_month;
    }

    public void set_rent_per_month(float rent_per_month) {
        this.rent_per_month = rent_per_month;
    }
    
    
    public float get_total_rent() {
        return total_rent;
    }

    public void set_total_rent(float total_rent) {
        this.total_rent = total_rent;
    }
    
    public float get_landord_agency_fee() {
        return landord_agency_fee;
    }

    public void set_landord_agency_fee(float landord_agency_fee) {
        this.landord_agency_fee = landord_agency_fee;
    }
    
    public float get_tenant_agency_fee() {
        return tenant_agency_fee;
    }

    public void set_tenant_agency_fee(float tenant_agency_fee) {
        this.tenant_agency_fee = tenant_agency_fee;
    }

}
