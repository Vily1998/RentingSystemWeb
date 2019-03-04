package com.ssm.model;

public class Pay {

	
	
	//主键 用户标识
	
	    private int pay_id;
		
	    private int transaction_id;
		
		private int house_id;
	    
	    private int landlord_user_id;
	    
	    private int tenant_user_id;
	    
	   
	    private int payment_method;
	    
	    private String pay_date;
	    
	    private float rent;
	    
	    private int is_pay;

	    

	    public Pay() {
	        super();
	    }

	    public Pay(int pay_id,int transaction_id,int house_id, int landlord_user_id, int tenant_user_id, int payment_method,
	    		String pay_date, float rent,int is_pay) {
	    	
	        super();
	        
	        this.pay_id = pay_id;
	        this.transaction_id = transaction_id;
	        this.house_id = house_id;
	        this.landlord_user_id = landlord_user_id;
	        this.tenant_user_id = tenant_user_id;
	        this.payment_method = payment_method;
	        this.pay_date = pay_date;
	        this.rent = rent;
	        this.is_pay = is_pay;
	        
	    }


	    public int get_pay_id() {
	        return pay_id;
	    }

	    public void set_pay_id(int pay_id) {
	        this.pay_id = pay_id;
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

	    
	    public String get_pay_date() {
	        return pay_date;
	    }

	    public void set_pay_date(String pay_date) {
	        this.pay_date = pay_date;
	    }


	    
	    
	  
	    
	    
	    
	    public int get_payment_method() {
	        return payment_method;
	    }

	    public void set_payment_method(int payment_method) {
	        this.payment_method = payment_method;
	    }
	    
	    
	    public float get_rent() {
	        return rent;
	    }

	    public void set_rent(float rent) {
	        this.rent = rent;
	    }
	    
	    public int get_is_pay() {
	        return is_pay;
	    }

	    public void set_is_pay(int is_pay) {
	        this.is_pay = is_pay;
	    }
	    
	
}
