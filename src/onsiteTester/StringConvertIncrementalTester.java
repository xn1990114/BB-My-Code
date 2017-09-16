package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.StringConvertIncremental;

public class StringConvertIncrementalTester {

	@Test
	public void test() {
		StringConvertIncremental tester=new StringConvertIncremental();
		String s1="aaabbca";
		assertTrue(tester.increaseString(s1).equals("abcbccd"));
		String s2="aaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		assertTrue(tester.increaseString(s2).equals("abcdefghijklmnopqrstuvwxyzab"));
	}

}
