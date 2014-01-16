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
package org.gnstudio.apdt.model.editor.nodes;

public enum NodeType {
	NONE, PROGRAM, PACKAGE, INTERFACE, CLASS, CLASS_MEMBER,
	METHOD, DESCRIPTION, ARGUMRNT, DISCUSSION, VARIABLE, COMMENT, GROUP, ITERATION,
	METHOD_CALL, METHOD_RETURN,THROWS, SWITCH, CASE, DEFAULT_CASE, IF , ELSE_IF , ELSE,
	RECURSION, PRINT, SHOW, PROMPT, READ, WRITE, TRY, CATCH, FINALLY ,RECOVER ,STORE, CALC_STORE,
	IMPLEMENTS,EXTENDS,SOURCE_LINK
}