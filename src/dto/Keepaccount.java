package dto;

public class Keepaccount {

	private String spending;
	private String income;

	public Keepaccount(){

	}

	public Keepaccount(String spending, String income) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.spending = spending;
		this.income = income;
	}
	public String getspending() {
		return spending;
	}
	public void setspending(String spending){
		this.spending = spending;
	}
	public String getincome() {
		return income;
	}
	public void setincome(String income){
		this.income = income;
	}
}
