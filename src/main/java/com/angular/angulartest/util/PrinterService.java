package com.angular.angulartest.util;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPrintable;
import org.apache.pdfbox.printing.Scaling;
import org.springframework.stereotype.Service;

import javax.print.PrintService;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.Sides;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;

import javax.print.DocFlavor;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.PrintRequestAttributeSet;

@Service
public class PrinterService {

    public static String[] prlist(String pri_flag){
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.PNG;
        if("0".equals(pri_flag)){//默认打印机
            String[] ps_name_arr = new String[1];
            PrintService PS = PrintServiceLookup.lookupDefaultPrintService();
            String ps_name = PS.getName();
            ps_name_arr[0] = ps_name;
            return ps_name_arr;
        }else if("1".equals(pri_flag)){
            //可用的打印机列表(字符串数组)
            PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
            String[] ps_name_arr = new String[printService.length];
            for(int i=0;i<printService.length;i++){
                ps_name_arr[i] =printService[i].getName();
            }
            return ps_name_arr;
        }
        return null;
    }

    //word转化pdf，传入转换前的文件路径（例："E:\\a.docx"）和转换后的文件路径（例："E:\\a.pdf"）
    public static void wordToPDF(String sFilePath,String toFilePath) {
        System.out.println("启动 Word...");
        long start = System.currentTimeMillis();
        ActiveXComponent app = null;
        Dispatch doc = null;
        try {
            app = new ActiveXComponent("Word.Application");
            app.setProperty("Visible", new Variant(false));
            Dispatch docs = app.getProperty("Documents").toDispatch();
            doc = Dispatch.call(docs, "Open", sFilePath).toDispatch();
            System.out.println("打开文档:" + sFilePath);
            System.out.println("转换文档到 PDF:" + toFilePath);
            File tofile = new File(toFilePath);
            if (tofile.exists()) {
                tofile.delete();
            }
            Dispatch.call(doc, "SaveAs", toFilePath, // FileName
                    17);//17是pdf格式
            long end = System.currentTimeMillis();
            System.out.println("转换完成..用时：" + (end - start) + "ms.");

        } catch (Exception e) {
            System.out.println("========Error:文档转换失败：" + e.getMessage());
        } finally {
            Dispatch.call(doc, "Close", false);
            System.out.println("关闭文档");
            if (app != null)
                app.invoke("Quit", new Variant[]{});
        }
        // 如果没有这句话,winword.exe进程将不会关闭
        ComThread.Release();
    }


    //这里传入的文件为word转化生成的pdf文件
    public static void PDFprint(File file ,String printerName) throws Exception {
        PDDocument document = null;
        try {
            document = PDDocument.load(file);
            PrinterJob printJob = PrinterJob.getPrinterJob();
            printJob.setJobName(file.getName());
            if (printerName != null) {
                // 查找并设置打印机
                //获得本台电脑连接的所有打印机
                PrintService[] printServices = PrinterJob.lookupPrintServices();
                if(printServices == null || printServices.length == 0) {
                    System.out.print("打印失败，未找到可用打印机，请检查。");
                    return ;
                }
                PrintService printService = null;
                //匹配指定打印机
                for (int i = 0;i < printServices.length; i++) {
                    //System.out.println(printServices[i].getName());
                    if (printServices[i].getName().contains(printerName)) {
                        printService = printServices[i];
                        break;
                    }
                }

                if(printService!=null){
                    printJob.setPrintService(printService);
                }else{
                    System.out.print("打印失败，未找到名称为" + printerName + "的打印机，请检查。");
                    return ;
                }
            }
            //设置纸张及缩放
            PDFPrintable pdfPrintable = new PDFPrintable(document, Scaling.ACTUAL_SIZE);
            //设置多页打印
            Book book = new Book();
            PageFormat pageFormat = new PageFormat();
            //设置打印方向
            pageFormat.setOrientation(PageFormat.PORTRAIT);//纵向
            pageFormat.setPaper(getPaper());//设置纸张
            book.append(pdfPrintable, pageFormat, document.getNumberOfPages());
            printJob.setPageable(book);
            printJob.setCopies(1);//设置打印份数
            //添加打印属性
            HashPrintRequestAttributeSet pars = new HashPrintRequestAttributeSet();
            pars.add(Sides.DUPLEX); //设置单双页
            printJob.print(pars);
        }finally {
            if (document != null) {
                try {
                    document.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static Paper getPaper() {
        Paper paper = new Paper();
        // 默认为A4纸张，对应像素宽和高分别为 595, 842
        int width = 595;
        int height = 842;
        // 设置边距，单位是像素，10mm边距，对应 28px
        int marginLeft = 10;
        int marginRight = 0;
        int marginTop = 10;
        int marginBottom = 0;
        paper.setSize(width, height);
        // 下面一行代码，解决了打印内容为空的问题
        paper.setImageableArea(marginLeft, marginRight, width - (marginLeft + marginRight), height - (marginTop + marginBottom));
        return paper;
    }
    public static void main(String[] args) throws Exception {
        wordToPDF("G:\\生成文件.docx","G:\\生成文件.pdf");
        File file = new File("G:\\生成文件.pdf");
        PDFprint(file,"Lenovo M7206W");
        /*String[] str_arr = prlist("0");
        if(str_arr==null){
            System.out.println("无");
        }else{
            for(int i=0;i<str_arr.length;i++){
                System.out.println(str_arr[i]);
            }
        }*/
    }
}
