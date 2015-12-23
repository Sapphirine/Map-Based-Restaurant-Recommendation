package FileControl;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;



public class SelectBusPro {

	
	public static void main(String[] args) throws IOException {
// read some business id that belongs to a specific user   
//		String csvFile = "/Users/MAC/Desktop/review_user+busId.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
//read the recommended business id
//		String inFile = "/Users/MAC/recommender_1521.csv";

//get the properties of recommended business ID
		String inFile = "data/business.csv";
		
		
		BufferedWriter bw = null; 
		File filew = new File("data/selectbusinessproperty_1654.txt");
		FileOutputStream fop =  new FileOutputStream(filew);
		BufferedWriter Writer = new BufferedWriter(new OutputStreamWriter(fop,"UTF-8"));
		
		try {

			br = new BufferedReader(new FileReader(inFile));
			while ((line = br.readLine()) != null) {

			        // use comma as separator
				String[] select = line.split(cvsSplitBy);
		//		String businessId = 1683
                if(select[7].equals("1926")){
				    System.out.println("delivery: " + select[0] 
				    		         +" latitude: " + select[1]
				    		         +" longitude: " + select[2]
	                                 + " outdoor sitting: " + select[3]
	                                 + " alcohol: " + select[4]	
	                                 + " parking lot: " + select[5]
	                                 + " take out: "+select[10]
	                                 + " stars: "+ select[11]);
				    Writer.write("userId= 1654 " + "delivery: " + select[0] 
				    		+" latitude: " + select[1]
				    		+" longitude: " + select[2]
                            + " outdoor sitting: " + select[3]
                            + " alcohol: " + select[4]	
                            + " parking lot: " + select[5]
                            + " take out: "+select[10]
       	                    + " stars: "+ select[11]);
	                Writer.newLine();
	                Writer.flush(); 

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
