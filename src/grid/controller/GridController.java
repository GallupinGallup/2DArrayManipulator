package grid.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import grid.model.PlanetMoon;
import grid.view.GridFrame;

public class GridController {
	
	// Moon website: http://www.windows2universe.org/our_solar_system/moons_table.html
	// Earth, Mars, Jupiter, Neptune, Uranus
	private PlanetMoon[][] planetMoons;
	private GridFrame gridFrame;
	
	public GridController(){
		this.populatePlanetMoonArray();
		this.gridFrame = new GridFrame(this);
	}
	
	public void start(){
		
	}
	
	public void populatePlanetMoonArray(){
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/grid/assets/planetMoons.txt")));
			this.planetMoons = new PlanetMoon[5][10];
			for(int row = 0; row < this.planetMoons.length; row++){
				String[] moonData = reader.readLine().split(",");
				for(int col = 0; col < planetMoons[0].length; col++){
					if(moonData.length - 1 < col){
						planetMoons[row][col] = new PlanetMoon("");
					}else{
						planetMoons[row][col] = new PlanetMoon(moonData[col]);
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error", "Error in reading file!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public PlanetMoon[][] getGrid(){
		return planetMoons;
	}

	public GridFrame getFrame() {
		return gridFrame;
	}
	

}
