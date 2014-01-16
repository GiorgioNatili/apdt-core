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

import org.eclipse.core.resources.IResource;
import org.gnstudio.apdt.model.Model;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeMoveProvider;
import org.gnstudio.apdt.model.editor.operations.OperationSupport;

public interface ModelContext {
	Model getModel();

	void modelUpdated();

	void refreah(AbstractNode<?> node);

	void refreahAll();

	void selectNodes(boolean focusDeatils, AbstractNode<?>... nodes);

	AbstractNode<?> findNode(Object source);
	
	boolean isRootTypes(NodeType type);
 
	NodeMoveProvider getRootNodeMoveProvider();
	
	IResource getModelResource();
	
	OperationSupport getOperationSupport(); 
}
