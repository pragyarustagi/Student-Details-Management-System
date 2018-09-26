package com.pragya.assignment2.models;

import java.io.Serializable;

public class Courses implements Serializable {

    private Character courseName;

    public Courses() {
    }

    public Courses(Character courseName) {
        this.courseName = courseName;
    }

    public final Character getCourseName() {
        return courseName;
    }

    public final void setCourseName(Character courseName) {
        this.courseName = courseName;
    }

}
