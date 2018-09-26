package com.pragya.assignment2.Information;

import com.pragya.assignment2.Constants.Constants;
import com.pragya.assignment2.Validations;
import com.pragya.assignment2.exceptions.MyExceptions;

import java.util.*;

public class Action {

    public static Action getInstance() {
        return new Action();
    }

    Student student = new Student();
    Scanner sc = new Scanner(System.in);
    List<Student> list1 = new ArrayList<Student>();
    List<Character> character = new ArrayList<Character>();


    String answer, order;
    Integer option;

    String filePath = "/Users/pragyarustagi/pragyaassignment2/src/main/java/com/pragya/assignment2/Information/Store";

    public void addDetails(List<Student> list, Set<Integer> set) throws MyExceptions {
        System.out.println("\nEnter Student's Details: ");
        System.out.println("\nName: ");
        student.setName(sc.nextLine());

        System.out.println("Address: ");
        student.setAddress(sc.nextLine());

        System.out.println("Choose any 4 Courses (A,B,C,D,E,F): ");
        String coursechoosen = sc.nextLine();

        List<Courses> coursesList = new ArrayList<Courses>();
        for (char ch : coursechoosen.toCharArray()) {
            if (ch != ' ') {
                Courses courses = new Courses();
                courses.setCourseName(ch);
                coursesList.add(courses);
            }
        }


        System.out.println("Age: ");
        student.setAge(sc.nextInt());

        System.out.println("Roll No: ");
        student.setRollNo(sc.nextInt());

        Validations valid = new Validations();

        valid.isValidName(student.getName());
        valid.isValidAddress(student.getAddress());
        valid.isValidAge(student.getAge());
        valid.isValidRollno(student.getRollNo());
        valid.isUniqueRollNo(student.getRollNo(), set);


        list.add(student);
        Collections.sort(list);


        for (Student st : list) {
            System.out.printf("%-10s%-7d%-7d%-20s\n",
                    st.getName(), st.getRollNo(), st.getAge(),
                    st.getAddress());

            }



    }


    public void displayDetails() throws MyExceptions {

        System.out.println("\nChoose the Order");
        System.out.println("\n1. Ascending Order");
        System.out.println("2. Descending Order");
        System.out.println("\n Enter your Order Choice ");
        order = sc.nextLine();

        System.out.println("\nChoose the Option");
        System.out.println("\n1. Name");
        System.out.println("2. RollNo");
        System.out.println(("3. Age"));
        System.out.println("4. Address");
        System.out.println("\n Enter your Option Choice ");
        option = sc.nextInt();

        if (order.equals(Constants.ONE)) {
            FileHandler sf = new FileHandler();
            List<Student> list1 = sf.readFromFile(filePath);
            switch (option) {
                case 1: {
                    Collections.sort(list1);
                    for (Student st : list1) {
                        System.out.printf("%-10s%-7d%-7d%-20s\n",
                                st.getName(), st.getRollNo(), st.getAge(),
                                st.getAddress());
                    }
                    break;
                }
                case 2: {
                    Collections.sort(list1, Student.RollnoComparator);
                    for (Student st : list1) {
                        System.out.printf("%-10s%-7d%-7d%-20s\n",
                                st.getName(), st.getRollNo(), st.getAge(),
                                st.getAddress());
                    }
                    break;
                }
                case 3: {
                    Collections.sort(list1, Student.AgeComparator);
                    for (Student st : list1) {
                        System.out.printf("%-10s%-7d%-7d%-20s\n",
                                st.getName(), st.getRollNo(), st.getAge(),
                                st.getAddress());
                    }
                    break;
                }
                case 4: {
                    Collections.sort(list1, Student.AddressComparator);
                    for (Student st : list1) {
                        System.out.printf("%-10s%-7d%-7d%-20s\n",
                                st.getName(), st.getRollNo(), st.getAge(),
                                st.getAddress());
                    }
                    break;
                }
                default:
                    System.out.println("\nInvalid Option Choosen");
                    break;
            }

        } else if (order.equals(Constants.TWO)) {
            FileHandler sf = new FileHandler();
            List<Student> list1 = sf.readFromFile(filePath);
            switch (option) {
                case 1: {
                    Collections.reverse(list1);
                    for (Student st : list1) {
                        System.out.printf("%-10s%-7d%-7d%-20s\n",
                                st.getName(), st.getRollNo(), st.getAge(),
                                st.getAddress());
                    }
                    break;
                }
                case 2: {
                    Collections.sort(list1, Student.DesRollnoComparator);
                    for (Student st : list1) {
                        System.out.printf("%-10s%-7d%-7d%-20s\n",
                                st.getName(), st.getRollNo(), st.getAge(),
                                st.getAddress());
                    }
                    break;
                }
                case 3: {
                    Collections.sort(list1, Student.DesAgeComparator);
                    for (Student st : list1) {
                        System.out.printf("%-10s%-7d%-7d%-20s\n",
                                st.getName(), st.getRollNo(), st.getAge(),
                                st.getAddress());
                    }
                    break;
                }
                case 4: {
                    Collections.sort(list1, Student.DesAddressComparator);
                    for (Student st : list1) {
                        System.out.printf("%-10s%-7d%-7d%-20s\n",
                                st.getName(), st.getRollNo(), st.getAge(),
                                st.getAddress());
                    }
                    break;
                }
                default: {
                    throw new MyExceptions("\nInvalid Option Choosen");
                }
            }
        }
    }

    public void deleteDetails() throws MyExceptions {

        System.out.println("Enter the Roll Number whose Information has to be deleted: ");
        Scanner scan = new Scanner(System.in);
        Integer rollNumber = scan.nextInt();
        FileHandler sf = new FileHandler();
        List<Student> list1 = sf.readFromFile(filePath);
        int t = -1;
        for (int pos = 0; pos < list1.size(); pos++) {
            if (rollNumber.equals(list1.get(pos).getRollNo())) {
                t = pos;
            }
        }

        if (t != -1) {
            list1.remove(t);
        } else {
            throw new MyExceptions("\nRoll number entered by the user doesn't exists!");
        }

        System.out.println("Do you want to save the Changes?");
        answer = sc.nextLine();
        if ((Constants.YES).equalsIgnoreCase(answer)) {
            Action.getInstance().saveDetails(list1);
        }
    }

    public void saveDetails(List<Student> list) {
        FileHandler sf = new FileHandler();
        sf.writeToFile(list, filePath);
    }

    public void terminate() {
        System.out.println("Do you want to save the changes?");
        answer = sc.nextLine();
        if ((Constants.YES).equalsIgnoreCase(answer)) {
            Action.getInstance().saveDetails(list1);
        } else {
            return;
        }
    }

}