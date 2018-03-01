# Java 面试总结

1. 抽象类和接口的区别？
    1. 抽象类中可以包含抽象方法和非抽象方法，接口只能包含公开的抽象方法；
    2. 抽象类中的变量是各种类型的，而接口只能包含public abstract final 类型；
    3. 接口中不能含有静态代码块和静态方法，而抽象类中可以包含；
    4. 一个类只能继承一个抽象类，但是可以实现多个接口；
    5. 抽象类可以有构造方法，接口不能有；

2. java中如何创建一个新线程？
    1. 实现 runnable 接口并重写 run 方法；
    2. 继承 Thread 类重写 run 方法；
    3. 实现 Callable 接口，重写 call() 方法；使用 FutureTask 类包装 Callable 对象，该 FutureTask 对象封装了该 Callable 对象的 call() 方法的返回值；
      使用 FutureTask 对象作为 Thread 对象的 target 创建并启动线程，调用 FutureTask 对象的 get() 方法获得子线程执行结束后的返回值；

3. AIDL 是什么？ AIDL 支持的数据类型有哪些？
   Android 跨进程通信。AIDL 全称 Android Interface Definition Language（Android 接口描述语言）是一种借口描述语言; 
    编译器可以通过 aidl 文件生成一段代码，通过预先定义的接口达到两个进程内部通信进程跨界对象访问的目的。
    AIDL的 IPC 的机制和 COM 或 CORBA 类似, 是基于接口的，但它是轻量级的;
    AIDL支持的数据类型: String，list，map，all native java dataType

4. 求计算1-2+3-4+5-6...的方法，n很大，考虑性能？
  答案：
```java
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

5. char类型的取值范围：

0-2<sup>16</sup>-1

6. java 中如何在线程中返回一个值？

答案：可以让这个类去实现Callable接口，然后定义私有变量进行传递即可：如，
```java
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
```java
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

7. Redis 中支持几种数据类型？ 分别是什么？ 你开发中一般使用到了哪种？
  Redis 数据类型Redis支持五种数据类型；分别是: String（字符串），Hash（哈希），List（列表），Set（集合）及 ZSet (sorted set：有序集合)。
  封锁一个IP地址(访问超过几次)。INCRBY 命令让这些变得很容易，通过原子递增保持计数。开发中一般将比如一些不经常改变的数据 省市级联、缓存配置等数据
  使用 String 进行存储。

8. Git 中 fetch 和 pull 的区别是什么？
  git fetch：相当于是从远程获取最新版本到本地，不会自动 merge。
  git pull：相当于是从远程获取最新版本并merge到本地。git fetch 和 git merge 在实际使用中，git fetch更安全一些。因为在merge前，我们可以查看更新情况，然后再决定是否合并结束。

9. 线程的生命周期是什么？
  新建--就绪--运行--阻塞--死亡。
  ```Txt
  1. 新建状态，当程序使用 new 关键字创建了一个线程之后，该线程就处于新建状态，此时仅由 JVM 为其分配内存，并初始化其成员变量的值。
  2. 就绪状态，当线程对象调用了 start() 方法之后，该线程处于就绪状态。Java 虚拟机会为其创建方法调用栈和程序计数器，等待调度运行。
  3. 运行状态，如果处于就绪状态的线程获得了 CPU，开始执行 run() 方法的线程执行体，则该线程处于运行状态。
  4. 阻塞状态，当处于运行状态的线程失去所占用资源之后，便进入阻塞状态。
  5. 在线程的生命周期当中，线程的各种状态的转换过程。
  ```
10. “static” 关键字是什么意思？在Java里可以 override private 或 static 的方法吗？

static 关键字表示，访问这个成员变量或方法时，不获取它属于的类实例。
Java 里的 static 方法不能被 override，因为 override 的机制是运行时(runtime)的动态绑定，而 static 方法是在编译时静态绑定的。static方法与任何类的具体实例无关，因此无法应用继承的概念。

11. 在静态方法里可以访问非静态变量吗?
Java 中的 static 变量归相应的类所有，它的值对于类的所有实例都是相同的。static 变量是在 JVM 加载类的时候初始化的。如果代码试图访问非静态的变量，而且不是通过类的实例去访问，编译器会报错，因为这些非静态变量还没有被创建呢，并且它们没有与实例相关联。

12. 静态变量和实例变量的区别？
Java 中的 static 变量归相应的类所有，它的值对于类的所有实例都是相同的。static 变量是在 JVM 加载类的时候初始化的。如果代码试图访问非静态的变量，而且不是通过类的实例去访问，编译器会报错，因为这些非静态变量还没有被创建呢，并且它们没有与实例相关联。

13. 引用传递和值传递是什么？
当对象通过传值调用时，传递的是这个对象的一个拷贝。因此，即使函数修改这个对象，也不会影响原对象的值。 
当对象通过传引用调用时，对象本身没有被传递，而传递的是对象的一个引用，会反映到任何出现这原对象的地方。

14. Java中的两种异常是什么?它们之间的区别?
Java 有两种类型的异常: checked 与 unchecked (检查与未检查) 异常. 如果 unchecked 异常可能会在方法或构造函数的执行时被抛出从而蔓延到方法或构造函数的外部, 它们也不需要要在方法或构造函数中声明 throws 子句。然而, checked 异常必须通过方法或构造函数的 throws 子句声明。

15. 写一个Singleton出来?
第一种:
```java
public class Singleton {
	private static instance = new Singleton();
	public static Singleton newInstance() {
		return instance;
	}
}
```
第二种：
```java
public class Singleton {
	private static Singleton instance = null;
	public static synchronized Singleton getInstance() {
		// 使用时再生成， 提高效率
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}
```
第三种:
```java
// 静态内部类  JVM 保证线程安全
public class Singleton {
	public static class SingletonHolder {
		private static  final  Singleton INSTANCE = new Singleton();
	}
	
	private Singleton() {}
	
	public static final Singleton getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
```
第四种：
```java
// 使用枚举
public enum Singleton {
	INSTANCE;
}
```
16. Java 泛型类在什么时候确定类型？
在编译期间确定变量类型。类型擦除。

17. Thread 和 Runnable 的区别？
Thread 类底层实现了 Runnable 接口，Thread 属于 Runnable 的子类。

18. Redis 中如何实现一次请求批量插入多条数据？
使用 Redis 的管道或者

19. CAS 算法的实现原理？
jvm中的CAS操作是基于处理器的CMPXCHG指令实现的，CAS存在三个问题：
* ABA问题
* 循环时间长开销大
* 只能保证一个共享变量的原子操作
CAS 有3个操作数，内存值V，旧的预期值A，要修改的新值B。当且仅当预期值A和内存值V相同时，将内存值V修改为B，否则什么都不做。
CAS通过调用JNI的代码实现的。JNI:Java Native Interface为JAVA本地调用，允许java调用其他语言。而 compareAndSwapInt 就是借助C来调用CPU底层指令实现的。


20. Volatile 关键字的作用？
多线程环境下保证共享变量的可见性和防止指令重排序。

21. synchronized 实现原理？
普通同步方法，锁是当前实例对象
静态同步方法，锁是当前类的class对象
同步方法块，锁是括号里面的对象
同步代码块是使用monitorenter和monitorexit指令实现的，同步方法依靠的是方法修饰符上的ACC_SYNCHRONIZED实现。 

22. Spring 中哪些类是单例的？
GlobalAdvisorAdapterRegistry