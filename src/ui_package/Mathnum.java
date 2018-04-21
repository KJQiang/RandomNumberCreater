package ui_package;

public class Mathnum { //Create a Random Number
	int ini;
	public Mathnum(int st) {
		ini = st;
	}
	public int createNum() {
		int a = 0;
		double b = 0;
		b = Math.random()*ini;
		a = (int)b;
		return a;
	}
}
