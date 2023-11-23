package com.blog.service;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entity.UserInfo;
import com.blog.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	HttpSession session;
	
	public int loginUser(String account, String password) {
		UserInfo u = userRepository.findUserByAccount(account);
		if(null == u) {
			return -1;
		}
		if(!password.equals(u.getPassword())) {
			return 0;
		}
		session.setAttribute("userId", u.getId());
		session.setAttribute("name", u.getName());
		return 1;
	}
	
	public int registerUser(String account, String password, String name) {
		UserInfo u = userRepository.findUserByAccount(account);
		if(null != u) {
			return -1;
		}
		u = new UserInfo();
		u.setAccount(account);
		u.setPassword(password);
		u.setName(name);
		u.setCreateTime(new Date());
		UserInfo su = userRepository.save(u);
		if(null == su) {
			return 0;
		}
		return 1;
	}
}
