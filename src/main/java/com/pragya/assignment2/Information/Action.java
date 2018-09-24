package com.pragya.assignment2.Information;

import com.pragya.assignment2.Consonants.Consonants;

import java.util.Scanner;

import java.util.*;

public class Action {

    Action action = null;

    public static Action getInstance() {
        return new Action();
    }

   List<Student> list = new ArrayList<Student>();

    String filePath = "/Users/pragyarustagi/pragyaassignment2/src/main/java/com/pragya/assignment2/Information/Store";
    public void addDetails() {
        String name;
        Integer age;
        String address;
        Integer rollNo;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Student's Details: ");
        System.out.println("\nName: ");
        name = sc.nextLine();

        System.out.println("Address: ");
        address = sc.nextLine();

        System.out.println("Age: ");
        age = sc.nextInt();

        System.out.println("Roll No: ");
        rollNo = sc.nextInt();


        //    System.out.println("Courses: ");
        //....

        //   String details = null;
        //   details += s.getName() + " " + s.getRollNo() + " " + s.getAge() + " " + s.getAddress();

//        String filePath = "/Users/pragyarustagi/pragyaassignment2/src/main/java/com/pragya/assignment2/Information/Store";
        this.list.add(new Student(name, rollNo, age, address));
        StudentFileStream sf = new StudentFileStream();
        Collections.sort(list);
        sf.writeToFile(list, filePath);
        List<Student> list1 = sf.readFromFile(filePath);
        for (Student st : list1) {
            System.out.printf("%-10s%-7d%-7d%-20s\n",
                    st.getName(), st.getRollNo(), st.getAge(),
                    st.getAddress());

        }

        }


        public void displayDetails () {

            Scanner scan = new Scanner(System.in);
            String order;
            Integer option;
            System.out.println("\nChoose the Order");
            System.out.println("\n1. Ascending Order");
            System.out.println("2. Descending Order");
            System.out.println("\n Enter your Order Choice ");
            order = scan.nextLine();

            System.out.println("\nChoose the Option");
            System.out.println("\n1. Name");
            System.out.println("2. RollNo");
            System.out.println(("3. Age"));
            System.out.println("4. Address");
            System.out.println("\n Enter your Option Choice ");
            option = scan.nextInt();

            if (order.equals(Consonants.ONE)) {

                StudentFileStream sf = new StudentFileStream();
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

            } else if (order.equals(Consonants.TWO)) {
                StudentFileStream sf = new StudentFileStream();
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
                    default:
                        System.out.println("\nInvalid Option Choosen");
                        break;
                }

            }
        }

        public void deleteDetails () {

        }

        public void saveDetails () {

        }

        public void terminate () {
        }

}