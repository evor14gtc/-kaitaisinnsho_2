--employeeテーブルがなければ作る。あるなら何もしない
CREATE TABLE IF NOT EXISTS employee (
	--column名がid/最大50文字の文字列/PRIMARY KEYに設定
  id VARCHAR(50) PRIMARY KEY,
  --column名がname/最大50文字の文字列
  name VARCHAR(50),
  --column名がage/整数
  age INT
);
  
/* ユーザーマスタ */
--m_userテーブルがなければ作る。あるなら何もしない
CREATE TABLE IF NOT EXISTS m_user (
	--column名がuser_id/最大50文字の文字列/PRIMARY KEYに設定
    user_id VARCHAR(50) PRIMARY KEY
  --column名がpassword/最大100文字の文字列
  , password VARCHAR(100)
  --column名がuser_name/最大50文字の文字列
  , user_name VARCHAR(50)
  --column名がbirthday/date型
  , birthday DATE
  --column名がage/整数
  , age INT
  --column名がgender/整数
  , gender INT
  --column名がdepartment_id/整数
  , department_id INT
  --column名がrole/最大50文字の文字列
  , role VARCHAR(50)
);

/* 部署マスタ */
--m_departmentテーブルがなければ作る。あるなら何もしない
CREATE TABLE IF NOT EXISTS m_department (
	--column名がdepartment_id/整数/PRIMARY KEYに設定
    department_id INT PRIMARY KEY
    --column名がdepartment_name/最大50文字の文字列
  , department_name VARCHAR(50)
);

/* 給料テーブル */
--t_salaryテーブルがなければ作る。あるなら何もしない
CREATE TABLE IF NOT EXISTS t_salary (
	--column名がuser_id/最大50文字の文字列
    user_id VARCHAR(50)
    --column名がyear_month/最大50文字の文字列
  , year_month VARCHAR(50)
  --column名がsalary/整数
  , salary INT
  --user_idとyear_monthをセットでPRIMARY KEYに設定
  , PRIMARY KEY(user_id, year_month)
);