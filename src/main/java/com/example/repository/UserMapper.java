package com.example.repository;
import java.util.List;

//@Mapperアノテーションを使うための宣言
import org.apache.ibatis.annotations.Mapper;
//@Paramアノテーションを使うための宣言
import org.springframework.data.repository.query.Param;

import com.example.domain.user.model.MUser;

//このインターフェイスはMyBatisでDBとやりとりする
@Mapper
//UserMapperインターフィス定義
public interface UserMapper {

    /** ユーザー登録 */
	//ユーザー情報を1件DBに登録するメソッド/XMLのSQLとマッピング
    public int insertOne(MUser user);
    
    /**ユーザー取得*/
    //DBからユーザー情報を全件取得して、Listに纏めて返すメソッド/XMLのSQLとマッピング
    public List<MUser> findMany(MUser user);
    
    /**ユーザー取得（１件）*/
    //DBからユーザー情報を1件取得して、MUserに入れて返すメソッド/XMLのSQLとマッピング
    public MUser findOne(String userId);
    
    /** ユーザー更新(1件) */
    //DBのuserIdに一致する1件のユーザー情報のpasswordとuserNameを更新するメソッド/XMLのSQLとマッピング
    public void updateOne(@Param("userId") String userId,
            @Param("password") String password,
            @Param("userName") String userName);

    /** ユーザー削除(1件) */
    //DBのuserIdに一致するユーザー情報を1件削除して、削除できれば1、削除するものがなければ0を返すメソッド/XMLのSQLとマッピング
    public int deleteOne(@Param("userId") String userId);
    
    /** ログインユーザー取得 */
    //DBからuserIdに一致するユーザー情報取得/XMLのSQLとマッピング
    public MUser findLoginUser(String userId);
}