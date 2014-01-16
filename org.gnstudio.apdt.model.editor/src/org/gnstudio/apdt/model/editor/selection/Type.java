package org.gnstudio.apdt.model.editor.selection;

import org.gnstudio.apdt.model.editor.nodes.AbstractNode;

public class Type {
	private final String pkg;
	final AbstractNode<?> node;

	public Type(String pkg, AbstractNode<?> node) {
		super();
		this.pkg = pkg;
		this.node = node;
	}

	public String getFullyQualifiedName() {
		return toFullyQualifiedName(pkg, node.getName());
	}

	public String getName() {
		return node.getName();
	}

	public String getPkg() {
		return pkg;
	}

	static String toFullyQualifiedName(String pkg, String name) {
		StringBuilder stringBuilder = new StringBuilder();
		if (pkg != null && pkg.length() > 0)
			stringBuilder.append(pkg).append(".");
		return stringBuilder.append(name).toString();
	}
}