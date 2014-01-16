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
package org.gnstudio.apdt.model.editor.nodes.dnd;

import org.gnstudio.apdt.model.editor.nodes.ModelContext;
import org.gnstudio.apdt.model.editor.nodes.NodeType;

public interface NodeMoveProvider {
	boolean canMove(Neighbor relation, NodeType type);

	boolean canMove(Neighbor relation, Object source);

	void move(ModelContext context, Neighbor neighbor, Object source,
			boolean before);

	public static interface Neighbor {
		Object getNeighborSource();
	}
	
	public static interface Movable{
		boolean canMove();
	}
}
