package onsiteTester;

import static org.junit.Assert.*;
import java.util.*;

import org.junit.Test;

import onsite.TopKSlidingWindow;

public class TopKSlidingWindowTester {

	@SuppressWarnings("rawtypes")
	@Test
	public void test() {
		TopKSlidingWindow tester=new TopKSlidingWindow();
		int[] nums1={2,1,5,2,1,6,1,4,4,5,7,9,1};
		List[] r1=tester.findTopK(nums1, 2, 3);
		for(int i=0;i<r1.length;i++){
			for(int j=0;j<r1[i].size();j++){
				System.out.print(r1[i].get(j)+"\t");
			}
			System.out.println();
		}
		System.out.println();
		List[] r2=tester.findTopK(nums1, 5, 7);
		for(int i=0;i<r2.length;i++){
			for(int j=0;j<r2[i].size();j++){
				System.out.print(r2[i].get(j)+"\t");
			}
			System.out.println();
		}
	}

}
