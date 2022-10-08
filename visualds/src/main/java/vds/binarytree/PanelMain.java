package vds.binarytree;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import vds.interfaces.DrawableBinaryTree;

public class PanelMain extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton bt_zoom_in;
	private JButton bt_zoom_out;
	private PanelTree panelTree;
	private JScrollPane sp;
	
	private DrawableBinaryTree dbt;
	
	public PanelMain(DrawableBinaryTree dbt) {
		super();
		this.dbt = dbt;
		makeUIElements();
		makePanel();
	}

	private void makeUIElements() {
		this.bt_zoom_in = new JButton();
		bt_zoom_in.setText(" Zoom Out ");
		this.bt_zoom_out = new JButton();
		bt_zoom_out.setText(" Zoom In ");
		this.panelTree = new PanelTree(dbt);
		this.sp = new JScrollPane(panelTree);
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	}

	private void makePanel() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx = gc.gridy = 0;
		gc.weightx = gc.weighty = 10;
		gc.gridwidth = 20;
		gc.fill = GridBagConstraints.BOTH;
		this.add(sp, gc);
		
		gc.gridwidth = 1;
		gc.gridy++;
		gc.weighty = 0;
		this.add(bt_zoom_in, gc);
		gc.gridx++;
		this.add(bt_zoom_out, gc);
		gc.gridx++;
		for(int i=0; i<18; i++){
			this.add(new JLabel(""), gc);
			gc.gridx++;
		}
		
	}
	

}
