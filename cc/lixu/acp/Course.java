package cc.lixu.acp;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    public long id;
    private String time;
    private double score;
    private int studytime;
    private String teacherId;

    public List<User> selectStu = new ArrayList<>();

    public Course(String name, String time, double score, int studytime) {
        this.name = name;
        this.time = time;
        this.score = score;
        this.studytime = studytime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getStudytime() {
        return studytime;
    }

    public void setStudytime(int studytime) {
        this.studytime = studytime;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "C-" + id + " " + name + " " + time + " " + score + " " + studytime;
    }
}
