package view.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import view.gui.icons.ShapesIcon;

public final class Toolbar extends JPanel {

    private static final Color DIVIDER = new Color(0x3A3E43);
    private static final Color BACKGROUND = new Color(0x25282C);

    private final Button resetButton;
    private final Button shapesButton;
    private final Button cameraButton;
    private final CheckBox axesCheckBox;
    private final JPopupMenu shapesPopup;
    private final JPanel shapeOptionsPanel = new JPanel();
    private final Map<String, CheckBox> shapeOptions = new LinkedHashMap<>();

    /* -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- Constructors -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */

    public Toolbar() {
        super(new BorderLayout());
        setOpaque(true);
        setFocusable(true);
        setBackground(BACKGROUND);
        setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 1, 0, DIVIDER),
            BorderFactory.createEmptyBorder(10, 6, 4, 6)
        ));

        JPanel controls = new JPanel(new FlowLayout(FlowLayout.LEFT, 6, 0));
        controls.setOpaque(false);

        shapesButton = new Button("Tvary  ▾", false);
        shapesButton.setOutlineVisible(false);
        shapesButton.setIcon(new ShapesIcon());
        shapesButton.setIconTextGap(7);
        shapesButton.setToolTipText("Vyberte žádný, jeden nebo více tvarů");
        JPanel shapesControl = new JPanel(new BorderLayout());
        shapesControl.setOpaque(false);
        shapesControl.setBorder(BorderFactory.createEmptyBorder(0, 2, 0, 6));
        shapesControl.add(shapesButton, BorderLayout.CENTER);
        controls.add(shapesControl);

        cameraButton = new Button("Perspektivní projekce", false);
        cameraButton.setToolTipText("Nastavení projekce");
        controls.add(cameraButton);

        axesCheckBox = new CheckBox("Osy");
        axesCheckBox.setFont(axesCheckBox.getFont().deriveFont(Font.BOLD, 12f));
        axesCheckBox.setToolTipText("Zobrazit souřadnicové osy");
        controls.add(axesCheckBox);
        add(controls, BorderLayout.WEST);

        JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT, 4, 0));
        resetButton = new Button("Reset");
        actions.setOpaque(false);
        actions.add(resetButton);
        add(actions, BorderLayout.EAST);

        shapesPopup = createShapesPopup();
    }

    /* -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- */

    private JPopupMenu createShapesPopup() {
        JPopupMenu popup = new JPopupMenu();
        popup.setOpaque(true);
        popup.setBackground(BACKGROUND);
        popup.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JPanel contents = new JPanel(new BorderLayout(0, 8));
        contents.setBackground(BACKGROUND);
        contents.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(DIVIDER),
            BorderFactory.createEmptyBorder(12, 14, 12, 14)
        ));

        JLabel title = new JLabel("Zobrazované tvary");
        title.setForeground(Color.WHITE);
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 13));
        contents.add(title, BorderLayout.NORTH);
        shapeOptionsPanel.setOpaque(false);
        shapeOptionsPanel.setLayout(new BoxLayout(shapeOptionsPanel, BoxLayout.Y_AXIS));
        contents.add(shapeOptionsPanel, BorderLayout.CENTER);
        popup.add(contents);
        return popup;
    }

    /* -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= Setters -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */

    public void registerShapeOption(String shapeName) {
        CheckBox option = new CheckBox(shapeName);
        shapeOptions.put(shapeName, option);
        shapeOptionsPanel.add(option);
        shapeOptionsPanel.revalidate();
    }

    /* -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= Getters -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */

    public Button getShapesButton() {
        return shapesButton;
    }

    public Button getCameraButton() {
        return cameraButton;
    }

    public Button getResetButton() {
        return resetButton;
    }

    public CheckBox getAxesCheckBox() {
        return axesCheckBox;
    }

    public JPopupMenu getShapesPopup() {
        return shapesPopup;
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension preferredSize = super.getPreferredSize();
        preferredSize.height = 56;
        return preferredSize;
    }

    public Map<String, CheckBox> getShapeOptions() {
        return Collections.unmodifiableMap(shapeOptions);
    }

}
