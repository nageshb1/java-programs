package com.nagesh.datastructures;

import java.util.*;

class Student{
	private int id;
	private String fname;
	private double cgpa;
	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public int getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public double getCgpa() {
		return cgpa;
	}
}
class CGPAComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        int cgpaCompare = new Double(s2.getCgpa()).compareTo(s1.getCgpa());
        int nameCompare;
        
        if (cgpaCompare == 0)
        {
            nameCompare = s1.getFname().compareTo(s2.getFname());
            if (nameCompare == 0) {
                return new Integer(s1.getId()).compareTo(s2.getId());
            } else {
                return nameCompare;
            }
        }
        else 
            return cgpaCompare;
    }
    
}
//Complete the code
public class CollectionsSort
{
	/*
	 * sample input:
	 * 5
	 * 33 Rumpa 3.68
	 * 85 Ashis 3.85
	 * 56 Samiha 3.75
	 * 19 Samara 3.75
	 * 22 Fahim 3.76
	 */
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			
			testCases--;
		}
              Collections.sort(studentList, new CGPAComparator());

      	for(Student st: studentList){
			System.out.println(st.getFname());
		}
	}
}