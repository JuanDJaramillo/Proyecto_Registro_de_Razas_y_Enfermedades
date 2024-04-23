import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;

public class Enfermedades extends JFrame {

    //General
    private JPanel panelPrincipal;
    private JButton btnAceptarPra, btnLimpiarPra, btnCancelarPra;

    //Ventana de Enfermedades (Principal)
    private JPanel pnlPraEnfermedades, pnlSurPraEnfermedades, pnlCentroPraEnfermedades, pnlNortePraEnfermedades;

    private JLabel lblTituloPraEnfermedades;

    private JButton btnBuscarPraEnfermedades, btnRegistrarPraEnfermedades, btnCancelarPraEnfermedades;

    //Buscar enfermedades por raza
    private JPanel pnlBuscarEnf, pnlNorteBuscar, pnlCentroBuscar, pnlSurBuscar;

    private JLabel lblRazaBuscar;
    private JComboBox cboRaza;

    private JTextArea textArea;
    private JScrollPane scrollTextArea;

    private List<String> listaRazas;

    //Registrar enfermedades
    private JPanel pnlRegistrarEnf, pnlNorteRegEnf, pnlCentroRegEnfPrc, pnlCentroRegEnfSec, pnlOesteInternoRegEnf, pnlEsteInternoRegEnf, pnlSurRegEnf;

    private JLabel lblTituloRegEnf, lblRazaRegEnf, lblNomCmnRegEnf, lblNomCienRegEnf;

    private JTextField txtRazaRegEnf, txtNomCmnRegEnf, txtNomCienRegEnf;

    public Enfermedades() {
        initComponentes();
        addListeners();
    }

    public void initComponentes() {
        setTitle("Mi ventana");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        panelPrincipal = new JPanel();
        this.getContentPane().add(panelPrincipal);
        panelPrincipal.setLayout(new BorderLayout());

        FlowLayout miLayout = new FlowLayout();
        miLayout.setAlignment(FlowLayout.CENTER);
        miLayout.setHgap(10);
        miLayout.setVgap(10);

        btnAceptarPra = new JButton("Aceptar");
        btnLimpiarPra = new JButton("Limpiar");
        btnCancelarPra = new JButton("Cancelar");

        //Ventana de Enfermedades (Principal)---------------------------------------------------
        pnlPraEnfermedades = new JPanel();
        pnlPraEnfermedades.setLayout(new BorderLayout());


        pnlNortePraEnfermedades = new JPanel();


        lblTituloPraEnfermedades = new JLabel();
        lblTituloPraEnfermedades.setText("<html>Bienvenido al apartado de Enfermedades <p><center>¿Que desea Realizar?<p></html>");
        pnlNortePraEnfermedades.add(lblTituloPraEnfermedades);


        pnlCentroPraEnfermedades = new JPanel();
        pnlCentroPraEnfermedades.setLayout(miLayout);

        btnRegistrarPraEnfermedades = new JButton("Nuevo Registro");
        pnlCentroPraEnfermedades.add(btnRegistrarPraEnfermedades);

        btnBuscarPraEnfermedades = new JButton("Buscar Enfermedad");
        pnlCentroPraEnfermedades.add(btnBuscarPraEnfermedades);


        pnlSurPraEnfermedades = new JPanel();

        btnCancelarPraEnfermedades = new JButton("Cerrar");

        pnlSurPraEnfermedades.add(btnCancelarPraEnfermedades);

        pnlPraEnfermedades.add(pnlNortePraEnfermedades, BorderLayout.NORTH);
        pnlPraEnfermedades.add(pnlCentroPraEnfermedades, BorderLayout.CENTER);
        pnlPraEnfermedades.add(pnlSurPraEnfermedades, BorderLayout.SOUTH);

        panelPrincipal.add(pnlPraEnfermedades, BorderLayout.CENTER);

        //Buscar enfermedades por raza--------------------------------------------------
        pnlBuscarEnf = new JPanel();
        pnlBuscarEnf.setLayout(new BorderLayout());


        pnlNorteBuscar = new JPanel();
        pnlNorteBuscar.setLayout(miLayout);

        lblRazaBuscar = new JLabel("Raza");
        pnlNorteBuscar.add(lblRazaBuscar);

        cboRaza = new JComboBox();
        cboRaza.addItem("Selecciona una Raza");
        pnlNorteBuscar.add(cboRaza);


        pnlCentroBuscar = new JPanel();

        textArea = new JTextArea(15, 30);
        textArea.setEditable(false);
        Border border = BorderFactory.createLineBorder(Color.black, 1, true);
        textArea.setBorder(border);
        pnlCentroBuscar.add(textArea);

        scrollTextArea = new JScrollPane();
        scrollTextArea.setViewportView(textArea);
        scrollTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pnlCentroBuscar.add(scrollTextArea);


        pnlSurBuscar = new JPanel();
        pnlSurBuscar.setLayout(miLayout);

        pnlBuscarEnf.add(pnlNorteBuscar, BorderLayout.NORTH);
        pnlBuscarEnf.add(pnlCentroBuscar, BorderLayout.CENTER);
        pnlBuscarEnf.add(pnlSurBuscar, BorderLayout.SOUTH);

        pnlBuscarEnf.setVisible(false);

        //Registrar enfermedades-----------------------------------------------------------
        pnlRegistrarEnf = new JPanel();
        pnlRegistrarEnf.setLayout(new BorderLayout());


        pnlNorteRegEnf = new JPanel();

        lblTituloRegEnf = new JLabel();
        lblTituloRegEnf.setText("<html><p><p>Ingresa la raza, el nombre común y científico de la Enfermedad<p><p></html>");
        pnlNorteRegEnf.add(lblTituloRegEnf);


        pnlCentroRegEnfPrc = new JPanel();
        pnlCentroRegEnfPrc.setLayout(miLayout);

        pnlCentroRegEnfSec = new JPanel();
        pnlCentroRegEnfSec.setLayout(new BorderLayout());

        pnlOesteInternoRegEnf = new JPanel();
        pnlOesteInternoRegEnf.setLayout(new GridLayout(3, 1, 40, 25));

        pnlEsteInternoRegEnf = new JPanel();
        pnlEsteInternoRegEnf.setLayout(new GridLayout(3, 1, 40, 25));

        lblRazaRegEnf = new JLabel("Raza    ");
        lblRazaRegEnf.setHorizontalAlignment(4);
        pnlOesteInternoRegEnf.add(lblRazaRegEnf);
        txtRazaRegEnf = new JTextField("",20);
        pnlEsteInternoRegEnf.add(txtRazaRegEnf);

        lblNomCmnRegEnf = new JLabel("Nombre común de la enfermedad    ");
        lblNomCmnRegEnf.setHorizontalAlignment(4);
        pnlOesteInternoRegEnf.add(lblNomCmnRegEnf);
        txtNomCmnRegEnf = new JTextField("",20);
        pnlEsteInternoRegEnf.add(txtNomCmnRegEnf);

        lblNomCienRegEnf = new JLabel("Nombre científico de la enfermedad    ");
        lblNomCienRegEnf.setHorizontalAlignment(4);
        pnlOesteInternoRegEnf.add(lblNomCienRegEnf);
        txtNomCienRegEnf = new JTextField("",20);
        pnlEsteInternoRegEnf.add(txtNomCienRegEnf);

        pnlCentroRegEnfSec.add(pnlOesteInternoRegEnf, BorderLayout.WEST);
        pnlCentroRegEnfSec.add(pnlEsteInternoRegEnf, BorderLayout.EAST);

        pnlCentroRegEnfPrc.add(pnlCentroRegEnfSec);


        pnlSurRegEnf = new JPanel();
        pnlSurRegEnf.setLayout(miLayout);

        pnlRegistrarEnf.add(pnlNorteRegEnf, BorderLayout.NORTH);
        pnlRegistrarEnf.add(pnlCentroRegEnfPrc, BorderLayout.CENTER);
        pnlRegistrarEnf.add(pnlSurRegEnf, BorderLayout.SOUTH);

        pnlRegistrarEnf.setVisible(false);

    }

    private void addListeners() {
        //General
        btnAceptarPra.addActionListener(new ListenersEnfermedades(this));
        btnLimpiarPra.addActionListener(new ListenersEnfermedades(this));
        btnCancelarPra.addActionListener(new ListenersEnfermedades(this));

        //Ventana de Enfermedades (Principal)
        btnBuscarPraEnfermedades.addActionListener(new ListenersEnfermedades(this));
        btnRegistrarPraEnfermedades.addActionListener(new ListenersEnfermedades(this));
        btnCancelarPraEnfermedades.addActionListener(new ListenersEnfermedades(this));

    }


    //Getters y Setters
    //General
    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public JButton getBtnAceptarPra() {
        return btnAceptarPra;
    }

    public void setBtnAceptarPra(JButton btnAceptarPra) {
        this.btnAceptarPra = btnAceptarPra;
    }

    public JButton getBtnLimpiarPra() {
        return btnLimpiarPra;
    }

    public void setBtnLimpiarPra(JButton btnLimpiarPra) {
        this.btnLimpiarPra = btnLimpiarPra;
    }

    public JButton getBtnCancelarPra() {
        return btnCancelarPra;
    }

    public void setBtnCancelarPra(JButton btnCancelarPra) {
        this.btnCancelarPra = btnCancelarPra;
    }

    //Ventana de Enfermedades (Principal)
    public JPanel getPnlPraEnfermedades() {
        return pnlPraEnfermedades;
    }

    public void setPnlPraEnfermedades(JPanel pnlPraEnfermedades) {
        this.pnlPraEnfermedades = pnlPraEnfermedades;
    }

    public JPanel getPnlSurPraEnfermedades() {
        return pnlSurPraEnfermedades;
    }
    public void setPnlSurPraEnfermedades(JPanel pnlSurPraEnfermedades) {
        this.pnlSurPraEnfermedades = pnlSurPraEnfermedades;
    }

    public JPanel getPnlCentroPraEnfermedades() {
        return pnlCentroPraEnfermedades;
    }
    public void setPnlCentroPraEnfermedades(JPanel pnlCentroPraEnfermedades) {
        this.pnlCentroPraEnfermedades = pnlCentroPraEnfermedades;
    }

    public JPanel getPnlNortePraEnfermedades() {
        return pnlNortePraEnfermedades;
    }
    public void setPnlNortePraEnfermedades(JPanel pnlNortePraEnfermedades) {
        this.pnlNortePraEnfermedades = pnlNortePraEnfermedades;
    }

    public JLabel getLblTituloPraEnfermedades() {
        return lblTituloPraEnfermedades;
    }
    public void setLblTituloPraEnfermedades(JLabel lblTituloPraEnfermedades) {
        this.lblTituloPraEnfermedades = lblTituloPraEnfermedades;
    }

    public JButton getBtnBuscarPraEnfermedades() {
        return btnBuscarPraEnfermedades;
    }
    public void setBtnBuscarPraEnfermedades(JButton btnBuscarPraEnfermedades) {
        this.btnBuscarPraEnfermedades = btnBuscarPraEnfermedades;
    }

    public JButton getBtnRegistrarPraEnfermedades() {
        return btnRegistrarPraEnfermedades;
    }
    public void setBtnRegistrarPraEnfermedades(JButton btnRegistrarPraEnfermedades) {
        this.btnRegistrarPraEnfermedades = btnRegistrarPraEnfermedades;
    }

    public JButton getBtnCancelarPraEnfermedades() {
        return btnCancelarPraEnfermedades;
    }
    public void setBtnCancelarPraEnfermedades(JButton btnCancelarPraEnfermedades) {
        this.btnCancelarPraEnfermedades = btnCancelarPraEnfermedades;
    }


    //Buscar enfermedades por raza
    public JPanel getPnlBuscarEnf() {
        return pnlBuscarEnf;
    }

    public void setPnlBuscarEnf(JPanel pnlBuscarEnf) {
        this.pnlBuscarEnf = pnlBuscarEnf;
    }

    public JPanel getPnlNorteBuscar() {
        return pnlNorteBuscar;
    }

    public void setPnlNorteBuscar(JPanel pnlNorteBuscar) {
        this.pnlNorteBuscar = pnlNorteBuscar;
    }

    public JPanel getPnlCentroBuscar() {
        return pnlCentroBuscar;
    }

    public void setPnlCentroBuscar(JPanel pnlCentroBuscar) {
        this.pnlCentroBuscar = pnlCentroBuscar;
    }

    public JPanel getPnlSurBuscar() {
        return pnlSurBuscar;
    }

    public void setPnlSurBuscar(JPanel pnlSurBuscar) {
        this.pnlSurBuscar = pnlSurBuscar;
    }

    public JLabel getLblRazaBuscar() {
        return lblRazaBuscar;
    }

    public void setLblRazaBuscar(JLabel lblRazaBuscar) {
        this.lblRazaBuscar = lblRazaBuscar;
    }

    public JComboBox getCboRaza() {
        return cboRaza;
    }

    public void setCboRaza(JComboBox cboRaza) {
        this.cboRaza = cboRaza;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    public List<String> getListaRazas(){
        return listaRazas;
    }
    public void setListaRazas(List<String> listaRazas) {
        this.listaRazas = listaRazas;
    }

    //Registrar enfermedades
    public JPanel getPnlRegistrarEnf() {
        return pnlRegistrarEnf;
    }

    public void setPnlRegistrarEnf(JPanel pnlRegistrarEnf) {
        this.pnlRegistrarEnf = pnlRegistrarEnf;
    }

    public JPanel getPnlNorteRegEnf() {
        return pnlNorteRegEnf;
    }

    public void setPnlNorteRegEnf(JPanel pnlNorteRegEnf) {
        this.pnlNorteRegEnf = pnlNorteRegEnf;
    }

    public JPanel getPnlCentroRegEnfPrc() {
        return pnlCentroRegEnfPrc;
    }

    public void setPnlCentroRegEnfPrc(JPanel pnlCentroRegEnfPrc) {
        this.pnlCentroRegEnfPrc = pnlCentroRegEnfPrc;
    }

    public JPanel getPnlCentroRegEnfSec() {
        return pnlCentroRegEnfSec;
    }

    public void setPnlCentroRegEnfSec(JPanel pnlCentroRegEnfSec) {
        this.pnlCentroRegEnfSec = pnlCentroRegEnfSec;
    }

    public JPanel getPnlOesteInternoRegEnf() {
        return pnlOesteInternoRegEnf;
    }

    public void setPnlOesteInternoRegEnf(JPanel pnlOesteInternoRegEnf) {
        this.pnlOesteInternoRegEnf = pnlOesteInternoRegEnf;
    }

    public JPanel getPnlEsteInternoRegEnf() {
        return pnlEsteInternoRegEnf;
    }

    public void setPnlEsteInternoRegEnf(JPanel pnlEsteInternoRegEnf) {
        this.pnlEsteInternoRegEnf = pnlEsteInternoRegEnf;
    }

    public JPanel getPnlSurRegEnf() {
        return pnlSurRegEnf;
    }

    public void setPnlSurRegEnf(JPanel pnlSurRegEnf) {
        this.pnlSurRegEnf = pnlSurRegEnf;
    }

    public JLabel getLblTituloRegEnf() {
        return lblTituloRegEnf;
    }

    public void setLblTituloRegEnf(JLabel lblTituloRegEnf) {
        this.lblTituloRegEnf = lblTituloRegEnf;
    }

    public JLabel getLblRazaRegEnf() {
        return lblRazaRegEnf;
    }

    public void setLblRazaRegEnf(JLabel lblRazaRegEnf) {
        this.lblRazaRegEnf = lblRazaRegEnf;
    }

    public JLabel getLblNomCmnRegEnf() {
        return lblNomCmnRegEnf;
    }

    public void setLblNomCmnRegEnf(JLabel lblNomCmnRegEnf) {
        this.lblNomCmnRegEnf = lblNomCmnRegEnf;
    }

    public JLabel getLblNomCienRegEnf() {
        return lblNomCienRegEnf;
    }

    public void setLblNomCienRegEnf(JLabel lblNomCienRegEnf) {
        this.lblNomCienRegEnf = lblNomCienRegEnf;
    }

    public JTextField getTxtRazaRegEnf() {
        return txtRazaRegEnf;
    }

    public void setTxtRazaRegEnf(JTextField txtRazaRegEnf) {
        this.txtRazaRegEnf = txtRazaRegEnf;
    }

    public JTextField getTxtNomCmnRegEnf() {
        return txtNomCmnRegEnf;
    }

    public void setTxtNomCmnRegEnf(JTextField txtNomCmnRegEnf) {
        this.txtNomCmnRegEnf = txtNomCmnRegEnf;
    }

    public JTextField getTxtNomCienRegEnf() {
        return txtNomCienRegEnf;
    }

    public void setTxtNomCienRegEnf(JTextField txtNomCienRegEnf) {
        this.txtNomCienRegEnf = txtNomCienRegEnf;
    }

}
