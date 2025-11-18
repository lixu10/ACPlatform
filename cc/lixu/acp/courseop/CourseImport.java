package cc.lixu.acp.courseop;

import cc.lixu.acp.Const;
import cc.lixu.acp.Course;
import cc.lixu.acp.User;

import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CourseImport {
    public static void CourseImport(User teacher, Path path) throws  Exception{
        try{
            List<CourseDTO> cds = importCourses(path);
            for(CourseDTO cd : cds){
                if(teacher.coursesAll.size() >= 10){
                    System.out.println("Course count reaches limit");
                }
                else if(teacher.courses.containsKey(cd.getName())){
                    System.out.println("Course name already exists");
                }
                else if(isConflict.is_Conflict(teacher, cd.getTime())){
                    System.out.println("Course time conflicts");
                }else{
                    Course course = new Course(cd.getName(), cd.getTime(), cd.getScore(), cd.getStudytime());
                    course.id = ++Const.CourseNum;
                    course.setTeacherId(teacher.getId());
                    teacher.courses.put(cd.getName(), course);
                    teacher.coursesAll.add(course);
                    Const.CourseMap.put(course.id, course);
                    System.out.println("Create course success (courseId: C-"+course.getId()+")");
                }
            }
        }
        catch (Exception e){
            // 应该不会触发
        }
    }

    public static List<CourseDTO> importCourses(Path path) throws Exception {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            return (List<CourseDTO>) ois.readObject();
        }
    }
}
