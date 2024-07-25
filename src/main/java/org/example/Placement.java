package org.example;

public class Placement {
    private boolean hardMode;
    private Place place;
    private String location;
    private Type type;
    private int monomer;
    private int polymer;
    private int organic;
    private int unorganic;

    public Placement(boolean hardMode, Place place, String location, Type type, int monomer, int polymer, int unorganic, int organic) {
        this.hardMode = hardMode;
        this.place = place;
        this.location = location;
        this.type = type;
        this.monomer = monomer;
        this.polymer = polymer;
        this.unorganic = unorganic;
        this.organic = organic;
    }

    public boolean getHardMode() {
        return hardMode;
    }

    public Place getPlace() {
        return place;
    }

    public String getLocation() {
        return location;
    }

    public Type getType() {
        return type;
    }

    public int getMonomer() {
        return monomer;
    }

    public int getPolymer() {
        return polymer;
    }

    public int getOrganic() {
        return organic;
    }

    public int getUnorganic() {
        return unorganic;
    }

    @Override
    public String toString() {
        return "Placement{" +
                "hardMode=" + hardMode +
                ", place=" + place +
                ", location='" + location + '\'' +
                ", type=" + type +
                ", monomer=" + monomer +
                ", polymer=" + polymer +
                ", organic=" + organic +
                ", unorganic=" + unorganic +
                '}';
    }
}

