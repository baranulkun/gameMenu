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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class createAccount {
	timeOperations tmO = new timeOperations();
	gui gui = new gui();
	scrollingScreens sL = new scrollingScreens();
	
	public void create(JPanel backPanel, JFrame gameFrame) {
		JPanel createPanel = new JPanel(null);
		sL.startAnimationLeft(createPanel);
		backPanel.add(createPanel);
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

		JLabel playerPP = new JLabel("Password Repeat: ");
		playerPP.setFont(font);
		playerPP.setBounds(20, 160, 120, 20);
		playerPP.setForeground(Color.black);
		playerPP.setHorizontalAlignment(SwingConstants.LEFT);

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

		JTextField playerPT = new JTextField();
		playerPT.setOpaque(false);
		playerPT.setForeground(Color.black);
		playerPT.setBorder(border);
		playerPT.setBounds(160, 120, 100, 20);

		JTextField playerPPT = new JTextField();
		playerPPT.setOpaque(false);
		playerPPT.setForeground(Color.black);
		playerPPT.setBorder(border);
		playerPPT.setBounds(160, 160, 100, 20);

		JButton createButton = new JButton("Create");
		createButton.setBounds(190, 200, 70, 20);
		createButton.setBorder(null);
		createButton.setBackground(Color.black);
		createButton.setForeground(Color.red);
		createButton.setFocusPainted(false);
		
		JButton backButton = new JButton("Back");
		backButton.setBounds(20, 200, 70, 20);
		backButton.setBorder(null);
		backButton.setBackground(Color.black);
		backButton.setForeground(Color.red);
		backButton.setFocusPainted(false);

		//registering the user in MYSQL
		/*createButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (playerNT.getText().length() <= 1 || playerPPT.getText().length() <= 1
							|| playerPT.getText().length() <= 1 || playerST.getText().length() <= 1) {
						createMsgPanel(backPanel, gameFrame, "Fill in all fields");
						playerNT.setText("");
						playerPPT.setText("");
						playerPT.setText("");
						playerST.setText("");
					} else if (check(playerNT.getText(), playerST.getText())) {
						createMsgPanel(backPanel, gameFrame, "Has been used");
						playerNT.setText("");
						playerPPT.setText("");
						playerPT.setText("");
						playerST.setText("");
					} else if (!playerPT.getText().equals(playerPPT.getText())) {
						createMsgPanel(backPanel, gameFrame, "Match error");
						playerNT.setText("");
						playerPPT.setText("");
						playerPT.setText("");
						playerST.setText("");
					} else {
						createAccount(playerNT.getText(), playerST.getText(), playerPT.getText());
						createMsgPanel(backPanel, gameFrame, "Account created successfully");
						sL.startAnimationRight(createPanel);
						gui.setClick(true);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}*/

			// Registration to mySql
			/*private void createAccount(String name, String lName, String passw) throws SQLException {
				Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/metelanddata",
						"root", "1234");
				java.sql.Statement stmt = conn.createStatement();
				String addPlayer = "INSERT INTO players (id,name,surname,passw,crtDate) VALUES (" + turdId() + ",'"
						+ name + "','" + lName + "'," + "'" + passw + "','" + tmO.now() + "')";
				System.out.println(addPlayer);
				stmt.executeUpdate(addPlayer);
			}
		});*/
		
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gui.setClick(true);
				sL.startAnimationRight(createPanel);
			}
		});

		createPanel.setOpaque(false);
		createPanel.add(playerNT);
		createPanel.add(playerST);
		createPanel.add(playerPT);
		createPanel.add(playerPPT);
		createPanel.add(playerS);
		createPanel.add(playerN);
		createPanel.add(playerP);
		createPanel.add(playerPP);
		createPanel.add(createButton);
		createPanel.add(backButton);
	}

	// is this user available
	/*private boolean check(String name, String sName) throws SQLException {
		Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/metelanddata", "root",
				"1234");
		java.sql.Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM players");
		boolean isUse = false;
		while (rs.next()) {
			if (name.equals(rs.getString("name")) && sName.equals(rs.getString("surname")))
				isUse = true;
		}
		return isUse;
	}*/
	
	//finding next id
	/*private int turdId() throws SQLException {
		Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/metelanddata", "root",
				"1234");
		java.sql.Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM players");
		int bigId = 0, flag;
		while (rs.next()) {
			flag = rs.getInt("id");
			if (flag > bigId)
				bigId = flag;
		}
		return bigId+1;
	}*/

	// returns various messages
	public void createMsgPanel(JPanel backPanel, JFrame gameFrame, String msg) {
		JPanel errorPanel = new JPanel();
		errorPanel.setOpaque(false);
		backPanel.add(errorPanel);
		gameFrame.setContentPane(backPanel);

		Font font = new Font("Times New Roman", Font.PLAIN, 14);
		JLabel errorMsg = new JLabel(msg);
		errorMsg.setFont(font);
		errorMsg.setForeground(Color.black);
		errorMsg.setBounds(0, 0, 200, 70);
		errorMsg.setHorizontalAlignment(SwingConstants.LEFT);
		sL.msg(errorPanel);

		errorPanel.add(errorMsg);

	}
}
