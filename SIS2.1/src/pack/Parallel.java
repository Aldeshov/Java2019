package pack;

public class Parallel extends Circuit {
	Circuit c1;
	Circuit c2;
	
	Parallel(Circuit c1,Circuit c2) {
		this.c1 = c1;
		this.c2 = c2;
	}
	
	@Override
	public double getResistance() {
		return (c1.getResistance() * c2.getResistance()) / (c1.getResistance() + c2.getResistance());
	}

	@Override
	public void applyPotentialDiff(double v) {
		c1.applyPotentialDiff(v);
		c2.applyPotentialDiff(v);
	}

	@Override
	public double getPotentialDiff() {
		return c1.getPotentialDiff();
	}
}