package edu.cmu.mutuelle.mutuelle.models;


public class User {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String nationalId;
    private String cardPicturePath;

    public User()
    {
    }

    public User(String newUserName, String newPassword)
    {
        userName = newUserName;
        password = newPassword;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String newFirstName)
    {
        this.firstName = newFirstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String newLastName)
    {
        this.lastName = newLastName;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String newUserName)
    {
        this.userName = newUserName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String newPassword)
    {
        this.password = newPassword;
    }

    public String getNationalId()
    {
        return nationalId;
    }

    public void setNationalId(String newNationalId)
    {
        this.nationalId = newNationalId;
    }

    public String getCardPicturePath()
    {
        return cardPicturePath;
    }

    public void setCardPicturePath(String newCardPicturePath)
    {
        this.cardPicturePath = newCardPicturePath;
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
