package simulation;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import graphicLayer.GImage;

public class GrBeacon extends GrMobileElement
{

  public GrBeacon()
  {

    File path = new File("balise.png");
    this.withoutBorder();
    this.withoutBackground();
    BufferedImage rawImage = null;
    try
    {
      rawImage = ImageIO.read(path);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    this.addElement(new GImage(rawImage));
    this.setDimension(new Dimension(rawImage.getWidth(), rawImage.getHeight()));
  }

}
