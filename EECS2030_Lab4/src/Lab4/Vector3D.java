package Lab4;


/**
 * This class defines a 3D vector
 * @author EECS2030 
 *
 */
public class Vector3D {
	// define instance variables here 
	private double x;
	private double y;
	private double z;
	
	/**
     * Creates the vector <code>(0.0, 0.0, 0.0)</code>.
     * This is the default constructor.
     */
    public Vector3D() {
    	// insert your code here 
    	this.x = 0.0;
    	this.y = 0.0;
    	this.z = 0.0;
     }

    /**
     * Creates the vector <code>(x, y, z)</code>.
     * @param x is the x-component of the vector       
     * @param y is the y-component of the vector
     * @param z is the z-component of the vector        
     */
    public Vector3D(double x, double y, double z) {       
       	// insert your code here 
    	this.x = x;
    	this.y = y;
    	this.z = z;
    }

    /**
     * Creates a vector with the same components as another vector.
     * This is the copy constructor.
     * @param other  is a vector used to copy the components from
     */
    public Vector3D(Vector3D other) {
       	// insert your code here 
    	this.x = other.x;
    	this.y = other.y;
    	this.z = other.z;
      }

    /**
     * Returns the x component of the vector.
     * @return the x component of the vector.
     */
    public double getX() {
       	// insert your code here 
    	// you may want to change the return value
    	return this.x;
     }

    /**
     * Sets the x component of the vector.
     * @param x the new value of the x component.
     */
    public void setX(double x) {
       	// insert your code here 
    	this.x = x;
    }

    /**
     * Returns the y component of the vector.
     * @return the y component of the vector.
     */
    public double getY() {
       	// insert your code here 
    	// you may want to change the return value
    	return this.y; 
     }
    /**
     * Sets the y component of the vector.
     * @param y the new value of the y component.
     */
    public void setY(double y) {
       	// insert your code here 
    	this.y = y;
     }
    /**
     * Returns the z component of the vector.
     * @return the z component of the vector.
     */
    public double getZ() {
       	// insert your code here 
    	// you may want to change the return value
    	return this.z; 
    }

    /**
     * Sets the z component of the vector.
     * @param z the new value of the z component.
     */
    public void setZ(double z) {
       	// insert your code here 
    	this.z = z;
    }
 

    /**
     * Adds a vector to this vector and changes the components of this vector.
     * To add, the counterpart components are added together.
     * @param other is the vector that is added to this vector.
     * @return the current <code>Vector3D</code> object
     */
    public Vector3D add(Vector3D other) {
       	// insert your code here 
      	// you may want to change the return value
    	this.x = this.x + other.x;
    	this.y = this.y + other.y;
    	this.z = this.z + other.z;
    	
    	
    	return this; 
    }


    /**
     * Subtracts a vector from this vector and changes the components of this vector.
     * To subtract, the counterpart components are subtracted.
     * @param other is the vector that is subtracted from this vector.
     * @return this <code>Vector3D</code> object
     */
    public Vector3D subtract(Vector3D other) {
       	// insert your code here 
      	// you may want to change the return value
    	this.x = this.x - other.x;
    	this.y = this.y - other.y;
    	this.z = this.z - other.z;
    	
    	return this;
    }
    /**
     * Multiplies this vector by a scalar.
     * @param scalar is the scalar that is multiplied by this vector
     * @return this vector after multiplication
     */
    public Vector3D scalarMultiplication(double scalar) {
       	// insert your code here 
      	// you may want to change the return value
    	this.x = this.x*scalar;
    	this.y = this.y*scalar;
    	this.z = this.z*scalar;
    	
    	return this;
    }

    /**
     * computes the DOT product of this vector and the given vector
     * @param other is the given vector, whose DOT product with this vector is given
     * @return the DOT product of this and the other vector.
     */
    public  double dotProduct(Vector3D other) {        
       	// insert your code here 
       	// you may want to change the return value
    	this.x = this.x*other.x;
    	this.y = this.y*other.y;
    	this.z = this.z*other.z;
    	double sum = this.x + this.y + this.z;
    	return sum; 
   }
    

    /**
     * Computes the magnitude of this vector.
     * @return the magnitude of this vector.
     */
    public double magnitude() {
       	// insert your code here 
     	// you may want to change the return value
    	this.x = this.x*this.x;
    	this.y = this.y*this.y;
    	this.z = this.z*this.z;
    	double sum = Math.sqrt(this.x+this.y+this.z);
    	return sum; 
    	
    }

    /**
     * Returns a string representation of the vector as [x, y, z], 
     * where x, y and z are teh components of teh vector. 
     * @return a string representation of the vector
     */
    @Override
    public String toString() {
       	// insert your code here 
   	// you may want to change the return value
    	String vectorstring = "[" + this.x + ", " + this.y + ", " + this.z + "]";
    	
    	return vectorstring; 
    	
     }

    /**
     * Determines if the difference between the magnitude of this vector and the other vector
     * is smaller than the given threshold.  
     * @param other the other vector that is compared with this vector
     * @param threshold a positive double, which shows the accepted magnitude difference between the two vectors
     * @return <code>true</code> if the difference between magnitude of the 
     * two vectors is less than <code> threshold</code> and <code>false</code> otherwise
     */
    public boolean equalTo(Vector3D other, double threshold) {
       	// insert your code here 
   	// you may want to change the return value 
    	if ((this.magnitude() - other.magnitude()) < threshold) {
    		return true;
    	}
    	else {
    		return false;
    	}
    	
        
    }
    	
}
