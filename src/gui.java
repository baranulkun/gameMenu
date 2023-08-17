import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class gui {

	static scrollingScreens mn = new scrollingScreens();
	static openGame oG = new openGame();
	private static boolean isCanClick = true;

	public void createGamePanel() {
		SwingUtilities.invokeLater(() -> GamePanel());
	}

	public void setClick(boolean isCanClick) {
		this.isCanClick = isCanClick;
	}

	public static void GamePanel() {
		JFrame gameFrame = new JFrame("Metaland");
		gameFrame.setBounds(-3, -3, 1539, 870);
		gameFrame.setUndecorated(true);
		gameFrame.setVisible(true);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setBackground(Color.red);

		JPanel menuBackGr = new JPanel(null) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				try {
					Image backGroundImg = (new ImageIcon(gui.class.getResource("/red.png")).getImage());
					g.drawImage(backGroundImg, 0, 0, getWidth() + 4, getHeight(), null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		JPanel menuPanel = new JPanel(null) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.black);
				g.fillRect(0, 0, getWidth(), getHeight());
			}
		};

		menuPanel.setBounds(50, 170, 500, 250);
		menuBackGr.add(menuPanel);
		gameFrame.setContentPane(menuBackGr);

		Font gotikFont = new Font("Old English Text MT", Font.PLAIN, 84);
		final Font fontByUse = new Font("Old English Text MT", Font.PLAIN, 34);
		final Font fontByTurn = new Font("Old English Text MT", Font.PLAIN, 30);

		JLabel gameName = new JLabel("Metaland", JLabel.CENTER);
		gameName.setFont(gotikFont);
		gameName.setBounds(50, 70, 350, 100);
		gameName.setForeground(new Color(255, 60, 60));
		gameName.setHorizontalAlignment(SwingConstants.LEFT);
		menuBackGr.add(gameName);

		gotikFont = gotikFont.deriveFont(30f);
		JLabel exitLabel = new JLabel("E X I T", JLabel.CENTER);
		exitLabel.setFont(gotikFont);
		exitLabel.setBounds(0, 160, 200, 100);
		exitLabel.setForeground(new Color(255, 60, 60));
		exitLabel.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel playerLabel = new JLabel("P L A Y E R", JLabel.CENTER);
		playerLabel.setFont(gotikFont);
		playerLabel.setBounds(0, 100, 240, 100);
		playerLabel.setForeground(new Color(255, 60, 60));
		playerLabel.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel adminLabel = new JLabel("A D M I N", JLabel.CENTER);
		adminLabel.setFont(gotikFont);
		adminLabel.setBounds(0, 40, 200, 100);
		adminLabel.setForeground(new Color(255, 60, 60));
		adminLabel.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel playGame = new JLabel("P L A Y", JLabel.CENTER);
		playGame.setFont(gotikFont);
		playGame.setBounds(0, 40, 200, 100);
		playGame.setForeground(new Color(255, 60, 60));
		playGame.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel createAccount = new JLabel("C R E A T E  A C C O U N T", JLabel.CENTER);
		createAccount.setFont(gotikFont);
		createAccount.setBounds(0, 100, 500, 100);
		createAccount.setForeground(new Color(255, 60, 60));
		createAccount.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel turnBack = new JLabel("B A C K", JLabel.CENTER);
		turnBack.setFont(gotikFont);
		turnBack.setBounds(0, 160, 200, 100);
		turnBack.setForeground(new Color(255, 60, 60));
		turnBack.setHorizontalAlignment(SwingConstants.LEFT);

		playGame.setVisible(false);
		createAccount.setVisible(false);
		turnBack.setVisible(false);

			adminLabel.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					Map<TextAttribute, Object> attributes = new HashMap<>(fontByUse.getAttributes());
					attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
					Font altiCiziliFont = fontByUse.deriveFont(attributes);
					adminLabel.setFont(altiCiziliFont);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					adminLabel.setFont(fontByTurn);
				}

				@Override
				public void mouseClicked(MouseEvent e) {
				}
			});

			playerLabel.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					Map<TextAttribute, Object> attributes = new HashMap<>(fontByUse.getAttributes());
					attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
					Font altiCiziliFont = fontByUse.deriveFont(attributes);
					playerLabel.setFont(altiCiziliFont);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					playerLabel.setFont(fontByTurn);
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					playGame.setVisible(true);
					createAccount.setVisible(true);
					turnBack.setVisible(true);
					mn.startAnimationGo(menuPanel, true);
					adminLabel.setVisible(false);
					playerLabel.setVisible(false);
					exitLabel.setVisible(false);
				}
			});
			exitLabel.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					Map<TextAttribute, Object> attributes = new HashMap<>(fontByUse.getAttributes());
					attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
					Font altiCiziliFont = fontByUse.deriveFont(attributes);
					exitLabel.setFont(altiCiziliFont);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					exitLabel.setFont(fontByTurn);
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					System.exit(0);
				}
			});
			playGame.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					if (isCanClick) {
						Map<TextAttribute, Object> attributes = new HashMap<>(fontByUse.getAttributes());
						attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
						Font altiCiziliFont = fontByUse.deriveFont(attributes);
						playGame.setFont(altiCiziliFont);
					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					playGame.setFont(fontByTurn);
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					if (isCanClick) {
						isCanClick=false;
						oG.signIn(menuBackGr, gameFrame, menuPanel, gameName);
					}
				}
			});
			createAccount.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					if (isCanClick) {
						Map<TextAttribute, Object> attributes = new HashMap<>(fontByUse.getAttributes());
						attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
						Font altiCiziliFont = fontByUse.deriveFont(attributes);
						createAccount.setFont(altiCiziliFont);
					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					createAccount.setFont(fontByTurn);
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					if (isCanClick) {
						isCanClick=false;
						createAccount cr = new createAccount();
						cr.create(menuBackGr, gameFrame);
					}

				}
			});
			turnBack.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent e) {
					if (isCanClick) {
						Map<TextAttribute, Object> attributes = new HashMap<>(fontByUse.getAttributes());
						attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
						Font altiCiziliFont = fontByUse.deriveFont(attributes);
						turnBack.setFont(altiCiziliFont);
					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					turnBack.setFont(fontByTurn);
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					if (isCanClick) {
						playGame.setVisible(false);
						createAccount.setVisible(false);
						turnBack.setVisible(false);
						mn.startAnimationGo(menuPanel, true);
						playerLabel.setVisible(true);
						adminLabel.setVisible(true);
						exitLabel.setVisible(true);
					}
				}
			});
		
		menuPanel.add(exitLabel);
		menuPanel.add(playerLabel);
		menuPanel.add(adminLabel);
		menuPanel.add(playGame);
		menuPanel.add(createAccount);
		menuPanel.add(turnBack);
		gameFrame.setVisible(true);
	}
}
