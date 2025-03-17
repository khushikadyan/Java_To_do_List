package todolist;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ElegantToDoList {

    private JFrame frame;
    private JTextField taskField;
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JButton addButton;
    private JButton removeButton;

    public ElegantToDoList() {
        // Initialize the frame
        frame = new JFrame("Elegant To-Do List");
        frame.setSize(600, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Set a background color
        frame.getContentPane().setBackground(new Color(255, 255, 255));

        // Input Panel (Task Field + Add Button)
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.setBackground(new Color(238, 238, 238)); // Light background for input panel

        taskField = new JTextField();
        taskField.setFont(new Font("Arial", Font.PLAIN, 20));
        taskField.setPreferredSize(new Dimension(600, 50)); // Increased size for task field

        addButton = new JButton("Add Task");
        addButton.setBackground(new Color(75, 181, 67)); // Green background for Add button
        addButton.setForeground(Color.WHITE);
        addButton.setFont(new Font("Arial", Font.BOLD, 20));
        addButton.setPreferredSize(new Dimension(180, 50)); // Increased size for Add button

        inputPanel.add(taskField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        // Task List Panel
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        taskList.setFont(new Font("Arial", Font.PLAIN, 16));
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some padding around the scroll

        // Remove Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(238, 238, 238)); // Matching background for button panel

        removeButton = new JButton("Remove Task");
        removeButton.setBackground(new Color(255, 59, 48)); // Red background for Remove button
        removeButton.setForeground(Color.WHITE);
        removeButton.setFont(new Font("Arial", Font.BOLD, 14));
        removeButton.setPreferredSize(new Dimension(150, 40)); // Increased size for Remove button

        buttonPanel.add(removeButton);

        // Add components to the frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Action Listener for Add Button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText().trim();
                if (!task.isEmpty()) {
                    // Adding the task with its index
                    String taskWithIndex = "Task #" + (taskListModel.getSize() + 1) + ": " + task;
                    taskListModel.addElement(taskWithIndex);
                    taskField.setText(""); // Clear the task field after adding
                }
            }
        });

        // Action Listener for Remove Button
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    taskListModel.remove(selectedIndex); // Remove the selected task
                }
            }
        });

        // Show the frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ElegantToDoList());
    }
}
