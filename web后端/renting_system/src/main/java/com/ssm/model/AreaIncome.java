package com.ssm.model;

public class AreaIncome {
	

    private String area;
    
    
    
    private int transaction_num;
    
    private float total_agency_fee;
    
    
    
    

    public AreaIncome() {
        super();
    }

    public AreaIncome(String area, int transaction_num, float total_agency_fee) {
        super();
        this.area = area;
        this.transaction_num = transaction_num;
        this.total_agency_fee = total_agency_fee;
    }



    public String get_area() {
        return area;
    }

    public void set_area(String area) {
        this.area = area;
    }

    
    
    public int get_transaction_num() {
        return transaction_num;
    }

    public void set_transaction_num(int transaction_num) {
        this.transaction_num = transaction_num;
    }
    
    public float get_total_agency_fee() {
        return total_agency_fee;
    }

    public void set_total_agency_fee(float total_agency_fee) {
        this.total_agency_fee = total_agency_fee;
    }


}
