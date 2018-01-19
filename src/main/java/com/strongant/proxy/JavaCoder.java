package com.strongant.proxy;

import com.strongant.proxy.ICoder;

/**
 * TODO
 * <p>
 * Created by bwh on 2017/8/11.
 * Contact me at <a href="mailto:baiwenhui@autobole.com">baiwenhui@autobole.com</a>
 *
 * @see
 * @since 2017/8/11
 */
public class JavaCoder implements ICoder {

    private String name;

    public JavaCoder(String name) {
        this.name = name;
    }

    @Override
    public void implDemands(String demandName) {
        System.out.println(this.name + " implement demandName: " + demandName + " in Java!" );
    }
}
