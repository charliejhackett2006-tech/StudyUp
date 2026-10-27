import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;


public class StudyUpGUI extends JFrame implements ActionListener{
	
	private JTextField nameField;
	private JTextField emailField;
	private JTextField courseField;
	
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
        courseField = new JTextField();
        
        formPanel.add(new JLabel("Name: "));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Email: "));
        formPanel.add(emailField);
        formPanel.add(new JLabel("Course: "));
        formPanel.add(courseField);
        
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
	
	private void refreshList() {
		studentListDisplay.setListData(studentList.toArray(new Student[0]));
		setTitle("StudyUp ("+studentList.size()+" students)");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == createButton) {
	        String name = nameField.getText().trim();
	        String email = emailField.getText().trim();
	        String course = courseField.getText().trim();

	        Student student = new Student(name, email, course);
	        studentList.add(student);
	        refreshList();

	        nameField.setText("");
	        emailField.setText("");
	        courseField.setText("");
	    }
	}
	public static void main (String[] args) {
		new StudyUpGUI();
	}
}

