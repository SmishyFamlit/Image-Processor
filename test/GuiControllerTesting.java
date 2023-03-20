import org.junit.Test;

import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;


import javax.swing.JMenuItem;
import controller.GuiControllerImpl;
import model.Model;
import static org.junit.Assert.assertTrue;

/**
 * Tests the GUI Controller.
 */
public class GuiControllerTesting {

  @Test
  public void testActionPerformedLoad() throws FileNotFoundException {
    JMenuItem load = new JMenuItem();
    load.setActionCommand("Load Button");
    StringBuilder output = new StringBuilder();
    Model model = new ImageProcessorMock(output);
    JFrameViewMock view = new JFrameViewMock(output);
    GuiControllerImpl controller = new GuiControllerImpl(model,view);
    load.addActionListener(controller);
    ActionEvent e = new ActionEvent(load, 0, "Load Button");
    controller.actionPerformed(e);


    assertTrue(output.toString().contains("file explorer is showing"));
    assertTrue(output.toString().contains("pop up shown"));
    assertTrue(output.toString().contains("image set in histogram"));
    assertTrue(output.toString().contains("is shown on gui"));

  }

  @Test
  public void testActionPerformedHorizontal() throws FileNotFoundException {
    JMenuItem load = new JMenuItem();
    load.setActionCommand("Horizontal Button");
    StringBuilder output = new StringBuilder();
    Model model = new ImageProcessorMock(output);
    JFrameViewMock view = new JFrameViewMock(output);
    GuiControllerImpl controller = new GuiControllerImpl(model,view);
    load.addActionListener(controller);
    ActionEvent e = new ActionEvent(load, 0, "Horizontal Button");
    controller.actionPerformed(e);

    assertTrue(output.toString().contains("listener has been set"));
    assertTrue(output.toString().contains("image: '' was flipped horizontally"));
    assertTrue(output.toString().contains("has been updated"));

  }

  @Test
  public void testActionPerformedVertical() throws FileNotFoundException {
    JMenuItem load = new JMenuItem();
    load.setActionCommand("Vertical Button");
    StringBuilder output = new StringBuilder();
    Model model = new ImageProcessorMock(output);
    JFrameViewMock view = new JFrameViewMock(output);
    GuiControllerImpl controller = new GuiControllerImpl(model,view);
    load.addActionListener(controller);
    ActionEvent e = new ActionEvent(load, 0, "Vertical Button");
    controller.actionPerformed(e);

    assertTrue(output.toString().contains("listener has been set"));
    assertTrue(output.toString().contains("image: '' was flipped vertically"));
    assertTrue(output.toString().contains("has been updated"));

  }

  @Test
  public void testActionPerformedSave() throws FileNotFoundException {
    JMenuItem load = new JMenuItem();
    load.setActionCommand("Save Button");
    StringBuilder output = new StringBuilder();
    Model model = new ImageProcessorMock(output);
    JFrameViewMock view = new JFrameViewMock(output);
    GuiControllerImpl controller = new GuiControllerImpl(model,view);
    load.addActionListener(controller);
    ActionEvent e = new ActionEvent(load, 0, "Save Button");
    controller.actionPerformed(e);

    assertTrue(output.toString().contains("listener has been set"));
    assertTrue(output.toString().contains("has been saved"));
    assertTrue(output.toString().contains("file of path taken"));

  }

  @Test
  public void testActionPerformedBlur() throws FileNotFoundException {
    JMenuItem load = new JMenuItem();
    load.setActionCommand("Blur Button");
    StringBuilder output = new StringBuilder();
    Model model = new ImageProcessorMock(output);
    JFrameViewMock view = new JFrameViewMock(output);
    GuiControllerImpl controller = new GuiControllerImpl(model,view);
    load.addActionListener(controller);
    ActionEvent e = new ActionEvent(load, 0, "Blur Button");
    controller.actionPerformed(e);

    assertTrue(output.toString().contains("listener has been set"));
    assertTrue(output.toString().contains("image: '' has been blurred"));
    assertTrue(output.toString().contains("has been updated"));

  }

  @Test
  public void testActionPerformedSharpen() throws FileNotFoundException {
    JMenuItem load = new JMenuItem();
    load.setActionCommand("Sharpen Button");
    StringBuilder output = new StringBuilder();
    Model model = new ImageProcessorMock(output);
    JFrameViewMock view = new JFrameViewMock(output);
    GuiControllerImpl controller = new GuiControllerImpl(model,view);
    load.addActionListener(controller);
    ActionEvent e = new ActionEvent(load, 0, "Sharpen Button");
    controller.actionPerformed(e);

    assertTrue(output.toString().contains("listener has been set"));
    assertTrue(output.toString().contains("image: '' has been sharpened"));
    assertTrue(output.toString().contains("has been updated"));

  }

  @Test
  public void testActionPerformedValue() throws FileNotFoundException {
    JMenuItem load = new JMenuItem();
    load.setActionCommand("Value Button");
    StringBuilder output = new StringBuilder();
    Model model = new ImageProcessorMock(output);
    JFrameViewMock view = new JFrameViewMock(output);
    GuiControllerImpl controller = new GuiControllerImpl(model,view);
    load.addActionListener(controller);
    ActionEvent e = new ActionEvent(load, 0, "Value Button");
    controller.actionPerformed(e);

    assertTrue(output.toString().contains("listener has been set"));
    assertTrue(output.toString().contains("image: '' has changed to value RGB colors"));
    assertTrue(output.toString().contains("has been updated"));

  }

  @Test
  public void testActionPerformedIntensity() throws FileNotFoundException {
    JMenuItem load = new JMenuItem();
    load.setActionCommand("Intensity Button");
    StringBuilder output = new StringBuilder();
    Model model = new ImageProcessorMock(output);
    JFrameViewMock view = new JFrameViewMock(output);
    GuiControllerImpl controller = new GuiControllerImpl(model,view);
    load.addActionListener(controller);
    ActionEvent e = new ActionEvent(load, 0, "Intensity Button");
    controller.actionPerformed(e);

    assertTrue(output.toString().contains("listener has been set"));
    assertTrue(output.toString().contains("image: '' has changed to intensity RGB colors"));
    assertTrue(output.toString().contains("has been updated"));

  }

  @Test
  public void testActionPerformedLuma() throws FileNotFoundException {
    JMenuItem load = new JMenuItem();
    load.setActionCommand("Luma Button");
    StringBuilder output = new StringBuilder();
    Model model = new ImageProcessorMock(output);
    JFrameViewMock view = new JFrameViewMock(output);
    GuiControllerImpl controller = new GuiControllerImpl(model,view);
    load.addActionListener(controller);
    ActionEvent e = new ActionEvent(load, 0, "Luma Button");
    controller.actionPerformed(e);

    assertTrue(output.toString().contains("listener has been set"));
    assertTrue(output.toString().contains("image: '' has changed to luma RGB colors"));
    assertTrue(output.toString().contains("has been updated"));

  }

  @Test
  public void testActionPerformedGrayscale() throws FileNotFoundException {
    JMenuItem load = new JMenuItem();
    load.setActionCommand("Grayscale Button");
    StringBuilder output = new StringBuilder();
    Model model = new ImageProcessorMock(output);
    JFrameViewMock view = new JFrameViewMock(output);
    GuiControllerImpl controller = new GuiControllerImpl(model,view);
    load.addActionListener(controller);
    ActionEvent e = new ActionEvent(load, 0, "Grayscale Button");
    controller.actionPerformed(e);

    assertTrue(output.toString().contains("listener has been set"));
    assertTrue(output.toString().contains("image: '' has grayscale filter"));
    assertTrue(output.toString().contains("has been updated"));

  }

  @Test
  public void testActionPerformedSepia() throws FileNotFoundException {
    JMenuItem load = new JMenuItem();
    load.setActionCommand("Sepia Button");
    StringBuilder output = new StringBuilder();
    Model model = new ImageProcessorMock(output);
    JFrameViewMock view = new JFrameViewMock(output);
    GuiControllerImpl controller = new GuiControllerImpl(model,view);
    load.addActionListener(controller);
    ActionEvent e = new ActionEvent(load, 0, "Sepia Button");
    controller.actionPerformed(e);

    assertTrue(output.toString().contains("listener has been set"));
    assertTrue(output.toString().contains("image: '' has sepia filter"));
    assertTrue(output.toString().contains("has been updated"));

  }

  @Test
  public void testActionPerformedRed() throws FileNotFoundException {
    JMenuItem load = new JMenuItem();
    load.setActionCommand("Red Button");
    StringBuilder output = new StringBuilder();
    Model model = new ImageProcessorMock(output);
    JFrameViewMock view = new JFrameViewMock(output);
    GuiControllerImpl controller = new GuiControllerImpl(model,view);
    load.addActionListener(controller);
    ActionEvent e = new ActionEvent(load, 0, "Red Button");
    controller.actionPerformed(e);

    assertTrue(output.toString().contains("listener has been set"));
    assertTrue(output.toString().contains("image: '' was greyscaled to Red"));
    assertTrue(output.toString().contains("has been updated"));

  }

  @Test
  public void testActionPerformedGreen() throws FileNotFoundException {
    JMenuItem load = new JMenuItem();
    load.setActionCommand("Green Button");
    StringBuilder output = new StringBuilder();
    Model model = new ImageProcessorMock(output);
    JFrameViewMock view = new JFrameViewMock(output);
    GuiControllerImpl controller = new GuiControllerImpl(model,view);
    load.addActionListener(controller);
    ActionEvent e = new ActionEvent(load, 0, "Green Button");
    controller.actionPerformed(e);

    assertTrue(output.toString().contains("listener has been set"));
    assertTrue(output.toString().contains("image: '' was greyscaled to Green"));
    assertTrue(output.toString().contains("has been updated"));

  }

  @Test
  public void testActionPerformedBlue() throws FileNotFoundException {
    JMenuItem load = new JMenuItem();
    load.setActionCommand("Blue Button");
    StringBuilder output = new StringBuilder();
    Model model = new ImageProcessorMock(output);
    JFrameViewMock view = new JFrameViewMock(output);
    GuiControllerImpl controller = new GuiControllerImpl(model,view);
    load.addActionListener(controller);
    ActionEvent e = new ActionEvent(load, 0, "Blue Button");
    controller.actionPerformed(e);

    assertTrue(output.toString().contains("listener has been set"));
    assertTrue(output.toString().contains("image: '' was greyscaled to Blue"));
    assertTrue(output.toString().contains("has been updated"));

  }

}
