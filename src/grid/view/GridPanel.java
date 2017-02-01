package grid.view;

import javax.swing.JPanel;

import grid.controller.GridController;

public class GridPanel extends JPanel {
	
	private GridController gridController;
	
	public GridPanel(GridController gridController){
		super();
		this.gridController = gridController;
	}
	
	public GridController getBaseController(){
		return gridController;
	}

}
