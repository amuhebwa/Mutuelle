package edu.cmu.mutuelle.mutuelle.models;


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
}
