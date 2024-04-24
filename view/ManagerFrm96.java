// ManagerFrm96.java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerFrm96 extends JFrame {
    private JButton btnCustomerSearchMenu;

    public ManagerFrm96() {
        setTitle("Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        btnCustomerSearchMenu = new JButton("Customer Search Menu");
        btnCustomerSearchMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCustomerSearchForm();
            }
        });

        getContentPane().add(btnCustomerSearchMenu);
    }

    private void openCustomerSearchForm() {
        CustomerSearchFrm96 customerSearchFrm96 = new CustomerSearchFrm96();
        customerSearchFrm96.setVisible(true);
    }

    public static void main(String[] args) {
        ManagerFrm96 managerFrm96 = new ManagerFrm96();
        managerFrm96.setVisible(true);
    }
}