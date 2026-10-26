import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class StudyUpGUI extends JFrame implements ActionListener{
	
	private JTextField nameField;
	private JTextField emailField;
	private JTextField moduleField;
	
	private JButton createButton;
	
	private JList<Student> studentListDisplay;
	private JTextArea profileArea;
	
	private ArrayList<Student> studentList;
	
	public StudyUpGUI() {
		super("StudyUp");
		setSize(700, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        studentList = new ArrayList<>();
        
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 6, 6));
        
        nameField = new JTextField();
        emailField = new JTextField();
        moduleField = new JTextField();
        
        formPanel.add(new JLabel("Name: "));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Email: "));
        formPanel.add(emailField);
        formPanel.add(new JLabel("Module: "));
        formPanel.add(moduleField);
        
        createButton = new JButton("Create Account");
        createButton.addActionListener(this);
        formPanel.add(createButton);
        
        studentListDisplay = new JList<>();
        profileArea = new JTextArea();
        profileArea.setEditable(false);
        
        JPanel centerPanel = new JPanel(new GridLayout(1,2,6,6));
        centerPanel.add(new JScrollPane(studentListDisplay));
        centerPanel.add(new JScrollPane(profileArea));
        
        add(formPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        
        setVisible(true);
	}
	@Override
	public void actionPreformed(ActionEvent e) {
	}
	public static void main (String[] args) {
		new StudyUpGUI();
	}
	
}
