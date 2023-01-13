package Lab9;
import java.util.List;
import java.util.ArrayList;

/**
 * This class contains a number of methods that 
 * works on a wide range of data types. 
 */

/* This is a parameterized class. You should decide 
* what the parameter should look like in order to 
* pass all the test cases. 
*/

// you might want to change the parameter of this class to something more appropriate. 
public class Utility <T> {
	
	// Insert the code here. 
	public List<T> list;
	
	public Utility() {
		this.list = new ArrayList<T>();
	}
	
	public Utility(List<T> mylist) {
		this.list = new ArrayList<T>(mylist);
	}
	
	public <T extends Comparable> int linearSearch(T item) {
		int position = -1;
		for (int i = 0; i < list.size(); i++) {
			if (item.compareTo(list.get(i)) == 0) {
				position = i;
				break;
			}
		}
		return position;
	}
	
	public void mergeList(List<? super T> list) {
		for (T obj : this.list) {
			list.add(obj);
		}
	}
	
	public boolean containList(List<T> list) {
		if (this.list.containsAll(list)) {
			this.list = new ArrayList<T>();
			for (T obj : list) {
				this.list.add(obj);
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void removeZero (List<? extends MyInteger> myList) {
		for (int i = 0; i < myList.size(); i++) {
			if (MyInteger.isZero(myList.get(i))) {
				myList.remove(i);
				i--;
			}
		}
	}

}


/**
 * This class implements a 2D points. 
 */
class Point implements Comparable<Point>{
	double x; 
	double y; 
	public Point(double x, double y) {
		this.x = x; 
		this.y = y;
	}
	@Override 
	public int compareTo(Point p) {
		if (this.x == p.x && this.y == p.y) return 0;
		else if (this.x == p.x) return 1;
		else return -1;	
	}
}

/**
 * This class represents an Integer number. 
 */
class MyInteger implements Comparable<MyInteger>{
	int x; 
	public MyInteger() {
		this.x = 0; 
	}
	public MyInteger(int x) {
		this.x = x; 
	}
	public static boolean isZero(MyInteger input) {
		return input.x == 0; 
	}
	@Override
	public int compareTo(MyInteger input) {
		if (this.x == input.x ) return 0;
		else if (this.x < input.x) return -1;
		else return 1;	
	}
}
/**
 * This class represents a subset of integer numbers that are natural numbers. 
 */
class NaturalNumber extends MyInteger{
	public NaturalNumber(int x) {
		super(x);
	}
}
/**
 * This class represents the odd natural numbers. 
 */

class OddNumber extends NaturalNumber{
	public OddNumber(int x) {
		super(x);
	}
	
}
/**
 * This class represents the even natural numbers. 
 */
class EvenNumber extends NaturalNumber{
	public EvenNumber(int x) {
		super(x);
	}
}