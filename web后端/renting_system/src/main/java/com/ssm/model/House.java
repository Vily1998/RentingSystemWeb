package com.ssm.model;

public class House {
	
	//主键 房屋标识
    private int house_id;
    
    //发布用户标识
    private int user_id;
    
    //所在城市
    private String city_name;
    
    //小区名称
    private String community_name;
    
    //具体楼门号
    private String house_num;
    
    //房屋类型1:一居 2：二居 3：三居 4：三居以上:
    private int house_type;
    
    //房屋面积
    private float house_area;
    
    //所在楼层
    private int house_floor;
    
    //是否有电梯
    private int is_elevator;
    
    //房屋家居描述
    private String description;
    
    //房屋内部照片
    //private String photo;
    
    //押金（N 个月）
    private float deposit;
    
    //租金支付方式 1：月 2：季 3：年:
    private int payment_method;
    
    //租金
    private float rent_per_month;
    
    //注册时间
    private String register_time;
    
    //修改时间
    private String modify_time;
    
    //状态 1：已租 0：待租
    private int state;
    
    
    public House() {
        super();
    }

    public House(int house_id,int user_id,String city_name,String community_name,String house_num,int house_type,float house_area,int house_floor,int is_elevator,String description,float deposit,int payment_method,float rent_per_month,String register_time,String modify_time,int state) {
    	
    	super();
    	
    	this.house_id = house_id;
        this.user_id = user_id;
        this.city_name = city_name;
        this.community_name = community_name;
        this.house_num = house_num;
        this.house_type = house_type;
        this.house_area = house_area;
        this.house_floor = house_floor;
        this.is_elevator = is_elevator;
        this.description = description;
        //this.photo = photo;
        this.deposit = deposit;
        this.payment_method = payment_method;
        this.rent_per_month = rent_per_month;
        this.register_time = register_time;
        this.modify_time = modify_time;
        this.state = state;
        
        
    }
    
    public int get_house_id() {
        return house_id;
    }

    public void set_house_id(int house_id) {
        this.house_id = house_id;
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
    
    public String get_house_num() {
        return house_num;
    }

    public void set_house_num(String house_num) {
        this.house_num = house_num;
    }
    
    public int get_house_type() {
        return house_type;
    }

    public void set_house_type(int house_type) {
        this.house_type = house_type;
    }
    
    public float get_house_area() {
        return house_area;
    }

    public void set_house_area(float house_area) {
        this.house_area = house_area;
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
    
    /*
    public String get_photo() {
        return photo;
    }

    public void set_photo(String photo) {
        this.photo = photo;
    }
    */
    
    
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
    
    public int get_state() {
        return state;
    }

    public void set_state(int state) {
        this.state = state;
    }
    
    
}
