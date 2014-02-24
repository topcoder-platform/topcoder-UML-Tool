/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.macosx;

import java.lang.reflect.*;
import java.util.HashMap;

/**
 * <p>
 * Adapter class used for handling Mac OS X specific events.
 * Implemented using reflections and thus doesn't require to reference
 * Mac OS X specific API directly
 * </p>
 * @author L0s7man
 * @version 1.0
 */
public class MacOSXAdapter implements InvocationHandler {

	/**
	 * <p> Represents the object that will perform the task </p>
	 */
	protected Object targetObject;
	/**
	 * <p> Represents the method that will be called </p>
	 */
	protected Method targetMethod;
	/**
	 * <p> Represents the name of the method that needs to be handled (for example:
	 * handleQuit, etc.)</p>
 	 */
	protected String proxySignature;

	/**
	 * <p> Represents the Mac OS X application </p>
 	 */
	static Object macOSXApplication;

	/**
	 * <p> Pass this method an Object and Method equipped to perform application
	 * shutdown logic. The method passed should return a boolean stating whether
	 * or not the quit should occur. </p>
	 * @param target the object that will perform the task
	 * @param quitHandler the method which handles the quit logic
	 */
	public static void setQuitHandler(Object target, Method quitHandler) throws MacOSXEventHandlerException {
		setHandler(new MacOSXAdapter("handleQuit", target, quitHandler));
	}

	/**
 	 * <p>Pass this method an Object and a Method equipped to handle document
	 * events from the Finder; Documents are registered with the Finder via
	 * the CFBundleDocumentTypes dictionary in the application bundle's Info.plist </p>
	 * @param target the object that will perform the task 
	 * @param fileHandler the method that handles the open file logic 
	 */
	public static void setFileHandler(Object target, Method fileHandler) throws MacOSXEventHandlerException {
		setHandler(new MacOSXAdapter("handleOpenFile", target, fileHandler) {
			// Override MacOSXAdapter.callTarget to send information on the
			// file to be opened
			public boolean callTarget(Object appleEvent) throws MacOSXEventHandlerException {
				if (appleEvent != null) {
					try {
						Method getFilenameMethod = appleEvent.getClass()
								.getDeclaredMethod("getFilename",
										(Class[]) null);
						String filename = (String) getFilenameMethod.invoke(
								appleEvent, (Object[]) null);
						this.targetMethod.invoke(this.targetObject,
								new Object[] { filename });
					} catch (Exception ex) {
							//throw MacOSXEventHandlerException which then will be logged by the
							//logger set up for this component
							throw new MacOSXEventHandlerException(
								"Unable to handle \"Open File\" event from Finder", ex);
					}
				}
				return true;
			}
		});
	}

	/**
	 * <p>setHandler creates a Proxy object from the passed MacOSXAdapter and adds
	 * it as an ApplicationListener</p>
	 * @param adapter MacOSX adapter to handle a specific task (example: handleQuit)
	 */
	public static void setHandler(MacOSXAdapter adapter) throws MacOSXEventHandlerException {
		try {
			Class applicationClass = Class
					.forName("com.apple.eawt.Application");
			if (macOSXApplication == null) {
				macOSXApplication = applicationClass.getConstructor(
						(Class[]) null).newInstance((Object[]) null);
			}
			Class applicationListenerClass = Class
					.forName("com.apple.eawt.ApplicationListener");
			Method addListenerMethod = applicationClass.getDeclaredMethod(
					"addApplicationListener",
					new Class[] { applicationListenerClass });
			// Create a proxy object around this handler that can be
			// reflectively added as an Apple ApplicationListener
			Object osxAdapterProxy = Proxy.newProxyInstance(MacOSXAdapter.class
					.getClassLoader(),
					new Class[] { applicationListenerClass }, adapter);
			addListenerMethod.invoke(macOSXApplication,
					new Object[] { osxAdapterProxy });
		} catch (ClassNotFoundException cnfe) {
				//throw MacOSXEventHandlerException which then will be logged by the
				//logger set up for this component
				throw new MacOSXEventHandlerException(
					"This version of Mac OS X does not support the Apple EAWT."
					+ " ApplicationEvent handling has been disabled.", cnfe);
		} catch (Exception ex) {    // Likely a NoSuchMethodException or an
									// IllegalAccessException loading/invoking
									// eawt.Application methods
				//throw MacOSXEventHandlerException which then will be logged by the
				//logger set up for this component
				throw new MacOSXEventHandlerException(
					"Mac OS X Adapter could not talk to EAWT.", ex);
		}
	}

	/**
	 * <p>Each MacOSXAdapter has the name of the EAWT method it intends to listen
	 * for (handleAbout, for example), the Object that will ultimately perform
	 * the task, and the Method to be called on that Object</p>
	 * @param proxySignature the name of the method the adapter listens for 
	 * @param target the object that will perform the task
	 * @param handler the mehtod of the object that will be called
	 */
	protected MacOSXAdapter(String proxySignature, Object target, Method handler) {
		this.proxySignature = proxySignature;
		this.targetObject = target;
		this.targetMethod = handler;
	}

	/**
	 * <p>Override this method to perform any operations on the event that comes
	 * with the various callbacks; See setFileHandler above for an example</p>
	 * @param appleEvent event object
	 */
	public boolean callTarget(Object appleEvent)
			throws InvocationTargetException, IllegalAccessException, MacOSXEventHandlerException {
		Object result = targetMethod.invoke(targetObject, (Object[]) null);
		if (result == null) {
			return true;
		}
		return Boolean.valueOf(result.toString()).booleanValue();
	}

	/**
	 * <p>InvocationHandler implementation; This is the entry point for our proxy
	 * object; it is called every time an ApplicationListener method is invoked </p>
	 * @param proxy the name of the method the adapter listens for 
	 * @param method the method that is to be called
	 * @param args the arguments for the method to be called
	 */
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if (isCorrectMethod(method, args)) {
			boolean handled = callTarget(args[0]);
			setApplicationEventHandled(args[0], handled);
		}
		// All of the ApplicationListener methods are void; return null
		// regardless of what happens
		return null;
	}

	/**
	 * <p>Compare the method that was called to the intended method when the
	 * MacOSXAdapter instance was created (e.g. handleAbout, handleQuit, handleOpenFile, etc.)</p>
	 * @param method the method that is to be called 
	 * @param args the arguments for the method to be called 
	 */
	protected boolean isCorrectMethod(Method method, Object[] args) {
		return (targetMethod != null && proxySignature.equals(method.getName()) && args.length == 1);
	}

	/**
	 *  <p>It is important to mark the ApplicationEvent as handled and cancel the
	 *  default behavior; This method checks for a boolean result from the proxy
	 *  method and sets the event accordingly </p>
	 *  @param event event object
	 *  @param handled boolean value that describes if the event was handled
	 */
	protected void setApplicationEventHandled(Object event, boolean handled)
		throws MacOSXEventHandlerException {
		if (event != null) {
			try {
				Method setHandledMethod = event.getClass().getDeclaredMethod(
						"setHandled", new Class[] { boolean.class });
				// If the target method returns a boolean, use that as a hint
				setHandledMethod.invoke(event, new Object[] { Boolean
						.valueOf(handled) });
			} catch (Exception ex) {
				//throw MacOSXEventHandlerException which then will be logged by the
				//logger set up for this component
				throw new MacOSXEventHandlerException(
					"MacOSXAdapter was unable to handle an ApplicationEvent: " + event, ex);
			}
		}
	}
}
