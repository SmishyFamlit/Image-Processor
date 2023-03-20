package view;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

import model.Histogram;
import model.HistogramData;
import model.Pixel;

/**
 * Jpanel for the Histogram.
 */
public class JHistogramView extends JPanel {

  Pixel[][] image;
  int scale;

  /**
   * Constructs the histogram view.
   * @param image the image that is currently being used by the user
   */
  public JHistogramView(Pixel[][] image) {
    super();
    this.image = image;
    this.scale = 1;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (this.image != null) {
      super.paintComponent(g);
      int[] red = new HistogramData(image, Histogram.HistogramColour.Red).getRedArray();
      int[] green = new HistogramData(image, Histogram.HistogramColour.Green).getGreenArray();
      int[] blue = new HistogramData(image, Histogram.HistogramColour.Blue).getBlueArray();
      int[] intensity = new HistogramData(image, Histogram.HistogramColour.Intensity).
              getIntensityArray();
      int startingPosn = Math.max(getMaxValue(red), Math.max(getMaxValue(green),
              Math.max(getMaxValue(blue), getMaxValue(intensity))));
      for (int i = 0; i < 256; i++) {
        g.drawLine(i, startingPosn, i, (startingPosn - red[i]));
        g.setColor(Color.red);
        g.drawLine(i + 256, startingPosn, i + 256, (startingPosn - green[i]));
        g.setColor(Color.green);
        g.drawLine(i + 256 + 256, startingPosn, i + 256 + 256,  (startingPosn - blue[i]));
        g.setColor(Color.blue);
        g.drawLine(i + 256 + 256 + 256, startingPosn, i + 256 + 256 + 256, (startingPosn -
                intensity[i]));
        g.setColor(Color.gray);
      }
    }
  }

  private int getMaxValue(int[] array) {
    int max = 0;
    for (int i = 0; i < array.length - 2; i++) {
      max = Math.max(array[i], array[i + 1]);
    }
    return max;
  }

  public void setImage(Pixel[][] image) {
    this.image = image;
    this.repaint();
  }
}