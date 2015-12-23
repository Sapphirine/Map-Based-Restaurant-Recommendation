package FileControl;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.mahout.cf.taste.common.TasteException;


public class DataProcess {
	
	private ArrayList<Double> longitude;
	private ArrayList<Double> latitude;
	private ArrayList<String> name;
	
	public DataProcess(){
		longitude = new ArrayList<Double>();
		latitude = new ArrayList<Double>();
		name = new ArrayList<String>();
	}
	
	public ArrayList<Double> getLongitude(){
		return longitude;
	}
	
	public ArrayList<Double> getLatitude(){
		return latitude;
	}
	
	public ArrayList<String> getName(){
		return name;
	}
	
	public void processing(String username) throws IOException, TasteException {
	//public static void main(String[] args) throws IOException, TasteException {
		//String uid = "1677";
	    latitude.clear();
	    longitude.clear();
	    name.clear();
		NameConverter nc = new NameConverter();
		String uid = nc.NameConverter(username);
		if(!uid.equals("")){
			Recommendation re = new Recommendation();
			re.recommender(uid);
			re.recommendBusProperty(uid);
			re.selectPastBusId(uid);
			re.pastBusPro(uid);
			ClusterTran ct = new ClusterTran();
			ct.transRecom(uid);
			ct.transStar(uid);
			DoCluster dc = new DoCluster();
			//System.out.println(uid);
			ArrayList<String> results = dc.runCluster(uid);
			for(int i=0;i<results.size();i++){
				String[] result = results.get(i).split(",");
				latitude.add(Double.parseDouble(result[0]));
				longitude.add(Double.parseDouble(result[1]));
				name.add(result[2]);
			}
		}
		
	}
}
