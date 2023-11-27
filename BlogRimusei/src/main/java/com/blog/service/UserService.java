package com.blog.service;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entity.UserInfo;
import com.blog.repository.UserRepository;

@Service // このクラスがサービス層のコンポーネントであることを示すアノテーションです。
public class UserService {

    @Autowired // Springの自動依存性注入を使用してリポジトリをインジェクトします。
    private UserRepository userRepository;
    @Autowired
    HttpSession session; // HTTPセッションを扱うためのオブジェクト。

    // ユーザーのログイン処理を行うメソッドです。
    public int loginUser(String account, String password) {
        UserInfo u = userRepository.findUserByAccount(account); // アカウントでユーザーを検索します。
        if(null == u) {
            return -1; // ユーザーが存在しない場合は-1を返します。
        }
        if(!password.equals(u.getPassword())) {
            return 0; // パスワードが一致しない場合は0を返します。
        }
        session.setAttribute("userId", u.getId()); // セッションにユーザーIDを設定します。
        session.setAttribute("name", u.getName()); // セッションにユーザー名を設定します。
        return 1; // ログイン成功の場合は1を返します。
    }
    
    // ユーザーの登録処理を行うメソッドです。
    public int registerUser(String account, String password, String name) {
        UserInfo u = userRepository.findUserByAccount(account); // アカウントでユーザーを検索します。
        if(null != u) {
            return -1; // アカウントが既に存在する場合は-1を返します。
        }
        u = new UserInfo();
        u.setAccount(account);
        u.setPassword(password);
        u.setName(name);
        u.setCreateTime(new Date()); // 現在の日時をアカウントの作成時間として設定します。
        UserInfo su = userRepository.save(u);
        if(null == su) {
            return 0; // 登録に失敗した場合は0を返します。
        }
        return 1; // 登録成功の場合は1を返します。
    }
}