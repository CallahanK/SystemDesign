
public class Item {
	private String firstValue;
	private String secondValue;
	private String thirdValue;
	
	public Item(){
		firstValue = "";
		secondValue = "";
		thirdValue = "";
	}
	
	public Item(String tempFirst, String tempSecond, String tempThird){
		firstValue = tempFirst;
		secondValue = tempSecond;
		thirdValue = tempThird;
	}
	
	public String getFirstValue() {
		return firstValue;
	}
	public void setFirstValue(String firstValue) {
		this.firstValue = firstValue;
	}
	public String getSecondValue() {
		return secondValue;
	}
	public void setSecondValue(String secondValue) {
		this.secondValue = secondValue;
	}
	public String getThirdValue() {
		return thirdValue;
	}
	public void setThirdValue(String thirdValue) {
		this.thirdValue = thirdValue;
	}
	
	
	
	
	
	
	
	
}
