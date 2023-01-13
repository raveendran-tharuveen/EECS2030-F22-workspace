package Lab10;
import java.util.*;
/**
 * This class contains several utilities that 
 * should be implemented using libraries available in 
 * Java
 */
public class FinalLab {
	/**
	 * This method removes the duplicate items in a list.
	 * @param list is an <code> arrayList </code> containing integers. 
	 * @return a set containing unique elements of <code> list </code> is returned.
	 */
	public static Set<Integer> removeDuplicate1 (Integer[] list ){
		// Insert your code here. You may want to change the return value. 
		
		Set<Integer> newlist = new HashSet<Integer>();
		
		for (Integer listvalue : list) {
			if(!newlist.contains(listvalue)) {
				newlist.add(listvalue);
			}
		}
		return newlist; 
		
	}
	/**
	 * This method removes the duplicates from the given list.
	 * @param list is an array of Integer.
	 * @return it returns a list that has no duplicate elements. 
	 */
	public static Integer[] removeDuplicate2 (Integer[] list ){
		// Insert your code here. You may want to change the return value. 
		int index = 1;	
		
		for (int i = 1; i < list.length; i++) {
	         int element = list[i];
	         
	         for (int j = 0; j < index; j++) {
	            if(list[j] == element) {
	               break;
	            }
	            	            
	            if(j == index-1) {
	               list[index++] = element;	              
	               break;
	            }
	         }
		}
		return Arrays.copyOf(list, index); 
	}
	
	/**
	 * This method finds all the duplicates elements and return them.
	 * example: <code> list = {1,2,2}</code> return=<code>{2,2}</code>
	 * @param list is a list of integers.
	 * @return returns a list of all duplicates but in a form of an array of Object.
	 */
	public static Object[] returnDuplicate1 (Integer[] list ){
		// Insert your code here. You may want to change the return value. 
		
		
		List<Object> duplicatedlist = new ArrayList<Object>();
		Set<Integer> noduplicates = new HashSet<Integer>();
		
		noduplicates = removeDuplicate1(list);
		duplicatedlist.addAll(Arrays.asList(list));
		
		for(Integer obj : noduplicates) {
			if (noduplicates.contains(obj)) {
				duplicatedlist.remove(obj);
			}
		}
		
		Object[] newlist = duplicatedlist.toArray();
		
		return newlist; 
	}
	
	/**
	 * This method finds all the duplicates elements and return them.
	 * example: <code> list = {1,1,2,2,2}</code> return=<code>{1,2,2}</code>
	 * @param list is a list of integers.
	 * @return returns a list of all duplicates.
	 */
	
	public static Integer[] returnDuplicate2 (Integer[] list ){
		// Insert your code here. You may want to change the return value. 
		
		List<Object> duplicatedlist = new ArrayList<Object>();
		Set<Integer> noduplicates = new HashSet<Integer>();
		
		noduplicates = removeDuplicate1(list);
		duplicatedlist.addAll(Arrays.asList(list));
		
		for(Integer obj : noduplicates) {
			if (noduplicates.contains(obj)) {
				duplicatedlist.remove(obj);
			}
		}
		
		Integer[] newlist = new Integer[duplicatedlist.size()];
		duplicatedlist.toArray(newlist);
		return newlist; 
	}
	
	/**
	 * This method finds all the duplicates elements and return them.
	 * example: <code> list = {1,1,2,2,2}</code> return=<code>{1,2}</code>
	 * @param list is a list of integers.
	 * @return returns a list of all unique duplicates.
	 */
	public static Integer[] returnUniqueDuplicate (Integer[] list ){
		// Insert your code here. You may want to change the return value. 
		
		return removeDuplicate2(returnDuplicate2(list)); 
	}

}
