package cc.lixu.acp.courseop;

import cc.lixu.acp.Course;
import cc.lixu.acp.User;

import java.util.Collections;
import java.util.Comparator;

public class CourseStuSort {
    public static void sort(Course c){
        c.selectStu.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                String id1 = o1.getId();
                String id2 = o2.getId();
                if (id1.charAt(0) == 'B') {
                    if (id2.charAt(0) == 'B') {
                        return id1.compareTo(id2);
                    } else {
                        return 1;
                    }
                }
                if (id1.charAt(0) == 'S') {
                    if (id2.charAt(0) == 'S') {
                        return id1.compareTo(id2);
                    }
                    if (id2.charAt(0) == 'B') {
                        return -1;
                    }
                    return 1;
                }
                if (id1.charAt(0) == 'Z') {
                    if (id2.charAt(0) == 'Z') {
                        return id1.compareTo(id2);
                    }
                    if (id2.charAt(0) == 'B' || id2.charAt(0) == 'S') {
                        return -1;
                    }
                    return 1;
                }
                if ('0' <= id1.charAt(0) && id1.charAt(0) <= '9') {
                    if (!('0' <= id2.charAt(0) && id2.charAt(0) <= '9')) {
                        return -1;
                    } else {
                        return id1.compareTo(id2);
                    }
                }
                return id1.compareTo(id2);
            }
        });
    }
}
