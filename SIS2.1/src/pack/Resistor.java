package pack;

public class Resistor extends Circuit {
    double resistance;
    private double  PotentialDiff;
    
	Resistor(double resistance) {
		PotentialDiff = 0;
		this.resistance = resistance;
	}
	 
	@Override
	public double getResistance() {
		return resistance;
	}

	@Override
	public double getPotentialDiff() {
		return  PotentialDiff;
	}

	@Override
	public void applyPotentialDiff(double v) {
		this.PotentialDiff = v;
	}
}