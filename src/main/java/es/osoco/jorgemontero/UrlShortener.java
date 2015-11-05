package es.osoco.jorgemontero;

import java.util.HashMap;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;

public class UrlShortener {
	final static Logger logger = Logger.getLogger(UrlShortener.class);
	private Base64 base64=new Base64(true);
	private HashMap<String,String> hm=new HashMap<String, String>(); 

	public String shorten(String url){
		logger.info("UrlShortener.shorten<--"+url);
		byte[] sum=DigestUtils.sha256(url);
		String ret=base64.encodeAsString(sum).replaceAll("\r\n", "");;
	    hm.put(ret, url);
	    logger.info("UrlShortener hashTableSize "+hm.size());
	    logger.info("UrlShortener.shorten-->"+ret);		
		return ret;
	}
	
	public String enlarge(String key){
		logger.info("UrlShortener.shorten<--"+key);
		String url=hm.get(key);
		logger.info("UrlShortener.shorten-->"+url);		
		return url;
	}
}
