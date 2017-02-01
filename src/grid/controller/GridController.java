package grid.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import grid.model.PlanetMoon;
import grid.view.GridFrame;

public class GridController {
	
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
			
			for(int row = 0; row < 5; row++){
				
				String[] moonData = reader.readLine().split(",");
				
				for(int col = 0; col < moonData.length; col++){
					planetMoons[row][col] = new PlanetMoon(moonData[col]);
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
