package grid.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import grid.controller.GridController;
import grid.model.GridTableModel;

public class GridPanel extends JPanel {
	
	private GridController gridController;
	
	private SpringLayout springLayout;
	private DefaultTableModel tableModel;
	
	private JScrollPane dataTableScrollPane;
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
		
		this.tableModel = new GridTableModel();
		this.dataTable = new JTable(tableModel);
		this.dataTableScrollPane = new JScrollPane(dataTable);
		this.titleLabel = new JLabel("Cell Editor");
		this.currentDataLabel = new JLabel("Edit Data:");
		this.editCellField = new JTextField();
		this.insertButton = new JButton("Insert");
		this.deleteButton = new JButton("Delete");
		this.clearButton = new JButton("Clear");
		this.quitButton = new JButton("Quit");
		this.dontPushButton = new JButton("Do Not Push");
		
		this.setupComponents();
		this.setupPanel();
		this.setupLayout();
		this.setupListeners();
	}
	
	private void setupComponents(){
		Font font = new Font("Verdana", Font.PLAIN, 17);
		
		this.titleLabel.setFont(font.deriveFont(25f));
		this.dataTable.setFont(font.deriveFont(13f));
		this.currentDataLabel.setFont(font);
		
		//new String[]{"Earth", "Mars", "Jupiter", "Neptune", "Uranus"}
	}
	
	private void setupPanel(){
		this.setLayout(springLayout);
		this.add(dataTableScrollPane);
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
		springLayout.putConstraint(SpringLayout.NORTH, titleLabel, 20, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, titleLabel, 0, SpringLayout.HORIZONTAL_CENTER, this);
		
		springLayout.putConstraint(SpringLayout.NORTH, dataTableScrollPane, 20, SpringLayout.SOUTH, titleLabel);
		springLayout.putConstraint(SpringLayout.SOUTH, dataTableScrollPane, 250, SpringLayout.NORTH, dataTableScrollPane);
		springLayout.putConstraint(SpringLayout.EAST, dataTableScrollPane, -20, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.WEST, dataTableScrollPane, 20, SpringLayout.WEST, this);
		
		springLayout.putConstraint(SpringLayout.NORTH, currentDataLabel, 30, SpringLayout.SOUTH, dataTableScrollPane);
		springLayout.putConstraint(SpringLayout.WEST, currentDataLabel, 0, SpringLayout.WEST, dataTableScrollPane);
		
		springLayout.putConstraint(SpringLayout.VERTICAL_CENTER, editCellField, 0, SpringLayout.VERTICAL_CENTER, currentDataLabel);
	}
	
	private void setupListeners(){
		
	}
	
	
	public GridController getBaseController(){
		return gridController;
	}

}
