package QRcheck.com.apple.Config;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.*;

@Service
public class InFileQR {

    public static final String QR_CODE_IMAGE_PATH = "./MyQRCode.png";
    //Path path1 = Paths.get(QR_CODE_IMAGE_PATH);


  public void generateQRCodeImage(String text, int width, int height, String filePath)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);


        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

//        Path srcPath = Paths.get(filePath);
//
//        try
//        {
//            Files.copy(srcPath,destPath,StandardCopyOption.REPLACE_EXISTING);
//        }
//        catch(IOException e)
//        {
//            e.printStackTrace();
//        }
    }
}
