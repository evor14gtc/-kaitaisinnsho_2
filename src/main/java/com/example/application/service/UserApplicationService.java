package com.example.application.service;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

// @Autowiredアノテーションを使うための宣言
import org.springframework.beans.factory.annotation.Autowired;
// MessageSourceを使うための宣言
import org.springframework.context.MessageSource;
// @Serviceアノテーションを使うための宣言
import org.springframework.stereotype.Service;

//このクラスをserviceにしてDIコンテナに登録
@Service
// UserApplicationServiceクラス定義
public class UserApplicationService {
	// MessageSourceを注入
	@Autowired
	// MessageSource型のmessageSourceを定義
	private MessageSource messageSource;

	// キー=文字列、値=整数のMapを返すgetGenderMapメソッド定義
	public Map<String, Integer> getGenderMap() {

		// LinkedHashMapクラスのインスタンス生成をしてgenderMapに代入
		Map<String, Integer> genderMap = new LinkedHashMap<>();
		//message.propertiesから、maleの値「男性」を取得して変数maleに代入
		String male = messageSource.getMessage("male", null, Locale.JAPAN);
		//message.propertiesから、femaleの値「女性」を取得して変数femaleに代入
        String female = messageSource.getMessage("female", null, Locale.JAPAN);

		// キー=male、値=1をマップに追加
		genderMap.put(male, 1);

		// キー=female、値=2をマップに追加
		genderMap.put(female, 2);

		// genderMapを返す
		return genderMap;
	}
}