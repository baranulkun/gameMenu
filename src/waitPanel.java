import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class waitPanel {

	private final int ANIMATION_DELAY=20;
	private final int PROG_MAX=150;
	private static int start=0;
	
	public void openPanel(JFrame frame) {
		JPanel backGr = new JPanel(null);

		JLayeredPane layeredPane = frame.getRootPane().getLayeredPane();
		layeredPane.add(backGr, JLayeredPane.PALETTE_LAYER);

		backGr.setBounds(-1, -1, 1550, 870);
		backGr.setBackground(Color.black);
		frame.add(backGr);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(0,850,1540,30);
		progressBar.setIndeterminate(false);
		progressBar.setForeground(Color.red);
		progressBar.setOpaque(false);
		progressBar.setBorderPainted(false);
		backGr.add(progressBar, BorderLayout.CENTER);
		
		JLabel load = new JLabel();
		load.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon imgYuk = new ImageIcon(this.getClass().getResource("/load2.gif"));
		Image gifImage = imgYuk.getImage();
		Image resizedImage = gifImage.getScaledInstance(50, 38, Image.SCALE_DEFAULT);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		load.setIcon(resizedIcon);
		backGr.add(load);

		java.util.Timer timer = new java.util.Timer();
		TimerTask animationTask = new TimerTask() {
			@Override
			public void run() {
					progressBar.setValue(start);
					start++;
					load.setBounds(10+(int)(start*15.2),825,50,50);
					if (start >= PROG_MAX) {
						backGr.setVisible(false);
						timer.cancel();
					}
			}
		};
		timer.scheduleAtFixedRate(animationTask, ANIMATION_DELAY, ANIMATION_DELAY);
	}

}
