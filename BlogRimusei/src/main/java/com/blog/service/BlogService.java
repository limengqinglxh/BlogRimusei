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

@Service // このクラスがサービス層のコンポーネントであることを示すアノテーションです。
public class BlogService {

    @Autowired // Springの自動依存性注入を使用してリポジトリをインジェクトします。
    private BlogRepository blogRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    HttpSession session; // HTTPセッションを扱うためのオブジェクト。

    // ブログを追加するメソッドです。
    public int add(BlogInfo blogInfo) {
        Assert.notNull(blogInfo, "blogInfo must not be null!"); // blogInfoがnullでないことを確認します。
        blogInfo.setBlogtime(new Date()); // 現在の日時を設定します。
        Long userId = Long.valueOf(session.getAttribute("userId").toString());
        blogInfo.setBloguser(userId); // セッションからユーザーIDを取得して設定します。
        BlogInfo save = blogRepository.save(blogInfo);
        if(null == save) {
            return 0; // 保存に失敗した場合は0を返します。
        }
        return 1; // 保存に成功した場合は1を返します。
    }
    
    // ブログを編集するメソッドです。
    public int edit(BlogInfo blogInfo) {
        Assert.notNull(blogInfo, "blogInfo must not be null!");
        BlogInfo save = blogRepository.save(blogInfo);
        if(null == save) {
            return 0;
        }
        return 1;
    }
    
    // ブログを削除するメソッドです。
    public int del(Long id) {
        try {
            blogRepository.deleteById(id);
            return 1; // 削除に成功した場合は1を返します。
        } catch (Exception e) {
            return 0; // 削除に失敗した場合は0を返します。
        }
    }
    
    // ブログのリストを取得するメソッドです。
    public List<BlogInfo> list(String title) {
        List<BlogInfo> list = new ArrayList<BlogInfo>();
        if(null == session.getAttribute("userId")) {
            if(title.equals("")) {
                return blogRepository.findAll(); // すべてのブログを返します。
            }
            return blogRepository.findAllByTitle3(title); // タイトルに基づいてブログを検索します。
        }
        Long userId = Long.valueOf(session.getAttribute("userId").toString());
        if(title.equals("")) {
            list = blogRepository.findAllByTitle(userId);
        }else {
            list = blogRepository.findAllByTitle2(userId, title);
        }
        return list;
    }
    
    // ブログの詳細を取得するメソッドです。
    public BlogInfo detail(Long id) {
        Optional<BlogInfo> info = blogRepository.findById(id);
        return info.get();
    }
    
    // BlogInfoエンティティをBlogInfoVoに変換するヘルパーメソッドです。
    private BlogInfoVo info2Vo(BlogInfo info) {
        BlogInfoVo vo = new BlogInfoVo();
        vo.setBlogid(info.getBlogid());
        vo.setBlogtitle(info.getBlogtitle());
        vo.setBlogtag(info.getBlogtag());
        vo.setBlogdesc(info.getBlogdesc());
        vo.setBloguser(info.getBloguser());
        Optional<UserInfo> userinfo = userRepository.findById(info.getBloguser());
        if(null != userinfo.get()) {
            vo.setUsername(userinfo.get().getName()); // ユーザー名を設定します。
        }
        return vo;
    }
}