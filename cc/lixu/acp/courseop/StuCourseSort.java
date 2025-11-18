package cc.lixu.acp.courseop;

import cc.lixu.acp.Course;
import cc.lixu.acp.User;

import java.util.Comparator;

public class StuCourseSort {
    public static void sort(User stu){
        stu.StuCourses.sort(new Comparator<Course>(){
            @Override
            public int compare(Course o1, Course o2) {
                int[] time1 = ExtractTime.extractTime(o1.getTime());
                int[] time2 = ExtractTime.extractTime(o2.getTime());
                if(time1[0] == time2[0]){
                    return time1[1] - time2[1];
                }
                return time1[0] - time2[0];
            }
        });
    }
}
