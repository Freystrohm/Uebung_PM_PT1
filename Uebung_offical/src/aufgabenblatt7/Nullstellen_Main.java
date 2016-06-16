package aufgabenblatt7;

import java.util.Collections;

public class Nullstellen_Main {
public static void main(String []args) throws NullstellenException{
	IFunktion funktion1 = new QuadratischeFunktionen(2, 3, -2);
	Nullstellen nullstelle = new Nullstellen(funktion1,10,-5);
	nullstelle.findeNullstellenRandomisiert(-15, 50, 1000);
	System.out.println(nullstelle.toString());
}
}
