package dto;

public class Keepaccount {

	private int spending;
	private int income;

	public Keepaccount(int spending, int income) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.spending = spending;
		this.income = income;
	}
	public int getspending() {
		return spending;
	}
	public void setspending(int spending){
		this.spending = spending;
	}
	public int getincome() {
		return income;
	}
	public void setincome(int income){
		this.income = income;
	}
}
