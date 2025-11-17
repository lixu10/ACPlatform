package cc.lixu.acp.judge;

public class ID {
    static public boolean isvalid(String id){
        switch (id.length()){
            case 8:
                if(!isint(id)) return false;
                int yr = toInt(id,0,2);
                int cps = toInt(id,2,4);
                int cls = toInt(id,4,5);
                int num = toInt(id,5,8);
                return yr <= 24 && yr >= 19 && cps >= 1 && cps <= 43 && cls >= 1 && cls <= 6 && num >= 1 && num <= 999;
            case 9:
                if(!isint(id.substring(2,9))) return false;
                int yrs = toInt(id,2,4);
                int cpss = toInt(id,4,6);
                int clss = toInt(id,6,7);
                int nums = toInt(id,7,9);
                if((id.charAt(0)=='S'||id.charAt(0)=='Z')&&id.charAt(1) == 'Y'&&yrs<=24&&yrs>=21&&cpss>=1&&cpss<=43&&clss>=1&&clss<=6&&nums>=1&&nums<=99) return true;
                return id.charAt(0) == 'B' && id.charAt(1) == 'Y' && yrs <= 24 && yrs >= 19 && cpss >= 1 && cpss <= 43 && clss >= 1 && clss <= 6 && nums >= 1 && nums <= 99;
            case 5:
                if (isint(id)&&Integer.parseInt(id)>0) return true;
                if (id.charAt(0)=='A'&&id.charAt(1)=='D'&&isint(id.substring(2,5))&&Integer.parseInt(id.substring(2,5))>0) return true;
                return false;
            default:
                return false;
        }
    }

    private static int toInt(String s, int start, int end) {
        return Integer.parseInt(s.substring(start, end));
    }

    private static boolean isint(String s){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<'0'||s.charAt(i)>'9') return false;
        }
        return true;
    }
}
