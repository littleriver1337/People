import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/**
 * Created by MattBrown on 10/19/15.
 */
public class People {
    public static void main(String[] args) {

        HashMap<String, ArrayList<Person>> pplInfo = new HashMap();
        String postContent = readFile("people.csv"); //add your read file...dont need a write file
        String lines[] = postContent.split("\n");

        for (int i = 1; i < lines.length; i++) {//this is looping over the information that I'm adding to the array list
            String columns[] = lines[i].split(",");//i added to indicate the positional start of the list
            int posNum = Integer.valueOf(columns[0]);
            String firstName = columns[1];
            String lastName = columns[2];
            String email = columns[3];
            String country = columns[4];
            String iP = columns[5];
            String searchLast = country;
            Person newPerson = new Person(posNum, firstName, lastName, email, country, iP);
            ArrayList<Person> list = pplInfo.get(searchLast);
            if (list == null) {
                list = new ArrayList();
                list.add(newPerson);
                pplInfo.put(searchLast, list);
            } else {
                list.add(newPerson);
            }
            System.out.println(pplInfo);
        }

        for (ArrayList<Person> list : pplInfo.values()) {   //looping
            Collections.sort(list);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type the last name that you would like to search by!");
        String name = scanner.nextLine();
        ArrayList<Person> numList = pplInfo.get(name);
        String newFile = String.format("%s_pplInfo", name);
        //System.out.println("This is your list", );

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


