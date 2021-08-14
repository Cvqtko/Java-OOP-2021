package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut{
	private static final double OXYGEN = 70;

	public Biologist(String name) {
		super(name, OXYGEN);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void breath() {
		this.setOxygen(this.getOxygen()-5);
		
	}
}
