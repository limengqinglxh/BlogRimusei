package com.blog.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // このクラスがJPAのエンティティであることを示すアノテーションです。
@Table(name = "userinfo") // このエンティティがマッピングするデータベーステーブルの名前を指定します。
public class UserInfo {

    @Id // このフィールドがエンティティのプライマリキー（主キー）であることを示します。
    @GeneratedValue(strategy = GenerationType.IDENTITY) // プライマリキーの値はデータベースが自動生成することを示します。
    private Long id; // ユーザーのユニークなID。

    @Column(name = "account") // このフィールドがaccount列にマッピングされることを示します。
    private String account; // ユーザーのアカウント名。

    @Column(name = "password") // このフィールドがpassword列にマッピングされることを示します。
    private String password; // ユーザーのパスワード。

    @Column(name = "name") // このフィールドがname列にマッピングされることを示します。
    private String name; // ユーザーの名前。
    
    @Column(name = "createTime") // このフィールドがcreateTime列にマッピングされることを示します。
    private Date createTime; // アカウントの作成時間。

    // 以下は各フィールドのgetterおよびsetterメソッドです。
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
}