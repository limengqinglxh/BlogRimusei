package blog.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import blog.com.services.UserService;

@Controller
public class RegisterController {
	@Autowired
	private UserService adminService;
	
	//登録画面の表示
	@GetMapping("/register")
	public String getRegisterPage() {
		return "admin_register.html";
	}
	//登録处理
	//url /register/process
	//register
	//もしadminテーブ内に入力されたeamilが存在しなければ保存处理をするメソッドを呼び出して
	//return admin_login.html
	//そうでない場合　return admin_register.html
	@PostMapping("/register/process")
	public String register(@RequestParam String adminName,
			@RequestParam String adminEmail,
			@RequestParam String password) {
		if(userService.createAdmin(adminName, adminEmail, password)) {
			return "admin_login.html";
		}else {
			return "admin_register.html";
		}
		
	}
		
	}

