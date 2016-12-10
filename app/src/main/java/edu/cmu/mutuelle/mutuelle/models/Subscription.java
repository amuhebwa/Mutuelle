package edu.cmu.mutuelle.mutuelle.models;

/**
 * Created by bmunyoki on 12/9/16.
 */

public class Subscription {
    private long subsciptionKey;
    private String userNationalId;
    private String planId;
    private String startDate;
    private String endDate;
    private int status; //1 - complete. 0 - pending

    public Subscription(){

    }

    public void setSubsciptionKey(Long subsciptionKey){
        this.subsciptionKey = subsciptionKey;
    }
    public Long getSubsriptionKey(){
        return this.subsciptionKey;
    }

    public void setUserNationalId(String uNationalId){
        this.userNationalId = uNationalId;
    }
    public String getUserNationalId(){
        return this.userNationalId;
    }

    public void setPlanId(String pId){
        this.planId = pId;
    }
    public String getPlanId(){
        return this.planId;
    }

    public void setStartDate(String stDate){
        this.startDate = stDate;
    }
    public String getStartDate(){
        return this.startDate;
    }

    public void setEndDate(String endDate){
        this.endDate = endDate;
    }
    public String getEndDate(){
        return this.endDate;
    }

    public void setStatus(int status){
        this.status = status;
    }
    public int getStatus(){
        return this.status;
    }
}
