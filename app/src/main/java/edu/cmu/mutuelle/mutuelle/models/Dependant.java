package edu.cmu.mutuelle.mutuelle.models;


public class Dependant
{
    private Long dependantKey;
    private int dependantId;
    private String dependantFirstName;
    private String dependantLastName;
    private String dependantDOB;
    private String dependantNationalId;
    private String getDependantCardPic;
    private String dependantAddTime;
    private String userNationalId;

    public Dependant() {

    }

    public Long getDependantKey()
    {
        return dependantKey;
    }
    public void setDependantKey(Long newDependantKey)
    {
        dependantKey = newDependantKey;
    }

    public int getDependentId()
    {
        return dependantId;
    }
    public void setDependentId(int newDependentId)
    {
        dependantId = newDependentId;
    }

    public void setUserNationalId(String id){
        this.userNationalId = id;
    }
    public String getUserNationalId(){
        return this.userNationalId;
    }

    public void setDependantDOB(String dob){
        this.dependantDOB = dob;
    }
    public String getDependantDOB(){
        return this.dependantDOB;
    }

    public void setDependantNationalId(String nationalId){
        this.dependantNationalId = nationalId;
    }
    public String getDependantNationalId(){
        return this.dependantNationalId;
    }

    public void setDependantCardPic(String path){
        this.getDependantCardPic = path;
    }
    public String getDependantCardPic(){
        return this.getDependantCardPic;
    }

    public void setDependantAddTime(String addTime){
        this.dependantAddTime = addTime;
    }
    public String getDependantAddTime(){
        return this.dependantAddTime;
    }

    public void setDependantFirstName(String name){
        this.dependantFirstName = name;
    }
    public String getDependantFirstName(){
        return this.dependantFirstName;
    }

    public void setDependantLastName(String name){
        this.dependantLastName = name;
    }
    public String getDependantLastName(){
        return this.dependantLastName;
    }

    public String toString()
    {
        return String.format("%s, %s", dependantId, dependantKey);
    }
}
