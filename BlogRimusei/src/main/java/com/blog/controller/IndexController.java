package com.blog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.entity.BlogInfo;
import com.blog.service.BlogService;
import com.blog.service.UserService;

@Controller
@RequestMapping
public class IndexController {

	@Autowired
	UserService userService;
	@Autowired
	BlogService blogService;
	@Autowired
	HttpSession session;

	@RequestMapping(value="")
	public String index(Model model, 
			@RequestParam(value="title", required = false, defaultValue = "") String title) {
		model.addAttribute("login", 1);
		if(null == session.getAttribute("userId")) {
			model.addAttribute("login", 0);
		}
		List<BlogInfo> list = blogService.list(title);
		model.addAttribute("list", list);
		
		return "/index";
	}

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login() {
		return "/login";
	}

	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String register() {
		return "/register";
	}

	@RequestMapping(value="/admin", method = RequestMethod.GET)
	public String admin() {
		if(null == session.getAttribute("userId")) {
			return "login";
		}
		return "/admin";
	}

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(Model model, String account, String password) {
		int val = userService.loginUser(account, password);
		if(val == 0) {
			model.addAttribute("msg", "Password error");
			return "login";
		}
		if(val == -1) {
			model.addAttribute("msg", "Account does not exist");
			return "login";
		}
		return "admin";
	}

	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String register(Model model, String account, String password, String name) {
		int val = userService.registerUser(account, password, name);
		if(val == 0) {
			model.addAttribute("msg", "register has failed");
			return "register";
		}
		if(val == -1) {
			model.addAttribute("msg", "Account already exists");
			return "register";
		}
		model.addAttribute("msg", "Login success");
		return "login";
	}

	@RequestMapping(value="/logout")
	public String logout() {
		session.invalidate();
		return "login";
	}
}
