package com.java.spring_board.Bcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.java.spring_board.dao.BDao;


public class BWriteCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bName = request.getParameter("BName");
		String bTitle = request.getParameter("BTitle");
		String bContent = request.getParameter("BContent");
		
		BDao dao = new BDao();
		dao.write(bName, bTitle, bContent);
	}

}
