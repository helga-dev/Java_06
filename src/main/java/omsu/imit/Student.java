package omsu.imit;

import java.util.Objects;

public class Student extends Human {
    private String faculty;

    public Student() {
        faculty = "ИМИТ";
    }

    public Student(String faculty) {
        setFaculty(faculty);
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        if (faculty != null && !faculty.equals("")) {
            this.faculty = faculty;
        } else {
            throw new IllegalArgumentException("String faculty should be not null and not empty");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(faculty, student.faculty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), faculty);
    }
}
