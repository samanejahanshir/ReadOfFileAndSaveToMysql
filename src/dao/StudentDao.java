package dao;

import models.Course;
import models.Student;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class StudentDao  extends  AccessDao{
    public StudentDao() throws SQLException, ClassNotFoundException {

    }

    public int setAll(List<Student> studentList) throws SQLException, ClassNotFoundException {
        if (getConnection() != null) {
            for (Student student : studentList) {
                String sql = String.format("INSERT INTO `student` (`id`,`name`) VALUES (%d,'%s');",
                        student.getId(),student.getName());
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
