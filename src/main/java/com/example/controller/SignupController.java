package com.example.controller;

import java.util.Locale;
import java.util.Map;

//@Autowiredアノテーションを使うための宣言
import org.springframework.beans.factory.annotation.Autowired;
//@Controllerアノテーションを使うための宣言
import org.springframework.stereotype.Controller;
//SpringMVCのModelを使うための宣言
import org.springframework.ui.Model;
//バインドのエラー情報を受け取るBindingResultを使うための宣言
import org.springframework.validation.BindingResult;
//@Validatedを使うための宣言
import org.springframework.validation.annotation.Validated;
//@GetMappingアノテーションを使うための宣言
import org.springframework.web.bind.annotation.GetMapping;
//ModelAttributeアノテーションを使うための宣言
import org.springframework.web.bind.annotation.ModelAttribute;
//@PostMappingアノテーションを使うための宣言
import org.springframework.web.bind.annotation.PostMapping;
//@RequestMappingアノテーションを使うための宣言
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.application.service.UserApplicationService;
import com.example.form.GroupOrder;
import com.example.form.SignupForm;

//Lombokライブラリの@Slf4jアノテーションを使うための宣言
import lombok.extern.slf4j.Slf4j;

//このクラスをControllerにしてDIコンテナに登録
@Controller
//リクエスト/userでこのクラスが動く
@RequestMapping("/user")
//ログ出力できるようになる
@Slf4j
//SignupControllerクラス定義
public class SignupController {

	//@UserApplicationServiceを注入
	@Autowired
	//UserApplicationService型のuserApplicationService定義
	private UserApplicationService userApplicationService;

	//リクエスト/signupでこのメソッドが動く
	@GetMapping("/signup")
	//引数でmodelを受け取る、formをSignupForm名で自動でModelに登録、ビュー画面を返すgetSignupメソッド定義
	public String getSignup(Model model, Locale locale,
			@ModelAttribute SignupForm form) {
		//serviceから性別を取得してgenderMapへ代入
		Map<String, Integer> genderMap = userApplicationService.getGenderMap();
		//受け取った性別を"genderMap"名でModelに登録
		model.addAttribute("genderMap", genderMap);
		//user/signupを表示する
		return "user/signup";
	}

	//リクエスト/signupでこのメソッドが動く
	@PostMapping("/signup")
	//ModelとLocaleを受け取り、formをSignupForm名で自動でModelに登録、バインド結果を受け取って実行する、バリデーションの順番を反映
	public String postSignup(Model model, Locale locale,
			@ModelAttribute @Validated(GroupOrder.class) SignupForm form, BindingResult bindingResult) {
		//bindingResultで入力エラーがあるか調べる。trueの場合はバインドエラーかバリデーションエラーが発生してる
		if (bindingResult.hasErrors()) {
			//エラーがあればユーザー登録画面に戻る
			return getSignup(model, locale, form);
		}
		//formのinfoログを出力する
		log.info(form.toString());
		///loginにリダイレクトして表示する
		return "redirect:/login";
	}
}
