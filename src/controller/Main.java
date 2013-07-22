package controller;

import c_view.ToolView;
import model.ToolModel;

public class Main {

	public static void main(String[] args) {
		ToolView toolview = new ToolView();
		ToolModel toolModel = new ToolModel();
		new ToolController(toolview, toolModel);

	}

}
