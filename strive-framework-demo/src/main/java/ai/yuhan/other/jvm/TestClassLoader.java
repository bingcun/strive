package ai.yuhan.other.jvm;

import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: bingcun.chen
 * @Date: 2021/9/25 10:41
 * @Version 1.0
 */
public class TestClassLoader {
    public static void main(String[] args) throws Exception{
        //初始化自定义类加载器，会先初始化父类ClassLoader，其中会把自定义类加载器的父加载器设置为应用程序类加载器AppClassLoader
         MyClassLoader classLoader = new MyClassLoader("D:\\Company_devops\\project\\strive\\strive-framework-demo\\target\\classes");
         //D盘创建 test/com/tuling/jvm 几级目录，将User类的复制类User1.class丢入该目录
         Class clazz = classLoader.loadClass("ai.yuhan.other.jvm.TestUser");
         Object obj = clazz.newInstance();
         Method method = clazz.getDeclaredMethod("sout", null);
         method.invoke(obj, null);
         System.out.println(clazz.getClassLoader().getClass().getName());
         }
    }
class MyClassLoader extends ClassLoader {
    private String classPath;

    public MyClassLoader(String classPath) {
        this.classPath = classPath;
    }

    private byte[] loadByte(String name) throws Exception {
        name = name.replaceAll("\\.", "/");
        FileInputStream fis = new FileInputStream(classPath + "/" + name
                + ".class");
        int len = fis.available();
        byte[] data = new byte[len];
        fis.read(data);
        fis.close();
        return data;
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] data = loadByte(name);
            //defineClass将一个字节数组转为Class对象，这个字节数组是class文件读取后最终的字节数组。
            return defineClass(name, data, 0, data.length);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassNotFoundException();
        }
    }
}