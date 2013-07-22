package controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;

import model.ScriptName;
import model.ToolModel;
import c_view.ToolView;

public class ToolController implements ActionListener {

	private ToolView toolview;
	private ToolModel toolModel;
	private String dDMSpath = "/Users/z.alex.kurocha/adt-bundle-mac-x86_64/sdk/tools/monitor";

	public ToolController(ToolView toolview, ToolModel toolModel) {
		this.toolview = toolview;
		this.toolModel = toolModel;
		toolview.addListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String userId = toolview.getUserId();

		JButton clickedButton = (JButton) e.getSource();

		if (clickedButton == toolview.getJiraButton()) {
			String jiraQuerry = toolview.getJiraQuerry();
			toolModel.openJira(jiraQuerry);
		} else if (clickedButton == toolview.getDdms()) {
			openMonitor();
		} else if (clickedButton == toolview.getGmail()) {
			toolModel.openGmail();

		} else {

			if (!userId.equals("")) {

				addIDToComboBoxModel();

				String serverUrl = toolview.getServerUrl();

				ScriptName script = null;
				if (clickedButton == toolview.getOpUsPg()) {
					script = ScriptName.opUsPg;
				} else if (clickedButton == toolview.getAddRes()) {
					script = ScriptName.addRes;
				} else if (clickedButton == toolview.getAddResMas()) {
					script = ScriptName.addResMas;
				} else if (clickedButton == toolview.getDropAll()) {
					// script = ScriptName.dropAll;
					toolview.showMessage("Not implemanted yet");
				} else if (clickedButton == toolview.getReset()) {
					script = ScriptName.reset;
				} else if (clickedButton == toolview.getNewItems()) {

					String itemType = toolview.getItemType();
					String itemIds = toolview.getItemsIds();

					try {
						String[] itemIdsArray = exstructItemsIds(itemIds);

						toolModel.setItemType(itemType);
						toolModel.setItemIds(itemIdsArray);
						script = ScriptName.newItems;

					} catch (NumberFormatException error) {
						toolview.showMessage("Enter items Ids separated with comma or/and space char");
					}
				}

				if (script != null) {
					toolModel.runScript(serverUrl, userId, script);
				}

			} else {
				toolview.showMessage("Enter user ID");
			}
		}

	}

	private String[] exstructItemsIds(String itemIds)
			throws NumberFormatException {

		String[] itemIdsArray = null;
		itemIds = itemIds.replace(",", " ");
		itemIds = itemIds.trim().replaceAll(" +", " ");
		itemIdsArray = itemIds.split(" ");
		for (int i = 0; i < itemIdsArray.length; i++) {
			itemIdsArray[i] = itemIdsArray[i].trim();
			// just to catch exception if the user entered letters
			Integer.valueOf(itemIdsArray[i]);
		}
		return itemIdsArray;
	}

	public void addIDToComboBoxModel() {
		String idFromTextField;
		idFromTextField = (String) toolview.getUserIDComboBox1()
				.getSelectedItem();
		if (toolview.getModel1().getIndexOf(idFromTextField) == -1) {
			toolview.getModel1().addElement(idFromTextField.trim());
		}
		System.out.println(idFromTextField);
	}

	private void openMonitor() {
		try {
			File ddmsFile = new File(dDMSpath);
			if (ddmsFile.exists()) {

				if (Desktop.isDesktopSupported()) {
					Desktop.getDesktop().open(ddmsFile);
				} else {
					toolview.showMessage("Awt Desktop is not supported!");
				}
			} else {
				toolview.showMessage("File is not exists! Provide correct hardcoded path");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
