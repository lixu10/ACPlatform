import cc.lixu.acp.Main;

public class Test {
    public static void main(String[] args) {
        try {
            Main.main(args);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
