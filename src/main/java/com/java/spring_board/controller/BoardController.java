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

import com.java.spring_board.Bcommand.BCommand;
import com.java.spring_board.Bcommand.BContentCommand;
import com.java.spring_board.Bcommand.BDeleteCommand;
import com.java.spring_board.Bcommand.BListCommand;
import com.java.spring_board.Bcommand.BUpdateCommand;
import com.java.spring_board.Bcommand.BWriteCommand;


@Controller
public class BoardController {
	
	BCommand command = null;
	
	@RequestMapping(value = "/Board", method = RequestMethod.GET)
	public String list(Model model) {
		
		command = new BListCommand();
		command.execute(model);
		
		return "Board";
	}
	
	@RequestMapping(value = "/BWrite", method = RequestMethod.GET)
	public String Login(Model model) {
		

		return "BWrite";
	}
	
	@RequestMapping(value = "/BWriteGo", method = RequestMethod.POST)
	public String SignUpGo(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		
		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.execute(model);
		
		response.setContentType("text/html; charset=UTF-8");
		 
		PrintWriter out = response.getWriter();
		 
		out.println("<script>alert('게시글이 등록되었습니다.'); location.href='/spring_board/Board';</script>");
		 
		out.flush();
		
		return "";
	}
	
	
	@RequestMapping(value = "/ContentView", method = RequestMethod.GET)
	public String content_view(HttpSession session, HttpServletRequest request, HttpServletRequest response, Model model){
		
		model.addAttribute("request", request);
		command = new BContentCommand();
		command.execute(model);
		
		return "ContentView";
	}
	
	@RequestMapping(value = "/SessionDel", method = RequestMethod.GET)
	public String SessionDel(HttpSession session, Model model) {
		
		session.invalidate();
		
		return "Main";
	}
	
	@RequestMapping(value = "/BUpdateGo", method = RequestMethod.POST)
	public String BUpdateGo(HttpServletRequest request, Model model){
		
		model.addAttribute("request", request);
		command = new BUpdateCommand();
		command.execute(model);
		
		return "redirect:Board";
	}
	
	@RequestMapping(value = "/BDeleteGo", method = RequestMethod.POST)
	public String BDeleteGo(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);
		
		return "redirect:Board";
	}
	
}