package com.example.form;

//@GroupSequenceアノテーションを使うための宣言
import javax.validation.GroupSequence;

//ValidGroup1→ValidGroup2の順番でバリデーション実施する設定
@GroupSequence({ ValidGroup1.class, ValidGroup2.class })
//インターフェイスGroupOrderを定義
public interface GroupOrder {

}