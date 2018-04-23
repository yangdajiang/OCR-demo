package service;

import util.BinImages;
import util.OutPutExl;
import util.Recognition;

import java.io.IOException;

/**
 * Created by 15114 on 2018/4/21.
 */
public class Service {

    public Service(String dirPath) throws IOException, InterruptedException {

        String outPath = new BinImages().BinImages(dirPath);
        new Recognition(outPath);
        new OutPutExl(outPath);

    }
}
