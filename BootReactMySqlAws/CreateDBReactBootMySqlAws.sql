CREATE DATABASE BOARD;
USE BOARD;

--  사용자 회원가입
# email[PK], pw,pw_check,nickname, 
# ph, address, address_detail, profileImg

# 실제 테이블 생성
-- 유저
# User(user_email[PK], user_password, user_nickname , user_ph , user_address , user_profileImg)

CREATE TABLE User(
	user_email VARCHAR(50) PRIMARY KEY,
    user_password VARCHAR(20) NOT NULL,
    user_nickname VARCHAR(30) NOT NULL,
	user_phone_number VARCHAR(15) NOT NULL,
    user_address TEXT NOT NULL,
    user_profile TEXT
);


-- 게시판
# 게시물 등록에는 제목, 내용, 사진, 동영상, 파일을 올릴 수 있다.
# Board(board_number[PK},oard_title, board_content, board_image, board_video,board_file, 
#  		board_writer_email[FK-user(user_email)],board_writer_profile,board_writer_nickname,
#		board_writer_date, board_click_count, board_like_count, board_comment_count)

CREATE TABLE Board(
	board_number INT PRIMARY KEY AUTO_INCREMENT,
    board_title VARCHAR(200) NOT NULL,
    board_content TEXT NOT NULL,
    board_image TEXT,
    board_video TEXT,
    board_file TEXT,
    board_writer_email VARCHAR(50) NOT NULL,
    board_writer_profile TEXT,
    board_writer_nickname VARCHAR(30) NOT NULL,
    board_write_date DATE NOT NULL,
    board_click_count INT DEFAULT 0,
    board_like_count INT DEFAULT 0,
    board_comment_count INT DEFAULT 0
);

-- 인기검색어
# PopularSearch(popular_term , popular_search_count)
CREATE TABLE PopularSearch(
	popular_term VARCHAR(200) PRIMARY KEY,
    popular_search_count INT DEFAULT 1
);

-- 좋아요
# Liky(board_number[FK-Board(board_number)], user_email[FK-User(user_email )],
#	   like_user_profile, like_user_nickname)
CREATE TABLE Liky(
	like_id INT AUTO_INCREMENT PRIMARY KEY,
	board_number INT NOT NULL,
	user_email VARCHAR(50) NOT NULL,
    like_user_profile TEXT,
    like_user_nickname VARCHAR(30) NOT NULL
);



-- 댓글
# Comment(board_number[FK_Board(board_number)],user_email[FK_User(user_email)],
#		 comment_user_profile,comment_user_nickname, board_comment_write_date, comment_content)
CREATE TABLE Comment(

	comment_id INT AUTO_INCREMENT PRIMARY KEY,
	board_number INT NOT NULL,
    user_email VARCHAR(50) NOT NULL,
    comment_user_profile TEXT,
    comment_user_nickname VARCHAR(30) NOT NULL,
    board_comment_write_date DATE NOT NULL,
    comment_content TEXT NOT NULL
);



commit;
-- 게시물
# 해당 게시물의 제목, 작성자, 작성자 프로필 사진, 작성일, 내용, 사진, 동영상, 파일
# 게시물의 좋아요 기능 좋아요, 좋아요한 유저 이미지, 좋아요한 유저 닉네임
# 댓글, 댓글 작성자, 작성자 프로필 사진, 작성일, 내용

# User - Board관계
# 1. User가 Board를 작성한다. 		1 : n 관계
# 2. User가 Board에 좋아요를 행한다. n : m 관계
# 3. User가 Board에 댓들을 단다.	n : m 관계

-- 게시물 리스트
# 작성자의 프로필 사진, 닉네임, 게시물의 제목, 내용, 좋아요 수, 댓글 수, 조회 수가 보여짐