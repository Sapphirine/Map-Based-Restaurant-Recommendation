package FileControl;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class TransBId {

	private static BufferedReader br = null;  
	private static File file = null;  
	private static BufferedWriter bw = null; 
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		  File filew = new File("D:/CU/2015FALL/BD/Project/Happy/Bigdata/data/bid_output.txt");  
		  File filer = new File("D:/CU/2015FALL/BD/Project/Happy/Bigdata/data/bid.txt"); 
		  
		  FileOutputStream fop =  new FileOutputStream(filew);
		  
		  BufferedWriter Writer = new BufferedWriter(new OutputStreamWriter(fop,"UTF-8"));
		   
		  FileInputStream fip =  new FileInputStream(filer);		   
		  BufferedReader Reader = new BufferedReader(new InputStreamReader(fip));
		
		  try {
	            String line = null;
	            int num = 0;
	            while ((line = Reader.readLine()) != null) {
	            	num=0;
	            	
	            	for(int i=0;i<22;i++){
	            	  char c = line.charAt(i);	         
	            	  num += c;	    
	            	}     
	            	System.out.println(num);
	                Writer.write(num+"");
	                Writer.newLine();
	                Writer.flush(); 
	            } 
	           } catch (IOException e) {
	            e.printStackTrace();
	        }
		   Reader.close();  
		   fip.close();
         //bw.close();
	}
}
