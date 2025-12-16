--employeeテーブルにid,name,ageのレコードを追加する宣言
INSERT INTO employee (id, name, age)
--id = 1,name = tom,age = 30に設定して追加
VALUES('1', 'Tom', 30);

/* ユーザーマスタ */
--m_userテーブルに（）の中の値をレコードを追加する宣言
INSERT INTO m_user (
    user_id
  , password
  , user_name
  , birthday
  , age
  , gender
  , department_id
  , role
  
) VALUES
--この値でレコードを追加
('system@co.jp', '$2a$10$szasqG5hXRwM6YmZ40nZSeQqdse34aPoxOKsMV1goYTWhQJg/lbuW', 'システム管理者', '2000-01-01', 21, 1, 1, 'ROLE_ADMIN')
--この値でレコードを追加
, ('user@co.jp', '$2a$10$szasqG5hXRwM6YmZ40nZSeQqdse34aPoxOKsMV1goYTWhQJg/lbuW', 'ユーザー1', '2000-01-01', 21, 2, 2, 'ROLE_GENERAL')
;

/* 部署マスタ */
--m_departmentテーブルに（）の中のレコードを追加する宣言
INSERT INTO m_department (
    department_id
  , department_name
  
) VALUES
--この値でレコードを追加
(1, 'システム管理部')
--この値でレコードを追加
, (2, '営業部')
;

/* 給料テーブル */
--t_salaryテーブルに（）の中のレコードを追加する宣言
INSERT INTO t_salary (
    user_id
  , year_month
  , salary
  
) VALUES
--この値でレコードを追加
('user@co.jp', '2020/11', 280000)
--この値でレコードを追加
, ('user@co.jp', '2020/12', 290000)
--この値でレコードを追加
, ('user@co.jp', '2021/01', 300000)
;