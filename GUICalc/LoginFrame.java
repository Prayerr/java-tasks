import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    public LoginFrame() {
        setTitle("Вход в систему");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Имя пользователя:"), gbc);

        gbc.gridx = 1;
        usernameField = new JTextField(15);
        panel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Пароль:"), gbc);

        gbc.gridx = 1;
        passwordField = new JPasswordField(15);
        panel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        loginButton = new JButton("Войти");
        registerButton = new JButton("Регистрация");
        
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);
        
        panel.add(buttonPanel, gbc);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            
            if (username.equals("admin") && password.equals("admin")) {
                JOptionPane.showMessageDialog(this, "Вход выполнен успешно!");
                openMainApplication();
            } else {
                JOptionPane.showMessageDialog(this, "Неверное имя пользователя или пароль!");
            }
        });

        registerButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Функция регистрации в разработке");
        });

        add(panel);
    }

    private void openMainApplication() {
        Calculator calc = new Calculator();
        calc.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
        });
    }
} 