package dk.sea;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Ib", 10));
        students.add(new Student("Bo", 7));

        writeData(students);
    }

    private static void writeData(ArrayList<Student> students) {
        PrintWriter pw = null;
        String delimiter = ";";

        StringBuilder sb = new StringBuilder();
        sb.append("Name");
        sb.append(delimiter);
        sb.append("Grade");
        sb.append(System.lineSeparator());

        try {
            pw = new PrintWriter("data.csv");

            for(Student st: students) {
                sb.append(st.name()).append(delimiter);
                sb.append(st.grade()).append(System.lineSeparator());
            }
            pw.print(sb.toString());


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
            pw.close();
        }


    }


}

record Student(String name, int grade){}
