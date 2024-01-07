/**
 * The ATM class - An ATM interface.
 * @author (Khurram Ahmed)
 * @date (Due: 30 Nov, 2023)
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
public class ATM
{
    private Bank bank;
    private String user;
    private JFrame frame;
    /**
     * Constructor for objects of class ATM
     */
    public ATM(String user)
    {
        this.user = user;
        createBankInfor();
        makeFrame();        
    }
    
    private void createBankInfor(){
        //test example
        bank = new Bank("Canada");
        bank.add(new Saving(user));
        bank.add(new Saving(user));
        bank.add(new Cheque(user));
        bank.add(new Cheque(user));
    }
    
    /**
     * Create the frame     
     */
    private void makeFrame()
    { 
        frame = new JFrame("ATM");
        Container contentPane = frame.getContentPane();        
        makeMenuBar(frame);        
        listAccounts();        
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Create the MenuBa     
     */
    
    private void makeMenuBar(JFrame frame)
    {
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        JMenu menu;
        JMenuItem item;        
        // create the Account menu
        menu = new JMenu("Accounts");
        menubar.add(menu);
        item = new JMenuItem("All Accounts...");
        item.addActionListener(e -> listAccounts());
        menu.add(item);
        
        //Q1. add a Checking menu item and its listener
        //your code goes here...
        item = new JMenuItem("Checking...");
        item.addActionListener(e -> listAccounts("Cheque"));
        menu.add(item);

        //Q2. add a Saving menu item and its listener   
        //your code goes here...  
        item = new JMenuItem("Saving...");
        item.addActionListener(e -> listAccounts("Saving"));
        menu.add(item);

        menu = new JMenu("File");
        menubar.add(menu);
        item = new JMenuItem("Open");
        item.addActionListener(e -> openFile());
        menu.add(item);
        // Save menu item
        item = new JMenuItem("Save");
        item.addActionListener(e -> saveFile());
        menu.add(item);
        
        // create the Help menu
        menu = new JMenu("Help");
        menubar.add(menu);  
        item = new JMenuItem("About...");
        item.addActionListener(e -> about());
        menu.add(item);        
        item = new JMenuItem("Exit...");
        menu.add(item);  
        item.addActionListener(e -> System.exit(0));

    }
    
    private void listAccounts(String accType)   
    {
        JPanel contentPane = (JPanel) frame.getContentPane();
        contentPane.removeAll();
        
        // Presentable Layout:
        JPanel flow1 = new JPanel(new FlowLayout()); 
        flow1.setBackground(Color.LIGHT_GRAY);
        flow1.add(new JLabel("Bank Name: "+ bank.getBankName()));
        JPanel flow2 = new JPanel(new FlowLayout()); 
        flow2.add(new JLabel("The Accounts of \"" + user + "\" are:"));
        flow2.setBackground(Color.LIGHT_GRAY);
        contentPane.add(flow2, BorderLayout.NORTH);
        contentPane.add(flow1, BorderLayout.SOUTH);
        
        JPanel grid = new JPanel(new GridLayout(0, 6, 4, 4)); 
        
        for(Account acc:bank.getAccounts(user))
        {
            if (!accType.equals(acc.getClass().getName())){
                continue;
            }
            drawAccount(acc, grid);
        }
        contentPane.add(grid, BorderLayout.CENTER);
        
        frame.pack();
        frame.setVisible(true);
    }
    
    private void listAccounts()   
    {
        JPanel contentPane = (JPanel) frame.getContentPane();
        contentPane.removeAll();
        
        // Presentable Layout:
        JPanel flow1 = new JPanel(new FlowLayout()); 
        flow1.setBackground(Color.LIGHT_GRAY);
        flow1.add(new JLabel("Bank Name: "+ bank.getBankName()));
        JPanel flow2 = new JPanel(new FlowLayout()); 
        flow2.add(new JLabel("The Accounts of \"" + user + "\" are:"));
        flow2.setBackground(Color.LIGHT_GRAY);
        contentPane.add(flow2, BorderLayout.NORTH);
        contentPane.add(flow1, BorderLayout.SOUTH);
        
        JPanel grid = new JPanel(new GridLayout(0, 6, 4, 4)); 
        
        for(Account acc:bank.getAccounts(user)){
            drawAccount(acc, grid);
        }
        contentPane.add(grid, BorderLayout.CENTER);
       
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * Open's File through FileManager Class
     */
    private void openFile()
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Open Bank File");
        FileManager fileReader = new FileManager();
        

        int result = fileChooser.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) 
        {
            File selectedFile = fileChooser.getSelectedFile();
            bank = fileReader.read(selectedFile.getAbsolutePath());
            listAccounts(); // Update the view to reflect the loaded data 
        }
    }
    
    /**
     * Save's File through FileManager Class
     */
    private void saveFile() 
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Bank File");
        FileManager fileWriter = new FileManager();

        int result = fileChooser.showSaveDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) 
        {
            File selectedFile = fileChooser.getSelectedFile();
            fileWriter.write(selectedFile.getAbsolutePath(), bank);
        }
    }
    
    /**
     * Draw each account on the panel
     */
    private void drawAccount(Account acc, JPanel contentPane)
    {
        JLabel label1 = new JLabel(acc.getClass().getName());
        contentPane.add(label1);
        
        
        //Q3. adding account number using a JLabel
        //your code goes here ...       
        
        JLabel label2 = new JLabel("Account: "+ Integer.toString(acc.getAccountNo()) + " ");
        label2.setBackground(Color.white);
        contentPane.add(label2);
        
        //Add a JTestField field for displaying balance value
        JLabel label3 = new JLabel("Balance: ");
        label3.setBackground(Color.white);
        contentPane.add(label3);
        //Add a JTestField field for displaying balance value
        JTextField tf1 = new JTextField(Float.toString(acc.getBalance()));       
        tf1.setBackground(Color.WHITE);
        contentPane.add(tf1);
        tf1.setEditable(false);

        //Add Deposit button and its listener
        JButton bDeposit = new JButton("Deposit");
        bDeposit.setBackground(Color.ORANGE);
        contentPane.add(bDeposit);
        //add event listener to the button, to pop up a dialog taking input
        bDeposit.addActionListener(
            ev->{String s = JOptionPane.showInputDialog("Input money: ",0);
                acc.deposit(s==null?0:Float.parseFloat(s));
                tf1.setText(Float.toString(acc.getBalance()));});
        
        //Q4. Add Withdraw button and its listener
        //your code goes here ...
        JButton bWithdraw = new JButton("Withdraw");
        bWithdraw.setBackground(Color.cyan);
        contentPane.add(bWithdraw);
        //add event listener to the button, to pop up a dialog taking input
        bWithdraw.addActionListener(
            ev->{String s = JOptionPane.showInputDialog("Input money: ",0);
                acc.withdraw(Float.parseFloat(s));
                tf1.setText(Float.toString(acc.getBalance()));});
        
    }

    private void about()
    {
        Container contentPane = frame.getContentPane();
        contentPane.removeAll();
        JPanel flow1 = new JPanel(new FlowLayout()); 
        JLabel label1 = new JLabel(user + "@" +bank.getBankName());
        flow1.add(label1);
        contentPane.add(flow1, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }    
}
