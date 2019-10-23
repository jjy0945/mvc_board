package com.java.spring_board.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

public class LDao {
	
	DataSource dataSource;
	
	public LDao() {
		// TODO Auto-generated constructor stub
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	public void SignUp(String MId, String MPw, String MName, String MAddress, String MPhone) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "insert into Member (MEMBERID, MEMBERPW, MEMBERNAME, MEMBERADDRESS, MEMBERPHONE) values (?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, MId);
			preparedStatement.setString(2, MPw);
			preparedStatement.setString(3, MName);
			preparedStatement.setString(4, MAddress);
			preparedStatement.setString(5, MPhone);
			preparedStatement.executeUpdate();
			
			
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		
	}
	
	
	public void delete(String MId) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			
			connection = dataSource.getConnection();
			
			String query = "delete from Member where MEMBERID = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, MId);
			preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	public void Login(String MId, String MPw, HttpServletResponse response, HttpSession session) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			
			connection = dataSource.getConnection();
			
			String query = "Select MEMBERID, MEMBERPW From MEMBER WHERE MEMBERID = ? and MEMBERPW = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, MId);
			preparedStatement.setString(2, MPw);
			rs = preparedStatement.executeQuery();
			if(rs.next()) {
				response.setContentType("text/html; charset=UTF-8");
				 
				PrintWriter out = response.getWriter();
				 
				out.println("<script>alert('로그인 하셨습니다.'); location.href='/spring_board/LoginEndMain';</script>");
				 
				out.flush();
				
			}
			else {
				session.invalidate(); 
				
				response.setContentType("text/html; charset=UTF-8");
				 
				PrintWriter out = response.getWriter();
				 
				out.println("<script>alert('아이디, 비밀번호가 일치하지 않습니다.'); location.href='http://localhost:8090/spring_board/';</script>");
				 
				out.flush();
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	
	}

}