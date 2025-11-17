package cc.lixu.acp.judge;

public class CourseId {
    public static boolean isvalid(String id){
        if(id==null || id.length() < 3) return false;
        if(id.charAt(0)!='C')return false;
        if(id.charAt(1)!='-')return false;
        if(id.charAt(2)<='0'||id.charAt(2)>'9')return false;
        for(int i = 3; i < id.length(); i++){
            if(id.charAt(i)<'0'||id.charAt(i)>'9') return false;
        }
        return true;
    }
}
