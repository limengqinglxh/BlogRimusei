package blog.com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import blog.com.models.entity.UserEntity;
import blog.com.services.UserService;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	//Sessionがつけるように宣言
	@Autowired
	private HttpSession session;
	
	//ログイン画面の表示
	@GetMapping("/login")
	public String getLoginPage() {
		return "admin_login.html";
	}
	
	//ログイン処理
	@PostMapping("/login/process")
	public String login(@RequestParam String adminEmail,@RequestParam String password) {
		//Serviceクラスのメソッドを使ってログインしている人の情報を获得して変数に格纳する
		UserEntity admin = userService.checkLogin(adminEmail,password);
		if(admin == null) {
			return "admin_login.html";
		}else {
			//sessionを使ってログインしている人の情報を保存酢する
			session.setAttribute("admin", admin);
			//return "product_list.html";
			return "redirect:/product/list";
		}
	}	
		//ログイン処理
		@GetMapping("/logout")
		public String logout() {
			//セッションの無効化
			session.invalidate();
			return "redirect:/login";
		}
	}
	


