import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class fadeScreen {
	waitPanel wP = new waitPanel();
	public void fadeEffect(JFrame frame, JPanel backgr) {
		JPanel fPanel = new JPanel();
		fPanel.setBackground(new Color(0, 0, 0, 0));

		JLayeredPane layeredPane = frame.getRootPane().getLayeredPane();
		layeredPane.add(fPanel, JLayeredPane.PALETTE_LAYER);
		fPanel.setBounds(30, 0, frame.getWidth(), frame.getHeight());
		fPanel.setVisible(false);

		int targetAlpha = 255;
		int step = 1;
		int animationDelay = 5;

		Timer timer = new Timer(animationDelay, null);
		timer.addActionListener(new ActionListener() {
			private int availableAlpha = 0;
			@Override
			public void actionPerformed(ActionEvent e) {
				availableAlpha += step;
				fPanel.setVisible(true);
				if (availableAlpha >= targetAlpha) {
					availableAlpha = targetAlpha;
					fPanel.setVisible(false);
					backgr.removeAll();
					wP.openPanel(frame);
					timer.stop();
					
				}
				fPanel.setBackground(new Color(0, 0, 0, availableAlpha));
				layeredPane.revalidate();
				layeredPane.repaint();
			}
		});
		timer.start();
	}
}
