package com.selfstudy.springtheory.singleton;

public class statefulService {

//    int price;

    public int order(String username, int price){

        System.out.println(username + "님의 가격은 " + price);

        return price;


    }

//    public int getPrice(){
//
//        return price;
//
//    }

}

