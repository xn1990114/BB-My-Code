package onsiteTester;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import onsite.ParenthesisStringParser;

public class ParenthesisStringParserTester {

	@Test
	public void test1() {
		ParenthesisStringParser tester = new ParenthesisStringParser();
		String s = "({I[forget(the)details]sorry}minasang)";
		String[] r = { "the", "forget the details", "I forget the details sorry",
				"I forget the details sorry minasang" };
		assertTrue(tester.sameStringList(r, tester.parse(s)));
	}
	@Test
	public void test2() {
		ParenthesisStringParser tester = new ParenthesisStringParser();
		String s = "({I[forget(the)details]sorry]minasang)";
		String[] r = { };
		assertTrue(tester.sameStringList(r, tester.parse(s)));
	}
	@Test
	public void test3() {
		ParenthesisStringParser tester = new ParenthesisStringParser();
		String s = "({I[forget(the)details]sorry}minasang";
		String[] r = { };
		assertTrue(tester.sameStringList(r, tester.parse(s)));
	}
	@Test
	public void test4() {
		ParenthesisStringParser tester = new ParenthesisStringParser();
		String s = "({I[forget(the)details]sorry}minasang))";
		String[] r = { };
		assertTrue(tester.sameStringList(r, tester.parse(s)));
	}
	@Test
	public void test5() {
		ParenthesisStringParser tester = new ParenthesisStringParser();
		String s = "{I[forget(the)details]sorry}minasang";
		String[] r = { };
		assertTrue(tester.sameStringList(r, tester.parse(s)));
	}
}
