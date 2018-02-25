package views;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.Actions;
import controller.Controller;

public class MenuBar extends JMenuBar{
	private static final long serialVersionUID = 1L;
	private JMenuItem addPerson;
	
	public MenuBar(Controller controller) {
		JMenu menuPerson = new JMenu("Add");
		
		addPerson = new JMenuItem("Add new Person");
		addPerson.setActionCommand(Actions.ADD_PERSON.toString());
		addPerson.addActionListener(controller);
		
		
		menuPerson.add(addPerson);
		add(menuPerson);
	}
}
