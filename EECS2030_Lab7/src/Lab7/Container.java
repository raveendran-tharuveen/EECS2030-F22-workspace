package Lab7;

import java.util.*;
import java.io.*;
/**
 * This class is a container that holds an unlimited number of 
 * String objects. It is able to remove objects and add objects.
 */

public class Container {
	// No instance variable should be defined for this class. 


	/**
	 * Reads the given file and add it into a list. 
	 * Each element of the list contains one line of the file. 
	 * @param fileName is the name of the file that is read in this method. 
	 */

	public static final List<String> readFile(String fileName) {
		// add your code here. You may change the return value.
		List<String> fileList = new ArrayList<String>();		
		try {
			File file = new File(fileName);
			Scanner scan = new Scanner(file);
			while (scan.hasNext()) {
				fileList.add(scan.nextLine());
			}
			scan.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileList;
		
	}
		
	/**
	 * This method adds the <code> obj </code> to the container.
	 * @param obj is the object that is added to the container.
	 */
	
	void add(Object object) {
		// insert your code here
	}

	/**
	 * This method removes the object from the container
	 * @return returns the removed object.
	 */
	Object remove() {
		// insert your code here, you may want to change the return value
		return null; 
	}

	/**
	 * @return It returns the number of elements in the container.
	 */
	int getSize() {
		// insert your code here. You may want to change the return value. 
		return 0;
	}

}

/**
 * 
 * This class simulates a Queue, which is a data structure that insert and remove data 
 * by FIFO (first-in, first-out) rule
 *
 */
class Queue extends Container{
	ArrayList<String> queue; 
	/**
	 * This is the constructor that initializes the <code> queue </code>
	 * with all the strings in the <code> fileName </code> that is labeled 
	 * by "Queue"
	 * @param fileName is the name of the file that is read.  
	 */
	public Queue(String fileName) {
		// insert your code here
		this.queue = new ArrayList<String>();
		try {
			File file = new File(fileName);
			Scanner scan = new Scanner(file);
			ArrayList<String> newQueue = new ArrayList<String>();
			while (scan.hasNext()) {
				newQueue.add(scan.nextLine());					
			}			
			
			for (int i = 0; i < newQueue.size(); i++) {			
				String noSpaces = newQueue.get(i).replace(" ", "");
				
				if (newQueue.get(i).charAt(0) == 'Q' || newQueue.get(i).charAt(0) == 'q') {
					this.queue.add(noSpaces.substring(5));
				}
			}
			scan.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		
		
		

	
	}
	
	/**
	 * This method adds the object into the Queue. 
	 * Please note that the rule of the queue insertion/removal is 
	 * First in, First out. 
	 * @param obj is the object that is added to the queue. 
	 */
	@Override
	public void add(Object obj) {
		// insert your code here
		this.queue.add((String)obj);
		
	}
	/**
	 * This method removes an object from the Queue. 
	 * Please note that the rule of the queue insertion/removal is 
	 * First in, First out. 
	 */
	@Override
	public Object remove() {
		// insert your code here. You may want to change the return value. 
		return this.queue.remove(0);
	}
	/**
	 * @return returns the object which is in front of the queue.
	 */
	public Object top() {
		// insert your code here. You may want to change the return value. 
		return this.queue.get(0);
	}
	
	/**
	 * Returns the number of items in the queue.
	 */
	@Override 
	public int getSize(){
		// insert your code here. You may want to change the return value. 
		return this.queue.size();
	}
}

/**
 * 
 * This class simulates a Stack, which is a data structure that insert and remove data 
 * by FILO (first-in, last-out) rule
 *
 */
class Stack extends Container{
	ArrayList<String> stack; 
	
	/**
	 * This is the constructor that initializes the <code> stack </code>
	 * with all the strings in the <code> fileName </code> that is labeled 
	 * by "Stack"
	 * @param fileName is the name of the file that is read.  
	 */
	public Stack(String fileName) {
		this.stack = new ArrayList<String>();
		try {
			File file = new File(fileName);
			Scanner scan = new Scanner(file);
			ArrayList<String> newStack = new ArrayList<String>();
			while (scan.hasNext()) {
				newStack.add(scan.nextLine());					

			}			
			
			for (int i = 0; i < newStack.size(); i++) {			
				String noSpaces = newStack.get(i).replace(" ", "");
				
				if (newStack.get(i).charAt(0) == 'S' || newStack.get(i).charAt(0) == 's') {
					this.stack.add(noSpaces.substring(5));
				}
			}
			scan.close();	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		// insert your code here.  
	}
	/**
	 * This method removes an object from the stack. 
	 * Please note that the rule of the stack insertion/removal is 
	 * First in, Last out. 
	 */

	@Override
	public void add(Object obj) {
		// insert your code here. 
		stack.add((String) obj);
	}
	
	/**
	 * This method removes an object from the stack. 
	 * Please note that the rule of the stack insertion/removal is 
	 * First in, Last out. 
	 */

	@Override
	public Object remove() {
		// insert your code here. You may want to change the return value. 
		return stack.remove(stack.size()-1);
	}
	/**
	 * @return returns the object which is on top of the stack.
	 */
	
	public Object top() {
		// insert your code here. You may want to change the return value. 
		return stack.get(stack.size()-1);
	}
	/**
	 * Returns the number of items in the stack.
	 */
	@Override 
	public int getSize() {
		// insert your code here. You may want to change the return value. 
		return stack.size();
	}
}