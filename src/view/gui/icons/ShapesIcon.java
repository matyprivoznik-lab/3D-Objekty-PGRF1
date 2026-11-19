package view.gui.icons;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.Icon;

public final class ShapesIcon implements Icon {

    private static final int SIZE = 16;
    private static final Color ACCENT = new Color(0x78D4C4);

    @Override
    public void paintIcon(Component component, Graphics graphics, int x, int y) {
        Graphics2D g2 = (Graphics2D) graphics.create();
        try {
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(ACCENT);
            g2.setStroke(new BasicStroke(1.5f));
            g2.drawRect(x + 1, y + 6, 6, 6);
            g2.drawOval(x + 8, y + 2, 6, 6);
            g2.drawLine(x + 8, y + 14, x + 11, y + 9);
            g2.drawLine(x + 11, y + 9, x + 14, y + 14);
            g2.drawLine(x + 14, y + 14, x + 8, y + 14);
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
