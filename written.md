1.抽象类和接口的区别？
抽象类和接口的区别主要有：
1）抽象类中可以包含抽象方法和非抽象方法，接口只能包含公开的抽象方法；
2）抽象类中的变量是各种类型的，而接口只能包含public abstract final 类型；
3）接口中不能含有静态代码块和静态方法，而抽象类中可以包含；
4）一个类只能继承一个抽象类，但是可以实现多个接口；
5）抽象类可以有构造方法，接口不能有；

2.java中如何创建一个新线程？

1）实现runable接口并重写run方法；
2）继承Thread类重写run方法；
3）实现Callable接口，重写call()方法；使用FutureTask类包装Callable对象，该FutureTask对象封装了该Callable对象的call()方法的返回值；
使用FutureTask对象作为Thread对象的target创建并启动线程，调用FutureTask对象的get()方法获得子线程执行结束后的返回值；

AIDL全称Android Interface Definition Language（AndRoid接口描述语言）是一种借口描述语言; 编译器可以通过aidl文件生成一段代码，通过预先定义的接口达到两个进程内部通信进程跨界对象访问的目的.AIDL的IPC的机制和COM或CORBA类似, 是基于接口的，但它是轻量级的。
3.AIDL支持的数据类型有Stirng，list，map，All native java datatype

4.求计算1-2+3-4+5-6...的方法，n很大，考虑性能？
答案：
```
public static  long fn(long n)
    {
        if(n<=0)
        {
            //1-2+3-4+5-6   当n为负数时，结果肯定为负数,使用加法结合律得出当n为偶数时,结果为(1-2)+(3-4)...(-1)+(-1),规律
            //当n为2时，结果为一个-1和，当n为4时，结果为2个-1的和,由此得出此结果的规律为(-1)*(n/2)

            //当n为奇数的时候，当n为1时，结果为1，当n为3时候,结果为2,当n为5时候,结果为3...
            //由此得出规律应该为：(-1)*(n/2)+n =-n/2+n   或者 (n+1)/2
            //>>(右移)
            //操作数每右移一位，相当于该数除以2

            System.out.println("error");
            return 0;
        }
        if(0==n%2)
            return (n>>1)*(-1);
        else{
            System.out.println("aaa");
            return (n>>1)*(-1)+n;   //或者可以替换为(n+1)>>1;
        }

    }
```
5.char类型的取值范围：
0-2<sup>16</sup>-1

6.java中如何在线程中返回一个值？
答案：可以让这个类去实现Callable接口，然后定义私有变量进行传递即可：如，
```
package com.pff;

import java.util.concurrent.Callable;

/**
 * Created by strongant on 16-6-16.
 */
public class MutiThread implements Callable<String> {
    private String str;
    private int count = 1;

    public MutiThread(String str) {
        this.str = str;
    }

    //需要实现的CallAble的Call方法
    public String call() throws Exception {
        for (int i = 0; i < this.count; i++) {
            System.out.println("Callable的call()方法打印:" + this.str + " " + i);
        }
        return this.str;
    }
}

```

测试调用
```
package com.pff;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by strongant on 16-6-16.
 */
public class CallableTest {
    public static void main(String[] args) {
        //创建一个线程池
        ExecutorService exs = Executors.newCachedThreadPool();
        ArrayList<Future<String>> al = new ArrayList<>();
        al.add(exs.submit(new MutiThread("String0")));
        for (Future<String> fs : al) {
            try {
                System.out.println(fs.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        exs.shutdown();
    }
}

```

具体流程就是实现Callable<Object>  泛型接口，然后线程类定义私有变量，重写call()方法，并且返回Callable接口声明的泛型类型值即可；

获取的时候使用Future<Object>泛型类去使用Future类的get()方法就可以获取到；



