package es.osoco.jorgemontero.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import es.osoco.jorgemontero.UrlShortener;

public class UrlShortenerTest {
	@Test
	public void fullTest() {

		UrlShortener tester = new UrlShortener();

		String url = "http://www.osoco.es";

		String shortUrl = tester.shorten(url);
		String enlargedUrl = tester.enlarge(shortUrl);
		assertEquals(url, enlargedUrl);

	}

	@Test
	public void addUrlProtocolEmptyTest() {
		UrlShortener tester = new UrlShortener();

		String url_initial = "www.osoco.es";
		String url_expected = "http://www.osoco.es";

		String shortUrl = tester.shorten(url_initial);
		String enlargedUrl = tester.enlarge(shortUrl);
		assertEquals(url_expected, enlargedUrl);
	}

	@Test
	public void addUrlProtocolHttpsTest() {
		UrlShortener tester = new UrlShortener();

		String url = "https://www.osoco.es";

		String shortUrl = tester.shorten(url);
		String enlargedUrl = tester.enlarge(shortUrl);
		assertEquals(url, enlargedUrl);
	}

	@Test
	public void addUrlProtocolHttpTest() {
		UrlShortener tester = new UrlShortener();

		String url = "http://www.osoco.es";

		String shortUrl = tester.shorten(url);
		String enlargedUrl = tester.enlarge(shortUrl);
		assertEquals(url, enlargedUrl);
	}

}
