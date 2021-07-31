package com.example.workout2021_step1;

public class Workout {
    private String name = null;
    private String description = null;
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public Workout(String name,String description){
        this.name = name;
        this.description = description;
    }
    public static Workout[] workouts = {
        new Workout("배드민턴","토끼랑 30분씩")
            ,new Workout("달리기","거북이랑 30분씩")
            ,new Workout("검연습","호랑이랑 30분씩")
    };
}
