package com.hjh.microservice.eureka.sentence;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

    /**
     * 用于服务发现的客户端
    @Autowired
    DiscoveryClient client;
    */
	
	/*用于Netflix Ribbon负载均衡的客户端*/
	/*@Autowired
	LoadBalancerClient loadBalancer;
*/
	@Autowired
    private NounClient nounClient;
	
	@Autowired
	private WordService wordService;
	
	/*@RequestMapping("/sentence")
    public  String getSentence() {
        return
                getWord("mmb-eureka-client-subject") + " "
                        + getWord("mmb-eureka-client-subject-1") + " "
                        + getWord("mmb-eureka-client-subject-2") + "." ;//大小写不区分
    }*/
	
	/**/
	@RequestMapping("/sentence_feigh")
    @ResponseBody
    public String getSentenceFeign() {
        return
                "<h3>造句:</h3><br/>" +
                        buildSentence() + "<br/><br/>" +
                        buildSentence() + "<br/><br/>" +
                        buildSentence() + "<br/><br/>" +
                        buildSentence() + "<br/><br/>" +
                        buildSentence() + "<br/><br/>"
                ;
    }
	
	/**/
	@RequestMapping("/sentence_hystrix")
    @ResponseBody
    public String getSentenceHystrix() {
        return
                "<h3>造句:</h3><br/>" +
                wordService.getSubject() + "<br/><br/>" +
                wordService.getSubject1() + "<br/><br/>" +
                wordService.getSubject2() + "<br/><br/>" ;
    }
    /**
     * 用于服务发现的client方法
     public String getWord(String service) {
        List<ServiceInstance> list = client.getInstances(service);
        if (list != null && list.size() > 0 ) {
            URI uri = list.get(0).getUri();
            if (uri !=null ) {
                return (new RestTemplate()).getForObject(uri,String.class);
            }
        }
        return null;
    }
    */
    
    /*用于Netflix Ribbon负载均衡的loadbalancer方法*/
    /*public String getWord(String service) {
        ServiceInstance instance = loadBalancer.choose(service);
           return (new RestTemplate()).getForObject(instance.getUri(),String.class);
    }*/
    /*用于Netflix Feign的方法*/
    public String buildSentence() {
        String sentence = "There was a problem assembling the sentence!";
        try{
            sentence =  nounClient.getWord();
        } catch ( Exception e ) {
            System.out.println(e);
        }
        return sentence;
    }
    
}

