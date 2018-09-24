package com.pragya.assignment2.Information;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class StudentFileStream {

        public void writeToFile(List<Student> list, String file) {
            ObjectOutputStream outStream = null;
            try {
                outStream = new ObjectOutputStream(new FileOutputStream (file));
                for (Student p : list) {
                    outStream.writeObject(p);
                }

            } catch (IOException ex) {
                System.err.println("Error opening file.");
            } finally {
                try {
                    if (outStream != null)
                        outStream.close();
                } catch (IOException ioException) {
                    System.err.println("Error closing file.");
                }
            }


        }

    public List<Student> readFromFile(String file) {
        List<Student> list = new ArrayList<Student>();
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream(file));
            while (true) {
                Student p = (Student) inputStream.readObject();
                list.add(p);
            }
        } catch (EOFException eofException) {
            return list;
        } catch (ClassNotFoundException classNotFoundException) {
            System.err.println("Object creation failed.");
        } catch (IOException ioException) {
            System.err.println("Error opening file.");
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException ioException) {
                System.err.println("Error closing file.");
            }
        }
        return list;
    }
}
