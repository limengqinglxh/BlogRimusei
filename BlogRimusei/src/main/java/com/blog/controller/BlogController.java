package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.entity.BlogInfo;
import com.blog.service.BlogService;

@Controller
@RequestMapping(value="/blog")
public class BlogController {

	@Autowired
	BlogService blogService;
	
	@RequestMapping(value="/detail")
	public String add(Long id) {
		
		return "detail";
	}
	
	@RequestMapping(value="/add")
	@ResponseBody
	public int add(@RequestBody BlogInfo blogInfo) {
		return blogService.add(blogInfo);
	}
	
	@RequestMapping(value="/del")
	@ResponseBody
	public int del(Long id) {
		return blogService.del(id);
	}
	
	@RequestMapping(value="/edit")
	@ResponseBody
	public int edit(@RequestBody BlogInfo blogInfo) {
		return blogService.edit(blogInfo);
	}
	
	@RequestMapping(value="/list")
	@ResponseBody
	public List<BlogInfo> list(String title) {
		return blogService.list(title);
	}
}
