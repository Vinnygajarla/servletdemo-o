package com.java.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RestaurantsSearchServlet
 */
public class RestaurantsSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantsSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int restaurantId = Integer.parseInt(request.getParameter("restaurantId"));
		PrintWriter out = response.getWriter();
		try {
			Connection con = ConnectionHelper.getConnection();
			String cmd = "select * from restaurant where restaurantId=?";
			PreparedStatement pst = con.prepareStatement(cmd);
			pst.setInt(1, restaurantId);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				out.println("restaurantid  " +rs.getInt("restaurantid") + "<br/>");
				out.println("restaurantname  " +rs.getString("restaurantname") + "<br/>");
				out.println("city   " +rs.getString("city") + "<br/>");
				out.println("branch   " +rs.getString("branch") + "<br/>");
				out.println("email  " +rs.getString("email") + "<br/>");
				out.println("contactno  " +rs.getInt("contactno") + "<br/><hr/>");
			} else {
				out.println("*** Record Not Found ***");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
