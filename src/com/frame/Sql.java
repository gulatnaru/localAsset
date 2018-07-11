package com.frame;

public class Sql {
	public static String insertUser = 
	"INSERT INTO T_USER VALUES(?,?,?)";
	public static String deleteUser = 
	"DELETE FROM T_USER WHERE ID=?";
	public static String updateUser = 
	"UPDATE T_USER SET PWD=?,NAME=? WHERE ID=?";
	public static String selectUser = 
	"SELECT * FROM T_USER WHERE ID=?";
	public static String selectallUser = 
	"SELECT * FROM T_USER";		
	
	public static String insertProduct = 
	"INSERT INTO T_PRODUCT VALUES(PRO_SEQ.NEXTVAL,?,?,SYSDATE,?)";
	public static String deleteProduct = 
	"DELETE FROM T_PRODUCT WHERE ID=?";
	public static String updateProduct = 
	"UPDATE T_PRODUCT SET NAME=?,PRICE=?,IMGNAME=? WHERE ID=?";
	public static String selectProduct = 
	"SELECT * FROM T_PRODUCT WHERE ID=?";
	public static String selectallProduct = 
	"SELECT * FROM T_PRODUCT";	

	public static String insertTable = 
	"INSERT INTO LOCALASSET VALUES(?,?,?,?,?)";
	public static String deleteTable = 			
	"DELETE FROM LOCALASSET WHERE CODE=?";
	public static String updateTable = 
	"UPDATE LOCALASSET SET LOCALNAME=?,FISCALYEAR=?,DETAILNAME=?,INCOME=?,INCOMERESULT=?,INDEPENDENT=? WHERE CODE=?";
	public static String selectTable = 
	"SELECT * FROM LOCALASSET WHERE CODE=?";
	public static String selectallTable = 
	"SELECT * FROM LOCALASSET ";   
	public static String selectAvg = 
	"SELECT LOCALNAME, AVG(INCOME) as incomeavg FROM LOCALASSET GROUP BY LOCALNAME";
}




