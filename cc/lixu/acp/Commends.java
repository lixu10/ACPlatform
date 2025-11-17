package cc.lixu.acp;
import cc.lixu.acp.courseop.CourseDelete;
import cc.lixu.acp.courseop.Coursesort;
import cc.lixu.acp.courseop.isConflict;
import cc.lixu.acp.courseop.isConflict_stu;
import cc.lixu.acp.judge.*;
import cc.lixu.acp.userop.Logout;

import java.util.Map;
import java.util.Objects;


public class Commends {
    static public void quit(String[] strs){
        if(strs.length > 1) {
            System.out.println("Illegal argument count");return ;
        }
        while (!Const.UserList.isEmpty()) {
            String uid = Const.UserList.get(0);
            Logout.logout(uid);
        }
        System.out.println("----- Good Bye! -----");
    }
    static public void register(String[] strs){
        if(strs.length != 6) {
            System.out.println("Illegal argument count"); 
            return;
        }
        String id = strs[1];
        String name = strs[2];
        String pw = strs[3];
        String repw = strs[4];
        String type = strs[5];
        if(!ID.isvalid(id)){
            System.out.println("Illegal user id");
            return ;
        }
        if(Const.UsersMap.containsKey(id)){
            System.out.println("User id exists");
            return ;
        }
        if(!Name.isvalid(name)){
            System.out.println("Illegal user name");
            return ;
        }
        if(!Password.isvalid(pw)){
            System.out.println("Illegal password");
            return ;
        }
        if(!pw.equals(repw)){
            System.out.println("Passwords do not match");
            return ;
        }
        if(!Type.isvalid(type)){
            System.out.println("Illegal identity");
            return ;
        }
        Const.UsersMap.put(id, new User(id, name, pw, type));
        System.out.println("Register success");
        return;
    }
    static public void login(String[] strs){
        if(strs.length !=3) {System.out.println("Illegal argument count"); return;}
        String id = strs[1];
        String pw = strs[2];
        if(!ID.isvalid(id)){
            System.out.println("Illegal user id");
            return ;
        }
        if(!Const.UsersMap.containsKey(id)){
            System.out.println("User does not exist");
            return ;
        }
        User user = Const.UsersMap.get(id);
        if(user.isLogin()){
            System.out.println(id + " is online");
            return ;
        }
        if (!user.getPassword().equals(pw)){
            System.out.println("Wrong password");
            return ;
        }
        user.setLogin(true);
        user.loginTime = ++Const.LoginNum ;
        Const.UserList.add(id);
        System.out.println("Welcome to ACP, " + id);
    }
    static public void logout(String[] strs){
        if(strs.length != 1 && strs.length !=2) {System.out.println("Illegal argument count"); return;}
        if(strs.length == 1){
            if(Const.UserList.isEmpty()){
                System.out.println("No one is online");
                return ;
            }
            String logoutId = Const.UserList.get(Const.UserList.size()-1);
            Logout.logout(logoutId);
            return;
        }
        if(Const.UserList.isEmpty()){
            System.out.println("No one is online");
            return ;
        }
        String logoutId = strs[1];
        String NowID = Const.UserList.get(Const.UserList.size()-1);
        if(!Objects.equals(Const.UsersMap.get(NowID).getType(), "Administrator")){
            System.out.println("Permission denied");
            return ;
        }
        if(!ID.isvalid(logoutId)){
            System.out.println("Illegal user id");
            return ;
        }
        if(!Const.UsersMap.containsKey(logoutId)){
            System.out.println("User does not exist");
            return ;
        }
        if(!Const.UsersMap.get(logoutId).isLogin()){
            System.out.println(logoutId + " is not online");
            return;
        }
        Logout.logout(logoutId);
    }
    static public void printInfo(String[] strs){
        if(strs.length != 1 && strs.length !=2) {System.out.println("Illegal argument count"); return;}
        if(strs.length == 1){
            if(Const.UserList.isEmpty()){
                System.out.println("No one is online");
                return ;
            }
            System.out.println(Const.UsersMap.get(Const.UserList.get(Const.UserList.size()-1)).toString());
            return;
        }
        if(Const.UserList.isEmpty()){
            System.out.println("No one is online");
            return ;
        }
        String printId = strs[1];
        String NowID = Const.UserList.get(Const.UserList.size()-1);
        if(!Objects.equals(Const.UsersMap.get(NowID).getType(), "Administrator")){
            System.out.println("Permission denied");
            return ;
        }
        if(!ID.isvalid(printId)){
            System.out.println("Illegal user id");
            return ;
        }
        if(!Const.UsersMap.containsKey(printId)){
            System.out.println("User does not exist");
            return ;
        }
        System.out.println(Const.UsersMap.get(printId).toString());
    }
    static public void createCourse(String[] strs){
        if(strs.length != 5){
            System.out.println("Illegal argument count");
            return;
        }
        String courseName = strs[1];
        String time = strs[2];
        String score = strs[3];
        String studytime = strs[4];
        if(Const.UserList.isEmpty()){
            System.out.println("No one is online");
            return ;
        }
        String NowID = Const.UserList.get(Const.UserList.size()-1);
        User NowTeacher = Const.UsersMap.get(NowID);
        if(!Objects.equals(NowTeacher.getType(), "Teacher")){
            System.out.println("Permission denied");
            return ;
        }
        if(NowTeacher.courses.size() >= 10){
            System.out.println("Course count reaches limit");
            return;
        }
        if(!CourseName.isvalid(courseName)){
            System.out.println("Illegal course name");
            return;
        }
        if(NowTeacher.courses.containsKey(courseName)){
            System.out.println("Course name exists");
            return;
        }
        if(!CourseTime.isvalid(time)){
            System.out.println("Illegal course time");
            return;
        }
        if(isConflict.is_Conflict(NowTeacher, time)){
            System.out.println("Course time conflicts");
            return;
        }
        if(!CourseScore.isvalid(score)){
            System.out.println("Illegal course credit");
            return;
        }
        if(!CourseStudyTime.isvalid(studytime)){
            System.out.println("Illegal course period");
            return;
        }
        Course course = new Course(courseName, time, Double.parseDouble(score), Integer.parseInt(studytime));
        course.setTeacherId(NowID);
        course.setId(++Const.CourseNum);
        Const.CourseMap.put(course.getId(), course);
        NowTeacher.courses.put(courseName, course);
        NowTeacher.coursesAll.add(course);
        System.out.println("Create course success (courseId: C-" + course.getId() + ")");
    }
    static public void listCourse(String[] strs){
        if(strs.length != 1 && strs.length !=2) {System.out.println("Illegal argument count"); return;}
        if(Const.UserList.isEmpty()){
            System.out.println("No one is online");
            return ;
        }
        User requestUser = Const.UsersMap.get(Const.UserList.get(Const.UserList.size()-1));
        if(strs.length == 1){
            if(requestUser.getType().equals("Student")||requestUser.getType().equals("Administrator")){

                Const.Courselist.clear();
                Const.Courselist.addAll(Const.CourseMap.entrySet());
                
                if(Const.Courselist.isEmpty()){
                    System.out.println("Course does not exist");
                    return ;
                }
                Coursesort.sort();
                for(Map.Entry<Long, Course> i: Const.Courselist){
                    System.out.println(Const.UsersMap.get(i.getValue().getTeacherId()).getName() + " " +i.getValue());
                }
                System.out.println("List course success");return;
            } else if (requestUser.getType().equals("Teacher")) {
                if(requestUser.courses.isEmpty()){
                    System.out.println("Course does not exist");
                    return ;
                }
                for(Course i: requestUser.coursesAll){
                    System.out.println(i);
                }
                System.out.println("List course success");return;
            }
        }else{
            String teacherId = strs[1];
            if(!Objects.equals(requestUser.getType(), "Administrator")){
                System.out.println("Permission denied");
                return ;
            }
            if(!ID.isvalid(teacherId)){
                System.out.println("Illegal user id");
                return ;
            }
            if(!Const.UsersMap.containsKey(teacherId)){
                System.out.println("User does not exist");
                return ;
            }
            User teacherNow = Const.UsersMap.get(teacherId);
            if(!Objects.equals(teacherNow.getType(), "Teacher")){
                System.out.println("User id does not belong to a Teacher");
                return ;
            }
            if(teacherNow.courses.isEmpty()){
                System.out.println("Course does not exist");
                return ;
            }
            for(Course i: teacherNow.coursesAll){
                System.out.println(Const.UsersMap.get(i.getTeacherId()).getName() + " " +i);
            }
            System.out.println("List course success");return;
        }
    }
    static public void selectCourse(String[] strs){
        if(strs.length != 2){
            System.out.println("Illegal argument count");
            return ;
        }
        String lessonId = strs[1];
        if(Const.UserList.isEmpty()){
            System.out.println("No one is online");
            return ;
        }
        User nowUser = Const.UsersMap.get(Const.UserList.get(Const.UserList.size()-1));
        if(!nowUser.getType().equals("Student")){
            System.out.println("Permission denied");
            return ;
        }
        if(!CourseId.isvalid(lessonId)){
            System.out.println("Illegal course id");
            return;
        }
        if(!Const.CourseMap.containsKey(Long.parseLong(lessonId.substring(2)))){
            System.out.println("Course does not exist");
            return;
        }
        Course nowLesson = Const.CourseMap.get(Long.parseLong(lessonId.substring(2)));
        if(isConflict_stu.is_Conflict(nowUser, nowLesson)){
            System.out.println("Course time conflicts");
            return;
        }
        nowUser.StuCourses.add(nowLesson);
        nowLesson.selectStu.add(nowUser);
        System.out.println("Select course success (courseId: "+lessonId+")");
    }
    static public void cancelCourse(String[] strs){
        if(strs.length != 2){
            System.out.println("Illegal argument count");
            return ;
        }
        String lessonId = strs[1];
        if(Const.UserList.isEmpty()){
            System.out.println("No one is online");
            return ;
        }
        if(!CourseId.isvalid(lessonId)){
            System.out.println("Illegal course id");
            return;
        }
        User nowUser = Const.UsersMap.get(Const.UserList.get(Const.UserList.size()-1));
        if(!Const.CourseMap.containsKey(Long.parseLong(lessonId.substring(2)))){
            System.out.println("Course does not exist");
            return;
        }
        Course nowLesson = Const.CourseMap.get(Long.parseLong(lessonId.substring(2)));
        if(nowUser.getType().equals("Student")){
            if(!nowUser.StuCourses.contains(nowLesson)){
                System.out.println("Course does not exist");return;
            }
            nowUser.StuCourses.remove(nowLesson);
            nowLesson.selectStu.remove(nowUser);
            System.out.println("Cancel course success (courseId: "+lessonId+")"); return;
        } else if (nowUser.getType().equals("Teacher")) {
            if(!nowUser.coursesAll.contains(nowLesson)){
                System.out.println("Course does not exist");return;
            }
            CourseDelete.delete(nowLesson);
            System.out.println("Cancel course success (courseId: "+lessonId+")"); return;
        }
        CourseDelete.delete(nowLesson);
        System.out.println("Cancel course success (courseId: "+lessonId+")"); return;
    }
    static public void unknownCommend(String[] strs){
        System.out.println("Command '" + strs[0] + "' not found");
    }


}
