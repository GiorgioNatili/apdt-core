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

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.gnstudio.apdt.model.Model;
import org.gnstudio.apdt.model.editor.APDEditorMessages;
import org.gnstudio.apdt.model.editor.APDModelEditor;
import org.gnstudio.apdt.model.editor.EditorLayoutFactory;

public class ModelDescriptionSection extends SectionPart {
	private APDModelEditor editor;

	private Text descriptionText;

	private Label lblOverview ;
	private Label lblAuthor;
	private Label lblCreated;
	private Label lblLastChangeBy;
	private Label lblLastChange;
	
	private boolean updateModel = true;
	public ModelDescriptionSection(APDModelEditor editor, FormPage page,
			Composite parent) {
		super(parent, page.getManagedForm().getToolkit(),  ExpandableComposite.TITLE_BAR);
		this.editor = editor;
		buildBody(getSection(), page.getEditor().getToolkit());
	}

	protected Model getModel() {
		return editor.getModel();
	}

	@Override
	public void refresh() {
		updateOverview();
		super.refresh();
	}

	public void updateOverview() {
		if (descriptionText != null) {
			updateModel = false;
			String mDescription = getModel().getDescription();
			descriptionText.setText(mDescription != null ? mDescription : ""); //$NON-NLS-1$
			updateModel = true;
		}
		if(lblOverview!=null){
			Model model = getModel();
			
			lblOverview.setText("Created with: APDT " + model.getRelease());
			
			if(model.getAuthor()!=null)
				lblAuthor.setText("Author: " + model.getAuthor());
			else 
				lblAuthor.setText("Author: ");
			
			
			DateFormat dateFormat = SimpleDateFormat.getDateInstance();
			
			
			if(model.getCreated()!=null)
				lblCreated.setText("Created: " + dateFormat.format(model.getCreated()));
			else
				lblCreated.setText("Created: ");
			
			if(model.getUpdatedBy()!=null)
				lblLastChangeBy.setText("Last change by: " + model.getUpdatedBy());
			else 
				lblLastChangeBy.setText("Last change by: ");
			
			if(model.getUpdated()!=null)
				lblLastChange.setText("Last change: " + dateFormat.format(model.getUpdated()));
			else
				lblLastChange.setText("Last change: ");
			
		}
	}

	protected void buildBody(Section section, FormToolkit toolkit) {
		section.setLayout(EditorLayoutFactory.createClearTableWrapLayout(false,
				1));
		GridData sectionData = new GridData(GridData.FILL_BOTH
				| GridData.GRAB_VERTICAL );
		sectionData.horizontalSpan = 2;
		section.setLayoutData(sectionData);

		section.setText(APDEditorMessages.DescriptionSection_title);
		
		 
		
		

		Composite body = toolkit.createComposite(section);
		body.setLayout(EditorLayoutFactory.createSectionClientGridLayout(false,
				1));
		body.setLayoutData(new GridData(GridData.FILL_BOTH
				| GridData.GRAB_VERTICAL));

		
		lblAuthor = toolkit.createLabel(body,"",SWT.LEFT);
		lblAuthor.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL));
		lblCreated = toolkit.createLabel(body,"",SWT.LEFT);
		lblCreated.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL));
		lblLastChangeBy = toolkit.createLabel(body,"",SWT.LEFT);
		lblLastChangeBy.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL));
		lblLastChange = toolkit.createLabel(body,"",SWT.LEFT);
		lblLastChange.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL));
		lblOverview = toolkit.createLabel(body,"",SWT.LEFT);
		lblOverview.setLayoutData(new GridData(GridData.FILL_HORIZONTAL
				| GridData.GRAB_HORIZONTAL));
		
		
		toolkit.createLabel(body,"",SWT.LEFT);
		toolkit.createLabel(body,"Notes:",SWT.LEFT);
		descriptionText = toolkit.createText(body, getModel().getDescription(),
				SWT.WRAP | SWT.MULTI);
		GridData desccriptionGD = new GridData(GridData.FILL_BOTH
				| GridData.GRAB_VERTICAL);
		desccriptionGD.widthHint = 200;
		desccriptionGD.heightHint = 80;
		descriptionText.setLayoutData(desccriptionGD);
		descriptionText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				if(updateModel){
					String value = descriptionText.getText().trim();
					getModel().setDescription((value.length() > 0 ? value : null));
					markDirty();
				}
			}
		});
		toolkit.paintBordersFor(body);
		section.setClient(body);
	}
	
	
}
