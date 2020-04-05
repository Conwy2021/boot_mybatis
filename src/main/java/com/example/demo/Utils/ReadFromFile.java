package com.example.demo.Utils;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Random;

/**
 * @Author:LiuKangwei
 * @Date:2020/4/4 17:58
 * @Description:
 */
@Slf4j
public class ReadFromFile {


    public static String makewenjian(File file) {

        String msg;

        //file = new File(path);
        File parentFile = file.getParentFile();
        log.info(parentFile.toString());
        if (!parentFile.exists()) {

            parentFile.mkdirs();
        }


        try {
            if (!file.exists()) {
                //file.mkdirs();//创键目录
                file.createNewFile();//创建文件 如何中间有目录 就会创建失败
                msg = "创建完成";
                return msg;
            } else {

                msg = "文件已存在";
                return msg;
            }
        } catch (IOException ex) {

            ex.printStackTrace();
            msg = "出错了";
            return msg;
        }


    }

    /**
     * 清空文件内容
     *
     * @param
     */
    public static void clearInfoForFile(File file) {

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String readwenjian(String wenjianjueduiluidng) {
        File file = new File(wenjianjueduiluidng);


        System.out.println("以字节为单位读取文件内容，一次读一个字节：");
        try {


            FileInputStream in = new FileInputStream(file);
            int tempbyte;//读出来的字节
            while ((tempbyte = in.read()) != -1) {
                System.out.println(tempbyte);
                System.out.println((char) tempbyte);
            }

            System.out.println(tempbyte);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "读取完成";
    }

    public static String readwenjian2(String wenjianjueduiluidng) throws IOException {

        System.out.println("以字节为单位读取文件内容，一次读多个字节：");
        // 一次读多个字节
        byte[] tempbytes = new byte[1];
        int byteread = 0;
        FileInputStream fileInputStream = new FileInputStream(wenjianjueduiluidng);
        ReadFromFile.showAvailableBytes(fileInputStream);
        // 读入多个字节到字节数组中，byteread为一次读入的字节数
        while ((byteread = fileInputStream.read(tempbytes)) != -1) {
            System.out.write(tempbytes, 0, byteread);
        }
        return null;
    }

    /**
     * 显示输入流中还剩的字节数
     */
    private static void showAvailableBytes(InputStream in) {
        try {
            System.out.println("当前字节输入流中的字节数为:" + in.available());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readwenjian3(String wenjianjueduiluidng) throws IOException {

        File file = new File(wenjianjueduiluidng);
        BufferedReader reader = null;

        System.out.println("以行为单位读取文件内容，一次读一整行：");
        reader = new BufferedReader(new FileReader(file));
        String tempString = null;
        int line = 1;
        // 一次读入一行，直到读入null为文件结束
        while ((tempString = reader.readLine()) != null) {
            // 显示行号
            System.out.println("line " + line + ": " + tempString);
            line++;
        }

        log.info("----{}",tempString);
        reader.close();
        return tempString;
    }

        /**
         * @Author:LiuKangwei
         * @Return:java.lang.String
         * @Date:2020/4/4 19:35
         * @Description: FileWriter 写入文件 打开文件时光标是在最前面的 有疑惑
         */
        public static String readwenjianbyByte () {
//todo
            return "";
        }

        public static String writewenjian (String neirong, String fileName){

            //打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件

            try {
                FileWriter writer = new FileWriter(fileName, true);//true 是追加内容

                writer.write(neirong);
                writer.close();


            } catch (IOException e) {
                e.printStackTrace();
                return "写入失败";
            }
            return "写入完成";
        }


        //创建指定大小的文件 不追加

        public static String makeZhiDingDaXiaoWenjian (String path, String daxiao){
            File file = new File(path);
            makewenjian(file);

            OutputStreamWriter outputStreamWriter = null;
            //用byte写入
            try {
                FileOutputStream output = new FileOutputStream(path);


                outputStreamWriter = new OutputStreamWriter(output, "utf-8");


                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);


                Random random = new Random();
                StringBuilder builder = new StringBuilder();
                Integer integer = Integer.valueOf(daxiao);

                int leng = integer * 1024 * 1024;


                for (int i = 0; i < leng; i++) {
                    int rd = random.nextInt(10);

                    builder.append(rd);
                }

                log.info("length is {}", builder.length());

                long length = file.length();
                log.info("写入前文件大小 {}", length);


                bufferedWriter.write(builder.toString());//这个写入光标是在文字最后
                long length2 = file.length();
                //
                log.info("写入write后文件大小 {}", length2);

                bufferedWriter.flush();
                long length3 = file.length();
                log.info("写入flush后文件大小 {}", length3);
                bufferedWriter.close();
                long length4 = file.length();
                log.info("写入close后文件大小 {}", length4);
            } catch (IOException ex) {
                ex.printStackTrace();
                return "写入出错";
            }


            return "写入成功";
        }


        //创建指定大小的文件 追加

        public static String makeZhiDingDaXiaoWenjianadd (String path, String daxiao){
            File file = new File(path);
            makewenjian(file);//创建文件

            OutputStreamWriter outputStreamWriter2 = null;
            //用byte写入
            try {
                FileOutputStream output = new FileOutputStream(path, true);


                outputStreamWriter2 = new OutputStreamWriter(output, "utf-8");


                BufferedWriter bufferedWriter2 = new BufferedWriter(outputStreamWriter2);


                Random random = new Random();
                StringBuilder builder = new StringBuilder();
                Integer integer = Integer.valueOf(daxiao);

                int leng = integer * 1024 * 1024;


                for (int i = 0; i < leng; i++) {
                    int rd = random.nextInt(10);
                    // log.info("random is {}", i); 这里打印很耗时 io 输出 估计会阻塞
                    builder.append(rd);
                }

                log.info("length is {}", builder.length());

                long length = file.length();
                log.info("写入前文件大小 {}", length);


                bufferedWriter2.write(builder.toString());//这个写入光标是在文字最后
                long length2 = file.length();
                //
                log.info("写入write后文件大小 {}", length2);

                bufferedWriter2.flush();
                long length3 = file.length();
                log.info("写入flush后文件大小 {}", length3);
                bufferedWriter2.close();
                long length4 = file.length();
                log.info("写入close后文件大小 {}", length4);
            } catch (IOException ex) {
                ex.printStackTrace();
                return "写入出错";
            }


            return "写入成功";
        }
    }
