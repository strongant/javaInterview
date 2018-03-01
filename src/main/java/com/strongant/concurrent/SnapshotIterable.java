package com.strongant.concurrent;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public interface SnapshotIterable<E> {
	SnapshotIterator<E> getSnapshotIterator();
}
