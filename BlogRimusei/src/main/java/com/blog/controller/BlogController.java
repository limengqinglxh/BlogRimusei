package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.entity.BlogInfo;
import com.blog.service.BlogService;

@Controller// コントローラーとしての役割を持つクラスを表します。
@RequestMapping(value="/blog")// このコントローラーが処理するリクエストの基本パスを/blogに設定します。
public class BlogController {

	@Autowired// Springによる依存性注入を使ってBlogServiceを自動的に割り当てます。
	BlogService blogService;
	// 単純なビューを返すメソッド。博客の詳細ページに使用される可能性があります。
	@RequestMapping(value="/detail")
	public String add(Long id) {
		
		return "detail";// "detail"という名前のビューを返します。
	}
	 // 博客を追加するメソッド。リクエストボディからBlogInfoオブジェクトを受け取ります。
	@RequestMapping(value="/add")
	@ResponseBody// 戻り値をレスポンスボディとして直接返します。
	public int add(@RequestBody BlogInfo blogInfo) {
		return blogService.add(blogInfo);// BlogServiceを使用して博客を追加し、結果を返します。
	}
	// 博客を削除するメソッド。IDをパラメータとして受け取ります。
	@RequestMapping(value="/del")
	@ResponseBody
	public int del(Long id) {
		return blogService.del(id);// BlogServiceを使用して指定されたIDの博客を削除し、結果を返します。
	}
	// 博客を編集するメソッド。リクエストボディからBlogInfoオブジェクトを受け取ります。
	@RequestMapping(value="/edit")
	@ResponseBody
	public int edit(@RequestBody BlogInfo blogInfo) {
		return blogService.edit(blogInfo);// BlogServiceを使用して博客を編集し、結果を返します。
	}
	// 博客のリストを取得するメソッド。タイトルで検索します。
	@RequestMapping(value="/list")
	@ResponseBody
	public List<BlogInfo> list(String title) {
		return blogService.list(title);// BlogServiceを使用して指定されたタイトルに基づいた博客のリストを返します。
	}
}
