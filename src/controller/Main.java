package controller;

import model.ToolModel;
import view.ToolView;

public class Main {

    public static void main(String[] args) {
        ToolView toolview = new ToolView();        
        ToolModel toolModel = new ToolModel();
        ToolController toolController = new ToolController(toolview, toolModel);
        

    }

}
