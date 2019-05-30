package com.ariatech.arportal.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class DAO {

	public static int login(String username, String password) {
		int m=0;
 		try
		{
		  Connection conn=DButil.getdbconnection();
		  PreparedStatement pstmt=conn.prepareStatement("select * from login where username=? and password=?");
		
		  pstmt.setString(1, username);
		
		pstmt.setString(2,password);
		  ResultSet rs = pstmt.executeQuery();
          if (rs.next()) 
          {
        	  m=1;
        	  
              System.out.println("Incorrect login credentials");
          } 
          else 
          {
        	  System.out.println("login Sucessfull");
          }
      } 
      catch (Exception e) 
      {
          e.printStackTrace();
      }
		return m;
		
	}

}
