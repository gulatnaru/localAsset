CREATE TABLE LOCALASSET(
    CODE       VARCHAR2(20) PRIMARY KEY,
    LOCALNAME VARCHAR2(20),
    FISCALYEAR VARCHAR2(10),
    DETAILNAME  VARCHAR2(20),
    INCOME     NUMBER,
    INCOMERESULT NUMBER,
    INDEPENDENT NUMBER
);