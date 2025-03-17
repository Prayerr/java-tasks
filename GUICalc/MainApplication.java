import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class MainApplication extends JFrame {
    private JTabbedPane tabbedPane;
    private List<JPanel> panels;

    public MainApplication() {
        setTitle("Многофункциональное приложение");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();
        panels = new ArrayList<>();

        createCalculatorPanel();
        createSurveyPanel();
        createTasksPanel();
        createRecipesPanel();
        createComingSoonPanels();

        add(tabbedPane);
    }

    private void createCalculatorPanel() {
        JPanel calculatorPanel = new JPanel(new BorderLayout());
        Calculator calc = new Calculator();
        calculatorPanel.add(calc.getContentPane(), BorderLayout.CENTER);
        tabbedPane.addTab("Калькулятор", calculatorPanel);
    }

    private void createSurveyPanel() {
        JPanel surveyPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        surveyPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] surveys = {
            "Опрос о программировании",
            "Опрос о технологиях",
            "Опрос о предпочтениях"
        };

        for (String survey : surveys) {
            JButton button = new JButton(survey);
            button.addActionListener(e -> JOptionPane.showMessageDialog(this, 
                "Опрос: " + survey + "\nФункция в разработке"));
            surveyPanel.add(button);
        }

        tabbedPane.addTab("Опросы", surveyPanel);
    }

    private void createTasksPanel() {
        JPanel tasksPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        tasksPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] tasks = {
            "Задача 1 (Высокий приоритет)",
            "Задача 2 (Средний приоритет)",
            "Задача 3 (Низкий приоритет)",
            "Задача 4 (Высокий приоритет)",
            "Задача 5 (Средний приоритет)"
        };

        for (String task : tasks) {
            JButton button = new JButton(task);
            button.addActionListener(e -> JOptionPane.showMessageDialog(this, 
                "Задача: " + task + "\nФункция в разработке"));
            tasksPanel.add(button);
        }

        tabbedPane.addTab("Задачи", tasksPanel);
    }

    private void createRecipesPanel() {
        JPanel recipesPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        recipesPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] recipes = {
            "Рецепт 1: Борщ",
            "Рецепт 2: Пельмени",
            "Рецепт 3: Оливье",
            "Рецепт 4: Гречка",
            "Рецепт 5: Блины"
        };

        for (String recipe : recipes) {
            JButton button = new JButton(recipe);
            button.addActionListener(e -> JOptionPane.showMessageDialog(this, 
                "Рецепт: " + recipe + "\nФункция в разработке"));
            recipesPanel.add(button);
        }

        tabbedPane.addTab("Рецепты", recipesPanel);
    }

    private void createComingSoonPanels() {
        String[] comingSoon = {
            "Статистика",
            "Календарь",
            "Заметки"
        };

        for (String title : comingSoon) {
            JPanel panel = new JPanel();
            panel.add(new JLabel(title + " - Скоро появится"));
            tabbedPane.addTab(title, panel);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainApplication app = new MainApplication();
            app.setVisible(true);
        });
    }
} 