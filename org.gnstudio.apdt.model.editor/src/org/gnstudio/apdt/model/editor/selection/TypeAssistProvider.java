package org.gnstudio.apdt.model.editor.selection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalProvider;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.fieldassist.ContentAssistCommandAdapter;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.gnstudio.apdt.model.ClassElement;
import org.gnstudio.apdt.model.Description;
import org.gnstudio.apdt.model.InterfaceElement;
import org.gnstudio.apdt.model.Model;
import org.gnstudio.apdt.model.PackageElement;
import org.gnstudio.apdt.model.Program;
import org.gnstudio.apdt.model.editor.APDEditorImages;
import org.gnstudio.apdt.model.editor.descriptors.ReferenceBrowseProvider;
import org.gnstudio.apdt.model.editor.descriptors.ReferenceBrowseProvider.FILTER;
import org.gnstudio.apdt.model.editor.nodes.ClassElementNode;
import org.gnstudio.apdt.model.editor.nodes.InterfaceElementNode;

public final class TypeAssistProvider implements IContentProposalProvider {
	private final Model model;
	private final ReferenceBrowseProvider.FILTER scope;

	public TypeAssistProvider(Model model, FILTER scope) {
		super();
		this.model = model;
		this.scope = scope;
	}

	public static void createTypeAssist(Control control, final Model model,
			final ReferenceBrowseProvider.FILTER scope) {

		ContentAssistCommandAdapter adapter = new ContentAssistCommandAdapter(
				control, new TextContentAdapter(), new TypeAssistProvider(
						model, scope),
				ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS,
				new char[0], true);
		adapter.setLabelProvider((new TypeLabelProvider()));
		adapter.setProposalAcceptanceStyle(ContentProposalAdapter.PROPOSAL_REPLACE);
	}

	private static class TypeProposal implements IContentProposal {
		private final Type type;
		private final String discription;
		private final String content;

		public TypeProposal(Type type, String discription) {
			this.type = type;
			this.discription = discription;
			this.content = type.getFullyQualifiedName();
		}

		public String getContent() {
			return content;
		}

		public int getCursorPosition() {
			return content.length();
		}

		public String getLabel() {
			return type.getFullyQualifiedName();
		}

		public String getDescription() {
			return discription;
		}
	}

	private boolean filterType(String contents, int position, String type) {
		if (contents.length() > position) {
			contents = contents.substring(0, position);
		}
		return type.contains(contents);
	}

	public IContentProposal[] getProposals(String contents, int position) {
		List<TypeProposal> proposals = new ArrayList<TypeProposal>();

		boolean addClass = (scope == ReferenceBrowseProvider.FILTER.ALL)
				|| (scope == ReferenceBrowseProvider.FILTER.CLASS);
		boolean addInterface = (scope == ReferenceBrowseProvider.FILTER.ALL)
				|| (scope == ReferenceBrowseProvider.FILTER.INTERFACE);

		List<PackageElement> packages = new ArrayList<PackageElement>();
		EList<Program> programs = model.getPrograms();
		for (Program program : programs) {
			packages.addAll(program.getPackages());
		}
		// get model packages
		packages.addAll(model.getPackages());

		for (PackageElement pkg : packages) {
			String pkgName = pkg.getName();
			if (addClass) {
				EList<ClassElement> classes = pkg.getClasses();
				for (ClassElement clazz : classes) {
					String className = clazz.getName();
					if (className != null) {
						if (filterType(contents, position,
								Type.toFullyQualifiedName(pkgName, className))) {
							Description description = clazz.getDescription();
							String dec = description == null ? "Description not available"
									: description.getText();
							proposals.add(new TypeProposal(new Type(pkgName,
									new ClassElementNode(null, clazz, null)),
									dec));
						}
					}
				}
			}
			if (addInterface) {
				EList<InterfaceElement> interfaces = pkg.getInterfaces();
				for (InterfaceElement interfaceItem : interfaces) {
					String className = interfaceItem.getName();
					if (className != null) {
						if (filterType(contents, position,
								Type.toFullyQualifiedName(pkgName, className))) {
							Description description = interfaceItem
									.getDescription();
							String dec = description == null ? "discription not added"
									: description.getText();
							proposals.add(new TypeProposal(new Type(pkgName,
									new InterfaceElementNode(null,
											interfaceItem, null)), dec));
						}
					}
				}
			}
		}
		Collections.sort(proposals, new Comparator<TypeProposal>() {

			public int compare(TypeProposal o1, TypeProposal o2) {
				
				return o1.type.getName().compareTo(o2.type.getName());
			}
		});
		return proposals.toArray(new IContentProposal[0]);
	}

	private static class TypeLabelProvider extends LabelProvider implements
			ILabelProvider,
			DelegatingStyledCellLabelProvider.IStyledLabelProvider {
		public Image getImage(Object element) {
			if (element instanceof TypeProposal) {
				return APDEditorImages
						.getImage(((TypeProposal) element).type.node
								.getImageDescriptor());
			}
			return null;
		}

		@Override
		public String getText(Object element) {
			return getStyledText(element).toString();
		}

		public StyledString getStyledText(Object element) {
			StyledString ss = new StyledString();
			if (element instanceof TypeProposal) {
				Type type = ((TypeProposal) element).type;
				ss.append(type.getName());
				ss.append(" - ", StyledString.QUALIFIER_STYLER);
				ss.append(type.getPkg(), StyledString.QUALIFIER_STYLER);
			}
			return ss;
		}

	}

}
