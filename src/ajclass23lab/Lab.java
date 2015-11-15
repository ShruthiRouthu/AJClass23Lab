package ajclass23lab;


import java.io.File;
import java.util.List;


/**
 *
 * @author Shruthi Routhu
 */
public class Lab {
    
    public static void main(String[] args) {
        
        // Creating file object
        File myFile = new File( File.separatorChar + "temp" + File.separatorChar +"lab1" + File.separatorChar + "lab1.txt");
        
        // Creating FileManager Object
        FileManager fileMgr = new FileManager();
        
// -------------------------------------- LAB2 ---------------------------------        
//        // Reading file
//        fileMgr.readFileToConsole(myFile);
//        
//        // Creating list of lines to write to file
//        List<String> lineList = new ArrayList<>();
//        lineList.add("Prasanna Vithal Raj");
//        lineList.add("N64W24375 Ivy Ave #Apt40");
//        lineList.add("Pewaukee, CA 00000");
//        lineList.add("Sonu Muddada");
//        lineList.add("N64W24375 Ivy Ave #Apt0");
//        lineList.add("Milwaukee, FL 00000");
//        
//        //Writing to file
//        fileMgr.writeToFile(myFile, lineList);
//        
//        fileMgr.readFileToConsole(myFile);
        
// -------------------------------------- LAB3 ---------------------------------
        // Getting record 
        List<String> record = fileMgr.getRecord(myFile, 2);
        
        // Getting state
        String[] temp = record.get(2).split(" ");
        String state = temp[temp.length - 2];
        
        System.out.println(record.get(0) + " State : " +  state);
        
    }
    
}
 