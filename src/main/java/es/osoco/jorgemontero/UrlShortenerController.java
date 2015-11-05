package es.osoco.jorgemontero;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UrlShortenerController {
	final static Logger logger = Logger.getLogger(UrlShortenerController.class);
	private String basePath="http://localhost:8080/urlEnlarger?key=";
    private static UrlShortener urlShortener=new UrlShortener();
    
    @RequestMapping("/urlShortener")
    public String urlShortener(@RequestParam(value="url") String url) {
    	logger.info("UrlShortenerController.urlShortener<--"+url);
    	String ret=basePath+urlShortener.shorten(url);
    	logger.info("UrlShortenerController.urlShortener-->"+ret);
    	
    	return ret;
    }
    
    @RequestMapping("/urlEnlarger")
    public void urlEnlarger(HttpServletResponse response,@RequestParam(value="key") String key) throws IOException {
    	logger.info("UrlShortenerController.urlEnlarger<--"+key);
    	String url =urlShortener.enlarge(key);
    	logger.info("UrlShortenerController.urlEnlarger--> "+url);
    	    	
    	response.sendRedirect(url);
    }
}
