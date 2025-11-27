package com.example.hello;

import lombok.Data;
//Lombokライブラリの@Dataアノテーションを使うための宣言

@Data
//・getter・setter・toString・hashCode・equalsを自動生成する
public class Employee {
//Employeeクラスを定義
    private String employeeId;
    //社員IDを入れるString型の変数employeeId定義
    private String employeeName;
    //社員名を入れるString型の変数employeeName定義
    private int employeeAge;
    //社員の年齢を入れるint型の変数employeeAge定義
}