package util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by 15114 on 2018/4/21.
 */
public class BinImages {

    public BinImages() {
    }

    public String BinImages (String dirPath) throws IOException {

        //String dirPath
        //String dirPath = "C:\\Users\\15114\\Desktop\\test";

        String outPath = dirPath + "\\after\\";
        File file = new File(dirPath);
        File outFile = new File(outPath);
        if (!outFile.exists()) {
            outFile.mkdir();
        }

        File[] files = file.listFiles();

        BufferedImage bi = null;
        BufferedImage nbi = null;
        for (File f : files) {
            if (!f.isDirectory()) {

                bi = ImageIO.read(f);

                int max = new Color(255, 255, 255).getRGB();
                int min = new Color(0, 0, 0).getRGB();

                nbi = new BufferedImage(600, 75, BufferedImage.TYPE_BYTE_BINARY);

                for (int y = 5; y < 80; y++) {
                    for (int x = 0; x < 600; x++) {
                        int RBG = getGray(bi.getRGB(x, y));
                        if (RBG == 0) {
                            nbi.setRGB(x, y - 5, max);
                        } else if (RBG == 229) {
                            nbi.setRGB(x, y - 5, max);
                        } else {
                            nbi.setRGB(x, y - 5, min);
                        }
                    }
                }
                String fileName = f.getName();
                String prefix = fileName.substring(fileName.indexOf(".") + 1);
                ImageIO.write(nbi, prefix, new File(outPath + fileName));
            }
        }
        return outPath;
    }

    public static int getGray(int rgb) {

        int r, b, g;
        Color c = new Color(rgb);
        r = c.getRed();
        g = c.getGreen();
        b = c.getBlue();

        int top = (r + g + b) / 3;
        return (int) (top);

    }

//    public static void main(String[] args) throws IOException {
//        new BinImages().BinImages("");
//    }

}