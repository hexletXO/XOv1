package gameXO;


public class Someclass {
	private static final int MAXCOUNT = 3;
	private static final byte MAXOFRAND = 1;
	
	private byte[][] field = new byte[MAXCOUNT][MAXCOUNT];
	
	public void checkArr () {
		  
	}
	
	public void setArrByRand () {
		byte val;
		for (int j = 0; j < MAXCOUNT; j++ ) {
			for (int k = 0; k < MAXCOUNT; k++ ) {
				val = (byte) (Math.random()*(MAXOFRAND+1));
				if (val == 0) {
					field[j][k] = -1;
				} else {
					field[j][k] = val;
				}
			}
		}
	}
	
	public void setArr(byte i) {
		for (int j = 0; j < MAXCOUNT; j++ ) {
			for (int k = 0; k < MAXCOUNT; k++ ) {
				field[j][k] = i;
			}
		}
	}
	
	public void showCell(int i){
		for (int p = 0; p < MAXCOUNT; p++) {
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
		for (int i = 0; i < MAXCOUNT; i++) {
			showCell(i);
			System.out.println();
		}
	}
}

