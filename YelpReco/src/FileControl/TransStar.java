package FileControl;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Hashtable;


public class TransStar {
	private static BufferedReader br = null;  
	private static File file = null;  
	private static BufferedWriter bw = null; 
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		  File file1 = new File("data/recommendation/selectbuspropertywentbefore_1654.txt");  
		  File file2 = new File("data/recommendation/selectwentbefore_1654.txt");
		  File filew = new File("data/star_1654.txt");
		  
		  FileOutputStream fop =  new FileOutputStream(filew);
		  BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fop,"UTF-8"));
		   
		  FileInputStream fip1 =  new FileInputStream(file1);		   
		  BufferedReader reader1 = new BufferedReader(new InputStreamReader(fip1));
		  
		  FileInputStream fip2 =  new FileInputStream(file2);		   
		  BufferedReader reader2 = new BufferedReader(new InputStreamReader(fip2));
		  
		  Hashtable<String, String> ht = new Hashtable<String, String>();
		  try {
	            String line = null;
	            ArrayList<String> id = new ArrayList<String>();
	            while ((line = reader1.readLine()) != null) {
	            	String[] s = line.split(" ");
	            	System.out.println(line);
	            	System.out.println(s.length+"");
	            	if(id.contains(s[1]))
	            		break;
	            	ht.put(s[1], mapping(s[3])+" "+mapping(s[6])+" "+mapping(s[8])+" "+mapping(s[11])+" "+mapping(s[14]));
	            	System.out.println(ht.get(s[1]));
	            } 
	      } catch (IOException e) {
	            e.printStackTrace();
	      }
		  reader1.close();
		  fip1.close();
		  
		  System.out.println("*********************************************");
		  try {
	            String line = null;
	            while ((line = reader2.readLine()) != null) {
	            	String[] s = line.split(" ");
	            	writer.write(ht.get(s[1])+" "+s[2]);
	                writer.newLine();
	                writer.flush(); 
	            	System.out.println(ht.get(s[1])+" "+s[2]);
	            } 
	      } catch (IOException e) {
	            e.printStackTrace();
	      }
		  
		  reader2.close();  
		  fip2.close();
		  fop.close();
	}
	
	public static String mapping(String s){
		String result;
		switch(s){
		case "FALSE":
			result = "0";
			break;
		case "TRUE":
			result = "1";
			break;
		case "none":
			result = "0";
			break;
		case "full_bar":
			result = "1";
			break;
		case "beer_and_wine":
			result = "2";
			break;
		default:
			result = "0";
		}
		return result;
	}
}
