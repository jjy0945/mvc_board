package com.java.spring_board.Lcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.java.spring_board.dao.LDao;

public class LDeleteCommand implements LCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String MId = request.getParameter("MId");
		
		LDao dao = new LDao();
		dao.delete(MId);
	}

}
