## java多线程总结

### 进程与线程的概念
#### 进程：
1.   例子： eclipse、qq都属于进程，动态性;
2.   概念：进程是程序的执行过程、持有资源(共享内存、共享文件)和线程，载体
#### 线程
1.  源代码文本编辑
2.  源代码校验
3.  qq收发文件
4. 进程之三年一班：学生是班级的最小单元，使用教室中的资源板凳、桌子
5. 线程的交互：互斥（图书馆的书，抢战资源）、同步（协作）、交互（排演节目），包括：
- java对线程的支持
- 线程的创建和启动
- 线程常用方法
- 正确停止线程
- thread和runable接口都位于java.lang包下
##### 线程的创建：
1. Thread()
2. Thread(String name)
3. Thread(Runable target)
4. Thread(Runable target,String name)

##### 线程的方法
1. void start() ,启动线程
2. static void sleep(long mills)，线程休眠
3. static void sleep(long mills)，使其他线程等待当前线程终止
4. void join----------------------------------------------------------------
5. void join(long mills)--------------------------------------------------
6. void join(long millils,int nanos)------------------------------------
7. static void yield()，当前运行线程释放处理器资源
8. static Thread currentThread(),返回当前运行的线程引用
##### 例子
* java.lang.Thread可以直接使用getName获取当前线程的名字
* java.lang.Runable接口没有getName方法，获取线程名字使用Thread.currendThread.getName();

##### 实例深入对线程的操作
###### 模拟隋唐演义中随军和农民起义军的战争，双方分别发动战争，进行攻击，攻击的过程中不能出现长时间的单方面攻击，攻击机会均等；还可以随时将战争进行停止。
* 分析：
首先我们需要定义一个作战的舞台提供双方战斗的场地，然后定义进攻的线程对象。其中需要解决线程让步操作，可以使用Thread.yield()方法让出CPU时间，让资源进行争取，外部可以控制线程的动作，需要使用在对象内部定义变量，用于判断是否还要发送战争，使用java中volatile保证了线程可以读取其它线程写入的值

* 实例代码：
```
package com.pff;

/**
 * Created by strongant on 16-6-17.
 */
public class RunableThreadTest {
    public static void main(String[] args) {
       /* Actor a = new Actor();
        a.start();

        Thread ad = new Thread(new Actress(),"Mrs Runable");
        ad.start();*/

        new Stage().start();
    }


}

//军队线程
//模拟作战双方的行为
class ArmyRunable implements Runnable{
    //保证了线程可以正确读取其他线程写入的值
    //可见性原因 ref JMM,happens-before原则
    volatile boolean keepRunning = true;
    @Override
    public void run() {
        while (keepRunning){
            //发送5连击
            for (int i = 0; i <5 ; i++) {
                System.out.println(Thread.currentThread().getName()+"进攻对方["+i+"]");
                //每发送一次，让出处理器时间，下次进攻不一定
                Thread.yield();
            }
        }
    }
}
//舞台
class Stage extends Thread{
    @Override
    public void run() {
        //隋军
        ArmyRunable armTaskOfSuiDynasty = new ArmyRunable();
        //农民起义军
        ArmyRunable armyTaskOfRevolt = new ArmyRunable();
        Thread armyOfSuiDynasty = new Thread(armTaskOfSuiDynasty,"随军");
        Thread armyOfRevolt = new Thread(armyTaskOfRevolt,"农民起义军");

        //启动线程让军队开始作战
        armyOfSuiDynasty.start();
        armyOfRevolt.start();
        //舞台线程休眠，专心观看军队厮杀
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        armTaskOfSuiDynasty.keepRunning = false;
        armyTaskOfRevolt.keepRunning = false;
        try {
            armyOfRevolt.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

