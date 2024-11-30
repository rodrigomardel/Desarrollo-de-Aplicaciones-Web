package jcolonia.daw2023.junio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JMenuBar;
import java.awt.Button;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class BocetoVentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 20240530000L;
	private JPanel panelGeneral;
	private JTabbedPane panelPestañas;
	private JPanel panelPrincipal;
	private ModeloTablaPaíses modeloPaíses;
	private JPanel panelBotones;
	private JButton botónInsertar;
	private JScrollPane panelTablaDeslizante;
	private JTable tablaPaíses;
	private JMenuBar menuBar;
	private JButton btnNewButton;
	private JPanel panelAmpliación;
	private JPanel panelInformación;
	private JLabel etiquetaRegistro;
	private JTextPane textoRegistroEntradas;
	private int contador = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] argumentos) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(() -> {
			try {
				BocetoVentanaPrincipal frame = new BocetoVentanaPrincipal();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BocetoVentanaPrincipal() {
		initialize();
	}

	private void initialize() {
		setTitle("Ventana países");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 411);
		panelGeneral = new JPanel();
		panelGeneral.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelGeneral);
		panelGeneral.setLayout(new BorderLayout(0, 0));
		panelGeneral.add(getPanelPestañas(), BorderLayout.CENTER);
		panelGeneral.add(getPanelInformación(), BorderLayout.SOUTH);
	}

	private JTabbedPane getPanelPestañas() {
		if (panelPestañas == null) {
			panelPestañas = new JTabbedPane(JTabbedPane.TOP);
			panelPestañas.setBorder(new EmptyBorder(10, 10, 10, 10));
			panelPestañas.addTab("Listado", null, getPanelPrincipal(), null);
			panelPestañas.addTab("Ampliación", null, getPanelAmpliación(), null);
		}
		return panelPestañas;
	}

	private JPanel getPanelPrincipal() {
		if (panelPrincipal == null) {
			panelPrincipal = new JPanel();
			panelPrincipal.setBorder(new EmptyBorder(10, 0, 0, 0));
			panelPrincipal.setLayout(new BorderLayout(0, 10));

			panelPrincipal.add(getPanelBotones(), BorderLayout.SOUTH);
			panelPrincipal.add(getPanelTablaDeslizante(), BorderLayout.CENTER);
		}
		return panelPrincipal;
	}

	private JScrollPane getPanelTablaDeslizante() {
		if (panelTablaDeslizante == null) {
			panelTablaDeslizante = new JScrollPane();
			panelTablaDeslizante.setViewportView(getTablaPaíses());
		}
		return panelTablaDeslizante;
	}

	private JTable getTablaPaíses() {
		if (tablaPaíses == null) {
			tablaPaíses = new JTable();
			tablaPaíses.setShowVerticalLines(true);
			tablaPaíses.setShowHorizontalLines(true);
			tablaPaíses.setGridColor(Color.RED);
			tablaPaíses.setBorder(new LineBorder(new Color(0, 0, 0)));
			tablaPaíses.setModel(getModeloPaíses());
		}
		return tablaPaíses;
	}

	public ModeloTablaPaíses getModeloPaíses() {
		if (modeloPaíses == null) {
			modeloPaíses = new ModeloTablaPaíses();
		}
		return modeloPaíses;
	}

	private JPanel getPanelBotones() {
		if (panelBotones == null) {
			panelBotones = new JPanel();
			panelBotones.setBorder(new EmptyBorder(0, 0, 0, 0));
			panelBotones.setLayout(new GridLayout(0, 1, 0, 0));
			panelBotones.add(getBotónInsertar());
			panelBotones.add(getBtnNewButton());
		}
		return panelBotones;
	}

	private JButton getBotónInsertar() {
		if (botónInsertar == null) {
			botónInsertar = new JButton("Insertar");
			botónInsertar.addActionListener(new BotónInsertarActionListener());
			botónInsertar.setMnemonic(KeyEvent.VK_I);
		}
		return botónInsertar;
	}

	private class BotónInsertarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			contador++;
			StringBuffer textoPaíses = new StringBuffer();
			String líneasIntroducidas;
			ModeloTablaPaíses modelo = getModeloPaíses();
			AccesoBD acceso = new AccesoBD();

			modelo.addRow(acceso.leerDatos(contador));

//			for (int i = 0; i < modelo.getRowCount(); i++) {
//				País país = new País((String) modelo.getValueAt(i, 0), (String) modelo.getValueAt(i, 1),
//						(String) modelo.getValueAt(i, 2), (String) modelo.getValueAt(i, 3));
//
//				textoPaíses.append(país.toString());
//			}

			líneasIntroducidas = String.format("%d", modelo.getRowCount());
			etiquetaRegistro.setText(líneasIntroducidas);
			textoRegistroEntradas.setText(textoPaíses.toString());
		}
	}

	private class BtnNewButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ModeloTablaPaíses modelo = getModeloPaíses();
			modelo.vaciar();
			textoRegistroEntradas.setText("No hay registros");
			etiquetaRegistro.setText("0");
			contador = 0;
			modelo.contador = 0;

		}
	}

	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Vaciar");
			btnNewButton.addActionListener(new BtnNewButtonActionListener());
			btnNewButton.setMnemonic(KeyEvent.VK_V);
		}
		return btnNewButton;
	}

	private JPanel getPanelAmpliación() {
		if (panelAmpliación == null) {
			panelAmpliación = new JPanel();
			panelAmpliación.setToolTipText("");
			panelAmpliación.setBorder(new EmptyBorder(10, 10, 10, 10));
			panelAmpliación.setLayout(new BorderLayout(0, 0));
		}
		return panelAmpliación;
	}

	private JPanel getPanelInformación() {
		if (panelInformación == null) {
			panelInformación = new JPanel();
			panelInformación.setLayout(new BorderLayout(0, 0));
			panelInformación.add(getEtiquetaRegistro(), BorderLayout.NORTH);
			panelInformación.add(getTextoRegistroEntradas(), BorderLayout.SOUTH);
		}
		return panelInformación;
	}

	private JLabel getEtiquetaRegistro() {
		if (etiquetaRegistro == null) {
			etiquetaRegistro = new JLabel("Nº de registros:");
		}
		return etiquetaRegistro;
	}

	private JTextPane getTextoRegistroEntradas() {
		if (textoRegistroEntradas == null) {
			textoRegistroEntradas = new JTextPane();
		}
		return textoRegistroEntradas;
	}
}
