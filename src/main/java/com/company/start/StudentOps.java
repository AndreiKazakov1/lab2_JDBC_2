package com.company.start;

import com.company.action.StudentAction;
import com.company.model.Student;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Scanner;

public class StudentOps {
    StudentAction action = new StudentAction();
    public void choice_1(){
        String DbOperationStudent = "EXIT(0), ADD(1), UPDATE(2), DELETE(3), FETCHBYID(4), FETCHBYEMAIL(5), " +
                "FETCHBYMOBNO(6), FETCHBYNAME(7), FETCHBYFNAMELNAME(77), FETCHBYCITY(8), FETCHBYSALRANGE(9), FETCHBYDOB(10)," +
                " FETCHBYDOJRANGE(11), FETCHALL(12)";
        StudentOps choice_one = new StudentOps();
        int value = 0;
        do {
            System.out.println("valid operations are");
            System.out.println(DbOperationStudent);
            System.out.println("Enter valid operation number 0-12");
            Scanner scanner = new Scanner(System.in);
            value = scanner.nextInt();

            switch (value) {
                case 1:
                    choice_one.addStudent();
                    break;
                case 2:
                    Scanner insert = new Scanner(System.in);//исправлен метод updateStudent
                    System.out.println("Enter id");
                    Long id = insert.nextLong();
                    choice_one.updateStudent(id);
                    choice_one.fetchAllStudents();
                    break;
                case 3:
                    choice_one.deleteStudent();
                    break;
                case 4:
                    choice_one.fetchStudentById();
                    break;
                case 5:
                    choice_one.fetchStudentByEmail();
                    break;
                case 6:
                    choice_one.fetchStudentByMobileNo();
                    break;
                case 7:
                    choice_one.fetchStudentByName();
                    break;
                case 77:
                    choice_one.fetchStudentByFnameLname();
                    break;
                case 8:
                    choice_one.fetchStudentByCity();
                    break;
                case 9:
                    choice_one.fetchStudentBySalaryRange();
                    break;
                case 10:
                    choice_one.fetchStudentByDob();
                    break;
                case 11:
                    choice_one.fetchStudentByDOjRange();
                    break;
                case 12:
                    choice_one.fetchAllStudents();
                    break;
                case 0:
                    System.out.println("Exiting code");
                    break;
                default:
                    System.out.println("Not a valid entry");
            }
        } while (value != 0);
    }


    //********************************************************************

    public void addStudent() {
        Student student = new Student();
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter First Name");
        student.setFname(insert.nextLine());
        System.out.println("Enter Last Name");
        student.setLname(insert.nextLine());
        System.out.println("Enter Address");
        student.setAddress(insert.nextLine());
        System.out.println("Enter Mobile Number");
        student.setMobileNo(insert.nextLine());
        System.out.println("Enter Mail Id");
        student.setMailId(insert.nextLine());
        System.out.println("Enter City");
        student.setCity(insert.nextLine());
        System.out.println("Enter Designation");
        student.setDesignation(insert.nextLine());
        System.out.println("Enter Dob (yyyy-mm-dd)");
        student.setDob(Date.valueOf(insert.nextLine()));
        System.out.println("Enter Doj  (yyyy-mm-dd)");
        student.setDoj(Date.valueOf(insert.nextLine()));
        System.out.println("Enter Salary");
        student.setSalary(insert.nextBigDecimal());
        action.insert (student);
    }

    public void updateStudent(Long id){
        Student student = new Student();
        Scanner insert = new Scanner(System.in);
       // System.out.println("Enter id");
        //student.setId(insert.nextLong());
        System.out.println("Enter First Name");
        student.setFname(insert.nextLine());
        System.out.println("Enter Last Name");
        student.setLname(insert.nextLine());
        System.out.println("Enter Address");
        student.setAddress(insert.nextLine());
        System.out.println("Enter Mobile Number");
        student.setMobileNo(insert.nextLine());
        System.out.println("Enter Mail Id");
        student.setMailId(insert.nextLine());
        System.out.println("Enter City");
        student.setCity(insert.nextLine());
        System.out.println("Enter Designation");
        student.setDesignation(insert.nextLine());
        System.out.println("Enter Dob (yyyy-mm-dd)");
        student.setDob(Date.valueOf(insert.nextLine()));
        System.out.println("Enter Doj  (yyyy-mm-dd)");
        student.setDoj(Date.valueOf(insert.nextLine()));
        System.out.println("Enter Salary");
        student.setSalary(insert.nextBigDecimal());
        action.update(student, id);
    }

    public void deleteStudent(){
        Scanner insert= new Scanner(System.in);
        System.out.println("Enter student Id");
        long id = insert.nextLong();
        action.delete(id);
    }

    public void fetchStudentById(){
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter student Id");
        long id = insert.nextLong();
        action.fetchById(id);
    }

    public void fetchStudentByEmail() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Student Mail Id");
        String mailId = insert.nextLine();
        action.fetchByEmailId(mailId);
    }

    public void fetchStudentByMobileNo(){
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Student's Mobile Number ");
        String mobileNo = insert.nextLine();
        action.fetchByMobileNo(mobileNo);
    }

    public void fetchStudentByName(){
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Student's Name");
        String name = insert.nextLine();
        action.fetchByName(name);
    }
    //***********************************************
    //modern
    public  void fetchStudentByFnameLname(){
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Student's First Name");
        String fname = insert.nextLine();
        System.out.println("Enter Student's Last Name");
        String lname = insert.nextLine();
        action.fetchByFnameLname(fname, lname);
    }


    //*********************************

    public void fetchStudentByCity(){
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Student City");
        String city = insert.nextLine();
        action.fetchByCity(city);
    }

    public void fetchStudentBySalaryRange(){
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Salary Start Range ");
        BigDecimal salaryRange1  = insert.nextBigDecimal();
        System.out.println("Enter Salary End Range ");
        BigDecimal salaryRange2  = insert.nextBigDecimal();
        action.fetchBySalaryRange(salaryRange1, salaryRange2);
    }

    public void fetchStudentByDob(){
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Date of Birth (yyyy-mm-dd)");
        String dob = insert.nextLine();
        action.fetchByDob(Date.valueOf(dob));
    }

    public void fetchStudentByDOjRange() {
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Start Date of Joining (yyyy-mm-dd)");
        String doj1 = insert.nextLine();
        System.out.println("Enter End Date of Joining (yyyy-mm-dd)");
        String doj2 = insert.nextLine();
        action.fetchByRangeDoj(Date.valueOf(doj1), Date.valueOf(doj2));
    }

    public void fetchAllStudents(){
        action.fetchAll();
    }
}
