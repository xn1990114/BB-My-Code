package onsiteTester;

import java.util.*;

import org.junit.Test;

import onsite.TravelPlan;

public class TravelPlanTester {

	@Test
	public void test() {
		TravelPlan tester=new TravelPlan();
		int[] c11={100,200,200,50,150,600};
		int[] c21={200,300,100,10,170,520};
		List<List<Character>> res=tester.makePlan(c11, c21);
		for(int i=0;i<res.size();i++){
			for(int j=0;j<res.get(i).size();j++){
				System.out.print(res.get(i).get(j)+"\t");
			}
			System.out.println();
		}
		int[] c12={100,200,40,90,150,500};
		int[] c22={200,300,100,210,170,520};
		res=tester.makePlan(c12, c22);
		for(int i=0;i<res.size();i++){
			for(int j=0;j<res.get(i).size();j++){
				System.out.print(res.get(i).get(j)+"\t");
			}
			System.out.println();
		}
	}

}
