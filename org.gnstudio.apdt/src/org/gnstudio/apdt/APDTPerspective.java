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
package org.gnstudio.apdt;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class APDTPerspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		IFolderLayout topLeft = layout.createFolder("topLeft", //$NON-NLS-1$
				IPageLayout.LEFT, 0.25f, layout.getEditorArea());

		topLeft.addView(IPageLayout.ID_PROJECT_EXPLORER);
		IFolderLayout bottom = layout.createFolder("bottomRight", //$NON-NLS-1$
				IPageLayout.BOTTOM, 0.75f, layout.getEditorArea());

		bottom.addView(IPageLayout.ID_TASK_LIST);
		
		bottom.addView(IPageLayout.ID_PROBLEM_VIEW);
		
		layout.addView(IPageLayout.ID_OUTLINE, IPageLayout.BOTTOM, 0.6f, IPageLayout.ID_PROJECT_EXPLORER);
		IFolderLayout view = (IFolderLayout) layout.getFolderForView(IPageLayout.ID_OUTLINE);
		view.addView(APDTUIConstants.MODEL_PALETTE_ID);
		
		// Add "show views".
        layout.addShowViewShortcut(IPageLayout.ID_PROJECT_EXPLORER);
        layout.addShowViewShortcut(IPageLayout.ID_TASK_LIST);
        layout.addShowViewShortcut(IPageLayout.ID_PROBLEM_VIEW);
        layout.addShowViewShortcut(IPageLayout.ID_OUTLINE);
        layout.addShowViewShortcut(APDTUIConstants.MODEL_PALETTE_ID);
        
        // Add "new wizards".
        layout.addNewWizardShortcut(APDTUIConstants.MODEL_WIZARD_ID);
        layout.addActionSet(APDTUIConstants.MODEL_WIZARD_ID);
        
	}

}
