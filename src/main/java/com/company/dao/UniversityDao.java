package com.company.dao;

import com.company.model.Student;
import com.company.model.University;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UniversityDao {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    int status;

    public int insert (University university){
        con = ConnectionFactory.getConnection();
        try {
            String query = "insert into university (name, accriditationlevel, creationdate," +
                    "address, phone, numberoffaculties, numberofstudents) values(?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, university.getName());
            ps.setInt(2, university.getAccriditationlevel());
            ps.setDate(3, university.getCreationdate());
            ps.setString(4, university.getAddress());
            ps.setString(5, university.getPhone());
            ps.setInt(6, university.getNumberoffaculties());
            ps.setInt(7, university.getNumberofstudents());


            status = ps.executeUpdate();
            System.out.println("inserted university " + status);
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

    public int update (University university, int id){
        con = ConnectionFactory.getConnection();
        try{
            String query = "update university set name=?,accriditationlevel=?,creationdate=?," +
                    "address=?,phone=?,numberoffaculties=?, "
                    + "numberofstudents=? where universityid=?";
            ps = con.prepareStatement(query);
            ps.setString(1, university.getName());
            ps.setInt(2, university.getAccriditationlevel());
            ps.setDate(3, university.getCreationdate());
            ps.setString(4, university.getAddress());
            ps.setString(5, university.getPhone());
            ps.setInt(6, university.getNumberoffaculties());
            ps.setInt(7, university.getNumberofstudents());
            ps.setInt(8, id);

            status = ps.executeUpdate();
            System.out.println("updated university" + status);
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

    public  int delete (int id){
        con = ConnectionFactory.getConnection();
        try{
            String query = "delete from university where universityid=?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            status = ps.executeUpdate();
            System.out.println("deleted university  " + status);
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


    public University fetchById(int id){
        University university = new University();
        con = ConnectionFactory.getConnection();
        try{
            String query = "select * from university where universityid =?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()){
                university.setUniversityid(rs.getInt("universityid"));
                university.setName(rs.getString("name"));
                university.setAccriditationlevel(rs.getInt("accriditationlevel"));
                university.setCreationdate(rs.getDate("creationdate"));
                university.setAddress(rs.getString("address"));
                university.setPhone(rs.getString("phone"));
                university.setNumberoffaculties(rs.getInt("numberoffaculties"));
                university.setNumberofstudents(rs.getInt("numberofstudents"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                con.close();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }return university;
    }

    public List<University> fetchByNumFc(int numFac) {
        List<University> universityList = new ArrayList<>();

        con = ConnectionFactory.getConnection();
        try {
            String query  = "select * from university where numberoffaculties > ?  ";
            ps = con.prepareStatement(query);
            ps.setInt(1, numFac);
            rs = ps.executeQuery();
            while (rs.next()) {
                University university = new University();
                university.setUniversityid(rs.getInt("universityid"));
                university.setName(rs.getString("name"));
                university.setAccriditationlevel(rs.getInt("accriditationlevel"));
                university.setCreationdate(rs.getDate("creationdate"));
                university.setAddress(rs.getString("address"));
                university.setPhone(rs.getString("phone"));
                university.setNumberoffaculties(rs.getInt("numberoffaculties"));
                university.setNumberofstudents(rs.getInt("numberofstudents"));
                universityList.add(university);
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
        return universityList;
    }

    public List<University> fetchByNumSt(int st1, int st2) {
        List<University> universityList = new ArrayList<>();

        con = ConnectionFactory.getConnection();
        try {
            String query  = "select * from university where numberofstudents between ? and ? ";
            ps = con.prepareStatement(query);
            ps.setInt(1, st1);
            ps.setInt(2, st2);
            rs = ps.executeQuery();
            while (rs.next()) {
                University university = new University();
                university.setUniversityid(rs.getInt("universityid"));
                university.setName(rs.getString("name"));
                university.setAccriditationlevel(rs.getInt("accriditationlevel"));
                university.setCreationdate(rs.getDate("creationdate"));
                university.setAddress(rs.getString("address"));
                university.setPhone(rs.getString("phone"));
                university.setNumberoffaculties(rs.getInt("numberoffaculties"));
                university.setNumberofstudents(rs.getInt("numberofstudents"));
                universityList.add(university);
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
        return universityList;
    }

    public List<University> fetchAll() {
        List<University> universityList = new ArrayList<>();

        con = ConnectionFactory.getConnection();
        try {
            String query  = "select * from university order by universityid";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                University university = new University();
                university.setUniversityid(rs.getInt("universityid"));
                university.setName(rs.getString("name"));
                university.setAccriditationlevel(rs.getInt("accriditationlevel"));
                university.setCreationdate(rs.getDate("creationdate"));
                university.setAddress(rs.getString("address"));
                university.setPhone(rs.getString("phone"));
                university.setNumberoffaculties(rs.getInt("numberoffaculties"));
                university.setNumberofstudents(rs.getInt("numberofstudents"));
                universityList.add(university);
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
        return universityList;
    }


}
