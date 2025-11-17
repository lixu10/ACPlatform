package cc.lixu.acp.judge;

public class Type {
    static public boolean isvalid(String type){
        return type.equals("Administrator") || type.equals("Teacher") || type.equals("Student");
    }
}
