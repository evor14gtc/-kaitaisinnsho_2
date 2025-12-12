package com.example.controller;

//ModelMapperライブラリをインポート
import org.modelmapper.ModelMapper;
//@Autowiredアノテーションを使うための宣言
import org.springframework.beans.factory.annotation.Autowired;
//@Controllerアノテーションを使うための宣言
import org.springframework.stereotype.Controller;
//SpringMVCのModelを使うための宣言
import org.springframework.ui.Model;
//@GetMappingアノテーションを使うための宣言
import org.springframework.web.bind.annotation.GetMapping;
//@PathVariableアノテーションを使うための宣言
import org.springframework.web.bind.annotation.PathVariable;
//@PostMappingアノテーションを使う宣言
import org.springframework.web.bind.annotation.PostMapping;
//@RequestMappingアノテーションを使うための宣言
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.user.model.MUser;
import com.example.domain.user.service.UserService;
import com.example.form.UserDetailForm;

//Lombokライブラリの@Slf4jアノテーションを使うための宣言
import lombok.extern.slf4j.Slf4j;

//このクラスをControllerにしてDIコンテナに登録
@Controller
//リクエスト/userでこのクラスが動く
@RequestMapping("/user")
//ログ出力できるようになる
@Slf4j
public class UserDetailController {
	
	//UserServiceを注入
    @Autowired
    //UserService型のuserService定義
    private UserService userService;
    
    //ModelMapperを注入
    @Autowired
    //ModelMapper型のmodelMapper定義
    private ModelMapper modelMapper;

    /** ユーザー詳細画面を表示 */
    //Getリクエストの/user/detail/ユーザーID（動的URL）でこのメソッドが動く
    @GetMapping("/detail/{userId:.+}")
    //URLからuserIdを受け取りDBから探すgetUserメソッド定義
    public String getUser(UserDetailForm form, Model model, @PathVariable("userId") String userId) {

        // ユーザーを1件取得
    	//getUserOneでユーザー情報1件取得してuserに入れる
        MUser user = userService.getUserOne(userId);
        //ユーザーのパスワードをnullに設定
        user.setPassword(null);

        // MUserをformに変換
        //userの値をそのままformに入れて、DBで扱えるようにしてる
        form = modelMapper.map(user, UserDetailForm.class);
        //userから取得した給料リストをformにセット
        form.setSalaryList(user.getSalaryList());

        // Modelに登録
        //"userDetailForm"の名でmodelに登録
        model.addAttribute("userDetailForm", form);

        // ユーザー詳細画面を表示
        //user/detail.html表示
        return "user/detail";
    }
    
    /** ユーザー更新処理 */
    //name属性がupdateボタンのPostリクエスト/user/detailでこのメソッドが動く
    @PostMapping(value = "/detail", params = "update")
    //form、Modelを受け取るupdateUserメソッド定義
    public String updateUser(UserDetailForm form, Model model) {
    	try {
    		// ユーザーを更新
        	//updateUserOneメソッド呼び出してユーザー情報1件更新
            userService.updateUserOne(form.getUserId(),
                    form.getPassword(),
                    form.getUserName());
        //Exceptionがでたらキャッチ
    	} catch (Exception e) {
    		//ユーザー更新でエラーとスタックトレースを出力
            log.error("ユーザー更新でエラー", e);
        }
        // ユーザー一覧画面にリダイレクト
        // /user/list.htmlにリダイレクト
        return "redirect:/user/list";
    }

    /** ユーザー削除処理 */
    //name属性がdeleteボタンのPostリクエスト/user/detailでこのメソッドが動く
    @PostMapping(value = "/detail", params = "delete")
    //form、Modelを受け取るdeleteUserメソッド定義
    public String deleteUser(UserDetailForm form, Model model) {
        // ユーザーを削除
    	//deleteUserOneメソッド呼び出してユーザー情報1件削除
        userService.deleteUserOne(form.getUserId());

        // ユーザー一覧画面にリダイレクト
        // /user/list.htmlにリダイレクト
        return "redirect:/user/list";
    }
}