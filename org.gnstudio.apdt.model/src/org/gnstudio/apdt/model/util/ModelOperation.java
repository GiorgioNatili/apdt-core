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
package org.gnstudio.apdt.model.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.gnstudio.apdt.model.Model;
import org.gnstudio.apdt.model.ModelFactory;
import org.gnstudio.apdt.model.ModelPackage;

public class ModelOperation {

	private static final String UTF_8 = "UTF-8";
	private static final String VERSION = "1.1.0";// TODO : fix this

	private ModelOperation() {
		// hide
	}

	static {
		// Register the XMI resource factory for the .apd extension
		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("apd", new XMIResourceFactoryImpl());
		// Initialize the model
		ModelPackage.eINSTANCE.eClass();
	}

	public static Model createNewModel(IFile modelFile, String encoding)
			throws ModelOperationException {
		if (modelFile == null) {
			throw new IllegalArgumentException("modelFile can not be null");
		}
		if (encoding == null) {
			encoding = UTF_8;
		}
		ResourceSet resourceSet = new ResourceSetImpl();
		// Get the URI of the model file.
		URI fileURI = URI.createPlatformResourceURI(modelFile.getFullPath()
				.toString(), true);
		// Create a resource for this file.
		Resource resource = resourceSet.createResource(fileURI);
		// Add the initial model object to the contents.
		Model model = ModelFactory.eINSTANCE.createModel();
		model.setRelease(VERSION);
		model.setEncoding(encoding);
		resource.getContents().add(model);
		Map<Object, Object> options = new HashMap<Object, Object>();
		options.put(XMLResource.OPTION_ENCODING, encoding);

		// Save the contents of the resource to the file system.
		try {

			resource.save(options);
		} catch (IOException e) {
			throw new ModelOperationException(e);
		}

		return model;
	}

	public static Model readModel(IFile modelFile)
			throws ModelOperationException {
		if (modelFile == null) {
			throw new IllegalArgumentException("modelFile can not be null");
		}
		Model model = null;

		// Get the URI of the model file.
		URI fileURI = URI.createPlatformResourceURI(modelFile.getFullPath()
				.toString(), true);
		model = (Model) readFromURI(fileURI);

		return model;
	}

	public static Model readModel(File modelFile)
			throws ModelOperationException {
		if (modelFile == null) {
			throw new IllegalArgumentException("modelFile can not be null");
		}
		Model model = null;

		// Get the URI of the model file.
		URI fileURI = URI.createFileURI(modelFile.getAbsolutePath());
		model = (Model) readFromURI(fileURI);

		return model;
	}

	public static EObject read(File eObjectFile) throws ModelOperationException {
		if (eObjectFile == null) {
			throw new IllegalArgumentException("eObjectFile can not be null");
		}

		// Get the URI of the model file.
		URI fileURI = URI.createFileURI(eObjectFile.getAbsolutePath());

		return readFromURI(fileURI);
	}

	private static EObject readFromURI(URI fileURI)
			throws ModelOperationException {
		if (fileURI == null) {
			throw new IllegalArgumentException("fileURI can not be null");
		}
		

		ResourceSet resourceSet = new ResourceSetImpl();

		// load the resource for this file.
		Resource resource = resourceSet.getResource(fileURI, true);
		for (EObject object : resource.getContents()) {
			return object;
		}

		return null;
	}

	public static void writeModel(Model model, IFile modelFile)
			throws IOException, ModelOperationException {
		if (modelFile == null) {
			throw new IllegalArgumentException("modelFile can not be null");
		}

		// Get the URI of the model file.
		URI fileURI = URI.createPlatformResourceURI(modelFile.getFullPath()
				.toString(), true);
		writeToURI(model, fileURI);
	}

	public static void writeModel(Model model, File modelFile)
			throws IOException, ModelOperationException {
		if (modelFile == null) {
			throw new IllegalArgumentException("modelFile can not be null");
		}

		// Get the URI of the model file.
		URI fileURI = URI.createFileURI(modelFile.getAbsolutePath());
		writeToURI(model, fileURI);
	}

	public static void write(EObject eObject, File modelFile)
			throws IOException, ModelOperationException {
		if (modelFile == null) {
			throw new IllegalArgumentException("eObject can not be null");
		}

		// Get the URI of the model file.
		URI fileURI = URI.createFileURI(modelFile.getAbsolutePath());
		writeToURI(eObject, fileURI);
	}

	private static void writeToURI(EObject model, URI fileURI)
			throws IOException, ModelOperationException {
		if (fileURI == null) {
			throw new IllegalArgumentException("fileURI can not be null");
		}

		String encoding = UTF_8;

		// if EObject is Model set system settings
		if (model instanceof Model) {
			Model core = (Model) model;
			if (core.getEncoding() != null) {
				encoding = core.getEncoding();

			} else {
				core.setEncoding(encoding);
			}
			core.setRelease(VERSION);
		}

		ResourceSet resourceSet = new ResourceSetImpl();

		// Create a resource for this file.
		Resource resource = resourceSet.createResource(fileURI);
		resource.getContents().add(model);
		Map<Object, Object> options = new HashMap<Object, Object>();
		options.put(XMLResource.OPTION_ENCODING, encoding);
		// Save the contents of the resource to the file system.
		try {

			resource.save(options);
		} catch (IOException e) {
			throw new ModelOperationException(e);
		}
	}

	public static EObject copyElement(EObject object) {
		return EcoreUtil.copy((EObject) object);
	}

	public static boolean isAncestor(EObject ancestorEObject, EObject eObject) {
		return EcoreUtil.isAncestor(ancestorEObject, eObject);
	}
}
