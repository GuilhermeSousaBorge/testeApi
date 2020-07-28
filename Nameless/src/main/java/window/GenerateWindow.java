package window;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import Api.GetInfo;


public class GenerateWindow {

	private static String texto;

	public static void criarJanela() {
		final JPanel panel = new JPanel();
		panel.setVisible(true);
		panel.setBounds(30, 15, 100, 25);
		final JPanel panel1 = new JPanel();
		panel1.setVisible(true);
		panel1.setBounds(30, 45, 100, 25);
		final JPanel panel2= new JPanel();
		panel2.setVisible(true);
		panel2.setBounds(30, 75, 100, 25);
		final JPanel panel3 = new JPanel();
		panel3.setVisible(true);
		panel3.setBounds(30, 100, 100, 25);
		final JPanel panel4 = new JPanel();
		panel4.setVisible(true);
		panel4.setBounds(30, 130, 100, 25);
		final JPanel panel5 = new JPanel();
		panel5.setVisible(true);
		panel5.setBounds(150, 150, 800, 650);
		final JFrame janela = new JFrame();
		janela.setBounds(50, 50, 1200, 900);
		final JTextField busca = new JTextField();
		busca.setBounds(10, 800, 800, 30);
		final JButton botao = new JButton("Pesquisar");
		botao.setBounds(850, 800, 100, 30);
		final JButton botao2 = new JButton("voltar");
		botao2.setBounds(1000, 800, 100, 30);

		botao.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				texto = busca.getText();
				try {
					
					final GetInfo info = new GetInfo(texto);
					panel.add(info.getNomePokemon());
					panel1.add(info.getAltura());
					panel2.add(info.getPeso());
					panel3.add(info.getID());
					panel4.add(info.getIsDefault());
					panel5.add(info.getIcone());
					janela.add(panel);
					janela.add(panel1);
					janela.add(panel2);
					janela.add(panel3);
					janela.add(panel4);
					janela.add(panel5);
					janela.revalidate();
					janela.repaint();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		botao2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel1.removeAll();
				panel2.removeAll();
				panel3.removeAll();
				panel4.removeAll();
				panel5.removeAll();
				panel.validate();
				panel.updateUI();
				panel1.validate();
				panel1.updateUI();
				panel2.validate();
				panel2.updateUI();
				panel3.validate();
				panel3.updateUI();
				panel4.validate();
				panel4.updateUI();
				panel5.validate();
				panel5.updateUI();
			}
		});

		janela.add(busca);
		janela.add(botao);
		janela.add(botao2);
		janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		janela.setLayout(null);
		janela.setVisible(true);
	}
	
	

}
