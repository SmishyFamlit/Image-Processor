package view;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Dimension;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;


import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Pixel;

/**
 * Makes the view for the GUIController.
 */
public class JFrameView extends JFrame implements JView {

  private Pixel[][] image;

  private JPanel imagePanel; //the panel where the image will be placed
  private JLabel imageLabel; //the label that holds the image

  private JHistogramView histoPanel; //the panel where the histogram will be placed



  private JLabel histoLabel; //the label that holds the histogram

  private JLabel inputDisplay; //the popup display for input



  //All the items in the File and Edit menu
  private JMenuItem load;
  private JMenuItem save;
  private JMenuItem value;
  private JMenuItem intensity;
  private JMenuItem luma;
  private JMenuItem grayScaleFilter;
  private JMenuItem sepia;

  //the list of items in the submenus
  private JMenuItem flipHorizontal;
  private JMenuItem flipVertical;
  private JMenuItem brighten;
  private JMenuItem darken;
  private JMenuItem blur;
  private JMenuItem sharpen;
  private JMenuItem redComponent;
  private JMenuItem greenComponent;
  private JMenuItem blueComponent;


  /**
   * Constructs the GUI for the Image Processor.
   *
   * @param caption the name of the frame
   */
  public JFrameView(String caption) {
    super(caption);

    JPanel mainPanel; //the main panel GUI
    JScrollPane scrollMain;
    JScrollPane scrollPane;
    JScrollPane scrollHisto;


    setSize(1000, 500); //sets the width and the height of the display

    mainPanel = new JPanel(); //makes the main frame of the view

    mainPanel.setLayout(new FlowLayout()); //set the layout as FlowLayout

    scrollMain = new JScrollPane(mainPanel);
    this.add(scrollMain); //adds the main panel to this JFrame

    createMenuBar(); //method that creates the menubar at the top

    //constructs the area for previewing the image in the gui
    this.imagePanel = new JPanel();
    this.imageLabel = new JLabel();
    scrollPane = new JScrollPane(this.imagePanel);
    scrollPane.setBorder(BorderFactory.createTitledBorder("Edit image here"));
    //this.imagePanel.setPreferredSize(new Dimension(800, 600));
    this.imagePanel.add(this.imageLabel);
    scrollPane.setPreferredSize(new Dimension(700, 500));
    mainPanel.add(scrollPane);


    //constructs the area for viewing the histogram
    this.histoPanel = new JHistogramView(this.image);
    scrollHisto = new JScrollPane(this.histoPanel);
    scrollHisto.setBorder(BorderFactory.createTitledBorder("Histogram"));
    this.histoPanel.setPreferredSize(new Dimension(1024, 1000000000));
    scrollHisto.setPreferredSize(new Dimension(700, 500));
    mainPanel.add(scrollHisto);
    pack();


    this.inputDisplay = new JLabel(); //makes the JLabel for the popup window

    setVisible(true); //allows us to see the JFrame
  }

  private void createMenuBar() {
    JMenuBar mb; //the menu bar of the GUI

    //creates the two JMenus File and Edit
    JMenu file;
    JMenu edit;


    //The submenus in the Edit menu
    JMenu flip;
    JMenu brightness;
    JMenu grayscaleComponent;
    JMenu filtering;


    mb = new JMenuBar();

    //makes the File and Edit tabs at the top of the bar
    file = new JMenu("File");
    edit = new JMenu("Edit");

    //Makes all the items in File and Edit Menus
    this.load = new JMenuItem("Load");
    this.load.setActionCommand("Load Button");

    this.save = new JMenuItem("Save");
    this.save.setActionCommand("Save Button");

    this.value = new JMenuItem("Value");
    this.value.setActionCommand("Value Button");

    this.intensity = new JMenuItem("Intensity");
    this.intensity.setActionCommand("Intensity Button");

    this.luma = new JMenuItem("Luma");
    this.luma.setActionCommand("Luma Button");

    this.grayScaleFilter = new JMenuItem("Grayscale Filter");
    this.grayScaleFilter.setActionCommand("Grayscale Button");

    this.sepia = new JMenuItem("Sepia");
    this.sepia.setActionCommand("Sepia Button");

    this.value = new JMenuItem("Value");
    this.value.setActionCommand("Value Button");


    //Makes the Submenus inside Edit
    flip = new JMenu("Flip");
    brightness = new JMenu("Brightness");
    grayscaleComponent = new JMenu("Grayscale Component");
    filtering = new JMenu("Filtering");

    //Makes the items inside the submenus and sets the action commands
    this.flipHorizontal = new JMenuItem("Horizontal Flip");
    this.flipHorizontal.setActionCommand("Horizontal Button");

    this.flipVertical = new JMenuItem("Vertical Flip");
    this.flipVertical.setActionCommand("Vertical Button");

    this.brighten = new JMenuItem("Brighten");
    this.brighten.setActionCommand("Brighten Button");

    this.darken = new JMenuItem("Darken");
    this.darken.setActionCommand("Darken Button");

    this.blur = new JMenuItem("Blur");
    this.blur.setActionCommand("Blur Button");

    this.sharpen = new JMenuItem("Sharpen");
    this.sharpen.setActionCommand("Sharpen Button");

    this.redComponent = new JMenuItem("Red Component");
    this.redComponent.setActionCommand("Red Button");

    this.greenComponent = new JMenuItem("Green Component");
    this.greenComponent.setActionCommand("Green Button");

    this.blueComponent = new JMenuItem("Blue Component");
    this.blueComponent.setActionCommand("Blue Button");


    //adds the File and Edit to the menu bar
    mb.add(file);
    mb.add(edit);

    //adds the load and save to the Edit
    file.add(this.load);
    file.add(this.save);

    //add all the items to the submenus
    brightness.add(this.brighten);
    brightness.add(this.darken);

    grayscaleComponent.add(this.redComponent);
    grayscaleComponent.add(this.greenComponent);
    grayscaleComponent.add(this.blueComponent);

    filtering.add(this.blur);
    filtering.add(this.sharpen);

    flip.add(this.flipHorizontal);
    flip.add(this.flipVertical);

    //adds all the edit items and submenus
    edit.add(brightness);
    edit.add(grayscaleComponent);
    edit.add(this.grayScaleFilter);
    edit.add(filtering);
    edit.add(flip);
    edit.add(this.intensity);
    edit.add(this.luma);
    edit.add(this.sepia);
    edit.add(this.value);

    setJMenuBar(mb);
  }


  @Override
  public void setListerner(ActionListener listener) {
    this.load.addActionListener(listener);
    this.save.addActionListener(listener);
    this.value.addActionListener(listener);
    this.intensity.addActionListener(listener);
    this.luma.addActionListener(listener);
    this.grayScaleFilter.addActionListener(listener);
    this.sepia.addActionListener(listener);
    this.value.addActionListener(listener);
    this.flipHorizontal.addActionListener(listener);
    this.flipVertical.addActionListener(listener);
    this.brighten.addActionListener(listener);
    this.darken.addActionListener(listener);
    this.blur.addActionListener(listener);
    this.sharpen.addActionListener(listener);
    this.redComponent.addActionListener(listener);
    this.greenComponent.addActionListener(listener);
    this.blueComponent.addActionListener(listener);
  }

  @Override
  public String showFileExplorer() throws IllegalStateException {
    final JFileChooser fchooser =
            new JFileChooser("C:\\Users\\sanchez.ism\\Documents\\CS3500Project" +
                    "\\group\\image-processing\\res\\cuphead.png");
    FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "JPG & GIF Images", "jpg", "gif", "png", "bmp", "ppm");
    fchooser.setFileFilter(filter);
    int retvalue = fchooser.showOpenDialog(this);
    if (retvalue == JFileChooser.APPROVE_OPTION) {
      File f = fchooser.getSelectedFile();
      return f.getAbsolutePath();
    } else {
      throw new IllegalStateException("File can't be opened");
    }
  }

  @Override
  public String saveFile() {
    final JFileChooser fchooser = new JFileChooser();
    fchooser.showSaveDialog(this);
    File f = fchooser.getSelectedFile();

    return fchooser.getCurrentDirectory().getPath() + "\\" + fchooser.getName(f);
  }

  @Override
  public void showImage(String imagePath) {
    imageLabel.setIcon(new ImageIcon(imagePath));
  }

  @Override
  public String showPopup() {
    inputDisplay.setText(JOptionPane.showInputDialog("Please enter an image name"));
    this.imagePanel.setBorder(BorderFactory.createTitledBorder(inputDisplay.getText()));
    return inputDisplay.getText();
  }

  @Override
  public void updateImage(Pixel[][] image) {
    //makes the buffered image
    BufferedImage bfImage = new BufferedImage(image[0].length, image.length,
            BufferedImage.TYPE_INT_RGB);
    for (int y = 0; y < bfImage.getHeight(); y++) {
      for (int x = 0; x < bfImage.getWidth(); x++) {
        Color c = new Color(image[y][x].getRed(), image[y][x].getGreen(), image[y][x].getBlue());
        int bfColor = c.getRGB();
        bfImage.setRGB(x, y, bfColor);
      }
    }

    //set the JLabel to the new buffered image
    this.imageLabel.setIcon(new ImageIcon(bfImage));

  }



  @Override
  public void setPixelImage(Pixel[][] array) {
    this.image = array;
    this.histoPanel.setImage(this.image);
    this.histoPanel.repaint();
  }

}
