package JavaGUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class StudentModify {

    private ArrayList<Student> list = new ArrayList<>();

    private void importFromFile() {
        list.clear();
        String fName = "Student.txt";
        try {
            File f = new File(fName);
            if (!f.exists()) {
                System.out.println(fName + " doesn't exist.");
                return;
            }
            FileReader fr = new FileReader(f); //doc file
            BufferedReader bf = new BufferedReader(fr); //luu vao bo nho
            String details;
            while ((details = bf.readLine()) != null) { //doc tung dong
                String attribute[] = details.split(", ");
                list.add(new Student(attribute[0], attribute[1], Integer.parseInt(attribute[2]), attribute[3], attribute[4]));
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Error!");
            return;
        }
    }

    private void exportToFile() {
        String fName = "Student.txt";
        try {
            File f = new File(fName);
            if (!f.exists()) {
                System.out.println(fName + " doesn't exist.");
                return;
            }
            FileWriter fr = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fr);
            for (Student student : list) {
                pw.println(student.toString());
            }
            pw.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Error!");
        }
    }

    public ArrayList<Student> findAll() {
        importFromFile();
        return list;
    }

    public void insert(Student student) {
        importFromFile();//co cai nay de clear list sau do add o duoi xuong cuoi
        list.add(new Student(student.getFullName(), student.getGender(), student.getAge(), student.getEmail(), student.getPhone()));
        exportToFile();
    }

    public void delete(int id) {
        importFromFile();
        try {
            list.remove(id);
        } catch (Exception e) {
            System.out.println("Can't delete student");
        }
        exportToFile();
    }

    public ArrayList<Student> findByFullname(String fullname) {
        importFromFile();
        ArrayList<Student> studentList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getFullName().contains(fullname)) {
                studentList.add(list.get(i));
            }
        }
        return studentList;
    }

}
