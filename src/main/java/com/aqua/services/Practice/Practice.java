

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Practice {

    public static void main(String[] args) throws IOException {
        File f1 = new File("C:\\Users\\Maor\\Desktop\\xml's\\__Oppo1.xml");
        File f2 = new File("C:\\Users\\Maor\\Desktop\\xml's\\__Oppo2.xml");
        boolean result = FileUtils.contentEqualsIgnoreEOL(f1, f2, "utf-8");
        if(!result){
            System.out.println("Files content is not equal.");
        }else{
            System.out.println("Files content is equal.");
        }

        result = FileUtils.contentEqualsIgnoreEOL(f1, f1, "utf-8");
        if(!result){
            System.out.println("Files content is not equal.");
        }else{
            System.out.println("Files content is equal.");
        }
    }

}