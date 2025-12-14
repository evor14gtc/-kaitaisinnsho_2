package com.example.aspect;

//DataAccessExceptionをインポート
import org.springframework.dao.DataAccessException;
//HttpStatusをインポート
import org.springframework.http.HttpStatus;
//SpringMVCのModelを使うための宣言
import org.springframework.ui.Model;
//@ControllerAdviceアノテーションを使うた目の宣言
import org.springframework.web.bind.annotation.ControllerAdvice;
//@ExceptionHandlerアノテーションを使うた目の宣言
import org.springframework.web.bind.annotation.ExceptionHandler;

//全てのコントローラーで例外が発生したらこのクララスが動く
@ControllerAdvice
//GlobalControllAdviceクラス定義
public class GlobalControllAdvice {

    /** データベース関連の例外処理 */
	//DataAccessExceptionが出た時の例外処理メソッド
    @ExceptionHandler(DataAccessException.class)
    //dataAccessExceptionHandlerメソッド定義
    public String dataAccessExceptionHandler(DataAccessException e, Model model) {

    	//modelに"error"名で空文字を追加
        model.addAttribute("error", "");

        //modelに"message"名で"SignupControllerで例外が発生しました"を追加
        model.addAttribute("message", "DataAccessExceptionが発生しました");

        //modelに"status"名でエラーコード（500）を追加
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);
        //error.htmlを表示する
        return "error";
    }

    /** その他の例外処理 */
    //その他の例外Exceptionが出た時の例外処理メソッド
    @ExceptionHandler(Exception.class)
    //exceptionHandlerメソッド定義
    public String exceptionHandler(Exception e, Model model) {

    	//modelに"error"名で空文字を追加
        model.addAttribute("error", "");

        //modelに"message"名で"SignupControllerで例外が発生しました"を追加
        model.addAttribute("message", "Exceptionが発生しました");

        //modelに"status"名でエラーコード（500）を追加
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);
        //error.htmlを表示する
        return "error";
    }
}