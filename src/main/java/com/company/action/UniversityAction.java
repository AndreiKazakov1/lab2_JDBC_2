package com.company.action;


import com.company.dao.UniversityDao;

import com.company.model.University;

import java.util.List;


public class UniversityAction {
    UniversityDao universityDao = new UniversityDao();
    int status;

    public void insert(University university){
        status = universityDao.insert(university);
        if (status == 1) {
            System.out.println("Student Inserted Successfully");
        } else if (status == -1) {
            System.out.println("Student Already exists");
        } else {
            System.out.println("Unable to Insert Student");
        }
    }
    public void update(University university, int id){
        status = universityDao.update(university, id);
        if (status == 1) {
            System.out.println("University Updated Successfully");
        } else {
            System.out.println("Unable to update University");
        }
    }

    public void delete(int id) {
        status = universityDao.delete(id);
        if (status == 1) {
            System.out.println("University Deleted Successfully");
        } else {
            System.out.println("No Record Found");
        }
    }

    public void fetchById(int id) {
        University university = universityDao.fetchById(id);
        if (university.getUniversityid() == 0) {
            System.out.println("No Record Found");
        } else {
            System.out.println("Student Details are :");
            System.out.println(university);
        }
    }

    public void fetchByNumFc(int numFac) {
        List<University> universityList = universityDao.fetchByNumFc(numFac);
        if (universityList.isEmpty()) {
            System.out.println("No Record Found");
        } else {
            System.out.println("University Details are :");
            for (University university: universityList) {
                System.out.println(university);
            }
        }
    }

    public void fetchByNumSt(int st1, int st2) {
        List<University> universityList = universityDao.fetchByNumSt(st1, st2);
        if (universityList.isEmpty()) {
            System.out.println("No Record Found");
        } else {
            System.out.println("University Details are :");
            for (University university: universityList) {
                System.out.println(university);
            }
        }
    }

    public void fetchAll() {
        List<University> universityList = universityDao.fetchAll();
        if (universityList.isEmpty()) {
            System.out.println("No Record Found");
        } else {
            System.out.println("Student Details are :");
            for (University university : universityList) {
                System.out.println(university);
            }
        }
    }

}
