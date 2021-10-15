package ai.yuhan.other.datastructure.test;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.model.StylesTable;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExcelToTxtExecutor {
    private static StylesTable stylesTable;
    private static String file_name = "110000.xlsx;120000.xlsx;130000.xlsx;140000.xlsx;620000.xlsx;650000.xlsx";
    private static String input_dir = "D:\\test\\c\\";
    private static String out_name = "aa.txt";

    protected static ExecutorService scheduler = Executors.newFixedThreadPool(5);
    static CopyOnWriteArrayList<String> lists;


    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
    /*}
    {*/
        BufferedWriter bw  = null;
        try {
            List<CopyOnWriteArrayList<String>> result = new CopyOnWriteArrayList<>();
            if (file_name.contains(";")) {//循环读取文件
                String[] split = file_name.split(";");
//                writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(input_dir + out_name)));
                for (int a = 0; a < split.length; a++) {
                    lists = new CopyOnWriteArrayList<>();
                    System.out.println("1111开始解析excel");
                    String start = df.format(new Date());
                    System.out.println("开始时间" + start);
                    System.out.println("读取本地文件路径" + input_dir + split[a]);
                    File file = new File(input_dir + split[a]);
                    scheduler.execute(new BatchExcel(file, split[a], lists));
                    result.add(lists);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                scheduler.shutdown();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("程序结束");
            long end = new Date().getTime();

            System.out.println("开始时间" + end);

        }
    }
}


