package FileControl;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;


public class selectPastBusProperty {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
		// read some business id that belongs to a specific user   
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		String inFile = "data/selectwentbefore_1654.csv";


    	String inFile2 = "data/business.csv";
		BufferedReader br2 = null;
		String line2 = "";
		
		File filew = new File("data/selectbuspropertywentbefore_1654_more.txt");
		FileOutputStream fop =  new FileOutputStream(filew);
		BufferedWriter Writer = new BufferedWriter(new OutputStreamWriter(fop,"UTF-8"));
		BufferedWriter bw = null; 
		
		try {

			br = new BufferedReader(new FileReader(inFile));
			br2 = new BufferedReader(new FileReader(inFile2));
			ArrayList<String> arr = new ArrayList<String>();
			while ((line = br.readLine()) != null) {

			        // use comma as separator
				String[] select = line.split(cvsSplitBy);
				String busId = select[1];
				if(!arr.contains(busId)){
					arr.add(busId);
				}
			}
				System.out.println(arr);
		        int num = arr.size();
		    while ((line2 = br2.readLine()) != null) {
//		        line2 = br2.readLine();
		        String[] select2 = line2.split(cvsSplitBy);
		        for(int i = 0; i<num; i++){
//		        	String s = ((Object) hset).get(i);
		        	if(select2[7] .equals(arr.get(i))){
		        		System.out.println( "businessId: "+ select2[7]+" delivery: " + select2[0] 
                                + " alcohol: " + select2[4]	
                                + " parking lot: " + select2[5]
                                + "take out: "+select2[10]
                                + " stars: "+ select2[11]);
		        		Writer.write("businessId: "+ select2[7]+ " delivery: " + select2[0] 
	                            + " outdoor sitting: " + select2[3]
	                            + " alcohol: " + select2[4]	
	                            + " parking lot: " + select2[5]
	                            + " take out: "+select2[10]
	       	                    + " stars: "+ select2[11]);	
		        		Writer.newLine();
		                Writer.flush(); 
		        	}
		        		
		        }
		        
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
