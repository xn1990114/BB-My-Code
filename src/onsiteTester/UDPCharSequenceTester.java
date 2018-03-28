package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.UDPCharSequence;

public class UDPCharSequenceTester {

	@Test
	public void test1() {
		UDPCharSequence tester=new UDPCharSequence();
		int[] seqs={1,2,4,3};
		String[] content={"a","b","d","c"};
		String[] res={"a","ab","abcd"};
		assertTrue(tester.sameRes(tester.generateString(seqs, content), res));
	}
	@Test
	public void test2() {
		UDPCharSequence tester=new UDPCharSequence();
		int[] seqs={5,2,4,3};
		String[] content={"a","b","d","c"};
		String[] res={};
		assertTrue(tester.sameRes(tester.generateString(seqs, content), res));
	}
	@Test
	public void test3() {
		UDPCharSequence tester=new UDPCharSequence();
		int[] seqs={1,7,4,3,5,2};
		String[] content={"a","b","d","c","e","f"};
		String[] res={"a","afcde"};
		assertTrue(tester.sameRes(tester.generateString(seqs, content), res));
	}
}
