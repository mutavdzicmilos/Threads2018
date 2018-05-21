package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Main;
import test.Test;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JTextField;

public class GUIDesign extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnPlay;
	private JButton btnStop;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private Test t = new Test();
	private JButton btnClear;
	private JButton btnStopT1;
	private JPanel panel_1;
	private JButton btnStartT1;
	private JButton btnStartT2;
	private JButton btnStartT3;
	private JButton btnStopT2;
	private JButton btnStopT3;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public GUIDesign() {
		setTitle("ThreadsGUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.SOUTH);
		contentPane.add(getScrollPane(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getBtnStop());
			panel.add(getBtnPlay());
			panel.add(getBtnClear());
		}
		return panel;
	}

	private JButton getBtnPlay() {
		if (btnPlay == null) {
			btnPlay = new JButton("Play");
			btnPlay.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnPlay.setEnabled(false);
					btnStartT2.setEnabled(false);
					btnStartT3.setEnabled(false);
					btnStartT1.setEnabled(false);
					Main.testSingingThreads();
				}
			});
		}
		return btnPlay;
	}

	private JButton getBtnStop() {
		if (btnStop == null) {
			btnStop = new JButton("Stop after all");
			btnStop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnPlay.setEnabled(true);
					btnStartT2.setEnabled(true);
					btnStartT3.setEnabled(true);
					btnStartT1.setEnabled(true);
					btnStopT1.setEnabled(true);
					btnStopT2.setEnabled(true);
					btnStopT3.setEnabled(true);
					Main.stopSingingThreads();
				}
			});
		}
		return btnStop;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea());
			scrollPane.setColumnHeaderView(getPanel_1());
		}
		return scrollPane;
	}

	public JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}

	private JButton getBtnClear() {
		if (btnClear == null) {
			btnClear = new JButton("Clear All Lyrics");
			btnClear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getTextArea().setText("");
				}
			});
		}
		return btnClear;
	}

	private JButton getBtnStopT1() {
		if (btnStopT1 == null) {
			btnStopT1 = new JButton("Stop 1");
			btnStopT1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnPlay.setEnabled(true);
					btnStartT2.setEnabled(true);
					btnStartT3.setEnabled(true);
					btnStartT1.setEnabled(true);
					btnStopT1.setEnabled(true);
					btnStopT2.setEnabled(true);
					btnStopT3.setEnabled(true);
					
					Main.stopFirstThread();
				}
			});
			btnStopT1.setPreferredSize(new Dimension(110, 23));
		}
		return btnStopT1;
	}
	private JButton getBtnStopT2() {
		if (btnStopT2 == null) {
			btnStopT2 = new JButton("Stop 2");
			btnStopT2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnPlay.setEnabled(true);
					btnStartT2.setEnabled(true);
					btnStartT3.setEnabled(true);
					btnStartT1.setEnabled(true);
					btnStopT1.setEnabled(true);
					btnStopT2.setEnabled(true);
					btnStopT3.setEnabled(true);
					Main.stopSecondThread();
				}
			});
			btnStopT2.setPreferredSize(new Dimension(110, 23));
		}
		return btnStopT2;
	}

	private JButton getBtnStopT3() {
		if (btnStopT3 == null) {
			btnStopT3 = new JButton("Stop 3");
			btnStopT3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnPlay.setEnabled(true);
					btnStartT2.setEnabled(true);
					btnStartT3.setEnabled(true);
					btnStartT1.setEnabled(true);
					btnStopT1.setEnabled(true);
					btnStopT2.setEnabled(true);
					btnStopT3.setEnabled(true);
					Main.stopThirdThread();
				}
			});
			btnStopT3.setPreferredSize(new Dimension(110, 23));
		}
		return btnStopT3;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setPreferredSize(new Dimension(120, 120));
			panel_1.add(getBtnStartT1());
			panel_1.add(getBtnStartT2());
			panel_1.add(getBtnStartT3());
			panel_1.add(getBtnStopT1());
			panel_1.add(getBtnStopT2());
			panel_1.add(getBtnStopT3());
		}
		return panel_1;
	}

	private JButton getBtnStartT1() {
		if (btnStartT1 == null) {
			btnStartT1 = new JButton("Start 1");
			btnStartT1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnPlay.setEnabled(false);
					btnStartT1.setEnabled(false);
					btnStartT2.setEnabled(false);
					btnStartT3.setEnabled(false);
					btnStopT2.setEnabled(false);
					btnStopT3.setEnabled(false);
					Main.startSpecificThread(1);
				}
			});
			btnStartT1.setPreferredSize(new Dimension(110, 23));
		}
		return btnStartT1;
	}

	private JButton getBtnStartT2() {
		if (btnStartT2 == null) {
			btnStartT2 = new JButton("Start 2");
			btnStartT2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnPlay.setEnabled(false);
					btnStartT1.setEnabled(false);
					btnStartT2.setEnabled(false);
					btnStartT3.setEnabled(false);
					btnStopT1.setEnabled(false);
					btnStopT3.setEnabled(false);
					Main.startSpecificThread(2);

				}
			});
			btnStartT2.setPreferredSize(new Dimension(110, 23));
		}
		return btnStartT2;
	}

	private JButton getBtnStartT3() {
		if (btnStartT3 == null) {
			btnStartT3 = new JButton("Start 3");
			btnStartT3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnPlay.setEnabled(false);
					btnStartT1.setEnabled(false);
					btnStartT2.setEnabled(false);
					btnStartT3.setEnabled(false);
					btnStopT2.setEnabled(false);
					btnStopT1.setEnabled(false);
					Main.startSpecificThread(3);

				}
			});
			btnStartT3.setPreferredSize(new Dimension(110, 23));
		}
		return btnStartT3;
	}

	
}