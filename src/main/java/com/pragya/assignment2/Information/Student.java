package com.pragya.assignment2.Information;

import java.io.Serializable;
import java.util.Comparator;

public class Student implements Serializable, Comparable<Student> {

    private String name;
    private Integer age;
    private String address;
    private Integer rollNo;

    public Student(String name, Integer rollNo, Integer age, String address) {
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
        this.address = address;
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

    public int compareTo(Student s) {
        if(s.getName()!=this.getName())
        return name.compareTo(s.name);

        else
        {
            return rollNo.compareTo(s.rollNo);
        }
    }

    public static Comparator<Student> RollnoComparator = new Comparator<Student>() {

        public int compare(Student o1, Student o2) {
            int rollno1 = o1.getRollNo();
            int rollno2 = o2.getRollNo();
            return rollno1 - rollno2;
        }
    };

    public static Comparator<Student> AgeComparator = new Comparator<Student>() {
        public int compare(Student o1, Student o2) {
            int age1 = o1.getAge();
            int age2 = o2.getAge();
            return age1 - age2;
        }
    };

    public static Comparator<Student> AddressComparator = new Comparator<Student>() {
        public int compare(Student o1, Student o2) {
            String address1 = o1.getAddress().toUpperCase();
            String address2 = o2.getAddress().toUpperCase();
            return address1.compareTo(address2);
        }
    };

    //................

    public static Comparator<Student> DesRollnoComparator = new Comparator<Student>() {
        public int compare(Student o1, Student o2) {
            int rollno1 = o1.getRollNo();
            int rollno2 = o2.getRollNo();
            return rollno2 - rollno1;
        }
    };

    public static Comparator<Student> DesAgeComparator = new Comparator<Student>() {
        public int compare(Student o1, Student o2) {
            int age1 = o1.getAge();
            int age2 = o2.getAge();
            return age2 - age1;
        }
    };

    public static Comparator<Student> DesAddressComparator = new Comparator<Student>() {
        public int compare(Student o1, Student o2) {
            String address1 = o1.getAddress().toUpperCase();
            String address2 = o2.getAddress().toUpperCase();
            return address2.compareTo(address1);
        }
    };

}