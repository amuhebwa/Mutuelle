package edu.cmu.mutuelle.mutuelle.models;


public class User {
    private String firstName;
    private String lastName;
    private String nationalId;
    private String cardPicturePath;

    public User()
    {
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
