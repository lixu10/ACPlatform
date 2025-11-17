package cc.lixu.acp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {
    private String id;
    private String name;
    private String password;
    private String type;
    private boolean isLogin;
    public long loginTime;

    // for teacher
    public HashMap<String, Course> courses = new HashMap<>();
    public List<Course> coursesAll = new ArrayList<>();
    // for student
    public List<Course> StuCourses = new ArrayList<>();

    public User(String id, String name, String password, String type) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    @Override
    public String toString() {
        return "User id: " + id + "\n" +
        "Name: " + name + "\n" +
        "Type: " + type + "\n" +
        "Print information success";
    }
}
