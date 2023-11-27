package com.blog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.blog.entity.BlogInfo;
import com.blog.service.BlogService;
import com.blog.service.UserService;

@Controller // コントローラークラスを表します。Spring MVCの一部です。
@RequestMapping // このコントローラーの基本リクエストパスを設定します。特定のパスが指定されていないため、ルートパス('/')に対応します。
public class IndexController {

    @Autowired // Springの自動依存性注入を使用して、以下のサービスをインジェクトします。
    UserService userService;
    @Autowired
    BlogService blogService;
    @Autowired
    HttpSession session; // HTTPセッションを扱うためのオブジェクト。

    // ホームページに対するリクエストを処理するメソッド。
    @RequestMapping(value="")
    public String index(Model model, 
            @RequestParam(value="title", required = false, defaultValue = "") String title) {
        model.addAttribute("login", 1); // モデルにログイン状態を追加します。
        if(null == session.getAttribute("userId")) {
            model.addAttribute("login", 0); // セッションがない場合はログイン状態を0に設定します。
        }
        List<BlogInfo> list = blogService.list(title); // ブログサービスからブログリストを取得します。
        model.addAttribute("list", list); // ブログリストをモデルに追加します。
        
        return "/index"; // indexビューを返します。
    }

    // ログインページに対するGETリクエストを処理するメソッド。
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login() {
        return "/login"; // loginビューを返します。
    }

    // 登録ページに対するGETリクエストを処理するメソッド。
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String register() {
        return "/register"; // registerビューを返します。
    }

    // 管理者ページに対するGETリクエストを処理するメソッド。
    @RequestMapping(value="/admin", method = RequestMethod.GET)
    public String admin() {
        if(null == session.getAttribute("userId")) {
            return "login"; // セッションがない場合はログインページにリダイレクトします。
        }
        return "/admin"; // adminビューを返します。
    }

    // ログイン処理を行うPOSTリクエストを処理するメソッド。
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(Model model, String account, String password) {
        int val = userService.loginUser(account, password); // ユーザーサービスを使ってログインを試みます。
        if(val == 0) {
            model.addAttribute("msg", "Password error"); // パスワードエラーの場合はメッセージを設定します。
            return "login"; // ログインビューを返します。
        }
        if(val == -1) {
            model.addAttribute("msg", "Account does not exist"); // アカウントが存在しない場合はメッセージを設定します。
            return "login"; // ログインビューを返します。
        }
        return "admin"; // ログイン成功の場合は管理者ページにリダイレクトします。
    }

    // 登録処理を行うPOSTリクエストを処理するメソッド。
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String register(Model model, String account, String password, String name) {
        int val = userService.registerUser(account, password, name); // ユーザーサービスを使って登録を試みます。
        if(val == 0) {
            model.addAttribute("msg", "register has failed"); // 登録失敗の場合はメッセージを設定します。
            return "register"; // 登録ビューを返します。
        }
        if(val == -1) {
            model.addAttribute("msg", "Account already exists"); // アカウントが既に存在する場合はメッセージを設定します。
            return "register"; // 登録ビューを返します。
        }
        model.addAttribute("msg", "Login success"); // 登録成功の場合はメッセージを設定します。
        return "login"; // ログインビューを返します。
    }

    // ログアウト処理を行うリクエストを処理するメソッド。
    @RequestMapping(value="/logout")
    public String logout() {
        session.invalidate(); // セッションを無効にします。
        return "login"; // ログインビューにリダイレクトします。
    }
}