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
	private String basePath="http://oso.co/e?k=";
    private static UrlShortener urlShortener=new UrlShortener();
    
    @RequestMapping(value={"/urlShortener", "s"})
    public String urlShortener(@RequestParam(value="u") String url) {
    	logger.info("UrlShortenerController.urlShortener<--"+url);
    	String ret=basePath+urlShortener.shorten(url);
    	logger.info("UrlShortenerController.urlShortener-->"+ret);
    	
    	return ret;
    }
    
    @RequestMapping(value={"/urlEnlarger","/e"})
    public void urlEnlarger(HttpServletResponse response,@RequestParam(value="k") String key) throws IOException {
    	logger.info("UrlShortenerController.urlEnlarger<--"+key);
    	String url =urlShortener.enlarge(key);
    	logger.info("UrlShortenerController.urlEnlarger--> "+url);
    	    	
    	response.sendRedirect(url);
    }
}
