package PE2;

import java.util.*;
/* PLEASE DO NOT MODIFY A SINGLE STATEMENT IN THE TEXT BELOW.
READ THE FOLLOWING CAREFULLY AND FILL IN THE GAPS

I hereby declare that all the work that was required to 
solve the following problem including designing the algorithms
and writing the code below, is solely my own and that I received
no help in creating this solution and I have not discussed my solution 
with anybody. I affirm that I have read and understood
the Senate Policy on Academic honesty at 
https://secretariat-policies.info.yorku.ca/policies/academic-honesty-senate-policy-on/
and I am well aware of the seriousness of the matter and the penalties that I will face as a 
result of committing plagiarism in this assignment.

BY FILLING THE GAPS,YOU ARE SIGNING THE ABOVE STATEMENTS.

Full Name: Tharuveen Raveendran
Student Number: 217863986
Course Section: E
*/

public class CSD {
	protected ChairPerson chair; //This is the ChairPerson object
	protected Faculty faculty; //This is the Faculty object
	protected UGrad uGrads; //This is the UGrad object
	protected Grad gradStudents; //This is the Grad object
	protected ProgramDirector progDirector; //This is the ProgramDirector object
	
	private List<Faculty> facultylist = new ArrayList<>(); // This is the List of Faculty members
	private int faculty_members; // This is a counter to check how many faculty members we have
	private List<UGrad> undergradlist = new ArrayList<>(); // This is the List of undergrads
	private int undergrads; // A counter to check the number of undergrads
	private List<Grad> gradlist = new ArrayList<>(); // This is the List of grad students
	private int gradstudents; // A counter to check the number of grad students
	private List<ProgramDirector> ProgDirectors = new ArrayList<>(); // A list that will contain the ProgramDirectors
	
	private List<Faculty> CompSci_faculty = new ArrayList<>(); // A list specified for Computer Science Faculty members
	private List<Faculty> SoftEng_faculty = new ArrayList<>(); // A list specified for Software Engineering Faculty members
	private List<Faculty> DigTech_faculty = new ArrayList<>(); // A list specified for Digital Technology Faculty members
	
	
	
	static class Person {
		protected String fname; // This is the first name of our Person
		protected String lname; // This is the last name of our Person
		protected int age; // This is the age of our Person
		protected String gender; // This is the gender of our Person
		protected String address; // This is the address of our Person
		
		/**
		 * This is the Person class constructor that takes the initial params for the other classes in the inheritance
		 * @param first
		 * @param last
		 * @param age1
		 * @param gender1
		 * @param address1
		 */
		public Person(String first, String last, int age1, String gender1, String address1) {
			this.fname = first;
			this.lname = last;
			this.age = age1;
			this.gender = gender1;
			this.address = address1;
		}
	}
	
	static class Academics extends Person{
		protected static int ID = 100; // This is the count for the employee ID that will be used amongst ChairPerson and Faculty
		
		public Academics(String first, String last, int age1, String gender1, String address1) {
			super(first, last, age1, gender1, address1); //The super is used in order for me to call the parameters from the parent class
		}
	}
	
	static class Administrator extends Academics {
		
		public Administrator(String first, String last, int age1, String gender1, String address1) {
			super(first, last, age1, gender1, address1);
		}
	}
	
	static class Faculty extends Academics {
		private String program; // This is the program that the Faculty is in 
		private double salary; // This is the salary of the Faculty member
		private int faculty_ID; // This is the specific Faculty member ID number
		private List<UGrad> UGrads = new ArrayList<>(); // This is the List of advising undergrads
		private List<Grad> Grads = new ArrayList<>(); // This is the List of TAs 
		private int retiredUGrads; // This is the counter used to check how many graduated undergrads
		private int retiredTAs; // This is the counter used to check how many graduated TAs
		
		public Faculty(String first, String last, int age1, String gender1, String address1) {
			super(first, last, age1, gender1, address1);
			this.faculty_ID = ID; // This is to keep the ID number saved from before
			ID++; // This will increment the ID when a Faculty member joins
		}
		/**
		 * This method is the getter for the employee ID
		 * @return This will return the Faculty members ID when called upon
		 */
		public int getEmployeeID() {
			return this.faculty_ID;
		}
		/**
		 * This is the getter method for the employee salary
		 * @return This will return the salary of the Faculty member
		 */
		public double getSalary() {
			return this.salary;
		}
		/**
		 * This is the setter method that will set the salary of the employee when used
		 * @param newSalary
		 */
		public void setSalary(double newSalary) {
			this.salary = newSalary;
		}
		/**
		 * This is the getter method that will get the specific program of the Faculty member
		 * @return This will return the program of the Faculty member
		 */
		public String getProgram() {
			return this.program;
		}
		/**
		 * This is the setter method for the program in which it will set the specific program for the member
		 * @param newProgram
		 */
		public void setProgram(String newProgram) {
			this.program = newProgram;
		}
		/**
		 * This is the toString method that will output the information about the Faculty
		 * @return The string mentioning the Faculty's information
		 */
		public String toString() {
			return ("Faculty " + this.program + "[[" + this.faculty_ID + ", " + this.salary + "["
					+ this.fname + ", " + this.lname + ", " + this.age + ", " + this.gender + ", "
					+ this.address + "]]]");
		}
		/**
		 * This getter method will grab the list of advising undergrads for the faculty
		 * @return A list of undergrads that need advising
		 */
		public List<UGrad> getAdvisingUgrads() {
			return this.UGrads;
		}
		/**
		 * This method is a setter for the advising undergrads which takes the undergrad list and sets it to this list
		 * @param undergradlist
		 */
		public void setUGradList(List<UGrad> undergradlist) {
			this.UGrads = undergradlist;
		}
		/**
		 * This getter method will grab the grad list which are TAs in the Faculty class
		 * @return This will return the grads list in this class which are TAs
		 */
		public List<Grad> getTAs() {		
			return this.Grads;
		}
		/**
		 * This is the setter method which will set the gradlist from CSD to the TA grad list in this class
		 * @param gradlist
		 */
		public void setTAs(List<Grad> gradlist) {
			this.Grads = gradlist;
		}
		/**
		 * This is a getter for the number of graduated undergrads
		 * @return A integer of how many retired undergrads
		 */
		public int getNumOfAdvisingUGrads() {
			return this.retiredUGrads;
		}
		/**
		 * This is a setter which will set the number when someone graduating
		 * @param retired
		 */
		public void setNumOfAdvisingUGrads(int retired) {
			this.retiredUGrads = retired;
		}
		/**
		 * This is a getter for the number of graduated TAs
		 * @return A integer of how many graduated/retired TAs
		 */
		public int getNumOfTAs() {
			return this.retiredTAs;
		}
		/**
		 * This is a setter that will set the number when someone is retiring from TA position
		 * @param retired
		 */
		public void setNumOfTAs(int retired) {
			this.retiredTAs = retired;
		}
		
	}
	
	static class ChairPerson extends Administrator{
		private double salary; // This is the salary for the ChairPerson
		private int chairperson_ID; // This is the specific ID for the ChairPerson
		
		public ChairPerson(String first, String last, int age1, String gender1, String address1) {
			super(first, last, age1, gender1, address1);
			this.chairperson_ID = ID; // This is to keep the ID number saved from before
			ID++; // This will increment the ID when a ChairPerson member joins
		}
		
		public int getEmployeeID() {
			return this.chairperson_ID;
		}
		
		public double getSalary() {
			return this.salary;
		}
		
		public void setSalary(double newSalary) {
			this.salary = newSalary;
		}
		
		public String toString() {
			return ("Chair Person [[[" + this.chairperson_ID + ", " + this.salary + "["
					+ this.fname + ", " + this.lname + ", " + this.age + ", " + this.gender + ", "
					+ this.address + "]]]]");
		}
	}
	
	static class ProgramDirector extends Administrator{
		private double salary;
		private String program;
		
		public ProgramDirector(String first, String last, int age1, String gender1, String address1) {
			super(first, last, age1, gender1, address1);
		}
		
		public int getEmployeeID() {
			return ID;
		}
		
		public double getSalary() {
			return this.salary;
		}
		
		public void setSalary(double newSalary) {
			this.salary = newSalary;
		}
		
		public String getProgram() {
			return this.program;
		}
		
		public void setProgram(String program) {
			this.program = program;
		}
	}
	
	static class Student extends Person{
		protected static int studentID = 1000; //This is the student ID counter that will be shared amongst undergrads and grads
		
		public Student(String first, String last, int age1, String gender1, String address1) {
			super(first, last, age1, gender1, address1);
		}
		
	}
	
	static class UGrad extends Student{
		private int UGrad_ID; // This is a counter used specifically for undergrads and to be added when a undergrad joins
		private Faculty advisor; // This is the Faculty advisor
		
		public UGrad(String first, String last, int age1, String gender1, String address1) {
			super(first, last, age1, gender1, address1);
			this.UGrad_ID = studentID; // This is to keep the ID number saved from before
			studentID++; // This will increment the ID when a undergrad joins
		}
		
		public String toString() {
			return ("Undergraduate [" + this.UGrad_ID + "[[" + this.fname + ", " + this.lname + ", " + this.age
					+ ", " + this.gender + ", " + this.address + "]]]");
		}
		/**
		 * This is a getter method that will grab the advisor for the specific undergrad
		 * @return This will return a Faculty object for the undergrad student
		 */
		public Faculty getAdvisor() {
			return this.advisor;
		}
		/**
		 * This is a setter that will set the specific Faculty member for the undergrad
		 * @param faculty
		 */
		public void setAdvisor(Faculty faculty) {
			this.advisor = faculty;
		}
	}
	
	static class Grad extends Student{
		private int Grad_ID; // This is a counter specifically for the grads when a new grad joins
		private Faculty advisor;
		
		public Grad(String first, String last, int age1, String gender1, String address1) {
			super(first, last, age1, gender1, address1);
			this.Grad_ID = studentID; // This is to keep the ID number saved from before
			studentID++; // This will increment the ID when a grad joins
		}
		
		public String toString() {
			return ("Graduate [" + this.Grad_ID + "[[" + this.fname + ", " + this.lname + ", " + this.age
					+ ", " + this.gender + ", " + this.address + "]]]");
		}

		public Faculty getAdvisor() {
			return this.advisor;
		}
		
		public void setAdvisor(Faculty faculty) {
			this.advisor = faculty;
		}
	}
	//This is to initialize the ChairPerson object that we set up in the CSD class
	public CSD(ChairPerson chair) {
		this.chair = chair;
	}
	// This is a getter method that will grab the ChairPerson object from the CSD class
	public ChairPerson getChairPerson() {
		return this.chair;
	}
	// This is to initialize the Faculty object that we set up in the CSD class 
	public CSD(Faculty faculty) {
		this.faculty = faculty;
	}
	// This is to initialize the UGrad object that we set up in the CSD class
	public CSD(UGrad undergrad) {
		this.uGrads = undergrad;
	}
	/**
	 * This method will allow the CSD to hire a Faculty member 
	 * @param faculty
	 * @throws NoSpaceException
	 */
	public void HireFaculty(Faculty faculty) throws NoSpaceException{
		// This will check to see if the size of the faculty list is greater than
		// 70 and if yes, it will throw the NoSpaceException as there is no space to add someone
		if (this.facultylist.size() > 70) {
			throw new NoSpaceException("No space");
		}
		// This will check if the faculty list contains the faculty member that wants to be 
		// added and if yes, it will return nothing
		if (this.facultylist.contains(faculty) ) {
			return;
		}
		this.facultylist.add(faculty); // This will add a faculty member to the list if he is not there already
		this.faculty_members++; // This will increment the counter of how many Faculty members we have
		this.faculty = faculty; // This will initialize the current Faculty member to the CSD Faculty object
		
		// This is a nested if statement which will add the Faculty member to its specific program 
		// whether that be Computer Science, Software Engineering, Digital Technology
		if(this.faculty.getProgram() != null) {
			if(this.faculty.getProgram().equals("Computer Science")) {
				this.CompSci_faculty.add(faculty); // This will add the faculty member to the Comp Sci faculty list
			}
			if(this.faculty.getProgram().equals("Software Engineering")) {
				this.SoftEng_faculty.add(faculty); // This will add the faculty member to the Soft Eng faculty list
			}
			if(this.faculty.getProgram().equals("Digital Technology")) {
				this.DigTech_faculty.add(faculty); // This will add the faculty member to the Dig Tech faculty list
			}
		}
	}
	// This getter method will grab the CSD faculty list
	public List<Faculty> getFaculty() {
		return this.facultylist;
	}
	//This getter method will grab the number of faculty members in the CSD
	public int getNumOfFaculty() {
		return this.faculty_members;
	}
	
	/**
	 * This method will admit the undergrad student into the CSD department
	 * @param undergrad
	 * @throws NoSpaceException
	 */
	public void AdmitStudent(UGrad undergrad) throws NoSpaceException{
		// This will check to see if the size of the undergrad list is greater than
		// 500 and if yes, it will throw the NoSpaceException as there is no space to add someone
		if (this.undergradlist.size() > 500) {
			throw new NoSpaceException("No space");
		}
		// This is a for loop that will check each faculty member in the faculty list
		for (Faculty faculty: this.facultylist) {
			if (faculty.UGrads.size() < 8) { // This will check if the faculty's undergrad list is less than 8 which are the adivising undergrads
				this.faculty = faculty; // This will initialize the current faculty member to the CSD Faculty object
				break;
			}
		}
		// This if statement will check if the faculty members advising undergrads list has the current undergrad in it
		if (!this.faculty.getAdvisingUgrads().contains(undergrad)) {
			this.faculty.UGrads.add(undergrad); // If not, this will add the undergrad to that specific faculty list
			this.undergradlist.add(undergrad); // This will also add the undergrad to the general undergrad list in the CSD department
			this.undergrads++; // This will increment the number of undergrads in the CSD department when someone joins
			undergrad.setAdvisor(this.faculty); // This will set the advisor for the current undergrad to the current faculty member that has space
		}
	}
	// This getter will grab the undergrad list from the CSD list
	public List<UGrad> getUGrad() {
		return this.undergradlist;
	}
	// This will grab the number of the undergrads 
	public int getNumOfUGradStudents() {
		return this.undergrads;
	}
	/**
	 * This method will hire a grad student as a TA in the CSD department
	 * @param gradstudent
	 * @throws NoSpaceException
	 */
	public void HireTA(Grad gradstudent) throws NoSpaceException{
		// This will check to see if the size of the grad list is greater than
		// 150 and if yes, it will throw the NoSpaceException as there is no space to add someone
		if (this.gradlist.size() > 150) {
			throw new NoSpaceException("No space");
		}
		// This will check if the grad list contains the undergrad and if not, it will go through whats inside the if statement
		if(!this.gradlist.contains(gradstudent)) {
			// This is a for loop that will check each faculty member in the faculty list
			for (Faculty faculty: this.facultylist) { 
				if (faculty.Grads.size() < 5) { // This will check if the faculty's grad list is less than 8 which are the TAs
					this.faculty = faculty; // This will initialize the current faculty member to the CSD Faculty object
					break;
				}
			}
			this.faculty.Grads.add(gradstudent); // This will add the grad student to the current faculty grad list
			this.gradlist.add(gradstudent); // This will add the grad student to the main grad list in the CSD class
			this.gradstudents++; // This will increment the counter for the number of grad students
			this.faculty.setNumOfTAs(this.gradstudents); // This will set the number of TAs to the Faculty class
			gradstudent.setAdvisor(this.faculty); // This will set the grad student as a TA to the current faculty member	
		}
	}
	// This getter will grab the grad list from the CSD class
	public List<Grad> getGrad() {
		return this.gradlist;
	}
	// This getter will grab the number of grad students in the CSD department
	public int getNumOfGradStudents() {
		return this.gradstudents;
	}
	/**
	 * This method is when an undergrad graduates and needs to be removed from the department
	 * @param undergrad
	 */
	public void AlumnusUGrad(UGrad undergrad) {
		if (this.faculty.getAdvisingUgrads().contains(undergrad)) { // This if statement will check if the Faculty's undergrad list has the undergrad
			this.faculty.UGrads.remove(undergrad); // If yes, it will remove the specific undergrad from that list 
			this.undergradlist.remove(undergrad); // This will remove the undergrad from the undergrad list in the CSD department
			this.undergrads--; // This will decrement the counter for the number of undergrads in the department
			this.faculty.setNumOfAdvisingUGrads(this.undergrads); // This will set the new number of advising undergrads as someone graduates
		}
	}
	/**
	 * This method is when a grad student graduates and needs to removed from the department
	 * @param gradstudent
	 * @throws NoTAException
	 */
	public void AlumnusGrad(Grad gradstudent) throws NoTAException {
		if (this.faculty.getTAs().contains(gradstudent)) { // This if statement will check if the Faculty's grad list has the grad student
			this.faculty.Grads.remove(gradstudent); // If yes, it will remove the specific grad student from that list
			this.gradlist.remove(gradstudent); // This will remove the grad student from the grad list in the CSD department
			this.gradstudents--; // This will decrement the counter for the number of grad students in the department
			this.faculty.setNumOfTAs(this.gradstudents); // This will set the new number of TAs as someone graduates
		}
		if (this.faculty.Grads.size() == 0) { // This if statement will check if the Faculty's grad list is equal, meaning that there is nobody
			throw new NoTAException("No TAs available"); // This will throw that exception if there is nobody to take the TA exception
		}
		
	}
	// This method will sort the grad list and alphabetize them in the grad list based on the first name
	public List<Grad> ExtractAllGradDetails() {
		// This is the collections sort method which would take the grad list and compare the first name of each grad to sort them alphabetically
		Collections.sort(this.gradlist, (firstgrad,nextgrad)->firstgrad.fname.compareTo(nextgrad.fname)); 
		return this.gradlist; // This will return the grad list after it is sorted
	}
	// This method will sort the undergrad list and alphabetize them in the undergrad list based on the first name
	public List<UGrad> ExtractAllUGradDetails() {
		Collections.sort(this.undergradlist, (firstUGrad,nextUGrad)->firstUGrad.fname.compareTo(nextUGrad.fname));
		return this.undergradlist;
	}
	// This method will sort the faculty list and alphabetize them in the faculty list based on the first name
	public List<Faculty> ExtractAllFacultyDetails() {
		Collections.sort(this.facultylist, (firstfaculty, nextfaculty)->firstfaculty.fname.compareTo(nextfaculty.fname));
		return this.facultylist;
	}
	// This method will sort the faculty list based on their program and then alphabetize them
	public List<Faculty> ExtractFacultyDetails(String program) {
		//This will check if the Faculty is under the Computer Science program before sorting
		if(program.equals("Computer Science") ) {
			Collections.sort(this.CompSci_faculty, (firstCompSci, nextCompSci)->firstCompSci.fname.compareTo(nextCompSci.fname));
			return this.CompSci_faculty;
		}
		//This will check if the Faculty is under the Software Engineering program before sorting
		if(program.equals("Software Engineering") ) {
			Collections.sort(this.SoftEng_faculty, (firstSoftEng, nextSoftEng)->firstSoftEng.fname.compareTo(nextSoftEng.fname));
			return this.SoftEng_faculty;
		} 
		//This will check if the Faculty is under the Digital Technology program before sorting
		if(program.equals("Digital Technology") ) {
			Collections.sort(this.DigTech_faculty, (firstDigTech, nextDigTech)->firstDigTech.fname.compareTo(nextDigTech.fname));
			return this.DigTech_faculty;
		}
		return null;
	}
	// This method will sort the undergrad list in the faculty class and alphabetize them based on the first name
	public List<UGrad> ExtractAdviseesDetails(Faculty faculty) {
		Collections.sort(faculty.UGrads, (firstadvisor, nextadvisor)->firstadvisor.fname.compareTo(nextadvisor.fname));
		return faculty.UGrads;
	}
	// This method will sort the grad list in the faculty class and alphabetize them based on the first name
	public List<Grad> ExtractTAsDetails(Faculty faculty) {
		Collections.sort(faculty.Grads, (firstTA, nextTA)->firstTA.fname.compareTo(nextTA.fname));
		return faculty.Grads;
	}
	// This method will add ProgramDirector to the list in the CSD department
	public void addProgramDirector(ProgramDirector progDirector) {
		this.ProgDirectors.add(progDirector);
	}

	/**
	 * This method will retire a Faculty member and remove them from the department 
	 * @param faculty
	 * @throws NoSpaceException
	 * @throws NoSpecialtyException
	 */
	public void RetireFaculty(Faculty faculty) throws NoSpaceException, NoSpecialtyException{
		this.facultylist.remove(faculty); // This will remove the faculty member from the faculty list in the CSD class
		
		// This will check the program of the faculty member and remove him from the specific program faculty list
		if(faculty.program.equals("Computer Science")) {
			if(this.CompSci_faculty.size()  > 1) { // if the size of the specific list is greater than zero
				this.CompSci_faculty.remove(faculty); // This will remove the faculty member from that specific faculty
			}
			else {
				throw new NoSpecialtyException("No Comp Sci profs"); // if not, then it will throw an exception saying there is no faculty member for that program
			}
		}
		// This will check the program of the faculty member and remove him from the specific program faculty list
		if(faculty.program.equals("Software Engineering")) {
			if(this.SoftEng_faculty.size() > 1) {
				this.SoftEng_faculty.remove(faculty);
			}
			else {
				throw new NoSpecialtyException("No Soft Eng profs");
			}
		}
		// This will check the program of the faculty member and remove him from the specific program faculty list
		if(faculty.program.equals("Digital Technology")) {
			if(this.DigTech_faculty.size() > 1) {
				this.DigTech_faculty.remove(faculty);
			}
			else {
				throw new NoSpecialtyException("No Dig Tech profs");
			}
		}
		// This will check if the main faculty list in the CSD department is zero and throw the exception
		if (this.facultylist.size() == 0) {
			throw new NoSpecialtyException("No Faculty members");
		}
		// This for loop will go through the faculty class grad list
		for(Grad grad: faculty.Grads) {
			this.gradlist.remove(grad); //This will remove the grad from that list as the faculty member is no longer there
			HireTA(grad); //This will hire the new grad as a TA under another faculty member
		}
		// This for loop will go through the faculty class undergrad list
		for(UGrad undergrad: faculty.UGrads) {
			this.undergradlist.remove(undergrad); // This will remove the undergrad from that list as the faculty member can not be their advisor anymore
			AdmitStudent(undergrad); // This will send the undergrad through the admit student method to allow them to get a new advisor
		}
	}
}


class NoSpaceException extends Exception{
	public NoSpaceException() {
		super();
	}
	public NoSpaceException(String s) {
		super(s);
	}
}


class NoTAException extends Exception {
	public NoTAException() {
		super();
	}
	public NoTAException(String s) {
		super(s);
	}
}


class NoSpecialtyException extends Exception {
	public NoSpecialtyException() {
		super();
	}
	public NoSpecialtyException(String s) {
		super(s);
	}
}
