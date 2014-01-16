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

import org.eclipse.swt.dnd.ByteArrayTransfer;
import org.eclipse.swt.dnd.TransferData;

public class NodeTransfer extends ByteArrayTransfer {

	protected static final String TYPE_NAME = "apd-node-transfer-format";
	protected static final int TYPE_ID = registerType(TYPE_NAME);

	private final static NodeTransfer instance = new NodeTransfer();

	public static NodeTransfer getInstance() {
		return instance;
	}

	protected long startTime;

	protected Object object;

	protected NodeTransfer() {
		super();
	}

	protected int[] getTypeIds() {
		return new int[] { TYPE_ID };
	}

	public String[] getTypeNames() {
		return new String[] { TYPE_NAME };
	}

	public void javaToNative(Object object, TransferData transferData) {
		startTime = System.currentTimeMillis();
		this.object = object;
		if (transferData != null) {
			super.javaToNative(String.valueOf(startTime).getBytes(),
					transferData);
		}
	}

	public Object nativeToJava(TransferData transferData) {
		byte[] bytes = (byte[]) super.nativeToJava(transferData);
		//native transfer fail to load get data use local type (see #135)
		if (bytes == null)
			return object;

		try {
			long startTime = Long.parseLong(new String(bytes));
			return this.startTime == startTime ? object : null;
		} catch (NumberFormatException exception) {
			return null;
		}
	}
}
