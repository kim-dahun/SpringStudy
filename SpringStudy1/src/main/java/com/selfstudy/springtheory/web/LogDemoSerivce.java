package com.selfstudy.springtheory.web;

import com.selfstudy.springtheory.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoSerivce {

    private final ObjectProvider<MyLogger> myLoggerObjectProvider;

    public void logic(String id){

        MyLogger myLogger = myLoggerObjectProvider.getObject();

        myLogger.log("service id = " + id);

    }

}
