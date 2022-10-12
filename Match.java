import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Match extends JFrame implements ActionListener{
	//JOptionPane.showMessageDialog(buttonSource, after);

	JPanel gamepanel;
	//The game should choose random numbers between 1 to 9 . 
	String[] RandomNumber = {"9", "8","7","6", "5","4","3","2","1"};
	/*24 buttons are divided into 8 groups. Every group is having 3 members of the same name.
	 *                                      Group 1= 7,7,7
	 *                                      Group 2= 6,6,6
	 *                                      Group 3= 5,5,5
	 *                                      Group 4= 4,4,4
	 *                                      Group 5= 3,3,3
	 *                                      Group 6= 2,2,2
	 *                                      Group 7= 1,1,1
	 *                                      Group 8= 0,0,0
	 *                                      
	 */

	Integer[] Buttons= {7,7,7,6,6,6,5,5,5,4,4,4,3,3,3,2,2,2,1,1,1,0,0,0};

	//One colour is displayed for one group. All the buttons of same group will display same colour.

	Color[] GroupColor = {Color.blue, Color.red, Color.green, Color.yellow, Color.orange, Color.black, Color.pink, Color.cyan};
	//Creating ArrayLists for using throughout the game.
	List<String> RandomNumberList;
	List<Integer> ButtonsList;
	List<Integer> LastUsedButton = new ArrayList<Integer>();
	List<Integer> AllUsedButton= new ArrayList<Integer>();
	List<JButton> MatchButtonList = new ArrayList<JButton>();

	public Match() {

		gamepanel = new JPanel();
		//add gamepanel in the JFrame.	
		add(gamepanel);
		/*Instead of creating 24 buttons manually, they are created using the for loop.
		 * All the buttons are having the same name as they have the same functionality.
		 * Instead of using 24 different buttons we can use one button only.
		 */
		for(int k= 0; k<24;k++) {
			JButton MatchButton = new JButton("");
			MatchButton.setName(String.valueOf(k));
			// add the button on the gamepanel

			gamepanel.add(MatchButton);
			MatchButtonList.add(MatchButton);
			MatchButton.addActionListener(this);


		}
		//Set panel layout, colour and make visible.
		gamepanel.setLayout(new GridLayout(4,5));
		gamepanel.setVisible(true);
		gamepanel.setBackground(Color.gray);
		RandomNumberList = Arrays.asList(RandomNumber);
		ButtonsList = Arrays.asList(Buttons);
		//For choosing random numbers from RandonNumberList and random button groups from ButtonList using shuffle.
		Collections.shuffle(RandomNumberList);
		Collections.shuffle(ButtonsList);


	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub



		JFrame Match = new Match();

		Match.setTitle("Match Game!");
		Match.setSize(500, 500);
		Match.setLocation(30, 300);
		Match.setVisible(true);
		Match.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	


	}



	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated meSystem.out.println(s);

		JButton OriginButton = (JButton) e.getSource();
		Integer thisbutton = Integer.parseInt(OriginButton.getName());
		//Continue do-while loop until all the 24 tiles are matched. 
		do {
			//
			if (!AllUsedButton.contains(thisbutton)) {
				int ButtonGroup=ButtonsList.get(thisbutton);
				LastUsedButton.add(thisbutton);
				AllUsedButton.add(thisbutton);
				String ButtonName =RandomNumberList.get(ButtonGroup);
				Color ButtoColour = GroupColor[ButtonGroup];
				OriginButton.setOpaque(true);
				OriginButton.setBackground(ButtoColour);
				OriginButton.setText(ButtonName);
				//Take 3 tiles or buttons together to compare while LastUsedButton length is 3.
				if(LastUsedButton.size()==3) {

					if(!(ButtonsList.get(LastUsedButton.get(0)).equals(ButtonsList.get(LastUsedButton.get(1))) && ButtonsList.get(LastUsedButton.get(1)).equals(ButtonsList.get(LastUsedButton.get(2)))))

					{ for (int count=0; count<3;count++) {
						MatchButtonList.get(LastUsedButton.get(count)).setBackground(new JButton().getBackground());
						MatchButtonList.get(LastUsedButton.get(count)).setText("");
						//Remove the unmatched buttons. Otherwise the buttons will not be deleted. 
						AllUsedButton.remove(Integer.valueOf(LastUsedButton.get(count)));
					}
					//Show massage when three colours are not matched. 
					JOptionPane.showMessageDialog(OriginButton, "not matched");

					}
					LastUsedButton = new ArrayList<Integer>();
					//Show time in console.
					long before = System.currentTimeMillis();
					long after = System.currentTimeMillis();
					long x=(after/1000);
					System.out.println(x);
				}


			}


		}while(LastUsedButton.size()>24);

	}

}







