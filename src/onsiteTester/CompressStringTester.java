package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.CompressString;

public class CompressStringTester {

	@Test
	public void test() {
		CompressString cs=new CompressString();
		String s="aaabbbcc";
		System.out.println(cs.compress(s));
		assertTrue(cs.compress(s).equals("a3b3c2"));
	}

}
