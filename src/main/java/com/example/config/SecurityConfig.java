//セキュリティ設定用クラス
package com.example.config;

//@Autowiredアノテーションを使う宣言
import org.springframework.beans.factory.annotation.Autowired;
//@Beanアノテーションを使うための宣言
import org.springframework.context.annotation.Bean;
//@Configurationアノテーションを使うための宣言
import org.springframework.context.annotation.Configuration;
//インメモリ認証をするための設定を行う
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//Webリクエストに対する認証・認可などのセキュリティ設定を行う
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//セキュリティフィルターを適用しないURL（CSSや画像など）の設定を行う
import org.springframework.security.config.annotation.web.builders.WebSecurity;
//@EnableWebSecurityアノテーションを使うための宣言
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//Spring Security設定用クラス
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
////ログインユーザー情報はこの形で渡してね、というインターフェイス
import org.springframework.security.core.userdetails.UserDetailsService;
//パスワードをハッシュ化する具体的な実装クラス
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//パスワード暗号化のインターフェース
import org.springframework.security.crypto.password.PasswordEncoder;
//GET /logoutリクエストをログアウト処理として扱うための設定
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//SpringSecurityの機能を有効化する
@EnableWebSecurity
//設定専用クラスになる
@Configuration
//WebSecurityConfigurerAdapterを継承したSecurityConfigクラス定義
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	//UserDetailsServiceを注入
	@Autowired
	//UserDetailsService型のuserDetailsService定義
    private UserDetailsService userDetailsService;
	
	//DIコンテナに登録
	 @Bean
	  //パスワードをどう暗号化するかを表す型で返す
	    public PasswordEncoder passwordEncoder() {
		 //BCryptでパスワードを暗号化するインスタンスを作って返す
	        return new BCryptPasswordEncoder();
	    }

    /** セキュリティの対象外を設定 */
	//オーバーライドする宣言
    @Override
    //configureメソット定義/Exceptionをスロー
    public void configure(WebSecurity web) throws Exception {
        // セキュリティを適用しない
    	//"/webjars/**"、"/css/**"、"/js/**"、"/h2-console/**"はセキュリティ対象外に設定
        web
            .ignoring()
                .antMatchers("/webjars/**")
                .antMatchers("/css/**")
                .antMatchers("/js/**")
                .antMatchers("/h2-console/**");
    }

    /** セキュリティの各種設定 */
    //オーバーライドする宣言
    @Override
    //configureメソッド定義/Exceptionをスロー
    protected void configure(HttpSecurity http) throws Exception {

        // ログイン不要ページの設定
    	//ログイン画面と要録画面は直リンクOK、アドミン画面はROLE_ADMINのみアクセス可、それ以外NGの設定
        http
            .authorizeRequests()
                .antMatchers("/login").permitAll() //直リンクOK
                .antMatchers("/user/signup").permitAll() //直リンクOK
                .antMatchers("/admin").hasAuthority("ROLE_ADMIN")//権限制御
                .anyRequest().authenticated(); // それ以外は直リンクNG
        
        // ログイン処理
        //フォーム認証によるログイン機能を有効にする
        http
            .formLogin()
                //ログイン処理のパス指定/login.htmlのth:actionと一致
                .loginProcessingUrl("/login") // ログイン処理のパス
                //ログインページリンク先/login.controllerのgetMaiingと一致
                .loginPage("/login") // ログインページの指定
                //// ログイン失敗時の遷移先
                .failureUrl("/login?error") // ログイン失敗時の遷移先
                //ユーザーID入力欄のname属性
                .usernameParameter("userId") // ログインページのユーザーID
                //パスワード入力欄のname属性
                .passwordParameter("password") // ログインページのパスワード
                //第一引数にログイン成功時の遷移先、第二引数をtrueにすると強制遷移
                .defaultSuccessUrl("/user/list", true); // 成功後の遷移先
        
        // ログアウト処理
        //ログアウト機能を有効にする
        http
            .logout()
                // GETリクエスト/logoutをログアウト処理に割り当てる
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                //ログアウトのリクエスト先パス
                .logoutUrl("/logout")
                //ログアウト成功時の遷移先
                .logoutSuccessUrl("/login?logout");


        // CSRF対策を無効に設定（一時的）
        //http.csrf().disable();
    }
    /** 認証の設定 */
    //オーバーライドする宣言
    @Override
    //configureメソッド定義/Exceptionをスロー
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
    	//passwordEncoderメソッドの戻り値をencoderに代入
    	PasswordEncoder encoder = passwordEncoder();
		/*
		// インメモリ認証
		//DB使わず仮ログインする機能を作成/メモリ上に保持で再起動で消える
		auth
		    .inMemoryAuthentication()
		        //ユーザーID＝user、パスワード＝user、権限＝GENERALを追加
		        .withUser("user") // userを追加
		            //パスワード"user"をハッシュ化してる
		            .password(encoder.encode("user"))
		            .roles("GENERAL")
		        .and()
		        //ユーザーID＝admin、パスワード＝admin、権限＝ADMINを追加
		        .withUser("admin") // adminを追加
		             //パスワード"admin"をハッシュ化してる
		            .password(encoder.encode("admin"))
		            .roles("ADMIN");
		            */
    	
    	// ユーザーデータ認証
    	//
        auth
            //ログイン時にDBからユーザーを取得する処理をSpringSecurityに使わせる設定
            .userDetailsService(userDetailsService)
            //パスワードをハッシュ化
            .passwordEncoder(encoder);
    }
}