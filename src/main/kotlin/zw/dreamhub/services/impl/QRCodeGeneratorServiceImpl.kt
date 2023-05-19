package zw.dreamhub.services.impl

import com.google.zxing.BarcodeFormat
import com.google.zxing.client.j2se.MatrixToImageWriter
import com.google.zxing.qrcode.QRCodeWriter
import org.springframework.stereotype.Service
import zw.dreamhub.services.QRCodeGeneratorService
import java.io.File
import javax.imageio.ImageIO

@Service
class QRCodeGeneratorServiceImpl : QRCodeGeneratorService {

    val imageFormat: String = "png"
    val mediaDir: String = "media"

    override fun generate(data: String) {
        val barcodeWriter = QRCodeWriter()
        val bitMatrix = barcodeWriter.encode(data, BarcodeFormat.QR_CODE, 200, 200)
        val bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix)
        val path = getPath(data)
        ImageIO.write(bufferedImage, imageFormat, File(path))
    }

    private fun getPath(data: String): String {
        val home = System.getProperty("user.dir")
        val path = home + File.separator + mediaDir
        val storage = File(path)
        if (!storage.exists()) {
            storage.mkdirs()
        }
        return path + File.separator + data + "." + imageFormat
    }

}