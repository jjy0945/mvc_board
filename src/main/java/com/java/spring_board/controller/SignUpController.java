package com.java.spring_board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.spring_board.Lcommand.LCommand;
import com.java.spring_board.Lcommand.LDeleteCommand;
import com.java.spring_board.Lcommand.LSignUpCommand;
import com.java.spring_board.Lcommand.LoginCommand;


@Controller
public class SignUpController {
	
	LCommand command = null;
	
	@RequestMapping(value = "/SignUp", method = RequestMethod.GET)
	public String SignUp(Model model) {
		

		return "SignUp";
	}
	
	@RequestMapping(value = "/GoSession", method = RequestMethod.GET)
	public String GoSession(Model model) {
		

		return "GoSession";
	}
	
	@RequestMapping(value = "/SignUpGo", method = RequestMethod.POST)
	public String SignUpGo(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		
		model.addAttribute("request", request);
		command = new LSignUpCommand();
		command.execute(model);
		
		response.setContentType("text/html; charset=UTF-8");
		 
		PrintWriter out = response.getWriter();
		 
		out.println("<script>alert('계정이 등록 되었습니다.'); location.href='/spring_board/';</script>");
		 
		out.flush();
		
		return "";
	}
	
	@RequestMapping(value = "/SignOut", method = RequestMethod.GET)
	public String SignOut(Model model) {
		

		return "SignOut";
	}
	
	@RequestMapping(value = "/SignOutGo", method = RequestMethod.POST)
	public String SignOutGo(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		
		model.addAttribute("request", request);
		command = new LDeleteCommand();
		command.execute(model);
		
		response.setContentType("text/html; charset=UTF-8");
		 
		PrintWriter out = response.getWriter();
		 
		out.println("<script>alert('계정이 탈퇴 되었습니다.'); location.href='/spring_board/';</script>");
		 
		out.flush();
		
		return "";
	}
	
	@RequestMapping(value = "/LoginEndMain", method = RequestMethod.GET)
	public String LoginEndMain(Model model) {
		

		return "LoginEndMain";
	}
	

	@RequestMapping(value = "/LoginGo", method = RequestMethod.POST)
	public String LoginGo(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) throws IOException {
		
		String MID = request.getParameter("MId");
    	
        session.setAttribute("id", MID);
		
		model.addAttribute("request", request);
		model.addAttribute("response", response);
		model.addAttribute("session", session);
		
		command = new LoginCommand();
		command.execute(model);
		
		
		
		return "";
	}
	 
}
