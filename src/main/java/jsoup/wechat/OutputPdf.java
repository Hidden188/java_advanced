package jsoup.wechat;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.util.Map;

public class OutputPdf {

    String pdfUrlBef = "D:\\chromdownload\\";
    String pdfUrlAft = ".pdf";
    String pdffile = "";
//写入文件的例子
// BufferedWriter out = new BufferedWriter(new FileWriter("runoob.txt"));
    public void parse(Map<String, String> htmlStr) {
        String title = htmlStr.get("title");
        String html = htmlStr.get("html");
        try {
            pdffile = pdfUrlBef + title + pdfUrlAft;
            File file = new File(pdffile);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //FileOutputStream os = new FileOutputStream(file);
        //output(os);
    }

    private void output(FileOutputStream os) {
        try {
            // 读取文件
            ITextRenderer iTextRenderer = new ITextRenderer();
            iTextRenderer.setDocument(pdffile);
            ITextFontResolver iTextFontResolver = iTextRenderer.getFontResolver();
            iTextFontResolver.addFont(pdffile, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            iTextRenderer.layout();
            iTextRenderer.createPDF(os);
            // 关闭文件流
            os.flush();
            os.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
