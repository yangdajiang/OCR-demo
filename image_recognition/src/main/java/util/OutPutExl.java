package util;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;

/**
 * Created by 15114 on 2018/4/21.
 */
public class OutPutExl {

    public OutPutExl(String dirPath) throws IOException {

        int i = 1;

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("sheet");
        sheet.setDefaultRowHeightInPoints(15);
        sheet.setDefaultColumnWidth(25);
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("企业名称");
        row.createCell(1).setCellValue("企业注册号");

        BufferedReader bf = null;
        String s = null , str = null , name = null , number = null;
        File[] files = new File(dirPath).listFiles();

        for(File f:files){

            if(f.getName().substring(f.getName().indexOf(".")+1).equals("txt")){

                StringBuffer buffer = new StringBuffer();
                bf = new BufferedReader(new FileReader(f.getAbsolutePath()));
                while((s = bf.readLine())!=null){
                    //System.out.print(s);
                    buffer.append(s);
                }

                str = buffer.toString();
                str = str.replaceAll(" ","");
                if(str.length()<5){
                    continue;
                }
                name = str.substring(str.indexOf(":")+1,str.indexOf(":")+18);
                number = str.substring(str.lastIndexOf(":")+1);

                System.out.println(name+number);
                row = sheet.createRow(i);

                row.createCell(0).setCellValue(number);
                row.createCell(1).setCellValue(name);

                i++;
            }
        }

        String xslPath = dirPath + "\\xls";
        File file = new File(xslPath);
        if(!file.exists()){
            file.mkdir();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(xslPath + "\\1.xls");
        wb.write(fileOutputStream);
        fileOutputStream.close();

    }

}
