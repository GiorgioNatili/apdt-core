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
package org.gnstudio.apdt.model.editor;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.swt.graphics.Image;

public class APDEditorImages {
	private APDEditorImages() {
	}

	private final static ImageRegistry PLUGIN_REGISTRY = new ImageRegistry();
	public final static String ICONS_PATH = "icons/"; //$NON-NLS-1$
	private static final String PATH_OBJ = ICONS_PATH + "obj16/"; //$NON-NLS-1$
	private static final String PATH_LCL = ICONS_PATH + "elcl16/"; //$NON-NLS-1$
	private static final String PATH_LCL_DISABLED = ICONS_PATH + "dlcl16/"; //$NON-NLS-1$

	public static final ImageDescriptor DESC_MODEL_OVERVIEW = create(PATH_OBJ,
			"apd_model_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_PROGRAM = create(PATH_OBJ,
			"apd_program_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_PACKAGE = create(PATH_OBJ,
			"apd_package_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_INTERFACE = create(PATH_OBJ,
			"apd_interface_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_INTERFACE_INNER = create(
			PATH_OBJ, "apd_interface_inner_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_EXTENDS_INTERFACE = create(
			PATH_OBJ, "apd_extends_int_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_METHOD = create(PATH_OBJ,
			"apd_method_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_METHOD_INNER = create(
			PATH_OBJ, "apd_method_inner_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_METHOD_PRIVATE = create(
			PATH_OBJ, "apd_method_private_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_METHOD_PROTECTED = create(
			PATH_OBJ, "apd_method_protected_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_METHOD_CALL = create(
			PATH_OBJ, "apd_method_call_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_RETURN = create(PATH_OBJ,
			"apd_return_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_CLASS = create(PATH_OBJ,
			"apd_class_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_CLASS_INNER = create(
			PATH_OBJ, "apd_class_inner_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_SUPER_TYPES = create(
			PATH_OBJ, "apd_super_types_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_PROPERTY = create(PATH_OBJ,
			"apd_property_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_TAG = create(PATH_OBJ,
			"apd_tag_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_COMMNETS = create(PATH_OBJ,
			"apd_comments_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_COMMNET = create(PATH_OBJ,
			"apd_comment_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_THROWS = create(PATH_OBJ,
			"apd_throws_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_CLASS_MEMBER = create(
			PATH_OBJ, "apd_member_public_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_CLASS_MEMBER_INNER = create(
			PATH_OBJ, "apd_member_inner_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_CLASS_MEMBER_PRIVATE = create(
			PATH_OBJ, "apd_member_private_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_CLASS_MEMBER_PROTECTED = create(
			PATH_OBJ, "apd_member_protected_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_ARGUMENTS = create(PATH_OBJ,
			"apd_args_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_ARGUMENT = create(PATH_OBJ,
			"apd_arg_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_DISCUSSIONS = create(
			PATH_OBJ, "apd_discussions_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_DISCUSSION = create(
			PATH_OBJ, "apd_discussion_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_LOCAL_VAR = create(PATH_OBJ,
			"apd_localvariable_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_SEQN_GROUP = create(
			PATH_OBJ, "apd_sequence_group_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_SEQN_ITERATION = create(
			PATH_OBJ, "apd_iteration_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_SEQN_SWITCH = create(
			PATH_OBJ, "apd_switch_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_SEQN_CASE = create(PATH_OBJ,
			"apd_case_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_SEQN_DEFAULT_CASE = create(
			PATH_OBJ, "apd_default_case_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_SEQN_IF = create(PATH_OBJ,
			"apd_if_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_SEQN_ELSE_IF = create(
			PATH_OBJ, "apd_elseif_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_SEQN_ELSE = create(PATH_OBJ,
			"apd_else_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_SEQN_RECURSION = create(
			PATH_OBJ, "apd_recursion_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_SEQN_PRINT = create(
			PATH_OBJ, "apd_print_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_SEQN_SHOW = create(PATH_OBJ,
			"apd_show_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_SEQN_PROMPT = create(
			PATH_OBJ, "apd_prompt_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_SEQN_READ = create(PATH_OBJ,
			"apd_read_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_SEQN_WRITE = create(
			PATH_OBJ, "apd_write_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_SEQN_TRY = create(PATH_OBJ,
			"apd_try_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_SEQN_CATCH = create(
			PATH_OBJ, "apd_catch_obj.gif"); //$NON-NLS-1$ 
	public static final ImageDescriptor DESC_MODEL_SEQN_FINALLY = create(
			PATH_OBJ, "apd_finally_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_LINK = create(PATH_OBJ,
			"apd_link_obj.gif"); //$NON-NLS-1$

	public static final ImageDescriptor DESC_MODEL_SEQN_RECOVER = create(
			PATH_OBJ, "apd_recover_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_SEQN_STORE = create(
			PATH_OBJ, "apd_store_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_SEQN_CALC_STORE = create(
			PATH_OBJ, "apd_calc_store_obj.gif"); //$NON-NLS-1$

	public static final ImageDescriptor DESC_MODEL_ANNOTATION_OV = create(
			PATH_OBJ, "apd_annotation_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_OVERRIDE_OV = create(
			PATH_OBJ, "apd_override_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_STATIC_OV = create(PATH_OBJ,
			"apd_static_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_FINAL_OV = create(PATH_OBJ,
			"apd_final_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_PINNED_OV = create(PATH_OBJ,
			"apd_pinned_obj.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_MODEL_UNCONFIGURED_OV = create(
			PATH_OBJ, "apd_unconfigured_obj.gif"); //$NON-NLS-1$

	public static final ImageDescriptor DESC_COLLAPSE_ALL = create(PATH_LCL,
			"collapseall.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_EXPAND_ALL = create(PATH_LCL,
			"expandall.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_ADD_ITEM = create(PATH_LCL,
			"add_item.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_DELETE_ITEM = create(PATH_LCL,
			"delete_item.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_DELETE_ITEM_DISABLED = create(
			PATH_LCL_DISABLED, "delete_item.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_PALETTE_CATEGORY = create(
			PATH_LCL, "palette_category.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_HELP = create(PATH_LCL, "help.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_HINT = create(PATH_LCL, "node_hint.gif"); //$NON-NLS-1$

	public static final ImageDescriptor DESC_REFRESH = create(PATH_LCL,
			"refresh.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_EXPORT = create(PATH_LCL,
			"export_wiz.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_EXPORT_TO_PRJ = create(PATH_LCL,
			"export_to_project.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_LINK_WITH_EDITOR = create(
			PATH_LCL, "synced.gif"); //$NON-NLS-1$
	public static final ImageDescriptor DESC_ALPHAB_SORT_CO = create(PATH_LCL,
			"alphab_sort_co.gif"); //$NON-NLS-1$

	private static ImageDescriptor create(String prefix, String name) {
		return ImageDescriptor.createFromURL(makeImageURL(prefix, name));
	}

	public static ImageDescriptor createOverlay(ImageDescriptor base,
			ImageDescriptor overlay, int quadrant) {
		return new DecorationOverlayIcon(getImage(base), overlay, quadrant);
	}

	private static URL makeImageURL(String prefix, String name) {
		String path = "$nl$/" + prefix + name; //$NON-NLS-1$
		return FileLocator.find(APDEditorPlugin.getDefault().getBundle(),
				new Path(path), null);
	}

	public static Image getImage(ImageDescriptor desc) {
		String key = String.valueOf(desc.hashCode());
		Image image = PLUGIN_REGISTRY.get(key);
		if (image == null) {
			image = desc.createImage();
			PLUGIN_REGISTRY.put(key, image);
		}
		return image;
	}
}
