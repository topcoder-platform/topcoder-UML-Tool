/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.toolbars.elements;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;

/**
 * <p>
 * This class represents the unit panel of the element toolbar. It can be
 * constructed as &quot;connectors&quot; or &quot;nodes&quot; panel.It contains
 * two inner panels. One is for the title, another is for the instances of
 * JToggleButton. The instances of JToggleButton are layed out in the FlowLayout
 * way. It has two initialization ways. One is from programming, another is from
 * loading configuration file.
 * </p>
 * <p>
 * The private method &quot;initSectionPanel&quot; is used to initialize the
 * SectionPanel. The private method &quot;createJToggleButton&quot; is used to
 * create new JToggleButton instance. The public method
 * &quot;getSelectedButtonName&quot; is used to retrieve the name of current
 * selected button. The public method &quot;unselectButton&quot; is used to
 * unselect the selected button.
 * </p>
 * <p>
 * Thread Safety: The members are mutable, and the public methods can be
 * accessed by many threads. Hence, this class is not thread safe.
 * </p>
 * <li>
 * <ul>
 * <b>look</b> - The name of the class that implements the look and feel
 * (required)
 * </ul>
 * <ul>
 * <b>sectionText</b> - The section text, which is label at the head of section
 * panel (required)
 * </ul>
 * <ul>
 * <b>backgroundColor</b> - The background color of section text panel. If it
 * doesn't exist, the component will use default Color.LIGHT_GRAY (optional)
 * </ul>
 * <ul>
 * <b>buttonsName</b> - The buttons' name array. If it doesn't exist, the
 * component will create an empty section panel (optional)
 * </ul>
 * <ul>
 * <b>imageLocations</b> - The locations of button's icon images. If it doesn't
 * exist, no image icon will be created for buttons (optional)
 * </ul>
 * </li>
 * <p>
 * Configuration example:
 * </p>
 *
 * <pre>
 *          &lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot; ?&gt;
 *          &lt;CMConfig&gt;
 *             &lt;Config name=&quot;com.topcoder.gui.toolbars.elements&quot;&gt;
 *                &lt;Property name=&quot;look&quot;&gt;
 *                   &lt;Value&gt;javax.swing.plaf.metal.MetalLookAndFeel&lt;/Value&gt;
 *                &lt;/Property&gt;
 *                &lt;Property name=&quot;sectionText&quot;&gt;
 *                   &lt;Value&gt;connectors&lt;/Value&gt;
 *                &lt;/Property&gt;
 *                &lt;Property name=&quot;backgroundColor&quot;&gt;
 *                   &lt;Value&gt;YELLOW&lt;/Value&gt;
 *                &lt;/Property&gt;
 *                &lt;Property name=&quot;buttonsName&quot;&gt;
 *                &lt;Value&gt;up&lt;/Value&gt;
 *                   &lt;Value&gt;down&lt;/Value&gt;
 *                &lt;/Property&gt;
 *                &lt;Property name=&quot;imageLocations&quot;&gt;
 *                   &lt;Value&gt;toolbarButtonGraphics/navigation/Up16.gif&lt;/Value&gt;
 *                   &lt;Value&gt;toolbarButtonGraphics/navigation/Down16.gif&lt;/Value&gt;
 *                &lt;/Property&gt;
 *             &lt;/Config&gt;
 *          &lt;/CMConfig&gt;
 * </pre>
 *
 * <p>
 * Code sample for creating a section panel with parametric constructor:
 * </p>
 *
 * <pre>
 * SectionPanel elementsPanel = new SectionPanel(&quot;elements&quot;, Color.RED,
 * 		buttonNames, icons, look);
 * </pre>
 *
 * @author wang_liang, enefem21
 * @version 1.0
 */
public class SectionPanel extends JPanel {

	/** Serial version UID. */
	private static final long serialVersionUID = 7527819363135320281L;

	/**
	 * <p>
	 * This inner class act as the listener for the action event of all buttons
	 * in the SectionPanel. When an action event happens, it will find the
	 * button that the action event comes from. If the state of the button is
	 * unselected, notify all the interested listeners in new work threads.
	 * </p>
	 * <p>
	 * Thread Safety: The class has no member, and the public method is the
	 * implementation of ActionListener. Hence, this class is thread safe.
	 * </p>
	 *
	 * @author wang_liang, enefem21
	 * @version 1.0
	 */
	private final class SectionPanelListener implements ActionListener {

		/**
		 * <p>
		 * Empty constructor.
		 * </p>
		 */
		public SectionPanelListener() {
			// do nothing
		}

		/**
		 * <p>
		 * The action performed after one button is clicked. It's called by the
		 * Event Dispatch Thread.
		 * </p>
		 *
		 * @param e
		 *            the action event that comes from the clicked button.
		 */
		public void actionPerformed(ActionEvent e) {
			// Find the button that the action event comes from.
			String buttonName = e.getActionCommand();
			JToggleButton button = buttonsMap.get(buttonName);

			// If the button is selected or unselected, notify all the interested listeners.
			// The interested listeners are the
			// listeners that registered into the member listenersMap.
			List<ElementSelectedListener> list = listenersMap.get(buttonName);
			if (list != null) {
				for (ElementSelectedListener elementSelectedListener : list) {
					elementSelectedListener.elementSelected(button,
							SectionPanel.this);
				}
			}
		}
	}

	/**
	 * <p>
	 * Represents the map between button's name and JButton object. This is hold
	 * to enable fast access to the JToggleButton in case of any event. Not
	 * null, can be empty map. The key and value is not null. The key is not
	 * null. Not changed after initialization.
	 * </p>
	 */
	private final Map<String, JToggleButton> buttonsMap = new HashMap<String, JToggleButton>();

	/**
	 * <p>
	 * Represents the map between button name and its listeners list. This is
	 * hold to enable fast access to all listeners of a JToggleButton in case of
	 * any event. Not null, can be empty map. The key and value is not null. The
	 * key is not null. Not changed after initialization.
	 * </p>
	 */
	private final Map<String, List<ElementSelectedListener>> listenersMap = new HashMap<String, List<ElementSelectedListener>>();

	/**
	 * <p>
	 * Represents the listener for action event of the buttons. Not null. Not
	 * changed after initialization.
	 * </p>
	 */
	private final SectionPanelListener listener = new SectionPanelListener();

	/**
	 * <p>
	 * Constructor with section text, button names and button images arguments.
	 * </p>
	 *
	 * @param look
	 *            the class name of look that the panel should be like.
	 * @param sectionText
	 *            the section text, which should not be null and may be empty.
	 * @param buttonNames
	 *            the buttons name array, which may be <code>null</code>.
	 *            However, if buttonNames is not <code>null</code>, element
	 *            in it should not be <code>null</code> or empty.
	 * @param backgroundColor
	 *            the background color of section text panel in the section
	 *            panel, which should not be null.
	 * @param imageIcons
	 *            the ImageIcon array, which may be <code>null</code>.
	 *            However, if images is not <code>null</code>, element in it
	 *            should not be <code>null</code>.
	 *
	 * @throws IllegalArgumentException
	 *             if sectionText is null, backgroundColor is null, element in
	 *             buttonNames is null or empty, or element in images is null.
	 *             Also if the length of the buttonNames and the images is not
	 *             equal.
	 */
	public SectionPanel(String sectionText, Color backgroundColor,
			String[] buttonNames, ImageIcon[] imageIcons, String look) {

		// arguments check
		ArgumentCheckUtil.checkNotNull("sectionText", sectionText);
		ArgumentCheckUtil.checkNotNull("backgroundColor", backgroundColor);
		ArgumentCheckUtil.checkNotContainsNullOrEmptyString("buttonNames",
				buttonNames);
		ArgumentCheckUtil.checkNotContainsNull("imageIcons", imageIcons);
		ArgumentCheckUtil.checkNotNullAndNotEmpty("look", look);

		if (ArgumentCheckUtil.isNull(buttonNames)) {
			buttonNames = new String[] {};
		}

		if (ArgumentCheckUtil.isNull(imageIcons)) {
			imageIcons = new ImageIcon[] {};
		}

		if (imageIcons.length != buttonNames.length) {
			throw new IllegalArgumentException(
					"The length of buttonNames and imageIcons is not equal");
		}

		// initialize section panel
		initSectionPanel(sectionText, backgroundColor, buttonNames, imageIcons,
				look);

		// Set look of the SectionPanel.
		LookAndFeelUtil.setLookAndFeel(look);

	}

	/**
	 * <p>
	 * Constructor with namespace argument.
	 * </p>
	 *
	 * @param namespace
	 *            the namespace that stores configuration information.
	 *
	 * @throws SectionPanelConfigurationException
	 *             if namespace is unknown, or one element of imageLocations is
	 *             null.
	 * @throws IllegalArgumentException
	 *             if namespace is null or empty.
	 */
	public SectionPanel(String namespace)
			throws SectionPanelConfigurationException {
		// argument check
		ArgumentCheckUtil.checkNotNullAndNotEmpty("namespace", namespace);

		try {
			// Get ConfigManager instance
			ConfigManager cm = ConfigManager.getInstance();

			// Load "look" property.
			String look = cm.getString(namespace, "look");
			if (ArgumentCheckUtil.isNullOrEmptyString(look)) {
				throw new SectionPanelConfigurationException(
						"'look' property can't be null or an empty string");
			}

			// Load "sectionText" property.
			String sectionText = cm.getString(namespace, "sectionText");
			if (ArgumentCheckUtil.isNull(sectionText)) {
				throw new SectionPanelConfigurationException(
						"'sectionText' property can't be null");
			}

			// Load "backgroundColor" property.
			String backgroundColorString = cm.getString(namespace,
					"backgroundColor");
			Color backgroundColor = null;

			// Create Color instance by the "backgroundColor" property.
			backgroundColor = ColorUtil.getColor(backgroundColorString);

			// Load "buttonsName" property.
			String[] buttonsName = cm.getStringArray(namespace, "buttonsName");
			if (ArgumentCheckUtil.isNull(buttonsName)) {
				buttonsName = new String[] {};
			}
			for (String buttonName : buttonsName) {
				if (ArgumentCheckUtil.isNullOrEmptyString(buttonName)) {
					throw new SectionPanelConfigurationException(
							"buttonsName contains null or empty string");
				}
			}

			// Load "imageLocations" property.
			String[] imageLocations = cm.getStringArray(namespace,
					"imageLocations");
			ImageIcon[] imageIcons = null;
			if (ArgumentCheckUtil.isNull(imageLocations)) {
				imageIcons = new ImageIcon[] {};
			} else {
				// If "imageLocations" property is not null, create new
				// ImageIcon instance for every element in
				// "imageLocations".
				imageIcons = new ImageIcon[imageLocations.length];
				for (int i = 0; i < imageLocations.length; i++) {
					if (ArgumentCheckUtil
							.isNullOrEmptyString(imageLocations[i])) {
						throw new SectionPanelConfigurationException(
								"imageLocations contains null or empty string");
					}
					if (!new File(imageLocations[i]).exists()) {
						throw new SectionPanelConfigurationException(
								"imageLocations contains unexist file name");
					}
					imageIcons[i] = new ImageIcon(imageLocations[i]);
				}
			}

			// Check length of buttonsName and imageIcons
			if (buttonsName.length != imageIcons.length) {
				throw new SectionPanelConfigurationException(
						"The length of buttonsName is not equals the length of imageIcons");
			}

			// Call initSectionPanel method to finish initialization.
			initSectionPanel(sectionText, backgroundColor, buttonsName,
					imageIcons, look);

			try {
				// Set look of the SectionPanel.
				LookAndFeelUtil.setLookAndFeel(look);
			} catch (IllegalArgumentException e) {
				throw new SectionPanelConfigurationException(e.getMessage(), e
						.getCause());
			}

		} catch (UnknownNamespaceException e) {
			throw new SectionPanelConfigurationException(
					"Exception happen when retrieves configuration value", e);
		}

	}

	/**
	 * <p>
	 * Initialize the section panel.
	 * </p>
	 *
	 * @param look
	 *            the class name of look that the panel should be like.
	 * @param sectionText
	 *            the section text, which should not be null and may be empty.
	 * @param buttonNames
	 *            the buttons name array, which may be <code>null</code>.
	 *            However, if buttonNames is not <code>null</code>, element
	 *            in it should not be <code>null</code> or empty.
	 * @param backgroundColor
	 *            the background color of section text panel in the section
	 *            panel, which should not be null.
	 * @param imageIcons
	 *            the ImageIcon array, which may be <code>null</code>.
	 *            However, if images is not <code>null</code>, element in it
	 *            should not be <code>null</code>.
	 */
	private void initSectionPanel(String sectionText, Color backgroundColor,
			String[] buttonNames, ImageIcon[] imageIcons, String look) {

		// Set layout of the panel to be new BorderLayout instance.
		setLayout(new BorderLayout());

		// Create new JPanel instance for section text, set the background color
		// of the instance to be
		// backgroundColor.
		JPanel sectionTextPanel = new JPanel();
		sectionTextPanel.setBackground(backgroundColor);

		// Set layout of the section text panel to be new FlowLayout instance.
		sectionTextPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 0));

		// If sectionText is not empty, add new JLabel instance with
		// sectionText. Otherwise, add new JLabel
		// instance with "\n" as empty JLabel.
		JLabel textLabel = null;
		if (ArgumentCheckUtil.isEmptyString(sectionText)) {
			textLabel = new JLabel();
		} else {
			textLabel = new JLabel(sectionText);
		}
		sectionTextPanel.add(textLabel);

		// Add the sectionTextPanel into the north part of the main panel.
		this.add(sectionTextPanel, BorderLayout.NORTH);

		// Create new JPanel instance to hold JToggleButton.
		JPanel buttonsPanel = new JPanel();

		// Create new FlowLayout instance, and set horizontal gap and vertical
		// gap to be 0.
		FlowLayout buttonsLayout = new FlowLayout(FlowLayout.LEFT, 0, 0);

		// Set layout of buttonsPanel to be buttonsLayout.
		buttonsPanel.setLayout(buttonsLayout);

		// If buttonNames is not null, create new JToggleButton instance for
		// each buttonName, and add it into
		// buttonsPanel.
		if (buttonNames != null) {
			for (int i = 0; i < buttonNames.length; i++) {
				buttonsPanel.add(createJToggleButton(buttonNames[i],
						imageIcons[i]));
			}
		}

		// Add the buttonsPanel into the center of the main panel.
		this.add(buttonsPanel, BorderLayout.CENTER);
	}

	/**
	 * <p>
	 * Create new JToggleButton instance.
	 * </p>
	 *
	 * @param image
	 *            the ImageIcon instance used as the button icon. It may be
	 *            null.
	 * @param name
	 *            the name of the JToggleButton, which is used to identified the
	 *            button.
	 *
	 * @return the toggle button
	 */
	private JToggleButton createJToggleButton(String name, ImageIcon image) {
		// Create new JToggleButton.
		JToggleButton button = new JToggleButton();
		button.setName(name);

		// Set action command of the new JToggleButton to be name.
		button.setActionCommand(name);
		button.setToolTipText(name);

		// Set icon of the action.
		button.setIcon(image);
		if (image != null) {
			Dimension preferredSize = new Dimension(image.getIconWidth() + 4,
					image.getIconHeight() + 4);
			button.setPreferredSize(preferredSize);
		}

		// Add listener into the button.
		button.addActionListener(listener);

		// Put the name and button pair into the member buttonsMap;
		buttonsMap.put(name, button);

		// Return the button.
		return button;
	}

	/**
	 * <p>
	 * Unselect the selected button.
	 * </p>
	 *
	 * @param buttonName
	 *            the name that the button will be unselected.
	 *
	 * @throws IllegalArgumentException
	 *             if name is null or empty.
	 */
	public void unselectButton(String buttonName) {
		// argument check
		ArgumentCheckUtil.checkNotNullAndNotEmpty("buttonName", buttonName);

		// Retrieve the JToggleButton object by selectedButtonName.
		JToggleButton button = buttonsMap.get(buttonName);

		// If the returned button is null, just return. Otherwise, unselect the
		// JToggleButton object
		if (button != null) {
			button.setSelected(false);
		}
	}

	/**
	 * <p>
	 * Add a new listener which will be notofied in case of any selection event
	 * of the specified button.
	 * </p>
	 * <p>
	 * If the button is not available, then do nothing.
	 * </p>
	 *
	 * @param buttonName
	 *            the name of the specified button, which should not be null or
	 *            empty.
	 * @param listener
	 *            the listener, which cares the selection event of the specified
	 *            button.
	 *
	 * @throws IllegalArgumentException
	 *             if buttonsName is null or empty, or listener is null.
	 */
	public void addElementSelectedListener(String buttonName,
			ElementSelectedListener listener) {
		// argument check
		ArgumentCheckUtil.checkNotNullAndNotEmpty("buttonName", buttonName);
		ArgumentCheckUtil.checkNotNull("listener", listener);
		if (!buttonsMap.containsKey(buttonName)) {
			return;
		}

		// Get the listeners' list of the specified button.
		List<ElementSelectedListener> list = listenersMap.get(buttonName);

		// If list is null, create a new ArrayList.
		if (list == null) {
			list = new ArrayList<ElementSelectedListener>();
			listenersMap.put(buttonName, list);
		}

		// If list doesn't contain the listener, add the listener into it.
		if (!list.contains(listener)) {
			list.add(listener);
		}

	}

	/**
	 * <p>
	 * Remove listener, which cares the selection event of the specified button.
	 * </p>
	 * <p>
	 * If the button is not available, then do nothing.
	 * </p>
	 *
	 * @param buttonName
	 *            the name of the specified button, which should not be null or
	 *            empty.
	 * @param listener
	 *            the listener, which cares the selection event of the specified
	 *            button.
	 *
	 * @throws IllegalArgumentException
	 *             if buttonsName is null or empty, or listener is null.
	 */
	public void removeElementSelectedListener(String buttonName,
			ElementSelectedListener listener) {
		// argument check
		ArgumentCheckUtil.checkNotNullAndNotEmpty("buttonName", buttonName);
		ArgumentCheckUtil.checkNotNull("listener", listener);

		// Get the listeners' list of the specified button.
		List<ElementSelectedListener> list = listenersMap.get(buttonName);

		// If the list is null, just return.
		if (list == null) {
			return;
		}

		// If the list contains the listener, remove it.
		list.remove(listener);
	}

	/**
	 * <p>
	 * Add new listener for all buttons in the SectionPanel.
	 * </p>
	 *
	 * @param listener
	 *            he listener, which cares the selection event of all buttons.
	 *
	 * @throws IllegalArgumentException
	 *             if listener is null.
	 */
	public void addListenerForAllButtons(ElementSelectedListener listener) {
		// argument check
		ArgumentCheckUtil.checkNotNull("listener", listener);

		// Iterate the member buttonsMap
		for (String buttonName : buttonsMap.keySet()) {
			addElementSelectedListener(buttonName, listener);
		}
	}

}
