package grid.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
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
		this.clearButton = new JButton("Clear Table");
		this.quitButton = new JButton("Quit");
		this.dontPushButton = new JButton("Do Not Push");
		
		this.populateTableModel();
		
		this.setupComponents();
		this.setupPanel();
		this.setupLayout();
		this.setupListeners();
	}
	
	private void populateTableModel(){
		this.tableModel.setDataVector(gridController.getGrid(), new String[]{"Earth", "Mars", "Jupiter", "Neptune", "Uranus"});
	}
	
	private void setupComponents(){
		this.dataTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.dataTable.setRowSelectionAllowed(false);
		this.dataTable.setColumnSelectionAllowed(false);
		this.dataTable.setCellSelectionEnabled(true);
		
		
		Font font = new Font("Verdana", Font.PLAIN, 17);
		this.titleLabel.setFont(font.deriveFont(25f));
		this.dataTable.setFont(font.deriveFont(13f));
		this.currentDataLabel.setFont(font);
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
		springLayout.putConstraint(SpringLayout.EAST, editCellField, 0, SpringLayout.EAST, dataTableScrollPane);
		springLayout.putConstraint(SpringLayout.WEST, editCellField, 10, SpringLayout.EAST, currentDataLabel);
		
		springLayout.putConstraint(SpringLayout.HORIZONTAL_CENTER, clearButton, 0, SpringLayout.HORIZONTAL_CENTER, dataTableScrollPane);
		
		springLayout.putConstraint(SpringLayout.NORTH, insertButton, 20, SpringLayout.SOUTH, editCellField);
		springLayout.putConstraint(SpringLayout.EAST, insertButton, 0, SpringLayout.WEST, clearButton);
		
		springLayout.putConstraint(SpringLayout.NORTH, deleteButton, 20, SpringLayout.SOUTH, editCellField);
		springLayout.putConstraint(SpringLayout.WEST, deleteButton, 0, SpringLayout.EAST, clearButton);
		
		springLayout.putConstraint(SpringLayout.NORTH, clearButton, 20, SpringLayout.SOUTH, insertButton);
		
		springLayout.putConstraint(SpringLayout.NORTH, quitButton, 20, SpringLayout.SOUTH, clearButton);
		springLayout.putConstraint(SpringLayout.EAST, quitButton, 0, SpringLayout.WEST, clearButton);
		
		springLayout.putConstraint(SpringLayout.NORTH, dontPushButton, 20, SpringLayout.SOUTH, clearButton);
		springLayout.putConstraint(SpringLayout.WEST, dontPushButton, 0, SpringLayout.EAST, clearButton);
	}
	
	private void setupListeners(){
		
	}
	
	
	public GridController getBaseController(){
		return gridController;
	}

}
