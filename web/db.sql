create table T_USER(
	ID VARCHAR2(20) PRIMARY KEY,
	PWD VARCHAR2(20),
	NAME VARCHAR2(20)
);

CREATE SEQUENCE PRO_SEQ
START WITH 100
INCREMENT BY 1;


SELECT * FROM T_PRODUCT;


create TABLE T_PRODUCT(
    ID NUMBER(5) PRIMARY KEY,
    NAME VARCHAR2(20),
    PRICE NUMBER(20),
    REGDATE DATE,
    IMGNAME VARCHAR2(30)
);


insert into T_PRODUCT VALUES(pro_seq.nextval, '징거버거', 4000, sysdate, 'bergur2.jpg');
insert into T_PRODUCT VALUES(pro_seq.nextval, '빅맥', 4000, sysdate, 'bergur3.jpg');
insert into T_PRODUCT VALUES(pro_seq.nextval, '상하이 스파이스', 4000, sysdate, 'bergur4.jpg');
insert into T_PRODUCT VALUES(pro_seq.nextval, '타워버거', 4000, sysdate, 'bergur5.jpg');
insert into T_PRODUCT VALUES(pro_seq.nextval, '새우버거', 4000, sysdate, 'bergur6.jpg');
insert into T_PRODUCT VALUES(pro_seq.nextval, '치킨버거', 4000, sysdate, 'bergur7.jpg');
insert into T_PRODUCT VALUES(pro_seq.nextval, '베이컨토마토디럭스', 4000, sysdate, 'bergur8.jpg');
insert into T_PRODUCT VALUES(pro_seq.nextval, '라이스버거', 4000, sysdate, 'bergur9.jpg');
COMMIT;
update T_PRODUCT SET IMGNAME=REPLACE(IMGNAME, '.jpg', '.png');
COMMIT;