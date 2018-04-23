package util;

import java.io.File;
import java.io.IOException;

/**
 * Created by 15114 on 2018/4/21.
 */
public class Recognition {

    public Recognition(String dirPath) throws IOException, InterruptedException {

        File file = new File(dirPath);
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for (File f : files) {
                if(!f.isDirectory()){
                    Process process = Runtime.getRuntime().exec(
                        new String[]
                                {
                                        "tesseract",
                                        dirPath + f.getName(),
                                        dirPath + f.getName().substring(0,f.getName().indexOf(".")),
                                        "-l",
                                        "chi_sim"
                                });
                    process.waitFor();
                }
                //System.out.print(f.getName().substring(0,f.getName().indexOf(".")));
            }
        }else {
            return;
        }

    }

//    public static void main(String[] args) throws IOException {
//        new Recognition("C:\\Users\\15114\\Desktop\\test\\after");
//    }
}
