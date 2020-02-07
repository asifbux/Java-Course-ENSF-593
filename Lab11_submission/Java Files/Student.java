
public class Student {
	
	private int id;
	private String name;
	private int dept;
	private String program;
	private int year;
	private Student left, right;
	
	public Student(String name, int id, int dept, String program, int year) {
		setId(id);
		setName(name);
		setDept(dept);
		setProgram(program);
		setYear(year);
		setLeft(null);
		setRight(null);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student getLeft() {
		return left;
	}
	public void setLeft(Student left) {
		this.left = left;
	}
	public Student getRight() {
		return right;
	}
	public void setRight(Student right) {
		this.right = right;
	}
	
	public int getDept() {
		return dept;
	}

	public void setDept(int dept) {
		this.dept = dept;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String prog) {
		this.program = prog;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Student Name: " + name + " ID: " + id + " Dept: " + dept + " Program: " + program + " Year: " + year;
	}
	
	

}
