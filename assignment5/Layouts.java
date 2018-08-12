package layoutTut;

import java.awt.*;
import javax.swing.*;

public class Layouts extends JApplet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9128906613966095782L;

	public void init(){
		gridBagLayout();
	}
	
	public void flowLayout(){
		
		setLayout(new FlowLayout());
		add(new Button("1"));
		add(new Button("2"));
		add(new Button("3"));
		add(new Button("4"));
		add(new Button("5"));
		
		/*Another way
		 Container BG = getContentPane();
		 FlowLayout lay = new FlowLayout(); //BorderLayout lay = new BorderLayout();
		 BG.setLayout(lay);
		 BG.add(new Button("1"));
		 BG.add(new Button("2"));
		 BG.add(new Button("3"));*/
		  
	}
	
	public void borderLayout(){
		
		setLayout(new BorderLayout());
		add(new Button("Center"), BorderLayout.CENTER);
		add(new Button("North"), BorderLayout.NORTH);
		add(new Button("South"), BorderLayout.SOUTH);
		add(new Button("East"), BorderLayout.EAST);
		add(new Button("West"), BorderLayout.WEST);
		
	}
	
	public void cardLayout(){
		Panel cards = new Panel();
		CardLayout DECK = new CardLayout();
		cards.setLayout(DECK);
		
		cards.add(new Button("Ace of Hearts"), "Ace");
		cards.add(new Button("Two of Hearts"), "Deuce");
		cards.add(new Button("Three of Hearts"), "Three");
		
		DECK.show(cards, "Ace");//can write deuce instead of ace etc
		//DECK.first(cards);
		
		add(cards);
	}
	
	public void gridLayout(){
		
		setLayout(new GridLayout(0, 1));
		add(new Button("ATTACK"));
		add(new Button("DEFEND"));
		add(new Button("USE"));
		add(new Button("NAVIGATE"));
		add(new Button("ABILITY"));
	}
	
	public void gridBagLayout(){
		
		JButton SelfDestruct = new JButton("Self Destruct");
		JButton Abort = new JButton("Abort");
		
		Container BG = getContentPane();
		BG.setLayout(new GridBagLayout());
		GridBagConstraints CONSTRAINTS = new GridBagConstraints();
		
		CONSTRAINTS.fill = GridBagConstraints.HORIZONTAL;
		CONSTRAINTS.weightx = 0.5;
		CONSTRAINTS.weighty = 1.0;
		
		CONSTRAINTS.gridy = 0;
		CONSTRAINTS.ipady = 0;
		CONSTRAINTS.gridwidth = 2;
		CONSTRAINTS.anchor = GridBagConstraints.PAGE_END;
		CONSTRAINTS.insets = new Insets(10, 0, 0, 0);
		
		BG.add(SelfDestruct,CONSTRAINTS);
		BG.add(Abort,CONSTRAINTS);
		
	}

}
