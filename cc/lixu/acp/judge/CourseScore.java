package cc.lixu.acp.judge;

public class CourseScore {
    static public boolean isvalid(String  score){
        try {
            double score_d = Double.parseDouble(score);
            if (score_d <= 0 || score_d > 12) return false;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
