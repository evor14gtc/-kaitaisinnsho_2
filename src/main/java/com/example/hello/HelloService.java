package com.example.hello;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
//@Autowiredアノテーションを使うための宣言
import org.springframework.stereotype.Service;
//@Serviceアノテーションを使うための宣言

@Service
//このクラスはServiceと宣言
public class HelloService {
//HelloServiceクラスを宣言

    @Autowired
    //HelloRepositoryを注入
    private HelloRepository repository;
    //HelloRepository型のrepository定義

    public Employee getEmployee(String id) {
    //getEmployeeメソッド宣言 引数文字列のid
        Map<String, Object> map = repository.findById(id);
        //findByIdメソッド呼び出してDBから社員情報を取得してmapに代入

        String employeeId = (String) map.get("id");
        //Mapからidのcolumnの値を取り出してemployeeIdに代入
        String name = (String) map.get("name");
        //Mapからnameのcolumnの値を取り出してemployeeNameに代入
        int age = (Integer) map.get("age");
        //Mapからageのcolumnの値を取り出してemployeeAgeに代入

        Employee employee = new Employee();
        //employeeオブジェクト作成
        employee.setEmployeeId(employeeId);
        //employeeにidをセット
        employee.setEmployeeName(name);
        //employeeにnameをセット
        employee.setEmployeeAge(age);
        //employeeにageをセット

        return employee;
        //employeeを返す
    }
}