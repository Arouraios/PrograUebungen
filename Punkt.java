import java.math.*;

public class Punkt {
	private final BigDecimal x, y;

	public Punkt(double pX, double pY) {
		x = new BigDecimal(pX);
		y = new BigDecimal(pY);
	}

	public Punkt(BigDecimal pX, BigDecimal pY) {
		x = pX;
		y = pY;
	}

	public String toString() {
		return "(" + x.toPlainString() + "," + y.toPlainString() + ")";
	}

	public BigDecimal getX() {
		return x;
	}

	public BigDecimal getY() {
		return y;
	}

	public BigDecimal abstand(Punkt other) {
		BigDecimal dX = x.subtract(other.getX());
		BigDecimal dY = y.subtract(other.getY());
		return BigDecimalUtility.sqrt(dX.multiply(dX).add(dY.multiply(dY)));
	}

	public boolean equals(Object obj) {
		if (obj instanceof Punkt) {
			Punkt p1 = (Punkt) (obj);
			return (BigDecimalUtility.equalValues(x, p1.getX()) && BigDecimalUtility.equalValues(y, p1.getY()));
		}
		return false;
	}

	public static void main(String[] args) {
		Punkt p1 = new Punkt(15d, 20d);
		System.out.println(p1.toString());
		Punkt p2 = new Punkt(20d, 25d);
		System.out.println(p2.toString());
		System.out.println(p1.abstand(p2).toPlainString());
		System.out.println(p1.equals(p2));
		Gerade g = new Gerade(p2, p1);
		System.out.println(g.toString());
		System.out.println("" + g.enthaelt(new Punkt(14d, 19d)) + g.enthaelt(p1) + g.enthaelt(new Punkt(16d, 21d))
				+ g.enthaelt(p2) + g.enthaelt(new Punkt(21d, 26d)));
		System.out.println(g.enthaelt(new Punkt(17d, 21d)) + "" + g.enthaelt(new Punkt(21d, 21d)));
		System.out.println(p1.toString() + g.enthaelt(p1) + g.zwischenp1p2(p1));
		System.out.println(g.vorp1(p1) + "");
		System.out.println("" + g.hinterp2(p1));
	}

}