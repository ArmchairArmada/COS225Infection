package cos225.project6.controller;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import cos225.project6.math.Rand;
import cos225.project6.gui.LineGraph;
import cos225.project6.infection.InfectedTurtle;
import cos225.project6.infection.InfectionData;
import cos225.project6.simview.SwingWorld;
import cos225.project6.turtle.Turtle;

/**
 * The main window of the Infected Turtle application 
 * 
 * @author Nathan
 *
 */
public class SwingInfectedTurtleController extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private boolean running = false;
	private boolean justReset = true;
	private InfectionData infectionData;
	private JToggleButton btnStartStop;
	private JFormattedTextField txtPopulation;
	private JFormattedTextField txtInfected;
	private JFormattedTextField txtHealTime;
	private JFormattedTextField txtHealRand;
	private JFormattedTextField txtRandTurn;
	private JFormattedTextField txtStepSize;
	private LineGraph graph;
	private SwingWorld world;

	private JFormattedTextField txtContagious;

	/**
	 * A while big pile of mess for controls and stuff.
	 */
	SwingInfectedTurtleController() {
		infectionData = new InfectionData();
		
		setTitle("Project 6 - Infected Turtles");
		
		// Outer top and bottom
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		// Top Space
		add(Box.createRigidArea(new Dimension(0,5)));
		
		// Top part
		JPanel pnlTop = new JPanel();
		pnlTop.setLayout(new BoxLayout(pnlTop, BoxLayout.X_AXIS));
		add(pnlTop);
		
		// Space between top and bottom
		add(Box.createRigidArea(new Dimension(0,5)));
		
		// Top Left Space
		pnlTop.add(Box.createRigidArea(new Dimension(5,0)));
		
		// The Turtle world simulation
		world = new SwingWorld(51, 10, 16);
		pnlTop.add(world);
		
		// Space between World and Controls
		pnlTop.add(Box.createRigidArea(new Dimension(5,0)));
		
		// User input controls
		JPanel pnlControls = new JPanel();
		pnlControls.setPreferredSize(new Dimension(200,510));
		pnlControls.setLayout(new GridLayout(16, 1, 5, 5));
		
		// Start / Running / Paused button
		btnStartStop = new JToggleButton("Start");
		btnStartStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				running = !running;
				if (running) {
					// Just Started
					btnStartStop.setText("Running");
					setControlsEnabled(false);
					
					if (justReset)
						configureSimulation();
					startSimulation();
				} else {
					// Paused
					btnStartStop.setText("Paused");
					stopSimulation();
				}
			}
		});
		pnlControls.add(btnStartStop);
		
		// Reset button
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				running = false;
				justReset = true;
				btnStartStop.setSelected(false);
				btnStartStop.setText("Start");
				setControlsEnabled(true);
				graph.reset();
				world.reset();
			}
		});
		pnlControls.add(btnReset);
		
		// Population size
		JLabel lblPopulation = new JLabel("Population Size");
		lblPopulation.setVerticalAlignment(JLabel.BOTTOM);
		pnlControls.add(lblPopulation);
		
		txtPopulation = new JFormattedTextField();
		txtPopulation.setValue(new Integer(300));
		pnlControls.add(txtPopulation);
		
		// Start infected chance
		JLabel lblInfected = new JLabel("Start Infected Chance (0-100)");
		lblInfected.setVerticalAlignment(JLabel.BOTTOM);
		pnlControls.add(lblInfected);
		
		txtInfected = new JFormattedTextField();
		txtInfected.setValue(new Double(10.0));
		pnlControls.add(txtInfected);
		
		// Infection contagious chance
		JLabel lblContagious = new JLabel("Infection Chance (0-100)");
		lblInfected.setVerticalAlignment(JLabel.BOTTOM);
		pnlControls.add(lblContagious);
		
		txtContagious = new JFormattedTextField();
		txtContagious.setValue(new Double(100.0));
		pnlControls.add(txtContagious);
		
		// Amount of time to heal
		JLabel lblHealTime = new JLabel("Healing Time (seconds)");
		lblHealTime.setVerticalAlignment(JLabel.BOTTOM);
		pnlControls.add(lblHealTime);
		
		txtHealTime = new JFormattedTextField();
		txtHealTime.setValue(new Double(1));
		pnlControls.add(txtHealTime);
		
		// Additional random time for healing
		JLabel lblHealRand = new JLabel("Healing Random (seconds)");
		lblHealRand.setVerticalAlignment(JLabel.BOTTOM);
		pnlControls.add(lblHealRand);
		
		txtHealRand = new JFormattedTextField();
		txtHealRand.setValue(new Double(0.25));
		pnlControls.add(txtHealRand);
		
		// Turtle's movement speed
		JLabel lblStepSize = new JLabel("Turtle Speed (pix/sec)");
		lblStepSize.setVerticalAlignment(JLabel.BOTTOM);
		pnlControls.add(lblStepSize);
		
		txtStepSize = new JFormattedTextField();
		txtStepSize.setValue(new Double(100.0));
		pnlControls.add(txtStepSize);
		
		// Turtle's random rotation amount
		JLabel lblRandTurn = new JLabel("Turtle Turn (deg/sec)");
		lblRandTurn.setVerticalAlignment(JLabel.BOTTOM);
		pnlControls.add(lblRandTurn);
		
		txtRandTurn = new JFormattedTextField();
		txtRandTurn.setValue(new Double(1000));
		pnlControls.add(txtRandTurn);
		
		pnlTop.add(pnlControls);
		
		// Top Right Space
		pnlTop.add(Box.createRigidArea(new Dimension(5,0)));
		
		// Graph
		JPanel pnlBottom = new JPanel();
		pnlBottom.setLayout(new BoxLayout(pnlBottom, BoxLayout.X_AXIS));
		add(pnlBottom);
		
		// Bottom Left Space
		pnlBottom.add(Box.createRigidArea(new Dimension(5,0)));
		
		// Infected percentage line graph
		graph = new LineGraph(infectionData.getSharedInfectedPercent(), 200, 100);
		graph.setPreferredSize(new Dimension(1, 150));
		pnlBottom.add(graph);
		pnlBottom.add(Box.createRigidArea(new Dimension(5,0)));
		
		// Bottom Right Space
		add(Box.createRigidArea(new Dimension(0,5)));
		
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				graph.stop();
				world.stop();
				System.exit(0);
			}
		});
	}
	
	/**
	 * Enable or disable controls on the gui 
	 * 
	 * @param value  If they should be enabled or disabled
	 */
	private void setControlsEnabled(boolean value) {
		txtPopulation.setEnabled(value);
		txtInfected.setEnabled(value);
		txtHealTime.setEnabled(value);
		txtHealRand.setEnabled(value);
		txtRandTurn.setEnabled(value);
		txtStepSize.setEnabled(value);
		txtContagious.setEnabled(value);
	}
	
	/**
	 * Sets up the simulation with the current configuration options
	 */
	private void configureSimulation() {
		justReset = false;
		
		infectionData.setPopulation((Integer)txtPopulation.getValue());
		infectionData.setInfected(0);
		
		// Newly configured prototype for infected turtle
		InfectedTurtle proto = new InfectedTurtle(
				world,
				infectionData,
				world.getCollisionSystem(),
				(Double)txtRandTurn.getValue(),
				(Double)txtStepSize.getValue(),
				(Double)txtInfected.getValue()/100.0,
				(Double)txtContagious.getValue()/100.0,
				(Double)txtHealTime.getValue(),
				(Double)txtHealRand.getValue()
				);
		world.getProtoCopier().regiseter("Turtle", proto);
		
		// Populate the world
		for (int i =0; i < (Integer)txtPopulation.getValue(); i++) {
			Turtle t = (Turtle) world.getProtoCopier().makeCopy("Turtle");
			t.setx(Rand.getRandom().nextDouble() * world.getWidth());
			t.sety(Rand.getRandom().nextDouble() * world.getHeight());
			t.setHeading(Rand.getRandom().nextDouble() * 360);
			
			world.getPopulation().add(t);
		}
	}
	
	/**
	 * Start the simulation
	 */
	private void startSimulation() {
		world.start();
		graph.start();
	}
	
	/**
	 * Stop the simulation
	 */
	private void stopSimulation() {
		world.stop();
		graph.stop();
	}
	
	/**
	 * Get it started.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				SwingInfectedTurtleController controller = new SwingInfectedTurtleController();
				controller.setVisible(true);
			}
		});
	}
}
