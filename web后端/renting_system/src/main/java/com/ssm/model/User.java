package com.ssm.model;

public class User {

    //���� �û���ʶ
    private int user_id;
    
    //�û���
    private String user_name;
    
    //��¼����
    private String password;
    
    //�û����� 0��ϵͳ����Ա 1����ͨ�û�
    private int user_type;
    
    //�û�����
    private String real_name;
    
    // ֤�����ͣ�Ĭ�����֤��0�����֤ 1������
    private int certificate_type;
    
    //֤������
    private String certificate_num;
    
    //�ֻ�����(11λ����)
    private String mobile_num;
    
    //�û����� 2����ʯ�� 1����Ҫ  0��һ��
    private int user_level;
    
    //ע�����
    private String register_city;
    
    //ע��ʱ��
    private String register_time;
    
    //�޸�ʱ��
    private String modify_time;
    
    public User() {
        super();
    }

    public User(int user_id, String user_name, String password, int user_type, String real_name, int certificate_type, String certificate_num, String mobile_num, int user_level, String register_city, String register_time, String modify_time) {
        super();
        this.user_id = user_id;
        this.user_name = user_name;
        this.password = password;
        this.user_type = user_type;
        this.real_name = real_name;
        this.certificate_type = certificate_type;
        this.certificate_num = certificate_num;
        this.mobile_num = mobile_num;
        this.user_level = user_level;
        this.register_city = register_city;
        this.register_time = register_time;
        this.modify_time = modify_time;
    }

    public int get_user_id() {
        return user_id;
    }

    public void set_user_id(int user_id) {
        this.user_id = user_id;
    }

    public String get_user_name() {
        return user_name;
    }

    public void set_user_name(String user_name) {
        this.user_name = user_name;
    }

    
    public String get_password() {
        return password;
    }

    public void set_password(String password) {
        this.password = password;
    }
    
    public int get_user_type() {
        return user_type;
    }

    public void set_user_type(int user_type) {
        this.user_type = user_type;
    }
    
    public String get_real_name() {
        return real_name;
    }

    public void set_real_name(String real_name) {
        this.real_name = real_name;
    }
    
    
    public int get_certificate_type() {
        return certificate_type;
    }

    public void set_certificate_type(int certificate_type) {
        this.certificate_type = certificate_type;
    }
    
    public String get_certificate_num() {
        return certificate_num;
    }

    public void set_certificate_num(String certificate_num) {
        this.certificate_num = certificate_num;
    }
    
    public String get_mobile_num() {
        return mobile_num;
    }

    public void set_mobile_num(String mobile_num) {
        this.mobile_num = mobile_num;
    }
    
    
    public int get_user_level() {
        return user_level;
    }

    public void set_user_level(int user_level) {
        this.user_level = user_level;
    }

    public String get_register_city() {
        return register_city;
    }

    public void set_register_city(String register_city) {
        this.register_city = register_city;
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
