package cc.lixu.acp.userop;

import cc.lixu.acp.Const;
import cc.lixu.acp.User;

public class Logout {
    public static void logout(String id){
        Const.UsersMap.get(id).setLogin(false);
        Const.UserList.remove(id);
        System.out.println(id + " Bye~");
    }
}
