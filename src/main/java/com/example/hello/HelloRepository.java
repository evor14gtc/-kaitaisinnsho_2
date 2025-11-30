package com.example.hello;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
//@Autowiredアノテーションを使うための宣言
import org.springframework.jdbc.core.JdbcTemplate;
//JdbcTemplateクラスを使うための宣言
import org.springframework.stereotype.Repository;
//@Repositoryアノテーションを使うための宣言

@Repository
//このクラスはリポジトリーと宣言 データベース関連を処理するクラス
public class HelloRepository {
//HelloRepositoryクラスを定義

    @Autowired
    //JdbcTemplateを注入
    private JdbcTemplate jdbcTemplate;
    //JdbcTemplate型のjdbcTemplate定義

    public Map<String, Object> findById(String id) {
    //findByIdメソッドを定義 引数のidで社員情報を取得する

        String query = "SELECT *"
                + " FROM employee"
                + " WHERE id=?";
        //employeeテーブルからid？のデータを取得

        Map<String, Object> employee = jdbcTemplate.queryForMap(query, id);
        //SQLを実行して結果をemployeeに入れる

        return employee;
        //employeeを返す
    }
}


