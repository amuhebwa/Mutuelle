package edu.cmu.mutuelle.mutuelle.models;

/**
 * Created by bmunyoki on 11/28/16.
 */

public class Treatment {
    private long treatmentKey;
    private long checkinId;
    private String serviceId;
    private String timeStamp;
    private String audioPath;

    public Treatment(){

    }

    public void setTreatmentKey(long treatmentKey){
        this.treatmentKey = treatmentKey;
    }
    public long getTreatmentKey(){
        return this.treatmentKey;
    }
    public void setCheckinId(long checkinId){
        this.checkinId = checkinId;
    }
    public long getCheckinId(){
        return this.checkinId;
    }

    public void setServiceId(String serviceId){
        this.serviceId = serviceId;
    }
    public String getServiceId(){
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
        s.append("Checkin ID: "+getCheckinId());
        s.append("Service ID: "+getServiceId());
        s.append("Timestamp: "+getTimeStamp());
        s.append("Audio path: "+getAudioPath());
        return s.toString();
    }
}
