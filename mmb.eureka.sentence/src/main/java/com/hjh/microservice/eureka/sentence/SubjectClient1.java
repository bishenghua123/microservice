package com.hjh.microservice.eureka.sentence;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*接口*/
@FeignClient("mmb-eureka-client-subject-1")
public interface SubjectClient1 {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public  String getWord();
}
