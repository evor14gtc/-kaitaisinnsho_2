package com.example.domain.user.service.impl;

import java.util.ArrayList;
import java.util.List;

//@Autowiredアノテーションを使う宣言
import org.springframework.beans.factory.annotation.Autowired;
//ユーザーが持つ権限を表すインターフェイス
import org.springframework.security.core.GrantedAuthority;
//権限を文字列で持つための実装クラス
import org.springframework.security.core.authority.SimpleGrantedAuthority;
//Spring Security が用意しているログインユーザーの完成形クラス
import org.springframework.security.core.userdetails.User;
//ログインユーザー情報はこの形で渡してね、というインターフェイス
import org.springframework.security.core.userdetails.UserDetails;
//ログイン時にユーザー情報を取得する処理を書くためのインターフェイス
import org.springframework.security.core.userdetails.UserDetailsService;
//UsernameNotFoundExceptionをインポート
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//@Serviceアノテーションを使う宣言
import org.springframework.stereotype.Service;

import com.example.domain.user.model.MUser;
import com.example.domain.user.service.UserService;

//このクラスをサービスとして使う
@Service
//UserDetailsServiceを実装したUserDetailsServiceImplクラスを定義
public class UserDetailsServiceImpl implements UserDetailsService {
	
	//UserServiceを注入
    @Autowired
    //UserService型の変数service定義
    private UserService service;
    
    //オーバーライドする宣言
    @Override
    //UserDetailsServiceのloadUserByUsernameメソッドをオーバーライド/UsernameNotFoundExceptionをスロー
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // ユーザー情報取得
    	//userServiceのgetLoginUserでログインユーザー情報取得して変数loginUserに代入
        MUser loginUser = service.getLoginUser(username);

        // ユーザーが存在しない場合
        //ログインユーザーが存在しなければUsernameNotFoundExceptionをスロー
        if(loginUser == null) {
            throw new UsernameNotFoundException("user not found");
        }

        // 権限List作成
        //ユーザーの権限を取得してauthorityに代入
        GrantedAuthority authority = new SimpleGrantedAuthority(loginUser.getRole());
        //GrantedAuthority型のauthoritiesリストを作成
        List<GrantedAuthority> authorities = new ArrayList<>();
        //リストにユーザーの権限を入れる
        authorities.add(authority);

        // UserDetails生成
        //ユーザーID（username）、パスワード、権限リストをuserDetailsに代入
        UserDetails userDetails = (UserDetails) new User(loginUser.getUserId(), loginUser.getPassword(), authorities);
        //UserDetailsを返す
        return userDetails;
    }
}