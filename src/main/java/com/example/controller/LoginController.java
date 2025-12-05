package com.example.controller;

//@Controllerアノテーションを使うための宣言
import org.springframework.stereotype.Controller;
//@GetMappingアノテーションを使うための宣言
import org.springframework.web.bind.annotation.GetMapping;
//@PostMappingアノテーションを使うための宣言
import org.springframework.web.bind.annotation.PostMapping;

//このクラスをControllerにしてDIコンテナに登録
@Controller
//LoginControllerクラス定義
public class LoginController {
	
	/** ログイン画面を表示 */
	//Getリクエスト/loginでこのメソッドが動く
    @GetMapping("/login")
  //文字列を返すgetLoginメソッド定義
    public String getLogin() {
    	//login/loginを表示する
        return "login/login";     
    }
    
    /** ユーザー一覧画面にリダイレクト */
    //Postリクエスト/loginでこのメソッドが動く
    @PostMapping("/login")
    //PostLoginメソッド定義
    public String postLogin() {
    	///user/list（ユーザー一覧画面）にリダイレクト
        return "redirect:/user/list";
    }
}