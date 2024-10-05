
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

 public class LibraryAppV2 extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardLayout);
    private JPanel homePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 30));
    private JPanel addBookPanel = new JPanel(new FlowLayout());
    private JPanel viewBooksPanel = new JPanel(new FlowLayout());

    private DefaultListModel<String> listModel;
    private JList<String> bookList;
    private JPanel booksContainer;

    // Book data simulation
    private String[][] booksData = {
            {"Magic Bites", "Illona Andrews", "345678", "Available", "/Users/sukruthianilkumar/Documents/SVVT Spring 24/Kate-Daniels.png"},
            {"The Day of the Duchess", "Sarah MacLean", "123456", "Checked Out", "/Users/sukruthianilkumar/Documents/SVVT Spring 24/The-dotd.png"},
            {"Verification, Validation and Testing in Software Engineering", "Aristides Dasso", "678901", "Available", "/Users/sukruthianilkumar/Documents/SVVT Spring 24/svvt-textbook.png"}
    };

    public LibraryAppV2() {
        setTitle("Library Management System V2");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setupHomePanel();
        setupAddBookPanel();
        setupViewBooksPanel();

        mainPanel.add(homePanel, "Home");
        mainPanel.add(addBookPanel, "Add Book");
        mainPanel.add(viewBooksPanel, "View Books");

        add(mainPanel);
        cardLayout.show(mainPanel, "Home");
    }

    private void setupHomePanel() {
        // Set up layout to align items vertically
        homePanel.setLayout(new GridBagLayout()); //CHANGE LAYOUT
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Welcome label similar to your Tkinter app
        JLabel welcomeLabel = new JLabel("Welcome to the Library Management System V2", SwingConstants.LEFT); //CHANGE ORIENTATION
        //welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 5)); //CHANGE FONT
        homePanel.add(welcomeLabel);

        // Space between components
        homePanel.add(Box.createRigidArea(new Dimension(0, 30)));

        // Add Book Button
        JButton addButton = new JButton("Add Book");
        addButton.setPreferredSize(new Dimension(4, 4)); // CHANGE BUTTON SIZE
        addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        homePanel.add(addButton);
        addButton.addActionListener(e -> cardLayout.show(mainPanel, "Add Book"));

        // View Books Button
        JButton viewButton = new JButton("View Books");
        viewButton.setPreferredSize(new Dimension(2000, 400)); // CHANGE BUTTON SIZE
        viewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        homePanel.add(viewButton);
        viewButton.addActionListener(e -> cardLayout.show(mainPanel, "View Books"));

        // Adding image
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("/Users/sukruthianilkumar/Documents/SVVT Spring 24/book-shelf.png").getImage().getScaledInstance(600, 350, Image.SCALE_DEFAULT));
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        homePanel.add(imageLabel);
    }

    private void setupAddBookPanel() {
        addBookPanel.setLayout(new BoxLayout(addBookPanel, BoxLayout.Y_AXIS));


        // Title label
        JLabel titleLabel = new JLabel("Add Book V2");
        titleLabel.setFont(new Font("Helvetica", Font.BOLD, 100)); //CHANGE SIZE
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT); //CHANGE ORIENTATION
        addBookPanel.add(titleLabel);

        // Availability Checkbox
        JCheckBox availableCheckBox = new JCheckBox("Available"); //CHANGE LAYOUT
        addBookPanel.add(availableCheckBox);

        // Book Title Field
        JTextField titleField = new JTextField(20);
        titleField.setMaximumSize(new Dimension(Integer.MAX_VALUE, titleField.getPreferredSize().height));
        addBookPanel.add(new JLabel("Book Title:"));
        addBookPanel.add(titleField);

        // Author Name Field
        JTextField authorField = new JTextField(20);
        authorField.setMaximumSize(new Dimension(Integer.MAX_VALUE, authorField.getPreferredSize().height));
        addBookPanel.add(new JLabel("Author Name:"));
        addBookPanel.add(authorField);

        // ISBN Number Field
        JTextField isbnField = new JTextField(20);
        isbnField.setMaximumSize(new Dimension(Integer.MAX_VALUE, isbnField.getPreferredSize().height));
        addBookPanel.add(new JLabel("ISBN Number:"));
        addBookPanel.add(isbnField);



        // Genre List with Scrollbar
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Fiction");
        listModel.addElement("Non-Fiction");
        listModel.addElement("Science");
        listModel.addElement("History");
        listModel.addElement("Biography");
        listModel.addElement("Children");
        listModel.addElement("Fantasy");
        JList<String> genreList = new JList<>(listModel);
        JScrollPane listScroller = new JScrollPane(genreList);
        listScroller.setPreferredSize(new Dimension(5000, 800)); //CHANGE SIZE
        addBookPanel.add(new JLabel("Select Genre:"));
        addBookPanel.add(listScroller);

        // Submit Button
        JButton submitButton = new JButton("Submit");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        submitButton.addActionListener(e -> {
            String bookDetails = "Title: " + titleField.getText() +
                    ", Author: " + authorField.getText() +
                    ", ISBN: " + isbnField.getText() +
                    ", Available: " + availableCheckBox.isSelected() +
                    ", Genre: " + genreList.getSelectedValue();
            JOptionPane.showMessageDialog(this, "Book Submitted:\n" + bookDetails);
        });
        addBookPanel.add(submitButton);

        // to view books
        JButton vbooksButton = new JButton("View all books");
        vbooksButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        vbooksButton.addActionListener(e -> cardLayout.show(mainPanel, "View Books"));
        addBookPanel.add(vbooksButton);

        // Back to Home Button
        JButton backButton = new JButton("Back to Home");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "Home"));
        addBookPanel.add(backButton);

        // Add an image
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("/Users/sukruthianilkumar/Documents/SVVT Spring 24/checkout-book.png").getImage().getScaledInstance(300, 200, Image.SCALE_SMOOTH));
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        addBookPanel.add(imageLabel);
    }

    private void setupViewBooksPanel() {
        /*viewBooksPanel.setLayout(new BoxLayout(viewBooksPanel, BoxLayout.Y_AXIS));
        JLabel label = new JLabel("View books:");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        viewBooksPanel.add(label);*/
        viewBooksPanel.setLayout(new BorderLayout());
        JLabel label = new JLabel("View books V2:");
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        viewBooksPanel.add(label, BorderLayout.NORTH);

        // Panel to hold book entries
        booksContainer = new JPanel(new GridLayout(1, 1)); //CHANGE LAYOUT TO HORIZONTAL SCROLLBAR
        booksContainer.setLayout(new BoxLayout(booksContainer, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(booksContainer);
        viewBooksPanel.add(scrollPane, BorderLayout.CENTER);

        loadBooks("All");
/*
        // Setup radio buttons for filtering
        JPanel southPanel = new JPanel(new GridLayout(2, 1));
        JPanel radioPanel = new JPanel();
        ButtonGroup group = new ButtonGroup();
        JRadioButton allButton = new JRadioButton("All", true, );
        JRadioButton availableButton = new JRadioButton("Available");
        JRadioButton checkedOutButton = new JRadioButton("Checked Out");
        group.add(allButton);
        group.add(availableButton);
        group.add(checkedOutButton);
        radioPanel.add(allButton);
        radioPanel.add(availableButton);
        radioPanel.add(checkedOutButton);
        //viewBooksPanel.add(radioPanel, BorderLayout.SOUTH);
        southPanel.add(radioPanel);

        JPanel buttonPanel = new JPanel(); // Panel for navigation buttons
        JButton addButton = new JButton("Add Book");
        JButton homeButton = new JButton("Back to Home");
        buttonPanel.add(addButton);
        buttonPanel.add(homeButton);
        southPanel.add(buttonPanel);*/

        // Setup radio buttons for filtering
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS)); // Changed layout to BoxLayout for better control

        JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Using FlowLayout for centering
        radioPanel.setBorder(new EmptyBorder(10, 50, 10, 50)); // Adding some padding

        ButtonGroup group = new ButtonGroup();
        JRadioButton allButton = new JRadioButton("All", true);
        JRadioButton availableButton = new JRadioButton("Available");
        JRadioButton checkedOutButton = new JRadioButton("Checked Out");

        group.add(allButton);
        group.add(availableButton);
        group.add(checkedOutButton);

        radioPanel.add(allButton);
        radioPanel.add(availableButton);
        radioPanel.add(checkedOutButton);

        southPanel.add(radioPanel);

        // Optionally add size modifications
        radioPanel.setPreferredSize(new Dimension(400, 50));
        // Panel for navigation buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton addButton = new JButton("Add Book");
        JButton homeButton = new JButton("Back to Home");
        buttonPanel.add(addButton);
        buttonPanel.add(homeButton);

        // Add buttonPanel to the southPanel
        southPanel.add(buttonPanel);



        viewBooksPanel.add(southPanel, BorderLayout.SOUTH);

        allButton.addActionListener(e -> loadBooks("All"));
        availableButton.addActionListener(e -> loadBooks("Available"));
        checkedOutButton.addActionListener(e -> loadBooks("Checked Out"));

        addButton.addActionListener(e -> cardLayout.show(mainPanel, "Home")); //CHANGED NAVIGATION FLOW. GOES BACK TO HOME PAGE.
        homeButton.addActionListener(e -> cardLayout.show(mainPanel, "Home"));


    }


    private void loadBooks(String filter) {
        booksContainer.removeAll();
        for (String[] book : booksData) {
            if (filter.equals("All") || book[3].equals(filter)) {
                JPanel bookPanel = new JPanel();
                bookPanel.setLayout(new BoxLayout(bookPanel, BoxLayout.X_AXIS));
                bookPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

                // Load the image
                ImageIcon originalIcon = new ImageIcon(book[4]); // Assuming the path is correct
                Image image = originalIcon.getImage();
                Image resizedImage = image.getScaledInstance(100, 150, Image.SCALE_SMOOTH);
                ImageIcon resizedIcon = new ImageIcon(resizedImage);
                JLabel imageLabel = new JLabel(resizedIcon);
                bookPanel.add(imageLabel);

                // Add text description
                JLabel textLabel = new JLabel("<html>" + book[0] + " - " + book[1] + " (" + book[2] + ") [" + book[3] + "]</html>");
                bookPanel.add(textLabel);

                booksContainer.add(bookPanel);
            }
        }
        booksContainer.revalidate();
        booksContainer.repaint();
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LibraryAppV2().setVisible(true);
            }
        });
    }
}
