package com.hjh.microservice.eureka.sentence;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*接口*/
@FeignClient("mmb-eureka-client-subject-2")
public interface SubjectClient2 {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public  String getWord();
}
