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
package org.gnstudio.apdt.model.editor.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.gnstudio.apdt.model.Model;
import org.gnstudio.apdt.model.editor.APDEditorImages;
import org.gnstudio.apdt.model.editor.APDEditorMessages;
import org.gnstudio.apdt.model.editor.APDEditorPlugin;
import org.gnstudio.apdt.model.editor.APDModelEditor;
import org.gnstudio.apdt.model.editor.EditorLayoutFactory;
import org.gnstudio.apdt.model.editor.descriptors.NodeDetailsDescriptor;
import org.gnstudio.apdt.model.editor.descriptors.ReferenceBrowseProvider;
import org.gnstudio.apdt.model.editor.descriptors.ReferenceBrowseSupport;
import org.gnstudio.apdt.model.editor.descriptors.SelectionValueProvider;
import org.gnstudio.apdt.model.editor.nodes.AbstractNode;
import org.gnstudio.apdt.model.editor.nodes.ModelContext;
import org.gnstudio.apdt.model.editor.operations.BooleanSetOperation;
import org.gnstudio.apdt.model.editor.operations.ObjectSetOperation;
import org.gnstudio.apdt.model.editor.operations.TextSetOperation;

public class ModelNodeDetailsSection extends SectionPart implements
		NodeDeatilsViewer {
	private static final String ADVN_EXPAND_STORE = "ModelNodeDetails_Advanced.isExpand";//$NON-NLS-1$;
	private static final String HINT_STORE = "ModelNodeDetails_Hint.isHide";//$NON-NLS-1$;
	private APDModelEditor editor;

	private Composite parent;
	private Composite body;
	private AbstractNode<?> node;
    
	private final DefaultInformationControl infoControl;
	private ModelContext context;

	private boolean activeForcus = false;
	private Text hint;
	public ModelNodeDetailsSection(APDModelEditor editor, FormPage page,
			Composite parent) {
		super(parent, page.getManagedForm().getToolkit(), Section.DESCRIPTION
				| ExpandableComposite.TITLE_BAR);
		this.parent = parent;
		this.editor = editor;
		infoControl = new DefaultInformationControl(getSection().getShell(), "");
		buildBody(getSection(), page.getEditor().getToolkit());
		createSectionToolbar(getSection(), page.getEditor().getToolkit());
		parent.setBackground(getSection().getBackground());
	}

	protected Model getModel() {
		return editor.getModel();
	}

	public boolean isActiveForcus() {
		return activeForcus;
	}

	protected void buildBody(Section section, FormToolkit toolkit) {
		section.setLayout(EditorLayoutFactory.createClearTableWrapLayout(false,
				1));
		GridData sectionData = new GridData(GridData.FILL_BOTH
				| GridData.GRAB_VERTICAL);
		section.setLayoutData(sectionData);

		section.setText(APDEditorMessages.TreeNodeDtlSection_title);
		section.setDescription(APDEditorMessages.TreeNodeDtlSection_dec);
		// show default info
		showDetails(null, null);

	}

	@SuppressWarnings("unchecked")
	public void showDetails(final ModelContext context,
			final AbstractNode<?> node) {
		this.context = context;
		this.node = node;
		FormToolkit toolkit = editor.getToolkit();
		final Section section = getSection();

		if (body != null) {
			body.dispose();

		}
		
		

		body = toolkit.createComposite(section);
		section.setTabList(new Control[] {body });
		Composite advnComp = null;
		if (node == null) {
			section.setDescription(APDEditorMessages.TreeNodeDtlSection_empty_dec);
		} else {
			section.setDescription(APDEditorMessages.TreeNodeDtlSection_dec);

			body.setLayout(new GridLayout());
			body.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

			Composite descripterBody = new Composite(body, SWT.NONE);
			descripterBody.setLayout(EditorLayoutFactory
					.createSectionClientGridLayout(false, 2));
			descripterBody
					.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

			NodeDetailsDescriptor<?>[] descriptors = node
					.getNodeDetailsDescriptors(context);
			for (NodeDetailsDescriptor<?> descriptor : descriptors) {
				AbstractEditorSection<?> editorSection = null;
				switch (descriptor.getType()) {
				case TEXT:
				case DESCRIPTION:
				case REFERENCE:
					final NodeDetailsDescriptor<String> textDes = (NodeDetailsDescriptor<String>) descriptor;
					TextSetOperation operation = new TextSetOperation(
							textDes.getValue()) {
						@Override
						public IStatus undo(IProgressMonitor monitor,
								IAdaptable info) throws ExecutionException {
							IStatus status = super.undo(monitor, info);
							showDetails(context, node);
							return status;
						}

						@Override
						public IStatus redo(IProgressMonitor monitor,
								IAdaptable info) throws ExecutionException {
							IStatus status = super.redo(monitor, info);
							showDetails(context, node);
							return status;
						}

						@Override
						public void setText(String value) {
							textDes.setValue(value);
						}
					};
					switch (descriptor.getType()) {
					case TEXT:
						editorSection = new TextEditorSection(operation,
								textDes);
						break;
					case DESCRIPTION:
						editorSection = new DescriptionEditorSection(operation,
								textDes);
						break;
					case REFERENCE:
						editorSection = new TypeEditorSection(operation,
								textDes);
						break;

					}

					break;

				case SELECTION:
					final NodeDetailsDescriptor<Object> objDes = (NodeDetailsDescriptor<Object>) descriptor;
					ObjectSetOperation setObjOperation = new ObjectSetOperation(
							objDes.getValue()) {
						@Override
						public IStatus undo(IProgressMonitor monitor,
								IAdaptable info) throws ExecutionException {
							IStatus status = super.undo(monitor, info);
							showDetails(context, node);
							return status;
						}

						@Override
						public IStatus redo(IProgressMonitor monitor,
								IAdaptable info) throws ExecutionException {
							IStatus status = super.redo(monitor, info);
							showDetails(context, node);
							return status;
						}

						@Override
						public void setObject(Object b) {
							objDes.setValue(b);

						}
					};
					editorSection = new SelectionEditorSection(setObjOperation,
							objDes);
					break;
				case BOOLEAN:
					final NodeDetailsDescriptor<Boolean> booleanDes = (NodeDetailsDescriptor<Boolean>) descriptor;
					BooleanSetOperation setOperation = new BooleanSetOperation(
							booleanDes.getValue()) {
						@Override
						public IStatus undo(IProgressMonitor monitor,
								IAdaptable info) throws ExecutionException {
							IStatus status = super.undo(monitor, info);
							showDetails(context, node);
							return status;
						}

						@Override
						public IStatus redo(IProgressMonitor monitor,
								IAdaptable info) throws ExecutionException {
							IStatus status = super.redo(monitor, info);
							showDetails(context, node);
							return status;
						}

						@Override
						public void setBoolean(boolean b) {
							booleanDes.setValue(b);
						}
					};
					editorSection = new BooleanEditorSection(setOperation,
							booleanDes);
					break;

				}
				if (editorSection != null)
					if (descriptor.isAdvanced()) {
						if (advnComp == null) {
							advnComp = createAdvancedSection(toolkit);
						}
						editorSection.createContents(advnComp, toolkit);
					} else
						editorSection.createContents(descripterBody, toolkit);
			}
			
			setTabComponents(descripterBody);
			setTabComponents(advnComp);
		}

		
			
			
		
		
		toolkit.paintBordersFor(body);
		section.setClient(body);
		section.layout();
		
			
			buildHint();
		
	}

	private void buildHint(){
		if(hint!=null){
			hint.dispose();
			hint = null;
		}
		
		if(node!=null && node.getNote()!=null && !APDEditorPlugin.getDefault().getPreferenceStore()
				.getBoolean(HINT_STORE)){
			//build help component
		    hint = new Text(parent, SWT.V_SCROLL | SWT.BORDER | SWT.MULTI |SWT.WRAP);
		    hint.setEditable(false);
		    GridData gd = new GridData(GridData.FILL_HORIZONTAL );
			gd.grabExcessVerticalSpace = false;
			gd.grabExcessHorizontalSpace = false;
			gd.heightHint =50;
			gd.widthHint =100;
			gd.horizontalIndent = 5;
			hint.setLayoutData(gd);
			hint.setBackground(hint.getDisplay()
					.getSystemColor(SWT.COLOR_INFO_BACKGROUND));
			hint.setText(node.getNote());
		}
		parent.layout();
	}

	private void setTabComponents(Composite com) {
		if(com==null)
			return;
		Control[] baseCtrls = com.getChildren();
		List<Control> foucsCtrls = new ArrayList<Control>();
		for (Control ctrl : baseCtrls) {
			if(!(ctrl instanceof Label)){
				foucsCtrls.add(ctrl);
			}
		}
		com.setTabList(foucsCtrls.toArray(new Control[0]));
	}

	private void createSectionToolbar(Section section, FormToolkit toolkit) {
		ToolBarManager toolBarManager = new ToolBarManager(SWT.FLAT);
		final ToolBar toolbar = toolBarManager.createControl(section);
		final Cursor handCursor = new Cursor(Display.getCurrent(),
				SWT.CURSOR_HAND);
		toolbar.setCursor(handCursor);
		// Cursor needs to be explicitly disposed
		toolbar.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				if ((handCursor != null) && (handCursor.isDisposed() == false)) {
					handCursor.dispose();
				}
			}
		});

		// create hint Action
		final Action hintAction = new Action(
				APDEditorMessages.TreeNodeAction_hint,
				IAction.AS_CHECK_BOX) {

			@Override
			public void run() {
				APDEditorPlugin.getDefault().getPreferenceStore()
				.setValue(HINT_STORE, !isChecked());
				buildHint();
			}
		};
		hintAction.setImageDescriptor(APDEditorImages.DESC_HINT);
		hintAction.setChecked(!APDEditorPlugin.getDefault().getPreferenceStore()
				.getBoolean(HINT_STORE));
		toolBarManager.add(hintAction);

		toolBarManager.update(true);

		

		section.setTextClient(toolbar);
	}
	
	
	private Composite createAdvancedSection(FormToolkit toolkit) {
		Composite advnComp;
		int style = ExpandableComposite.TITLE_BAR | ExpandableComposite.TWISTIE;
		if (APDEditorPlugin.getDefault().getPreferenceStore()
				.getBoolean(ADVN_EXPAND_STORE))
			style = style | ExpandableComposite.EXPANDED;

		final Section advnSection = toolkit.createSection(body, style);
		advnSection.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		advnSection
				.setText(APDEditorMessages.TreeNodeDtlSection_advanced_title);

		advnComp = toolkit.createComposite(advnSection);
		advnComp.setLayout(EditorLayoutFactory.createSectionClientGridLayout(
				false, 2));
		advnComp.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		advnSection.setClient(advnComp);

		advnSection.addExpansionListener(new ExpansionAdapter() {
			@Override
			public void expansionStateChanged(ExpansionEvent e) {
				APDEditorPlugin.getDefault().getPreferenceStore()
						.setValue(ADVN_EXPAND_STORE, advnSection.isExpanded());
			}
		});
		return advnComp;
	}

	@Override
	public void refresh() {
		super.refresh();
	}

	@Override
	public void dispose() {
		if (infoControl != null)
			infoControl.dispose();
		super.dispose();
	}

	public abstract class AbstractEditorSection<T> {
		protected final NodeDetailsDescriptor<T> descriptor;

		public AbstractEditorSection(NodeDetailsDescriptor<T> descriptor) {
			this.descriptor = descriptor;
		}

		protected Label createLabel(Composite parent, FormToolkit toolkit) {
			String text = descriptor.getText();
			if (descriptor.isRequired()) {
				text += "*:"; //$NON-NLS-1$
			} else {
				text += ":"; //$NON-NLS-1$
			}
			Label label = toolkit.createLabel(parent, text, SWT.NULL);
			addInfoHoverContorl(label);
			return label;
		}

		protected void addInfoHoverContorl(final Control control) {
			control.addMouseTrackListener(new MouseTrackListener() {
				public void mouseEnter(MouseEvent e) {
					// ignore
				}

				public void mouseExit(MouseEvent e) {
					infoControl.setVisible(false);
				}

				public void mouseHover(MouseEvent e) {

					String text = descriptor.getTooltip();
					if (text == null || text.trim().length() == 0)
						return;
					infoControl.setSizeConstraints(200, 600);
					infoControl.setInformation(text);
					infoControl.setStatusText(descriptor.isRequired() ? APDEditorMessages.TreeNode_required_text
							: "");
					Point p = infoControl.computeSizeHint();
					infoControl.setSize(p.x, p.y);
					infoControl.setLocation(control
							.toDisplay(new Point(10, 25)));
					infoControl.setVisible(true);
				}
			});
		}

		public abstract void createContents(Composite parent,
				FormToolkit toolkit);

	}

	class TextEditorSection extends AbstractEditorSection<String> {
		private Text text;
		private TextSetOperation operation;

		public TextEditorSection(TextSetOperation operation,
				NodeDetailsDescriptor<String> descriptor) {
			super(descriptor);
			this.operation = operation;
		}

		@Override
		public void createContents(Composite parent, FormToolkit toolkit) {
			createLabel(parent, toolkit);
			text = toolkit
					.createText(parent, descriptor.getValue(), SWT.SINGLE);

			text.addFocusListener(new FocusListener() {

				public void focusLost(FocusEvent e) {
					activeForcus = false;
					refreash();
				}

				public void focusGained(FocusEvent e) {
					activeForcus = true;
					refreash();
				}

				private void refreash() {
					APDEditorPlugin.getStandardDisplay().asyncExec(
							new Runnable() {

								public void run() {
									editor.getContributor().refreah();

								}
							});
				}
			});
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.widthHint = 20;
			gd.horizontalSpan = 1;
			gd.horizontalIndent = 3;
			text.setLayoutData(gd);

			text.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					operation.updateText(context, text.getText());
				}
			});
		}
	}

	class TypeEditorSection extends AbstractEditorSection<String> {
		private Text text;
		private TextSetOperation operation;

		public TypeEditorSection(TextSetOperation operation,
				NodeDetailsDescriptor<String> descriptor) {
			super(descriptor);
			this.operation = operation;
		}

		@Override
		public void createContents(Composite parent, FormToolkit toolkit) {
			createLabel(parent, toolkit);
			Composite composite = toolkit.createComposite(parent);
			composite.setLayout(EditorLayoutFactory
					.createSectionClientGridLayout(false, 2));
			composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			text = toolkit.createText(composite, descriptor.getValue(),
					SWT.SINGLE);
			

			text.addFocusListener(new FocusListener() {

				public void focusLost(FocusEvent e) {
					activeForcus = false;
					refreash();
				}

				public void focusGained(FocusEvent e) {
					activeForcus = true;
					refreash();
				}

				private void refreash() {
					APDEditorPlugin.getStandardDisplay().asyncExec(
							new Runnable() {

								public void run() {
									editor.getContributor().refreah();

								}
							});
				}
			});
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.widthHint = 20;
			gd.horizontalSpan = 1;
			gd.horizontalIndent = 3;
			text.setLayoutData(gd);
			text.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					operation.updateText(context, text.getText());
				}
			});
			descriptor.addEditorAssist(text);
			final Button browse = toolkit.createButton(composite, "Browse",
					SWT.PUSH);

			if (descriptor instanceof ReferenceBrowseSupport) {
				final ReferenceBrowseSupport browseProvider = (ReferenceBrowseSupport) descriptor;
				browse.setEnabled(browseProvider.isSupported());

				if (browse.isEnabled()) {
					final ReferenceBrowseProvider[] providers = browseProvider
							.getProviders();
					browse.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent e) {
							if (providers.length == 1) {
								ReferenceBrowseProvider provider = providers[0];
								selectType(browseProvider, provider);
							} else {
								MenuManager popupMenuManager = new MenuManager();
								Menu menu = popupMenuManager
										.createContextMenu(browse);
								for (final ReferenceBrowseProvider provider : providers) {
									popupMenuManager.add(new Action(provider
											.getName()) {
										public void run() {
											selectType(browseProvider, provider);
										}
									});
								}
								Rectangle rect = browse.getBounds();
								Point pt = new Point(e.x, e.y + rect.height);
								pt = browse.toDisplay(pt);

								menu.setLocation(pt.x, pt.y);
								menu.setVisible(true);

							}

						}

					});
				}
			} else
				browse.setEnabled(false);
		}

		private void selectType(final ReferenceBrowseSupport browseProvider,
				final ReferenceBrowseProvider provider) {

			Job setupJob = new Job("Initializing Types") {

				@Override
				protected IStatus run(IProgressMonitor monitor) {
					provider.setup(browseProvider.getContext(), monitor);
					return Status.OK_STATUS;
				}
			};

			final Runnable typeSelectTask = new Runnable() {

				public void run() {
					String type = provider.browse(browseProvider.getFilter(),
							text.getText(), browseProvider.getContext());
					if (type != null) {
						text.setText(type);
					}

				}
			};
			// wait for setup job to finish and then try to browse types
			setupJob.addJobChangeListener(new JobChangeAdapter() {
				@Override
				public void done(IJobChangeEvent event) {
					APDEditorPlugin.getStandardDisplay().asyncExec(
							typeSelectTask);
				}
			});
			setupJob.setUser(true);
			setupJob.schedule();

		}
	}

	class BooleanEditorSection extends AbstractEditorSection<Boolean> {
		private Button button;
		private BooleanSetOperation setOperation;

		public BooleanEditorSection(BooleanSetOperation setOperation,
				NodeDetailsDescriptor<Boolean> descriptor) {
			super(descriptor);
			this.setOperation = setOperation;
		}

		@Override
		public void createContents(Composite parent, FormToolkit toolkit) {
			createLabel(parent, toolkit);
			button = toolkit.createButton(parent, null, SWT.CHECK);
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.widthHint = 20;
			gd.horizontalSpan = 1;
			gd.horizontalIndent = 3;
			button.setLayoutData(gd);
			button.setSelection(descriptor.getValue());
			button.addSelectionListener(new SelectionListener() {

				public void widgetSelected(SelectionEvent e) {
					setOperation.updateBoolean(context, button.getSelection());

				}

				public void widgetDefaultSelected(SelectionEvent e) {
					setOperation.updateBoolean(context, button.getSelection());

				}
			});
		}
	}

	class DescriptionEditorSection extends AbstractEditorSection<String> {
		private Text text;
		private TextSetOperation operation;

		public DescriptionEditorSection(TextSetOperation operation,
				NodeDetailsDescriptor<String> descriptor) {
			super(descriptor);
			this.operation = operation;
		}

		@Override
		public void createContents(Composite parent, FormToolkit toolkit) {
			GridData sectionData = new GridData(GridData.FILL_BOTH
					| GridData.GRAB_VERTICAL);
			sectionData.horizontalSpan = 2;
			parent.setLayoutData(sectionData);
			Label label = createLabel(parent, toolkit);
			GridData lgd = new GridData();
			lgd.verticalAlignment = SWT.BEGINNING;
			label.setLayoutData(lgd);
			text = toolkit.createText(parent, descriptor.getValue(), SWT.MULTI);
			

			text.addFocusListener(new FocusListener() {

				public void focusLost(FocusEvent e) {
					activeForcus = false;
					refreash();
				}

				public void focusGained(FocusEvent e) {
					activeForcus = true;
					refreash();
				}

				private void refreash() {
					APDEditorPlugin.getStandardDisplay().asyncExec(
							new Runnable() {

								public void run() {
									editor.getContributor().refreah();

								}
							});
				}
			});
			GridData gd = new GridData(GridData.FILL_BOTH
					| GridData.GRAB_VERTICAL);
			gd.widthHint = 20;
			gd.heightHint = 80;
			gd.horizontalSpan = 1;
			gd.horizontalIndent = 3;
			text.setLayoutData(gd);
			text.addModifyListener(new ModifyListener() {
				public void modifyText(ModifyEvent e) {
					operation.updateText(context, text.getText());
				}
			});
		}
	}

	class SelectionEditorSection extends AbstractEditorSection<Object> {
		private Combo combo;
		private ObjectSetOperation operation;

		public SelectionEditorSection(ObjectSetOperation operation,
				NodeDetailsDescriptor<Object> descriptor) {
			super(descriptor);
			this.operation = operation;
		}

		@Override
		public void createContents(Composite parent, FormToolkit toolkit) {
			createLabel(parent, toolkit);
			combo = new Combo(parent, SWT.READ_ONLY | SWT.BORDER);
			GridData gd = new GridData(GridData.FILL_HORIZONTAL);
			gd.widthHint = 20;
			gd.horizontalSpan = 1;
			gd.horizontalIndent = 3;
			combo.setLayoutData(gd);
			if (descriptor instanceof SelectionValueProvider) {
				final SelectionValueProvider<?> provider = (SelectionValueProvider<?>) descriptor;
				for (Object item : provider.getOptions()) {
					String key = item.toString();
					combo.add(key);
					combo.setData(key, item);
				}
				if (descriptor.getValue() != null)
					combo.setText(descriptor.getValue().toString());

				combo.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent event) {
						String key = combo.getText();
						operation.updateObject(context,
								key != null ? combo.getData(key) : null);
					}

				});
			}
		}
	}
}
