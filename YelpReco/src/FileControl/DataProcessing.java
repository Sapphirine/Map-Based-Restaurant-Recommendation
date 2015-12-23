package FileControl;
import java.io.IOException;
import java.util.ArrayList;


public class DataProcessing {
	public String txt;
	
	private ArrayList<Double> longitude;
	private ArrayList<Double> latitude;
	private ArrayList<String> name;
	
	public DataProcessing(String s){
		
		this.txt = s;
	
		}
	
	public ArrayList<Double> getLongitude(){
		longitude = new ArrayList<Double>();
		//longitude.add(-80.8501723);
		//longitude.add(-80.77854);
		longitude.add(-80.7903369);
		longitude.add(-80.8381685);
		longitude.add(-80.848589);
		//longitude.add(-81.0277219);
		//longitude.add(-81.025964);
		
		
		
		return longitude;
	}
	
	public ArrayList<Double> getLatitude(){
		latitude = new ArrayList<Double>();
		//latitude.add(35.1706933);
		//latitude.add(35.098696);
		latitude.add(35.196533);
		latitude.add(35.2310911);
		latitude.add(35.232204);
		//latitude.add(35.2546334);
		//latitude.add(35.251298);
		return latitude;
	}
	
	public ArrayList<String> getName(){
		name = new ArrayList<String>();
		//name.add("Ole Smokehouse");
		//name.add("Taco Bell");
		name.add("Napoli Pizza & Pasta");
		name.add("The TIN Kitchen");
		name.add("Nana's Uptown Restaurant");
		//name.add("Pizza Hut");
		//name.add("Sub Corral Sandwich Shop");
		return name;
	}
					
		
		
		
	}


