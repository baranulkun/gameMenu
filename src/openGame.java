import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class openGame {
	scrollingScreens sL = new scrollingScreens();
	createAccount cr = new createAccount();
	fadeScreen fD = new fadeScreen();
	gui gui = new gui();
	
	public void signIn(JPanel backPanel, JFrame gameFrame, JPanel menuPanel, JLabel header) {
		JPanel signPanel = new JPanel(null);
		sL.startAnimationLeft(signPanel);
		backPanel.add(signPanel);
		gameFrame.setContentPane(backPanel);

		Font font = new Font("Times New Roman", Font.PLAIN, 14);
		Border border = BorderFactory.createLineBorder(Color.black);

		JLabel playerN = new JLabel("Player Name: ");
		playerN.setFont(font);
		playerN.setBounds(20, 40, 120, 20);
		playerN.setForeground(Color.black);
		playerN.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel playerS = new JLabel("Player Last Name: ");
		playerS.setFont(font);
		playerS.setBounds(20, 80, 120, 20);
		playerS.setForeground(Color.black);
		playerS.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel playerP = new JLabel("Player Password: ");
		playerP.setFont(font);
		playerP.setBounds(20, 120, 120, 20);
		playerP.setForeground(Color.black);
		playerP.setHorizontalAlignment(SwingConstants.LEFT);

		JTextField playerNT = new JTextField();
		playerNT.setOpaque(false);
		playerNT.setForeground(Color.black);
		playerNT.setBorder(border);
		playerNT.setBounds(160, 40, 100, 20);

		JTextField playerST = new JTextField();
		playerST.setOpaque(false);
		playerST.setForeground(Color.black);
		playerST.setBorder(border);
		playerST.setBounds(160, 80, 100, 20);

		JPasswordField playerPT = new JPasswordField();
		playerPT.setOpaque(false);
		playerPT.setForeground(Color.black);
		playerPT.setBorder(border);
		playerPT.setBounds(160, 120, 100, 20);

		JButton signButton = new JButton("Sign in");
		signButton.setBounds(190, 170, 70, 20);
		signButton.setBorder(null);
		signButton.setBackground(Color.black);
		signButton.setForeground(Color.red);
		signButton.setFocusPainted(false);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(20, 170, 70, 20);
		backButton.setBorder(null);
		backButton.setBackground(Color.black);
		backButton.setForeground(Color.red);
		backButton.setFocusPainted(false);
		//user login using MYSQL
		/*signButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				if (playerNT.getText().length() < 1 || playerST.getText().length() < 1
						|| playerPT.getText().length() < 1) {
					cr.createMsgPanel(backPanel, gameFrame, "Fill in all fields");
					playerNT.setText("");
					playerST.setText("");
					playerPT.setText("");
				} else {
					try {
						int id = check(playerNT.getText(), playerST.getText(), playerPT.getText());
						if (id != 0) {
							fD.fadeEffect(gameFrame, backPanel);
						}
						else {
							cr.createMsgPanel(backPanel, gameFrame, "Incorrect name or password");
							playerNT.setText("");
							playerST.setText("");
							playerPT.setText("");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});*/

		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.setClick(true);
				sL.startAnimationRight(signPanel);
			}
		});

		signPanel.setOpaque(false);
		signPanel.add(playerPT);
		signPanel.add(playerST);
		signPanel.add(playerNT);
		signPanel.add(playerP);
		signPanel.add(playerS);
		signPanel.add(playerN);
		signPanel.add(signButton);
		signPanel.add(backButton);
	}

	// password-name check
	/*private int check(String name, String sName, String passw) throws SQLException {
		Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/metelanddata", "root",
				"1234");
		java.sql.Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM players");
		int whoIs = 0;
		while (rs.next()) {
			if (name.equals(rs.getString("name")) && sName.equals(rs.getString("surname"))
					&& passw.equals(rs.getString("passw")))
				whoIs = rs.getInt("id");
		}
		return whoIs;
	}*/

}
