package es.osoco.jorgemontero;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UrlShortenerApplication {
	final static Logger logger = Logger.getLogger(UrlShortenerApplication.class);
	
    public static void main(String[] args) {
    	logger.info("UrlShortenerApplication Starting");
        SpringApplication.run(UrlShortenerApplication.class, args);
    }
}