package edu.cmu.mutuelle.mutuelle.models;


public class Hospital
{
    private long hospitalId;
    private String hospitalName;
    private long tinNumber;
    private double longitude;
    private double latitude;

    public long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(long hosID) {
        hospitalId = hosID;
    }

    public String getHospitalName()
    {
        return hospitalName;
    }

    public void setHospitalName(String hosName)
    {
        hospitalName = hosName;
    }

    public long getTinNumber() {
        return hospitalId;
    }

    public void setTinNumber(long tinNo) {
        tinNumber = tinNo;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(long lat) {
        latitude = lat;
    }

    public double getLongitude() {
        return latitude;
    }

    public void setLongitude(long longi) {
        longitude = longi;
    }
}
