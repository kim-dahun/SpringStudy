package com.selfstudy.springtheory.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient {

    private String url;

    public NetworkClient(){

        System.out.println("생성자 호출, url = " + url);


    }

    public void setUrl(String url){

        this.url = url;

    }

    // 서비스 시작 시 호출
    public void connect(){

        System.out.println("connect : " + url);

    }

    public void call(String message){

        System.out.println("call: " + url + " message = " + message);

    }

    // 서비스 종료 시 호출
    public void disconnect() {

        System.out.println("close " + url);

    }

    @PostConstruct // 스프링이 아니더라도 지원함. JavaX 패키지에 포함된 기능, 외부 라이브러리 사용 시 Bean(initMethod, destroyMethod) 로 처리
    public void init() throws Exception {
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");

    }

    @PreDestroy
    public void close() throws Exception {
        System.out.println("NetworkClient.destroy");
        disconnect();
    }
}
