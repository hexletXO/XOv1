package gameXO;

public class Main {
	final static byte CLEAR_ARR_BY = 0;
	public static void main(String[] args) {
		Someclass one = new Someclass();
		one.setArr(CLEAR_ARR_BY);
		one.setArrByRand();
		one.showRow();

	}

}
