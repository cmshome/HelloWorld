package com.lxk.test;

import java.io.*;

/**
 * @author LiXuekai on 2019/11/20
 */
public class ChinaEzBuilder {
    public ChinaEzBuilder() {
    }

    private static String[] process(File file) {
        String[] result = null;
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        Object var8;
        try {
            StringBuilder city = new StringBuilder();
            StringBuilder ip = new StringBuilder();
            fis = new FileInputStream(file);
            isr = new InputStreamReader(fis, "utf-8");
            br = new BufferedReader(isr);
            String line = br.readLine();
            if (line != null) {
                int firstChar = line.charAt(0);
                if (firstChar < '0' || firstChar > '9') {
                    line = line.substring(8);
                }

                for(; line != null; line = br.readLine()) {
                    String[] s = line.split(",");
                    if (s.length == 5) {
                        city.append(line + "\r\n");
                    } else if (s.length == 3) {
                        ip.append(line + "\r\n");
                    }
                }

                result = new String[]{city.toString(), ip.toString()};
                return result;
            }

            var8 = null;
        } catch (Exception var19) {
            var19.printStackTrace();
            return result;
        } finally {
            try {
                if (br != null) {
                    br.close();
                }

                if (isr != null) {
                    isr.close();
                }

                if (fis != null) {
                    fis.close();
                }
            } catch (Exception var18) {
                var18.printStackTrace();
            }

        }

        return (String[])var8;
    }

    public static void main(String[] args) {
        if (args == null || args.length < 2) {
            System.err.println("parameter error,You need to provide at least two parameters,src and target ");
            System.err.println("for example: java -jar china.ez-builder.jar /src/china.ez /target/china.ez");
            System.exit(-1);
        }

        String srcPath = args[0];
        String targetPath = args[1];
        File srcFile = new File(srcPath);
        File targetFile = new File(targetPath);
        if (srcFile.getPath().equals(targetFile.getPath())) {
            System.out.println("parameter error,src and target are the same");
            System.exit(-1);
        }

        if (!srcFile.exists()) {
            System.out.println("src china.ez not exists");
            System.exit(-1);
        }

        boolean override = false;
        if (args.length == 3) {
            try {
                override = Boolean.valueOf(args[2]);
            } catch (Exception var7) {
                System.out.println("parameter 3:{" + args[2] + "} error:allowed true or false");
                override = false;
            }
        }

        if (targetFile.exists()) {
            if (override) {
                System.out.println("target file exists ,will override it");
                targetFile.delete();
            } else {
                System.out.println("target file exists ,use a another path");
                System.exit(-1);
            }
        }

        String[] result = process(srcFile);
        writeFile(targetFile, result);
        System.out.println("write success");
        System.exit(1);
    }

    private static void writeFile(File targetFile, String[] chinaEz) {
        RandomAccessFile writeFile = null;

        try {
            if (chinaEz != null && chinaEz.length == 2) {
                byte[] cityByte = chinaEz[0].getBytes("utf-8");
                byte[] ipByte = chinaEz[1].getBytes("utf-8");
                writeFile = new RandomAccessFile(targetFile, "rw");
                writeFile.writeInt(cityByte.length);
                writeFile.writeInt(ipByte.length);
                writeFile.write(cityByte);
                writeFile.write(ipByte);
                return;
            }
        } catch (Exception var14) {
            var14.printStackTrace();
            return;
        } finally {
            if (writeFile != null) {
                try {
                    writeFile.close();
                } catch (IOException var13) {
                    var13.printStackTrace();
                }
            }

        }

    }
}
