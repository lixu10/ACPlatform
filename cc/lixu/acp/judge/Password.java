package cc.lixu.acp.judge;

public class Password {
    static public boolean isvalid(String pw){
        int len = pw.length();
        if(len > 16 || len < 6) return false;
        int letter = 0, digit = 0, symbol = 0;
        for(int i=0;i<len;i++){
            if((pw.charAt(i)>='a'&&pw.charAt(i)<='z')||(pw.charAt(i)>='A'&&pw.charAt(i)<='Z')) letter++;
            else if((pw.charAt(i)>='0')&&(pw.charAt(i)<='9')) digit++;
            else if(pw.charAt(i)=='@'||pw.charAt(i)=='_'||pw.charAt(i)=='%'||pw.charAt(i)=='$') symbol++;
            else return false;
        }
        return (letter>=1&&digit>=1&&symbol>=1);
    }
}
