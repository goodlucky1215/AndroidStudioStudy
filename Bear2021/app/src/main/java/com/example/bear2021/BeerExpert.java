package com.example.bear2021;

import java.util.ArrayList;
import java.util.List;

public class BeerExpert {
    List<String> getBrands(String color,String from){
        List<String> brands = new ArrayList<>();
        if(color.equals("amber")){
            brands.add("Jack Amber");
            brands.add("Red Moose");
        }else {
            brands.add("Jail Pale Ale");
            brands.add("Gout Stout");
        }
        if(from.equals("Korea")){
            brands.add("HanRa");
            brands.add("Terra");
        }else {
            brands.add("G Ale");
            brands.add("America Stout");
        }
        return  brands;
    }
}
