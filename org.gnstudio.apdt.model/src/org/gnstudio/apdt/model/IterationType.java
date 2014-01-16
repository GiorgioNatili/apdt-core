/*******************************************************************************
 * Copyright (c) 2010, 2012 GNstudio s.r.l. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl-3.0.html
 *
 * Contributors:
 *   GNstudio s.r.l. - initial API and implementation
 *******************************************************************************/
package org.gnstudio.apdt.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Iteration Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.gnstudio.apdt.model.ModelPackage#getIterationType()
 * @model
 * @generated
 */
public enum IterationType implements Enumerator {
	/**
	 * The '<em><b>FOR</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FOR_VALUE
	 * @generated
	 * @ordered
	 */
	FOR(0, "FOR", "for"),

	/**
	 * The '<em><b>FOR EACH</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FOR_EACH_VALUE
	 * @generated
	 * @ordered
	 */
	FOR_EACH(0, "FOR_EACH", "for-each"),

	/**
	 * The '<em><b>WHILE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WHILE_VALUE
	 * @generated
	 * @ordered
	 */
	WHILE(0, "WHILE", "while"),

	/**
	 * The '<em><b>DO WHILE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DO_WHILE_VALUE
	 * @generated
	 * @ordered
	 */
	DO_WHILE(0, "DO_WHILE", "do-while");

	/**
	 * The '<em><b>FOR</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FOR</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FOR
	 * @model literal="for"
	 * @generated
	 * @ordered
	 */
	public static final int FOR_VALUE = 0;

	/**
	 * The '<em><b>FOR EACH</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>FOR EACH</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #FOR_EACH
	 * @model literal="for-each"
	 * @generated
	 * @ordered
	 */
	public static final int FOR_EACH_VALUE = 0;

	/**
	 * The '<em><b>WHILE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>WHILE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #WHILE
	 * @model literal="while"
	 * @generated
	 * @ordered
	 */
	public static final int WHILE_VALUE = 0;

	/**
	 * The '<em><b>DO WHILE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>DO WHILE</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DO_WHILE
	 * @model literal="do-while"
	 * @generated
	 * @ordered
	 */
	public static final int DO_WHILE_VALUE = 0;

	/**
	 * An array of all the '<em><b>Iteration Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final IterationType[] VALUES_ARRAY =
		new IterationType[] {
			FOR,
			FOR_EACH,
			WHILE,
			DO_WHILE,
		};

	/**
	 * A public read-only list of all the '<em><b>Iteration Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<IterationType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Iteration Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IterationType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IterationType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Iteration Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IterationType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			IterationType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Iteration Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IterationType get(int value) {
		switch (value) {
			case FOR_VALUE: return FOR;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private IterationType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //IterationType
