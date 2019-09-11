package com.lxk.fileTest.scanner;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

/**
 * scanner test
 *
 * @author LiXuekai on 2019/9/11
 */
public class ScannerTest {

    @Test
    public void read() {
        try {
            String s = System.getProperty("user.dir") + "/resources/source";
            File file = new File(s);
            String[] fileArray = file.list();
            if (fileArray == null) {
                return;
            }
            for (String fileName : fileArray) {
                List<String> list = readFile(s + "/" + fileName);
                write2File(list, fileName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private List<String> readFile(String path) {
        List<String> list = Lists.newArrayList();
        try (Scanner scanner = new Scanner(new File(path), "gbk")) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                list.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private static void write2File(List<String> text, String name) {
        PrintWriter pw = null;
        try {
            final File file = new File(System.getProperty("user.dir") + "/resources/target/" + name);
            FileWriter fw = new FileWriter(file, true);
            pw = new PrintWriter(fw);
            for (String s : text) {
                pw.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.flush();
                pw.close();
            }
        }
    }
}