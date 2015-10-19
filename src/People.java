import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by MattBrown on 10/19/15.
 */
public class People {
    public static void main(String[] args) {

        HashMap<String, ArrayList<Person>> pplInfo = new HashMap();
        String postContent = readFile("people.csv"); //add your read file...dont need a write file
        String lines[] = postContent.split("/n");

        for (String line : lines) {//this is looping over the information that I'm adding to the array list
            String columns[] = line.split("/,");
            int posNum = Integer.valueOf(columns[0]);
            String firstName = columns[1];
            String lastName = columns[2];
            String email = columns[3];
            String country = columns[4];
            String iP = columns[5];
            String searchLast = lastName;
            Person newPerson = new Person(posNum, firstName, lastName, email, country, iP);
            ArrayList<Person> list = pplInfo.get(searchLast);
            if (list == null) {
                list = new ArrayList();
                list.add(newPerson);
                pplInfo.put(searchLast, list);
            } else {
                list.add(newPerson);
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type the last name that you would like to search by!");
        String name = scanner.nextLine();
        ArrayList<Person> numList = pplInfo.get(name);
        String newFile = String.format("%s_pplInfo", name);

        if (pplInfo.containsKey(name)) {
            String contents = "";
            for (Person data : numList) {
                contents += data.lastName + "\n";
            }
            writeFile(newFile, contents);
        }
    }

    static void writeFile(String fileName, String fileContent) {//copy and paste when you need to read/write files
        //write file^ is not initialized yet, therefore it will NOT write the file until your HashMap constructor is completed
        File f = new File(fileName);
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(fileContent);
            fw.close();
        } catch (Exception e) {

        }
    }


    static String readFile(String fileName) {//copy and paste when I need to read/write files
        File f = new File(fileName);
        try {
            FileReader fr = new FileReader(f);
            int fileSize = (int) f.length();
            char[] fileContent = new char[fileSize];
            fr.read(fileContent);
            return new String(fileContent);
        } catch (Exception e) {
            return null;
        }
    }
}


