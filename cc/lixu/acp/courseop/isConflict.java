package cc.lixu.acp.courseop;

import cc.lixu.acp.User;

public class isConflict {
    static public boolean is_Conflict(User teacher, String time){
        int[] time_ = ExtractTime.extractTime(time);
        for(int i = 0; i < teacher.courses.size(); i++){
            int[] time_1 = ExtractTime.extractTime(teacher.coursesAll.get(i).getTime());
            if(time_[0] == time_1[0]){
                if(Integer.max(time_[1], time_1[1]) <= Integer.min(time_[2], time_1[2])) return true;
            }
        }
        return false;
    }
}
