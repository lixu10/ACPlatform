package cc.lixu.acp.judge;

public class Name {
    static public boolean isvalid(String name){
        int len = name.length();
        if(len > 16 || len < 4) return false;
        if(name.charAt(0)=='_') return false;
        for(int i=0;i<len;i++){
            if((name.charAt(i)>='a'&&name.charAt(i)<='z')||(name.charAt(i)>='A'&&name.charAt(i)<='Z')||(name.charAt(i)>='0'&&name.charAt(i)<='9')||name.charAt(i)=='_') continue;
            return false;
        }
        return true;
    }
}
