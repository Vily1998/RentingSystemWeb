package com.ssm.model;

public class MonthIncome {
	
	
    private String year;
    
    private int month;
    
    private int transaction_num;
    
    private float total_agency_fee;
    
    
    
    

    public MonthIncome() {
        super();
    }

    public MonthIncome(String year, int month, int transaction_num, float total_agency_fee) {
        super();
        this.year = year;
        this.month = month;
        this.transaction_num = transaction_num;
        this.total_agency_fee = total_agency_fee;
    }



    public String get_year() {
        return year;
    }

    public void set_year(String year) {
        this.year = year;
    }

    public int get_month() {
        return month;
    }

    public void set_month(int month) {
        this.month = month;
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
