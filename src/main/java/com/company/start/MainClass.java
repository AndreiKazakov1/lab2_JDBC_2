package com.company.start;


import java.util.Scanner;
public class MainClass {

    //ЗАДАЧИ
//1.	В классе MainClass определить возов методов и проверить их реализацию. Определить вызываемый метод в StudentAction
//2.	В классе StudentAction проверить реализацию соответствующего метода.
//3.	В классе StudentDao определить недостающие методы для соответствующих действий пользователя.
// 4.	Добавить еще 1 сущность и выполнить несколько операций (2-4).!!!
//
// ДОБАВЛЕНА СУЩНОСТЬ  University И ВЫДЕЛЕНЫ StudentOps И UniversityOps


    public static void main (String[] args) {

        String MakeChoise = "EXIT(0), WORKWITHSTUDENTS(1), WORKWITHUNIVERSITY(2)";
        StudentOps choice1 = new StudentOps();
        UniversityOps choice2 = new UniversityOps();
        int value_x = 0;
        do{
            System.out.println("valid operations are");
            System.out.println(MakeChoise);
            System.out.println("Enter valid operation number 0, 1 or 2");
            Scanner scanner = new Scanner(System.in);
            value_x = scanner.nextInt();
            switch (value_x) {
                case 1:
                   choice1.choice_1();
                    break;
                case 2:
                    choice2.choice_2();
                    break;
                case 0:
                    System.out.println("Exiting code");
                    break;
                default:
                    System.out.println("Not a valid entry");
            }
        } while (value_x != 0);
    }

}

