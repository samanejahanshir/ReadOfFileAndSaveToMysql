package models;

public class StudentCourseRating {
    private  int id;
    private  int idStudent;
    private  int idCourse;
    private  double ratting;
    private  String command;

    public StudentCourseRating(int id, int idStudent, int idCourse, double ratting, String command) {
        this.id = id;
        this.idStudent = idStudent;
        this.idCourse = idCourse;
        this.ratting = ratting;
        this.command = command;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public double getRatting() {
        return ratting;
    }

    public void setRatting(double ratting) {
        this.ratting = ratting;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return "StudentCourseRating{" +
                "id=" + id +
                ", idStudent=" + idStudent +
                ", idCourse=" + idCourse +
                ", ratting=" + ratting +
                ", command='" + command + '\'' +
                '}';
    }
}
