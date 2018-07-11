package com.table;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import com.frame.Dao;
import com.frame.Sql;
import com.vo.Table;


public class TableDao<K,V> extends Dao<K, V> {

	@Override
	public void insert(Connection con, K obj) throws Exception {
		PreparedStatement pstmt = null;
		Table p = (Table)obj;
		try {
			pstmt = 
			con.prepareStatement(Sql.insertTable);
			pstmt.setString(1, p.getCode());
			pstmt.setString(2, p.getLocalname());
			pstmt.setString(3, p.getFiscalyear());
			pstmt.setString(4, p.getDetailname());
			pstmt.setDouble(5, p.getIncome());
			pstmt.setDouble(6, p.getIncomeresult());
			pstmt.setDouble(7, p.getIndependent());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);	
		}
	}

	@Override
	public void delete(Connection con, V code) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = 
			con.prepareStatement(Sql.deleteTable);
			pstmt.setInt(1, 
					Integer.valueOf(code.toString()));
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);	
		}			
	}

	@Override
	public void update(Connection con, K obj) throws Exception {
		PreparedStatement pstmt = null;
		Table t = (Table)obj;
		try {
			pstmt = 
			con.prepareStatement(Sql.updateTable);
			pstmt.setString(1, t.getLocalname());
			pstmt.setString(2, t.getFiscalyear());
			pstmt.setString(3, t.getDetailname());
			pstmt.setDouble(4, t.getIncome());
			pstmt.setDouble(5, t.getIncomeresult());
			pstmt.setDouble(6, t.getIndependent());
			pstmt.setString(7, t.getCode());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);	
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public K select(Connection con, V code) throws Exception {
		Table t = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = 
			con.prepareStatement(Sql.selectTable);
			pstmt.setString(1, code.toString());
			rset = pstmt.executeQuery();
			rset.next();
			String dbcode = rset.getString("CODE");
			String localname = rset.getString("LOCALNAME");
			String fiscalyear = rset.getString("FISCALYEAR");
			String detailname = rset.getString("DETAILNAME");
			double income = rset.getDouble("INCOME");
			double incomeresult = rset.getDouble("INCOMERESULT");
			double independent = rset.getDouble("INDEPENDENT");
			t = new Table(dbcode, localname, fiscalyear, detailname,income,incomeresult,independent);
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);	
			close(rset);
		}					
		return (K)t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<K> select(Connection con) throws Exception {
		ArrayList<Table> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = 
			con.prepareStatement(Sql.selectallTable);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Table t = null;
				String dbcode = rset.getString("CODE");
				String localname = rset.getString("LOCALNAME");
				String fiscalyear = rset.getString("FISCALYEAR");
				String detailname = rset.getString("DETAILNAME");
				double  income = rset.getDouble ("INCOME");
				double incomeresult = rset.getDouble("INCOMERESULT");
				double independent = rset.getDouble ("INDEPENDENT");
				t = new Table(dbcode, localname, fiscalyear, detailname,income,incomeresult,independent);
				list.add(t);
			}
		}catch(Exception e) {
			System.out.println("==="+ e.getMessage() );
			throw e;
		}finally {
			close(pstmt);	
			close(rset);
		}					
		return (ArrayList<K>)list;
	}
	@SuppressWarnings("unchecked")
	public ArrayList<K> selectAvg(Connection con) throws Exception {
		ArrayList<Table> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = 
			con.prepareStatement(Sql.selectAvg);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Table t = null;
				String localname = rset.getString("LOCALNAME");
				double incomeavg = rset.getDouble ("incomeavg");
				t = new Table(localname,incomeavg);
				list.add(t);
			}
		}catch(Exception e) {
			System.out.println("==="+ e.getMessage() );
			throw e;
		}finally {
			close(pstmt);	
			close(rset);
		}					
		return (ArrayList<K>)list;
	}
}

