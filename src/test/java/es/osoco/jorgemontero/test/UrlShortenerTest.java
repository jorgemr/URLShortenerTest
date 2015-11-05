package es.osoco.jorgemontero.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import es.osoco.jorgemontero.UrlShortener;

public class UrlShortenerTest {
	 @Test
	  public void fullTest() {

	    UrlShortener tester = new UrlShortener();
	    
	    String url="http://www.osoco.es";
	    
	    String shortUrl=tester.shorten(url);
	    String enlargedUrl=tester.enlarge(shortUrl);
	    assertEquals(url, enlargedUrl);
	    
	  }
}
