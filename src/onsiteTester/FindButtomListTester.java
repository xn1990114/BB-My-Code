package onsiteTester;

import static org.junit.Assert.*;

/*
1 （h1）
|
2  -- 6 -- 5 (h2)
| 
3  -- 9 -- 8 --7 (h3)
|
4  -- 11 -- 10  (h4)
 */

import org.junit.Test;

import onsite.FindButtomList;

public class FindButtomListTester {

	@Test
	public void test() {
		// lists strcuture is above
		FindButtomList fbl=new FindButtomList();
		FindButtomList.Node n1=fbl.new Node(1);
		FindButtomList.Node n2=fbl.new Node(2);
		FindButtomList.Node n3=fbl.new Node(3);
		FindButtomList.Node n4=fbl.new Node(4);
		FindButtomList.Node n5=fbl.new Node(5);
		FindButtomList.Node n6=fbl.new Node(6);
		FindButtomList.Node n7=fbl.new Node(7);
		FindButtomList.Node n8=fbl.new Node(8);
		FindButtomList.Node n9=fbl.new Node(9);
		FindButtomList.Node n10=fbl.new Node(10);
		FindButtomList.Node n11=fbl.new Node(11);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n5.next=n6;
		n6.next=n2;
		n7.next=n8;
		n8.next=n9;
		n9.next=n3;
		n10.next=n11;
		n11.next=n4;
		FindButtomList.Node[] array={n1,n5,n7,n10};
		assertTrue(fbl.findButtomHead(array)==n10);
	}

}
