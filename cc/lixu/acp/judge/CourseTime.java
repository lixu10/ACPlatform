package cc.lixu.acp.judge;

public class CourseTime {
    static public boolean isvalid(String time){
        String[] strs = time.split("_");
        if(strs.length != 2) return false;
        if(strs[0].length()!=1 || !(strs[0].charAt(0)>'0'&&strs[0].charAt(0)<='7')){
            return false;
        }
        String[] timeStrs = strs[1].split("-");
        if(timeStrs.length != 2) return false;
        if(!isValid(timeStrs[0]) || !isValid(timeStrs[1])) return false;
        return Integer.parseInt(timeStrs[0])<=Integer.parseInt(timeStrs[1]);
    }

    static private boolean isValid(String time){
        if(time.length()==1&&time.charAt(0)>='1'&&time.charAt(0)<='9') return true;
        if(time.length()==2&&time.charAt(0)=='1'&&time.charAt(1)>='0'&&time.charAt(1)<='4') return true;
        return false;
    }
}
