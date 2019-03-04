package com.ssm.model;

public class Rent {

	
	//Ö÷¼ü
    private int rent_id;
    
    private int user_id;
    
    private String city_name;
    
    private String community_name;
    
    private int house_type;
    
    private int house_floor;
    
    private int is_elevator;
    
    private String description;
    
    private float deposit;
    
    private int payment_method;
    
    private float rent_per_month;
    
    private String register_time;
    
    private String modify_time;
    
    
    public Rent() {
        super();
    }

    public Rent(int rent_id,int user_id,String city_name,String community_name,int house_type,int house_floor,int is_elevator,String description,float deposit,int payment_method,float rent_per_month,String register_time,String modify_time) {
    	
    	super();
    	
    	this.rent_id = rent_id;
        this.user_id = user_id;
        this.city_name = city_name;
        this.community_name = community_name;
        this.house_type = house_type;
        this.house_floor = house_floor;
        this.is_elevator = is_elevator;
        this.description = description;
        this.deposit = deposit;
        this.payment_method = payment_method;
        this.rent_per_month = rent_per_month;
        this.register_time = register_time;
        this.modify_time = modify_time;
        
        
    }
    
    public int get_rent_id() {
        return rent_id;
    }

    public void set_rent_id(int rent_id) {
        this.rent_id = rent_id;
    }
    
    public int get_user_id() {
        return user_id;
    }

    public void set_user_id(int user_id) {
        this.user_id = user_id;
    }

    public String get_city_name() {
        return city_name;
    }

    public void set_city_name(String city_name) {
        this.city_name = city_name;
    }
    
    public String get_community_name() {
        return community_name;
    }

    public void set_community_name(String community_name) {
        this.community_name = community_name;
    }
    
    
    public int get_house_type() {
        return house_type;
    }

    public void set_house_type(int house_type) {
        this.house_type = house_type;
    }
    
    
    public int get_house_floor() {
        return house_floor;
    }

    public void set_house_floor(int house_floor) {
        this.house_floor = house_floor;
    }
    
    public int get_is_elevator() {
        return is_elevator;
    }

    public void set_is_elevator(int is_elevator) {
        this.is_elevator = is_elevator;
    }
    
    public String get_description() {
        return description;
    }

    public void set_description(String description) {
        this.description = description;
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
    
    public String get_register_time() {
        return register_time;
    }

    public void set_register_time(String register_time) {
        this.register_time = register_time;
    }
    
    public String get_modify_time() {
        return modify_time;
    }

    public void set_modify_time(String modify_time) {
        this.modify_time = modify_time;
    }
    
}
