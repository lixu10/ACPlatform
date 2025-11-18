package cc.lixu.acp.userop;

import cc.lixu.acp.Const;
import cc.lixu.acp.User;

import java.util.Objects;

public class Logout {
    public static void logout(String id){
        Const.UsersMap.get(id).setLogin(false);
        Const.UserList.remove(id);
        if(Objects.equals(Const.NowUser, id)) Const.NowUser = null;
        System.out.println(id + " Bye~");
    }
}
