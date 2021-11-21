package dao;

import models.Student;
import models.StudentCourseRating;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class StudentCourseRatingDao extends AccessDao{
    public StudentCourseRatingDao() throws SQLException, ClassNotFoundException {
    }
    public int setAll(List<StudentCourseRating> studentRatingList) throws SQLException, ClassNotFoundException {
        if (getConnection() != null) {
            for (StudentCourseRating rating : studentRatingList) {
                String sql = String.format("INSERT INTO `student_course_rating` (`id`,`id_student`,`id_cource`,`raiting`,`commands`) VALUES (%d,%d,%d,%f,'%s');",
                        rating.getId(),rating.getIdStudent(),rating.getIdCourse(),rating.getRatting(),rating.getCommand());
                Statement statement = getConnection().createStatement();
                int i = statement.executeUpdate(sql);
                if (i != 0) {
                    return i;
                } else {
                    return -1;
                }
            }
        }
        return -1;
    }
}
