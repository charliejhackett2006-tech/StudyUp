import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;


public class StudyUpGUI extends JFrame implements ActionListener{
	
	private JTextField nameField;
	private JTextField emailField;
	private JTextField courseField;
	
	private JTextField moduleField;
	private JButton addModuleButton;
	private JButton removeModuleButton;
	
	
	private JButton createButton;
	private JButton viewButton;
	
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
        
        formPanel.add(new JLabel(""));
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
        
        JPanel bottomPanel = new JPanel(new GridLayout(0, 1));
        JPanel viewPanel = new JPanel(new FlowLayout());
        viewButton = new JButton("View Profile");
        viewButton.addActionListener(this);
        viewPanel.add(viewButton);
        bottomPanel.add(viewPanel);
        add(bottomPanel, BorderLayout.SOUTH);
        
        JPanel modulePanel = new JPanel(new FlowLayout());
        moduleField = new JTextField(10);
        addModuleButton = new JButton("Add Module");
        addModuleButton.addActionListener(this);
        
        modulePanel.add(new JLabel("Module:"));
        modulePanel.add(moduleField);
        modulePanel.add(addModuleButton);
        
        removeModuleButton = new JButton("Remove Module");
        removeModuleButton.addActionListener(this);
        modulePanel.add(removeModuleButton);
        bottomPanel.add(modulePanel);
        
        
        
        setVisible(true);
	}
	
	private void refreshList() {
		studentListDisplay.setListData(studentList.toArray(new Student[0]));
		setTitle("StudyUp ("+studentList.size()+" students)");
	}
	private Student findByEmail(String email) {
	    for (Student s : studentList) {
	        if (s.getEmail().equalsIgnoreCase(email)) {
	            return s;
	        }
	    }
	    return null;
	}

	private Student getSelectedStudent() {
	    Student selected = studentListDisplay.getSelectedValue();
	    if (selected == null) {
	        JOptionPane.showMessageDialog(this, "Select a student first.");
	    }
	    return selected;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == createButton) {
	        String name = nameField.getText().trim();
	        String email = emailField.getText().trim();
	        String course = courseField.getText().trim();
	        
	        if (name.isEmpty() || email.isEmpty() || course.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Fill out all details please.");
	            return;
	        }
	        if (findByEmail(email) != null) {
	            JOptionPane.showMessageDialog(this, "An account with that email already exists.");
	            return;
	        }

	        Student student = new Student(name, email, course);
	        studentList.add(student);
	        refreshList();

	        nameField.setText("");
	        emailField.setText("");
	        courseField.setText("");
	    }if (e.getSource() == viewButton) {
	        Student selected = getSelectedStudent();
	        if (selected == null) {
	            return;
	        }
	        profileArea.setText(selected.getProfileText());
	    }if  (e.getSource() == addModuleButton) {
	        Student selected = getSelectedStudent();
	        if (selected == null) {
	            return;
	        }

	        String module = moduleField.getText().trim().toUpperCase();
	        if (module.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Enter a module code.");
	            return;
	        }
	        if (selected.getModules().contains(module)) {
	            JOptionPane.showMessageDialog(this, "That module is already added.");
	            return;
	        }

	        selected.addModule(module);
	        moduleField.setText("");
	        profileArea.setText(selected.getProfileText());
	    }if (e.getSource() == removeModuleButton) {
	        Student selected = getSelectedStudent();
	        if (selected == null) {
	            return;
	        }

	        String module = moduleField.getText().trim().toUpperCase();
	        if (selected.removeModule(module)) {
	            moduleField.setText("");
	            profileArea.setText(selected.getProfileText());
	        } else {
	            JOptionPane.showMessageDialog(this, "That student doesn't have that module.");
	        }
	    }
	    
	}
	public static void main (String[] args) {
		new StudyUpGUI();
	}
}

