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

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.gnstudio.apdt.model.editor.descriptors.NodeDetailsDescriptor;

public class AbstractNode<T> {
	private AbstractNode<?> parent;
	private final NodeDeleteProvider<T> deleteProvider;
	protected T source;

	public AbstractNode(T source) {
		this(null, source);
	}

	public AbstractNode(T source, NodeDeleteProvider<T> deleteProvider) {
		this(null, source, deleteProvider);
	}

	public AbstractNode(AbstractNode<?> parent, T source) {
		this(parent, source, null);
	}

	public AbstractNode(AbstractNode<?> parent, T source,
			NodeDeleteProvider<T> deleteProvider) {
		this.parent = parent;
		this.source = source;
		this.deleteProvider = deleteProvider;
	}

	public String getName() {
		return null;
	}
	public String getNote() {
		return null;
	}

 	public String getToolTipText(){
 		return null;
 	}
	
	public ImageDescriptor getImageDescriptor() {
		return null;
	}

	public boolean isLeaf() {
		return true;
	}

	public AbstractNode<?> getParent() {
		return parent;
	}
    public void setParent(AbstractNode<?> parent) {
		this.parent = parent;
	}
	
	public NodeDeleteProvider<T> getDeleteProvider() {
		return deleteProvider;
	}

	public Action[] getActions(ModelContext context) {
		return new Action[0];
	}

	public NodeDetailsDescriptor<?>[] getNodeDetailsDescriptors(
			ModelContext context) {
		return new NodeDetailsDescriptor[0];
	}

	public T getSource() {
		return source;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractNode<?> other = (AbstractNode<?>) obj;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		return true;
	}

	public AbstractNode<?>[] getChildren() {
		return new AbstractNode<?>[0];
	}

	

	@Override
	public String toString() {
		return getName();
	}

	public NodeType[] getSuppotedSubNodeTypes() {
		return new NodeType[] { NodeType.NONE };
	}

	public boolean canAddNodeType(NodeType type) {
		return false;
	}
	
	public AbstractNode<?> toNode(NodeType type,Object source) {
		return null;
	}
}
