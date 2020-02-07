import java.util.ArrayList;

public class CourseCat {
	
	private ArrayList <Course> courseList;
	
	
	public CourseCat () {	
		this.courseList = loadFromDB();
	}
	private static ArrayList<Course> loadFromDB () {
		//In real life courses are loaded from the database, or
	    //at least a file on disk. Here we are simulating that!
		//Imagine!! this is being loaded from the database!
		ArrayList<Course> courseList = new ArrayList<Course>();
		courseList.add(new Course ("ENGG", 233));
		courseList.add(new Course ("PHYS", 259));
		courseList.add(new Course ("ENSF", 293));
		return courseList;
	}
	public Course searchCat (String courseName, int courseNum) {
		for (Course c: courseList) {
			if (courseName.equals(c.getCourseName()) 
					&& c.getCourseNum() == courseNum) {
				return c;
			}
		}
		//System.err.println("ERROR! Course: " + courseName + " " + courseNum + " does NOT exit!");
		return null;
	}
	public CourseOffering searchOffering (Course selectedCourse, int secNum) {
		for (CourseOffering co: selectedCourse.getCourseOffering()) {
			if (co.getSecNum() == secNum)
				return co;
		}
		return null;	
	}
	public void createCourseOffering (Course c, int secNum, int secCap) {
		if (c != null) {
			CourseOffering co = new CourseOffering (secNum, secCap);
			c.addOffering(co);
		}
	}
	public ArrayList<Course> getCourseList(){
		return courseList;
	}
	public boolean addToCourseList(Course myCourse){
		this.courseList.add(myCourse);
		return true;
	}
	
	// to check if the Course Offering has 8 or more students before it can take place
	public boolean above(CourseOffering myCO) {
		if(myCO.getStudentRegList().size() >= 8)
			return true;
		return false;
		
	}

}
