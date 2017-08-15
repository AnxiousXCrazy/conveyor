package net.uchoice.conveyor.chain;

/**
 * Created by admin on 2017/8/14.
 */
public interface BoolFilter<T> extends Filter{

    boolean bool(T t);
}
