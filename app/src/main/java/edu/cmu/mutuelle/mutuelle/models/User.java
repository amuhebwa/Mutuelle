package edu.cmu.mutuelle.mutuelle.models;


import java.util.Date;

public class User {
    private String firstName;
    private String lastName;
    private String nationalId;
    private String cardPicturePath;
    private String password;
    private String dob;
    private long id;

    public User(){

    }
    public User(String firstName, String lastName, String nationaId, String password, String dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalId = nationaId;
        this.password = password;
        this.dob = dob;
    }
    public User(String firstName, String lastName, String nationaId, String password, String dob, String cardPicturePath) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalId = nationaId;
        this.password = password;
        this.dob = dob;
        this.cardPicturePath = cardPicturePath;
    }

    public void setid(long id){
        this.id = id;
    }
    public long getUserId(){
        return this.id;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }

    public void setDOB(String dob){
        this.dob = dob;
    }
    public String getDob(){
        return this.dob;
    }
    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String newFirstName)
    {
        firstName = newFirstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String newLastName)
    {
        lastName = newLastName;
    }

    public String getNationalId()
    {
        return nationalId;
    }

    public void setNationalId(String newNationalId)
    {
        nationalId = newNationalId;
    }

    public String getCardPicturePath()
    {
        return cardPicturePath;
    }

    public void setCardPicturePath(String newCardPicturePath)
    {
        cardPicturePath = newCardPicturePath;
    }

    public boolean isUserLoggedIn()
    {
        return true;
    }

    public String toString()
    {
        return String.format("%s\n, %s\n, %s\n", firstName, lastName, nationalId);
    }
}
