//データベースのテーブルに対応するユーザーエンティティクラス
package com.example.domain.user.model;

import java.util.Date;
import java.util.List;

//Lombokライブラリの@Dataアノテーションを使うための宣言
import lombok.Data;

//getter・setter・toString・hashCode・equalsを自動生成する
@Data
//MUserクラス定義
public class MUser {
	//String型の変数userId定義
    private String userId;
    //String型の変数password定義
    private String password;
    //String型の変数userName定義
    private String userName;
    //Date型の変数birthday定義
    private Date birthday;
    //Integer型の変数age定義
    private Integer age;
    //Integer型の変数gender定義
    private Integer gender;
    //Integer型の変数departmentId定義
    private Integer departmentId;
    //String型の変数role定義
    private String role;
    //Department型の変数department定義
    private Department department;
    //Salary型のリストsalaryList定義
    private List<Salary> salaryList;
}