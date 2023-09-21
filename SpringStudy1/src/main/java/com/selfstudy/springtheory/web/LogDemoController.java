package com.selfstudy.springtheory.web;

import com.selfstudy.springtheory.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoSerivce logDemoSerivce;
    private final ObjectProvider<MyLogger> myLoggerObjectProvider;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request){

        String requestURL = request.getRequestURL().toString();
        MyLogger myLogger = myLoggerObjectProvider.getObject();
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");

        logDemoSerivce.logic("testId");

        return "OK";

    }

}
