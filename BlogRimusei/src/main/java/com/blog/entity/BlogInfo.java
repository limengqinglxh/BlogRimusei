package com.blog.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bloginfo")
public class BlogInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long blogid;

	@Column(name = "bloguser")
	private Long bloguser;

	@Column(name = "blogtitle")
	private String blogtitle;

	@Column(name = "blogdesc")
	private String blogdesc;
	
	@Column(name = "blogtag")
	private String blogtag;
	
	@Column(name = "blogtime")
	private Date blogtime;

	public Long getBlogid() {
		return blogid;
	}

	public void setBlogid(Long blogid) {
		this.blogid = blogid;
	}

	public Long getBloguser() {
		return bloguser;
	}

	public void setBloguser(Long bloguser) {
		this.bloguser = bloguser;
	}

	public String getBlogtitle() {
		return blogtitle;
	}

	public void setBlogtitle(String blogtitle) {
		this.blogtitle = blogtitle;
	}

	public String getBlogdesc() {
		return blogdesc;
	}

	public void setBlogdesc(String blogdesc) {
		this.blogdesc = blogdesc;
	}

	public String getBlogtag() {
		return blogtag;
	}

	public void setBlogtag(String blogtag) {
		this.blogtag = blogtag;
	}

	public Date getBlogtime() {
		return blogtime;
	}

	public void setBlogtime(Date blogtime) {
		this.blogtime = blogtime;
	}

	
}
