//データベースのテーブルに対応する部署エンティティクラス
package com.example.domain.user.model;

//Lombokライブラリの@Dataアノテーションを使うための宣言
import lombok.Data;

//getter・setter・toString・hashCode・equalsを自動生成する
@Data
//Departmentクラス定義
public class Department {
	//Integer型の変数departmentId定義
    private Integer departmentId;
    //String型の変数departmentName定義
    private String departmentName;
}