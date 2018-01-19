package com.strongant.io;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * TODO
 * <p>
 * Created by bwh on 2017/8/10.
 * Contact me at <a href="mailto:baiwenhui@autobole.com">baiwenhui@autobole.com</a>
 *
 * @see
 * @since 2017/8/10
 */
public class InputStreamTest {

    public static void main(String[] args) throws Exception {



        String progressName =  ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(progressName.substring(0,progressName.indexOf('@')));


        long count = Long.MAX_VALUE;

        for (long i = 0; i < count; i++) {

            count--;

            InputStream stream = InputStreamTest.class.getResourceAsStream("/test.txt");



            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));

            int ch = 0;
            while ((ch=bufferedReader.read())!=-1){
                System.out.print((char)ch);
            }

            //手动关闭
            bufferedReader.close();
            stream.close();




            //打印当前程序运行的进程id
            printCurrentProcessId();

            Thread.sleep(1000);
        }
    }


    static void printCurrentProcessId() {
        try {
            java.lang.management.RuntimeMXBean runtime =
                    java.lang.management.ManagementFactory.getRuntimeMXBean();
            java.lang.reflect.Field jvm = runtime.getClass().getDeclaredField("jvm");
            jvm.setAccessible(true);
            sun.management.VMManagement mgmt =
                    (sun.management.VMManagement) jvm.get(runtime);
            java.lang.reflect.Method pid_method =
                    mgmt.getClass().getDeclaredMethod("getProcessId");
            pid_method.setAccessible(true);

            int pid = (Integer) pid_method.invoke(mgmt);
            System.out.println("current processId is " + pid);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    /**
     * 获得java进程id
     *
     * @author lichengwu
     * @created 2012-1-18
     *
     * @return java进程id
     */
    public static final String getPID() {
        String pid = System.getProperty("pid");
        if (pid == null) {
            RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
            String processName = runtimeMXBean.getName();
            if (processName.indexOf('@') != -1) {
                pid = processName.substring(0, processName.indexOf('@'));
            }
            System.setProperty("pid", pid);
        }
        return pid;
    }

}
