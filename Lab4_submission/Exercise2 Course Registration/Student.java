import java.util.ArrayList;

public class Student {
	private String name;
	private int id;
	//private ArrayList <CourseOffering> studentCourseList;
	private ArrayList <Registration> studentRegList;
	//private CourseCat courseCat;
	//in Student we construct type registration in the searchCat method. Does that not break association rules?
	
	public Student (String name, int id) {
		this.name = name;
		this.id = id;
		studentRegList = new ArrayList<Registration>();
	}
	public boolean registerForCourse (CourseCat cat, String cName, int cNum, int secNum) {
		Course newCourse = searchCat(cat, cName, cNum);
		
		if (newCourse != null) {
			CourseOffering co = cat.searchOffering(newCourse, secNum);
			if (co != null && studentRegList.size() <= 6) {
				Registration r = new Registration ();
				r.completeRegistration(this, co);
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}
	public boolean deregisterForCourse (CourseCat cat, String cName, int cNum, int secNum) {
		if (alreadyInCourse(cat, cName, cNum, secNum) == false)
		{				
			System.out.print("Student is not registred in this course/Course Offering");
			return false;
		}
		Course newCourse = searchCat(cat, cName, cNum); // shallow copy
		if (newCourse != null) {
			CourseOffering co = cat.searchOffering(newCourse, secNum); // shallow copy 
			if (co != null) {
				Registration rCopy = new Registration();
				boolean studentRemoved = false;
				for (Registration r: studentRegList) {
					if(r.getTheOffering().getTheCourse().getCourseName() == newCourse.getCourseName()) {
						rCopy = r;
						System.out.println(rCopy.getTheStudent().getId());
						studentRegList.remove(studentRegList.indexOf(r));
						studentRemoved = true;
						break;
						}
				}
				if(studentRemoved) {
				for(Registration reg: co.getStudentRegList()) {
					if (rCopy.getTheStudent().getId() == reg.getTheStudent().getId()) {
						rCopy.completeDeregistration(rCopy.getTheStudent().getId(), co);
						break;
					}	
					}
				}
				return studentRemoved;
			}
			return false;
			}
		
		return false;
	}

	//helper function
	private Course searchCat(CourseCat cat, String cName, int cNum) {
		return  cat.searchCat(cName, cNum);	
	}
    //adding one Registration to studentRegList
	public void addRegistration (Registration reg) {
		studentRegList.add(reg);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void getStudentRegList() {
		int counter = 1;
		for(Registration r: studentRegList) {
			System.out.println("Course " + counter + ": " + r);
			counter++;
		}
	}
	public boolean alreadyInCourse (CourseCat cat, String cName, int cNum, int secNum) {
		Course newCourse = searchCat(cat, cName, cNum);
		if (newCourse != null) {
			CourseOffering co = cat.searchOffering(newCourse, secNum);
			if (co != null) {
				boolean matchFound = false;
				for( Registration r: co.getStudentRegList()) {
					if (r.getTheStudent().getId() == this.id) {
						matchFound = true;
					}
				}
				return matchFound;
			}
			else
				return false;
		}
		else
			return false;
	}
	@Override
	public String toString () {
		return "Student Name: " + name + " ID: " + id;
	}
	
}
