package edu.cmu.mutuelle.mutuelle.models;

<<<<<<< HEAD

public class Checkin
{
    private long userNationalID;
    private long secondaryUser;
    private long hospitalID;
    private Date checkInTime;
    private Date checkOutTime;

    public CheckIn(long userNID)
    {
        userNationalID = userNID;
    }

    public CheckIn(long userNID, long secUser, long hosID)
    {
        userNationalID = userNID;
        secondaryUser = secUser;
        hospitalID = hosID;
    }

    public long getUserNationalID() {
        return userNationalID;
    }

    public void setUserNationalID(long userNID) {
        userNationalID = userNID;
    }

    public long getSecondaryUser() {
        return secondaryUser;
    }

    public void setSecondaryUser (long secUser) {
        secondaryUser = secUser;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkin) {
        checkInTime = checkin;
    }

    public Date getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(Date checkout) {
        checkOutTime = checkout;
    }

    public long getHospitalId() {
        return hospitalID;
    }

    public void setHospitalId (long hosID) {
        hospitalID = hosID;
    }

    public image generateQrCode (long userNationalID) {
        Image image = null;
        return image;
    }

    public boolean isUserCheckedIn() {
        if (true)
            return true;
        else
            return false;
    }

    public String toString() {
        
    }
=======
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


>>>>>>> benjamin
}
