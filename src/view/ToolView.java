package view;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class ToolView {
    private JComboBox userIDComboBox1;
    private JLabel labelUser1;
    private JButton opUsPg, addRes, newItems, reset, dropAll, ddms;
    private JFrame frame;
    private String[] usersIDs = {"", "UDID1.............", "UDID2............." };
    private DefaultComboBoxModel model1;
    private JButton addResMas;
    private String[] itemTypes = {"Charm", "Collactable"};
    private JComboBox itemTypesComboBox;
    private DefaultComboBoxModel model2;
    private String[] serverUrls = {"http://54.234.204.160/bingo/index.php/admin/find_player/", "http://23.22.103.229/bingo/index.php/admin/update_player/"};
    private JComboBox serverComboBox;
    private JTextField itemsIds;
    private ComboBoxModel model3;
    private JComboBox jiraComboBox;
    private Object[] jiraSearches;

    public ToolView() {

        JPanel windowContent = new JPanel();
        FlowLayout flowLayout = new FlowLayout(1, 5, 10);
        windowContent.setLayout(flowLayout);

        labelUser1 = new JLabel("User ID:");

        // Creating ComboBoxes and setting AutoCompleate to them
        model1 = new DefaultComboBoxModel(usersIDs);
        userIDComboBox1 = new JComboBox(model1);
        userIDComboBox1.setEditable(true);
//        AutoCompleteDecorator.decorate(userIDComboBox1);

        itemTypesComboBox = new JComboBox(itemTypes);
        
        model2 = new DefaultComboBoxModel(serverUrls );
        serverComboBox = new JComboBox(model2);
        serverComboBox.setEditable(true);
        
        opUsPg = new JButton("OpenPage");
        addRes = new JButton("AddResources");
        addResMas = new JButton("AddResourcesMastery");
        newItems = new JButton("AddItems");
        reset = new JButton("Reset");
        dropAll = new JButton("DropAllItems");
        ddms = new JButton("DDMS");

        itemsIds = new JTextField(15);
        
        model3 = new DefaultComboBoxModel(jiraSearches);
        jiraComboBox = new JComboBox(model3);
        jiraComboBox.setEditable(true);
        
        windowContent.add(labelUser1);
        windowContent.add(userIDComboBox1);

        windowContent.add(opUsPg);
        windowContent.add(addRes);
        windowContent.add(addResMas);
        
        windowContent.add(itemTypesComboBox);
        windowContent.add(itemsIds);
        windowContent.add(newItems);
        
        
        windowContent.add(dropAll);
        windowContent.add(reset);
        
        windowContent.add(serverComboBox);
        
        windowContent.add(ddms);

        frame = new JFrame("Admin");
        frame.setContentPane(windowContent);
        frame.setSize(1100, 100);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public JButton getOpUsPg() {
        return opUsPg;
    }

    public JButton getAddRes() {
        return addRes;
    }

    public JButton getNewItems() {
        return newItems;
    }

    public JButton getReset() {
        return reset;
    }

    public JButton getDropAll() {
        return dropAll;
    }

    public JButton getDdms() {
        return ddms;
    }

    public JButton getAddResMas() {
        return addResMas;
    }

    public void addListener(ActionListener viewListener) {
        opUsPg.addActionListener(viewListener);
        addRes.addActionListener(viewListener);
        addResMas.addActionListener(viewListener);
        newItems.addActionListener(viewListener);
        dropAll.addActionListener(viewListener);
        reset.addActionListener(viewListener);
        ddms.addActionListener(viewListener);

    }

    public String getUserId() {
        String userId = (String) userIDComboBox1.getSelectedItem();
        return userId;
    }
    
    public String getItemType() {
        String itemType = (String) itemTypesComboBox.getSelectedItem();
        return itemType;
    }
    
    public String getServerUrl() {
        String serverUrl = (String) serverComboBox.getSelectedItem();
        return serverUrl;
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(
                getFrame(),
                message, "Info",
                JOptionPane.WARNING_MESSAGE);
        
    }

    public JFrame getFrame() {
        return frame;
    }

    public String getItemsIds() {
        return itemsIds.getText();
    }

    
    
}