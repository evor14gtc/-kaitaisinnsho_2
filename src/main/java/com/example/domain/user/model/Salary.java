//データベースのテーブルに対応する給料エンティティクラス
package com.example.domain.user.model;

//Lombokライブラリの@Dataアノテーションを使うための宣言
import lombok.Data;

//getter・setter・toString・hashCode・equalsを自動生成する
@Data
//Salaryクラス定義
public class Salary {
	//String型の変数userId定義
    private String userId;
    //String型の変数yearMonth定義
    private String yearMonth;
    //Integer型の変数salary定義
    private Integer salary;
}