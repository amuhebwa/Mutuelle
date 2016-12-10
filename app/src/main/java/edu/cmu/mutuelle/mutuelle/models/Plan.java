package edu.cmu.mutuelle.mutuelle.models;

/**
 * Created by bmunyoki on 11/28/16.
 */

public class Plan {
    private String planId;
    private String planName;
    private double planCost;
    private String description;
    private long planKey;

    public Plan(){

    }

    public void setPlanKey(Long planKey){
        this.planKey = planKey;
    }
    public Long getPlanKey(){
        return this.planKey;
    }
    public void setPlanId(String planId){
        this.planId = planId;
    }
    public String getPlanId(){
        return this.planId;
    }

    public void setPlanName(String planName){
        this.planName = planName;
    }
    public String getPlanName(){
        return this.planName;
    }

    public void setPlanCost(double planCost){
        this.planCost = planCost;
    }
    public double getPlanCost(){
        return this.planCost;
    }

    public void setDescription(String description){
        this.description = description;
    }
    public String getDescription(){
        return this.description;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Plan ID: "+getPlanId());
        s.append("Plan name: "+getPlanName());
        s.append("Plan cost: "+getPlanCost());
        s.append("Description: "+getDescription());
        return s.toString();
    }
}
