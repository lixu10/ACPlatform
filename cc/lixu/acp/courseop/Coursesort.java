package cc.lixu.acp.courseop;

import cc.lixu.acp.Const;
import cc.lixu.acp.Course;
import cc.lixu.acp.User;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class Coursesort {
    public static void sort(){
        Collections.sort(Const.Courselist, new Comparator<Map.Entry<Long, Course>>() {
            @Override
            public int compare(Map.Entry<Long, Course> u1, Map.Entry<Long, Course> u2)
            {
                String teacher1Name = Const.UsersMap.get(u1.getValue().getTeacherId()).getName();
                String teacher2Name = Const.UsersMap.get(u2.getValue().getTeacherId()).getName();
                
                int teacherCompare = teacher1Name.compareTo(teacher2Name);
                if (teacherCompare != 0) {
                    return teacherCompare;
                }
                return Long.compare(u1.getValue().getId(), u2.getValue().getId());
            }
        });
    }
}