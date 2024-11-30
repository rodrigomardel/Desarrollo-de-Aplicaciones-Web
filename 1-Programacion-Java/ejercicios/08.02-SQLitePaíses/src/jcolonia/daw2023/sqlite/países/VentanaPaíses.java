package jcolonia.daw2023.sqlite.países;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.util.List;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class VentanaPaíses extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jcontentPanel;
	private JPanel jpanelExterior;
	private JPanel jpanelBúsqueda;
	private JMenuBar jmenúBúsqueda;
	private JTextField jtextoBúsqueda;
	private JButton jbotónBúsqueda;
	private JPanel jpanelListado;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private String textoIntroducido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPaíses frame = new VentanaPaíses();
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
	public VentanaPaíses() {
		initialize();
	}

	/**
	 * Consulta la ventana.
	 * 
	 * @return ventana correspondiente
	 */
	private JFrame getVentana() {
		return this;
	}

	private void initialize() {
		setTitle("Países");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		jcontentPanel = new JPanel();
		jcontentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(jcontentPanel);
		jcontentPanel.setLayout(new BorderLayout(0, 0));
		jcontentPanel.add(getJpanelExterior());
	}

	private JPanel getJpanelExterior() {
		if (jpanelExterior == null) {
			jpanelExterior = new JPanel();
			jpanelExterior.setBorder(new EmptyBorder(10, 10, 10, 10));
			jpanelExterior.setLayout(new BorderLayout(0, 0));
			jpanelExterior.add(getJpanelBúsqueda(), BorderLayout.NORTH);
			jpanelExterior.add(getJpanelListado(), BorderLayout.CENTER);
		}
		return jpanelExterior;
	}

	/**
	 * Muestra un listado númerado de los países en formato texto.
	 * 
	 * @param contenido
	 */
	private void mostrarListado(List<AccesoBD.País> contenido) {
		JTextArea jtexto = getTextArea();
		StringBuffer texto;
		texto = new StringBuffer();

		for (AccesoBD.País elemento : contenido) {
			texto.append(elemento.toString());
		}

		jtexto.setText(texto.toString());
	}

	private JPanel getJpanelBúsqueda() {
		if (jpanelBúsqueda == null) {
			jpanelBúsqueda = new JPanel();
			jpanelBúsqueda.setBorder(new TitledBorder(
					new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
					"B\u00FAsqueda", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			jpanelBúsqueda.setLayout(new BorderLayout(0, 0));
			jpanelBúsqueda.add(getMenuBar_2(), BorderLayout.NORTH);
		}
		return jpanelBúsqueda;
	}

	private JMenuBar getMenuBar_2() {
		if (jmenúBúsqueda == null) {
			jmenúBúsqueda = new JMenuBar();
			jmenúBúsqueda.add(getTextField_1());
			jmenúBúsqueda.add(getJbotónBúsqueda());
		}
		return jmenúBúsqueda;
	}

	private JTextField getTextField_1() {
		if (jtextoBúsqueda == null) {
			jtextoBúsqueda = new JTextField();
			jtextoBúsqueda.setText("Introduzca el texto deseado");
			jtextoBúsqueda.setColumns(10);
		}
		return jtextoBúsqueda;
	}

	private JButton getJbotónBúsqueda() {
		if (jbotónBúsqueda == null) {
			jbotónBúsqueda = new JButton("Buscar");
			jbotónBúsqueda.addActionListener(new JbotónBúsquedaActionListener());
		}
		return jbotónBúsqueda;
	}

	private JPanel getJpanelListado() {
		if (jpanelListado == null) {
			jpanelListado = new JPanel();
			jpanelListado
					.setBorder(new TitledBorder(null, "Listado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			jpanelListado.setLayout(new BorderLayout(0, 0));
			jpanelListado.add(getScrollPane(), BorderLayout.CENTER);
		}
		return jpanelListado;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}

	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}

	private class JbotónBúsquedaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			textoIntroducido = jtextoBúsqueda.getText();
			try {
				mostrarListado(AccesoBD.leerDatos(textoIntroducido));
			} catch (NombrePaísException ex) {
				JOptionPane.showMessageDialog(getVentana(), ex.getLocalizedMessage(), "Información", 2);
			}

		}
	}
}
