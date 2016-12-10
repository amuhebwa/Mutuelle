package edu.cmu.mutuelle.mutuelle.models;


public class Service
{
    private String serviceId;
    private String hospitalId;
    private String description;
    private double cost;
    private long serviceKey;

    public void setServiceKey(Long serviceKey){
        this.serviceKey = serviceKey;
    }
    public Long getServiceKey(){
        return this.serviceKey;
    }
    public void setServiceId(String serviceId){
        this.serviceId = serviceId;
    }
    public String getServiceId(){
        return this.serviceId;
    }
    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hosID) {
        hospitalId = hosID;
    }

    public void setDescription(String descriptions) {
        description = descriptions;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double costs) {
        cost = costs;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return "";
    }
}
