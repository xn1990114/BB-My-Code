package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.RemoveStringInRange;

public class RemoveStringInRangeTester {

	@Test
	public void test1() {
		RemoveStringInRange tester=new RemoveStringInRange();
		String s="abcdefghij";
		int[][] range={{2,3} ,{1,3} ,{4,5}};
		String r="aghij";
		assertTrue(tester.removeString(s, range).equals(r));
	}
	@Test
	public void test2() {
		RemoveStringInRange tester=new RemoveStringInRange();
		String s="My name is Nan Xiao";
		int[][] range={{20,20},{2,3} ,{1,3} ,{4,5},{30,35}};
		String r="Me is Nan Xiao";
		assertTrue(tester.removeString(s, range).equals(r));
	}
	@Test
	public void test3() {
		RemoveStringInRange tester=new RemoveStringInRange();
		String s="My name is Nan Xiao";
		int[][] range={{20,20},{2,3} ,{1,3} ,{4,5},{30,35},{-10,0},{1,6},{4,10},{14,17},{18,18}};
		String r="Nan";
		assertTrue(tester.removeString(s, range).equals(r));
	}
}
