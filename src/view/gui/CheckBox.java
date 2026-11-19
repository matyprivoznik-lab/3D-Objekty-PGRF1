package view.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;

import view.gui.icons.CheckIcon;

public final class CheckBox extends JCheckBox {

    public CheckBox(String text) {
        super(text);
        setOpaque(false);
        setIconTextGap(8);
        setFocusPainted(false);
        setBorderPainted(false);
        setForeground(Color.WHITE);
        setContentAreaFilled(false);
        setIcon(new CheckIcon(false));
        setSelectedIcon(new CheckIcon(true));
        setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 13));
        setBorder(BorderFactory.createEmptyBorder(5, 4, 5, 4));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

}
