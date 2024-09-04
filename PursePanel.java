import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PursePanel extends JPanel {
    private Purse purse = new Purse();

    public void setPurse(Purse purse) {
        this.purse = purse;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int y = 20;
        for (Map.Entry<Denomination, Integer> entry : purse.cash.entrySet()) {
            Denomination denom = entry.getKey();
            int count = entry.getValue();
            String text = String.format("%d x %s ($%.2f each)", count, denom.name(), denom.amt());
            g2d.drawString(text, 10, y);
            y += 20;
        }
    }
}
