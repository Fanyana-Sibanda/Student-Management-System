import java.io.*;
import java.util.ArrayList;

public class FileManager {
    public void saveStudents(ArrayList<Student> students){
        try(FileWriter fileWriter = new FileWriter("students.txt")){
            for(Student student: students){
                fileWriter.write(student.getStudentID() + "," +
                        student.getName() + "," +
                        student.getAge() + "," +
                        student.getCourse() + "," +
                        student.getAvgMark() +
                        System.lineSeparator()
                );
            }
        }catch(IOException e){
            System.out.println("Could not write this file");
        };
    }

    public void loadStudents(ArrayList<Student> students){
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("students.txt"))){
            String line;

            while ((line = bufferedReader.readLine()) != null) {

                String[] parts = line.split(",");

                int studentID = Integer.parseInt(parts[0]);
                String name = parts[1];
                int age = Integer.parseInt(parts[2]);
                String course = parts[3];
                double avgMark = Double.parseDouble(parts[4]);

                Student student = new Student(studentID, name, age, course, avgMark);
                students.add(student);
            }

        }catch(FileNotFoundException e){
            System.out.println("No existing student records found.");
        }catch(IOException e){
            System.out.println("Something went wrong!");
        }
    }

}
