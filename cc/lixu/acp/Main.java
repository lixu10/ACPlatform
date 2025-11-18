package cc.lixu.acp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (Const.UsersMap != null) Const.UsersMap.clear();
        if (Const.UserList != null) Const.UserList.clear();
        if (Const.CourseMap != null) Const.CourseMap.clear();
        if (Const.Courselist != null) Const.Courselist.clear();
        Const.NowUser = null;
        Const.LoginNum = 0;
        Const.CourseNum = 0;
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String str = scan.nextLine();
            if (str.trim().isEmpty()) continue;
            String[] strs = str.trim().split("\\s+");
            commend(strs);
            if ("quit".equals(strs[0])&&strs.length==1) return;
        }

        scan.close();
    }

    public static void commend(String[] strs){
        if (strs.length == 0) return;
        
        String one = strs[0];
        switch (one) {
            case "quit":
                Commends.quit(strs);
                break;

            case "login":
                Commends.login(strs);
                break;

            case "register":
                Commends.register(strs);
                break;

            case "logout":
                Commends.logout(strs);
                break;

            case "printInfo":
                Commends.printInfo(strs);
                break;

            case "createCourse":
                Commends.createCourse(strs);
                break;

            case "listCourse":
                Commends.listCourse(strs);
                break;

            case "selectCourse":
                Commends.selectCourse(strs);
                break;

            case "cancelCourse":
                Commends.cancelCourse(strs);
                break;

            case "switch":
                Commends.switchCommend(strs);
                break;

            case "inputCourseBatch":
                Commends.inputCourseBatch(strs);
                break;

            case "outputCourseBatch":
                Commends.outputCourseBatch(strs);
                break;

            case "listStudent":
                Commends.listStudent(strs);
                break;

            case "removeStudent":
                Commends.removeStudent(strs);
                break;

            case "listCourseSchedule":
                Commends.listCourseSchedule(strs);
                break;

            default:
                Commends.unknownCommend(strs);
                break;
        }

    }
}