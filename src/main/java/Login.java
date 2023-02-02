//import required classes and packages  
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;

//create CreateLoginForm class to create login form  
//class extends JFrame to create a window where our component add  
//class implements ActionListener to perform an action on button click  
class Login extends JFrame implements ActionListener
{
    //initialize button, panel, label, and text field  
    JButton b1;
    private Container c;
    private JLabel dob1;
    private JLabel dob2;
    private JTextField name;
    private JPasswordField password;

    //calling constructor  
    Login()
    {
        c = getContentPane();
        c.setLayout(null);
        this.setTitle("Logowanie");
        setBounds(750, 450, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);

        dob1 = new JLabel("Nazwa użytkownika: ");
        dob1.setFont(new Font("Arial", Font.PLAIN, 15));
        dob1.setSize(200, 30);
        dob1.setLocation(10, 10);
        c.add(dob1);

        name = new JTextField(15);
        name.setFont(new Font("Arial", Font.PLAIN, 15));
        name.setSize(200, 20);
        name.setLocation(170, 15);
        c.add(name);

        dob2 = new JLabel("Hasło: ");
        dob2.setFont(new Font("Arial", Font.PLAIN, 15));
        dob2.setSize(200, 30);
        dob2.setLocation(10, 30);
        c.add(dob2);

        password = new JPasswordField(15);
        password.setFont(new Font("Arial", Font.PLAIN, 15));
        password.setSize(200, 20);
        password.setLocation(170, 35);
        c.add(password);


        //create submit button  
        b1 = new JButton("Zaloguj się"); //set label to button
        b1.setSize(200, 20);
        b1.setLocation(90, 65);
        //perform action on button click   
        b1.addActionListener(this);     //add action listener to button
        c.add(b1);
        getRootPane().setDefaultButton(b1);
    }

    //define abstract method actionPerformed() which will be called on button click   
    public void actionPerformed(ActionEvent ae)     //pass action listener as a parameter  
    {
        String userValue = name.getText();        //get user entered username from the textField1
        String passValue = password.getText();        //get user entered password from the textField2

        //check whether the credentials are authentic or not  
        if (userValue.equals("admin") && passValue.equals("admin")) {  //if authentic, navigate user to a new page

            frame newFrame = new frame();
            this.dispose();
        }
        else{
            //show error message  
            System.out.println("Please enter valid username and password");
        }
    }
}  