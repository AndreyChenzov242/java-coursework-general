package com.company;

public class Chesser {

    private int id;
    private String name;
    private String dateOfBirth;
    private String city;
    private int rating;

    public int getId(){ return id; }
    public String getName(){ return name; }
    public String getDateOfBirth(){ return dateOfBirth; }
    public String getCity(){ return city; }
    public int getRating(){ return rating; }

    public void setId(int id){ this.id = id; }
    public void setName(String name){ this.name = name; }
    public void setDateOfBirth(String dateOfBirth){ this.dateOfBirth = dateOfBirth; }
    public void setCity(String city){ this.city = city; }
    public void setRating(int rating){ this.rating = rating; }

    public Chesser(int id, String name, String dateOfBirth, String city, int rating) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
        this.rating = rating;
    }
}
