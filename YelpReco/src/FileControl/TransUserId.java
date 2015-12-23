package FileControl;
import java.io.*;
public class TransUserId {

	   private static BufferedReader br = null;  
	   private static File file = null;  
	   private static BufferedWriter bw = null; 
	   public static void main(String args[]) throws IOException
	   {
//		   FileReader in = null;
//		   FileWriter out = null
		  File filew = new File("data/output.txt"); 
		  File filer = new File("data/review.txt");  
		  
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
//	            	int j = Character.getNumericValue(c);
//	            	int j = Integer.parseInt(String.valueOf(c));
	         
	            	num += c;
	                //System.out.println(num);
	                //Writer.write(num+"");
	                //Writer.newLine();
	                //Writer.flush();  
//	                bufferedWriter.newLine();	    
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


