
import java.util.ArrayList;

public class Course {
	
	private String courseName;
	private int courseNum;
	private ArrayList <Course> preReq;
	private ArrayList <CourseOffering> courseOffering;
	//Taking this constructor out so that the relationship between Course and CourseOffering
	//is no longer aggregation 
//	public Course (String courseName, int courseNum, 
//			ArrayList<CourseOffering> courseOffering) {
//		this.courseName = courseName;
//		this.courseNum = courseNum;
//		preReq = new ArrayList<Course>();
//		this.courseOffering = courseOffering;
//	}
	public Course (String courseName, int courseNum) {
		this.courseName = courseName;
		this.courseNum = courseNum;
		setPreReq(new ArrayList<Course>());
		courseOffering = new ArrayList <CourseOffering>();
	}
	public void addOffering (CourseOffering offering) {
		if (offering.getTheCourse() == null)
			offering.setTheCourse(this);
		if (!offering.getTheCourse().getCourseName().equals(courseName) ||
			offering.getTheCourse().getCourseNum() != courseNum) {
			System.err.println("ERROR! This sectio belongs to anohter course!");
			return;
		}
		courseOffering.add(offering);
	}
	
	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCourseNum() {
		return courseNum;
	}
	public void setCourseNum(int courseNum) {
		this.courseNum = courseNum;
	}
	public ArrayList<CourseOffering> getCourseOffering () {
		return courseOffering;//not safe, should return a copy of this instead
		//will do later
	}
	public CourseOffering getCourseOfferingAt(int index) {
		return courseOffering.get(index);//what if index is out of bounds??
	}
	public ArrayList <Course> getPreReq() {
		return preReq;
	}
	public void setPreReq(ArrayList <Course> preReq) {
		this.preReq = preReq;
	}
	public void addPreReq(Course myCourse) {
		preReq.add(myCourse);
	}
	@Override
	public String toString() {
		String st = "\n";
		st += courseName + " " + courseNum + "\n";
		for (CourseOffering c: courseOffering)
			st += c;
		return st;
	}

	

}
