package com.selfstudy.springtheory.web;

import com.selfstudy.springtheory.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoSerivce {

//    private final ObjectProvider<MyLogger> myLoggerObjectProvider;
    private final MyLogger myLogger;
    public void logic(String id){

//        MyLogger myLogger = myLoggerObjectProvider.getObject();

        myLogger.log("service id = " + id);

    }

}
