//バインド用クラス
package com.example.form;

import java.util.Date;

//@Emailアノテーションを使うための宣言
import javax.validation.constraints.Email;
//@Maxアノテーションを使うための宣言
import javax.validation.constraints.Max;
//@Minアノテーションを使うための宣言
import javax.validation.constraints.Min;
//@NotBlankアノテーションを使うための宣言
import javax.validation.constraints.NotBlank;
//@NotNullアノテーションを使うための宣言
import javax.validation.constraints.NotNull;
//@Patternアノテーションを使うための宣言
import javax.validation.constraints.Pattern;

//@Lengthアノテーションを使うための宣言
import org.hibernate.validator.constraints.Length;
//@DateTimeFormatアノテーションを使うための宣言
import org.springframework.format.annotation.DateTimeFormat;

//Lombokライブラリの@Dataアノテーションを使うための宣言
import lombok.Data;

//getter・setter・toString・hashCode・equalsを自動生成する
@Data
//SignupFormクラスを定義
public class SignupForm {
	
	//文字列がnull、空文字、空白じゃないかチェックする/ValidGroup1でバリデーション実行する
	@NotBlank(groups = ValidGroup1.class)
	//文字列がメアド形式かチェックする/ValidGroup2でバリデーション実行する
	@Email(groups = ValidGroup2.class)
	//privateの文字列変数userIdを宣言
	private String userId;
	
	//文字列がnull、空文字、空白じゃないかチェックする/ValidGroup1でバリデーション実行する
	@NotBlank(groups = ValidGroup1.class)
	//文字列の長さが4文字以上、100文字以下かチェックする/ValidGroup2でバリデーション実行する
	@Length(min = 4,max = 100, groups = ValidGroup2.class)
	//^[a-zA-Z0-9]+$の正規表現に一致するかチェックする/ValidGroup2でバリデーション実行する
	@Pattern(regexp = "^[a-zA-Z0-9]+$", groups = ValidGroup2.class)
	//privateの文字列変数passwordを宣言
	private String password;
	
	//文字列がnull、空文字、空白じゃないかチェックする/ValidGroup1でバリデーション実行する
	@NotBlank(groups = ValidGroup1.class)
	//privateの文字列変数userNameを宣言
	private String userName;
	
	//Date型にバインドする時に使う/yyyy/MM/ddのフォーマットで入力されたらバインド
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	//nullじゃないかチェックする/ValidGroup1でバリデーション実行する
	@NotNull(groups = ValidGroup1.class)
	//privateのDate型変数birthdayを宣言
	private Date birthday;
	
	//値が20以上かチェックする/ValidGroup2でバリデーション実行する
	 @Min(value = 20, groups = ValidGroup2.class)
	//値が100以下かチェックする/ValidGroup2でバリデーション実行する
	 @Max(value = 100, groups = ValidGroup2.class)
	//privateの整数変数ageを宣言
	private Integer age;
	
	//nullじゃないかチェックする/ValidGroup1でバリデーション実行する
	@NotNull(groups = ValidGroup1.class)
	//privateの整数変数genderを宣言
	private Integer gender;
}