package com.blog.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.blog.entity.BlogInfo;
import com.blog.entity.BlogInfoVo;
import com.blog.entity.UserInfo;
import com.blog.repository.BlogRepository;
import com.blog.repository.UserRepository;

import java.util.Date;
@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	HttpSession session;
	
	public int add(BlogInfo blogInfo) {
		Assert.notNull(blogInfo, "blogInfo must not be null!");
		blogInfo.setBlogtime(new Date());
		Long userId = Long.valueOf(session.getAttribute("userId").toString());
		blogInfo.setBloguser(userId);
		BlogInfo save = blogRepository.save(blogInfo);
		if(null == save) {
			return 0;
		}
		return 1;
	}
	
	public int edit(BlogInfo blogInfo) {
		Assert.notNull(blogInfo, "blogInfo must not be null!");
		BlogInfo save = blogRepository.save(blogInfo);
		if(null == save) {
			return 0;
		}
		return 1;
	}
	
	public int del(Long id) {
		try {
			blogRepository.deleteById(id);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public List<BlogInfo> list(String title) {
		List<BlogInfo> list = new ArrayList<BlogInfo>();
		if(null == session.getAttribute("userId")) {
			if(title.equals("")) {
				return blogRepository.findAll();
			}
			return blogRepository.findAllByTitle3(title);
		}
		Long userId = Long.valueOf(session.getAttribute("userId").toString());
		if(title.equals("")) {
			list = blogRepository.findAllByTitle(userId);
		}else {
			list = blogRepository.findAllByTitle2(userId, title);
		}
		return list;
	}
	
	public BlogInfo detail(Long id) {
		Optional<BlogInfo> info = blogRepository.findById(id);
		
		return info.get();
	}
	
	private BlogInfoVo info2Vo(BlogInfo info) {
		BlogInfoVo vo = new BlogInfoVo();
		vo.setBlogid(info.getBlogid());
		vo.setBlogtitle(info.getBlogtitle());
		vo.setBlogtag(info.getBlogtag());
		vo.setBlogdesc(info.getBlogdesc());
		vo.setBloguser(info.getBloguser());
		Optional<UserInfo> userinfo = userRepository.findById(info.getBloguser());
		if(!userinfo.isEmpty()) {
			vo.setUsername(userinfo.get().getName());
		}
		return vo;
	}
}
