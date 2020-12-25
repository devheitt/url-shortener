package dev.heitt.AcortadorDeUrl.Utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NormalizerTest {

	@Test
	void addHTTPS() {
		String url = "test.com";
		
		String normalizedUrl = Normalizer.normalize(url);
		
		String expected = "https://test.com";
	
		assertEquals(expected, normalizedUrl);
	}
	
	@Test
	void testWithUrlThatContainsHTTPS() {
		String url = "https://test.com";
		
		String normalizedUrl = Normalizer.normalize(url);
		
		String expected = "https://test.com";
	
		assertEquals(expected, normalizedUrl);
	}	
	
	@Test
	void testWithUrlThatContainsHTTP() {
		String url = "http://test.com";
		
		String normalizedUrl = Normalizer.normalize(url);
		
		String expected = "http://test.com";
	
		assertEquals(expected, normalizedUrl);
	}
	
	
	@Test
	void testWithUrlForFTP() {
		String url = "ftp://test.com";
		
		String normalizedUrl = Normalizer.normalize(url);
		
		String expected = "ftp://test.com";
	
		assertEquals(expected, normalizedUrl);
	}
}
