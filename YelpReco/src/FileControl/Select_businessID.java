package FileControl;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;



public class Select_businessID {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
// read some business id that belongs to a specific user   
		String csvFile = "data/recommendationfile.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		
		
		BufferedWriter bw = null; 
		File filew = new File("data/selectwentbefore_1654.txt");
		FileOutputStream fop =  new FileOutputStream(filew);
		BufferedWriter Writer = new BufferedWriter(new OutputStreamWriter(fop,"UTF-8"));
		
		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

			        // use comma as separator
				String[] select = line.split(cvsSplitBy);
                if(select[0].equals("1654")){
				    System.out.println("userId= " + select[0] 
	                                 + " businessId= " + select[1]
	                                 + " rate: " + select[2]);
//				    Writer.write("userId= " + select[0] 
//                            + " businessId=" + select[1]
//                            + " rate: " + select[2]);
				    Writer.write(select[0]+" "
                           + select[1]+" "
                          + select[2]);
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
