/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.eventmanager;

import com.topcoder.util.actionmanager.Action;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.ActionManager;
import com.topcoder.util.actionmanager.RedoActionExecutionException;
import com.topcoder.util.actionmanager.UndoActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;

import java.util.EventObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * <p>This class is the main class of this component. The manager will be responsible for handling action events
 * and GUI events.</p>
 *
 *  <ul type="disc">
 *      <li>For the simple action event, it will validate it by the registered validator and execute it
 *      according to the validation. And notify the registered action event listeners.</li>
 *      <li>For the undo/redo changes event, it will simply redo/undo it and notify every undone/redone actions
 *      by their registered listeners.</li>
 *  </ul>
 *
 * <p><b>Usage:</b></p>
 * <p>
 * This class will be created by the application directly. The application can registers validators for
 * concrete actions or for all actions, action listeners for concrete actions or for all actions and registers
 * listeners for concrete GUI events and for all events. And the application can call handleActionEvent and
 * handleGUIEvent to handle the events.<br>
 * <b>Sample usage:</b>
 * <pre>
 *      // Register the listener to Action class
 *      eventManager.addActionEventListener(actionEventListener, Action.class);
 *      // Register the validator the all event class
 *      eventManager.addEventValidator(eventValidator);
 *      // Handle the simple ActionEvent
 *      eventManager.handleActionEvent(actionEvent);
 *      // Handle the undo changes event
 *      eventManager.handleActionEvent(undoChangesEvent);
 *      // Handle the redo changes event
 *
 *      eventManager.handleActionEvent(redoChangesEvent);
 *      // Register the gUIEventListener
 *      eventManager.addGUIEventListener(gUIEventListener);
 * </pre>
 * </p>
 *
 * <p><b>Thread Safety:</b></p>
 * <p>
 * This class is not thread-safe since the Map is used by the class. This class considered to be used in single
 * thread. If an application does intend to use this component in a multi-threaded environment, then it should ensure
 * the add/remove validator/listener methods and handleActionEvent/handleGUIEvent methods are synchronized externally.
 * </p>
 *
 * @author kinzz, TCSDEVELOPER
 * @version 1.0
 */
public class EventManager {
    /**
     * <p>Represents the action manager used by this event manager to execute/redo/undo the actions. It is set
     * in the constructor, it is immutable and will never be null.</p>
     */
    private final ActionManager actionManager;

    /**
     * <p>Represents the event validators used to validate the action of the events. It is immutable and will
     * never  be null. The type of key is Class, and it can be null, the concrete class of the action or null which
     * means the validator is suitable for all the action events. The value's type is Set&lt;ActionEventValidator&gt;,
     * and it can't be null and won't contain null element.</p>
     */
    private final Map<Class, Set<ActionEventValidator>> eventValidators
        = new HashMap<Class, Set<ActionEventValidator>>();

    /**
     * <p>Represents the event listeners which is listening to the specific action events. It is immutable and
     * will never be null. The type of key is Class, and it can be null, the concrete class of the action or null which
     * means the listener is listening to all the action events. The value's type is Set&lt;ActionEventListener&gt;,
     * and it can't be null and won't contain null element.</p>
     */
    private final Map<Class, Set<ActionEventListener>> actionEventListeners
        = new HashMap<Class, Set<ActionEventListener>>();

    /**
     * <p>Represents the GUI event listeners which listening to the specific GUI events. It is  and will never
     * be null. The type of key is Class, and it can be null, the event object class or null which means the listener
     * is listening to all the GUI events. The value's type is Set&lt;GUIEventListener&gt;, and it can't be null and
     * won't contain null element.</p>
     */
    private final Map<Class, Set<GUIEventListener>> guiEventListeners = new HashMap<Class, Set<GUIEventListener>>();

    /**
     * <p>
     * Constructor of the event manager with the given action manager.
     * </p>
     *
     *
     * @param actionManager the non null action manager used by this event manager
     *
     * @throws IllegalArgumentException if the actionManager is null
     */
    public EventManager(ActionManager actionManager) {
        checkNull(actionManager, "actionManager");
        this.actionManager = actionManager;
    }

    /**
     * <p>Handle the given action event.</p>
     *
     * @param event the non null action event to be handled
     *
     * @throws IllegalArgumentException if the event is null
     * @throws ActionExecutionException if there are problems detected in the execution of the Action, this exception
     *         is thrown by the action manager
     */
    public void handleActionEvent(ActionEvent event) throws ActionExecutionException {
        checkNull(event, "event");

        if (event instanceof UndoChangesEvent) {
            // The event is an UndoChangesEvent, call handleUndoChangesEvent(event)
            handleUndoChangesEvent((UndoChangesEvent) event);
        } else if (event instanceof RedoChangesEvent) {
            // The event is a RedoChangesEvent, call handleRedoChangesEvent(event)
            handleRedoChangesEvent((RedoChangesEvent) event);
        } else {
            // The event is a simple ActionEvent, call handleSimpleActionEvent(event)
            handleSimpleActionEvent(event);
        }
    }

    /**
     * <p>Handle the given GUI event. It will notify all the registered listeners.</p>
     *
     * @param event the non null GUI event to be handled
     *
     * @throws IllegalArgumentException if the event is null
     */
    public void handleGUIEvent(EventObject event) {
        checkNull(event, "event");

        // Get the corresponding listeners from the guiEventListener with the event.getClass and null
        // as the key
        Set<GUIEventListener> listeners = getAllElements(guiEventListeners, event.getClass());

        for (GUIEventListener listener : listeners) {
            // Notify the registered listeners
            listener.actionPerformed(event);
        }
    }

    /**
     * <p>Add the event validator for the given action class to the event manager.</p>
     *
     * @param eventValidator the non null event validator to be added
     * @param actionClass the non null class of the action which will be validated by this validator
     *
     * @throws IllegalArgumentException if eventValidator or actionClass is null or if the actionClass
     *         is not an Action class
     */
    public void addEventValidator(ActionEventValidator eventValidator, Class actionClass) {
        checkNull(eventValidator, "eventValidator");
        checkAssignable(Action.class, actionClass);

        addToMap(eventValidators, actionClass, eventValidator);
    }

    /**
     * <p>Add the action event listener for the given action class to the event manager.</p>
     *
     * @param listener the non null action event listener to be added
     * @param actionClass the possible null class of the action which will be listened by this listener
     *
     * @throws IllegalArgumentException if listener or actionClass or if the actionClass is not an Action class
     */
    public void addActionEventListener(ActionEventListener listener, Class actionClass) {
        checkNull(listener, "listener");
        checkAssignable(Action.class, actionClass);
        addToMap(actionEventListeners, actionClass, listener);
    }

    /**
     * <p>Add the GUI event listener for the given event class to the event manager.</p>
     *
     * @param listener the non null GUI event listener to be added
     * @param eventClass the non null class of the event which will be listened by this listener
     *
     * @throws IllegalArgumentException if listener or eventClass or if the eventClass is not an event object
     */
    public void addGUIEventListener(GUIEventListener listener, Class eventClass) {
        checkNull(listener, "listener");
        checkAssignable(EventObject.class, eventClass);

        // Add the GUI event listener for the given event class to the event manager
        addToMap(guiEventListeners, eventClass, listener);
    }

    /**
     * <p>Remove the action event listener of the given action class.</p>
     *
     * @param listener the non null action event listener to be removed
     * @param actionClass the non null class of the action which will be listened by this listener
     *
     * @throws IllegalArgumentException if listener or actionClass is null or if the actionClass is not an Action class
     */
    public void removeActionEventListener(ActionEventListener listener, Class actionClass) {
        checkNull(listener, "listener");
        checkAssignable(Action.class, actionClass);
        removeFromMap(actionEventListeners, actionClass, listener);
    }

    /**
     * <p>Remove the event validator of the given action class.</p>
     *
     * @param eventValidator the non null event validator to be removed
     * @param actionClass the non null class of the action which will be validated by this validator
     *
     * @throws IllegalArgumentException if eventValidator or actionClass is null or if the actionClass
     *         is not an Action class
     */
    public void removeEventValidator(ActionEventValidator eventValidator, Class actionClass) {
        checkNull(eventValidator, "eventValidator");
        checkAssignable(Action.class, actionClass);
        removeFromMap(eventValidators, actionClass, eventValidator);
    }

    /**
     * <p>Remove the GUI event listener of the given event object class.</p>
     *
     * @param listener the non null GUI event listener to be removed
     * @param eventClass the non null class of the event which will be listened by this listener
     *
     * @throws IllegalArgumentException if listener or eventClass is null or if the eventClass is not an event object
     */
    public void removeGUIEventListener(GUIEventListener listener, Class eventClass) {
        checkNull(listener, "listener");
        checkAssignable(EventObject.class, eventClass);
        removeFromMap(guiEventListeners, eventClass, listener);
    }

    /**
     * <p>Remove the action event listener for all action classes.</p>
     *
     * @param listener the non null action event listener to be removed
     *
     * @throws IllegalArgumentException if the listener is null
     */
    public void removeActionEventListener(ActionEventListener listener) {
        checkNull(listener, "listener");
        removeFromMap(actionEventListeners, null, listener);
    }

    /**
     * <p>Remove the GUI event listener for all event object classes.</p>
     *
     * @param listener the non null GUI event listener to be removed
     *
     * @throws IllegalArgumentException if the listener is null
     */
    public void removeGUIEventListener(GUIEventListener listener) {
        checkNull(listener, "listener");
        removeFromMap(guiEventListeners, null, listener);
    }

    /**
     * <p>Add the event validator, which will be able to validate all the action events, to the event manager.</p>
     *
     * @param eventValidator the non null event validator to be added
     *
     * @throws IllegalArgumentException if the eventValidator is null
     */
    public void addEventValidator(ActionEventValidator eventValidator) {
        checkNull(eventValidator, "eventValidator");
        addToMap(eventValidators, null, eventValidator);
    }

    /**
     * <p>Add the GUI event listener, which will listen to all the GUI events, to the event manager.</p>
     *
     * @param listener the non null GUI event listener to be added
     *
     * @throws IllegalArgumentException if the listener is null
     */
    public void addGUIEventListener(GUIEventListener listener) {
        checkNull(listener, "listener");
        addToMap(guiEventListeners, null, listener);
    }

    /**
     * <p>Remove the event validator for all action classes.</p>
     *
     * @param eventValidator the non null event validator to be removed
     *
     * @throws IllegalArgumentException if the eventValidator is null
     */
    public void removeEventValidator(ActionEventValidator eventValidator) {
        checkNull(eventValidator, "eventValidator");
        removeFromMap(eventValidators, null, eventValidator);
    }

    /**
     * <p>Add the action event listener, which will listen to all the action events, to the event manager.</p>
     *
     * @param listener the non null action event listener to be added
     *
     * @throws IllegalArgumentException if the listener is null
     */
    public void addActionEventListener(ActionEventListener listener) {
        checkNull(listener, "listener");
        addToMap(actionEventListeners, null, listener);
    }

    /**
     * <p>Handle the given simple action event.</p>
     *  <p>This method will validate the event by the registered validator and execute it according to the
     * validation. finally notify the registered action event listeners.</p>
     *
     * @param event the non null action event to be handled
     *
     * @throws ActionExecutionException if there are problems detected in the execution of the Action, this exception
     *         is thrown by the action manager
     */
    private void handleSimpleActionEvent(ActionEvent event)
        throws ActionExecutionException {
        // Get the action from the event
        Action action = event.getAction();

        // Get the all corresponding validators by the action.getClass and null
        Set<ActionEventValidator> validators = getAllElements(eventValidators, action.getClass());
        EventValidation validationResult = EventValidation.SUCCESSFUL;

        // For each validator, validate the event, get the worse result
        for (ActionEventValidator validator : validators) {
            EventValidation tempResult = validator.validateEvent(event);

            if (tempResult.compareTo(validationResult) > 0) {
                validationResult = tempResult;
            }
        }

        // If validation result is not DENIED, execute the action
        if (validationResult != EventValidation.DENIED) {
            actionManager.executeAction(action);
        }

        // Get the all corresponding listeners by the action.getClass and null
        Set<ActionEventListener> listeners = getAllElements(actionEventListeners, action.getClass());

        for (ActionEventListener listener : listeners) {
            // For each listener, notify the simple action event
            listener.actionPerformed(event, validationResult);
        }
    }

    /**
     * <p>Handle the given undo changes event. This method will first undo the action using ActionManager, then
     * notify all the listeners for each undoneAction.</p>
     *
     * @param event the non null action event to be handled
     * @throws UndoActionExecutionException if any exception occurs when undo the actions
     */
    private void handleUndoChangesEvent(UndoChangesEvent event) throws UndoActionExecutionException {
        // Get the action from the event
        UndoableAction action = event.getAction();

        // Get all to be undone actions
        List<UndoableAction> toBeUndoneActions = actionManager.getUndoableActionsToBeUndone();

        // Get the index of the action
        int index = toBeUndoneActions.indexOf(action);

        // Do nothing if the action could not be found
        if (index == -1) {
            return;
        }

        // IllegalArgumentException will be thrown here if the action of the event was not executed
        // correctly by ActionManager
        actionManager.undoActions(action);

        for (int i = 0; i <= index; ++i) {
            UndoableAction toBeUndoneAction = toBeUndoneActions.get(i);
            // Get all listeners
            Set<ActionEventListener> listeners = getAllElements(actionEventListeners, toBeUndoneAction.getClass());

            // For each listener, notify the action undo event
            for (ActionEventListener listener : listeners) {
                listener.undoActionPerformed(event, toBeUndoneAction);
            }
        }
    }

    /**
     * <p>Handle the given redo changes event. This method will first redo the action using ActionManager, then
     * notify all the listeners for each toBeRedoneAction.</p>
     *
     * @param event the non null action event to be handled
     * @throws RedoActionExecutionException if any exception occurs when redo the actions
     */
    private void handleRedoChangesEvent(RedoChangesEvent event) throws RedoActionExecutionException {
        // Get the action from the event
        UndoableAction action = event.getAction();

        // Get all to be redone actions
        List<UndoableAction> toBeRedoneActions = actionManager.getUndoableActionsToBeRedone();

        // Get the index of the action
        int index = toBeRedoneActions.indexOf(action);

        // Do nothing if the action could not be found
        if (index == -1) {
            return;
        }

        // IllegalArgumentException will be thrown here if the action of the event was not executed
        // correctly by ActionManager
        actionManager.redoActions(action);

        for (int i = 0; i <= index; ++i) {
            UndoableAction toBeRedoneAction = toBeRedoneActions.get(i);
            // Get all listeners
            Set<ActionEventListener> listeners = getAllElements(actionEventListeners, toBeRedoneAction.getClass());

            // For each listener, notify the action undo event
            for (ActionEventListener listener : listeners) {
                listener.redoActionPerformed(event, toBeRedoneAction);
            }
        }
    }

    /**
     * <p> Returns the action event listener that registered on given action class. </p>
     *
     * @param actionClass listeners registered on
     * @return the listener set that registered on given action class
     */
    public Set<ActionEventListener> getActionEventListener(Class actionClass){
    	return getAllElements(actionEventListeners, actionClass);
    }

    /**
     * <p>Checks whether the given Object is null.</p>
     *
     * @param arg the argument to be checked
     * @param name the name of the argument
     *
     * @throws IllegalArgumentException if the given Object is null
     */
    private static void checkNull(Object arg, String name) {
        if (arg == null) {
            throw new IllegalArgumentException(name + " should not be null.");
        }
    }

    /**
     * Check whether a given class is a type of specified class.
     *
     * @param baseClass The specified class type
     * @param classType The class to be checked
     *
     * @throws IllegalArgumentException if the classType is not a class of baseClass.
     */
    private static void checkAssignable(Class<?> baseClass, Class<?> classType) {
        checkNull(classType, "classType");
        if (!baseClass.isAssignableFrom(classType)) {
            throw new IllegalArgumentException("The class represented by " + classType.getName()
                    + " is not a class of " + baseClass.getName() + ".");
        }
    }

    /**
     * Get all the elements from the Set which are corresponded to either 'key' or null value, then merge them
     * into a new one.
     *
     * @param <T> specify the type of the Set's element
     * @param map the map which the element will be get from
     * @param key the key of the specified Set
     *
     * @return all the elements from the Set which are corresponded to either 'key' or null value
     */
    private static <T> Set<T> getAllElements(Map<Class, Set<T>> map, Class key) {
        Set<T> ret = new HashSet<T>();

        // Get the set with 'key' value
        Set<T> tempSet = map.get(key);

        if (tempSet != null) {
            ret.addAll(tempSet);
        }

        // Get the set with 'null' value
        tempSet = map.get(null);

        if (tempSet != null) {
            ret.addAll(tempSet);
        }

        return ret;
    }

    /**
     * <p>This static method will insert the specified element to the Set corresponding to the specified key.
     * If the Set with specified key is not existent, simply create an empty Set and put it to the map.</p>
     *
     * @param <T> specify the type of the Set's element
     * @param map the map which the element will be put into
     * @param key the key of the specified Set
     * @param element the element which will be added to the Set corresponding to the specified key
     */
    private static <T> void addToMap(Map<Class, Set<T>> map, Class key, T element) {
        Set<T> set = map.get(key);

        // Create a new Set If the corresponding Set is not existent
        if (set == null) {
            set = new HashSet<T>();
            // Add the empty Set to map
            map.put(key, set);
        }

        // Add the element to Set
        set.add(element);
    }

    /**
     * <p>This static method will remove the specified element from the Set, if existent, corresponding to the
     * specified key.</p>
     *
     * @param <T> specify the type of the Set's element
     * @param map the map which the element will be removed from
     * @param key the key of the specified Set
     * @param element the element which will be removed from the Set corresponding to the specified key
     */
    private static <T> void removeFromMap(Map<Class, Set<T>> map, Class key, T element) {
        Set<T> set = map.get(key);

        if (set != null) {
            // Remove the element from the Set
            set.remove(element);
        }
    }
}
