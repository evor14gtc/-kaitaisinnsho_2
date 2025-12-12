package com.example.config;

//ModelMapperライブラリをインポート
import org.modelmapper.ModelMapper;
//@Beanアノテーションを使うための宣言
import org.springframework.context.annotation.Bean;
//@Configurationアノテーションを使うための宣言
import org.springframework.context.annotation.Configuration;

//このクラスは設定用のクラス宣言
@Configuration
//JavaConfigクラス定義
public class JavaConfig {
	//このメソッドの戻り値をDIに登録
	@Bean
	//メソッドmodelMapper定義
	public ModelMapper modelMapper() {
		//ModelMapperのインスタンスを生成して返す
		return new ModelMapper();
	}
}