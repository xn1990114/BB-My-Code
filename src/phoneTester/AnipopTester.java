package phoneTester;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

import phone.Anipop;

public class AnipopTester {

	@Test
	public void test() {
		Anipop tester=new Anipop();
		int[] nums1={1,2,2,2,1,1};
		assertTrue(tester.popElements(nums1).size()==0);
		int[] nums2={1,2,2,2,1,1,3,3,3,1};
		List<Integer> r2=tester.popElements(nums2);
		assertTrue(r2.size()==1&&r2.get(0)==1);
		int[] nums3={1,2,2,2,1,4,4,5,5,5,4,4,4,1,3,3,3,1};
		List<Integer> r3=tester.popElements(nums3);
		assertTrue(r3.size()==1&&r3.get(0)==1);
	}

}
