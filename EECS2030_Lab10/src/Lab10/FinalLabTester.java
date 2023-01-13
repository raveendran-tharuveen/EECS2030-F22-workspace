package Lab10;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

import org.junit.jupiter.api.Test;


class FinalLabTester {

	@Test
	void testRemoveDuplicate1_1() {
		Integer [] list = {1, 2, 3, 1, 3, 4, 2};
		HashSet<Integer> set = (HashSet) FinalLab.removeDuplicate1(list);
		assertEquals(4, set.size(), "The size of the set must be 4 after removing the duplications.using RemoveDuplicat1 method");
		
	}

	@Test
	void testRemoveDuplicate1_2() {
		Integer [] list = {1, 2, 3, 1, 3, 4, 2, 2, 2,};
		HashSet<Integer> set = (HashSet) FinalLab.removeDuplicate1(list);
		boolean equal = set.contains(1) && set.contains(2) && set.contains(3) && set.contains(4); 
		assertTrue((equal&&set.size()==4), "RemoveDuplicate1 does not remove all the duplicates");
		
	}
	@Test
	void testRemoveDuplicate2_1() {
		Integer [] list = {1, 2, 3, 1, 3, 4, 2, 2, 2,};
		list = FinalLab.removeDuplicate2(list);
		assertEquals(4, list.length, "The lenght of the list must be 4 after removing the duplications using RemoveDuplicat2 method.");
		
	}

	@Test
	void testRemoveDuplicate2_2() {
		Integer [] list = {1, 2, 3, 1, 3, 4, 2, 2, 2,};
		Integer [] listWithoutduplicate = {1, 2, 3, 4};
		List<Integer> listWD = Arrays.asList(listWithoutduplicate);
		list = FinalLab.removeDuplicate2(list);
		List<Integer> list2 = Arrays.asList(list);
		boolean equal = (list.length == 4) && list2.containsAll(listWD) && listWD.containsAll(list2); 
		assertTrue(equal, "RemoveDuplicate2 does not remove all the duplicates");
		
	}
	
	@Test
	void testReturnDuplicate1_1() {
		Integer [] list = {1, 2, 3, 1, 3, 4, 2, 2, 2,};
		Object [] list2 = FinalLab.returnDuplicate1(list);
		assertTrue(list2.length == 5, "ReturnDuplicate1 does not correctly return all the duplicated elements.");
		
	}

	@Test
	void testReturnDuplicate1_2() {
		Integer [] list = {1, 2, 3, 1, 3, 4, 2, 2, 2,};
		List<Object> duplicatesActual = Arrays.asList(FinalLab.returnDuplicate1(list));
		Integer [] list2 = {1, 3, 2, 2, 2};
		List<Object> duplicatesExpected = Arrays.asList(list2);		
		boolean equal = (duplicatesActual.size() == 5) && duplicatesActual.containsAll(duplicatesExpected) && duplicatesExpected.containsAll(duplicatesActual); 
		assertTrue(equal, "ReturnDuplicate1 does not correctly return all the duplicated elements.");
		
	}
	@Test
	void testReturnDuplicate2_1() {
		Integer [] list = {1, 2, 3, 1, 3, 4, 2, 2, 2,};
		Integer [] list2 = FinalLab.returnDuplicate2(list);
		assertTrue(list2.length == 5, "ReturnDuplicate2 does not correctly return all the duplicated elements.");
		
	}

	@Test
	void testReturnDuplicate2_2() {
		Integer [] list = {1, 2, 3, 1, 3, 4, 2, 2, 2,};
		List<Integer> duplicatesActual = Arrays.asList(FinalLab.returnDuplicate2(list));
		Integer [] list2 = {1, 3, 2, 2, 2};
		List<Object> duplicatesExpected = Arrays.asList( list2);		
		boolean equal = (duplicatesActual.size() == 5) && duplicatesActual.containsAll(duplicatesExpected) && duplicatesExpected.containsAll(duplicatesActual); 
		assertTrue(equal, "ReturnDuplicate_2 does not correctly return all the duplicated elements.");
	}
	@Test
	void testReturnUniqueDuplicate1() {
		Integer [] list = {1, 2, 3, 1, 3, 4, 2, 2, 2,};
		Integer [] list2 = FinalLab.returnUniqueDuplicate(list);
		assertTrue(list2.length == 3, "ReturnUniqueDuplicate does not correctly return all the duplicated elements.");
		
	}

	@Test
	void testReturnUniqueDuplicate2() {
		Integer [] list = {1, 2, 3, 1, 3, 4, 2, 2, 2,};
		List<Integer> duplicatesActual = Arrays.asList(FinalLab.returnUniqueDuplicate(list));
		Integer [] list2 = {1, 2, 3};
		List<Object> duplicatesExpected = Arrays.asList( list2);		
		boolean equal = (duplicatesActual.size() == 3) && duplicatesActual.containsAll(duplicatesExpected) && duplicatesExpected.containsAll(duplicatesActual); 
		assertTrue(equal, "ReturnUniqueDuplicate does not correctly return all the duplicated elements.");
	}

}
