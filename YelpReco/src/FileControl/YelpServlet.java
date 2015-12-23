package FileControl;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.mahout.cf.taste.common.TasteException;

/**
 * Servlet implementation class YelpServlet
 */
@WebServlet("/YelpServlet")
public class YelpServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//       DataProcessor dp = new DataProcessor(500);
	//    /**
	//     * @see HttpServlet#HttpServlet()
	//     */
	//    public YelpServlet() {
	//        super();
	//        // TODO Auto-generated constructor stub
	//    }
	//
	//	/**
	//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	//	 */
	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//String user= request.getParameter("user");
		String[] user = request.getParameterValues("user");
		//String user = "1872";
		System.out.println("#########"+user[0]);
		//System.out.println(new File("").getAbsolutePath());
//		DataProcessing dp = new DataProcessing(user[0]);
		DataProcess dp = new DataProcess();
		
		try {
			dp.processing(user[0]);
			System.out.println("servlet"+user);
		} catch (TasteException e) {
			// TODO Auto-generated catch block
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.toString());
            getServletContext().log("Unexpected error in " + getClass().getSimpleName(), e);
		}
		
		ArrayList<Double> d1 = dp.getLatitude();
		ArrayList<Double> d2 = dp.getLongitude();
		ArrayList<String> d3 = dp.getName();
		int size1 = d1.size(); 
		//System.out.println("size1: " +size1);
		int size2 = d2.size();
		int size3 = d3.size();
		Double[] array1=new Double[size1];  
		for(int i=0;i<size1;i++){  
			array1[i]=d1.get(i);  
		}  

		Double[] array2=new Double[size2];  
		for(int i=0;i<size2;i++){  
			array2[i]=d2.get(i);  
		}  

		String[] array3=new String[size3];  
		for(int i=0;i<size3;i++){  
			array3[i]=d3.get(i);  
		} 
		System.out.println(array1.length);
//		response.setContentType("text/html");
//		request.setAttribute("array1", array1);
//		request.setAttribute("array2", array2);
//		request.setAttribute("array3", array3);
//		request.setAttribute("size", size1);
		
		//request.getRequestDispatcher("/index.jsp").include(request, response);
		//String jsonString = "{";
		String latitude = "{ \"latitude\": [  ";
		String longitude = " \"longitude\": [  ";
		String name = " \"name\": [  ";
		for(int i=0;i<size1;i++){
		
			//jsonString += "{ \"latitude\": "+ "\""+ array1[i] +"\", " + "\"longitude\": "+ "\"" +array2[i]+ "\", " +"\"name\": " + "\""+ array3[i] + "\" , " +"\"size\": " + "\""+ size1 + "\" }";
			latitude += "\""+ array1[i] +"\", ";
			longitude += "\"" +array2[i]+ "\", ";
			name += "\""+ array3[i] + "\", ";
		}
		latitude = latitude.substring(0, latitude.length()-2)+"],";
		longitude = longitude.substring(0, longitude.length()-2)+"],";
		name = name.substring(0, name.length()-2)+"],";
		String jsonString = latitude+longitude+name+" \"size\": " + "\""+ size1 + "\"}";
		System.out.println(jsonString);
		response.getWriter().print(jsonString);
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ahah");
	//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String radius=request.getParameter("radius");
//		System.out.println(radius);
//		response.setContentType("text/javascript");
//		request.setAttribute("radius", radius);
//		request.getRequestDispatcher("/page2.jsp").forward(request, response);
	}


}
