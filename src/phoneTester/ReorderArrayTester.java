package phoneTester;

import static org.junit.Assert.*;

import org.junit.Test;

import phone.ReorderArray;

public class ReorderArrayTester {

	@Test
	public void test() {
		ReorderArray tester = new ReorderArray();
		char[] chars = { 'a', 'b', 'e', 'f', 'c' };
		int[] orders = { 1, 4, 3, 0, 2 };
		tester.reOrder(chars, orders);
		char[] target={'f','a','c','e','b'};
		for(int i=0;i<chars.length;i++){
			assertTrue(chars[i]==target[i]);
		}
	}

}
