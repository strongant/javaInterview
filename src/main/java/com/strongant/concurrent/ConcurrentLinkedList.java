package com.strongant.concurrent;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * 通过 CAS 实现 ConcurrentLinkedList
 *
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class ConcurrentLinkedList<E> implements SnapshotIterable<E> {

	private AtomicReference<LinkedElement<E>>
			lastAddedLinkedElementAtomicReference =
			new AtomicReference<LinkedElement<E>>();

	private AtomicReferenceFieldUpdater<LinkedElement, LinkedElement>
			nextLinkedElementUpdater =
			AtomicReferenceFieldUpdater.newUpdater(
					LinkedElement.class, LinkedElement.class, "nextLinkedElement");

	public void add(E object) {
		LinkedElement<E> linkedElement = new LinkedElement<E>( object );
		while ( true ){

			linkedElement.nextLinkedElement =
					lastAddedLinkedElementAtomicReference.get();

			if ( lastAddedLinkedElementAtomicReference.compareAndSet(
					linkedElement.nextLinkedElement, linkedElement ) ){

				break;
			}
		}
	}

	private boolean removeObject(
			LinkedElement<E> linkedElement, LinkedElement<E> nextLinkedElement,
			E objectToRemove ){

		if ( nextLinkedElement == null ){

			throw new RuntimeException( "Cannot find element to remove" );
		}

		LinkedElement<E> nextNextLinkedElement =
				nextLinkedElement.nextLinkedElement;

		if ( nextLinkedElement.object.equals( objectToRemove ) ){

			return nextLinkedElementUpdater.compareAndSet(
					linkedElement, linkedElement.nextLinkedElement,
					nextNextLinkedElement );
		}
		else {

			return removeObject( nextLinkedElement, nextNextLinkedElement,
					objectToRemove );
		}
	}

	private LinkedElement<E> populatePreviousLinks(
			LinkedElement<E> linkedElementIn ){

		LinkedElement<E> linkedElement = linkedElementIn;
		LinkedElement<E> nextLinkedElement;

		while ( ( nextLinkedElement =
				linkedElement.nextLinkedElement  ) != null ){

			nextLinkedElement.previousLinkedElement = linkedElement;
			linkedElement = nextLinkedElement;
		}

		return linkedElement;
	}

	public void remove( E objectToRemove ){

		while ( true ){

			LinkedElement<E> lastAddedLinkedElement =
					lastAddedLinkedElementAtomicReference.get();

			if ( lastAddedLinkedElement == null ){

				throw new RuntimeException( "Cannot find element to remove" );
			}

			LinkedElement<E> nextLinkedElement =
					lastAddedLinkedElement.nextLinkedElement;

			if ( lastAddedLinkedElement.object.equals( objectToRemove ) ){

				lastAddedLinkedElementAtomicReference.set( nextLinkedElement );
				break;
			}
			else {

				if ( removeObject( lastAddedLinkedElement, nextLinkedElement,
						objectToRemove ) ){

					break;
				}
			}
		}
	}



	@Override
	public SnapshotIterator<E> getSnapshotIterator() {
		LinkedElement<E> linkedElement =
				lastAddedLinkedElementAtomicReference.get();

		try {
			LinkedElement<E> clonedLinkedElement =
					( LinkedElement<E> )linkedElement.clone();

			LinkedElement<E> lastLinkedElement =
					populatePreviousLinks( clonedLinkedElement );

			SnapshotIterator<E> snapshotIterator =
					new SnapshotIteratorImpl<E>( lastLinkedElement );

			return snapshotIterator;
		}
		catch( CloneNotSupportedException e ){

			throw new RuntimeException( e );
		}
	}


}
