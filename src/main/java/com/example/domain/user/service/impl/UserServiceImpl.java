package com.example.domain.user.service.impl;

import java.util.List;

//@Autowiredアノテーションを使うための宣言
import org.springframework.beans.factory.annotation.Autowired;
//@Serviceアノテーションを使うための宣言
import org.springframework.stereotype.Service;
//@Transactionalアノテーションを使うための宣言
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.user.model.MUser;
import com.example.domain.user.service.UserService;
import com.example.repository.UserMapper;

//このクラスはServiceと宣言
@Service
//UserServiceインターフェイスを実装したUserServiceImplクラスを定義
public class UserServiceImpl implements UserService {
	//UserMapperを注入
    @Autowired
    //UserMapper型のmapper定義
    private UserMapper mapper;

    /** ユーザー登録 */
    //オーバーライドする宣言
    @Override
    //UserServiceインターフェイスのsignupメソッドをオーバーライド
    public void signup(MUser user) {
    	//departmentIdを1に設定
        user.setDepartmentId(1); // 部署
        //roleをROLE_GENERALに設定
        user.setRole("ROLE_GENERAL"); // ロール
        //mapperのinsertOneメソッドを使ってユーザー情報を1件DBに登録する
        mapper.insertOne(user);
    }
    
    /** ユーザー取得 */
    //オーバーライドする宣言
    @Override
    //UserServiceインターフェイスのgetUsersメソッドをオーバーライド
    public List<MUser> getUsers(MUser user) {
    	//mapperのfindManyメソッドを使ってユーザー情報を全件取得して返す
        return mapper.findMany(user);
    }
    
    /** ユーザー取得(1件) */
  //オーバーライドする宣言
    @Override
    //UserServiceインターフェイスのgetUserOneメソッドをオーバーライド
    public MUser getUserOne(String userId) {
    	//mapperのfindOneメソッドを使ってユーザー情報を1件取得して返す
        return mapper.findOne(userId);
    }
    
    /** ユーザー更新(1件) */
    //トランザクション実行する/途中でエラー出た時に処理を元に戻す
    @Transactional
    //オーバーライドする宣言
    @Override
    //UserServiceインターフェイスのupdateUserOneメソッドをオーバーライド
    public void updateUserOne(String userId,
            String password,
            String userName) {
    	//mapperのupdateOneメソッドを使ってユーザー情報を更新する
        mapper.updateOne(userId, password, userName);
        
        //わざと例外を発生させる
        //int i = 1/0;
    }

    /** ユーザー削除(1件) */
  //オーバーライドする宣言
    @Override
  //UserServiceインターフェイスのdeleteUserOneメソッドをオーバーライド
    public void deleteUserOne(String userId) {
    	//mapperのdeleteOneメソッドを使ってユーザー情報を削除/削除できれば1、削除するものがなければ0をint型のcountに代入
        int count = mapper.deleteOne(userId);
    }
}