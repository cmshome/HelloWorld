package com.lxk.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * 最开始新建的测试类，各种测试都有。
 * <p>
 * @author lxk on 2016/8/31
 */
public class NoGroupTest {
    public static void main(String[] args) {
        if (getNum() == 1) {
            testArrayList();
            testCloseFileStream();
            testChar("aa", "aa");
            testStringBuilder();
            testFileStream();
            testReference();
            testOutAllFile();
            testLoopOutAllFileName("F:/桌面文件");
            testOutAllDir();
            testFileClass();
            testFileConstructor();
            testFinal();
            testValueOfAndParseX();
            testHashSet();
            testArrayReverse();
            testSortTwoSortedArray();
        } else {
            testRandom();
        }
    }

    /**
     * 使用随机算法产生一个数，要求把1-1000W之间这些数全部生成。
     * （考察高效率，解决产生冲突的问题）
     * {@link com.lxk.random.Main#createRandom4()}
     */
    private static void testRandom() {
        int value = 10000000;
        //int类型最大值：2的32次方 - 1 = Integer.MAX_VALUE = 2147483647，二十亿多,真够啦 。
        Set<Integer> result = Sets.newHashSetWithExpectedSize(value);
        Random random = new Random();
        long a = System.currentTimeMillis();
        while (result.size() < value + 1) {
            int i = random.nextInt(value + 1);
            result.add(i);
        }

        System.out.println("\r<br> 执行耗时 : " + (System.currentTimeMillis() - a) / 1000f + " 秒 ");
        System.out.println("完了，集合大小为" + result.size());
    }

    /**
     * 两个有序数组的合并排序
     * (默认2个有序数组都是升序)
     */
    private static void testSortTwoSortedArray() {
        int[] a = {12, 32, 63, 84, 105};
        int[] b = {12, 32, 53, 74, 95};
        int length1 = a.length;
        int length2 = b.length;
        int newArrayLength = length1 + length2;
        int[] result = new int[newArrayLength];
        int i = 0, j = 0, k = 0;   //i:用于标示a数组    j：用来标示b数组  k：用来标示传入的数组

        while (i < length1 && j < length2) {
            /* 元素不管重复与否，直接给合并到一起 */
            //if (a[i] <= b[j]) {
            //    result[k++] = a[i++];
            //} else {
            //    result[k++] = b[j++];
            //}

            /* 去重复元素，但是空间利用率还是浪费啦，看结果后面有默认的2个0显示 */
            if (a[i] < b[j]) {
                result[k++] = a[i++];
            } else if (a[i] == b[j]) {
                result[k++] = a[i];
                //在某个位置上2个值相等的话，取哪个都一样，
                // 然后这个相等的位置的2个值都可以不用比啦，都直接向后移动1，继续比较
                j++;
                i++;
            } else {
                result[k++] = b[j++];
            }
        }

        /* 后面while循环是用来保证两个数组比较完之后剩下的一个数组里的元素能顺利传入结果数组 */
        while (i < a.length) {
            result[k++] = a[i++];
        }

        while (j < b.length) {
            result[k++] = b[j++];
        }

        System.out.println(Arrays.toString(result));
    }

    /**
     * 一个数组的倒序
     */
    private static void testArrayReverse() {
        int[] data = {22, 12, 33, 24, 75};
        System.out.println("原顺序" + Arrays.toString(data));
        int length = data.length;
        for (int i = 0; i < length / 2; i++) {
            int temp = data[i];
            data[i] = data[length - 1 - i];
            data[length - 1 - i] = temp;
        }
        System.out.println("倒序后" + Arrays.toString(data));
    }

    /**
     * 测试HashSet原理
     */
    private static void testHashSet() {
        Set<String> s = Sets.newHashSet();
        System.out.println(s);
        Maps.newHashMapWithExpectedSize(3);
    }

    /**
     * 测试 valueOf和parseX的差别
     */
    private static void testValueOfAndParseX() {
        String s = "100";
        Integer i = Integer.valueOf(s);//返回integer
        System.out.println(i);
        int ii = Integer.parseInt(s);//返回int
        System.out.println(ii);
    }

    /**
     * 测试 Java final
     */
    private static void testFinal() {
        String a = "helloaa";
        final String b = "hello";
        String d = "hello";
        String c = b + "aa";
        String e = d + "aa";
        System.out.println((a == c));
        System.out.println((a == e));
    }

    /**
     * 主方法开关控制器，控制只执行哪个测试方法
     */
    private static int getNum() {
        return 2;
    }

    /**
     * 测试file的构造方法
     */
    private static void testFileConstructor() {
        //以下三个public构造方法
        //构造函数File(String pathname)
        File f1 = new File("F:/1.txt");
        System.out.println(f1);
        //File(String parent,String child)
        File f2 = new File("F:", "1.txt");
        System.out.println(f2);
        //File(File parent,String child)
        File f3 = new File("f:");//separator 跨平台分隔符
        File f4 = new File(f3, "1.txt");
        System.out.println(f4);
    }

    /**
     * 测试 File Class 方法
     */
    private static void testFileClass() {
        File file = new File("F:/桌面.txt");
        if (!file.exists()) {//判断文件是否存在
            boolean result = false;
            try {
                result = file.createNewFile();  //创建文件
            } catch (IOException e) {
                //打印log
            }
            if (result) {
                outFileInformation(file);
                if (file.renameTo(new File("F:/修改.txt"))) {
                    System.out.println("修改名称成功");
                    outFileInformation(file);
                } else {
                    System.out.println("修改名称失败");
                }
            }
        } else {
            outFileInformation(file);
            if (file.delete()) {
                System.out.println("删除OK");
            } else {
                System.out.println("删除失败");
            }
        }
    }

    /**
     * 输出文件的信息
     *
     * @param file 文件
     */
    private static void outFileInformation(File file) {
        if (file == null) {
            return;
        }
        System.out.println("---输出开始---");
        System.out.println("getName()         " + file.getName());
        System.out.println("toString()        " + file.toString());
        System.out.println("getPath()         " + file.getPath());
        System.out.println("getParent()       " + file.getParent());
        System.out.println("getAbsoluteFile() " + file.getAbsoluteFile());
        System.out.println("getAbsolutePath() " + file.getAbsolutePath());
        System.out.println("getTotalSpace()   " + file.getTotalSpace());
        System.out.println("isDirectory()     " + file.isDirectory());
        System.out.println("isHidden()        " + file.isHidden());
        System.out.println("isFile()          " + file.isFile());
        System.out.println("list()            " + Arrays.toString(file.list()));
        System.out.println("---输出结束---");
    }

    /**
     * 输出file的全路径名称
     */
    private static void testOutAllDir() {
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory();
            }
        };
        File dir = new File("F:");
        File[] files = dir.listFiles(fileFilter);
        if (files == null) {
            return;
        }
        System.out.println(files.length);
        if (files.length == 0) {
            System.out.println("目录不存在或它不是一个目录");
        } else {
            for (File file : files) {
                System.out.println(file.toString());
            }
        }
    }

    /**
     * 递归读取文件夹下的 所有文件
     *
     * @param testFileDir 文件名或目录名
     */
    private static void testLoopOutAllFileName(String testFileDir) {
        if (testFileDir == null) {
            //因为new File(null)会空指针异常,所以要判断下
            return;
        }
        File[] testFile = new File(testFileDir).listFiles();
        if (testFile == null) {
            return;
        }
        for (File file : testFile) {
            if (file.isFile()) {
                System.out.println(file.getName());
            } else if (file.isDirectory()) {
                System.out.println("-------this is a directory, and its files are as follows:-------");
                testLoopOutAllFileName(file.getPath());
            } else {
                System.out.println("文件读入有误！");
            }
        }
    }

    /**
     * 输出指定目录下的所有文件名称包括目录名称
     */
    private static void testOutAllFile() {
        File dir = new File("d:");
        String[] children = dir.list();
        if (children == null) {
            System.out.println("目录不存在或它不是一个目录");
        } else {
            for (String filename : children) {
                System.out.println(filename);
            }
        }
    }

    /**
     * 测试四种引用类型--强;软;弱;虚.
     */
    private static void testReference() {
        //创建一个强引用
        String str = "hello";
        //创建引用队列, <String>为范型标记，表明队列中存放String对象的引用
        ReferenceQueue<String> rq = new ReferenceQueue<>();

        //创建一个软引用，它引用"hello"对象，并且与rq引用队列关联
        //<String>为范型标记，表明SoftReference会弱引用String对象
        SoftReference<String> sf = new SoftReference<>(str, rq);
        str = null;//取消"hello"对象的强引用
        String str1 = sf.get(); //假如"hello"对象没有被回收，str1引用"hello"对象
        System.out.println(str1);

        //创建一个弱引用，它引用"hello"对象，并且与rq引用队列关联
        //<String>为范型标记，表明WeakReference会弱引用String对象
        WeakReference<String> wf = new WeakReference<>(str, rq);
        System.out.println(wf);
    }

    /**
     * 测试逐行读txt文件并正确关闭文件流
     */
    private static void testFileStream() {
        final Logger LOG = LoggerFactory.getLogger(NoGroupTest.class);
        InputStreamReader read = null;
        BufferedReader bufferedReader = null;
        String serverFile = "D:/ss.txt";
        Set<String> tempSet = Sets.newHashSet();
        List<String> allRulesList = Lists.newArrayList();
        String encoding = "utf-8";
        try {
            //new FileInputStream(serverFile)可能异常
            read = new InputStreamReader(new FileInputStream(serverFile), encoding);//考虑到编码格式,serverFile 将要读取的文件的目录

            bufferedReader = new BufferedReader(read);
            String lineTxt;
            //bufferedReader.readLine()可能异常
            while ((lineTxt = bufferedReader.readLine()) != null) {
                if (tempSet.add(lineTxt)) {   //set 去重复
                    if (lineTxt.isEmpty()) {//处理空行
                        continue;
                    }
                    allRulesList.add(lineTxt);
                }
            }
        } catch (IOException e) {
            LOG.debug("读取文件异常:" + e.getMessage());
        } finally {
            if (read != null) {
                try {
                    read.close();
                } catch (IOException e) {
                    LOG.debug("关闭文件read流异常:" + e.getMessage());
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    LOG.debug("关闭文件bufferedReader流异常:" + e.getMessage());
                }
            }
        }

        //打印输出，验证执行结果。
        for (String s : allRulesList) {
            System.out.println(s);
        }
    }

    /**
     * 测试StringBuilder用法
     */
    private static void testStringBuilder() {
        //估计一般的，上来就直接如下这么干了！简单粗暴。
        String s = "";
        for (int i = 0; i < 100; i++) {
            s += String.valueOf(i) + ";";
        }
        System.out.println("s = " + s);

        //实际上如下这个写法就好一点点，说明你的Java还是比上面的好一丢丢的
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append(String.valueOf(i)).append(";");
        }
        System.out.println("sb = " + sb);

        //至于StringBuilder这个类就是StringBuilder的加强版，强化了线程安全。
        //所以不涉及到线程操作的，就可以不考虑这个啦。
    }

    /**
     * 测试char类型数据的比较用 ==
     */
    private static void testChar(String s1, String s2) {
        char a = s1.charAt(1);
        char s = s2.charAt(1);
        int intA = 1;
        int intB = 13;

        System.out.println(intA);
        System.out.println(intB);
        if (a == s) {
            System.out.println("xx");
        } else {
            System.out.println("yyy");
        }
    }

    /**
     * 测试正确关闭文件流
     */
    private static void testCloseFileStream() {
        final Logger LOG = LoggerFactory.getLogger(NoGroupTest.class);
        String fileName = "";
        InputStream inputStream = null;
        try {
            //这里就会异常,如果文件名不存在的话。
            inputStream = new FileInputStream(fileName);
        } catch (IOException e) {
            //这个主要是把出现的异常给人看见，不然就算异常了，看不到就找不到问题所在。
            LOG.debug("loadProperties IOException:" + e.getMessage());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close(); // 关闭流
                } catch (IOException e) {
                    LOG.debug("inputStream close IOException:" + e.getMessage());
                }
            }
        }
    }

    /**
     * 测试ArrayList
     */
    private static void testArrayList() {
        int[] ints = {1, 2, 3, 4, 5};
        List list = Lists.newArrayList(Arrays.asList(ints));
        System.out.println("list's size is：" + list.size());
        System.out.println("list 的类型:" + list.get(0).getClass());
        System.out.println("list.get(0) == ints：" + list.get(0).equals(ints));

        Integer[] ints_ = {1, 2, 3, 4, 5};
        List list_ = Arrays.asList(ints_);
        System.out.println("list_'size：" + list_.size());
        System.out.println("list_.get(0) 的类型:" + list_.get(0).getClass());
        System.out.println("list_.get(0) == ints_[0]：" + list_.get(0).equals(ints_[0]));
    }


}

