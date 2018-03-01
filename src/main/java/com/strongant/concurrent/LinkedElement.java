package com.strongant.concurrent;

/**
 * @author <a href="mailto:strongant1994@gmail.com">strongant</a>
 * @since 2017/8/20
 */
public class LinkedElement<E> implements Cloneable {

	LinkedElement<E> previousLinkedElement;

	volatile LinkedElement<E> nextLinkedElement;

	E object;

	LinkedElement( E object ){

		this.object = object;
	}

	@Override
	protected LinkedElement<E> clone() throws CloneNotSupportedException {

		LinkedElement<E> clonedLinkedElement = new LinkedElement<E>( object );

		if ( nextLinkedElement != null ){

			clonedLinkedElement.nextLinkedElement = nextLinkedElement.clone();
		}

		return clonedLinkedElement;
	}
}
