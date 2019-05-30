package com.ariatech.arportal.connections;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;

public class DBConnection {
	Connection con;
	public DBConnection() {
		super();
		// TODO Auto-generated constructor stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			this.con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","root","server"); 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Map getLoginStatus(String uname,String pwd) throws SQLException {
		Map retMap = new HashMap<String, String>();
		Statement st= con.createStatement();
        System.out.println("connection established successfully...!!");
        String query = "select * from login where username = '"+uname+"' and password = '"+pwd+"'";
        ResultSet resultset=st.executeQuery(query);
        ResultSetMetaData metadata = resultset.getMetaData();
        System.out.println(metadata);
        int numberOfColumns = metadata.getColumnCount();
        Map<String,String> arrayList = new HashMap<String,String>(); 
        while (resultset.next()) {              
        	 arrayList.put("username",resultset.getString("username"));
             arrayList.put("password",resultset.getString("password"));
             arrayList.put("role",resultset.getString("role"));
               // System.out.println(resultset.getString("username"));
               // System.out.println(resultset.getString("password"));
               // System.out.println(resultset.getString("role"));                    
        }
        return arrayList;
	}
	
	public List getQuestions() throws SQLException {
		List<Map<String,String>> al = new ArrayList<Map<String,String>>();
		Map retMap = new HashMap<String, String>();
		Statement st= con.createStatement();
        System.out.println("connection established successfully...!!");
        String query = "select * from questions";
        ResultSet resultset=st.executeQuery(query);
        ResultSetMetaData metadata = resultset.getMetaData();
        System.out.println(metadata);
        int numberOfColumns = metadata.getColumnCount();
        System.out.println(numberOfColumns);
       
        while (resultset.next()) { 
        	Map<String,String> qmap = new HashMap<String,String>(); 
        	qmap.put("questionid",resultset.getString("questionid"));
        	qmap.put("question",resultset.getString("question"));
        	qmap.put("answer1",resultset.getString("answer1"));
        	qmap.put("answer2",resultset.getString("answer2"));
        	qmap.put("answer3",resultset.getString("answer3"));
        	qmap.put("answer4",resultset.getString("answer4"));
             System.out.println(qmap);
             al.add(qmap);
               // System.out.println(resultset.getString("username"));
               // System.out.println(resultset.getString("password"));
               // System.out.println(resultset.getString("role"));                     
        }
		return al;
		
		/*Map<String,String> qMap = new HashMap<String,String>(); 
		qMap.put("question_id","123");
		qMap.put("question","Q1");
		qMap.put("answer_1","ans1");
		qMap.put("answer_2","ans2");
		qMap.put("answer_3","ans3");
		qMap.put("answer_4","ans4");
		Map<String,String> qMap2 = new HashMap<String,String>(); 
		qMap2.put("question_id","1234");
		qMap2.put("question","Q2");
		qMap2.put("answer_1","ans1");
		qMap2.put("answer_2","ans2");
		qMap2.put("answer_3","ans3");
		qMap2.put("answer_4","ans4");
		List<Map<String, String>> retData = new ArrayList<Map<String, String>>();
		System.out.println(qMap);
		retData.add(qMap);
		System.out.println(qMap2);
		retData.add(qMap2);
		System.out.println(retData);
		
		
        return retData;*/
	}
	
	

}
