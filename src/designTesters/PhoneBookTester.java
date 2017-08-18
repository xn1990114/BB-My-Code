package designTesters;

import static org.junit.Assert.*;

import org.junit.Test;

import design_PhoneBook.PhoneBook;

public class PhoneBookTester {

	@Test
	public void test() {
		PhoneBook pb=new PhoneBook();
		assertFalse(pb.removeContact("Nan", "Xiao", "123"));
		assertFalse(pb.addContact("Nan", "Xiao", "91"));
		assertTrue(pb.addContact("Nan", "Xiao", "9173282865"));
		assertFalse(pb.addContact("Nan", "Xiao", "9173282865"));
		assertTrue(pb.addContact("Nan", "Wang", "2034345095"));
		assertFalse(pb.addContact("Allen", "Fung", "9173282865"));
		assertTrue(pb.addContact("Allen", "Fung", "2034345093"));
		assertTrue(pb.addContact("Na", "Xi", "2034345094"));
		assertTrue(pb.searchFirst("Na").size()==3);
		assertTrue(pb.searchLast("Xi").size()==2);
		assertFalse(pb.removeContact("Na","xiao","1234567890"));
		assertFalse(pb.removeContact("Nan","Xiao","1234567890"));
		assertTrue(pb.removeContact("Nan","Xiao","9173282865"));
		assertTrue(pb.searchFirst("Na").size()==2);
		assertTrue(pb.searchLast("Xi").size()==1);
		assertFalse(pb.removeContact("Nan","Xiao","9173282865"));
	}

}
