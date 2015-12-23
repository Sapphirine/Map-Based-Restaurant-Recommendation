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

import org.apache.spark.mllib.clustering.KMeansModel;
import org.apache.spark.mllib.linalg.Vectors;


public class DoCluster {
	public static final String PATH = "data/";
	public static final String USERRECORD = "star_";
	public static final String RECOMM = "recom_";
	public static final String OUTPUT = "result_";
	public static final String EXTENSION = ".txt";
	
	
	public ArrayList<Integer> giveGrade(int numCluster, String uid, KMeansModel clusters) throws IOException{
		int[] grade = new int[numCluster];
		for(int i=0;i<numCluster;i++){
			grade[i]=0;
		}
		
		File file = new File(PATH+USERRECORD+uid+EXTENSION);
		FileInputStream fis =  new FileInputStream(file);		   
		BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
		try {
            String line = null;
            while ((line = reader.readLine()) != null) {
            	
            	String[] s = line.split(" ");
            	double[] point = new double[s.length-1];
            	for(int i=0;i<s.length-1;i++){
            		point[i] = Double.parseDouble(s[i]);
            	}
            	grade[clusters.predict(Vectors.dense(point))] += Double.parseDouble(s[s.length-1])-3;
            } 
        } catch (IOException e) {
            e.printStackTrace();
        }
	    reader.close();  
	    fis.close();
	    int max = grade[0];
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    for(int i=0;i<numCluster;i++){
	    	if(grade[i]==max)
	    		result.add(i);
	    	else if(grade[i]>max){
	    		max = grade[i];
	    		result.clear();
	    		result.add(i);
	    	}
	    }
	    return result;
	}
	
	public ArrayList<String> filter(String uid, KMeansModel clusters, ArrayList<Integer> topClusters) throws IOException{
		File fileIn = new File(PATH+RECOMM+uid+EXTENSION);
		FileInputStream fis =  new FileInputStream(fileIn);		   
		BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
		
		File fileOut = new File(PATH+OUTPUT+uid+EXTENSION);
		FileOutputStream fos =  new FileOutputStream(fileOut);
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos,"UTF-8"));
		
		int cluster;
		ArrayList<String> result = new ArrayList<String>();
		
		try {
            String line = null;
            String str;
            result.clear();
            ArrayList<String> place = new ArrayList<String>();
            while ((line = reader.readLine()) != null) {
            	
            	String[] s = line.split(" ");
            	if(place.contains(s[5]+s[6]))
            		continue;
            	place.add(s[5]+s[6]);
            	double[] point = new double[5];
            	for(int i=0;i<5;i++){
            		point[i] = Double.parseDouble(s[i]);
            	}
            	cluster = clusters.predict(Vectors.dense(point));
            	if(topClusters.contains(cluster)){
            		str = s[5]+","+s[6]+",";
            		for(int i=7;i<s.length;i++){
	            		str = str+s[i]+" ";
	            	}
            		str = str.substring(0, str.length()-1);
            		//writer.write(s[5]+" "+s[6]);
            		//for(int i=7;i<s.length;i++){
	            	//	writer.write(" "+s[i]);
	            	//}
            		result.add(str);
            		writer.write(str);
            		writer.newLine();
            		writer.flush();
            	}
            } 
        } catch (IOException e) {
            e.printStackTrace();
        }
	    reader.close();  
	    fis.close();
	    writer.close();
	    fos.close();
	    
	    return result;
	}
	
	public ArrayList<String> runCluster(String uid) throws IOException{
	//public static void main(String[] args) throws IOException{
		//String uid = "1654";
		int numCluster = 3;
		int numIteration = 10;
		int numRun = 10;
		String fileName = "data/business_info.txt";
		DoCluster dc = new DoCluster();
		
		//Clustering
		Cluster c = new Cluster(fileName);
		KMeansModel clusters = c.doClustering(numCluster, numIteration, numRun);
		
		
		//Grading
		ArrayList<Integer> topClusters = dc.giveGrade(numCluster, uid, clusters);
		//filter the recommendation result
		return dc.filter(uid, clusters, topClusters);
	}
}
