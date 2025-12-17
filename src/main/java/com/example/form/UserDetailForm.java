//ユーザー詳細画面フォームクラス
package com.example.form;

import java.util.Date;
import java.util.List;

import com.example.domain.user.model.Department;
import com.example.domain.user.model.Salary;

//lombokライブラリの@Dataアノテーションを使うための宣言
import lombok.Data;
//getter・setter・toString・hashCode・equalsを自動生成する
@Data
//UserDetailFormクラス定義
public class UserDetailForm {
	//String型のuserId定義
    private String userId;
    //String型のpasssword定義
    private String password;
    //String型のuserName定義
    private String userName;
    //Date型のbirthday定義
    private Date birthday;
    //Integer型のage定義
    private Integer age;
    //Integer型のgender定義
    private Integer gender;
    //Department型の変数department定義
    private Department department;
    //Salary型のリストsalaryList定義
    private List<Salary> salaryList;
}