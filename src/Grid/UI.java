/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grid;

/**
 *
 * @author ensea
 */
import java.awt.* ; // pour importer Color et Container
import javax.swing.*; // pour importer tout le reste : JFrame,…
import java.awt.event.*;
import java.util.*;
import java.lang.*;

public class UI extends JFrame implements ActionListener{
	private int width = 900;
	private int length = 1200;
	private int x;
	private int y;
	private boolean iO = false;
	private JTextField nbBlocks;
	private JTextField nbBuild; 
	private JTextField streetWidth;
	private Grid manGrid ;
	private GridProcess manGridProcess;
	private JRadioButton radioButtonIn = new JRadioButton("In");
	private JRadioButton radioButtonOut = new JRadioButton("Out");

	
	public void actionPerformed(ActionEvent e){
		String cmd = e.getActionCommand();
		if(cmd == "start"){

			manGrid.setNbBlocks(Integer.parseInt(nbBlocks.getText()));
			//manGrid.setNbBuildings(Integer.parseInt(nbBuild.getText()));
			manGrid.setStreetWidth(Integer.parseInt(streetWidth.getText()));
                        manGrid.setPaintMatrix();
			manGrid.repaint();
		}
		if(cmd == "In"){
			iO = true;
			radioButtonOut.setSelected(false);
		}
		if(cmd == "Out"){
			iO = false;
			radioButtonIn.setSelected(false);
		}
}
	
	public UI(String title){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                setLocation(0,0);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//setLocation(0,200);
		//setSize(800,600);
		setTitle("Manhattan Grid");
		JSplitPane main = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);		

		
		JPanel parameters = new JPanel();
		/*
		JPanel paramBuild = new JPanel();
		//JSplitPane paramBuild = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JLabel labelNbBuild = new JLabel("Number of Buildings");
		nbBuild = new JTextField("10",10);
		paramBuild.add(labelNbBuild);
		paramBuild.add(nbBuild);
		parameters.add(paramBuild);
		*/
		JPanel paramBlocks = new JPanel();
		//JSplitPane paramBlocks = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JLabel labelNbBlocks = new JLabel("Number of Blocks");
		nbBlocks= new JTextField("5",10);
		paramBlocks.add(labelNbBlocks);
		paramBlocks.add(nbBlocks);
		parameters.add(paramBlocks);
		
		JPanel paramStreetWidth = new JPanel();
		//JSplitPane paramStreetWidth = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JLabel labelStreetWidth = new JLabel("Width of the streets");
		streetWidth= new JTextField("20",10);
		paramStreetWidth.add(labelStreetWidth);
		paramStreetWidth.add(streetWidth);
		parameters.add(paramStreetWidth);
		
		radioButtonIn.addActionListener(this);
		radioButtonIn.setActionCommand("In");
		radioButtonOut.setActionCommand("Out");
		radioButtonOut.addActionListener(this);
		JPanel inOut = new JPanel();
		inOut.add(radioButtonIn,"South");
		inOut.add(radioButtonOut,"South");
		
		parameters.add(inOut,"South");
		
		JButton jButtonStart = new JButton("start");
		parameters.add(jButtonStart);
		jButtonStart.addActionListener(this);	
		
                int intNbBlocks = Integer.parseInt(nbBlocks.getText());
                //int intNbBuild = Integer.parseInt(nbBuild.getText());
                int intStreetWidth = Integer.parseInt(streetWidth.getText());
		//manGrid = new Grid(Integer.parseInt(nbBlocks.getText()),Integer.parseInt(nbBuild.getText()),Integer.parseInt(streetWidth.getText()));
                manGrid = new Grid(intNbBlocks,intStreetWidth,1000,200,this.iO);
		//manGrid = new Grid(intNbBlocks,intNbBuild,intStreetWidth);
                main.setResizeWeight(0.1);
		main.setDividerLocation(300);
		main.add(parameters);
		
		main.add(manGrid);
		
		add(main);
		setVisible(true);
                
                //manGridProcess = new GridProcess(manGrid,iO,253,302);
		
		//System.out.println("process = "+manGridProcess.getStateProcess());
		
		
	}
}
