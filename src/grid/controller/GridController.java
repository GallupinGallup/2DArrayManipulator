package grid.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;

import grid.model.PlanetMoon;
import grid.view.GridFrame;

public class GridController {
	
	private PlanetMoon[][] planetMoons;
	private GridFrame gridFrame;
	
	public GridController(){
		this.gridFrame = new GridFrame(this);
	}
	
	public void start(){
		
	}
	
	public void populatePlanetMoonArray(){
		String textData = "";
		
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/grid/assets/planetMoon.txt")));
			textData = reader.readLine();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error", "Error in reading file!", JOptionPane.ERROR_MESSAGE);
		}
		
		if(textData.equals("")){
			return;
		}
		
		String[] planetWithMoonData = textData.split("-");
		
		this.planetMoons = new PlanetMoon[planetWithMoonData.length][];
		
		for(int row = 0; row < planetMoons.length; row++){
			for(int col = 0; col < planetMoons[0].length; col++){
				planetMoons[row][col] = new PlanetMoon();
			}
		}
	}
	
	public PlanetMoon[][] getGrid(){
		return planetMoons;
	}

	public GridFrame getFrame() {
		return gridFrame;
	}
	

}
