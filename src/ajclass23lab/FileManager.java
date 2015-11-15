package ajclass23lab;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shruthi Routhu
 */
public class FileManager {
    private static String ERROR_MSG = "Invalid Input data !";
    
    // Method to read file
    public void readFileToConsole(File myFile){

        if(myFile.exists())
        {
            BufferedReader reader = null;
            try{
               
                reader = new BufferedReader( new FileReader(myFile));
                String line = reader.readLine();
                while(line != null){
                    System.out.println(line);
                    line = reader.readLine();
                }
               
            }catch(IOException ioe){
                System.out.println(ioe.getMessage());
            }
            finally{
                
                try { 
                    reader.close();
                } catch (IOException ioe) {
                    System.out.println(ioe.getMessage());
                }
            }  
        }else{
            throw new IllegalArgumentException(ERROR_MSG);
        }  
    }
    
    // Method to write data to file
    public void writeToFile(File file, List<String> lineList){
        if(file.exists()&& lineList != null){
            PrintWriter writer = null ;
            try{
                writer = new PrintWriter(new BufferedWriter(new FileWriter(file,true)));
                for(String line : lineList){
                    writer.println(line);
                }
              
            }catch(IOException ioe){
                System.out.println(ioe.getMessage());
            }
            finally{
                writer.close();
            }
        }else{
            throw new IllegalArgumentException(ERROR_MSG);
        }
        
    }
    
    // This method gets a record based on its positon
    public List<String> getRecord(File file, int recordNo){
        List<String> lineList = new ArrayList<>();
       
        if(file.exists() && recordNo > 0){
                       
            BufferedReader reader = null;
            
            //Formula to get to first line in record based on recordNo (recordNo-1)*3 + 1
            // if posiion = 2 then first line is  (2-1)*3 + 1 = 4 
            // if posiion = 5 then first line is  (5-1)*3 + 1 = 13 
            
            // Calculating Read Position
            int readPosition = (recordNo-1)*3 + 1;
            int endPosition = readPosition+3;
            
            try{
                reader = new BufferedReader(new FileReader(file));
                
                int lineNo = 0;
                String line = reader.readLine();
                
                while(line != null){
                    lineNo += 1; 
                    if(lineNo >= readPosition && lineNo < endPosition ){
                        lineList.add(line);
                    }
                    line = reader.readLine();
                }
                
            }catch(IOException ioe){
                System.out.println(ioe.getMessage());
            }
            finally{
                
                try { 
                    reader.close();
                }catch (IOException ioe) {
                    System.out.println(ioe.getMessage());
                }
            } 
            
        }else{
            lineList = null;
            throw new IllegalArgumentException(ERROR_MSG);
        }
        
        return lineList ; 
    }
}
