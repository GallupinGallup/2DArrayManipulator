package grid.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import grid.controller.GridController;

public class GridPanel extends JPanel {
	
	private GridController gridController;
	private SpringLayout springLayout;
	
	private JTable dataTable;
	private JLabel titleLabel;
	private JLabel currentDataLabel;
	private JTextField editCellField;
	private JButton insertButton;
	private JButton deleteButton;
	private JButton clearButton;
	private JButton quitButton;
	private JButton dontPushButton;
	
	public GridPanel(GridController gridController){
		super();
		this.gridController = gridController;
		this.springLayout = new SpringLayout();
		this.dataTable = new JTable(new DefaultTableModel(gridController.getGrid(), new String[]{"Earth", "Mars", "Jupiter", "Neptune", "Uranus"} ));
		this.titleLabel = new JLabel("This is an Application");
		this.currentDataLabel = new JLabel("Current Data:");
		this.editCellField = new JTextField();
		this.insertButton = new JButton("Insert");
		this.deleteButton = new JButton("Delete");
		this.clearButton = new JButton("Clear");
		this.quitButton = new JButton("Quit");
		this.dontPushButton = new JButton("Do Not Push");
		
		this.setupPanel();
		this.setupLayout();
		this.setupListeners();
	}
	
	private void setupPanel(){
		this.setLayout(springLayout);
		this.add(dataTable);
		this.add(titleLabel);
		this.add(currentDataLabel);
		this.add(editCellField);
		this.add(insertButton);
		this.add(deleteButton);
		this.add(clearButton);
		this.add(quitButton);
		this.add(dontPushButton);
	}
	
	private void setupLayout(){
		
	}
	
	private void setupListeners(){
		
	}
	
	
	public GridController getBaseController(){
		return gridController;
	}

}
