/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class StudentDaoImpl_BTH2 implements StudentDao_BTH2{
    List<Student_BTH2>students;
    public StudentDaoImpl_BTH2(){
        students = new ArrayList<Student_BTH2>();
        Student_BTH2 student1= new Student_BTH2("Robert", 0);
        Student_BTH2 student2= new Student_BTH2("John", 1);
        
        students.add(student1);
        students.add(student2);
    }
    @Override
    public List<Student_BTH2> getAllStudents() {
       return students;
    }

    @Override
    public Student_BTH2 getStudent(int rollNo) {
        return students.get(rollNo);
    }

    @Override
    public void updateStudent(Student_BTH2 student) {
        students.get(student.getRolNo()).setName(student.getName());
        System.out.println("Student:Roll No " + student.getRolNo()+ "update in the database");
    }

    @Override
    public void deleteStudent(Student_BTH2 student) {
        students.remove(student.getRolNo());
        System.out.println("Student:Roll No " + student.getRolNo()+ ", delete from database");
    }
    public static void main(String[] args) {
        StudentDao_BTH2 studentDao = new StudentDaoImpl_BTH2();
        
        for(Student_BTH2 student: studentDao.getAllStudents()){
            System.out.println("Student: [RollNo: " +student.getRolNo()+ " Name:" + student.getName()+ "]");
            
        }
        Student_BTH2 student = studentDao.getAllStudents().get(0);
        student.setName("Michael");
        studentDao.updateStudent(student);
        
        studentDao.getStudent(0);
        System.out.println("Student: [RollNo : " + student.getRolNo()+ ", Name : " + student.getName() + " ]");
    }
}
