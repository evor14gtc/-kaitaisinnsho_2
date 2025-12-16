package com.example.controller;

//@Controller;アノテーションを使う宣言
import org.springframework.stereotype.Controller;
//@GetMappingアノテーションを使う宣言
import org.springframework.web.bind.annotation.GetMapping;

//このクラスをControllerにしてDIコンテナに登録
@Controller
//AdminControllerクラス定義
public class AdminController {

    /** アドミン権限専用画面に遷移 */
	//Getリクエスト/adminでこのメソッドが動く
    @GetMapping("/admin")
    //getAdminメソッド定義
    public String getAdmin() {
    	//アドミン権限専用画面を表示
        return "admin/admin";
    }
}