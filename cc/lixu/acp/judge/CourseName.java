package cc.lixu.acp.judge;

public class CourseName {
    static public boolean isvalid(String name){
        int len = name.length();
        if(len<1 || len>20) return false;
        if(!((name.charAt(0)>='a'&&name.charAt(0)<='z')||(name.charAt(0)>='A'&&name.charAt(0)<='Z'))) return false;
        for(int i=0;i<len;i++){
            if((name.charAt(i)>='a'&&name.charAt(i)<='z')||(name.charAt(i)>='A'&&name.charAt(i)<='Z')||(name.charAt(i)>='0'&&name.charAt(i)<='9')||name.charAt(i)=='_'||name.charAt(i)=='-') continue;
            return false;
        }
        return true;
    }
}
