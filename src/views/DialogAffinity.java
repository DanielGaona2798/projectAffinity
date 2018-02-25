package views;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import com.sun.prism.paint.Color;

import constants.ConstantsUI;

public class DialogAffinity extends JDialog{

	private static final long serialVersionUID = 1L;
	private JProgressBar progressBar;
	
	public DialogAffinity() {
		setTitle("Your Affinity");
		setLayout(new BorderLayout());
		setSize(400, 300);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon("src/img/1.png").getImage());
		JLabel lblImg = new JLabel(new ImageIcon("src/img/imgDialogAffinity.png"));
		progressBar = new JProgressBar(0, 100);
		progressBar.setValue(0);
		progressBar.setForeground(ConstantsUI.COLOR_BTN);
		
		add(progressBar, BorderLayout.SOUTH);
		add(lblImg, BorderLayout.CENTER);
	}
	
	public void setProgressBar(int porcent){
		progressBar.setValue(porcent);
		progressBar.setStringPainted(true);
		progressBar.setString("Porcent: "+ porcent + "%");
		progressBar.setFont(new Font("Arial", Font.BOLD, 15));
	}
}
