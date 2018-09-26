package com.pragya.assignment2.Information;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Student implements Serializable, Comparable<Student> {

    private String name;
    private Integer age;
    private String address;
    private Integer rollNo;
    private List<Courses> courses;

    /**
     * Parameterized Constructor
     * @param name
     * @param rollNo
     * @param age
     * @param address
     */

    private List<Courses> coursesList = new ArrayList<Courses>();
    public Student(String name, Integer rollNo, Integer age, String address, List<Courses> coursesList) {
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
        this.address = address;
        this.coursesList = coursesList;
    }

    //Default Constructor
    public Student() {
    }

    public final void addCourse(List<Courses> coursesList) {
        if(this.coursesList.isEmpty()){
            this.coursesList = coursesList;
        }
    }


    public final List getList() {
        return coursesList;
    }



    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final Integer getAge() {
        return age;
    }

    public final void setAge(Integer age) {
        this.age = age;
    }

    public final String getAddress() {
        return address;
    }

    public final void setAddress(String address) {
        this.address = address;
    }

    public final Integer getRollNo() {
        return rollNo;
    }

    public final void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }




    //Using Comparable interface to Sort according to Name
    public int compareTo(Student s) {
        if (s.getName() != this.getName())
            return getName().compareTo(s.getName());

        else {
            return getRollNo().compareTo(s.getRollNo());
        }
    }

    //Using Comparator interface to sort according to Roll Number in Ascending Order
    public static Comparator<Student> RollnoComparator = new Comparator<Student>() {
        public int compare(Student o1, Student o2) {
            int rollno1 = o1.getRollNo();
            int rollno2 = o2.getRollNo();
            return rollno1 - rollno2;
        }
    };

    //Using Comparator interface to sort according to Age in Ascending Order
    public static Comparator<Student> AgeComparator = new Comparator<Student>() {
        public int compare(Student o1, Student o2) {
            int age1 = o1.getAge();
            int age2 = o2.getAge();
            return age1 - age2;
        }
    };

    //Using Comparator interface to sort according to Address in Ascending Order
    public static Comparator<Student> AddressComparator = new Comparator<Student>() {
        public int compare(Student o1, Student o2) {
            String address1 = o1.getAddress().toUpperCase();
            String address2 = o2.getAddress().toUpperCase();
            return address1.compareTo(address2);
        }
    };

    //Using Comparator interface to sort according to Rollno in Descending Order
    public static Comparator<Student> DesRollnoComparator = new Comparator<Student>() {
        public int compare(Student o1, Student o2) {
            int rollno1 = o1.getRollNo();
            int rollno2 = o2.getRollNo();
            return rollno2 - rollno1;
        }
    };

    //Using Comparator interface to sort according to Age in Descending Order
    public static Comparator<Student> DesAgeComparator = new Comparator<Student>() {
        public int compare(Student o1, Student o2) {
            int age1 = o1.getAge();
            int age2 = o2.getAge();
            return age2 - age1;
        }
    };

    //Using Comparator interface to sort according to Address in Descending Order
    public static Comparator<Student> DesAddressComparator = new Comparator<Student>() {
        public int compare(Student o1, Student o2) {
            String address1 = o1.getAddress().toUpperCase();
            String address2 = o2.getAddress().toUpperCase();
            return address2.compareTo(address1);
        }
    };

}