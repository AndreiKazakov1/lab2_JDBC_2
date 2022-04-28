package com.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.company.model.Student;
import java.sql.SQLIntegrityConstraintViolationException;
import java.math.BigDecimal;
import java.sql.Date;


public class StudentDao {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int status;

    public int insert (Student student){
        con = ConnectionFactory.getConnection();
        try {
            String query = "insert into student (fname,lname,address,mobile_no,email_id,city," +
                    "designation,dob,doj,salary)"+ "values(?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, student.getFname());
            ps.setString(2, student.getLname());
            ps.setString(3, student.getAddress());
            ps.setString(4, student.getMobileNo());
            ps.setString(5, student.getMailId());
            ps.setString(6, student.getCity());
            ps.setString(7, student.getDesignation());
            ps.setDate(8, student.getDob());
            ps.setDate(9, student.getDoj());
            ps.setBigDecimal(10, student.getSalary());

            status = ps.executeUpdate();
            System.out.println("inserted student " + status);
        } catch (SQLIntegrityConstraintViolationException e){
            status = -1;
            e.printStackTrace();
        }catch (Exception e){
            status = -2;
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        } return status;
    }

    public int update(Student student, Long id){
        con = ConnectionFactory.getConnection();
        try{
            String query = "update student set fname=?,lname=?,address=?,mobile_no=?,email_id=?,city=?, "
                    + "designation=?,dob=?,doj=?,salary=? "
                    + "where id=? ";
            ps = con.prepareStatement(query);
            ps.setString(1, student.getFname());
            ps.setString(2, student.getLname());
            ps.setString(3, student.getAddress());
            ps.setString(4, student.getMobileNo());
            ps.setString(5, student.getMailId());
            ps.setString(6, student.getCity());
            ps.setString(7, student.getDesignation());
            ps.setDate(8, student.getDob());
            ps.setDate(9, student.getDoj());
            ps.setBigDecimal(10, student.getSalary());
            ps.setLong(11, id);

            status = ps.executeUpdate();
            System.out.println("updated student" + status);
        }catch (Exception e){
            status = -2;
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }return status;
    }

    public  int delete (long id){
        con = ConnectionFactory.getConnection();
        try{
            String query = "delete from student where id=?";
            ps = con.prepareStatement(query);
            ps.setLong(1, id);
            status = ps.executeUpdate();
            System.out.println("deleted student" + status);
        }catch (Exception e){
            status = -2;
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }return status;

    }

    public Student fetchById(long id){
        Student student = new Student();
        con = ConnectionFactory.getConnection();
        try{
            String query = "select * from student where id =?";
            ps = con.prepareStatement(query);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
                student.setId(rs.getLong("id"));
                student.setFname(rs.getString("fname"));
                student.setLname(rs.getString("lname"));
                student.setAddress(rs.getString("address"));
                student.setMobileNo(rs.getString("mobile_no"));
                student.setMailId(rs.getString("email_id"));
                student.setCity(rs.getString("city"));
                student.setDesignation(rs.getString("designation"));
                student.setDob(rs.getDate("dob"));
                student.setDoj(rs.getDate("doj"));
                student.setSalary(rs.getBigDecimal("salary"));
                student.setAddDate(rs.getTimestamp("add_date"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }return student;
    }
//*******************************************************+
    //********Найти студентов по emailID
    public Student fetchByEmailId(String emailId){
        Student student= new Student();
        con = ConnectionFactory.getConnection();
        try{
            String query = "select * from student where mailId =?";
            ps = con.prepareStatement(query);
            ps.setString(1, emailId);
            rs = ps.executeQuery();
            while (rs.next()){
                student.setId(rs.getLong("id"));
                student.setFname(rs.getString("fname"));
                student.setLname(rs.getString("lname"));
                student.setAddress(rs.getString("address"));
                student.setMobileNo(rs.getString("mobile_no"));
                student.setMailId(rs.getString("email_id"));
                student.setCity(rs.getString("city"));
                student.setDesignation(rs.getString("designation"));
                student.setDob(rs.getDate("dob"));
                student.setDoj(rs.getDate("doj"));
                student.setSalary(rs.getBigDecimal("salary"));
                student.setAddDate(rs.getTimestamp("add_date"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }return student;
    }
//**********************************************************
    //********Найти студентов по Номеру телефона
    public Student fetchByMobileNo (String mobileNo){
        Student student = new Student();
        con = ConnectionFactory.getConnection();
        try{
            String query = "select * from student where mobileNo =?";
            ps = con.prepareStatement(query);
            ps.setString(1, mobileNo);
            rs = ps.executeQuery();
            while (rs.next()){
                student.setId(rs.getLong("id"));
                student.setFname(rs.getString("fname"));
                student.setLname(rs.getString("lname"));
                student.setAddress(rs.getString("address"));
                student.setMobileNo(rs.getString("mobile_no"));
                student.setMailId(rs.getString("email_id"));
                student.setCity(rs.getString("city"));
                student.setDesignation(rs.getString("designation"));
                student.setDob(rs.getDate("dob"));
                student.setDoj(rs.getDate("doj"));
                student.setSalary(rs.getBigDecimal("salary"));
                student.setAddDate(rs.getTimestamp("add_date"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }return student;
    }
//*************************************************************************************
    //**********Найти студентов по Имени
//*********************Модернизируйте метод. С возможностью искать и по имени и по фамилии с помощью слова like
    public List<Student> fetchByName (String name){
        List<Student> studentList = new ArrayList<Student>();
        con = ConnectionFactory.getConnection();
        try {
            String query = "select * from student where fname=?";
            ps = con.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setFname(rs.getString("fname"));
                student.setLname(rs.getString("lname"));
                student.setAddress(rs.getString("address"));
                student.setMobileNo(rs.getString("mobile_no"));
                student.setMailId(rs.getString("email_id"));
                student.setCity(rs.getString("city"));
                student.setDesignation(rs.getString("designation"));
                student.setDob(rs.getDate("dob"));
                student.setDoj(rs.getDate("doj"));
                student.setSalary(rs.getBigDecimal("salary"));
                student.setAddDate(rs.getTimestamp("add_date"));
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return studentList;
    }
    //модернизированный
    public List<Student> fetchByFnameLname (String fname, String lname){
        List<Student> studentList = new ArrayList<Student>();
        con = ConnectionFactory.getConnection();
        try {
            String query = "select * from student where fname like ? and lname like ?";
            ps = con.prepareStatement(query);
            ps.setString(1, '%'+fname+'%');
            ps.setString(2, '%'+lname+'%');
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setFname(rs.getString("fname"));
                student.setLname(rs.getString("lname"));
                student.setAddress(rs.getString("address"));
                student.setMobileNo(rs.getString("mobile_no"));
                student.setMailId(rs.getString("email_id"));
                student.setCity(rs.getString("city"));
                student.setDesignation(rs.getString("designation"));
                student.setDob(rs.getDate("dob"));
                student.setDoj(rs.getDate("doj"));
                student.setSalary(rs.getBigDecimal("salary"));
                student.setAddDate(rs.getTimestamp("add_date"));
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return studentList;
    }

//**************************************************************************************
    public List<Student> fetchByCity(String city){
        List<Student> studentList= new ArrayList<Student>();

        con = ConnectionFactory.getConnection();
        try{
            String query = "select * from student where city=?";
            ps = con.prepareStatement(query);
            ps.setString(1, city);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setFname(rs.getString("fname"));
                student.setLname(rs.getString("lname"));
                student.setAddress(rs.getString("address"));
                student.setMobileNo(rs.getString("mobile_no"));
                student.setMailId(rs.getString("email_id"));
                student.setCity(rs.getString("city"));
                student.setDesignation(rs.getString("designation"));
                student.setDob(rs.getDate("dob"));
                student.setDoj(rs.getDate("doj"));
                student.setSalary(rs.getBigDecimal("salary"));
                student.setAddDate(rs.getTimestamp("add_date"));
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return studentList;
    }
//****************************************************************************
    //***********Найти студентов с ЗП в пределах От и До
    public List<Student> fetchBySalaryRange(BigDecimal lowerSalary, BigDecimal higherSalary) {
        List<Student> studentList = new ArrayList<>();

        con = ConnectionFactory.getConnection();
        try {
            String query  = "select * from student where salary between ? and ? ";
            ps = con.prepareStatement(query);
            ps.setBigDecimal(1, lowerSalary);
            ps.setBigDecimal(2, higherSalary);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setFname(rs.getString("fname"));
                student.setLname(rs.getString("lname"));
                student.setAddress(rs.getString("address"));
                student.setMobileNo(rs.getString("mobile_no"));
                student.setMailId(rs.getString("email_id"));
                student.setCity(rs.getString("city"));
                student.setDesignation(rs.getString("designation"));
                student.setDob(rs.getDate("dob"));
                student.setDoj(rs.getDate("doj"));
                student.setSalary(rs.getBigDecimal("salary"));
                student.setAddDate(rs.getTimestamp("add_date"));
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return studentList;
    }


    //*************************************************************************

    public List<Student> fetchByDob(Date dob) {
        List<Student> studentList = new ArrayList<Student>();

        con = ConnectionFactory.getConnection();
        try {
            String query = "select * from student where dob=?";
            ps = con.prepareStatement(query);
            ps.setDate(1, dob);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setFname(rs.getString("fname"));
                student.setLname(rs.getString("lname"));
                student.setAddress(rs.getString("address"));
                student.setMobileNo(rs.getString("mobile_no"));
                student.setMailId(rs.getString("email_id"));
                student.setCity(rs.getString("city"));
                student.setDesignation(rs.getString("designation"));
                student.setDob(rs.getDate("dob"));
                student.setDoj(rs.getDate("doj"));
                student.setSalary(rs.getBigDecimal("salary"));
                student.setAddDate(rs.getTimestamp("add_date"));
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return studentList;
    }

    //*************************************************************************
    //********Найти студентов с датами От и До
    public List<Student> fetchByRangeDoj(Date startDate, Date endDate) {
        List<Student> studentList = new ArrayList<Student>();

        con = ConnectionFactory.getConnection();
        try {
            String query = "select * from student where doj between ? and ?";
            ps = con.prepareStatement(query);
            ps.setDate(1, startDate);
            ps.setDate(2, endDate);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setFname(rs.getString("fname"));
                student.setLname(rs.getString("lname"));
                student.setAddress(rs.getString("address"));
                student.setMobileNo(rs.getString("mobile_no"));
                student.setMailId(rs.getString("email_id"));
                student.setCity(rs.getString("city"));
                student.setDesignation(rs.getString("designation"));
                student.setDob(rs.getDate("dob"));
                student.setDoj(rs.getDate("doj"));
                student.setSalary(rs.getBigDecimal("salary"));
                student.setAddDate(rs.getTimestamp("add_date"));
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return studentList;
    }

    //*****************************************************
//*******************************************************
    //Модернизируйте поиск - отсортировав от большего к меньшему по полю id
    public List<Student> fetchAll() {
        List<Student> studentList = new ArrayList<Student>();

        con = ConnectionFactory.getConnection();
        try {

            // Модернизируйте поиск - отсортировав от большего к меньшему по полю id

            String query = "select * from student order by id";
            //String query = "select * from student order by id desc ";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setFname(rs.getString("fname"));
                student.setLname(rs.getString("lname"));
                student.setAddress(rs.getString("address"));
                student.setMobileNo(rs.getString("mobile_no"));
                student.setMailId(rs.getString("email_id"));
                student.setCity(rs.getString("city"));
                student.setDesignation(rs.getString("designation"));
                student.setDob(rs.getDate("dob"));
                student.setDoj(rs.getDate("doj"));
                student.setSalary(rs.getBigDecimal("salary"));
                student.setAddDate(rs.getTimestamp("add_date"));
                studentList.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return studentList;
    }
}



































