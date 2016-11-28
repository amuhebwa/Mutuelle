package edu.cmu.mutuelle.mutuelle.models;

/**
 * Created by bmunyoki on 11/28/16.
 */

public class Treatment {
    private int treatmentId;
    private int checkinId;
    private int serviceId;
    private String timeStamp;
    private String audioPath;

    public Treatment(){

    }

    public void setTreatmentId(int treatmentId){
        this.treatmentId = treatmentId;
    }
    public int getTreatmentId(){
        return this.treatmentId;
    }

    public void setCheckinId(int checkinId){
        this.checkinId = checkinId;
    }
    public int getCheckinId(){
        return this.checkinId;
    }

    public void setServiceId(int serviceId){
        this.treatmentId = serviceId;
    }
    public int getServiceId(){
        return this.serviceId;
    }

    public void setTimeStamp(String timeStamp){
        this.timeStamp = timeStamp;
    }
    public String getTimeStamp(){
        return this.timeStamp;
    }

    public void setAudioPath(String audioPath){
        this.audioPath = audioPath;
    }
    public String getAudioPath(){
        return this.audioPath;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Treatment ID: "+getTreatmentId());
        s.append("Checkin ID: "+getCheckinId());
        s.append("Service ID: "+getServiceId());
        s.append("Timestamp: "+getTimeStamp());
        s.append("Audio path: "+getAudioPath());
        return s.toString();
    }
}
