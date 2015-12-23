package FileControl;
import java.io.IOException;

import org.apache.mahout.cf.taste.common.TasteException;


public class RecommendationTest {

	public static void main(String[] args) throws IOException, TasteException {
		//String uid = "1677";
		//Recommendation re = new Recommendation();
		//re.recommender(uid);
        //re.recommendBusProperty(uid);
        //re.selectPastBusId(uid);
        //re.pastBusPro(uid);
        //ClusterTran ct = new ClusterTran();
        //ct.transRecom(uid);
        //ct.transStar(uid);
        //DoCluster dc = new DoCluster();
        //dc.runCluster(uid);
		DataProcess dp = new DataProcess();
		dp.processing("Yishan");
		System.out.println(dp.getLatitude());
		System.out.println(dp.getLongitude());
		System.out.println(dp.getName());
	}

}
