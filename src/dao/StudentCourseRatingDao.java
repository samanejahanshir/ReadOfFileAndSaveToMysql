package dao;

import models.Student;
import models.StudentCourseRating;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Set;

public class StudentCourseRatingDao extends AccessDao{
    public StudentCourseRatingDao() throws SQLException, ClassNotFoundException {
    }
    public int setAll(Set<StudentCourseRating> studentRatingList) throws SQLException, ClassNotFoundException {
        if (getConnection() != null) {
            for (StudentCourseRating rating : studentRatingList) {
                String sql = String.format("INSERT INTO `student_course_rating` (`id`,`id_student`,`id_cource`,`raiting`,`commands`) VALUES (%d,%d,%d,%f,'%s');",
                        rating.getId(), rating.getIdStudent(), rating.getIdCourse(), rating.getRatting(), rating.getCommand());
                Statement statement = getConnection().createStatement();
                statement.executeUpdate(sql);

            }
            return 1;
        }
            return -1;
    }
}
