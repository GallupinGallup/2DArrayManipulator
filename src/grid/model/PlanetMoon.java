package grid.model;

public class PlanetMoon {
	
	private String moonName;
	
	public PlanetMoon(String moonName){
		this.moonName = moonName;
	}
	
	@Override
	public String toString() {
		return "The moon name is: " + moonName;
	}
	
	public String getMoonName() {
		return moonName;
	}

	public void setMoonName(String moonName) {
		this.moonName = moonName;
	}

}
