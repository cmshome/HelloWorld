package com.lxk.fileTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Properties;

/**
 * 文件测试
 * <p>
 * @author lxk on 2017/5/16
 */
public class FileTest {
    public static void main(String[] args) {
        //testFileIsExists();
        testRenameFile();

    }

    /**
     * 重命名一个文件：将原来的文件直接修改
     */
    private static void testRenameFile() {
        String filePath = "D:/test/我是.conf";
        try {
            File src = new File(filePath);
            filePath += ".properties";
            File des = new File(filePath);
            if (des.exists()) {
                boolean res = des.delete();
                if (!res) {
                    System.out.println("Failed to delete file");
                }
            }
            if (!src.renameTo(des)) {
                System.out.println("Failed to renameTo file");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 一个目录要是不存在，则创建目录，然后写文件。
     */
    private static void testFileIsExists() {
        String path = "D:/lxk/conf/es-source.properties";
        File file = new File(path);
        System.out.println(file.getParentFile());
        if (!file.getParentFile().exists()) {
            boolean result = file.getParentFile().mkdirs();
            if (!result) {
                System.out.println("创建失败");
            }
        }
        Properties properties = new Properties();
        properties.setProperty("sss", "ssa");
        properties.setProperty("ssasds", "ssaas");
        OutputStreamWriter outputStreamWriter = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path, false);//true表示追加打开,false每次都是清空再重写
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, "utf-8");
            properties.store(outputStreamWriter, "");
        } catch (Exception e) {
            System.out.println("writeOrderedPropertiesFile IOException:" + e.getMessage());
        } finally {
            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (IOException e) {
                    System.out.println("writeOrderedPropertiesFile close IOException:" + e.getMessage());
                }
            }
        }
    }


}
