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


insert into T_PRODUCT VALUES(pro_seq.nextval, '¡�Ź���', 4000, sysdate, 'bergur2.jpg');
insert into T_PRODUCT VALUES(pro_seq.nextval, '���', 4000, sysdate, 'bergur3.jpg');
insert into T_PRODUCT VALUES(pro_seq.nextval, '������ �����̽�', 4000, sysdate, 'bergur4.jpg');
insert into T_PRODUCT VALUES(pro_seq.nextval, 'Ÿ������', 4000, sysdate, 'bergur5.jpg');
insert into T_PRODUCT VALUES(pro_seq.nextval, '�������', 4000, sysdate, 'bergur6.jpg');
insert into T_PRODUCT VALUES(pro_seq.nextval, 'ġŲ����', 4000, sysdate, 'bergur7.jpg');
insert into T_PRODUCT VALUES(pro_seq.nextval, '�������丶��𷰽�', 4000, sysdate, 'bergur8.jpg');
insert into T_PRODUCT VALUES(pro_seq.nextval, '���̽�����', 4000, sysdate, 'bergur9.jpg');
COMMIT;
update T_PRODUCT SET IMGNAME=REPLACE(IMGNAME, '.jpg', '.png');
COMMIT;