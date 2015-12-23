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


public class ClusterTran {
	public void transRecom(String uid) throws IOException{
		  File filer = new File("data/selectbusinessproperty_"+uid+".txt");
		  File filew = new File("data/recom_"+uid+".txt");
		  
		  FileOutputStream fop =  new FileOutputStream(filew);
		  BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fop,"UTF-8"));
		  
		  FileInputStream fip =  new FileInputStream(filer);		   
		  BufferedReader reader = new BufferedReader(new InputStreamReader(fip));
		  //userId= 1830 delivery: FALSE latitude: 35.22073 longitude: 35.22073 outdoor sitting: TRUE alcohol: full_bar parking lot:  take out: TRUE stars: 3.5 name: xxx
		  //0         1    2         3      4         5        6            7       8       9     10    11       12       13     14 15 16   17   18   19     20  21    22
		  try {
	            String line = null;
	            while ((line = reader.readLine()) != null) {
	            	String[] s = line.split(" ");
	            	//System.out.println(line);
	            	//System.out.println(s.length+"");
	            	writer.write(mapping(s[3])+" "+mapping(s[10])+" "+mapping(s[12])+" "+mapping(s[15])+" "+mapping(s[18])+" "+s[5]+" "+s[7]);
	            	for(int i=22;i<s.length;i++){
	            		writer.write(" "+s[i]);
	            	}
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
	
	public void transStar(String uid) throws IOException{
		  File file1 = new File("data/selectbuspropertywentbefore_"+uid+".txt");  
		  File file2 = new File("data/selectwentbefore_"+uid+".txt");
		  File filew = new File("data/star_"+uid+".txt");
		  
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
	            	//System.out.println(line);
	            	//System.out.println(s.length+"");
	            	if(id.contains(s[1]))
	            		continue;
	            	id.add(s[1]);
	            	ht.put(s[1], mapping(s[3])+" "+mapping(s[6])+" "+mapping(s[8])+" "+mapping(s[11])+" "+mapping(s[14]));
	            	//System.out.println(ht.get(s[1]));
	            } 
	      } catch (IOException e) {
	            e.printStackTrace();
	      }
		  reader1.close();
		  fip1.close();
		  
		  try {
	            String line = null;
	            while ((line = reader2.readLine()) != null) {
	            	String[] s = line.split(" ");
	            	if(ht.get(s[1])!=null){
	            		writer.write(ht.get(s[1])+" "+s[2]);
	            		writer.newLine();
	            		writer.flush(); 
	            	//System.out.println(ht.get(s[1])+" "+s[2]);
	            	}
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
