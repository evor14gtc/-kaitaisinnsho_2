package com.example.controller;

//@Controllerアノテーションを使うための宣言
import org.springframework.stereotype.Controller;
//@PostMappingアノテーションを使うための宣言
import org.springframework.web.bind.annotation.PostMapping;

//Lombokライブラリの@Slf4jアノテーションを使うための宣言
import lombok.extern.slf4j.Slf4j;

//このクラスをControllerにしてDIコンテナに登録
@Controller
//ログ出力できるようになる
@Slf4j
//LogoutControllerクラス定義
public class LogoutController {
    /** ログイン画面にリダイレクト */
	//Postリクエスト/logoutでこのメソッドが動く
    @PostMapping("/logout")
    //postLogoutメソッド定義
    public String postLogout() {
    	//ログにログアウトと表示する
        log.info("ログアウト");
        // /login（ログイン画面）にリダイレクト
        return "redirect:/login";
    }
}