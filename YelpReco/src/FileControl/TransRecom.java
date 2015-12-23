package FileControl;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TransRecom {
	private static BufferedReader br = null;  
	private static File file = null;  
	private static BufferedWriter bw = null; 
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		  File filer = new File("data/recommendation/selectbusinessproperty_1654.txt");
		  File filew = new File("data/recom_1654.txt");
		  
		  FileOutputStream fop =  new FileOutputStream(filew);
		  BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fop,"UTF-8"));
		  
		  FileInputStream fip =  new FileInputStream(filer);		   
		  BufferedReader reader = new BufferedReader(new InputStreamReader(fip));
		  //userId= 1830 delivery: FALSE latitude: 35.22073 longitude: 35.22073 outdoor sitting: TRUE alcohol: full_bar parking lot:  take out: TRUE stars: 3.5
		  //0         1    2         3      4         5        6            7       8       9     10    11       12       13     14 15 16   17   18   19     20 
		  try {
	            String line = null;
	            while ((line = reader.readLine()) != null) {
	            	String[] s = line.split(" ");
	            	System.out.println(line);
	            	System.out.println(s.length+"");
	            	writer.write(mapping(s[3])+" "+mapping(s[10])+" "+mapping(s[12])+" "+mapping(s[15])+" "+mapping(s[18])+" "+s[5]+" "+s[7]);
	                writer.newLine();
	                writer.flush();
	            } 
	      } catch (IOException e) {
	            e.printStackTrace();
	      }
		  reader.close();
		  fip.close();
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
