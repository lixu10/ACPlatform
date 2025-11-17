package cc.lixu.acp.courseop;

import cc.lixu.acp.Course;
import cc.lixu.acp.User;

public class isConflict_stu {
    static public boolean is_Conflict(User stu, Course select){
        if(stu.StuCourses.isEmpty()) return false;
        if(stu.StuCourses.contains(select)) return true;
        int[] time_ = ExtractTime.extractTime(select.getTime());
        for(Course i: stu.StuCourses){
            int[] time_1 = ExtractTime.extractTime(i.getTime());
            if(time_[0] == time_1[0]){
                if(Integer.max(time_[1], time_1[1]) <= Integer.min(time_[2], time_1[2])) return true;
            }
        }
        return false;
    }
}
