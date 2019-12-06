package pack;

public class Series extends Circuit {
    Circuit c1;
    Circuit c2;
    
	Series(Circuit c1, Circuit c2) {
    	this.c1 = c1;
    	this.c2 = c2;
    }
	
	@Override
	public double getResistance() {
		return c1.getResistance() + c2.getResistance();
	}

	@Override
	public double getPotentialDiff() {
		return c1.getPotentialDiff() + c2.getPotentialDiff();
	}

	@Override
	public void applyPotentialDiff(double v) {
		c1.applyPotentialDiff((v / getResistance()) * c1.getResistance());
		c2.applyPotentialDiff((v / getResistance()) * c2.getResistance());
	}
}