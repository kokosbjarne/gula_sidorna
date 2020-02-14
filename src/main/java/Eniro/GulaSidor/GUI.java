package Eniro.GulaSidor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GUI {

	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;
	private DefaultListModel<String> defaultListModel = new DefaultListModel<String>();
	private JTextField textFieldName;
	private JTextField textFieldNumber;
	private ImageIcon image;
	private ListSelectionModel listSelectionModel;

	ContactBook cb = new ContactBook();

	/**
	 * Konstruktor till klassen GUI som skapar en instans av Load
	 * save-klassen och där Contactbook fylls med personer från Json
	 * Konstruktorn kallar också på metoden GUI som kör GUI:t
	 */
	public GUI() {

		LoadSave ls = new LoadSave();
		cb = ls.Load();
		GUI();
	}

	/**
	 * Metoden GUI() skapar en JFrame, en JPanel läggs på där alla
	 * komponenter läggs på, DefaultListModel, JList, JScrollPane,
	 * JTextField samt JButtons för olika funktioner. Här laddas också
	 * kontakterna ur ContactBook in i DefaultListModel. 
	 */
	public void GUI() {
		mainFrame = new JFrame("Contact Book");
		mainFrame.setSize(600, 900);
		mainFrame.setLayout(new FlowLayout());
		textFieldName = new JTextField("Sök efter namn...");
		textFieldNumber = new JTextField("Sök efter telefonnummer...");

		defaultListModel = new DefaultListModel<String>();

		for (int j = 0; j < cb.p.size(); j++) {
			defaultListModel.addElement(cb.p.get(j).fname + " " + cb.p.get(j).lname + " " + cb.p.get(j).number);
		}

		image = new ImageIcon("src\\main\\java\\Eniro\\GulaSidor\\eniro.jpg");
		JLabel label = new JLabel("", image, JLabel.CENTER);
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(label, BorderLayout.CENTER);
		mainFrame.add(panel);

		JList<String> list = new JList<String>(defaultListModel);
		list.setLayoutOrientation(JList.VERTICAL);
		list.setVisibleRowCount(-1);
		JScrollPane listScroller = new JScrollPane(list);
		listScroller.setPreferredSize(new Dimension(450, 400));
		list.setFont(new java.awt.Font("Arial", Font.PLAIN, 14));

		list.setBounds(100, 100, 75, 75);
		mainFrame.add(listScroller);
		textFieldName.setPreferredSize(new Dimension(225, 30));
		textFieldNumber.setPreferredSize(new Dimension(225, 30));
		textFieldName.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
		textFieldNumber.setFont(new java.awt.Font("Arial", Font.BOLD, 14));

		list.setBackground(new Color(255, 224, 1));
		mainFrame.add(textFieldName);
		mainFrame.add(textFieldNumber);

		headerLabel = new JLabel("", JLabel.CENTER);
		statusLabel = new JLabel("", JLabel.CENTER);
		statusLabel.setSize(300, 300);

		listSelectionModel = list.getSelectionModel();
		
		/**
		 * Anonym klass där om man trycker på ett namn i ContactBook, så hamnar namn
		 * och telefonnummer i textfälten.
		 */
		listSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				textFieldName.setText(cb.p.get(listSelectionModel.getAnchorSelectionIndex()).fname + " "
						+ cb.p.get(listSelectionModel.getAnchorSelectionIndex()).lname);
				textFieldNumber.setText(cb.p.get(listSelectionModel.getAnchorSelectionIndex()).number);
				listSelectionModel.getAnchorSelectionIndex();

			}

		});

		/**
		 * Anoynym klass där om man stänger ned fönstret så stängs programmet ned.
		 */
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});

		controlPanel = new JPanel(new BorderLayout());
		controlPanel.setLayout(new FlowLayout());

		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);

		controlPanel.setBackground(new Color(255, 224, 1));
		headerLabel.setBackground(new Color(255, 224, 1));
		mainFrame.setBackground(new Color(255, 224, 1));
		statusLabel.setBackground(new Color(255, 224, 1));
		mainFrame.getContentPane().setBackground(new Color(255, 224, 1));

	}

	private void eventDemo() {

		JButton contactBook = new JButton("Contact Book");
		JButton addButton = new JButton("Add");
		JButton searchButton = new JButton("Search");
		JButton removeButton = new JButton("Remove");

		contactBook.setPreferredSize(new Dimension(120, 40));
		addButton.setPreferredSize(new Dimension(100, 40));
		searchButton.setPreferredSize(new Dimension(100, 40));
		removeButton.setPreferredSize(new Dimension(100, 40));

		contactBook.setBackground(new Color(255, 224, 1));
		addButton.setBackground(new Color(255, 224, 1));
		searchButton.setBackground(new Color(255, 224, 1));
		removeButton.setBackground(new Color(255, 224, 1));

		controlPanel.add(contactBook);
		controlPanel.add(addButton);
		controlPanel.add(searchButton);
		controlPanel.add(removeButton);

		mainFrame.setVisible(true);

//	}
//	final AddRemoveSearch ars = new AddRemoveSearch();

		textFieldName.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				textFieldName.setText("");
			}
		});

		textFieldNumber.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				textFieldNumber.setText("");
			}
		});

		/*
		 * Metod EJ KLAR, vid klick ska defaultListModel visa telefonboken igen. FÅR EJ
		 * TILL DET :(
		 */
		contactBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				defaultListModel.clear();

				for (int j = 0; j < cb.p.size(); j++) {
					defaultListModel.addElement(cb.p.get(j).fname + " " + cb.p.get(j).lname + " " + cb.p.get(j).number);
				}
				JList<String> list = new JList<String>(defaultListModel);

			}
		});
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("Du tryckte add");

				AddRemoveSearch ars = new AddRemoveSearch(cb);

				ars.Add(textFieldName.getText(), textFieldNumber.getText());
			}
		});
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {

				defaultListModel.clear();
				System.out.println("dlm.size är: " + defaultListModel.size());

				AddRemoveSearch ars = new AddRemoveSearch(cb);

				System.out.println("Du tryckte search");
				System.out.println(cb.p.size());

				ars.Search(textFieldName.getText(), textFieldNumber.getText());

				System.out.println(ars.foundpeople.size());

				for (int j = 0; j < ars.foundpeople.size(); j++) {

					defaultListModel.addElement(ars.foundpeople.get(j).fname + " " + ars.foundpeople.get(j).lname + " "
							+ ars.foundpeople.get(j).number);
				}
			}
		});
		removeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.out.println("Du tryckte remove");

				AddRemoveSearch ars = new AddRemoveSearch(cb);

				ars.Remove(textFieldName.getText(), textFieldNumber.getText());
			}
		});

	}

	public void RunGui() {
		GUI gui = new GUI();
		gui.eventDemo();
	}
}
