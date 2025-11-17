package cc.lixu.acp.judge;

public class CourseStudyTime {
    static public boolean isvalid(String studytime){
        try {
            int t = Integer.parseInt(studytime);
            if (t > 1280 || t <= 0) return false;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
