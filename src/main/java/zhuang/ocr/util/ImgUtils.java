package zhuang.ocr.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

public class ImgUtils {

    public static byte[] read(String imgFilePath) {
        try {
            FileInputStream inputStream = new FileInputStream(imgFilePath);
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            return bytes;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String toBase64String(byte[] imgBytes) {
        return new String(Base64.getEncoder().encode(imgBytes));
    }

    public static BufferedImage toBufferedImage(String imgBase64) {
        return toBufferedImage(toBytes(imgBase64));
    }

    public static BufferedImage toBufferedImage(byte[] imgBytes) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imgBytes);
        try {
            BufferedImage bufferedImage = ImageIO.read(byteArrayInputStream);
            return bufferedImage;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] toBytes(String imgBase64) {
        return Base64.getDecoder().decode(imgBase64.getBytes());
    }
}
