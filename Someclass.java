package gameXO;

import java.util.Scanner;


public class Someclass {
	
	private static final byte MAXSIZEOFARR = 10;
	
	private static final byte MINSIZEOFARR = 3;
	
	private static final byte DEFSIZEOFARR = 3;
	
	private static final byte MAXOFRAND = 1;
	
	private static byte vul1;
	
	private static byte vul2;
	
	private static byte vul4;
	
	private static byte vul5;
	
	private static byte vul6;
	
	private final int sizeOfArr;
	
	private byte[][] field;

	private Scanner scanner;
	
	public Someclass() {
		this(DEFSIZEOFARR);
	}
	
	public Someclass(byte sizeIn) {
		if (sizeIn != DEFSIZEOFARR) {
			sizeOfArr = sizeIn + 2;
		} else {
			sizeOfArr = getFromConsoleSizeOfArr() + 2;
		}
		field = new byte[sizeOfArr][sizeOfArr];
		
	}
	
	public byte getFromConsoleSizeOfArr() {
		System.out.println("Vvedite razmer polya, ot " + MINSIZEOFARR +" do " +MAXSIZEOFARR +":" );
		scanner = new Scanner(System.in);
		byte vul7 = scanner.nextByte();
		if ((vul7 >= MINSIZEOFARR) && (vul7 <= MAXSIZEOFARR)) {
			return vul7;
		} else { 
			return DEFSIZEOFARR;
		}
	}
	
	public boolean checkForSign(int c, int v) {
		if (field[c][v] > 0) {System.out.println("Pobeda krestikov ;)");}
		else {System.out.println("Pobeda nolikov :)");}
		return true;
	}
	
	public boolean checkForWin () {
		for (int n = 1; n < sizeOfArr - 1; n++) {
			for (int m = 1; m < sizeOfArr - 1; m++) {
				if (Math.abs(field[n - 1][m]+field[n][m]+field[n + 1][m]) == 3) {
					return checkForSign(n,m);
				}
				if (Math.abs(field[n][m - 1]+field[n][m]+field[n][m + 1]) == 3) {
					return checkForSign(n,m);
				}
				if ((n > 1) && (m > 1) && (n < sizeOfArr - 2) && (m < sizeOfArr - 2)) {
					if (Math.abs(field[n - 1][m - 1]+field[n][m]+field[n + 1][m + 1]) == 3) {
						return checkForSign(n,m);
					}
					if (Math.abs(field[n + 1][m - 1]+field[n][m]+field[n - 1][m + 1]) == 3) {
						return checkForSign(n,m);
					}
				}
				if (n == m) {
					if (Math.abs(field[n - 1][m - 1]+field[n][m]+field[n + 1][m + 1]) == 3) {
						return checkForSign(n,m);
					}
				}	
				if (((n == sizeOfArr - 1) && (m == 1)) || ((n == 1) && (m == sizeOfArr - 1))) {
					if (Math.abs(field[n - 1][m + 1]+field[n][m]+field[n + 1][m - 1]) == 3) {
						return checkForSign(n,m);
					}
				}
		  	} 
		} 
		return false;
	}
	
	public boolean checkForZero(byte e, byte w) {
		if (field[e][w] == 0) {
			return true; 
		} else {
			return false;
		}
	}
	
	public void getRandXY() {
		vul1 =  (byte) (Math.random()*(sizeOfArr - 2) + 1);
		vul2 =  (byte) (Math.random()*(sizeOfArr - 2) + 1);
		if (checkForZero(vul1,vul2) == false) {
			getRandXY();
		} else {
			
		}
	}
	
	public byte getFromConsoleInputType() {
		scanner = new Scanner(System.in);
		byte vulnFromCons = scanner.nextByte();
		if ((vulnFromCons > 0) && (vulnFromCons < 3)) {return vulnFromCons;}
		else {return 1;}
	}
	
	public void questionForInputType() {
		byte val3 = 1;
		System.out.println("Viberite rezhim: 1.Zapolnenie sluchaino. 2. Person vs Person.");		
		val3 = getFromConsoleInputType();
		if (val3 == 1) {setArrByRand();} 
		if (val3 == 2) {setArrByConsole();} 
	}
	
	public void questionForXY() {
		String str;
		if ((vul6 % 2) == 0) {
			str = "Hod krestikov, ";
		} else {
			str = "Hod nolikov, ";
		}
		scanner = new Scanner(System.in);
		System.out.println(str +"Vvedite stolbec, ot 1 do " + (sizeOfArr - 2));
		vul4 = scanner.nextByte();
		System.out.println(str +"Vvedite stroku, ot 1 do " + (sizeOfArr - 2));
		vul5 = scanner.nextByte();
	}
	
	public void  getXYFromConsole() {
		questionForXY();
		if (field[vul4][vul5] != 0) {
			if (field[vul4][vul5] > 0) {
				System.out.println("Zdes uzhe stoit krestik");
			} else {
				System.out.println("Zdes uzhe stoit nolik");
			}
			getXYFromConsole();
		}
	}
	
	public void setArrByConsole() {
		for (int e = 1; e < (((sizeOfArr - 2) * (sizeOfArr - 2)) + 1); e++) {
			vul6 = (byte) e;
			getXYFromConsole();
			if ((e%2) == 0) {
				field[vul4][vul5] = 1;
			} else {
				field[vul4][vul5] = -1;
			}
			magicQQ(vul4,vul5);	
			showRow();
			System.out.println("");
			if (checkForWin() == true) {System.exit(0);}
		}
		System.out.println("Net pobeditelya >:O");
	}
	
	public void magicQQ(int d, int f) {
		
		if (f == 3) {field[d][0] = field[d][f];}
		if (d == 3) {field[0][f] = field[d][f];}
		if (f == sizeOfArr - 4) {field[d][sizeOfArr - 1] = field[d][f];}
		if (d == sizeOfArr - 4) {field[sizeOfArr - 1][f] = field[d][f];}
		if ((d == 3) && (f == 3)) {field[0][0] = field[d][f];}
		if ((d == 3) && (f == sizeOfArr - 4)) {field[0][sizeOfArr - 1] = field[d][f];}
		if ((d == sizeOfArr - 4) && (f == 3)) {field[sizeOfArr - 1][0] = field[d][f];}
		if ((d == sizeOfArr - 4) && (f == sizeOfArr - 4)) {field[sizeOfArr - 1][sizeOfArr - 1] = field[d][f];}	
		
	}
	
	public void setArrByRand () {
		byte val;
		for (int j = 1; j < sizeOfArr - 1; j++ ) {
			for (int k = 1; k < sizeOfArr - 1; k++ ) {
				getRandXY();
				val = (byte) (Math.random()*(MAXOFRAND+1));
				if (val == 0) {
					field[vul1][vul2] = -1;
				} else {
					field[vul1][vul2] = val;
				}					
				magicQQ(vul1,vul2);
				showRow();
				System.out.println("");
				if (checkForWin() == true) {System.exit(0);}
			}
		}
	}
	
	public void setArrBy(byte i) {
		for (int j = 0; j < sizeOfArr; j++ ) {
			for (int k = 0; k < sizeOfArr; k++ ) {
				field[j][k] = i;
			}
		}
	}
	
	public void showCell(int i){
		for (int p = 0; p < sizeOfArr; p++) {
			System.out.print("[");
			if (field[i][p] == -1) {
				System.out.print("O");				
				} else {
					if (field[i][p] == 0) {
						System.out.print(" ");
					} else {
						if (field[i][p] == 1) {
							System.out.print("X");
						}
					}
				}
			System.out.print("]");
		}
	}
	
	public void showRow() { 
		for (int i = 0; i < sizeOfArr; i++) {
			showCell(i);
			System.out.println();
		}
	}
}

