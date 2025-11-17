package cc.lixu.acp.courseop;

public class ExtractTime {
    public static int[] extractTime(String time){
        int[] ans = new int[3];
        String[] strs = time.split("_");
        ans[0] = Integer.parseInt(strs[0]);
        ans[1] = Integer.parseInt(strs[1].split("-")[0]);
        ans[2] = Integer.parseInt(strs[1].split("-")[1]);
        return ans;
    }
}
