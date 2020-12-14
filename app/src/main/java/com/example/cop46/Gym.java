package com.example.cop46;

public class Gym {

    private String Name;
    private String Rating;


    public Gym(String name, String rating){

        Name = name;
        Rating = rating;

    }
    public String getName() {
        return Name;
    }

    public String getRating() {
        return Rating;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

}
