import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangmanMainClass extends JFrame {

	public Boolean Match = false;
	public int ind;
	public Boolean Mistake = false;
	public int MistakeCount = 1;
	public String Buchstabe;
	public int n;

	public static void main(String[] args) throws Exception {
		HangmanMainClass a = new HangmanMainClass();

	}

	public HangmanMainClass() throws Exception {
		// ersstellen des Frames und des Panels
// Schleife falls am Ende erneut spielen ausgew�hlt wird
		Boolean spielen = true;

		while (spielen) {
			// erstellen eines Frames
			JFrame frame = new JFrame();
//erstellen eines Panels und hinzuf�gen zum Frame
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			frame.add(panel);
			// erstellen des LayoutManagers
			GridBagConstraints gbc = new GridBagConstraints();
			frame.setTitle("Hangman");
			GridBagLayout layout = new GridBagLayout();
//Layout von Panel festgelegt
			panel.setLayout(layout);
// errechnen einer zuf�lligen Zahl, um zuf�lliges Wort auszuw�hlen
			Random rand = new Random();
			n = rand.nextInt(360);
			n += 1;

			// definieren der Buttons, sowie des ersten Bildes

			ImageIcon galgenStep1 = new ImageIcon(getClass().getClassLoader().getResource("Hangaman/w1.png"));

			Button A_Button = new Button("A");

			Button B_Button = new Button("B");

			Button C_Button = new Button("C");

			Button D_Button = new Button("D");

			Button E_Button = new Button("E");

			Button F_Button = new Button("F");

			Button G_Button = new Button("G");

			Button H_Button = new Button("H");

			Button I_Button = new Button("I");

			Button J_Button = new Button("J");

			Button K_Button = new Button("K");

			Button L_Button = new Button("L");

			Button M_Button = new Button("M");

			Button N_Button = new Button("N");

			Button O_Button = new Button("O");

			Button P_Button = new Button("P");

			Button Q_Button = new Button("Q");

			Button R_Button = new Button("R");

			Button S_Button = new Button("S");

			Button T_Button = new Button("T");

			Button U_Button = new Button("U");

			Button V_Button = new Button("V");

			Button W_Button = new Button("W");

			Button X_Button = new Button("X");

			Button Y_Button = new Button("Y");

			Button Z_Button = new Button("Z");
			// festlegen des Y-Wertes
			int yAlignment = 7;

			// erstellen einer Anzeige f�r Highscore
			JMenuBar menuBar = new JMenuBar();
			menuBar.add(new JMenu(" Highscore: " + getHighscore()));
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.anchor = GridBagConstraints.NORTH;
			gbc.gridwidth = 10;
			gbc.weighty = 1;
			panel.add((menuBar), gbc);
			gbc.gridwidth = 1;
			gbc.weighty = 0;

			// Hinzuf�gen der Unterstriche f�r jeden Buchstaben des Worts
			int in = 0;
			for (int i = 0; i < WordStrings(n); i++) {
				if (i < 10) {

					gbc.gridx = i;
					gbc.gridy = yAlignment;
					gbc.weightx = 1;
					JLabel name = new JLabel(
							new ImageIcon(getClass().getClassLoader().getResource("Hangaman/strich.png")));
					panel.add(name, gbc);
					gbc.weightx = 0;
				} else {
					gbc.gridx = in;
					gbc.gridy = yAlignment + 1;
					panel.add(new JLabel(new ImageIcon(getClass().getClassLoader().getResource("Hangaman/strich.png"))),
							gbc);
					in++;
				}
			}
			// hinzuf�gen des ersten Bildes
			gbc.fill = GridBagConstraints.HORIZONTAL;
			gbc.gridx = 0;
			gbc.gridy = 1;
			gbc.gridwidth = 10;
			panel.add(new JLabel(galgenStep1), gbc);
			gbc.gridwidth = 1;

			// hinzuf�gen der Buttons
			gbc.weightx = 1;
			gbc.gridx = 0;
			gbc.gridy = yAlignment + 4;
			panel.add(A_Button, gbc);
			gbc.weightx = 1;
			gbc.gridx = 1;
			gbc.gridy = yAlignment + 4;
			panel.add(B_Button, gbc);
			gbc.weightx = 1;
			gbc.gridx = 2;
			gbc.gridy = yAlignment + 4;
			panel.add(C_Button, gbc);
			gbc.weightx = 1;
			gbc.gridx = 3;
			gbc.gridy = yAlignment + 4;
			panel.add(D_Button, gbc);
			gbc.weightx = 1;
			gbc.gridx = 4;
			gbc.gridy = yAlignment + 4;
			panel.add(E_Button, gbc);
			gbc.weightx = 1;
			gbc.gridx = 5;
			gbc.gridy = yAlignment + 4;
			panel.add(F_Button, gbc);
			gbc.weightx = 1;
			gbc.gridx = 6;
			gbc.gridy = yAlignment + 4;
			panel.add(G_Button, gbc);
			gbc.weightx = 1;
			gbc.gridx = 7;
			gbc.gridy = yAlignment + 4;
			panel.add(H_Button, gbc);
			gbc.weightx = 1;
			gbc.gridx = 8;
			gbc.gridy = yAlignment + 4;
			panel.add(I_Button, gbc);
			gbc.weightx = 1;
			gbc.gridx = 9;
			gbc.gridy = yAlignment + 4;
			panel.add(J_Button, gbc);

			gbc.weightx = 1;
			gbc.gridx = 0;
			gbc.gridy = yAlignment + 5;
			panel.add(K_Button, gbc);
			gbc.weightx = 1;
			gbc.gridx = 1;
			gbc.gridy = yAlignment + 5;
			panel.add(L_Button, gbc);
			gbc.weightx = 1;
			gbc.gridx = 2;
			gbc.gridy = yAlignment + 5;
			panel.add(M_Button, gbc);
			gbc.weightx = 1;
			gbc.gridx = 3;
			gbc.gridy = yAlignment + 5;
			panel.add(N_Button, gbc);
			gbc.weightx = 1;
			gbc.gridx = 4;
			gbc.gridy = yAlignment + 5;
			panel.add(O_Button, gbc);
			gbc.weightx = 1;
			gbc.gridx = 5;
			gbc.gridy = yAlignment + 5;
			panel.add(P_Button, gbc);
			gbc.weightx = 1;
			gbc.gridx = 6;
			gbc.gridy = yAlignment + 5;
			panel.add(Q_Button, gbc);
			gbc.weightx = 1;
			gbc.gridx = 7;
			gbc.gridy = yAlignment + 5;
			panel.add(R_Button, gbc);
			gbc.weightx = 1;
			gbc.gridx = 8;
			gbc.gridy = yAlignment + 5;
			panel.add(S_Button, gbc);
			gbc.weightx = 1;
			gbc.gridx = 9;
			gbc.gridy = yAlignment + 5;
			panel.add(T_Button, gbc);
			gbc.weightx = 1;
			gbc.gridx = 2;
			gbc.gridy = yAlignment + 6;
			panel.add(U_Button, gbc);
			gbc.weightx = 1;
			gbc.gridx = 3;
			gbc.gridy = yAlignment + 6;
			panel.add(V_Button, gbc);
			gbc.weightx = 1;
			gbc.gridx = 4;
			gbc.gridy = yAlignment + 6;
			panel.add(W_Button, gbc);
			gbc.weightx = 1;
			gbc.gridx = 5;
			gbc.gridy = yAlignment + 6;
			panel.add(X_Button, gbc);
			gbc.weightx = 1;
			gbc.gridx = 6;
			gbc.gridy = yAlignment + 6;
			panel.add(Y_Button, gbc);
			gbc.weightx = 1;
			gbc.gridx = 7;
			gbc.gridy = yAlignment + 6;
			panel.add(Z_Button, gbc);

// erstellen einer Liste mit allen Labels des Panels
			ArrayList<Component> component = new ArrayList();
			Component[] components = panel.getComponents();
			for (int z = 0; z < components.length; z++) {
				// schauen ob die Komponente ein Label ist
				if (components[z] instanceof JLabel) {
					// falls ein Label gefunden wurde, hinzuf�gen zu Liste
					component.add(components[z]);
				}

			}
// hinzuf�gen der Funktion der Buttons
			A_Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int MatchCount = 0;
					// Button wird deaktiviert
					A_Button.setEnabled(false);
					// Buchtsaben des Wortes werden mit angeklickten Buchstaben verglichen
					try {
						for (int i = 0; i < WordStrings(n); i++) {
							if (LetterArray(n)[i].matches("[A,a]")) {
								// Treffer
								setIndex(i);
								String a = "A";
								setBuchstabe(a);
								setMatch(true);
								MatchCount++;
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (MatchCount == 0) {
						// kein Treffer
						setMistakeCount(getMistakeCount() + 1);
						setMistake(true);
					}
				}
			});
			B_Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int MatchCount = 0;
					B_Button.setEnabled(false);
					try {
						for (int i = 0; i < WordStrings(n); i++) {
							if (LetterArray(n)[i].matches("[B,b]")) {
								setIndex(i);

								String b = "b";
								setBuchstabe(b);
								setMatch(true);
								MatchCount++;
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (MatchCount == 0) {
						setMistakeCount(getMistakeCount() + 1);
						setMistake(true);
					}
				}
			});
			V_Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int MatchCount = 0;
					V_Button.setEnabled(false);
					try {
						for (int i = 0; i < WordStrings(n); i++) {
							if (LetterArray(n)[i].matches("[V,v]")) {
								setIndex(i);

								String v = "v";
								setBuchstabe(v);
								setMatch(true);
								MatchCount++;
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (MatchCount == 0) {
						setMistakeCount(getMistakeCount() + 1);
						setMistake(true);
					}

				}
			});
			E_Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int MatchCount = 0;
					E_Button.setEnabled(false);
					try {
						for (int i = 0; i < WordStrings(n); i++) {
							if (LetterArray(n)[i].matches("[E,e]")) {
								setIndex(i);

								String ee = "E";
								setBuchstabe(ee);
								setMatch(true);
								MatchCount++;
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (MatchCount == 0) {
						setMistakeCount(getMistakeCount() + 1);
						setMistake(true);
					}

				}
			});
			C_Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int MatchCount = 0;
					C_Button.setEnabled(false);
					try {
						for (int i = 0; i < WordStrings(n); i++) {
							if (LetterArray(n)[i].matches("[C,c]")) {
								setIndex(i);

								String a = "C";
								setBuchstabe(a);
								setMatch(true);
								MatchCount++;
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (MatchCount == 0) {
						setMistakeCount(getMistakeCount() + 1);
						setMistake(true);
					}
				}
			});
			D_Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int MatchCount = 0;
					D_Button.setEnabled(false);
					try {
						for (int i = 0; i < WordStrings(n); i++) {
							if (LetterArray(n)[i].matches("[D,d]")) {
								setIndex(i);

								String a = "D";
								setBuchstabe(a);
								setMatch(true);
								MatchCount++;
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (MatchCount == 0) {
						setMistakeCount(getMistakeCount() + 1);
						setMistake(true);
					}
				}
			});
			F_Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int MatchCount = 0;
					F_Button.setEnabled(false);
					try {
						for (int i = 0; i < WordStrings(n); i++) {
							if (LetterArray(n)[i].matches("[F,f]")) {
								setIndex(i);

								String a = "F";
								setBuchstabe(a);
								setMatch(true);
								MatchCount++;
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (MatchCount == 0) {
						setMistakeCount(getMistakeCount() + 1);
						setMistake(true);
					}
				}
			});
			G_Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int MatchCount = 0;
					G_Button.setEnabled(false);
					try {
						for (int i = 0; i < WordStrings(n); i++) {
							if (LetterArray(n)[i].matches("[G,g]")) {
								setIndex(i);

								String a = "G";
								setBuchstabe(a);
								setMatch(true);
								MatchCount++;
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (MatchCount == 0) {
						setMistakeCount(getMistakeCount() + 1);
						setMistake(true);
					}
				}
			});
			H_Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int MatchCount = 0;
					H_Button.setEnabled(false);
					try {
						for (int i = 0; i < WordStrings(n); i++) {
							if (LetterArray(n)[i].matches("[H,h]")) {
								setIndex(i);

								String a = "H";
								setBuchstabe(a);
								setMatch(true);
								MatchCount++;
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (MatchCount == 0) {
						setMistakeCount(getMistakeCount() + 1);
						setMistake(true);
					}
				}
			});
			I_Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int MatchCount = 0;
					I_Button.setEnabled(false);
					try {
						for (int i = 0; i < WordStrings(n); i++) {
							if (LetterArray(n)[i].matches("[I,i]")) {
								setIndex(i);

								String a = "I";
								setBuchstabe(a);
								setMatch(true);
								MatchCount++;
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (MatchCount == 0) {
						setMistakeCount(getMistakeCount() + 1);
						setMistake(true);
					}
				}
			});
			J_Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int MatchCount = 0;
					J_Button.setEnabled(false);
					try {
						for (int i = 0; i < WordStrings(n); i++) {
							if (LetterArray(n)[i].matches("[J,j]")) {
								setIndex(i);

								String a = "J";
								setBuchstabe(a);
								setMatch(true);
								MatchCount++;
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (MatchCount == 0) {
						setMistakeCount(getMistakeCount() + 1);
						setMistake(true);
					}
				}
			});
			K_Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int MatchCount = 0;
					K_Button.setEnabled(false);
					try {
						for (int i = 0; i < WordStrings(n); i++) {
							if (LetterArray(n)[i].matches("[K,k]")) {
								setIndex(i);

								String a = "K";
								setBuchstabe(a);
								setMatch(true);
								MatchCount++;
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (MatchCount == 0) {
						setMistakeCount(getMistakeCount() + 1);
						setMistake(true);
					}
				}
			});
			L_Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int MatchCount = 0;
					L_Button.setEnabled(false);
					try {
						for (int i = 0; i < WordStrings(n); i++) {
							if (LetterArray(n)[i].matches("[L,l]")) {
								setIndex(i);

								String a = "L";
								setBuchstabe(a);
								setMatch(true);
								MatchCount++;
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (MatchCount == 0) {
						setMistakeCount(getMistakeCount() + 1);
						setMistake(true);
					}
				}
			});
			M_Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int MatchCount = 0;
					M_Button.setEnabled(false);
					try {
						for (int i = 0; i < WordStrings(n); i++) {
							if (LetterArray(n)[i].matches("[M,m]")) {

								setIndex(i);
								String a = "M";
								setBuchstabe(a);
								setMatch(true);
								MatchCount++;
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (MatchCount == 0) {
						setMistakeCount(getMistakeCount() + 1);
						setMistake(true);
					}
				}
			});
			N_Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int MatchCount = 0;
					N_Button.setEnabled(false);
					try {
						for (int i = 0; i < WordStrings(n); i++) {
							if (LetterArray(n)[i].matches("[N,n]")) {

								setIndex(i);
								String a = "N";
								setBuchstabe(a);
								setMatch(true);
								MatchCount++;
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (MatchCount == 0) {
						setMistakeCount(getMistakeCount() + 1);
						setMistake(true);
					}
				}
			});
			O_Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int MatchCount = 0;
					O_Button.setEnabled(false);
					try {
						for (int i = 0; i < WordStrings(n); i++) {
							if (LetterArray(n)[i].matches("[O,o]")) {

								setIndex(i);
								String a = "O";
								setBuchstabe(a);
								setMatch(true);
								MatchCount++;
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (MatchCount == 0) {
						setMistakeCount(getMistakeCount() + 1);
						setMistake(true);
					}
				}
			});
			P_Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int MatchCount = 0;
					P_Button.setEnabled(false);
					try {
						for (int i = 0; i < WordStrings(n); i++) {
							if (LetterArray(n)[i].matches("[P,p]")) {

								setIndex(i);
								String a = "P";
								setBuchstabe(a);
								setMatch(true);
								MatchCount++;
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (MatchCount == 0) {
						setMistakeCount(getMistakeCount() + 1);
						setMistake(true);
					}
				}
			});
			Q_Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int MatchCount = 0;
					Q_Button.setEnabled(false);
					try {
						for (int i = 0; i < WordStrings(n); i++) {
							if (LetterArray(n)[i].matches("[Q,q]")) {

								setIndex(i);
								String a = "Q";
								setBuchstabe(a);
								setMatch(true);
								MatchCount++;
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (MatchCount == 0) {
						setMistakeCount(getMistakeCount() + 1);
						setMistake(true);
					}
				}
			});
			R_Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int MatchCount = 0;
					R_Button.setEnabled(false);
					try {
						for (int i = 0; i < WordStrings(n); i++) {
							if (LetterArray(n)[i].matches("[R,r]")) {

								setIndex(i);
								String a = "R";
								setBuchstabe(a);
								setMatch(true);
								MatchCount++;
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (MatchCount == 0) {
						setMistakeCount(getMistakeCount() + 1);
						setMistake(true);
					}
				}
			});
			S_Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int MatchCount = 0;
					S_Button.setEnabled(false);
					try {
						for (int i = 0; i < WordStrings(n); i++) {
							if (LetterArray(n)[i].matches("[S,s]")) {

								setIndex(i);
								String a = "S";
								setBuchstabe(a);
								setMatch(true);
								MatchCount++;
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (MatchCount == 0) {
						setMistakeCount(getMistakeCount() + 1);
						setMistake(true);
					}
				}
			});
			T_Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int MatchCount = 0;
					T_Button.setEnabled(false);
					try {
						for (int i = 0; i < WordStrings(n); i++) {
							if (LetterArray(n)[i].matches("[T,t]")) {

								setIndex(i);
								String a = "T";
								setBuchstabe(a);
								setMatch(true);
								MatchCount++;
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (MatchCount == 0) {
						setMistakeCount(getMistakeCount() + 1);
						setMistake(true);
					}
				}
			});
			U_Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int MatchCount = 0;
					U_Button.setEnabled(false);
					try {
						for (int i = 0; i < WordStrings(n); i++) {
							if (LetterArray(n)[i].matches("[U,u]")) {

								setIndex(i);
								String a = "U";
								setBuchstabe(a);
								setMatch(true);
								MatchCount++;
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (MatchCount == 0) {
						setMistakeCount(getMistakeCount() + 1);
						setMistake(true);
					}
				}
			});
			W_Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int MatchCount = 0;
					W_Button.setEnabled(false);
					try {
						for (int i = 0; i < WordStrings(n); i++) {
							if (LetterArray(n)[i].matches("[W,w]")) {
								setMatch(true);
								setIndex(i);
								String a = "W";
								setBuchstabe(a);
								MatchCount++;
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (MatchCount == 0) {
						setMistakeCount(getMistakeCount() + 1);
						setMistake(true);
					}
				}
			});
			X_Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int MatchCount = 0;
					X_Button.setEnabled(false);
					try {
						for (int i = 0; i < WordStrings(n); i++) {
							if (LetterArray(n)[i].matches("[X,x]")) {

								setIndex(i);
								String a = "X";
								setBuchstabe(a);
								setMatch(true);
								MatchCount++;
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (MatchCount == 0) {
						setMistakeCount(getMistakeCount() + 1);
						setMistake(true);
					}
				}
			});
			Y_Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int MatchCount = 0;
					Y_Button.setEnabled(false);
					try {
						for (int i = 0; i < WordStrings(n); i++) {
							if (LetterArray(n)[i].matches("[Y,y]")) {

								setIndex(i);
								String a = "Y";
								setBuchstabe(a);
								setMatch(true);
								MatchCount++;
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (MatchCount == 0) {
						setMistakeCount(getMistakeCount() + 1);
						setMistake(true);
					}
				}
			});
			Z_Button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int MatchCount = 0;
					Z_Button.setEnabled(false);
					try {
						for (int i = 0; i < WordStrings(n); i++) {
							if (LetterArray(n)[i].matches("[Z,z]")) {

								setIndex(i);
								String a = "Z";
								setBuchstabe(a);
								setMatch(true);
								MatchCount++;
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
							}
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					if (MatchCount == 0) {
						setMistakeCount(getMistakeCount() + 1);
						setMistake(true);
					}
				}
			});

// Gr��e des Fensters, Sichtbarkeit bestimmen
			if (WordStrings(n) > 10) {
				frame.setSize(516, 501);
			} else {
				frame.setSize(516, 468);

			}
			frame.setResizable(false);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

			int TrefferCount = 0;
			int running = 0;
			// Schleife l�uft im Hintergrund um zu erkennen ob es ein Treffer oder einen
			// Fehler gab
			while (running == 0) {
				if (getMistake()) {
					// falls kein Treffer vorliegt wird Bild mit Fortschritt des Galgen eingeblendet
					panel.remove(component.get(component.size() - 1));
					gbc.gridx = 0;
					gbc.gridy = 1;
					gbc.gridwidth = 10;
					panel.add(new JLabel(new ImageIcon(
							getClass().getClassLoader().getResource("Hangaman/w" + getMistakeCount() + ".png"))), gbc);
					panel.revalidate();
					gbc.gridwidth = 1;
					setMistake(false);
					components = panel.getComponents();
					// hinzuf�gen des neuen Labels zum Array um sp�ter wieder zugreifen zu k�nnen
					for (int z = 0; z < components.length; z++) {
						if (components[z] instanceof JLabel) {
							component.add(components[z]);
						}
					}
					if (getMistakeCount() == 10) {
						// beenden des Spiels falls es zu viele Fehler gab
						// �ffnen eines Dialogfensters
						String t = "<html>Verloren! <br/>Das Wort lautet: " + Word(n) + "<br/> Erneut spielen?</html>";
						int weiter = JOptionPane.showOptionDialog(null, t, "Verloren", JOptionPane.YES_NO_OPTION,
								JOptionPane.INFORMATION_MESSAGE, null, new String[] { "Ja", "Nein" }, "Ja");
						if (weiter == JOptionPane.YES_OPTION) {
							panel.removeAll();
							setMistakeCount(1);
							setMatch(false);
							frame.dispose();
							break;
						}
						if (weiter == JOptionPane.NO_OPTION) {
							// beenden falls nein ausgew�hlt wurde
							frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
						}
					}

				}
// schauen ob es ein Match gab
				if (getMatch()) {
					// entfernen des Platzhalters

					panel.remove(component.get(getIndex()));

					if (getIndex() < 10) {
						gbc.gridx = getIndex();
						gbc.gridy = yAlignment;
					} else {
						gbc.gridx = getIndex() - 10;
						gbc.gridy = yAlignment + 1;
					}

					// hinzuf�gen des neuen Buchstaben
					panel.add(new JLabel(new ImageIcon(
							getClass().getClassLoader().getResource("Hangaman/Buchstaben/" + getBuchstabe() + ".png"))),
							gbc);
					// GUI neu laden
					panel.revalidate();
					TrefferCount++;

					if (TrefferCount == WordStrings(n)) {
						// falls alle Buchstaben erraten wurden �ffnen eines Dialogfensters
						int score = WordStrings(n) * 10 / (getMistakeCount()) * 10;
						if (score > getHighscore()) {
							setNewHighscore(score);
						}
						String t = "<html>Gratuliere! Du hast gewonnen!<br/>Das Wort lautet: " + Word(n)
								+ "<br/> Dein Score: " + score + "<br/> Erneut spielen?</html>";

						int weiter = JOptionPane.showOptionDialog(null, t, "Gewonnen", JOptionPane.YES_NO_OPTION,
								JOptionPane.INFORMATION_MESSAGE, null, new String[] { "Ja", "Nein" }, "Ja");
						if (weiter == JOptionPane.YES_OPTION) {
							Thread.sleep(100);
							panel.removeAll();
							setMistakeCount(1);
							setMatch(false);
							frame.dispose();
							break;
						}
						if (weiter == JOptionPane.NO_OPTION) {
							frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
						}
					}
					setMatch(false);

				} else {
					Thread.sleep(0);
				}
			}
		}
	}

// einstellen des Highscores
	public void setNewHighscore(int score) throws Exception {
		String path = System.getProperty("user.home") + File.separator + "Hangman" + File.separator + "score.txt";
		File newFile = new File(path);
		if (!newFile.exists()) {
			// erstelllen eines neuen Files, indem der sscore gespeichert wird
			newFile.getParentFile().mkdirs();
			newFile.createNewFile();
		}
		// eintragen des scores in Datei
		BufferedWriter writer = new BufferedWriter(new FileWriter(path));
		writer.write(new Integer(score).toString());
		writer.close();
	}

//Highscore abfragen
	public int getHighscore() throws Exception {
		int Highscore;
		String path = System.getProperty("user.home") + File.separator + "Hangman" + File.separator + "score.txt";
		File scoreFile = new File(path);
		if (!scoreFile.exists()) {
			// Highscore auf 0 gesetzt
			// falls das Programm erstmalig ausgef�hrt wird oder der score File gel�scht
			// wurde
			Highscore = 0;
			return Highscore;
		} else {
			// falls vorhanden auslesen des Highscores aus Datei
			FileReader fileReader = new FileReader(scoreFile);
			BufferedReader reader = new BufferedReader(fileReader);
			Highscore = Integer.parseInt(reader.readLine());
			reader.close();
			fileReader.close();
			return Highscore;
		}

	}

// erstellen eines Arrays mit den einzelnen Buchstaben des Wortes
	public String[] LetterArray(int n) throws Exception {
		String wort = new String(Word(n));
		// String in einzelne Buchstaben splitten und in Array packen
		String[] letter = wort.split("");
		return letter;
	}

//einstellen der eines Fehlers
	public void setMistake(Boolean mistake) {
		Mistake = mistake;
	}

// abfragen ob ein Fehler vorliegt
	public Boolean getMistake() {
		return Mistake;
	}

//setzt den Wert f�r Match
	public void setMatch(Boolean matched) {
		Match = matched;
	}

// gib den Wert von Match aus
	public Boolean getMatch() {
		return Match;
	}

// setzt den Index des Treffers
	public void setIndex(int index) {
		ind = index;
	}

// gibt den Index des Treffers aus
	public int getIndex() {
		return ind;
	}

// einstellen der Fehlerzahl
	public void setMistakeCount(int fehler) {
		MistakeCount = fehler;
	}

// abfragen der Fehlerzahl
	public int getMistakeCount() {
		return MistakeCount;
	}

	// L�nge des Wortes ermitteln und zur�ckgeben
	public int WordStrings(int n) throws Exception {
		String wort = new String(Word(n));
		int Length;
		Length = wort.length();
		return Length;
	}

// ausw�hlen eines zuf�lligen Wortes
	public String Word(int n) throws Exception {
		File file = null;
		String resource = "/Hangaman/wo.txt";
		java.net.URL res = getClass().getResource(resource);
		// erstellen eines tempor�ren Files
		if (res.getProtocol().equals("jar")) {
			try {
				InputStream input = getClass().getResourceAsStream(resource);
				file = File.createTempFile("tempfile", ".tmp");
				OutputStream out = new FileOutputStream(file);
				int read;
				byte[] bytes = new byte[1024];

				while ((read = input.read(bytes)) != -1) {
					out.write(bytes, 0, read);
				}
				out.close();
				file.deleteOnExit();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} else {
			file = new File(res.getFile());
		}

		if (file != null && !file.exists()) {
			throw new RuntimeException("Error: File " + file + " not found!");
		}
		// lesen der Datei
		FileReader fileReader = new FileReader(file);
		BufferedReader reader = new BufferedReader(fileReader);
		String word;
		// erstellen eines Arrays mit allen W�rtern
		ArrayList<String> w�rter = new ArrayList();
		while ((word = reader.readLine()) != null) {
			w�rter.add(word);
		}

		reader.close();
		fileReader.close();
		return w�rter.get(n);
	}

// einstellen des Buchstaben
	public void setBuchstabe(String s) {
		Buchstabe = s;
	}

// abfragen des Buchstaben, um die richtige Datei anzuzeigen
	public String getBuchstabe() {
		return Buchstabe;
	}

}
