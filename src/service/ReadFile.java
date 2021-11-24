package service;

import dao.CourseDao;
import dao.StudentCourseRatingDao;
import dao.StudentDao;
import models.Course;
import models.Student;
import models.StudentCourseRating;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReadFile {
    CourseDao courseDao;
    StudentDao studentDao;
    StudentCourseRatingDao rattingDao;

    public boolean getFileData() throws IOException {
        String inputFileName = "resource/info.csv";
        Set<Course> courseList = new HashSet<>();
        Set<Student> studentList = new HashSet<>();
        Set<StudentCourseRating> ratingList = new HashSet<>();
        int indexCourse = 1, indexStudent = 1, indexRating = 1;
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        for (int i = 1; i < lines.size(); i++) {
            String[] columns = lines.get(i).split(",");
            courseList.add(new Course(indexCourse, columns[0], columns[2]));
            studentList.add(new Student(indexStudent, columns[1]));
            ratingList.add(new StudentCourseRating(indexRating++, indexStudent, indexCourse, Double.parseDouble(columns[3]), columns[4]));
            indexCourse++;
            indexStudent++;
        }
        if (saveDataStudent(studentList) != -1 && saveDataCourse(courseList) != -1 && saveDataRatting(ratingList) != -1) {
            reader.close();
            return true;
        } else {
            reader.close();
            return false;
        }
    }

    public int saveDataStudent(Set<Student> studentList) {
        int isAdd = -1;
        try {
            studentDao = new StudentDao();
            isAdd = studentDao.setAll(studentList);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println( ex.getMessage());
        }
        return isAdd;
    }

    public int saveDataCourse(Set<Course> courseList) {
        int isAdd = -1;
        try {
            courseDao = new CourseDao();
            isAdd = courseDao.setAll(courseList);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println( ex.getMessage());
        }
        return isAdd;
    }

    public int saveDataRatting(Set<StudentCourseRating> ratingList) {
        int isAdd = -1;
        try {
            rattingDao = new StudentCourseRatingDao();
            isAdd = rattingDao.setAll(ratingList);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println( ex.getMessage());
        }
        return isAdd;
    }


}
