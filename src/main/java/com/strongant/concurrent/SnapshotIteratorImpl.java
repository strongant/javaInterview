package com.strongant.concurrent;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class SnapshotIteratorImpl<E> implements SnapshotIterator<E> {

	private LinkedElement<E> linkedElement;

	public SnapshotIteratorImpl( LinkedElement<E> linkedElement ){

		this.linkedElement = linkedElement;
	}

	@Override
	public boolean hasNext() {

		if (linkedElement !=  null ){
			return true;
		}
		return false;
	}

	@Override
	public E next() {

		E objectToReturn;

		if ( linkedElement != null ){

			objectToReturn = linkedElement.object;
			linkedElement = linkedElement.previousLinkedElement;
			return objectToReturn;
		}

		return null;
	}
}
