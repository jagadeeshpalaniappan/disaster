package com.sundar.disastermanagement.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sundar.disastermanagement.service.IncidentServiceImpl;
import com.sundar.disastermanagement.vo.LocationVO;


/**
 * Servlet implementation class GetVillageList
 */
public class GetVillageList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetVillageList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id= Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		IncidentServiceImpl impl=IncidentServiceImpl.getIncidentService();
		List<LocationVO> list=impl.getVillagesByTalukId(id);
		PrintWriter out = response.getWriter();
		System.out.println("hi villages");
		out.println("<div id=villages>"
				+ "<input class='form-control' id='village1' name='village' list='villageList' placeholder='type your village' >"
				+ "<datalist  id='villageList'>");
		Iterator<LocationVO> itr=list.iterator();
		while(itr.hasNext())
			{
			LocationVO locationVO=itr.next();
			out.println("<option value="+locationVO.getLocationID()+">"+locationVO.getVillageName()+
					"</option>");
			}
		out.println("</datalist></div>");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
