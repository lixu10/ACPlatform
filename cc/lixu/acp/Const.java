package cc.lixu.acp;

import java.util.*;

public class Const {
    public static Map<String, User> UsersMap = new HashMap<>();
    public static long LoginNum;
    public static List<String> UserList = new ArrayList<>(); // 登录用户列表
    public static String NowUser; // 当前用户

    public static Map<Long, Course> CourseMap = new HashMap<>();
    public static long CourseNum;

    public static List<Map.Entry<Long, Course>> Courselist = new ArrayList<>(); // 排好序的
}