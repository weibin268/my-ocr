package zhuang.ocr.tesseract;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import zhuang.ocr.OcrClient;
import zhuang.ocr.util.ImgUtils;

import java.io.File;
import java.io.IOException;

public class TesseractOcrClient implements OcrClient {

    private String dataPath;

    public TesseractOcrClient() {
        try {
            dataPath = new File(this.getClass().getResource("/tessdata").getPath()).getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TesseractOcrClient(String dataPath) {
        this.dataPath = dataPath;
    }

    @Override
    public String parseString(byte[] imgBytes) {
        ITesseract instance = new Tesseract();
        instance.setDatapath(dataPath);
        instance.setLanguage("eng+chi_sim");
        String result;
        try {
            result = instance.doOCR(ImgUtils.toBufferedImage(imgBytes));
            return result;
        } catch (TesseractException e) {
            throw new RuntimeException(e);
        }
    }


}
