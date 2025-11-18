package cc.lixu.acp.courseop;

import cc.lixu.acp.Course;
import cc.lixu.acp.User;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CourseExport {
    public static void Export(List<Course> cs, Path path) throws Exception{
        List<CourseDTO> cds = new ArrayList<>();
        for (Course c : cs) {
            cds.add(new CourseDTO(c));
        }
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))){
            oos.writeObject(cds);
        }
    }

    public static void TeacherExport(User teacher, Path path) throws Exception{
        List<Course> courses = teacher.coursesAll;
        Export(courses, path);
    }
}
