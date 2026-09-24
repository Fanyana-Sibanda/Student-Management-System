public class Student {
    private int studentID;
    private String name;
    private int age;
    private String course;
    private double avgMark;

    public Student(int studentID, String name, int age, String course, double avgMark){
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.course = course;
        this.avgMark = avgMark;
    }

    //Getters
    public int getStudentID(){
        return studentID;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getCourse(){
        return course;
    }
    public double getAvgMark(){
        return avgMark;
    }

    //Setters
    public void setStudentID(int studentID){
        this.studentID = studentID;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setCourse(String course){
        this.course = course;
    }
    public void setAvgMark(double avgMark){
        this.avgMark = avgMark;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID +
                "\nName: " + name +
                "\nAge: " + age +
                "\nCourse: " + course +
                "\nAverage Mark: " + avgMark;
    }
}
