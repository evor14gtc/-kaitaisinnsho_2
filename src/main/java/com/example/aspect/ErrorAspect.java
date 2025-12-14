package com.example.aspect;


//@AfterThrowingアノテーションを使う宣言
import org.aspectj.lang.annotation.AfterThrowing;
//@Aspectアノテーションを使う宣言
import org.aspectj.lang.annotation.Aspect;
//DataAccessExceptionをインポート
import org.springframework.dao.DataAccessException;
//@Componentアノテーションを使うための宣言
import org.springframework.stereotype.Component;

//Lombokライブラリの@Slf4jアノテーションを使うための宣言
import lombok.extern.slf4j.Slf4j;

//このクラスはAOP用クラスになる
@Aspect
//このクラスをBeanに登録
@Component
//ログ出力できるようになる
@Slf4j
//ErrorAspectクラス定義
public class ErrorAspect {
	//Controller、Service、Repositoryの全メソッドでDataAccessExceptionが発生したらexで受け取る
    @AfterThrowing(value = "execution(* *..*..*(..)) &&"
            + "(bean(*Controller) || bean(*Service) || bean(*Repository))",
            throwing = "ex")
    //throwingNullメソッド定義
    public void throwingNull(DataAccessException ex) {
        // 例外処理の内容（ログ出力）
        log.error("DataAccessExceptionが発生しました");
    }
}