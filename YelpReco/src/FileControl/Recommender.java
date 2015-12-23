package FileControl;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.CachingUserSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.SpearmanCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.apache.mahout.math.hadoop.similarity.cooccurrence.measures.CosineSimilarity;

//import com.sun.xml.bind.v2.schemagen.xmlschema.java.util.List;

public class Recommender{
	public static void main(String[] args) throws Exception {
		FileWriter fw = new FileWriter("/Users/MAC/Desktop/recommender_1830.txt");
		//DataModel model = new FileDataModel (new File("/Users/MAC/Desktop/music.txt"));
		DataModel model = new FileDataModel (new File("/Users/MAC/Desktop/recommendationfile.txt"));
		//System.out.println("11111");
		UserSimilarity similarity =new PearsonCorrelationSimilarity (model);
		
		//UserSimilarity similarity = new EuclideanDistanceSimilarity (model);
		
		//UserSimilarity similarity = new CachingUserSimilarity (new SpearmanCorrelationSimilarity(model), model);

		UserNeighborhood neighborhood =
		  new NearestNUserNeighborhood (7, similarity, model);

		//use userbasedRecommender
		GenericUserBasedRecommender recommender = new GenericUserBasedRecommender (model, neighborhood, similarity);
		
		
		List<RecommendedItem> recommendations =
			recommender.recommend(1830,7);

		for (RecommendedItem recommendation : recommendations) {
		  //System.out.println(recommendation);
		  fw.write("UserId: 1830"+recommendation.toString()+"\n");
			}
		fw.close();
	}
}

