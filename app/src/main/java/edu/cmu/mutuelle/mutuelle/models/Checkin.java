package edu.cmu.mutuelle.mutuelle.models;

import android.widget.ImageView;

/**
 * Created by bmunyoki on 11/28/16.
 */

public class Checkin {
    private String subscriptionType;
    private String grade;
    private String accountNumber;
    private String customerName; //Review this
    private ImageView barcode;

    public Checkin(){

    }

    public void setSubscriptionType(String subscriptionType){
        this.subscriptionType = subscriptionType;
    }
    public String getSubscriptionType(){
        return this.subscriptionType;
    }

    public void setAccountNumber(String accountNumber){
        this.accountNumber = accountNumber;
    }
    public String getAccountNumber(){
        return this.accountNumber;
    }

    public void displayUSerInformation(){

    }

    public void displayBarCode(){

    }

    public void displayMutuelleCard(){
        
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Subscription type : "+this.subscriptionType);
        s.append("Grade :"+this.grade);
        s.append("Account number :"+this.accountNumber);
        return s.toString();
    }


}
