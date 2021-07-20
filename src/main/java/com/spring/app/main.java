package com.spring.app;

import com.spring.database.Database;
import com.spring.database.Member;
import com.spring.database.MemberJDBCTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class main {
    public static void main(String[] args) {
        int choice = 0;
        int id = 0;

        Scanner scanner = new Scanner(System.in);
        String[] input =new String[2];
        Database database = new Database();
        ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/resources/beans-config.xml");
        MemberJDBCTemplate memberJDBCTemplate = (MemberJDBCTemplate) context.getBean("memberJDBCTemplate");
        //設定使用者ID
        id = database.login(memberJDBCTemplate, input,scanner);
        //使用者登陸成功
        if(id!=0){
            //設定登陸日期
            memberJDBCTemplate.set_login_date(id);
        }
        //結束程式
        else {return;}
        do {
            System.out.println("1.透過名稱查詢\n2.新增資料(註冊)\n3.更新資料\n4.刪除資料\n5.離開本程式");
            try {
                choice = scanner.nextInt();
            }catch (Exception e){
                System.out.println("請輸入介於1~5的整數");
                scanner.nextLine();
            }
            switch (choice){
                case 1:
                    //查詢
                    System.out.print("輸入要帳號: ");
                    input[0] = scanner.next();
                    List<Member> members = memberJDBCTemplate.listMembers(input[0]);
                    for(Member member : members){
                        System.out.print("ID : " + member.getId() );
                        System.out.print(", Name : " + member.getName() );
                        System.out.println(", Last login : " + member.getLast_login());
                    }
                    break;
                case 2:
                    database.register_account(id,memberJDBCTemplate,input,scanner);
                    break;
                case 3:
                    //更新密碼
                    database.update_password(id,memberJDBCTemplate,input,scanner);
                    break;
                case 4:
                    //刪除資料
                    memberJDBCTemplate.delete(id);
                    break;
                case 5:
                    //離開程式
                    break;
                default:
                    //輸入不是1~5
                    System.out.println("輸入錯誤 ");
            }
        }while (choice != 5);//輸入5離開程式
    }//end main


}
