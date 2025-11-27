CREATE TABLE IF NOT EXISTS employee (
	--tableが無ければ作る。あるなら何もしない
  id VARCHAR(50) PRIMARY KEY,
  --社員ID 最大50文字 文字列
  name VARCHAR(50),
  --社員名 最大50文字 文字列
  age INT
  --年齢　整数
);


