package com.ssm.model;

public class Photo {
	
	//主键 用户标识
    private int house_id;

    private String photo;
    
    

    public Photo() {
        super();
    }

    public Photo(int house_id,  String photo) {
        super();
        this.house_id = house_id;

        this.photo = photo;
    }



   
    public int get_house_id() {
        return house_id;
    }

    public void set_house_id(int house_id) {
        this.house_id = house_id;
    }




    
    public String get_photo() {
        return photo;
    }

    public void set_photo(String photo) {
        this.photo = photo;
    }

}
