/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTTH;

import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface StudentDao_BTH2 {
    public List<Student_BTH2> getAllStudents();
    
    public Student_BTH2 getStudent(int rollNo);
    
    public void updateStudent(Student_BTH2 student);
    
    public void deleteStudent(Student_BTH2 student);
}
