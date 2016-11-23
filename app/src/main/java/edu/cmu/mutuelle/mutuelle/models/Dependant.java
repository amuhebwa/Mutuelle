package edu.cmu.mutuelle.mutuelle.models;


public class Dependant
{
    private int dependantKey;
    private int dependentId;

    public Dependant()
    {

    }

    public int getDependantKey()
    {
        return dependantKey;
    }

    public void setDependantKey(int newDependantKey)
    {
        dependantKey = newDependantKey;
    }

    public int getDependentId()
    {
        return dependentId;
    }

    public void setDependentId(int newDependentId)
    {
        dependentId = newDependentId;
    }
    public String toString()
    {
        return String.format("%s, %s", dependentId, dependantKey);
    }
}
