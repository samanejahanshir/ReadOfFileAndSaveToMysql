package dao;

import models.Course;
import models.Student;

import java.sql.*;
import java.util.List;
import java.util.Set;

public class CourseDao extends AccessDao {

    public CourseDao() throws SQLException, ClassNotFoundException {

    }

    public int setAll(Set<Course> courseList) throws SQLException, ClassNotFoundException {
            if (getConnection() != null) {
                for (Course course : courseList) {
                    String sql = String.format("INSERT INTO `course` (`id`,`name`,`timeStamp`) VALUES (%d,'%s','%s');",
                            course.getId(), course.getName(),course.getTimeStamp());
                    Statement statement = getConnection().createStatement();
                     statement.executeUpdate(sql);
                }
                return 1;
            }
        return -1;
    }
}
