package com.example.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
//Autowiredノテーションを使うための宣言
import org.springframework.beans.factory.annotation.Autowired;
//@Controllerアノテーションを使うための宣言
import org.springframework.stereotype.Controller;
//SpringMVCのModelを使うための宣言
import org.springframework.ui.Model;
//@GetMappingアノテーションを使うための宣言
import org.springframework.web.bind.annotation.GetMapping;
//@ModelAttributeアノテーションを使うための宣言
import org.springframework.web.bind.annotation.ModelAttribute;
//@PostMappingアノテーションを使うための宣言
import org.springframework.web.bind.annotation.PostMapping;
//@ReqestMappingアノテーションを使うための宣言
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.MUser;
import com.example.domain.user.service.UserService;
import com.example.form.UserListForm;

//このクラスをControllerにしてDIコンテナに登録
@Controller
//リクエスト/userでこのクラスが動く
@RequestMapping("/user")
//UserListControllerクラス定義
public class UserListController {
	  //UserServiceを注入
	  @Autowired
	    //UserService型のuserService宣言
	    private UserService userService;
	  
	  //ModelMapperを注入
	  @Autowired
	  //ModelMapper型のmodelMapper宣言
	  private ModelMapper modelMapper;

	/** ユーザー一覧画面を表示 */
	//Getリクエストの/user/listでこのメソッドが動く
	@GetMapping("/list")
	//getUserListメソッド定義/ formをUserListForm名でModel登録
	public String getUserList(@ModelAttribute UserListForm form, Model model) {
		//formの中身をそのままuserに入れて、DBに扱えるようにしてる
        MUser user = modelMapper.map(form, MUser.class);
		//userServiceのgetUsersメソッドを使ってユーザー情報を全件取得してuserListに代入
		 List<MUser> userList = userService.getUsers(user);
		 //受け取ったユーザー情報を"userList"の名でmodelに登録
		 model.addAttribute("userList", userList);
		//user/list（ユーザー一覧画面）を表示する
		return "user/list";
	}
	
	/** ユーザー検索処理 */
	//Postリクエスト/user/listでこのメソッドが動く
    @PostMapping("/list")
    //PostUserListメソッド定義/ formをUserListForm名でModelに登録
    public String postUserList(@ModelAttribute UserListForm form, Model model) {
    	
    	//formの中身をそのままuserに入れて、DBに扱えるようにしてる
        MUser user = modelMapper.map(form, MUser.class);

        //userServiceのgetUsersメソッドを使ってユーザー情報を全件取得してuserListに代入
        List<MUser> userList = userService.getUsers(user);

        //受け取ったユーザー情報を"userList"の名でmodelに登録
        model.addAttribute("userList", userList);

        //user/list（ユーザー一覧画面）を表示する
        return "user/list";
    }
}