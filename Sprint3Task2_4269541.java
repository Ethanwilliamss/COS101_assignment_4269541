import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Sprint3Task2_4269541 {

    private static int currentPlantIndex = 0;
    private static final String[] plantNames = {"Ethan's Sunny Sunflowers", "Ethan's Cool Cucumbers", "Ethan's Marvelous Marigolds", "Ethan's Blissful Basil","Ethan's Elegant Orchids","Ethan's Radiant Roses","Ethan's Tranquil Tulips"};
    private static final String[] plantDescriptions = {
            "Ethan's Sunny Sunflowers:\n\n" +
                    "Ethan's Sunny Sunflowers is a vibrant and cheerful variety of sunflowers that bloom in brilliant yellow hues. " +
                    "These sunflowers are known for their resilience and ability to thrive in various sunlight conditions. " +
                    "Whether planted in gardens or used as cut flowers, Ethan's Sunny Sunflowers add a touch of sunshine to any space.\n\n" +
                    "Care Instructions:\n" +
                    "- Sunlight: Full sun\n" +
                    "- Watering: Regular watering, well-draining soil\n" +
                    "- Height: 2m tall\n" +
                    "- Blooming Season: December till April\n\n" +
                    "Enjoy the beauty of Ethan's Sunny Sunflowers in your garden or living space!",
            "Ethan's Cool Cucumbers:\n\n" +
                    "Ethan's Cool Cucumbers are a refreshing and versatile addition to any garden. These cucumbers are prized for their crisp texture and mild flavor. " +
                    "Ideal for salads, pickling, or as a healthy snack, Ethan's Cool Cucumbers thrive in warm weather and well-drained soil.\n\n" +
                    "Care Instructions:\n" +
                    "- Sunlight: Full sun\n" +
                    "- Watering: Regular watering, well-draining soil\n" +
                    "- Harvesting: Harvest when cucumbers are firm and bright green\n\n" +
                    "Experience the cool and crisp taste of Ethan's Cool Cucumbers in your culinary adventures!",
            "Ethan's Marvelous Marigolds:\n\n" +
                    "Ethan's Marvelous Marigolds are vibrant and hardy flowers that bring a burst of color to gardens and landscapes. " +
                    "Known for their pest-repelling properties, these marigolds are not only beautiful but also functional. " +
                    "Plant Ethan's Marvelous Marigolds to add a touch of gold and orange to your outdoor spaces.\n\n" +
                    "Care Instructions:\n" +
                    "- Sunlight: Full sun to partial shade\n" +
                    "- Watering: Moderate watering, well-draining soil\n" +
                    "- Pest Control: Marigolds help repel pests\n\n" +
                    "Bring the beauty and functionality of Ethan's Marvelous Marigolds to your garden!",
            "Ethan's Blissful Basil:\n\n" +
                    "Ethan's Blissful Basil is a fragrant and flavorful herb that adds a delightful aroma and taste to a variety of dishes. " +
                    "Whether used in salads, pasta, or as a garnish, this basil variety is a kitchen essential. " +
                    "Grow Ethan's Blissful Basil in your herb garden for a continuous supply of fresh and aromatic leaves.\n\n" +
                    "Care Instructions:\n" +
                    "- Sunlight: Full sun\n" +
                    "- Watering: Regular watering, well-draining soil\n" +
                    "- Harvesting: Harvest basil leaves regularly for best flavor\n\n" +
                    "Experience the culinary joy of Ethan's Blissful Basil in your kitchen!",
            "Ethan's Elegant Orchids:\n\n" +
                    "Ethan's Elegant Orchids are stunning and exotic flowers that add a touch of sophistication to any environment. " +
                    "Known for their vibrant colors and unique shapes, these orchids make a statement in both gardens and indoor spaces.\n\n" +
                    "Care Instructions:\n" +
                    "- Sunlight: Indirect light\n" +
                    "- Watering: Regular watering, well-draining soil\n" +
                    "- Temperature: Warm and humid conditions\n\n" +
                    "Admire the elegance of Ethan's Elegant Orchids in your surroundings!",
            "Ethan's Radiant Roses:\n\n" +
                    "Ethan's Radiant Roses are classic and timeless flowers that symbolize love and beauty. " +
                    "With a variety of colors available, these roses are perfect for expressing emotions and enhancing the aesthetics of any garden.\n\n" +
                    "Care Instructions:\n" +
                    "- Sunlight: Full sun\n" +
                    "- Watering: Regular watering, well-draining soil\n" +
                    "- Pruning: Prune to encourage healthy growth\n\n" +
                    "Enjoy the timeless beauty of Ethan's Radiant Roses in your garden!",
            "Ethan's Tranquil Tulips:\n\n" +
                    "Ethan's Tranquil Tulips bring a burst of color and a sense of tranquility to gardens and landscapes. " +
                    "With their vibrant hues and graceful shape, these tulips create a peaceful and inviting atmosphere.\n\n" +
                    "Care Instructions:\n" +
                    "- Sunlight: Full sun to partial shade\n" +
                    "- Watering: Moderate watering, well-draining soil\n" +
                    "- Bloom Time: Spring\n\n" +
                    "Experience the tranquility of Ethan's Tranquil Tulips in your outdoor spaces!"
                
                
    };

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowLoginGUI();
        });
    }

    private static void createAndShowLoginGUI() {
        JFrame frame = new JFrame("Plant Nursery Management System - Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);

        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] password = passwordField.getPassword();

                writeUserInfoToFile(username, new String(password));

                JOptionPane.showMessageDialog(frame, "Welcome to Ethan's plant nursery");

                frame.dispose();
                createAndShowFeaturedPlantGUI();
            }
        });

        mainPanel.add(usernameLabel);
        mainPanel.add(usernameField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(loginButton);

        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void createAndShowFeaturedPlantGUI() {
        JFrame plantFrame = new JFrame("Featured Plant");
        plantFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea plantInfoArea = new JTextArea(plantDescriptions[currentPlantIndex]);
        plantInfoArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(plantInfoArea);

        JButton nextPlantButton = new JButton("Next Plant");
        nextPlantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPlantIndex = (currentPlantIndex + 1) % plantNames.length;
                plantInfoArea.setText(plantDescriptions[currentPlantIndex]);
                plantFrame.setTitle("Featured Plant: " + plantNames[currentPlantIndex]);
            }
        });

        plantFrame.getContentPane().setLayout(new BorderLayout());
        plantFrame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        plantFrame.getContentPane().add(nextPlantButton, BorderLayout.SOUTH);

        plantFrame.setSize(400, 300);
        plantFrame.setLocationRelativeTo(null);
        plantFrame.setVisible(true);
    }

    private static void writeUserInfoToFile(String username, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("user_info.txt", true))) {
            writer.write("Username: " + username + ", Password: " + password + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
