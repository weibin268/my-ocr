package zhuang.ocr.tesseract;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.junit.Test;
import zhuang.ocr.OcrClient;
import zhuang.ocr.util.ImgUtils;

import java.io.File;
import java.io.IOException;

public class TesseractOcrClientTest {

    @Test
    public void test() throws TesseractException, IOException {
        String dataPath = new File(this.getClass().getResource("/tessdata").getPath()).getCanonicalPath();
        File imageFile = new File("C:\\Users\\zhuang\\myfiles\\temp\\test.png");//图片位置
        ITesseract instance = new Tesseract();
        instance.setDatapath(dataPath);
        instance.setLanguage("eng+chi_sim");
        String result = instance.doOCR(imageFile);
        System.out.println(result);
    }

    @Test
    public void parseString() {

        OcrClient ocrClient = new TesseractOcrClient();
        String imgFilePath = "C:\\Users\\zhuang\\myfiles\\temp\\test.png";
        System.out.println(ocrClient.parseString(ImgUtils.read(imgFilePath)));

    }
}