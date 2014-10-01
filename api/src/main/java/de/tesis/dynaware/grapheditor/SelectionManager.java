/*
 * Copyright (C) 2005 - 2014 by TESIS DYNAware GmbH
 */
package de.tesis.dynaware.grapheditor;

import java.util.List;

import javafx.collections.ObservableList;
import de.tesis.dynaware.grapheditor.model.GJoint;
import de.tesis.dynaware.grapheditor.model.GNode;

/**
 * Provides actions related to selections in the graph editor.
 */
public interface SelectionManager {

    /**
     * Gets the observable list of currently-selected nodes.
     *
     * <p>
     * This list is read-only. Nodes should be selected via their skin class.
     * </p>
     *
     * @return the list of selected nodes
     */
    ObservableList<GNode> getSelectedNodes();

    /**
     * Gets the observable list of currently-selected joints.
     *
     * <p>
     * This list is read-only. Joints should be selected via their skin class.
     * </p>
     *
     * @return the list of selected joints
     */
    ObservableList<GJoint> getSelectedJoints();

    /**
     * Cuts the current selection. Saves cut nodes and the connections bewteen them to memory to be pasted later.
     */
    void cut();

    /**
     * Copies the current selection. Saves copied nodes and the connections bewteen them to memory to be pasted later.
     */
    void copy();

    /**
     * Pastes the previously cut / copied selection.
     *
     * @return the list of pasted nodes
     */
    List<GNode> paste();

    /**
     * Selects all 'selectable' elements (i.e. nodes and joints) in the editor.
     */
    void selectAll();

    /**
     * Deletes all elements that are currently selected.
     */
    void deleteSelection();

    /**
     * Backs up the selection state, i.e. what nodes and joints are currently selected.
     *
     * <p>
     * The z-ordering of the root nodes of node and joint skins is also backed up.
     * </p>
     */
    void backup();

    /**
     * Restores the selection state from backup, i.e. reselects nodes and joints that were selected at the last backup.
     *
     * <p>
     * The z-ordering of the root nodes and joints is also restored.
     * </p>
     */
    void restore();
}
