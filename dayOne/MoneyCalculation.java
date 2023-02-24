package dayOne;

public class MoneyCalculation {
	public static float compute(float investment) {
		//40% increase in first year
		investment=investment*1.4f;
		
		//1500 loss in second year
		investment=investment-1500;
		
		//12% increase in third year
		investment=investment*1.12f;
		
		return investment;
	}
	public static void main(String[] args) {
		System.out.println(compute(14000));
	}
}
