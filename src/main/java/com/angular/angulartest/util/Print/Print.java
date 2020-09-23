package com.angular.angulartest.util.Print;



import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;
import org.apache.pdfbox.printing.PDFPrintable;
import org.apache.pdfbox.printing.Scaling;

import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterJob;
import java.io.InputStream;
import java.net.URL;
/**
 * fileUrl 文件链接
 * printService 指定打印机
 *
 * @Author: Robert·Ran
 * @CreateTime: 2019/5/17 11:59
 * @Description: 打印方法
 */
public class Print {
    public static void printFile(String fileUrl, PrintService printService, String jobName) throws Exception {
        URL url = new URL(fileUrl);
        InputStream is = url.openStream();
        // 读取pdf文件
        PDDocument document = PDDocument.load(is);
        // 创建打印任务
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("文件_" + jobName);
        job.setPrintService(printService);
        job.setPageable(new PDFPageable(document));
        Paper paper = new Paper();
        // 设置打印纸张大小
        paper.setSize(595, 842); // 值为点 1 = 1/72 inch
        // 设置打印位置与坐标
        paper.setImageableArea(0, 0, paper.getWidth(), paper.getHeight()); // no margins
        PageFormat pageFormat = new PageFormat();
        pageFormat.setPaper(paper);
        Book book = new Book();
        /**
         *实际大小 ACTUAL_SIZE,
         *缩小     SHRINK_TO_FIT,
         *拉伸     STRETCH_TO_FIT,
         *适应     SCALE_TO_FIT;
         **/
        book.append(new PDFPrintable(document, Scaling.SCALE_TO_FIT), pageFormat, 1);
        job.setPageable(book);
        job.print();
    }

    /**
     * printerName 指定打印机名称
     *
     * @Author: Robert·Ran
     * @CreateTime: 2019/5/17 11:59
     * @Description: 指定打印机, 若无指定打印机则调用默认打印机
     */
    public static PrintService specifyPrinter(String printerName) {
        DocFlavor psInFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
        HashPrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        PrintService printService[] = PrintServiceLookup.lookupPrintServices(psInFormat, pras);
        PrintService myPrinter = null;
        // 遍历所有打印机如果没有选择打印机或找不到该打印机则调用默认打印机
        for (PrintService printService2 : printService) {
            String svcName = printService2.toString();
            if (svcName.contains(printerName)) {
                myPrinter = printService2;
                break;
            }
        }
        if (myPrinter == null) {
            myPrinter = PrintServiceLookup.lookupDefaultPrintService();
        }
        return myPrinter;
    }
}
