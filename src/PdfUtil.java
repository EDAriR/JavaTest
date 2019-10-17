
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.AcroFields.Item;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.Barcode39;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * 使用說明，首先必須先執行 genByteArrayOutputStreamPDF取的ByteArrayOutputStream型態
 * ByteArrayOutputStream可以轉成byte[]格式 可以針對byte[]的PDF去增加頁面資料
 * 最後再利用byte[]產生加密或不加密的檔案
 */
public class PdfUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(PdfUtil.class);

    /**
     * PDF 加密
     *
     * @param stamper
     * @param custID
     * @throws DocumentException
     */
    public static void encryptionPdf(PdfStamper stamper, String custID) throws DocumentException {
        stamper.setEncryption(custID.getBytes(), custID.getBytes(),
                PdfWriter.ALLOW_COPY | PdfWriter.ALLOW_SCREENREADERS | PdfWriter.ALLOW_PRINTING,
                PdfWriter.STANDARD_ENCRYPTION_128);
    }

    /**
     * PDF 增加條碼
     *
     * @param stamper
     * @param number
     * @throws DocumentException
     */
    public static void addBarcode(PdfStamper stamper, String number) throws DocumentException {
        Barcode39 barcode = new Barcode39();
        barcode.setCode(number);
        barcode.setAltText(number);
        barcode.setBarHeight(13);
        Image image = barcode.createImageWithBarcode(stamper.getOverContent(1), null, null);
        image.setAbsolutePosition(55, 762);
        stamper.getOverContent(1).addImage(image);
    }

    /**
     * 產生ByteArrayOutputStream型態的PDF 傳入pdfMap, 來源的pdf file, 要生成barCode的資料
     *
     * @param pdfMap
     * @param fileName
     * @param barCodeData
     * @return
     * @throws Exception
     */
    public static byte[] genByteArrayOutputStreamPDF(Map<String, String> pdfMap, String inputFilePath, List<PdfIncludImage> pdfIncludImages)
            throws Exception {

        InputStream inputPath = null;
        PdfReader reader = null;
        PdfStamper stamp = null;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        InputStream is = null;

        try {
            ClassPathResource trueType = new ClassPathResource("pdf/PingFang_Regular.ttf");
            is = trueType.getInputStream();

            byte[] bytes = IOUtils.toByteArray(is);
            BaseFont chineseFont = BaseFont.createFont("PingFang_Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED,
                    true, bytes, null);

            ClassPathResource pdf = new ClassPathResource(inputFilePath);
            inputPath = pdf.getInputStream();
            reader = new PdfReader(inputPath);
            stamp = new PdfStamper(reader, buffer);
            stamp.getAcroFields().setGenerateAppearances(true);


            Iterator<Entry<String, Item>> pdfItor = stamp.getAcroFields().getFields().entrySet().iterator();
//			writeDemoData(pdfMap, stamp, pdfItor);
            while (pdfItor.hasNext()) {
                Entry<String, Item> map = pdfItor.next();
                if (null != pdfMap.get(map.getKey())) {
                    stamp.getAcroFields().setFieldProperty(map.getKey(), "textfont", chineseFont, null);
                    stamp.getAcroFields().setField(map.getKey(), pdfMap.get(map.getKey()));
                }
            }
//			addBarcode(stamp, barCodeData);

            chineseFont.setSubset(true);
            chineseFont.setCompressionLevel(1);
            stamp.setFormFlattening(true);

            setImage(stamp , pdfIncludImages);

        } finally {
            if (inputPath != null)
                inputPath.close();
            if (stamp != null)
                stamp.close();
            if (reader != null)
                reader.close();
            if (is != null)
                is.close();
        }

        return buffer.toByteArray();
    }

    private static void writeDemoData(Map<String, String> pdfMap, PdfStamper stamp,
                                      Iterator<Entry<String, Item>> pdfItor) {
        Entry<String, Item> map = pdfItor.next();
        if(stamp.getAcroFields().getFieldType(map.getKey())==AcroFields.FIELD_TYPE_TEXT){
            pdfMap.put(map.getKey(), "99");
        }
        if(stamp.getAcroFields().getFieldType(map.getKey())==AcroFields.FIELD_TYPE_CHECKBOX){
            pdfMap.put(map.getKey(), "Y");
        }
    }

    private static void setImage(PdfStamper stamp , List<PdfIncludImage> pdfIncludImages)
            throws BadElementException, MalformedURLException, IOException, DocumentException {

        for(PdfIncludImage pdfIncludImage : pdfIncludImages) {
            stamp.getOverContent(pdfIncludImage.getOverContent()).addImage(pdfIncludImage.getScaleImage());
        }
    }

    /**
     * 產生加密過 ByteArrayOutputStream 型態的PDF 整理過後的byte[] PDF資料型態及密碼
     *
     * @param buff
     * @param pass
     * @return
     * @throws Exception
     */
    public static byte[] genEncryptionByteArrayOutputStreamPDF(byte[] buff, String pass){
        ByteArrayOutputStream finalBuffer = new ByteArrayOutputStream();
        try {
            PdfReader pdfReader = new PdfReader(buff);
            PdfStamper stamper = new PdfStamper(pdfReader, finalBuffer);

            encryptionPdf(stamper, pass.toUpperCase());
            stamper.setFormFlattening(true);
            stamper.close();
        }catch (Exception e) {
            LOGGER.error("Error Pdf file Encryption Error , Error stack: ", e);
//            throw CCDException.createByCode(ReturnCode.M0090);
        }
        return finalBuffer.toByteArray();
    }


}
