
public class Registration {
	
	private Student theStudent;
	private CourseOffering theOffering;
	private char grade;
	
	
	public void completeRegistration (Student theStudent, CourseOffering theOffering) {
		this.theStudent = theStudent;
		this.theOffering = theOffering;
		addRegistration ();
	}
	public void completeDeregistration (int id, CourseOffering theOffering) {
		this.theOffering = theOffering;
		deleteRegistration(id);
	}
	private void addRegistration() {
		// TODO Auto-generated method stub
		theStudent.addRegistration(this); // array update of registration objects in student 
		theOffering.addRegistration(this); // array update of Registration objects in Course Offering 
	}
	private void deleteRegistration(int id) {
		// TODO Auto-generated method stub
		theOffering.deleteRegistration(id); // array update of Registration objects in Course Offering 
	}
	public Student getTheStudent() {
		return theStudent;
	}
	public void setTheStudent(Student theStudent) {
		this.theStudent = theStudent;
	}
	public CourseOffering getTheOffering() {
		return theOffering;
	}
	public void setTheOffering(CourseOffering theOffering) {
		this.theOffering = theOffering;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	@Override
	public String toString () {
		return 
				theOffering.getTheCourse().getCourseName() + " " + theOffering.getTheCourse().getCourseNum() +
				" Section: " + theOffering.getSecNum() + " Section Capacity: " + theOffering.getSecCap();
		
	}

}
