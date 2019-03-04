package com.ssm.model;

public class Message {
	
	//主键 用户标识
    private int message_id;
    
    private int landlord_user_id;
    
    private int house_id;
    
    private int tenant_user_id;
    
    private String content;
    
   
   
    private int state;
    
    
    //修改时间
    private String modify_time;
    
    

    public Message() {
        super();
    }

    public Message(int message_id, int landlord_user_id, int house_id, int tenant_user_id, String content,  int state, String modify_time) {
        super();
        this.message_id = message_id;
        this.landlord_user_id = landlord_user_id;
        this.house_id = house_id;
        this.tenant_user_id = tenant_user_id;
        this.content = content;
        this.state = state;
        this.modify_time = modify_time;
    }



   
    public int get_message_id() {
        return message_id;
    }

    public void set_message_id(int message_id) {
        this.message_id = message_id;
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

    
    public String get_content() {
        return content;
    }

    public void set_content(String content) {
        this.content = content;
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
