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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.StyledString;
import org.gnstudio.apdt.model.AccessType;
import org.gnstudio.apdt.model.DeclarationType;
import org.gnstudio.apdt.model.Description;
import org.gnstudio.apdt.model.Method;
import org.gnstudio.apdt.model.MethodArgument;
import org.gnstudio.apdt.model.MethodSignature;
import org.gnstudio.apdt.model.MethodType;
import org.gnstudio.apdt.model.ModelFactory;
import org.gnstudio.apdt.model.Sequence;
import org.gnstudio.apdt.model.TypeReference;
import org.gnstudio.apdt.model.editor.APDEditorImages;
import org.gnstudio.apdt.model.editor.APDEditorMessages;
import org.gnstudio.apdt.model.editor.APDNodeHelpMessages;
import org.gnstudio.apdt.model.editor.descriptors.AccessTypeDescriptor;
import org.gnstudio.apdt.model.editor.descriptors.DeclarationDescriptor;
import org.gnstudio.apdt.model.editor.descriptors.MethodTypeDescriptor;
import org.gnstudio.apdt.model.editor.descriptors.NodeDetailsDescriptor;
import org.gnstudio.apdt.model.editor.descriptors.ReferenceBrowseProvider.FILTER;
import org.gnstudio.apdt.model.editor.descriptors.ReferenceDescriptor;
import org.gnstudio.apdt.model.editor.nodes.dnd.NodeMoveProvider;
import org.gnstudio.apdt.model.editor.nodes.sequence.SequenceNode;
import org.gnstudio.apdt.model.editor.operations.AbstractDeleteOperation;

public class MethodNode extends AbstractNode<Method> implements NodeOverview,
		NodeCategory, NodeMoveProvider, NodeMoveProvider.Neighbor,
		NodeMoveProvider.Movable {
	private boolean implementation;

	public MethodNode(AbstractNode<?> parent, Method method,
			NodeDeleteProvider<Method> deleteProvider) {
		super(parent, method, deleteProvider);
	}

	public MethodNode(AbstractNode<?> parent, Method method,
			NodeDeleteProvider<Method> deleteProvider, boolean implementation) {
		super(parent, method, deleteProvider);
		this.implementation = implementation;
	}

	@Override
	public String getName() {
		String name = source.getNote();
		if (name != null && name.length() > 0)
				return name;
		
		String def = source.getSignature().getName();
		if ((def == null || def.length() == 0)) {
			return APDEditorMessages.TreeNode_method_name;
		}
		
		return "";
	}

	@Override
	public String getNote() {
		return APDNodeHelpMessages.getNLS("editor.help.method");
	}
	
	@Override
	public ImageDescriptor getImageDescriptor() {
		ImageDescriptor descriptor = APDEditorImages.DESC_MODEL_METHOD;
		if (source.getSignature() != null) {
			switch (source.getSignature().getAccess()) {
			case INTERNAL:
				descriptor = APDEditorImages.DESC_MODEL_METHOD_INNER;
				break;
			case PRIVATE:
				descriptor = APDEditorImages.DESC_MODEL_METHOD_PRIVATE;
				break;
			case PROTECTED:
				descriptor = APDEditorImages.DESC_MODEL_METHOD_PROTECTED;
				break;

			}

			switch (source.getSignature().getDeclaration()) {
			case FINAL:
				descriptor = APDEditorImages.createOverlay(descriptor,
						APDEditorImages.DESC_MODEL_FINAL_OV,
						IDecoration.BOTTOM_RIGHT);
				break;
			case OVERRIDDEN:
				descriptor = APDEditorImages.createOverlay(descriptor,
						APDEditorImages.DESC_MODEL_OVERRIDE_OV,
						IDecoration.BOTTOM_RIGHT);
				break;
			case STATIC:
				descriptor = APDEditorImages.createOverlay(descriptor,
						APDEditorImages.DESC_MODEL_STATIC_OV,
						IDecoration.BOTTOM_RIGHT);
				break;
			}

		}

		if (source.getAnnotation() != null
				&& source.getAnnotation().length() > 0) {
			descriptor = APDEditorImages.createOverlay(descriptor,
					APDEditorImages.DESC_MODEL_ANNOTATION_OV,
					IDecoration.TOP_LEFT | IDecoration.UNDERLAY);
		}
		return descriptor;
	}

	@Override
	public boolean isLeaf() {
		return !(source.getDescription() != null
				|| source.getThrowsElements().size() > 0
				|| source.getArguments().size() > 0
				|| source.getDiscussions().size() > 0 || source.getSequences()
				.size() > 0);
	}

	@Override
	public AbstractNode<?>[] getChildren() {
		List<AbstractNode<?>> nodes = new ArrayList<AbstractNode<?>>(2);

		if (source.getDescription() != null) {
			nodes.add(new DescriptionNode(this, source.getDescription(),
					DescriptionNode.createDeleteProvider(this, source)));
		}

		if (source.getDiscussions().size() > 0)
			nodes.add(new DiscussionsNode(this));

		// add <args> folder
		if (source.getArguments().size() > 0) {
			nodes.add(new ArgumentsNode(this));
		}
		// add <throws> folder
		if (source.getThrowsElements().size() > 0) {
			nodes.add(new ThrowsNode(this));
		}

		for (Sequence sequence : source.getSequences()) {
			SequenceNode node = SequenceNode.toSequenceNode(this, source,
					sequence);
			assert node != null;
			nodes.add(node);
			SequenceNode.AssociateNodeProvider nodeProvider = node
					.getAssociateNodeProvider();
			if (nodeProvider != null) {
				nodes.addAll(nodeProvider.getAssociateNodes());
			}
		}
		return nodes.toArray(new AbstractNode<?>[0]);

	}

	@Override
	public Action[] getActions(final ModelContext context) {
		if (implementation)
			return new Action[] {
					DescriptionNode
							.newDescripationAction(context, this, source),
					null,
					getNewArgsAction(this, context),
					getNewThrowsAction(this, context),
					null,
					DiscussionsNode.getNewDiscussionAction(this, context),
					null,
					SequenceNode.newAction(context, this, NodeType.VARIABLE),
					SequenceNode.newAction(context, this, NodeType.COMMENT),
					SequenceNode.newAction(context, this, NodeType.ITERATION),
					SequenceNode.newAction(context, this, NodeType.IF),
					SequenceNode.newAction(context, this, NodeType.SWITCH),
					SequenceNode.newAction(context, this, NodeType.GROUP),
					SequenceNode.newAction(context, this, NodeType.TRY),
					SequenceNode.newAction(context, this, NodeType.METHOD_CALL),
					SequenceNode.newAction(context, this, NodeType.RECURSION),
					SequenceNode.newAction(context, this, NodeType.PRINT),
					SequenceNode.newAction(context, this, NodeType.SHOW),
					SequenceNode.newAction(context, this, NodeType.PROMPT),
					SequenceNode.newAction(context, this, NodeType.READ),
					SequenceNode.newAction(context, this, NodeType.WRITE),
					SequenceNode.newAction(context, this, NodeType.RECOVER),
					SequenceNode.newAction(context, this, NodeType.STORE),
					SequenceNode.newAction(context, this, NodeType.CALC_STORE),
					SequenceNode.newAction(context, this,
							NodeType.METHOD_RETURN) };

		return new Action[] {
				DescriptionNode.newDescripationAction(context, this, source),
				null, getNewArgsAction(this, context),
				getNewThrowsAction(this, context), null,
				DiscussionsNode.getNewDiscussionAction(this, context) };
	}

	@Override
	public NodeDetailsDescriptor<?>[] getNodeDetailsDescriptors(
			final ModelContext context) {
		NodeDetailsDescriptor<String> noteDesc = new NodeDetailsDescriptor<String>(
				NodeDetailsDescriptor.TYPE.TEXT) {

			@Override
			public String getValue() {
				return source.getNote();
			}

			@Override
			public void setValue(String value) {
				source.setNote(value);
				context.modelUpdated();
				// refresh method node as well
				context.refreah(MethodNode.this);

			}
		};
		noteDesc.setText(APDEditorMessages.TreeNode_note);
		final MethodSignature signature = source.getSignature();
		// name
		NodeDetailsDescriptor<String> nameDesc = new NodeDetailsDescriptor<String>(
				NodeDetailsDescriptor.TYPE.TEXT) {

			@Override
			public String getValue() {
				return signature.getName();
			}

			@Override
			public void setValue(String value) {
				signature.setName(value);
				context.modelUpdated();
				// refresh method node as well
				context.refreah(MethodNode.this);

			}
		};
		nameDesc.setText(APDEditorMessages.TreeNode_method_signature_name);

		// type
		MethodTypeDescriptor typeDesc = new MethodTypeDescriptor() {

			@Override
			public MethodType getValue() {
				return signature.getType() != null ? signature.getType()
						: MethodType.STANDARD;
			}

			@Override
			public void setValue(MethodType value) {
				signature.setType(value == null ? MethodType.STANDARD : value);
				context.modelUpdated();
				context.refreah(MethodNode.this);

			}

			public MethodType[] getOptions() {
				return MethodType.values();
			}
		};
		typeDesc.setText(APDEditorMessages.TreeNode_method_signature_type);
		typeDesc.setAdvanced(true);

		ReferenceDescriptor returnTypeDesc = new ReferenceDescriptor() {

			@Override
			public String getValue() {
				return signature.getReturnType() != null ? signature
						.getReturnType().getName() : null;
			}

			@Override
			public void setValue(String value) {
				if (value == null || value.length() == 0) {
					signature.setReturnType(null);
				} else {
					TypeReference reference = ModelFactory.eINSTANCE
							.createTypeReference();
					reference.setName(value);
					signature.setReturnType(reference);
				}
				context.modelUpdated();
				// refresh method node as well
				context.refreah(MethodNode.this);

			}

			@Override
			public ModelContext getContext() {
				return context;
			}
		};
		returnTypeDesc
				.setText(APDEditorMessages.TreeNode_method_signature_return_type);
		returnTypeDesc.setAdvanced(true);

		// varargs
		NodeDetailsDescriptor<Boolean> varargDesc = new NodeDetailsDescriptor<Boolean>(
				NodeDetailsDescriptor.TYPE.BOOLEAN) {

			@Override
			public Boolean getValue() {
				return signature.isVarargs();
			}

			@Override
			public void setValue(Boolean value) {
				signature.setVarargs(value.booleanValue());
				context.modelUpdated();
				context.refreah(MethodNode.this);

			}

		};
		varargDesc.setText(APDEditorMessages.TreeNode_method_signature_varargs);
		varargDesc.setAdvanced(true);
		if (!implementation) {
			return new NodeDetailsDescriptor[] { noteDesc, nameDesc, typeDesc,
					returnTypeDesc, varargDesc };
		}

		// implementation related NodeDetailsDescriptors
		// annotation
		NodeDetailsDescriptor<String> annotationDesc = new NodeDetailsDescriptor<String>(
				NodeDetailsDescriptor.TYPE.TEXT) {

			@Override
			public String getValue() {
				return source.getAnnotation();
			}

			@Override
			public void setValue(String value) {
				source.setAnnotation(value);
				context.modelUpdated();
				context.refreah(MethodNode.this);

			}
		};
		annotationDesc.setText(APDEditorMessages.TreeNode_annotation);
		annotationDesc.setAdvanced(true);

		// access
		AccessTypeDescriptor accessDesc = new AccessTypeDescriptor() {

			@Override
			public AccessType getValue() {
				return signature.getAccess() != null ? signature.getAccess()
						: AccessType.PUBLIC;
			}

			@Override
			public void setValue(AccessType value) {
				signature.setAccess(value == null ? AccessType.PUBLIC : value);
				context.modelUpdated();
				context.refreah(MethodNode.this);

			}

			public AccessType[] getOptions() {
				return AccessType.values();
			}
		};
		accessDesc.setText(APDEditorMessages.TreeNode_access);
		accessDesc.setAdvanced(true);

		// declaration
		DeclarationDescriptor declarationDesc = new DeclarationDescriptor() {

			@Override
			public DeclarationType getValue() {
				return signature.getDeclaration() != null ? signature
						.getDeclaration() : DeclarationType.DEFAULT;
			}

			@Override
			public void setValue(DeclarationType value) {
				signature
						.setDeclaration(value == null ? DeclarationType.DEFAULT
								: value);
				context.modelUpdated();
				context.refreah(MethodNode.this);

			}

			public DeclarationType[] getOptions() {
				return new DeclarationType[] { DeclarationType.DEFAULT,
						DeclarationType.OVERRIDDEN, DeclarationType.FINAL,
						DeclarationType.STATIC };
			}
		};
		declarationDesc
				.setText(APDEditorMessages.TreeNode_method_signature_declaration);
		declarationDesc.setAdvanced(true);

		return new NodeDetailsDescriptor[] { noteDesc, nameDesc,
				annotationDesc, accessDesc, typeDesc, declarationDesc,
				returnTypeDesc, varargDesc };
	}

	public void addOverview(StyledString styledString) {
		String name = null;
		boolean varargs = false;
		boolean hasReturnType = false;
		if (source.getSignature() != null) {
			name = source.getSignature().getName();
			varargs = source.getSignature().isVarargs();
			hasReturnType = (source.getSignature().getReturnType() != null
					&& source.getSignature().getReturnType().getName() != null && source
					.getSignature().getReturnType().getName().length() > 0);
		}
		if (name != null && name.length() > 0) {
			if(source.getNote()!=null && source.getNote().length()> 0)
				styledString.append(" : ", StyledString.DECORATIONS_STYLER);//$NON-NLS-1$
			
			if (hasReturnType) {
				styledString.append(source.getSignature().getReturnType()
						.getName(), StyledString.DECORATIONS_STYLER);
			} else {
				styledString.append("void", StyledString.DECORATIONS_STYLER);//$NON-NLS-1$
			}
			styledString.append(" ");//$NON-NLS-1$
			styledString.append(name, StyledString.DECORATIONS_STYLER);
			styledString.append("(", StyledString.DECORATIONS_STYLER);//$NON-NLS-1$
			if (varargs)
				styledString.append("...", StyledString.DECORATIONS_STYLER);//$NON-NLS-1$
			styledString.append(")", StyledString.DECORATIONS_STYLER);//$NON-NLS-1$

		}

	}

	public int getCategory() {
		return CATEGORY_METHOD;
	}

	private static Action getNewThrowsAction(final MethodNode node,
			final ModelContext context) {
		Action extendsAction = new Action() {
			public void run() {
				NodeActions.createNewNode(context, node, NodeType.THROWS);
			}
		};
		extendsAction.setText(APDEditorMessages.TreeNodeAction_new_throws);

		return extendsAction;
	}

	private static Action getNewArgsAction(final MethodNode node,
			final ModelContext context) {
		Action descAction = new Action() {
			public void run() {
				NodeActions.createNewNode(context, node, NodeType.ARGUMRNT);
			}
		};
		descAction.setText(APDEditorMessages.TreeNodeAction_new_method_arg);

		return descAction;
	}

	// ThrowsNode: group throws types together
	// ----------------------------------------------------------
	private static class ThrowsNode extends AbstractNode<MethodNode> implements
			NodeCategory, NodeOverview {
		private final Method method;

		public ThrowsNode(MethodNode parent) {
			super(parent, parent);
			method = parent.source;
		}

		public String getName() {

			return APDEditorMessages.TreeNode_throws;
		}


		@Override
		public String getNote() {
			return APDNodeHelpMessages.getNLS("editor.help.throws");
		}
		
		
		@Override
		public boolean isLeaf() {
			return false;
		}

		@Override
		public ImageDescriptor getImageDescriptor() {
			return APDEditorImages.DESC_MODEL_THROWS;
		}

		@Override
		public AbstractNode<?>[] getChildren() {
			List<AbstractNode<?>> nodes = new ArrayList<AbstractNode<?>>();

			for (TypeReference element : method.getThrowsElements()) {
				nodes.add(new TypeReferenceNode(this, element,
						new ThrowsDeleteProvider(source), FILTER.CLASS));
			}
			return nodes.toArray(new AbstractNode<?>[0]);
		}

		@Override
		public Action[] getActions(final ModelContext context) {
			return new Action[] { getNewThrowsAction(source, context) };
		}

		public int getCategory() {
			return CATEGORY_THROWS;
		}

		public void addOverview(StyledString styledString) {
			if (method.getThrowsElements().size() > 0) {
				String mask = " : ";//$NON-NLS-1$
				for (TypeReference reference : method.getThrowsElements()) {
					if (reference.getName() != null) {
						styledString.append(mask,
								StyledString.DECORATIONS_STYLER);
						styledString.append(reference.getName(),
								StyledString.DECORATIONS_STYLER);
						mask = ", ";//$NON-NLS-1$
					}
				}
			}
		}
	}

	// Arguments : group args types together
	// ----------------------------------------------------------
	private static class ArgumentsNode extends AbstractNode<MethodNode>
			implements NodeCategory, NodeOverview {
		private final Method method;

		public ArgumentsNode(MethodNode parent) {
			super(parent, parent);
			method = parent.source;
		}

		public String getName() {

			return APDEditorMessages.TreeNode_arguments;
		}


		@Override
		public String getNote() {
			return APDNodeHelpMessages.getNLS("editor.help.arguments");
		}
		
		
		@Override
		public boolean isLeaf() {
			return false;
		}

		@Override
		public ImageDescriptor getImageDescriptor() {
			return APDEditorImages.DESC_MODEL_ARGUMENTS;
		}

		@Override
		public AbstractNode<?>[] getChildren() {
			List<AbstractNode<?>> nodes = new ArrayList<AbstractNode<?>>();

			for (MethodArgument element : method.getArguments()) {
				nodes.add(new MethodArgNode(this, element,
						new ArgDeleteProvider(source)));
			}
			return nodes.toArray(new AbstractNode<?>[0]);
		}

		@Override
		public Action[] getActions(final ModelContext context) {
			return new Action[] { getNewArgsAction(source, context) };
		}

		public int getCategory() {
			return CATEGORY_METHOD_ARGS;
		}

		public void addOverview(StyledString styledString) {

		}
	}

	private static class ThrowsDeleteProvider implements
			NodeDeleteProvider<TypeReference> {
		private final AbstractNode<Method> node;

		public ThrowsDeleteProvider(AbstractNode<Method> node) {
			this.node = node;
		}

		public void delete(final ModelContext context, TypeReference ref) {
			node.source.getThrowsElements().remove(ref);
			context.modelUpdated();
			context.refreah(node);
		}

		public AbstractOperation createDeleteOperation(ModelContext context,
				TypeReference t) {
			return AbstractDeleteOperation.create(context, node,
					node.source.getThrowsElements(), t);
		}

	}

	private static class ArgDeleteProvider implements
			NodeDeleteProvider<MethodArgument> {
		private final AbstractNode<Method> node;

		public ArgDeleteProvider(AbstractNode<Method> node) {
			this.node = node;
		}

		public void delete(final ModelContext context, MethodArgument ref) {
			node.source.getArguments().remove(ref);
			context.modelUpdated();
			context.refreah(node);
		}

		public AbstractOperation createDeleteOperation(ModelContext context,
				MethodArgument t) {
			return AbstractDeleteOperation.create(context, node,
					node.source.getArguments(), t);
		}

	}

	@Override
	public NodeType[] getSuppotedSubNodeTypes() {
		List<NodeType> types = new ArrayList<NodeType>(
				Arrays.asList(new NodeType[] { NodeType.DESCRIPTION,
						NodeType.ARGUMRNT,NodeType.THROWS , NodeType.DISCUSSION }));
		if (implementation)
			types.addAll(Arrays.asList(SequenceNode.getSequenceNodeTypes()));
		return types.toArray(new NodeType[0]);
	}

	@Override
	public boolean canAddNodeType(NodeType type) {
		switch (type) {
		case DESCRIPTION:
			return source.getDescription() == null;
		case ARGUMRNT:
		case THROWS:
		case DISCUSSION:
			return true;
		default:
			return implementation && SequenceNode.isSequenceType(type);
		}
	}

	@Override
	public AbstractNode<?> toNode(NodeType type, Object source) {
		switch (type) {
		case ARGUMRNT:
			return new MethodArgNode(new ArgumentsNode(this),
					(MethodArgument) source, null);
		case THROWS:
			return new TypeReferenceNode(new ThrowsNode(
					this), (TypeReference) source, null);

		case DISCUSSION:
			return DiscussionsNode.toDiscussionNode(this, (Description) source);
		}

		if (SequenceNode.isSequenceType(type)) {
			return SequenceNode.toSequenceNode(this, this.getSource(),
					(Sequence) source);
		}
		return super.toNode(type, source);
	}

	public boolean canMove(Neighbor relation, NodeType type) {
		return implementation
				&& relation.getNeighborSource() instanceof Sequence
				&& SequenceNode.isSequenceType(type);
	}

	public void move(ModelContext context, Neighbor relation, Object source,
			boolean before) {
		if ((relation == null || relation.getNeighborSource() instanceof Sequence)
				&& source instanceof Sequence) {
			EList<Sequence> sequences = getSource().getSequences();
			if (relation != null) {
				Sequence neighbor = (Sequence) relation.getNeighborSource();
				if (sequences.contains(neighbor)) {
					int index = sequences.indexOf(neighbor);
					if (!before)
						index++;

					sequences.add(index, (Sequence) source);
				}
			} else
				sequences.add((Sequence) source);
		}

	}

	public boolean canMove(Neighbor relation, Object source) {
		EList<Sequence> sequences = getSource().getSequences();
		return implementation
				&& source instanceof Sequence
				&& (relation == null || sequences.contains(relation
						.getNeighborSource()));
	}

	public Object getNeighborSource() {
		return getSource();
	}

	public boolean canMove() {
		return true;
	}
}
