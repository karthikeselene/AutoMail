package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Content {
	
	public static String readHtmlFile(){
		String fileName = "./htmlMail.txt";
		String line = null;
		ArrayList<String> data = new ArrayList<String>();
		String html = null;
		try {
            
            FileReader fileReader = new FileReader(fileName);          
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
            	data.add(line);
            }         
            bufferedReader.close();  
            StringBuilder sb = new StringBuilder();
            for (String s : data)
            {
                sb.append(s);               
            }
            html = sb.toString();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '"+fileName +"'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '"+ fileName +"'");                  
            
        }
		return html;
	}

}
