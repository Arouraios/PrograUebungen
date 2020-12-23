public class Strahl extends Gerade {
	private final int start;

	public Strahl(Punkt p1, Punkt p2) {
		super(p1, p2);
		if (this.p1.equals(p1))
			start = 1;
		else
			start = 2;
	}

	public boolean startsFromp1() {
		return start == 1;
	}

	public boolean startsFromp2() {
		return start == 2;
	}

	public String toString() {
		return ("Strahl von " + (startsFromp1() ? p1.toString() : p2.toString()) + " durch "
				+ (startsFromp2() ? p1.toString() : p2.toString()));
	}

	public Gerade verlaengern() {
		return new Gerade(p1, p2);
	}

	public boolean enthaelt(Punkt p0) {
		if(zwischenp1p2(p0)) return true;
		if(startsFromp1()) return hinterp2(p0); else return vorp1(p0);
	}
	
	public boolean equals(Object obj) {
		if(obj.getClass().equals(this.getClass())) {
			if(((Strahl) obj).startsFromp1()&&startsFromp1()) return(((Strahl)obj).getP1().equals(p1)&& enthaelt(((Strahl)obj).getP2()) && ((Strahl)obj).enthaelt(p2));
			if(((Strahl) obj).startsFromp1()&&startsFromp2()) return(((Strahl)obj).getP1().equals(p2)&& enthaelt(((Strahl)obj).getP2()) && ((Strahl)obj).enthaelt(p1));
			if(((Strahl) obj).startsFromp2()&&startsFromp1()) return(((Strahl)obj).getP2().equals(p1)&& enthaelt(((Strahl)obj).getP1()) && ((Strahl)obj).enthaelt(p2));
			if(((Strahl) obj).startsFromp2()&&startsFromp2()) return(((Strahl)obj).getP2().equals(p2)&& enthaelt(((Strahl)obj).getP1()) && ((Strahl)obj).enthaelt(p1));
			System.out.println("Hier darf der Code nicht ankommen. Ups. xkcd.com/2200");
		}
		return false;
	}
}
