package com.example.hello; 

import org.springframework.beans.factory.annotation.Autowired;
//@Autowiredアノテーションを使うための宣言
import org.springframework.stereotype.Controller;
//@Controllerアノテーションを使うための宣言
import org.springframework.ui.Model;
//SpringMVCのModelを使うための宣言
import org.springframework.web.bind.annotation.GetMapping;
//@GetMappingアノテーションを使うための宣言
import org.springframework.web.bind.annotation.PostMapping;
//@PostMappingアノテーションを使うための宣言
import org.springframework.web.bind.annotation.RequestParam;
//@RequestParamアノテーションを使うための宣言

@Controller 
//このクラスをコントローラーと宣言
public class HelloController {
//HelloControllerクラスを定義
	
	@Autowired
	//HelloServiceを注入
    private HelloService service;
	//HelloService型の変数service定義

    @GetMapping("/hello") 
    //リクエスト/helloでこのメソッドが動く
    public String getHello() { 
    //getHelloメソッド定義
        return "hello";
        //hello.htmlを表示する
    }
    
    @PostMapping("/hello")
    //リクエスト/helloでこのメソッドが動く
    public String postRequest(@RequestParam("text1") String str, Model model) {
    //画面で入力されたtext1の値をstrとして受け取る

        model.addAttribute("sample", str);
        //受け取った文字列のstrを"sample"名でModelに登録

        return "hello/response";
        //hello/response.htmlを表示する
    }
    
    @PostMapping("/hello/db")
    //リクエスト/hello/dbでこのメソッドが動く
    public String postDbRequest(@RequestParam("text2") String id, Model model) {
    //画面で入力されたtext2の値をidとして受け取る

        Employee employee = service.getEmployee(id);
        //idを使ってDBから社員情報を取得して変数employeeに代入
        
        model.addAttribute("employee", employee);
        //受け取った社員情報を"employee"名でModelに登録

        return "hello/db";
        //hello/db.htmlを表示する
    }
    
    
    
}