import java.util.TimerTask;
import javax.swing.JPanel;

public class scrollingScreens {

	private static int menuPos;
	private static int createPos = 1550;
	private static final int PANEL_POS_STEP = -5;
	private static final int ANIMATION_DELAY = 5;
	private static int delay = 0;
	private static boolean cont;

	public void startAnimationGo(JPanel panel, boolean control) {
		menuPos = 50;
		cont = control;
		java.util.Timer timer = new java.util.Timer();
		TimerTask animationTask = new TimerTask() {
			@Override
			public void run() {
				if (cont == true) {
					menuPos += PANEL_POS_STEP;
					panel.setBounds(menuPos, 170, 500, 250);
					panel.repaint();

					if (menuPos <= -550) {
						cont = false;
					}
				} else {
					menuPos += -PANEL_POS_STEP;
					panel.setBounds(menuPos, 170, 500, 250);
					panel.repaint();

					if (menuPos >= 50) {
						timer.cancel();
					}
				}
			}
		};
		timer.scheduleAtFixedRate(animationTask, ANIMATION_DELAY, ANIMATION_DELAY);
	}

	public void startAnimationLeft(JPanel panel) {
		java.util.Timer timer = new java.util.Timer();
		TimerTask animationTask = new TimerTask() {
			@Override
			public void run() {
				createPos += PANEL_POS_STEP;
				panel.setBounds(createPos, 200, 500, 250);
				panel.repaint();

				if (createPos <= 1000) {
					timer.cancel();
				}
			}
		};
		timer.scheduleAtFixedRate(animationTask, ANIMATION_DELAY, ANIMATION_DELAY);
	}

	public void startAnimationRight(JPanel panel) {
		createPos = 1000;
		java.util.Timer timer = new java.util.Timer();
		TimerTask animationTask = new TimerTask() {
			@Override
			public void run() {
				createPos += -PANEL_POS_STEP;
				panel.setBounds(createPos, 200, 500, 250);
				panel.repaint();

				if (createPos >= 1550) {
					timer.cancel();
				}
			}
		};
		timer.scheduleAtFixedRate(animationTask, ANIMATION_DELAY, ANIMATION_DELAY);
	}

	public void msg(JPanel panel) {
		cont = true;
		menuPos = 1550;
		delay = 0;
		java.util.Timer timer = new java.util.Timer();
		TimerTask animationTask = new TimerTask() {
			@Override
			public void run() {
				if (cont == true) {
					menuPos += PANEL_POS_STEP;
					panel.setBounds(menuPos, 450, 200, 70);
					panel.repaint();

					if (menuPos <= 1173) {
						cont = false;
					}
				} else if (menuPos <= 1173 && delay < 800) {
					panel.setBounds(menuPos, 450, 200, 70);
					panel.repaint();
					delay += 5;
				} else {
					menuPos += -PANEL_POS_STEP;
					panel.setBounds(menuPos, 450, 200, 70);
					panel.repaint();

					if (menuPos >= 1550) {
						timer.cancel();
					}
				}
			}
		};
		timer.scheduleAtFixedRate(animationTask, ANIMATION_DELAY, ANIMATION_DELAY);
	}
}
