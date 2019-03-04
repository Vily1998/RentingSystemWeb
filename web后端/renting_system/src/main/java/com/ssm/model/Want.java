package com.ssm.model;

public class Want {
	
	//主键 用户标识
    private int want_id;
    
    private int landlord_user_id;
    
    private int house_id;
    
    private int tenant_user_id;
    
    private String real_name;
    
    private String start_month;
    
    private int continual_month;
    

    private String description;
    
    //用户类型 0：系统管理员 1：普通用户
    private int state;
    
    
    //修改时间
    private String modify_time;
    
    

    public Want() {
        super();
    }

    public Want(int want_id, int landlord_user_id, int house_id, int tenant_user_id, String real_name, String start_month,int continual_month, String description, int state, String modify_time) {
        super();
        this.want_id = want_id;
        this.landlord_user_id = landlord_user_id;
        this.house_id = house_id;
        this.tenant_user_id = tenant_user_id;
        this.real_name = real_name;
        this.start_month = start_month;
        this.continual_month = continual_month;
        this.description = description;
        this.state = state;
        this.modify_time = modify_time;
    }



   
    public int get_want_id() {
        return want_id;
    }

    public void set_want_id(int want_id) {
        this.want_id = want_id;
    }

    public int get_landlord_user_id() {
        return landlord_user_id;
    }

    public void set_landlord_user_id(int landlord_user_id) {
        this.landlord_user_id = landlord_user_id;
    }
    
    
    public int get_house_id() {
        return house_id;
    }

    public void set_house_id(int house_id) {
        this.house_id = house_id;
    }
    
    
    public int get_tenant_user_id() {
        return tenant_user_id;
    }

    public void set_tenant_user_id(int tenant_user_id) {
        this.tenant_user_id = tenant_user_id;
    }

    
    public String get_real_name() {
        return real_name;
    }

    public void set_real_name(String real_name) {
        this.real_name = real_name;
    }
    
    public String get_start_month() {
        return start_month;
    }

    public void set_start_month(String start_month) {
        this.start_month = start_month;
    }
    
    public int get_continual_month() {
        return continual_month;
    }

    public void set_continual_month(int continual_month) {
        this.continual_month = continual_month;
    }


    
    public String get_description() {
        return description;
    }

    public void set_description(String description) {
        this.description = description;
    }


    
    public int get_state() {
        return state;
    }

    public void set_state(int state) {
        this.state = state;
    }

    
    public String get_modify_time() {
        return modify_time;
    }

    public void set_modify_time(String modify_time) {
        this.modify_time = modify_time;
    }

}
