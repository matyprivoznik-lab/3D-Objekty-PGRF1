package view.gui.icons;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.Icon;

public final class CheckIcon implements Icon {

    private static final int SIZE = 16;
    private static final Color ACCENT = new Color(0x78D4C4);
    private static final Color SURFACE = new Color(0x34393F);
    private static final Color OUTLINE = new Color(0x68737D);
    private static final Color CHECKMARK = new Color(0x20282B);

    private final boolean selected;

    public CheckIcon(boolean selected) {
        this.selected = selected;
    }

    /* -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= Main functions -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- */

    @Override
    public void paintIcon(Component component, Graphics graphics, int x, int y) {
        Graphics2D g2 = (Graphics2D) graphics.create();
        try {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setStroke(new BasicStroke(1.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
            if (selected) {
                g2.setColor(ACCENT);
                g2.fillRoundRect(x + 1, y + 1, SIZE - 2, SIZE - 2, 4, 4);
                g2.setColor(CHECKMARK);
                g2.drawLine(x + 4, y + 8, x + 7, y + 11);
                g2.drawLine(x + 7, y + 11, x + 12, y + 5);
            } else {
                g2.setColor(SURFACE);
                g2.fillRoundRect(x + 1, y + 1, SIZE - 2, SIZE - 2, 4, 4);
                g2.setColor(OUTLINE);
                g2.drawRoundRect(x + 1, y + 1, SIZE - 3, SIZE - 3, 4, 4);
            }
        } finally {
            g2.dispose();
        }
    }

    /* -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= Getters -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= */

    @Override
    public int getIconWidth() {
        return SIZE;
    }

    @Override
    public int getIconHeight() {
        return SIZE;
    }

}
