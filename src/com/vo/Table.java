package com.vo;

public class Table {
	private String code;
	private String localname;
	private String fiscalyear; 
	private String detailname;  
	private double income;   
	private double incomeresult;
	private double independent;
	private double avg;
	
	public Table() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Table(String code, String localname, String fiscalyear, String detailname, double income,
			double incomeresult, double independent, double avg) {
		super();
		this.code = code;
		this.localname = localname;
		this.fiscalyear = fiscalyear;
		this.detailname = detailname;
		this.income = income;
		this.incomeresult = incomeresult;
		this.independent = independent;
		this.avg = avg;
	}

	public Table(String code, String localname, String fiscalyear, String detailname, double income,
			double incomeresult, double independent) {
		super();
		this.code = code;
		this.localname = localname;
		this.fiscalyear = fiscalyear;
		this.detailname = detailname;
		this.income = income;
		this.incomeresult = incomeresult;
		this.independent = independent;
	}

	public Table(String localname, double avg) {
		super();
		this.localname = localname;
		this.avg = avg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLocalname() {
		return localname;
	}

	public void setLocalname(String localname) {
		this.localname = localname;
	}

	public String getFiscalyear() {
		return fiscalyear;
	}

	public void setFiscalyear(String fiscalyear) {
		this.fiscalyear = fiscalyear;
	}

	public String getDetailname() {
		return detailname;
	}

	public void setDetailname(String detailname) {
		this.detailname = detailname;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public double getIncomeresult() {
		return incomeresult;
	}

	public void setIncomeresult(double incomeresult) {
		this.incomeresult = incomeresult;
	}

	public double getIndependent() {
		return independent;
	}

	public void setIndependent(double independent) {
		this.independent = independent;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(avg);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((detailname == null) ? 0 : detailname.hashCode());
		result = prime * result + ((fiscalyear == null) ? 0 : fiscalyear.hashCode());
		temp = Double.doubleToLongBits(income);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(incomeresult);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(independent);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((localname == null) ? 0 : localname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Table other = (Table) obj;
		if (Double.doubleToLongBits(avg) != Double.doubleToLongBits(other.avg))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (detailname == null) {
			if (other.detailname != null)
				return false;
		} else if (!detailname.equals(other.detailname))
			return false;
		if (fiscalyear == null) {
			if (other.fiscalyear != null)
				return false;
		} else if (!fiscalyear.equals(other.fiscalyear))
			return false;
		if (Double.doubleToLongBits(income) != Double.doubleToLongBits(other.income))
			return false;
		if (Double.doubleToLongBits(incomeresult) != Double.doubleToLongBits(other.incomeresult))
			return false;
		if (Double.doubleToLongBits(independent) != Double.doubleToLongBits(other.independent))
			return false;
		if (localname == null) {
			if (other.localname != null)
				return false;
		} else if (!localname.equals(other.localname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Table [code=" + code + ", localname=" + localname + ", fiscalyear=" + fiscalyear + ", detailname="
				+ detailname + ", income=" + income + ", incomeresult=" + incomeresult + ", independent=" + independent
				+ ", avg=" + avg + "]";
	}
	
	
}

