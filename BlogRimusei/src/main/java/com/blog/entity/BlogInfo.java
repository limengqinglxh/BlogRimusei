package com.blog.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // このクラスがJPAのエンティティであることを示すアノテーションです。
@Table(name = "bloginfo") // このエンティティがマッピングするデータベーステーブルの名前を指定します。
public class BlogInfo {

    @Id // このフィールドがエンティティのプライマリキー（主キー）であることを示します。
    @GeneratedValue(strategy = GenerationType.IDENTITY) // プライマリキーの値はデータベースが自動生成することを示します。
    private Long blogid; // ブログのユニークなID。

    @Column(name = "bloguser") // このフィールドがbloguser列にマッピングされることを示します。
    private Long bloguser; // ブログを投稿したユーザーのID。

    @Column(name = "blogtitle") // このフィールドがblogtitle列にマッピングされることを示します。
    private String blogtitle; // ブログのタイトル。

    @Column(name = "blogdesc") // このフィールドがblogdesc列にマッピングされることを示します。
    private String blogdesc; // ブログの説明。

    @Column(name = "blogtag") // このフィールドがblogtag列にマッピングされることを示します。
    private String blogtag; // ブログのタグ。

    @Column(name = "blogtime") // このフィールドがblogtime列にマッピングされることを示します。
    private Date blogtime; // ブログが投稿された日時。

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
