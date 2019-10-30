package com.java.spring_board.Bcommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.java.spring_board.dao.BDao;


public class BDeleteCommand implements BCommand {

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bNum = request.getParameter("bNum");
		BDao dao = new BDao();
		dao.delete(bNum);
	}

}
