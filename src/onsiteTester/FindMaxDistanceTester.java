package onsiteTester;

import static org.junit.Assert.*;

import org.junit.Test;

import onsite.FindMaxDistance;

public class FindMaxDistanceTester {

	@Test
	public void test() {
		FindMaxDistance tester=new FindMaxDistance();
		int[] nums1={5,1,2,5,6,1,6,1,3,5,12,12,1};
		assertTrue(tester.calMaxDistance(nums1)==11);
		int[] nums2={10,9,8,7,6,5,4,3,2,1};
		assertTrue(tester.calMaxDistance(nums2)==0);
		int[] nums3={10,9,8,7,6,7,4,3,2,1};
		assertTrue(tester.calMaxDistance(nums3)==1);
		int[] nums4={10,6,6,6,6,7,4,3,2,1};
		assertTrue(tester.calMaxDistance(nums4)==4);
		int[] nums5={5,1,6,6,6,7,4,3,10,4,2};
		assertTrue(tester.calMaxDistance(nums5)==9);
		int[] nums6={5,2,6,6,6,7,4,3,10,4,2};
		assertTrue(tester.calMaxDistance(nums6)==8);
	}

}
