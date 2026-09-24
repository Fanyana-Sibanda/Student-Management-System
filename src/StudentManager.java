import java.util.ArrayList;
public class StudentManager {
    private final ArrayList<Student> students;

    public StudentManager(){
        students = new ArrayList<>();
    }
    public void addStudent(Student student){
        students.add(student);
    }

    public void viewStudents(){
        if(students.isEmpty()){
            System.out.println("\nNo students found!");
        }else{
            for(Student student : students){
                System.out.println("\n" + student);
            }
        }
    }

    public Student searchStudent(int studentID){
        for(Student student : students){
            if(student.getStudentID() == studentID){
                return student;
            }
        }
        return null;
    }

    public void deleteStudent(Student student){
        students.remove(student);
    }

    public ArrayList<Student> getStudents(){
        return students;
    }
}
