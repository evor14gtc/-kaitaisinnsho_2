package com.example.controller;

//@Controllerアノテーションを使うための宣言
import org.springframework.stereotype.Controller;
//@GetMappingアノテーションを使うための宣言
import org.springframework.web.bind.annotation.GetMapping;
//@ReqestMappingアノテーションを使うための宣言
import org.springframework.web.bind.annotation.RequestMapping;

//このクラスをControllerにしてDIコンテナに登録
@Controller
//リクエスト/userでこのクラスが動く
@RequestMapping("/user")
//UserListControllerクラス定義
public class UserListController {

	/** ユーザー一覧画面を表示 */
	//Getリクエストの/user/listでこのメソッドが動く
	@GetMapping("/list")
	//getUserListメソッド定義
	public String getUserList() {
		//user/list（ユーザー一覧画面）を表示する
		return "user/list";
	}
}