package com.selfstudy.springtheory.web;

import com.selfstudy.springtheory.common.MyLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoSerivce logDemoSerivce;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request){

        String requestURL = request.getRequestURL().toString();

        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");

        logDemoSerivce.logic("testId");

        return "OK";

    }

}
