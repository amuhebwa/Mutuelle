package edu.cmu.mutuelle.mutuelle.models;


public class Service
{
    private long serviceId;
    private long hospitalId;
    private String description;
    private double cost;

    public long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(long hosID) {
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
