package com.java.servelet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RestaurantInsertServlet
 */
public class RestaurantInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection connection;
		PrintWriter out = response.getWriter();
		try {
			connection = ConnectionHelper.getConnection();
			String cmd = "Insert into restaurant(restaurantId,restaurantName,city,branch,email,contactno)" +
			               "values(?,?,?,?,?,?)";
			PreparedStatement pst= connection.prepareStatement(cmd);
				pst.setInt(1, Integer.parseInt(request.getParameter("restaurantId")));
				pst.setString(2, request.getParameter("restaurantName"));
				pst.setString(3, request.getParameter("city"));
				pst.setInt(4, Integer.parseInt(request.getParameter("branch")));
				pst.setString(5, request.getParameter("email"));
				pst.setInt(6, Integer.parseInt(request.getParameter("contactno")));
				pst.executeUpdate();
				out.println("*** Record Inserted ***");
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
