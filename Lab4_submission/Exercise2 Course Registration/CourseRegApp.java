//This is the front end
import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegApp {
	
	
	public static void main (String [] args) {	
		StudentList stList = new StudentList();
		CourseCat cat = new CourseCat ();
		Student st = new Student ("Sara", 1);
		stList.addToStudentList(st);  // adds to the array list of students
		Student st2 = new Student ("Sam", 2);
		stList.addToStudentList(st2);
		Student st3 = new Student("Pam", 3);
		stList.addToStudentList(st3);
		Student st4 = new Student("Tam", 4);
		stList.addToStudentList(st4);
		Course myCourse = cat.searchCat("ENGG", 233);
		Course myCourse2 = new Course("ENSF", 592);
		cat.addToCourseList(myCourse2);
		cat.searchCat("ENSF", 592);
		Course myCourse3 = cat.searchCat("PHYS", 259);

		if (myCourse != null) {
			 cat.createCourseOffering(myCourse, 1, 60);
			cat.createCourseOffering(myCourse, 2, 100);
		}
		if (myCourse2 != null) {
			cat.createCourseOffering(myCourse2, 1, 77);
			cat.createCourseOffering(myCourse2, 2, 88);
		}
		if (myCourse3 != null) {
			 cat.createCourseOffering(myCourse3, 1, 99);
			cat.createCourseOffering(myCourse3, 2, 100);
		}

	    
	    // 1. search function 
//	    System.out.println(cat.searchCat("ENGG", 233));
//	    System.out.println(cat.searchCat("ENSF", 592));
//	    System.out.print(cat.searchCat("PHYS", 259));
	    
	    // 2. Add course to student course
	    st.registerForCourse(cat, "PHYS", 259, 1);
	    st.registerForCourse(cat, "ENSF", 592, 1);
	    st.registerForCourse(cat, "ENGG", 233, 1);
	    st2.registerForCourse(cat, "ENGG",233, 1);
	    st2.registerForCourse(cat, "ENSF",592, 2);
	    st3.registerForCourse(cat, "ENGG",233, 1);
	   // System.out.println(cat.searchCat("ENGG", 233));
	   //System.out.println(myCourse.getCourseOfferingAt(0));
	    
	    app(cat, stList);
		
	}
	public static void app(CourseCat cat, StudentList stList) {
		
		System.out.println("Welcome to Schulich 2 Learn (S2L)! \n"
				+ "This is a Student Course Management system \n");
		while(true) {
			System.out.println("Before we contuine, please tell us if you are a student by entering 1 "
			+ "or an instructor by entering 2");
			Scanner keyboard = new Scanner(System.in);
			 int input = keyboard.nextInt();
			
			switch(input) {
			
			case 1:
				while (true)
				{
					System.out.println( "\n" +
							"Please make a selection using the keyboard from the following list of options: \n"
							+ "Press 1: To Search Catalogue Courses \n"
							+ "Press 2: Add course to student courses \n"
							+ "Press 3: Remove course from student courses \n"
							+ "Press 4: View All courses in catalogue \n"
							+ "Press 5: View all courses taken by student \n"
							+ "Press 6: To exit from S2L. \n");
					
				   int selection = keyboard.nextInt();
				   
				   switch(selection){
				        case 1:
				           System.out.println("Please enter the name of the course you want to search");
				           String courseName = keyboard.next();
				           System.out.println("Please enter the course code of the course you want to search");
				           int courseNum = keyboard.nextInt();
				           if(cat.searchCat(courseName.toUpperCase(), courseNum) != null) {
				        	   System.out.printf("%s %d is on the Course Catalogue \n", courseName.toUpperCase(), courseNum);
				           }
				           else
				        	   System.out.printf("%s %d is NOT on the Course Catalogue \n", courseName.toUpperCase(), courseNum);
				           break;

				        case 2:
				        		System.out.println("Please enter your name");
					           String studentName1 = keyboard.next();
					           System.out.println("Please enter your student id");
					           int studentNum1 = keyboard.nextInt();
					           System.out.println("Please enter the name of the course you want to add");
					           String courseName1 = keyboard.next().toUpperCase();
					           System.out.println("Please enter the course code of the course you want to add");
					           int courseNum1 = keyboard.nextInt();
					           if(cat.searchCat(courseName1.toUpperCase(), courseNum1) == null ) 
					           {
					        	   System.out.println("The course does not exist. Please check back later");
					        	   break;
					           }
					           else
					           {
					        	   Course aCourse1 = cat.searchCat(courseName1.toUpperCase(), courseNum1);
					        	   System.out.println("Please enter section number");
					        	   int secNum1 = keyboard.nextInt();
					        	   if(cat.searchOffering(aCourse1, secNum1) != null) {
					        		   Boolean studentMatch = false;
					        		   for(Student st : stList.getStudentList() ) {
					        			   if (st.getId() == studentNum1)
					        			   		{
					        				   if(st.alreadyInCourse(cat, courseName1.toUpperCase(), courseNum1, secNum1) == false) {
					        				   	st.registerForCourse(cat, courseName1.toUpperCase(), courseNum1, secNum1);
					        				   	System.out.println("This student has been added to the course!");
					        				   	studentMatch = true;
					        				   	break;
					        			   		}
					        				   else {
					        					   System.out.println("Student already in couse. Can not be added");
					        					   studentMatch = true;
					        					   break;
					        				   }
					        				   
					        		   		}
					        		   }
					        		   if(studentMatch == false) {
					        			   Student st = new Student(studentName1, studentNum1);
					        			   stList.addToStudentList(st);
					        			   st.registerForCourse(cat, courseName1, courseNum1, secNum1);
					        			   System.out.println("This student has been added to the course!");
					        		   }
					        	   }
					        	   else
					        		   System.out.println("Section does not exist");
					           }
					           break;

				        case 3:
					           System.out.println("Please enter your student id");
					           int studentNum2 = keyboard.nextInt();
				        	System.out.println("Please enter the name of the course you want to remove");
					           String courseName2 = keyboard.next().toUpperCase();
					           System.out.println("Please enter the course code of the course you want to remove");
					           int courseNum2 = keyboard.nextInt();
					           System.out.println("Please enter the section number associated with this course");
					           int secNum2 = keyboard.nextInt();
					           for (Student st: stList.getStudentList()) {
					        	   if (studentNum2 == st.getId()) {
							           if(st.deregisterForCourse(cat, courseName2, courseNum2, secNum2)) {
							        	   System.out.printf("%s %d section %d has been removed for Student with %d registration\n", courseName2, courseNum2, secNum2, studentNum2);
							        	   System.out.println("This is the student's updated Registration \n");
							        	   st.getStudentRegList();
							        	   break;
					           }
					        	   
					           else 
					        	   System.out.println("%s %d degrestration was not completed \n");
					        	   break;
					        	   	}
					        	}
					           break;
				        case 4:
				        	System.out.println("Following is the Course Catalog");
				        	for(Course c: cat.getCourseList()) {
				        		System.out.println(c.getCourseName() + " " + c.getCourseNum());
				        	}
				        	break;
				        case 5:
				        	System.out.println("Please enter your student id");
					           int studentid3 = keyboard.nextInt();
					           boolean matchFound = false;
					           for (Student st: stList.getStudentList()) {
					        	   if (studentid3 == st.getId()) {
					        		   st.getStudentRegList();
					        		   matchFound = true;
					        	   }
					           }
					           if(matchFound == false)
					        	   System.out.println("This student does not exist");
					           break;
				        case 6:
					           System.out.println("Thank you for using Schulich 2 Learn. See you again!");
					           System.exit(0);
					           break;
				        default: 
				        	System.out.println("Invalid selection, please select between 1 to 6!");
		                   break;
				      }
				 }
			case 2:
				while (true)
				{
					System.out.println( "\n" +
							"Please make a selection using the keyboard from the following list of options: \n"
							+ "Press 1: To add Courses to Course Catalogue \n"
							+ "Press 2: To add sections to an Existing Course\n"
							+ "Press 3: Show all students in a Course Offering \n"
							+ "Press 4: Print Course Catalog \n"
							+ "Press 5: Print Course Offering \n"
							+ "Press 6: To exit from S2L. \n");
					
				   int selection = keyboard.nextInt();
				   
				   switch(selection){
				        case 1:
					           System.out.println("Please enter the Course Name. ");
					           String courseName = keyboard.next();
					           System.out.println("Please enter the Course Number");
					           int courseNum = keyboard.nextInt();
					           if(cat.searchCat(courseName.toUpperCase(), courseNum) == null ) {
					        		   Course aCourse = new Course(courseName.toUpperCase(), courseNum);
					        		   cat.addToCourseList(aCourse);
						        	   System.out.printf("%s %d has been added to the Course Catalog \n", courseName.toUpperCase(), courseNum);
						           }
					           else
					        	   System.out.printf("%s %d was NOT added to the Course Catalog \n", courseName.toUpperCase(), courseNum);
					           break;

					   case 2:
						           System.out.println("Please enter the name of the course you want to add the section to");
						           String courseName1 = keyboard.next();
						           System.out.println("Please enter the course Number of the course you want to add the section to");
						           int courseNum1 = keyboard.nextInt();
						           if(cat.searchCat(courseName1.toUpperCase(), courseNum1) == null ) 
						           {
						        	   System.out.println("The course does not exist. Please create the course first");
						           }
						           else
						           {
						        	   Course aCourse1 = cat.searchCat(courseName1.toUpperCase(), courseNum1);
						           System.out.println("Please enter section number");
						           int secNum1 = keyboard.nextInt();
						           System.out.println("Please enter this section's capacity");
						           int secCap1 = keyboard.nextInt();
						           if(cat.searchOffering(aCourse1, secNum1) == null) {
						        	   cat.createCourseOffering(aCourse1, secNum1, secCap1);
						        	   System.out.printf("%s %d has section %d with a capacity of %d", courseName1.toUpperCase(), courseNum1, secNum1, secCap1);
						           }
						           else
						        	   System.out.println("Section already exist");
						           }
						           break;

					        case 3:
					        	System.out.println("Please enter the name of the course you want to add the section to");
						           String courseName2 = keyboard.next();
						           System.out.println("Please enter the course Number of the course you want to add the section to");
						           int courseNum2 = keyboard.nextInt();
						           if(cat.searchCat(courseName2.toUpperCase(), courseNum2) == null ) 
						           {
						        	   System.out.println("The course does not exist. Please create the course first before any students can be added!");
						           }
						           else
						           {
						        	   Course aCourse2 = cat.searchCat(courseName2.toUpperCase(), courseNum2);
						           System.out.println("Please enter section number");
						           int secNum2 = keyboard.nextInt();
						           System.out.println("Please enter this section's capacity");
						           int secCap2 = keyboard.nextInt();
						           if(cat.searchOffering(aCourse2, secNum2) != null) {
						        	   System.out.printf("%s %d section %d with a capacity of %d has following students", courseName2.toUpperCase(), courseNum2, secNum2, secCap2);
						        	   System.out.println(cat.searchOffering(aCourse2, secNum2));
						        	   
						           }
						           else
						        	   System.out.printf("%s %d with section %d with a capacity of %d is null and has no students", courseName2.toUpperCase(), courseNum2, secNum2, secCap2);
						           }
						           
						           break;
					        case 4:
					        	System.out.println("Following is the Course Catalog");
					        	System.out.print(cat.getCourseList());
					        	break;
					        case 5:
					        	System.out.println("Please enter the name of the course offering you want to print");
						           String courseName3 = keyboard.next();
						           System.out.println("Please enter the course Number of the offering you want to print");
						           int courseNum3 = keyboard.nextInt();
						           if(cat.searchCat(courseName3.toUpperCase(), courseNum3) == null ) 
						           {
						        	   System.out.println("The course does not exist!");
						           }
						           else
						           {
						        	   Course aCourse3 = cat.searchCat(courseName3.toUpperCase(), courseNum3);
						           System.out.println("Please enter section number");
						           int secNum3 = keyboard.nextInt();
						           if(cat.searchOffering(aCourse3, secNum3) != null) {
						        	   System.out.printf("%s %d section %d has following students", courseName3.toUpperCase(), courseNum3, secNum3);
						        	   System.out.println(cat.searchOffering(aCourse3, secNum3));
						        	   
						           }
						           else
						        	   System.out.printf("%s %d section %d is null and has no students", courseName3.toUpperCase(), courseNum3, secNum3);
						           }
						           break;
					        case 6:
					        	   System.out.println("Thank you for using Schulich 2 Learn. See you again!");
						           System.exit(0);
						           break;
					        	
					        default: 
					        	    System.out.println("Invalid selection, please select between 1 to 4!");
			                        break;
				   }
				}
			default: 
        	    System.out.println("Invalid selection, please select 1 or 2!");
                break;
			}
		}
	}
}
