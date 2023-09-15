package com.selfstudy.springtheory.singleton;

public class SingletonService {
    
    private static final SingletonService instance = new SingletonService();
    
    private SingletonService(){
        
        
        
    }
    
    public void logic(){
        
        System.out.println("싱글톤 객체 생성");
        
    }
    
    public static SingletonService getInstance(){
        
        return instance;
        
    }
    
}
