/*
 * Librerias utilizadas
 */
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
    /*
     * Actualiza la pantalla con cada accion
     */
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
    /*
     * Creacion de la GUI
     */
    public BlenderGUI(){
        this.blender = new Blender2();
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
        /*
         * Boton para aumentar velocidad
         */
        JButton speedUpButton = createButton("/Resources/imgs/SpeedUpIMG.png", 350, 150);
        speedUpButton.addActionListener(e -> {
            blender.SpeedUp();
            updateGUI();
        });
        /*
         * Boton para disminuir velocidad
         */
        JButton speedDownButton = createButton("/Resources/imgs/SpeedDownIMG.png", 50, 150);
        speedDownButton.addActionListener(e -> {
            blender.SpeedDown();
            updateGUI();
        });
        /*
         * Boton para llenar la licuadora
         */
        JButton fillButton = createButton("/Resources/imgs/IMGFill.png", 50, 250);
        fillButton.addActionListener(e -> {
            blender.Fill();
            updateGUI();
            JOptionPane.showMessageDialog(this, "Licuadora llenada");
        });
        /*
         * Boton para vaciar la licuadora
         */
        JButton emptyButton = createButton("/Resources/imgs/emptyyy.png", 350, 250);
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

