package FileControl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class NameConverter {
	
	public String NameConverter(String name) throws IOException{

			  File filer = new File("data/try_users.csv"); 
			   
			  FileInputStream fip =  new FileInputStream(filer);		   
			  BufferedReader Reader = new BufferedReader(new InputStreamReader(fip));
			
			   try {
		            String line = null;
		            while ((line = Reader.readLine()) != null) {
		                String[] select = line.split(",");
		                if(name.equals(select[0])){
		                	//System.out.println("111");
		                	return select[1];
		                }

		            } 
		           } catch (IOException e) {
		            e.printStackTrace();
		        }
			   Reader.close();  
			   fip.close();
	        
		return "";
		
	}

}
