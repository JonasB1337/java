package JavaUebung5;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class KreisGui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					KreisGui frame = new KreisGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public KreisGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel ergebnis = new JLabel("");
		ergebnis.setBounds(147, 86, 110, 71);
		contentPane.add(ergebnis);
		
		textField = new JTextField();
		textField.setBounds(147, 44, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel radius = new JLabel("Radius:");
		radius.setBounds(157, 11, 46, 14);
		contentPane.add(radius);
		
		JButton berechnen = new JButton("Berechnen");
		berechnen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				double r= Double.parseDouble(textField.getText()); 	//umgewandelt von text auf Zahlen
				Kreis kreis = new Kreis(); 							//neues Kreisobjekt wurde erstellt
				kreis.setRadius(r);									//radius wird festgelegt
				String ergebnistext = String.valueOf(Math.round(kreis.getFlaeche()));	//ergebnis wird ausgegeben, gerundet
				ergebnis.setText(ergebnistext);
				
	
			}
		});
		berechnen.setBounds(144, 187, 89, 23);
		contentPane.add(berechnen);
		
	}
}
