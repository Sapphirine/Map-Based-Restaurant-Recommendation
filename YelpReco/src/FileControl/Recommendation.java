package FileControl;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;


public class Recommendation {
	public void recommender(String userId) throws IOException, TasteException{
		FileWriter fw = new FileWriter("data/recommender_"+userId+".txt");
		int uid = Integer.parseInt(userId);
		DataModel model = new FileDataModel (new File("data/recommendationfile.txt"));
		UserSimilarity similarity =new PearsonCorrelationSimilarity (model);
		
		//UserSimilarity similarity = new EuclideanDistanceSimilarity (model);
		//UserSimilarity similarity = new CachingUserSimilarity (new SpearmanCorrelationSimilarity(model), model);

		UserNeighborhood neighborhood =
		  new NearestNUserNeighborhood (7, similarity, model);

		//use userbasedRecommender
		GenericUserBasedRecommender recommender = new GenericUserBasedRecommender (model, neighborhood, similarity);
		List<RecommendedItem> recommendations =
			recommender.recommend(uid,7);

		for (RecommendedItem recommendation : recommendations) {
		  System.out.println(recommendation);
		  fw.write("UserId:" +"userId"+recommendation.toString()+"\n");
			}
		fw.close();
	}
	
	public void recommendBusProperty(String uid) throws IOException{
		BufferedReader br = null;
		String line = "";
		String txtSplitBy = " ";
		String inFile = "data/recommender_"+uid+".txt";
		
    	String inFile2 = "data/business.csv";
		BufferedReader br2 = null;
		String line2 = "";
		String csvSplitBy = ",";
		
		File filew = new File("data/selectbusinessproperty_"+uid+".txt");
		FileOutputStream fop =  new FileOutputStream(filew);
		BufferedWriter Writer = new BufferedWriter(new OutputStreamWriter(fop,"UTF-8"));
		BufferedWriter bw = null; 
		
		try {
			br = new BufferedReader(new FileReader(inFile));
			br2 = new BufferedReader(new FileReader(inFile2));
			ArrayList<String> arr = new ArrayList<String>();
			
			while ((line = br.readLine()) != null) {
//				String[] select = line.split(txtSplitBy);
				String busId = line.substring(34,38);
				if(!arr.contains(busId)){
					arr.add(busId);
				}
			}
				//System.out.println(arr);
		        int num = arr.size();
		    while ((line2 = br2.readLine()) != null) {
		        String[] select2 = line2.split(csvSplitBy);
		        for(int i = 0; i<num; i++){
		        	if(select2[7].equals("1926")){
					    //System.out.println("delivery: " + select2[0] 
					    //		         +" latitude: " + select2[1]
					    //		         +" longitude: " + select2[2]
		                //                 + " outdoor sitting: " + select2[3]
		                //                 + " alcohol: " + select2[4]	
		                //                 + " parking lot: " + select2[5]
		                //                 + " take out: "+select2[10]
		                //                 + " stars: "+ select2[11]);
					    Writer.write("userId= 1654 " + "delivery: " + select2[0] 
					    		+" latitude: " + select2[1]
					    		+" longitude: " + select2[2]
	                            + " outdoor sitting: " + select2[3]
	                            + " alcohol: " + select2[4]	
	                            + " parking lot: " + select2[5]
	                            + " take out: "+select2[10]
	       	                    + " stars: "+ select2[11]
	       	                    + " name: "+ select2[8]);
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
	
	public void selectPastBusId(String uid) throws FileNotFoundException, UnsupportedEncodingException{
		String csvFile = "data/recommendationfile.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
			
		BufferedWriter bw = null; 
		File filew = new File("data/selectwentbefore_"+uid+".txt");
		FileOutputStream fop =  new FileOutputStream(filew);
		BufferedWriter Writer = new BufferedWriter(new OutputStreamWriter(fop,"UTF-8"));
		
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
			        // use comma as separator
				String[] select = line.split(cvsSplitBy);
                if(select[0].equals(uid)){
				   // System.out.println("userId= " + select[0] 
	               //                  + " businessId=" + select[1]
	               //                  + " rate: " + select[2]);
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
	
	
	public void pastBusPro(String uid) throws FileNotFoundException, UnsupportedEncodingException{
		BufferedReader br = null;
		String line = "";
		String txtSplitBy = " ";
		String inFile = "data/selectwentbefore_"+uid+".txt";
		
    	String inFile2 = "data/business.csv";
		BufferedReader br2 = null;
		String line2 = "";
		String csvSplitBy = ",";
		
		File filew = new File("data/selectbuspropertywentbefore_"+uid+".txt");
		FileOutputStream fop =  new FileOutputStream(filew);
		BufferedWriter Writer = new BufferedWriter(new OutputStreamWriter(fop,"UTF-8"));
		BufferedWriter bw = null; 
		
		try {
			br = new BufferedReader(new FileReader(inFile));
			br2 = new BufferedReader(new FileReader(inFile2));
			ArrayList<String> arr = new ArrayList<String>();
			
			while ((line = br.readLine()) != null) {
				String[] select = line.split(txtSplitBy);
				String busId = select[1];
				if(!arr.contains(busId)){
					arr.add(busId);
				}
			}
				//System.out.println(arr);
		        int num = arr.size();
		    while ((line2 = br2.readLine()) != null) {
		        String[] select2 = line2.split(csvSplitBy);
		        for(int i = 0; i<num; i++){
		        	if(select2[7] .equals(arr.get(i))){
		        		//System.out.println( "businessId: "+ select2[7]+" delivery: " + select2[0] 
                        //        + " alcohol: " + select2[4]	
                        //        + " parking lot: " + select2[5]
                        //        + "take out: "+select2[10]
                        //        + " stars: "+ select2[11]);
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
