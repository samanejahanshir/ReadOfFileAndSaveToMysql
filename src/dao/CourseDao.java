package dao;

import models.Course;
import models.Student;

import java.sql.*;
import java.util.List;

public class CourseDao extends AccessDao {

    public CourseDao() throws SQLException, ClassNotFoundException {

    }

    public int setAll(List<Course> courseList) throws SQLException, ClassNotFoundException {
            if (getConnection() != null) {
                for (Course course : courseList) {
                    String sql = String.format("INSERT INTO `course` (`id`,`name`) VALUES (%d,'%s');",
                            course.getId(), course.getName());
                    Statement statement = getConnection().createStatement();
                     statement.executeUpdate(sql);
                }
                return 1;
            }
        return -1;
    }
}
