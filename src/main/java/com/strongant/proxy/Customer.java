package com.strongant.proxy;

/**
 * TODO
 * <p>
 * Created by bwh on 2017/8/11.
 * Contact me at <a href="mailto:baiwenhui@autobole.com">baiwenhui@autobole.com</a>
 *
 * @see
 * @since 2017/8/11
 */
public class Customer {
    public static void main(String[] args) {
        //定义一个java码农
        ICoder coder = new JavaCoder("Zhang");
        //定义一个产品经理
        ICoder proxy = new CoderProxy(coder);
        //让产品经理实现一个需求
        proxy.implDemands("Add");
    }
}
