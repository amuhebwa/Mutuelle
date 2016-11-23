package edu.cmu.mutuelle.mutuelle.models;

import java.util.ArrayList;

public class Owner extends User{
    private String userName;
    private String password;
    private ArrayList<Dependant> dependants;
    public Owner(String newUserName, String newPassword)
    {
        userName = newUserName;
        password = newPassword;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String newUserName)
    {
        userName = newUserName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String newPassword)
    {
        password = newPassword;
    }

    public ArrayList<Dependant> getDependants()
    {
        return dependants;
    }

    public void setDependants(ArrayList<Dependant> newDependants)
    {
        dependants = newDependants;
    }

    public String toString()
    {
        return String.format("%s %s", userName, password);
    }
}
