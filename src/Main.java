import java.util.Scanner;
public class Main {
    public static int getValidInteger(Scanner scanner){
        while(!scanner.hasNextInt()){
            System.out.print("Please enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static double getValidDouble(Scanner scanner){
        while (!scanner.hasNextDouble()) {
            System.out.print("Please enter a number: ");
            scanner.next(); // discard the bad token
        }
        return scanner.nextDouble();
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();
        FileManager fileManager = new FileManager();

        fileManager.loadStudents(manager.getStudents());

        int option;
        boolean running = true;
        while(running){

            System.out.print("""
            =========== Student Management System =============
            1. Add Student
            2. View Students
            3. Search Student
            4. Remove a Student
            5. Update Student
            6. Exit
            ===================================================
            """);
            System.out.print("Enter your choice: ");
            option = getValidInteger(scanner);

            switch(option){
                case 1:

                    System.out.print("Enter student ID: ");
                    int studentID = getValidInteger(scanner);

                    Student duplicate = manager.searchStudent(studentID);
                    if(duplicate != null){
                        System.out.println("Student ID already exists\n");
                        break;
                    }

                    System.out.print("Enter student name: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();

                    while(!name.matches("[A-Za-z' -]+")){
                        System.out.print("Invalid Option, Student name may only contain letters, spaces, hyphens and apostrophes.\nEnter student name: ");
                        name = scanner.nextLine();
                    }

                    System.out.print("Enter student age (Age must be between 18 and 50): ");
                    int age = scanner.nextInt();

                    while (age < 18 || age > 50) {
                        System.out.println("Age out of range\n");
                        System.out.print("""
                                            1. Enter student age (Age must be between 18 and 50)
                                            2. Exit
                                            
                                            Option:""");

                        int option1 = scanner.nextInt();
                        switch(option1){
                            case 1:
                                System.out.print("Enter student age (Age must be between 18 and 50): ");
                                age = getValidInteger(scanner);
                                break;
                            case 2:
                                System.out.println("Goodbye!");
                                System.exit(0);
                            default:
                                System.out.println("Invalid option!");
                                continue;
                        }
                    }

                    System.out.print("Enter student course: ");
                    scanner.nextLine();
                    String course = scanner.nextLine();

                    System.out.print("Enter student average Mark: ");
                    double avgMark = getValidDouble(scanner);
                    while(avgMark < 0 || avgMark > 100){
                        System.out.println("Marks must be between 0 and 100!!!");
                        System.out.print("Enter student average Mark: ");
                        avgMark = getValidDouble(scanner);
                    }

                    Student student = new Student(studentID, name, age, course, avgMark);
                    manager.addStudent(student);
                    System.out.println("\nStudent added successfully!\n");
                        break;

                case 2:
                    manager.viewStudents();
                    System.out.println();
                        break;

                case 3:
                    System.out.print("Enter student ID: ");
                    studentID = getValidInteger(scanner);
                    System.out.println();

                    Student foundStudent = manager.searchStudent(studentID);
                    if(foundStudent != null){
                        System.out.println(foundStudent);
                    }else{
                        System.out.println("Student not found\n");
                    }

                    break;

                case 4:
                    System.out.print("Enter Student ID number: ");
                    studentID = getValidInteger(scanner);

                    Student selectedStudent = manager.searchStudent(studentID);
                    if(selectedStudent != null){
                        System.out.println(selectedStudent);
                        System.out.println();
                        System.out.print("Are you sure you'd like to remove this student from the system\n\n1. Yes\n2. No\n");
                        System.out.print("Option: ");
                        int studentDelete = scanner.nextInt();

                        if(studentDelete == 1){
                            manager.deleteStudent(selectedStudent);
                            System.out.println("Student deleted from system!");
                            System.out.println();
                        }else if(studentDelete == 2){
                            break;
                        }else{
                            System.out.println("Invalid Input");
                        }
                    }else{
                        System.out.println("\nStudent ID not found\n");
                    }
                    break;

                case 5:
                    System.out.print("Enter student ID: ");
                    studentID = getValidInteger(scanner);

                    Student updateStudent = manager.searchStudent(studentID);
                    if(updateStudent != null){
                        System.out.println(updateStudent);
                        System.out.println();
                        System.out.println("Select what you would like to be updated\n" +
                                "1. Update Name\n" +
                                "2. Update Age\n" +
                                "3. Update Course\n" +
                                "4. Update Average Mark\n" +
                                "5. Cancel");
                        int updateOption = scanner.nextInt();
                        switch(updateOption){
                            case 1:
                                System.out.println("Enter updated name: ");
                                scanner.nextLine();
                                String updatedName = scanner.nextLine();
                                while(!updatedName.matches("[A-Za-z' -]+")){
                                    System.out.print("Invalid Option, Student name may only contain letters, spaces, hyphens and apostrophes.\nEnter student name: ");
                                    updatedName = scanner.nextLine();
                                }

                                updateStudent.setName(updatedName);
                                System.out.println("Student name successfully updated!");
                                break;
                            case 2:
                                System.out.println("Enter updated age: ");
                                int updatedAge = scanner.nextInt();
                                while (updatedAge < 18 || updatedAge > 50) {
                                    System.out.println("Age out of range\n");
                                    System.out.print("""
                                            1. Enter student age (Age must be between 18 and 50)
                                            2. Exit
                                            
                                            Option:""");

                                    int option1 = scanner.nextInt();
                                    switch(option1){
                                        case 1:
                                            System.out.print("Enter student age (Age must be between 18 and 50): ");
                                            updatedAge = getValidInteger(scanner);
                                            break;
                                        case 2:
                                            System.out.println("Goodbye!");
                                            System.exit(0);
                                        default:
                                            System.out.println("Invalid option!");
                                            continue;
                                    }
                                }
                                updateStudent.setAge(updatedAge);
                                System.out.println("Student age successfully updated!");
                                break;
                            case 3:
                                System.out.println("Enter updated Course: ");
                                scanner.nextLine();
                                String updatedCourse = scanner.nextLine();
                                updateStudent.setCourse(updatedCourse);
                                System.out.println("Student course successfully updated!");
                                break;
                            case 4:
                                System.out.println("Enter updated average mark: ");
                                double updatedAvgMark = scanner.nextDouble();
                                while(updatedAvgMark < 0 || updatedAvgMark > 100){
                                    System.out.println("Marks must be between 0 and 100!!!");
                                    System.out.print("Enter student average Mark: ");
                                    updatedAvgMark = getValidDouble(scanner);
                                }

                                updateStudent.setAvgMark(updatedAvgMark);
                                System.out.println("Student average mark successfully updated!");
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Invalid option. Please try again.");
                        }
                    }else{
                        System.out.println("\nStudent not found\n");
                    }

                    break;

                case 6:
                    System.out.println("Goodbye");
                    fileManager.saveStudents(manager.getStudents());
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.\n");
            }
        }
    }
}
