
/* Drop Triggers */

DROP TRIGGER TRI_book_b_num;
DROP TRIGGER TRI_lent_l_num;
DROP TRIGGER TRI_member_m_num;



/* Drop Tables */

DROP TABLE lent CASCADE CONSTRAINTS;
DROP TABLE book CASCADE CONSTRAINTS;
DROP TABLE member CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE SEQ_book_b_num;
DROP SEQUENCE SEQ_lent_l_num;
DROP SEQUENCE SEQ_member_m_num;




/* Create Sequences */

CREATE SEQUENCE SEQ_book_b_num INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_lent_l_num INCREMENT BY 1 START WITH 1;
CREATE SEQUENCE SEQ_member_m_num INCREMENT BY 1 START WITH 1;



/* Create Tables */

CREATE TABLE book
(
	b_num number(10,0) NOT NULL,
	b_title varchar2(60) NOT NULL,
	b_author varchar2(20) NOT NULL,
	b_credat date NOT NULL,
	b_desc clob,
	PRIMARY KEY (b_num)
);


CREATE TABLE lent
(
	l_num number(10,0) NOT NULL,
	l_lentdate date NOT NULL,
	l_recdate date,
	m_num number(10,0) NOT NULL,
	b_num number(10,0) NOT NULL,
	PRIMARY KEY (l_num)
);


CREATE TABLE member
(
	m_num number(10,0) NOT NULL,
	m_name varchar2(20) NOT NULL,
	m_id varchar2(20) NOT NULL UNIQUE,
	m_pwd varchar2(20) NOT NULL,
	m_credat date NOT NULL,
	PRIMARY KEY (m_num)
);



/* Create Foreign Keys */

ALTER TABLE lent
	ADD FOREIGN KEY (b_num)
	REFERENCES book (b_num)
;


ALTER TABLE lent
	ADD FOREIGN KEY (m_num)
	REFERENCES member (m_num)
;



/* Create Triggers */

CREATE OR REPLACE TRIGGER TRI_book_b_num BEFORE INSERT ON book
FOR EACH ROW
BEGIN
	SELECT SEQ_book_b_num.nextval
	INTO :new.b_num
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_lent_l_num BEFORE INSERT ON lent
FOR EACH ROW
BEGIN
	SELECT SEQ_lent_l_num.nextval
	INTO :new.l_num
	FROM dual;
END;

/

CREATE OR REPLACE TRIGGER TRI_member_m_num BEFORE INSERT ON member
FOR EACH ROW
BEGIN
	SELECT SEQ_member_m_num.nextval
	INTO :new.m_num
	FROM dual;
END;

/




