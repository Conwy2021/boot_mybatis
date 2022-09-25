import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author:LiuKangwei
 * @Date:2020/4/6 0:52
 * @Description:
 */
public class FileReadingTest {

    @Test
    public void tet() throws IOException {
        File file = new File("D:/youarebest/newTemp4.txt");
        FileInputStream in = new FileInputStream(file);
        int read = in.read();//读取下一个字节
        int read1 = in.read();
        int read2 = in.read();
        int read3 = in.read();
        System.out.println(read); System.out.println(read1);
        System.out.println(read2); System.out.println(read3);//一个字节一个读 没有就返回-1

        in.close();
        System.out.println("--------------");
        in=new FileInputStream(file);
        byte[] bytes = new byte[2];
        int read4 = in.read(bytes,0,2);//读到bytes数组中,读一个字节 #这个len是读几个字节 到内存中

        int available = in.available();
        System.out.println("-----"+available);//通道里的字节
        System.out.println(read4);
        System.out.println(Arrays.toString(bytes));
        int read5 = in.read(bytes,0,2);//第二次读的时候读了一个两个

        System.out.println(read5);
        System.out.println(Arrays.toString(bytes));
        int available2 = in.available();
        System.out.println("-----"+available2);
        System.out.println("--------------");


    }
    String path ="D:/youarebest/newTemp4.txt";
    @Test
    public void test2() throws IOException {

        File file = new File("D:/youarebest/newTemp4.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String s = bufferedReader.readLine();
        System.out.println(s);
        String s2 = bufferedReader.readLine();
        System.out.println(s2);
        String s3 = bufferedReader.readLine();
        System.out.println(s3);
        String s4 = bufferedReader.readLine();
        System.out.println(s4);

    }


    @Test
    public void test67(){

        for (int i=0;i<10;i++){
            System.out.println(i);
        }

        System.out.println("---------------");
        for(int a=10;a>0;a--){
            System.out.println(a);
        }

    }

    @Test
    public void test81() {
        String a = new String("a");


        int i = a.hashCode();
        System.out.println(i);

        String b="a";
        int i1 = b.hashCode();
        System.out.println(i1);

        String c =new String("a");
        System.out.println(c.hashCode());

    }

    @Test
    public void test98(){
        File file = new File("D:/youarebest/hello");
        boolean mkdir = file.mkdir();
        System.out.println(mkdir);


    }


    @Test
    public void test109() throws IOException {
        File file = new File("D:/youarebest/hello2/hello2.txt");
        //boolean mkdir = file.mkdir();//这是创建目录
        boolean newFile = file.createNewFile();//这是创建文件
        boolean directory = file.isDirectory();
        boolean file1 = file.isFile();
        //System.out.println(mkdir);


        System.out.println(newFile);
        System.out.println(directory);
        System.out.println(file1);


    }

    @Test
    public ArrayList<String> test126(){
        ArrayList<String> list = new ArrayList<>();

        if (list.size()>0){
            list.add("1");
        }else {
            list.add("2");
        }

        return list;
    }

}
