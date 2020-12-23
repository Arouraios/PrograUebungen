import java.math.*;

public class Gerade {
	protected final Punkt p1;
	protected final Punkt p2;

	public Gerade(Punkt p1, Punkt p2) {
		if (p1.equals(p2)) {
			System.out.println("Die angegebenen Punkte dürfen nicht gleich sein!");
			this.p1 = null;
			this.p2 = null;
		} else {
			if (p1.getX().compareTo(p2.getX()) < 0) {
				this.p1 = p1;
				this.p2 = p2;
			} else if (p1.getX().compareTo(p2.getX()) > 0) {
				this.p1 = p2;
				this.p2 = p1;
			} else if (p1.getX().equals(p2.getX())) {
				if (p1.getY().compareTo(p2.getY()) < 0) {
					this.p1 = p1;
					this.p2 = p2;
				} else if (p1.getY().compareTo(p2.getY()) > 0) {
					this.p1 = p2;
					this.p2 = p1;
				} else {
					this.p1 = null;
					this.p2 = null;
					System.out.println(
							"Nur wenn sowohl x als auch y gleich sind, kann dieser Fall gelten. Dieser Text wird also nur ausgegeben, wenn p1=p2 sind, was nicht der Fall sein kann. Trotzdem muss ich den Fall explizit als else behandeln. Danke Java/Eclipse." );
				}
			} else {
				this.p1 = null;
				this.p2 = null;
				System.out.println(
						"Diese Stelle im Code soll nicht erreicht werden. Wenn doch ist was schief gelaufen :/");
			}
		}
	}

	public Punkt getP1() {
		return p1;
	}

	public Punkt getP2() {
		return p2;
	}

	public String toString() {
		return ("Gerade durch " + p1.toString() + " und " + p2.toString());
	}

	/*
	 * Wenn p0 zwischen p1 und p2 liegt, dann ist der Abstand zu x positiv und
	 * kleiner als der Abstand zwischen p1 und p2. Außerdem gilt: Wenn eine gerade
	 * durch p1 und p0 die selbe Steigung hat wie die gerade durch p1 und p2, so
	 * sind p0 und p2 auf der selben gerade.
	 */
	protected boolean zwischenp1p2(Punkt p0) {
		if (p0.equals(p1))
			return true;
		if (p0.equals(p2))
			return true;
		BigDecimal dx = p0.getX().subtract(p1.getX());
		BigDecimal dy = p0.getY().subtract(p1.getY());
		BigDecimal gDx = p2.getX().subtract(p1.getX());
		BigDecimal gDy = p2.getY().subtract(p1.getY());
		if (dx.compareTo(BigDecimal.ZERO) >= 0 && dy.compareTo(BigDecimal.ZERO) >= 0 && dx.compareTo(gDx) <= 0
				&& dy.compareTo(gDy) <= 0 && BigDecimalUtility.equalValues(dx.divide(dy, RoundingMode.HALF_UP),
						gDx.divide(gDy, RoundingMode.HALF_UP)))
			return true;
		return false;
	}

	protected boolean vorp1(Punkt p0) {
		if (zwischenp1p2(p0))
			return false;
		BigDecimal dx = p1.getX().subtract(p0.getX());
		BigDecimal dy = p1.getY().subtract(p0.getY());
		BigDecimal gDx = p2.getX().subtract(p1.getX());
		BigDecimal gDy = p2.getY().subtract(p1.getY());
		if (dx.compareTo(BigDecimal.ZERO) > 0 && dy.compareTo(BigDecimal.ZERO) > 0 && BigDecimalUtility
				.equalValues(dx.divide(dy, RoundingMode.HALF_UP), gDx.divide(gDy, RoundingMode.HALF_UP)))
			return true;
		return false;
	}

	protected boolean hinterp2(Punkt p0) {
		if (zwischenp1p2(p0))
			return false;
		if (vorp1(p0))
			return false;
		BigDecimal dx = p0.getX().subtract(p1.getX());
		BigDecimal dy = p0.getY().subtract(p1.getY());
		BigDecimal gDx = p2.getX().subtract(p1.getX());
		BigDecimal gDy = p2.getY().subtract(p1.getY());
		if (dx.compareTo(gDx) > 0 && dy.compareTo(gDy) > 0
				&& BigDecimalUtility.equalValues(dx.divide(dy), gDx.divide(gDy)))
			return true;

		return false;
	}

	public boolean enthaelt(Punkt p0) {
		if (zwischenp1p2(p0)) {
			return true;
		}
		if (vorp1(p0)) {
			return true;
		}
		if (hinterp2(p0)) {
			return true;
		}
		return false;
	}

	public boolean equals(Object obj) {
		if (obj.getClass().equals(this.getClass())) {
			if (this.enthaelt(((Gerade) obj).getP1()) && this.enthaelt(((Gerade) obj).getP2())
					&& ((Gerade) obj).enthaelt(p1) && ((Gerade) obj).enthaelt(p2))
				return true;
			return false;

		}
		return false;
	}

}