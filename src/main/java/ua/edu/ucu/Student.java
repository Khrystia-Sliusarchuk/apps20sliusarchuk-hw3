package ua.edu.ucu;


class Student {

    static final double DELTA = 0.000001;
    private double GPA;
    private int year;
    private String name;
    private String surname;

    public Student(String name, String surname, double GPA, int year) {
        this.GPA = GPA;
        this.year = year;
        this.name = name;
        this.surname = surname;
    }

    public double getGPA() {
        return GPA;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public int hashCode() {
        return (int) GPA + 11 * year + 121 * name.hashCode()
                + 1331 * surname.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return student.GPA - GPA < DELTA && year == student.year
                && name.equals(student.name) && surname.equals(student.surname);
    }

    @Override
    public String toString() {
        return "Student{name=" + name + ", surname=" + surname
                + ", " + "GPA=" + GPA + ", year=" + year + '}';
    }

}
