package com.example.Assignment2.API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Assignment2ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(Assignment2ApiApplication.class, args);
                        getstrJoke();

                
	}
        public static void getstrJoke() {
        try {
            String url = "https://v2.jokeapi.dev/joke/Any";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jSonFact = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jSonFact);

            String strJoke = root.findValue("setup").asText();
            //String strDelivery = root.findValue("delivery").asText();

            
            
            System.out.println("**********joke ********");
            System.out.println("strJoke " + strJoke);
            //System.out.println("strDelivery"+strDelivery);

        } catch (JsonProcessingException ex) {
            System.out.println("error in getstrJoke");

        }
    }

}
