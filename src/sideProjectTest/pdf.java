package sideProjectTest;

import com.itextpdf.text.pdf.*;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class pdf {

    public static void main(String[] args)  {


        String inputFilePath = "PloanApply.pdf";


        InputStream inputPath = null;
        PdfReader reader = null;
        PdfStamper stamp = null;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        InputStream is = null;

        String fontPath = "/Users/ed/ThinkPower/ccdscore/target/classes/pdf/PingFang_Regular.ttf";

        try {

            File f = new File(inputFilePath);
            File ff = new File(fontPath);
//            System.out.println(f.exists());
//            System.out.println(f.length());
//            System.out.println(f.getName());
//
//
//            System.out.println(ff.exists());
//            System.out.println(ff.length());
//            System.out.println(ff.getName());


//            ClassPathResource trueType = new ClassPathResource(fontPath);
//            is = trueType.getInputStream();

//            byte[] bytes = IOUtils.toByteArray(is);
            BaseFont chineseFont = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED,
                    true, null, null);

//            ClassPathResource pdf = new ClassPathResource(inputFilePath);
            inputPath = new FileInputStream(f);
            reader = new PdfReader(inputPath);
            stamp = new PdfStamper(reader, buffer);
            stamp.getAcroFields().setGenerateAppearances(true);


            AcroFields fields =  stamp.getAcroFields();

            Set<String> fldNames = fields.getFields().keySet();


            System.out.println(fields.getFields().isEmpty());


            for (String fldName : fldNames) {
                System.out.println( fldName + ": " + fields.getField( fldName ) );
            }


            Iterator<Map.Entry<String, AcroFields.Item>> pdfItor = stamp.getAcroFields().getFields().entrySet().iterator();



        } catch (Exception e) {

            System.out.println(e);
            e.getStackTrace();
        } finally {
            try{


            if (inputPath != null)
                inputPath.close();
            if (stamp != null)
                stamp.close();
            if (reader != null)
                reader.close();
            if (is != null)
                is.close();

            } catch (Exception e) {
                e.fillInStackTrace();
            }
        }
    }


}
