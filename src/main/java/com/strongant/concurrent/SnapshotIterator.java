package com.strongant.concurrent;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public interface SnapshotIterator<E> {
	boolean hasNext();
	E next();
}
