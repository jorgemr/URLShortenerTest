package es.osoco.jorgemontero;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

public class UrlShortener {
	final static Logger logger = Logger.getLogger(UrlShortener.class);
	private Base64 base64=new Base64(true); //Url safe
	private HashMap<String,String> hm=new HashMap<String, String>(); 

	public String shorten(String url){
		logger.info("shorten<--"+url);
		
		url = addUrlProtocol(url);
		
		byte[] sum=DigestUtils.sha1(url); //shorter URL | More collisions
		//byte[] sum=DigestUtils.sha256(url);
		//byte[] sum=DigestUtils.sha512(url); // Larger URL | Less Collisions
		String ret=base64.encodeAsString(sum).replaceAll("\r\n", "");
		
	    hm.put(ret, url);
	    logger.info("shorten-->hashTableSize "+hm.size());
	    logger.info("shorten-->"+ret);
	    
		return ret;
	}
	
	public String enlarge(String key){
		logger.info("enlarge<--"+key);
		String url=hm.get(key);
		logger.info("enlarge-->"+url);		
		return url;
	}
	
	private String addUrlProtocol(String url) {
		//Default http protocol is added to url (if missing)
		Pattern p = Pattern.compile("^http.*$");
		Matcher m = p.matcher(url);
		if(!m.matches()){
			url="http://"+url;
		}
		logger.info("addUrlProtocol(corrected)<--"+url);
	
		return url;
	}
}
