/**
 * @author Administrator
 *
 */
package com.hjh.microservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@ConfigurationProperties(prefix = "wordConfig")
@RefreshScope
public class LuckyWordController {

	//@Value("${lucky-word}") String luckyWord;

	//String luckyWord;
	
	@Value("${wordConfig.luckyWord}")String luckyWord;
	
    @RequestMapping("/lucky-word")
    public String showLuckyWord() {
        return "The lucky word is: " + luckyWord;
    }

    /*public String getLuckyWord() {
        return luckyWord;
    }

    public void setLuckyWord(String luckyWord) {
        this.luckyWord = luckyWord;
    }*/
    
}