package com.strongant.proxy;

/**
 * Java静态代理
 * <p>
 * Created by bwh on 2017/8/11.
 * Contact me at <a href="mailto:baiwenhui@autobole.com">baiwenhui@autobole.com</a>
 *
 * @see
 * @since 2017/8/11
 */
public class CoderProxy implements ICoder {

    private ICoder coder;

    public CoderProxy(ICoder coder){
        this.coder = coder;
    }

    @Override
    public void implDemands(String demandName) {
        if(demandName.startsWith("Add")){
            System.out.println("No longer receive 'Add' demand");
            return;
        }
        coder.implDemands(demandName);
    }
}
