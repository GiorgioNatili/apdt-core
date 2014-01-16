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
package org.gnstudio.apdt.model.editor.descriptors;

import org.eclipse.swt.widgets.Control;

public abstract class NodeDetailsDescriptor<T> {
	public enum TYPE {
		TEXT, DESCRIPTION, SELECTION, BOOLEAN, REFERENCE
	}

	private final TYPE type;
	private boolean required;
	private boolean advanced;
	private String text;
	private String tooltip;

	public NodeDetailsDescriptor(TYPE type) {
		super();
		this.type = type;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTooltip() {
		return tooltip;
	}

	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public boolean isAdvanced() {
		return advanced;
	}

	public void setAdvanced(boolean advanced) {
		this.advanced = advanced;
	}

	public TYPE getType() {
		return type;
	}

	public void addEditorAssist(Control control){
		
	}
	public abstract T getValue();

	public abstract void setValue(T value);

}
