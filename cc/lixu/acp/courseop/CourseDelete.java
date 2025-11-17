package cc.lixu.acp.courseop;

import cc.lixu.acp.Const;
import cc.lixu.acp.Course;
import cc.lixu.acp.User;

public class CourseDelete {
    public static void delete(Course c){
        for(User i: c.selectStu){
            i.StuCourses.remove(c);
        }
        Const.UsersMap.get(c.getTeacherId()).courses.remove(c.getName());
        Const.UsersMap.get(c.getTeacherId()).coursesAll.remove(c);
        Const.CourseMap.remove(c.id);
    }
}
