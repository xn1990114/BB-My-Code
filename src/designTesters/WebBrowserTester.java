package designTesters;

import static org.junit.Assert.*;

import org.junit.Test;

import design_WebBrowser.WebBrowser;

public class WebBrowserTester {

	@Test
	public void test() {
		String url1="google.com";
		String url2="facebook.com";
		String url3="amazon.com";
		String url4="apple.com";
		WebBrowser wb=new WebBrowser(3);
		wb.start();
		wb.goToUrl(url1);
		wb.goToUrl(url2);
		wb.goToUrl(url3);
		wb.goToUrl(url4);
		assertTrue(wb.forward().equals("no next"));
		assertTrue(wb.backward().equals("amazon.com"));
		assertTrue(wb.backward().equals("facebook.com"));
		assertTrue(wb.backward().equals("no previous"));
		wb.goToUrl(url3);
		assertTrue(wb.forward().equals("no next"));
		assertTrue(wb.backward().equals("facebook.com"));
		wb.goToUrl(url4);
		assertTrue(wb.backward().equals("facebook.com"));
	}

}
