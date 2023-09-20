import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int GROUPNUM = 3;   // Constant representing total number of groups
        int count = 0;
        List<Student> newStudents = new ArrayList<Student>();
        List<String>  fileData = new ArrayList<String>();

        // Reading and writing from file
        try {
            File myFile = new File("src/class.txt");
            Scanner myReader = new Scanner(myFile);

            while (myReader.hasNextLine()) {
                fileData.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e)   {
            System.out.print("File Not Found.");
            e.printStackTrace();
        }

        // Organizing fileData from List<String> into list newStudents<Students>
        while(count != fileData.size())   {
            Student newStudent = new Student();

            newStudent.setName(fileData.get(count));
            count++;
            newStudent.setAttendance(Boolean.parseBoolean(fileData.get(count)));
            count++;

            newStudents.add(newStudent);
        }

        // Intro Programming Class Object introProg initialization
        Class introProg = new Class();
        introProg.setAllStudents(newStudents);
        introProg.doAttendance();

        // Main Processing
        introProg.createGroups(GROUPNUM);
        introProg.pickScribes();

        introProg.printScribes();
    }
}