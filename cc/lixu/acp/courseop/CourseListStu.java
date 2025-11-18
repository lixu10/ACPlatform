package cc.lixu.acp.courseop;

import cc.lixu.acp.Const;
import cc.lixu.acp.Course;
import cc.lixu.acp.User;

public class CourseListStu {
    public static void list(User stu){
        StuCourseSort.sort(stu);
        for(Course c: stu.StuCourses){
            String teacherName = Const.UsersMap.get(c.getTeacherId()).getName();
            System.out.println(c.getTime() + " " + c.getName() + " " + c.getScore() + " " + c.getStudytime() + " "  + teacherName);
        }
        System.out.println("List course schedule success");
    }
}
