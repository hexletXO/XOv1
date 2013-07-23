package gameXO;

<<<<<<< HEAD

public class Main {
	
	final static byte CLEAR_ARR_BY = 0;
	
	public static void main(String[] args) {
/*		byte m = 1;
		byte n = 1;
		if ((m != 1) && (n != 1) && (n != 3) && (m != 3)) { System.out.println("Получилось при " +m +" " +n);}
		m = 1;
		n = 2;
		if ((m != 1) && (n != 1) && (n != 3) && (m != 3)) { System.out.println("Получилось при " +m +" " +n);}
		m = 2;
		n = 2;
		if ((m != 1) && (n != 1) && (n != 3) && (m != 3)) { System.out.println("Получилось при " +m +" " +n);}
		m = 2;
		n = 1;
		if ((m != 1) && (n != 1) && (n != 3) && (m != 3)) { System.out.println("Получилось при " +m +" " +n);}
		m = 3;
		n = 1;
		if ((m != 1) && (n != 1) && (n != 3) && (m != 3)) { System.out.println("Получилось при " +m +" " +n);}
		m = 3;
		n = 3;
		if ((m != 1) && (n != 1) && (n != 3) && (m != 3)) { System.out.println("Получилось при " +m +" " +n);}
*/		
		Someclass one = new Someclass();
		
		one.setArrBy(CLEAR_ARR_BY);
		
		one.questionForInputType();
=======
public class Main {
	final static byte CLEAR_ARR_BY = 0;
	public static void main(String[] args) {
		Someclass one = new Someclass();
		one.setArr(CLEAR_ARR_BY);
		one.setArrByRand();
		one.showRow();

>>>>>>> 855c7c6867a47c780f4f024fabb446210fccde70
	}

}
