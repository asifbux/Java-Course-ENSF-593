// to check if the student already exist before adding courses
import java.util.ArrayList;

public class StudentList {
	
	private ArrayList <Student> studentList;
	
	public StudentList() {
		this.studentList= new ArrayList <Student>();
	}
	
	public boolean addToStudentList(Student mystudent){
		this.studentList.add(mystudent);
		return true;
	}

	public ArrayList <Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList <Student> studentList) {
		this.studentList = studentList;
	}
	
	public Student findStudent(int id) {
		for(Student st: studentList)
			if(st.getId() == id) {
				return st;}
		return null;

	}
	

}
