package net.uchoice.conveyor.chain;

/**
 * Created by admin on 2017/8/14.
 */
public interface FilterChain<F extends Filter,P,R> {

    void registFilter(F filter);

    R chain(P param);
}
