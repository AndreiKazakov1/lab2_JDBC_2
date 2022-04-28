package com.company.start;

import com.company.action.UniversityAction;
import com.company.model.University;

import java.sql.Date;
import java.util.Scanner;

public class UniversityOps {
    UniversityAction action_ = new UniversityAction();
    public void choice_2(){
        String DboperationUniversity = "EXIT(0), ADD(1), UPDATE(2), DELETE(3), FETCHBYID(4), "+
                "FETCHBYNUMBEROFFACULTIES(5), FETCHBYNUMBEROFSTUDENTS(6), FETCHALL(7)";
        UniversityOps choice_two = new UniversityOps();
        int value = 0;
        do {
            System.out.println("valid operations are");
            System.out.println(DboperationUniversity);
            System.out.println("Enter valid operation number 0-7");
            Scanner scanner = new Scanner(System.in);
            value = scanner.nextInt();

            switch (value) {
                case 1:
                    choice_two.addUniversity();
                    break;
                case 2:
                    Scanner insert = new Scanner(System.in);
                    System.out.println("Enter ID");
                    int id = insert.nextInt();
                    choice_two.updateUniversity(id);
                    break;
                case 3:
                    choice_two.deleteUniversity();
                    break;
                case 4:
                    choice_two.fetchUniversityById();
                    break;
                case 5:
                    choice_two.fetchByNumFac();//больше к-либо кол-+ва
                    break;
                case 6:
                    choice_two.fetchByNumStud();//диапазон студентов
                    break;
                case 7:
                    choice_two.fetchAllUniversity();
                    break;
                case 0:
                    System.out.println("Exiting code");
                    break;
                default:
                    System.out.println("Not a valid entry");
            }
        } while (value != 0);
    }
    //*******************************************************************************
// for university
    public void addUniversity()

    {
        University university = new University();
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Name");
        university.setName(insert.nextLine());
        System.out.println("Enter accriditationlevel");
        university.setAccriditationlevel(insert.nextInt());
        insert.nextLine();
        System.out.println("Enter creationdate (yyyy-mm-dd)");
        university.setCreationdate(Date.valueOf(insert.nextLine()));
        System.out.println("Enter address");
        university.setAddress(insert.nextLine());
        System.out.println("Enter phone");
        university.setPhone(insert.nextLine());
        System.out.println("Enter  numberoffaculties");
        university.setNumberoffaculties(insert.nextInt());
        System.out.println("Enter numberofstudents");
        university.setNumberofstudents(insert.nextInt());
        action_.insert(university);
    }
    public void updateUniversity(int id)

    {
        University university = new University();
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter Name");
        university.setName(insert.nextLine());
        System.out.println("Enter accriditationlevel");
        university.setAccriditationlevel(insert.nextInt());
        insert.nextLine();
        System.out.println("Enter creationdate");
        university.setCreationdate(Date.valueOf(insert.nextLine()));
        System.out.println("Enter address");
        university.setAddress(insert.nextLine());
        System.out.println("Enter phone");
        university.setPhone(insert.nextLine());
        System.out.println("Enter  numberoffaculties");
        university.setNumberoffaculties(insert.nextInt());
        System.out.println("Enter numberofstudents");
        university.setNumberofstudents(insert.nextInt());
        action_.update(university, id);
    }

    public void deleteUniversity(){
        Scanner insert= new Scanner(System.in);
        System.out.println("Enter university Id");
        int id = insert.nextInt();
        action_.delete(id);
    }
    public void fetchUniversityById(){
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter university Id");
        int id = insert.nextInt();
        action_.fetchById(id);
    }

    public void fetchByNumFac(){
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter number of faculties ");
        int numFac  = insert.nextInt();
        action_.fetchByNumFc(numFac);
    }

    public void fetchByNumStud(){
        Scanner insert = new Scanner(System.in);
        System.out.println("Enter number of students_1 ");
        int st_1  = insert.nextInt();
        System.out.println("Enter number of students_2 ");
        int st_2  = insert.nextInt();
        action_.fetchByNumSt(st_1, st_2);
    }
    public void fetchAllUniversity(){
        action_.fetchAll();
    }
}
