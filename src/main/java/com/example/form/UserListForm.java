package com.example.form;

//Lombokライブラリの@Dataアノテーションを使うための宣言
import lombok.Data;

//getter・setter・toString・hashCode・equalsを自動生成する
@Data
//UserListFormクラス定義
public class UserListForm {
	//String型の変数userId定義
    private String userId;
    //String型の変数userName定義
    private String userName;
}