public class Strecke extends Strahl {

	public Strecke(Punkt p1, Punkt p2) {
		super(p1, p2);
	}

	public boolean enthaelt(Punkt p0) {
		return zwischenp1p2(p0);
	}

	public boolean equals(Object obj) {
		if (obj.getClass().equals(this.getClass()))
			return (p1.equals(((Strecke) obj).getP1()) && p1.equals(((Strecke) obj).getP1()));
		return false;
	}
	
	public Gerade verlaengern() {
		return new Gerade(p1, p2);
	}
	
	public Strahl verlaengern(boolean swap) {
		if (swap) return new Strahl (p1, p2); else return new Strahl(p2,p1);
	}
	
	public String toString() {
		return ("Strecke von " + p1.toString() + " bis "+p2.toString());
	}

}
