
/**
 * Image Inversion
 * @author: Mugilan
 * (14/08/2020)
 */

import edu.duke.*;
import java.io.*;

public class Assignment {
    public ImageResource makeInversion(ImageResource inImage) {
        ImageResource outImage = new ImageResource(inImage);
        
        for (Pixel pixel : outImage.pixels()) {
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int r = inPixel.getRed();
            int g = inPixel.getGreen();
            int b = inPixel.getBlue();
            
            pixel.setRed(255 - r);
            pixel.setGreen(255 - g);
            pixel.setBlue(255 - b);
        }
        
        return outImage;
    }
    
    public void selectAndConvert() {
        DirectoryResource dr = new DirectoryResource();
        
        for (File f : dr.selectedFiles()) {
            ImageResource inImage = new ImageResource(f);
            ImageResource outImage = makeInversion(inImage);
            
            //outImage.draw();
            
            String fileName = inImage.getFileName();
            String newFileName = "inverted-" + fileName;
            
            outImage.setFileName(newFileName);
            outImage.save();
        }
    }
}
