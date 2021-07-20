package com.spring.database;

import java.util.List;
import java.util.Scanner;

public class Database {
    //connect function
    public int login(MemberJDBCTemplate memberJDBCTemplate, String[] input, Scanner scanner){

        //設定密碼輸入次數
        for (int i = 0;i<5;i++){
            if(i!=0){
                System.out.println("帳號或密碼錯誤，請重新輸入，剩餘"+(5-i)+"次機會");
            }
            System.out.print("輸入要帳號: ");
            input[0] = scanner.next();
            System.out.print("請輸入密碼: ");
            input[1] = scanner.next();
            //從資料庫透過帳號找數據
            List<Member> members = memberJDBCTemplate.listMembers(input[0]);
            for(Member member : members){
                //從抓出來的資料比對密碼
                if(member.getPassword().equals(input[1])){
                    System.out.println("Login success");
                    return member.getId();
                }
            }//end for
        }//end for
        System.out.println("Login failed");
        System.out.println("即將結束程式");
        return 0;
    }//end login
    public void register_account(int id,MemberJDBCTemplate memberJDBCTemplate,String[] input,Scanner scanner){
        //新增用戶
        for(int i=0;i<2;i++){
            if(i == 0)System.out.println("請輸入帳號: ");
            else if(i == 1)System.out.println("請輸入密碼: ");
            input[i] = scanner.next();
        }
        //jdbc create
        memberJDBCTemplate.create(input[0],input[1]);
        memberJDBCTemplate.set_login_date(id);
        System.out.println("註冊成功");
    }
    public void update_password(int id,MemberJDBCTemplate memberJDBCTemplate,String[] input,Scanner scanner){
        //請輸入新密碼
        System.out.println("請輸入新密碼");
        input[0] = scanner.next();
        memberJDBCTemplate.update_password(id,input[0]);
    }
}

