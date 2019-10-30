package com.java.spring_board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.java.spring_board.dto.BDto;

public class BDao {
	
	DataSource dataSource;
	
	public BDao() {
		// TODO Auto-generated constructor stub
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
public ArrayList<BDto> list() {
		
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select BNUM, BID, BTITLE, BCONTENT from MVC_BOARD order by BNUM desc";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int bNum = resultSet.getInt("BNUM");
				String bId = resultSet.getString("BID");
				String bTitle = resultSet.getString("BTITLE");
				String bContent = resultSet.getString("BCONTENT");
				
				BDto dto = new BDto(bNum, bId, bTitle, bContent);
				dtos.add(dto);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return dtos;
}


public void write(String bName, String bTitle, String bContent) {
	// TODO Auto-generated method stub
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	
	try {
		connection = dataSource.getConnection();
		String query = "insert into MVC_BOARD (BNUM, BID, BTITLE, BCONTENT) values (MVC_BOARD_SEQ.nextval, ?, ?, ?)";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, bName);
		preparedStatement.setString(2, bTitle);
		preparedStatement.setString(3, bContent);
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

public BDto ContentView(String bNum) {
	// TODO Auto-generated method stub
	
	BDto dto = null;
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	
	try {
		
		connection = dataSource.getConnection();
		
		String query = "select * from MVC_BOARD where BNUM = ?";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, Integer.parseInt(bNum));
		resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			int BNUM = resultSet.getInt("BNUM");
			String BID = resultSet.getString("BID");
			String BTITLE = resultSet.getString("BTITLE");
			String BCONTENT = resultSet.getString("BCONTENT");
			
			dto = new BDto(BNUM, BID, BTITLE, BCONTENT);
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	} finally {
		try {
			if(resultSet != null) resultSet.close();
			if(preparedStatement != null) preparedStatement.close();
			if(connection != null) connection.close();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	}
	return dto;
}

public void update(String bNum, String bTitle, String bContent) {
	// TODO Auto-generated method stub
	
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	
	try {
		connection = dataSource.getConnection();
		
		String query = "update MVC_BOARD set BTITLE = ?, BCONTENT = ? where BNUM = ?";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, bTitle);
		preparedStatement.setString(2, bContent);
		preparedStatement.setInt(3, Integer.parseInt(bNum));
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

public void delete(String bNum) {
	// TODO Auto-generated method stub
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	try {
		
		connection = dataSource.getConnection();
		String query = "delete from MVC_BOARD where BNUM = ?";
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, Integer.parseInt(bNum));
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

}