package com.java.spring_board.Lcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.java.spring_board.dao.LDao;

public class LoginCommand implements LCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpServletResponse response = (HttpServletResponse) map.get("response");
		HttpSession session = (HttpSession) map.get("session");
		
		String MId = request.getParameter("MId");
		String MPw = request.getParameter("MPw");
	
		LDao dao = new LDao();
		dao.Login(MId, MPw, request, response, session);
	}

}
