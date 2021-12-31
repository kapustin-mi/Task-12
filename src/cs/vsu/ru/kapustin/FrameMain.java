package cs.vsu.ru.kapustin;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class FrameMain extends JFrame {
    private JSpinner spinnerInputSize;
    private JSpinner spinnerInputDepth;
    private JButton buttonDrawFigure;
    private JButton buttonSaveToFile;
    private JPanel panelMain;
    private JLabel labelForImage;

    private final JFileChooser fileChooserSave;

    public FrameMain() {
        this.setTitle("Task 12");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(600, 0, 200, 100);
        this.pack();

        spinnerInputSize.setModel(new SpinnerNumberModel(600, 350, 900, 1));
        spinnerInputDepth.setModel(new SpinnerNumberModel(5, 3, 10, 1));

        fileChooserSave = new JFileChooser();
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("image", "jpg");
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

        JMenuBar menuBarMain = new JMenuBar();
        setJMenuBar(menuBarMain);

        this.pack();


        buttonDrawFigure.addActionListener(e -> {
            int size = (int) spinnerInputSize.getValue();
            int depth = (int) spinnerInputDepth.getValue();

            BufferedImage image = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = (Graphics2D) image.getGraphics();

            ImageCreation creation = new ImageCreation();
            creation.drawFigure(size, depth, graphics2D);

            labelForImage.setIcon(new ImageIcon(image));
            setBounds(600, 0, size + 20, size + 120);
        });

        buttonSaveToFile.addActionListener(e -> {
            try {
                if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                    ImageIcon image = (ImageIcon) labelForImage.getIcon();
                    BufferedImage img = (BufferedImage) image.getImage();

                    String fileName = fileChooserSave.getSelectedFile().getPath();
                    if (!fileName.toLowerCase().endsWith(".jpg")) {
                        fileName += ".jpg";
                    }

                    File file = new File(fileName);
                    Utils.printImageToFile(file, img);
                }
            } catch (Exception exception) {
                ErrorMessages.showErrorMessage(0);
            }
        });
    }
}
