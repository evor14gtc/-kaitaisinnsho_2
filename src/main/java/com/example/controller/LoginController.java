package com.example.controller;

import org.springframework.stereotype.Controller;
//@Controllerアノテーションを使うための宣言
import org.springframework.web.bind.annotation.GetMapping;
//@GetMappingアノテーションを使うための宣言

@Controller
//このクラスをControllerにしてDIコンテナに登録
public class LoginController {
//LoginControllerクラス定義

    @GetMapping("/login")
    //リクエスト/loginでこのメソッドが動く
    public String getLogin() {
    //文字列を返すgetLoginメソッド定義
        return "login/login";
        //login/loginを表示する
    }
}