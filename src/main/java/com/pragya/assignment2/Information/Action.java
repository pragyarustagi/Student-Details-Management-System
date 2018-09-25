package com.pragya.assignment2.Information;

import com.pragya.assignment2.Constants.Consonants;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Action {

    Action action = null;

    public static Action getInstance() {
        return new Action();
    }

    //  List<Student> list = new ArrayList<Student>();

    String filePath = "/Users/pragyarustagi/pragyaassignment2/src/main/java/com/pragya/assignment2/Information/Store";

    public void addDetails(List<Student> list) {
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

//      String filePath = "/Users/pragyarustagi/pragyaassignment2/src/main/java/com/pragya/assignment2/Information/Store";
        list.add(new Student(name, rollNo, age, address));
        FileHandler sf = new FileHandler();
        Collections.sort(list);
        sf.writeToFile(list, filePath);
        List<Student> list1 = sf.readFromFile(filePath);
        for (Student st : list1) {
            System.out.printf("%-10s%-7d%-7d%-20s\n",
                    st.getName(), st.getRollNo(), st.getAge(),
                    st.getAddress());

        }
    }


    public void displayDetails() {

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

        } else if (order.equals(Consonants.TWO)) {
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
                default:
                    System.out.println("\nInvalid Option Choosen");
                    break;
            }

        }
    }

    public void deleteDetails() {

        System.out.println("Enter the Roll Number whose Information has to be deleted: ");
        Scanner scan = new Scanner(System.in);
        Integer rollNumber = scan.nextInt();
        FileHandler sf = new FileHandler();
        List<Student> list1 = sf.readFromFile(filePath);
        Integer RnoPresent = 0;
        int t = -1;
        //  List<Student> found = new ArrayList<Student>();
        for (int pos = 0; pos < list1.size(); pos++) {
            if (rollNumber.equals(list1.get(pos).getRollNo())) {
                t = pos;
                //       found.add(st);
            }
        }

        if (t != -1) {
            list1.remove(t);
        }

    /*    if (RnoPresent == 0) {
            System.out.println("Rollno entered by the user doesn't exists!");
        } else {
            list1.removeAll(found);
        } */

        sf.writeToFile(list1, filePath);
        List<Student> li = sf.readFromFile(filePath);
        for (Student st : li) {
            System.out.printf("%-10s%-7d%-7d%-20s\n",
                    st.getName(), st.getRollNo(), st.getAge(),
                    st.getAddress());
        }
    }


    public void saveDetails() {
        FileHandler sf = new FileHandler();
        List<Student> list1 = sf.readFromFile(filePath);
        sf.writeToFile(list1, filePath);
        /*  List<Student> li = sf.readFromFile(filePath);
            for (Student st : li) {
                System.out.printf("%-10s%-7d%-7d%-20s\n",
                        st.getName(), st.getRollNo(), st.getAge(),
                        st.getAddress());
            } */
    }

    public void terminate() {
        Scanner scan = new Scanner(System.in);
        String answer;
        System.out.println("Do you want to save the changes?");
        answer = scan.nextLine();
        if ((Consonants.YES).equalsIgnoreCase(answer)) {
            Action.getInstance().saveDetails();
        } else {
            return;
        }
    }

}