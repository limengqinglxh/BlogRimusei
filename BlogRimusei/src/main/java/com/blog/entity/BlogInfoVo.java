package com.blog.entity;

public class BlogInfoVo {

    private Long blogid; // ブログのID。

    private Long bloguser; // ブログを投稿したユーザーのID。

    private String username; // ブログを投稿したユーザーの名前。

    private String blogtitle; // ブログのタイトル。

    private String blogdesc; // ブログの説明。
    
    private String blogtag; // ブログのタグ。
    
    private String blogtime; // ブログが投稿された時間（文字列形式）。

    // 以下は各フィールドのgetterおよびsetterメソッドです。
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getBlogtime() {
        return blogtime;
    }

    public void setBlogtime(String blogtime) {
        this.blogtime = blogtime;
    }
    
}