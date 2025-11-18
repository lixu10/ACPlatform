package cc.lixu.acp.courseop;

import cc.lixu.acp.Course;

import java.io.Serializable;

public class CourseDTO implements Serializable {
    private String name;
    private String time;
    private double score;
    private int studytime;

    public CourseDTO(Course c) {
        this.name = c.getName();
        this.time = c.getTime();
        this.score = c.getScore();
        this.studytime = c.getStudytime();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}