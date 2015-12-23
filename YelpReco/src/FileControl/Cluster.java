package FileControl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.mllib.clustering.KMeans;
import org.apache.spark.mllib.clustering.KMeansModel;
import org.apache.spark.mllib.linalg.Vector;
import org.apache.spark.mllib.linalg.Vectors;


public class Cluster {

	private static final Pattern SPLITOR = Pattern.compile(",");
	private JavaRDD<String> data;
	private String path;
	private JavaSparkContext sc;
	
	public Cluster(String path) {
		SparkConf sparkConf = new SparkConf().setAppName("K-Means").setMaster("local[2]");
		sc = new JavaSparkContext(sparkConf);
		this.path = path;
		data = sc.textFile(path);
	}
	
	public JavaRDD<String> getData(){
		return data;
	}
	
	public JavaRDD<String> findValue(JavaRDD<String> data){
	    JavaRDD<String> value = data.map(s -> {
	       	List<String> splitData = Arrays.asList(SPLITOR.split(s));
	       	String values = splitData.get(1);
	       	for(int i=2;i<splitData.size();i++){
	       		values += SPLITOR+splitData.get(i);
	       	}
	       	return values;
	    });
	    return value;
	}
	
	public double[] findValue (String s){
		List<String> splitData = Arrays.asList(SPLITOR.split(s));
		double[] value = new double[splitData.size()-1];
    	for(int i=1;i<splitData.size();i++){
    		value[i-1] = Double.parseDouble(splitData.get(i));
    	}
    	return value;
	}
	
	public JavaRDD<String> findInfo(JavaRDD<String> data){
	    JavaRDD<String> info = data.map(s -> {
	       	List<String> splitData = Arrays.asList(SPLITOR.split(s));
	       	return splitData.get(0);
	    });
	    return info;
	}
	
	public String findInfo(String s){
	    return Arrays.asList(SPLITOR.split(s)).get(0);
	}
	
	public KMeansModel doClustering(int numCluster, int numIteration, int numRun){
		JavaRDD<String> subData = findValue(data);
		JavaRDD<Vector> parsedData = subData.map(s -> {
	    	double[] values = Arrays.asList(SPLITOR.split(s)).stream().mapToDouble(Double::parseDouble).toArray();
	        return Vectors.dense(values);
	    });
		return KMeans.train(parsedData.rdd(), numCluster, numIteration, numRun);
	}
	
	public int whichCluster(KMeansModel clusters, double[] point){
		return clusters.predict(Vectors.dense(point));
	}
	
//	public ArrayList<ArrayList<String>> infoCollection(KMeansModel clusters, int numCluster){
//		ArrayList<ArrayList<String>> info = new ArrayList<ArrayList<String>> ();
//		for(int i=0;i<numCluster;i++){
//			ArrayList<String> a = new ArrayList<String>();
//			info.add(a);
//		}
//		data = sc.textFile(path);
//		data.map(s -> {
//			System.out.println("ahsbdg");
////			List<String> splitData = Arrays.asList(SPLITOR.split(s));
////			double[] point = new double[splitData.size()-1];
////	    	for(int i=1;i<splitData.size();i++){
////	    		point[i-1] = Double.parseDouble(splitData.get(i));
////	    	}
////			//String value = Arrays.asList(SPLITOR.split(s)).get(0);
////	    	System.out.println("" + (clusters.predict(Vectors.dense(point))-1) + splitData.get(0));
////			info.get(clusters.predict(Vectors.dense(point))-1).add(splitData.get(0));
////			//info.put(clusters.predict(Vectors.dense(point)),value);
//			return 1;
//		});
//		return info;
//	}
}
