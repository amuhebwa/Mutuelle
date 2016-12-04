package edu.cmu.mutuelle.mutuelle.models;


public class Report {
    private String checkedInDate;
    private String checkedInTime;
    private String hospitalCheckedIn;

    public Report() {

    }

    public String getCheckedInDate() {
        return checkedInDate;
    }

    public void setCheckedInDate(String newCheckedInDate) {
        checkedInDate = newCheckedInDate;
    }

    public String getCheckedInTime() {
        return checkedInTime;
    }

    public void setCheckedInTime(String newCheckedInTime) {
        checkedInTime = newCheckedInTime;
    }

    public String getHospitalCheckedIn() {
        return hospitalCheckedIn;
    }

    public void setHospitalCheckedIn(String newHospitalCheckedIn) {
        hospitalCheckedIn = newHospitalCheckedIn;
    }
    public  String toString(){
        return String.format("%s, %s, %s", hospitalCheckedIn, checkedInDate, checkedInTime);
    }
}
