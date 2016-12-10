package edu.cmu.mutuelle.mutuelle.models;

import android.media.Image;

import java.util.Date;

public class Checkin
{
    private long checkinKey;
    private String userNationalID;
    private String secondaryUser;
    private String hospitalID;
    private String checkInTime;
    private String checkOutTime;

    public Checkin(){

    }
    public Checkin(String userNID)
    {
        userNationalID = userNID;
    }

    public Checkin(String userNID, String secUser, String hosID)
    {
        userNationalID = userNID;
        secondaryUser = secUser;
        hospitalID = hosID;
    }

    public void setCheckinKey(Long key){
        this.checkinKey = key;
    }
    public long getCheckinKey(){
        return this.checkinKey;
    }
    public String getUserNationalID() {
        return userNationalID;
    }

    public void setUserNationalID(String userNID) {
        userNationalID = userNID;
    }

    public String getSecondaryUser() {
        return secondaryUser;
    }

    public void setSecondaryUser (String secUser) {
        secondaryUser = secUser;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkin) {
        checkInTime = checkin;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkout) {
        checkOutTime = checkout;
    }

    public String getHospitalId() {
        return hospitalID;
    }

    public void setHospitalId (String hosID) {
        hospitalID = hosID;
    }

    public Image generateQrCode (String userNationalID) {
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
       return  "";
    }

}
