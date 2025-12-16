package com.example.domain.user.service;

import java.util.List;

import com.example.domain.user.model.MUser;
//UserServiceインターフィス定義
public interface UserService {

    /** ユーザー登録 */
	//ユーザー登録の処理をまとめたsignupメソッド宣言
    public void signup(MUser user);
    
    /** ユーザー取得 */
    //ユーザー情報を全件取得して、Listに纏めて返すメソッド宣言
    public List<MUser> getUsers(MUser user);
    
    /** ユーザー取得(1件) */
    //ユーザー情報を1件取得して、MUserに入れて返すメソッド宣言
    public MUser getUserOne(String userId);
    
    /** ユーザー更新(1件) */
    //ユーザー情報を1件更新するメソッド宣言
    public void updateUserOne(String userId,
            String password,
            String userName);

    /** ユーザー削除(1件) */
    //ユーザー情報を1件削除するメソッド宣言
    public void deleteUserOne(String userId);
    
    /**ログインユーザー情報取得*/
    //ログインユーザー情報を取得するメソッド宣言
    public MUser getLoginUser(String userId);
}