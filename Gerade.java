public class Gerade {
	private final p1, p2;
	
	public Gerade(Punkt p1, Punkt p2) {
		if(p1.equals(p2)) {
			System.out.println("Die angegebenen Punkte dürfen nicht gleich sein!");
			this.p1 = null;
			this.p2 = null;
		} else {
			if(p1.getX().compareTo(p2.getX()) < 0) {
				this.p1=p1;
				this.p2=p2;
			} else if(p1.getX().compareTo(p2.getX()) > 0) {
				this.p1=p2;
				this.p2=p1;
			} else if(p1.getX().equals(p2.getX())) {
				if(p1.getY().compareTo(p2.getY())<0) {
					this.p1=p1;
					this.p2=p2;
				} else if(p1.getY().compareTo(p2.getY())>0) {
					this.p1=p2;
					this.p2=p1;
				}
			} else { System.out.println("Diese Stelle im Code soll nicht erreicht werden. Wenn doch ist was schief gelaufen :/");}
		}
	}
	
	public String toString() {
		System.out.println("Gerade durch "+ p1.toString() + " und " + p2.toString());
	}
}