
import java.util.ArrayList;

public class CourseOffering {
	private int secNum;
	private int secCap;
	//ArrayList <Student> studentList;
	private ArrayList <Registration> studentRegList;
	private Course theCourse;

	
	public CourseOffering (int secNum, int secCap) {
		this.setSecNum(secNum);
		this.secCap = secCap;
		studentRegList = new ArrayList<Registration>();
	}
	public boolean addRegistration (Registration reg) {
		//We can add logic to ensure the requirements for the number of students
		//is met
		if(studentRegList.size() <= 6) {
			studentRegList.add(reg);
				return true; }
		else
			return false;
	}
	public void deleteRegistration (int id) {;
		for(Registration r: studentRegList) {
			if(id == r.getTheStudent().getId()) {
				int index = studentRegList.indexOf(r);
				studentRegList.remove(index);
				break;
			}
		}
	}
	public int getSecNum() {
		return secNum;
	}
	public void setSecNum(int secNum) {
		this.secNum = secNum;
	}
	public int getSecCap() {
		return secCap;
	}
	public void setSecCap(int secCap) {
		this.secCap = secCap;
	}
	public Course getTheCourse() {
		return theCourse;
	}
	public void setTheCourse(Course theCourse) {
		this.theCourse = theCourse;
	}
	public ArrayList<Registration> getStudentRegList () {
		return studentRegList;
	}
	@Override
	public String toString() {
		String st = "\n";
		st += "Section Number: " + secNum + ", Section Cap: " + secCap + "\n\n";
		st += "Students in this section are: \n\n";
		for (Registration r : studentRegList) {
			st += r.getTheStudent();
			st += "\n\n";
		}
		return st;
	}
}
