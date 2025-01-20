
// import java.awt.Color;
// import java.awt.Font;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.io.InputStream;

// import javax.swing.ImageIcon;
// import javax.swing.JButton;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.JOptionPane;

// public class BlenderGUI extends JFrame {

//     private int velActual = 0; 

//     public BlenderGUI() {
//         setTitle("Licuadora IoT");
//         setSize(800, 600); 
//         setLayout(null); 
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         getContentPane().setBackground(Color.BLACK);

//         Font buttonFont = cargarFuente("/Resources/fonts/Vogue.ttf", Font.PLAIN, 50);

//         ImageIcon speedUpImage = new ImageIcon(getClass().getResource("/Resources/imgs/SpeedUpIMG.png"));
//         ImageIcon speedDownImage = new ImageIcon(getClass().getResource("/Resources/imgs/SpeedDownIMG.png"));
//         ImageIcon EmptyImage = new ImageIcon(getClass().getResource("/Resources/imgs/EmptyIMG.png"));
//         ImageIcon FillImage = new ImageIcon(getClass().getResource("/Resources/imgs/IMGFill.png"));
//         ImageIcon IsFullImage = new ImageIcon(getClass().getResource("/Resources/imgs/SpeedDownIMG.png"));

//         JLabel veloLabel = new JLabel("Velocidad: " + velActual);
//         veloLabel.setFont(buttonFont);
//         veloLabel.setForeground(Color.RED);
//         veloLabel.setBounds(300, 50, 400, 50);
//         add(veloLabel);

//         JButton upVolButton = new JButton(speedUpImage);
//         upVolButton.setBounds(500, 150, 150, 70);
//         upVolButton.setContentAreaFilled(false); 
//         upVolButton.setBorderPainted(false); 
//         upVolButton.addActionListener(e -> {
//             if (velActual < 10) {
//                 velActual++;
//                 veloLabel.setText("Velocidad: " + velActual);
//             }
//         });
//         add(upVolButton);

//         JButton downVolButton = new JButton(speedDownImage);
//         downVolButton.setBounds(200, 150, 150, 70);
//         downVolButton.setContentAreaFilled(false); 
//         downVolButton.setBorderPainted(false); 
//         downVolButton.addActionListener(e -> {
//             if (velActual > 0) {
//                 velActual--;
//                 veloLabel.setText("Velocidad: " + velActual);
//             }
//         });
//         add(downVolButton);

//         JButton fillButton = new JButton(FillImage);
//         fillButton.setBounds(200, 250, 150, 70);
//         fillButton.setFont(new Font("Arial", Font.PLAIN, 20));
//         fillButton.addActionListener(e -> {
//             JOptionPane.showMessageDialog(this, "Licuadora llenada");
//         });
//         add(fillButton);

//         JButton emptyButton = new JButton(EmptyImage);
//         emptyButton.setBounds(500, 250, 150, 70);
//         emptyButton.setFont(new Font("Arial", Font.PLAIN, 20));
//         emptyButton.addActionListener(e -> {
//             velActual = 0;
//             veloLabel.setText("Velocidad: " + velActual);
//             JOptionPane.showMessageDialog(this, "Licuadora vaciada");
//         });
//         add(emptyButton);

//         setVisible(true); 
//     }

//     public static void main(String[] args) {
//         new BlenderGUI(); 
//     }

//     private static Font cargarFuente(String fontPath, int style, int size) {
//         try (InputStream fontStream = BlenderGUI.class.getResourceAsStream(fontPath)) {
//             if (fontStream == null) {
//                 throw new IllegalArgumentException("Fuente no encontrada en la ruta " + fontPath);
//             }
//             Font font = Font.createFont(Font.TRUETYPE_FONT, fontStream);
//             return font.deriveFont(style, size);
//         } catch (Exception e) {
//             e.printStackTrace();
//             return new Font("Serif", style, size); 
//         }
//     }
    
// }


import javax.swing.*;
import java.awt.*;
import java.io.InputStream;


public class BlenderGUI extends JFrame{
    private final IBlender blender;
    private final JLabel speedLabel;
    private final JLabel statusLabel;

    private JButton createButton(String imagePath, int x, int y) {
        ImageIcon icon = new ImageIcon(getClass().getResource(imagePath));
        JButton button = new JButton(icon);
        button.setBounds(x, y, 150, 70);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        return button;
    }

    private void updateGUI() {
        speedLabel.setText("Velocidad: " + blender.GetSpeed());
        statusLabel.setText("Estado: " + (blender.IsFull() ? "Llena" : "Vacía"));
        statusLabel.setForeground(blender.IsFull() ? Color.RED : Color.GREEN);
    }

    private Font loadFont(String fontPath, int style, int size) {
        try (InputStream fontStream = BlenderGUI.class.getResourceAsStream(fontPath)) {
            if (fontStream == null) {
                throw new IllegalArgumentException("Fuente no encontrada: " + fontPath);
            }
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontStream);
            return font.deriveFont(style, size);
        } catch (Exception e) {
            e.printStackTrace();
            return new Font("Arial", style, size); 
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(BlenderGUI::new); 
    }

    public BlenderGUI(){
        this.blender = new Blender();
        setTitle("Licuadora ");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
        Font customFont = loadFont("/Resources/fonts/Vogue.ttf", Font.BOLD, 25);

        speedLabel = new JLabel("Velocidad: 0", SwingConstants.CENTER);
        speedLabel.setFont(customFont);
        speedLabel.setForeground(Color.RED);
        speedLabel.setBounds(200, 20, 200, 50);
        add(speedLabel);

        
        statusLabel = new JLabel("Estado: Vacía", SwingConstants.CENTER);
        statusLabel.setFont(customFont);
        statusLabel.setForeground(Color.GREEN);
        statusLabel.setBounds(200, 70, 200, 50);
        add(statusLabel);

        JButton speedUpButton = createButton("/Resources/imgs/SpeedUpIMG.png", 350, 150);
        speedUpButton.addActionListener(e -> {
            blender.SpeedUp();
            updateGUI();
        });

        JButton speedDownButton = createButton("/Resources/imgs/SpeedDownIMG.png", 50, 150);
        speedDownButton.addActionListener(e -> {
            blender.SpeedDown();
            updateGUI();
        });

        JButton fillButton = createButton("/Resources/imgs/IMGFill.png", 50, 250);
        fillButton.addActionListener(e -> {
            blender.Fill();
            updateGUI();
            JOptionPane.showMessageDialog(this, "Licuadora llenada");
        });

        JButton emptyButton = createButton("/Resources/imgs/EmptyIMG.png", 350, 250);
        emptyButton.addActionListener(e -> {
            blender.Empty();
            updateGUI();
            JOptionPane.showMessageDialog(this, "Licuadora vaciada");
        });

        
        add(speedUpButton);
        add(speedDownButton);
        add(fillButton);
        add(emptyButton);

        setVisible(true);
    }

   
}

