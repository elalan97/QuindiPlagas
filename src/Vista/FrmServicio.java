/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Controlador.CtlAgenda;
import Controlador.CtlCliente;
import Controlador.CtlLocal;
import Controlador.CtlServicio;
import Controlador.CtlUsuario;
import DTO.DTOLocal;
import DTO.DtoAgenda;
import DTO.DtoServicio;
import Modelo.Agenda;
import Modelo.Cliente;
import Modelo.Miles;
import Modelo.Servicio;
import Modelo.Usuario;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ALAN
 */
public class FrmServicio extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmServicio
     */
    CtlLocal ctlLocal;
    CtlCliente ctlCliente;
    CtlServicio ctlServicio;
    CtlUsuario ctlUsuario;
    CtlAgenda ctlAgenda;
    public String usuarioIniciado;
    String vendedor, codigoEditar, fechaRefuerzoVieja;

    public FrmServicio() {
        initComponents();
        this.setSize(new Dimension(1435, 600));
        this.setTitle("Gestionar Servicio");
        bloquearCampos();
        ctlCliente = new CtlCliente();
        ctlLocal = new CtlLocal();
        ctlServicio = new CtlServicio();
        ctlUsuario = new CtlUsuario();
        ctlAgenda = new CtlAgenda();
        Inicio usuarioInicio = new Inicio();
        usuarioIniciado = usuarioInicio.usuarioIniciado;
        buscarVendedor();
        generarCodigo();

    }

    public void buscarVendedor() {

        Usuario usuario = ctlUsuario.buscarUsuario(usuarioIniciado);
        vendedor = usuario.getNombre();

    }

    public void bloquearCampos() {

        txtApellidoCliente.setEditable(false);
        txtCelularCliente.setEditable(false);
        txtCiudadNegocio.setEditable(false);
        txtCorreoCliente.setEditable(false);
        txtDireccionNegocio.setEditable(false);
        txtEncargadoNegocio.setEditable(false);
        txtMunicipioNegocio.setEditable(false);
        txtNitNegocio.setEditable(false);
        txtNombreCliente.setEditable(false);
        txtNombreNegocio.setEditable(false);
        txtTipoCliente.setEditable(false);
    }

    public void listaLocales(String codigo) {

        ArrayList<DTOLocal> lista = ctlLocal.listarLocalPorCliente(codigo);

        DefaultTableModel modelo = (DefaultTableModel) tbLocal.getModel();
        modelo.setRowCount(0);

        for (DTOLocal dTOLocal : lista) {

            modelo.addRow(new Object[]{dTOLocal.getNombreNegocio(), dTOLocal.getDireccion(),
                dTOLocal.getNit(), dTOLocal.getEncargado(), dTOLocal.getMunicipio(), dTOLocal.getCiudad()});

        }

    }

    public void limpiarCampos() {

        txtFactura.setText("");
        txtTecnico.setText("");
        txtProximaFecha.setText("");
        txtValor.setText("");
        txtObservacion.setText("");
        jcFechaRealizo.setCalendar(null);
        llenarCombo1();
        llenarCombo2();
        llenarCombo3();
        llenarCombo4();
        txtHoraAgenda.setText("");
        txtConfirmacionAgenda.setText("");
        txtObservacionesAgenda.setText("");
        jcRefuerzo.setCalendar(null);

    }

    public void llenarCombo1() {

        cbTipoServicio.removeAllItems();
        cbTipoServicio.addItem("Seleccione");
        cbTipoServicio.addItem("Control Integral");
        cbTipoServicio.addItem("Desratizacion");
        cbTipoServicio.addItem("Lavado de Tanques");
        cbTipoServicio.addItem("Mantenimiento de cebaderos");
        cbTipoServicio.addItem("Refuerzo");
        cbTipoServicio.addItem("Garantia");
        cbTipoServicio.addItem("Seguimiento");
        cbTipoServicio.addItem("Trampa pegante");
        cbTipoServicio.addItem("Trampa de grasa");

    }

    public void llenarCombo2() {

        cbPeriocidad.removeAllItems();
        cbPeriocidad.addItem("Seleccione");
        cbPeriocidad.addItem("Mensual");
        cbPeriocidad.addItem("Bimensual");
        cbPeriocidad.addItem("Trimestral");
        cbPeriocidad.addItem("Cuatrimestral");
        cbPeriocidad.addItem("Quinquemestral");
        cbPeriocidad.addItem("Semestral");
        cbPeriocidad.addItem("Unica vez");

    }

    public void llenarCombo3() {

        cbPago.removeAllItems();
        cbPago.addItem("Seleccione");
        cbPago.addItem("Pago");
        cbPago.addItem("Pendiente");

    }

    public void llenarCombo4() {

        cbRefuerzo.removeAllItems();
        cbRefuerzo.addItem("Seleccione");
        cbRefuerzo.addItem("Si");
        cbRefuerzo.addItem("No");

    }

    public void generarCodigo() {

        int consecutivo;
        String letra1, numero, codigoCadena;

        Servicio servicio = ctlServicio.buscarUltimoRegistroServicio();

        String[] separarTodo = servicio.getNroFactura().split("S");

        if (separarTodo.length > 1) {

            letra1 = separarTodo[0];
            numero = separarTodo[1];

            consecutivo = Integer.parseInt(numero) + 1;

            codigoCadena = "S" + consecutivo;
            txtFactura.setText(codigoCadena);

        } else {

            System.out.println("nada");

        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTipoCliente = new javax.swing.JTextField();
        txtCodigoCliente = new javax.swing.JTextField();
        txtNombreCliente = new javax.swing.JTextField();
        txtApellidoCliente = new javax.swing.JTextField();
        txtCelularCliente = new javax.swing.JTextField();
        txtCorreoCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLocal = new javax.swing.JTable();
        btnBuscarCliente = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNombreNegocio = new javax.swing.JTextField();
        txtDireccionNegocio = new javax.swing.JTextField();
        txtNitNegocio = new javax.swing.JTextField();
        txtEncargadoNegocio = new javax.swing.JTextField();
        txtMunicipioNegocio = new javax.swing.JTextField();
        txtCiudadNegocio = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtFactura = new javax.swing.JTextField();
        txtTecnico = new javax.swing.JTextField();
        txtProximaFecha = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        txtObservacion = new javax.swing.JTextField();
        cbTipoServicio = new javax.swing.JComboBox<>();
        jcFechaRealizo = new com.toedter.calendar.JDateChooser();
        cbPeriocidad = new javax.swing.JComboBox<>();
        cbPago = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        BtnBuscar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        cbRefuerzo = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtHoraAgenda = new javax.swing.JTextField();
        txtConfirmacionAgenda = new javax.swing.JTextField();
        txtObservacionesAgenda = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jcRefuerzo = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Gestionar Servicios");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 15, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Codigo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 73, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Tipo de Cliente");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 123, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Nombre");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 173, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Apellido");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 223, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Correo");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 273, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Celular");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 323, -1, -1));
        getContentPane().add(txtTipoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 150, -1));

        txtCodigoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoClienteKeyTyped(evt);
            }
        });
        getContentPane().add(txtCodigoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 150, -1));
        getContentPane().add(txtNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 150, -1));
        getContentPane().add(txtApellidoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 150, -1));
        getContentPane().add(txtCelularCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 150, -1));
        getContentPane().add(txtCorreoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 150, -1));

        tbLocal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre del Negocio", "Direccion", "Nit", "Encargado", "Departamento", "Ciudad"
            }
        ));
        tbLocal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLocalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbLocal);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 423, 630, 110));

        btnBuscarCliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnBuscarCliente.setText("Buscar Cliente");
        btnBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 373, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Nombre Del Negocio");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 73, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Direccion");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 123, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Nit");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 173, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Encargado");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 223, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Departamento");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 273, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Ciudad");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 323, -1, -1));
        getContentPane().add(txtNombreNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 70, 150, -1));
        getContentPane().add(txtDireccionNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 120, 150, -1));
        getContentPane().add(txtNitNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 170, 150, -1));
        getContentPane().add(txtEncargadoNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 220, 150, -1));
        getContentPane().add(txtMunicipioNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 270, 150, -1));
        getContentPane().add(txtCiudadNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 320, 150, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Nro Servicio");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 73, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Tipo de Servicio");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 123, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Tecnico");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 173, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Fecha de Realizo");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 273, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Periocidad");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 323, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Proxima Fecha");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 373, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Pago");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 423, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Valor");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 473, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Observacion");
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 523, -1, -1));

        txtFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFacturaKeyTyped(evt);
            }
        });
        getContentPane().add(txtFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 70, 200, -1));
        getContentPane().add(txtTecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 170, 200, -1));
        getContentPane().add(txtProximaFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 370, 200, -1));

        txtValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtValorKeyReleased(evt);
            }
        });
        getContentPane().add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 470, 200, -1));
        getContentPane().add(txtObservacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 520, 200, -1));

        cbTipoServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Control Integral", "Desratizacion", "Lavado de Tanques", "Mantenimiento de cebaderos", "Refuerzo", "Garantia", "Seguimiento", "Trampa pegante", "Trampa de grasa" }));
        getContentPane().add(cbTipoServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 120, 200, -1));

        jcFechaRealizo.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(jcFechaRealizo, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 270, 200, -1));

        cbPeriocidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Mensual", "Bimensual", "Trimestral", "Cuatrimestral", "Quinquemestral", "Semestral", "Unica vez" }));
        cbPeriocidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbPeriocidadItemStateChanged(evt);
            }
        });
        getContentPane().add(cbPeriocidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 320, 200, -1));

        cbPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Pago", "Pendiente" }));
        getContentPane().add(cbPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 420, 200, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1075, 270, -1, -1));

        BtnBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1168, 270, -1, -1));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Editar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1255, 270, -1, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1335, 270, -1, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Refuerzo");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 223, -1, -1));

        cbRefuerzo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Si", "No" }));
        getContentPane().add(cbRefuerzo, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 220, 200, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Hora");
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(1075, 73, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Confirmacion");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1075, 123, -1, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("Observaciones");
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1075, 173, -1, -1));
        getContentPane().add(txtHoraAgenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 70, 180, -1));
        getContentPane().add(txtConfirmacionAgenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 120, 180, -1));
        getContentPane().add(txtObservacionesAgenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 170, 180, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("Fecha refuerzo");
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(1075, 223, -1, -1));

        jcRefuerzo.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(jcRefuerzo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 220, 180, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarClienteActionPerformed
        // TODO add your handling code here:

        String codigo;

        codigo = txtCodigoCliente.getText();

        if (codigo.isEmpty()) {

            JOptionPane.showMessageDialog(null, "por favor busque por codigo al cliente");

        } else {

            try {

                Cliente c = ctlCliente.buscarCliente(codigo);

                txtApellidoCliente.setText(c.getApellido());
                txtCelularCliente.setText(c.getCelular());
                txtCorreoCliente.setText(c.getCorreo());
                txtNombreCliente.setText(c.getNombre());
                txtTipoCliente.setText(c.getTipo());

                listaLocales(codigo);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }

    }//GEN-LAST:event_btnBuscarClienteActionPerformed

    private void txtCodigoClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoClienteKeyTyped
        // TODO add your handling code here:

        char enter = evt.getKeyChar();

        if (enter == KeyEvent.VK_ENTER) {

            btnBuscarCliente.doClick();

        }
    }//GEN-LAST:event_txtCodigoClienteKeyTyped

    private void tbLocalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLocalMouseClicked
        // TODO add your handling code here:

        int seleccionar;

        seleccionar = tbLocal.rowAtPoint(evt.getPoint());

        txtNombreNegocio.setText(String.valueOf(tbLocal.getValueAt(seleccionar, 0)));
        txtDireccionNegocio.setText(String.valueOf(tbLocal.getValueAt(seleccionar, 1)));
        txtNitNegocio.setText(String.valueOf(tbLocal.getValueAt(seleccionar, 2)));
        txtEncargadoNegocio.setText(String.valueOf(tbLocal.getValueAt(seleccionar, 3)));
        txtMunicipioNegocio.setText(String.valueOf(tbLocal.getValueAt(seleccionar, 4)));
        txtCiudadNegocio.setText(String.valueOf(tbLocal.getValueAt(seleccionar, 5)));
    }//GEN-LAST:event_tbLocalMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        int valor;
        String nroFactura, tipoServicio, refuerzo, tecnico, fecha, periocidad, proxFecha, pago,
                observacion, valorCadena, direccion, ciudad, fechaRefuerzo, hora, confirmacion, observaciones;

        valorCadena = txtValor.getText();
        nroFactura = txtFactura.getText();
        tipoServicio = (String) cbTipoServicio.getSelectedItem();
        refuerzo = (String) cbRefuerzo.getSelectedItem();
        tecnico = txtTecnico.getText();
        fecha = ((JTextField) jcFechaRealizo.getDateEditor().getUiComponent()).getText();
        periocidad = (String) cbPeriocidad.getSelectedItem();
        proxFecha = txtProximaFecha.getText();
        pago = (String) cbPago.getSelectedItem();
        observacion = txtObservacion.getText();
        direccion = txtDireccionNegocio.getText();
        ciudad = txtCiudadNegocio.getText();
        hora = txtHoraAgenda.getText();
        confirmacion = txtConfirmacionAgenda.getText();
        observaciones = txtObservacionesAgenda.getText();

        if (valorCadena.isEmpty() || nroFactura.isEmpty() || tipoServicio.equals("Seleccione")
                || tecnico.isEmpty() || fecha.isEmpty() || periocidad.equals("Seleccione")
                || proxFecha.isEmpty() || pago.isEmpty() || observacion.isEmpty() || direccion.isEmpty()
                || ciudad.isEmpty() || refuerzo.equals("Seleccione")) {

            JOptionPane.showMessageDialog(null, "porfavor llenar los "
                    + "datos del servicio que quiere registrar");

        } else {

            try {

                if (refuerzo.equals("Si")) {

                    String num = valorCadena.replace(".", "");
                    valor = Integer.parseInt(num);

                    DateTimeFormatter format = new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("yyyy-MM-d")).toFormatter();
                    LocalDate fecha_I = LocalDate.parse(fecha, format);
                    fechaRefuerzo = fecha_I.plusDays(20) + "";

                    Servicio servicio = new Servicio(0, 0, valor, nroFactura, tipoServicio,
                            refuerzo, tecnico, fecha, periocidad, proxFecha, pago, vendedor, observacion);

                    Agenda agenda = new Agenda(0, 0,
                            hora, confirmacion, observaciones, fecha);

                    Agenda agendaRefuerzo = new Agenda(0, 0,
                            hora, confirmacion, observacion, fechaRefuerzo);

                    ctlServicio.guardarServicio(servicio, direccion, ciudad);
                    ctlAgenda.guardarAgenda(agenda, nroFactura);
                    ctlAgenda.guardarAgenda(agendaRefuerzo, nroFactura);
                    JOptionPane.showMessageDialog(null, "se ha guardado correctamente");
                    limpiarCampos();
                    generarCodigo();

                } else {

                    String num = valorCadena.replace(".", "");
                    valor = Integer.parseInt(num);

                    Servicio servicio = new Servicio(0, 0, valor, nroFactura, tipoServicio,
                            refuerzo, tecnico, fecha, periocidad, proxFecha, pago, vendedor, observacion);

                    Agenda agenda = new Agenda(0, 0,
                            hora, confirmacion, observaciones, fecha);

                    ctlServicio.guardarServicio(servicio, direccion, ciudad);
                    ctlAgenda.guardarAgenda(agenda, nroFactura);
                    JOptionPane.showMessageDialog(null, "se ha guardado correctamente");
                    limpiarCampos();
                    generarCodigo();
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtValorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorKeyReleased
        // TODO add your handling code here:

        Miles op = new Miles();

        if (!txtValor.getText().isEmpty()) {

            double numero;
            String num = txtValor.getText();
            String numeracion = num.replace(".", "");
            numero = Double.parseDouble(numeracion);
            txtValor.setText(op.separarMiles(numero));

        } else {
            txtValor.setText("");
        }
    }//GEN-LAST:event_txtValorKeyReleased

    private void cbPeriocidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbPeriocidadItemStateChanged
        // TODO add your handling code here:

        String datoSeleccionado, fecha, proxFecha;

        fecha = ((JTextField) jcFechaRealizo.getDateEditor().getUiComponent()).getText();

        if (evt.getStateChange() == ItemEvent.SELECTED) {

            datoSeleccionado = (String) evt.getItem();

            if (datoSeleccionado.equals("Seleccione") || fecha.isEmpty()) {

            } else {

                proxFecha = ctlServicio.proximaFecha(datoSeleccionado, fecha);

                txtProximaFecha.setText(proxFecha);

            }
        }
    }//GEN-LAST:event_cbPeriocidadItemStateChanged

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        // TODO add your handling code here:

        Date fecha, fechaRefuerzo;
        int valor1;
        String nroFactura, fecha1, valor, fechaRefuerzo1, fecha2;

        nroFactura = txtFactura.getText();

        if (nroFactura.isEmpty()) {

            JOptionPane.showMessageDialog(null, "por favor busque por nro de factura");

        } else {

            try {

                Miles miles = new Miles();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                DtoAgenda dtoAgenda = ctlAgenda.buscarServicioAgenda(nroFactura);

                if (dtoAgenda.getsRefuerzo().equals("Si")) {

                    valor1 = Integer.parseInt(dtoAgenda.getsValor());
                    valor = miles.separarMiles(valor1);

                    txtFactura.setText(dtoAgenda.getsNroFactura());
                    txtTecnico.setText(dtoAgenda.getsTecnico());
                    txtProximaFecha.setText(dtoAgenda.getsProxFecha());
                    txtValor.setText(valor);
                    txtObservacion.setText(dtoAgenda.getsObservacion());
                    txtApellidoCliente.setText(dtoAgenda.getcApellido());
                    txtCelularCliente.setText(dtoAgenda.getcCelular());
                    txtCiudadNegocio.setText(dtoAgenda.getCiNombre());
                    txtCodigoCliente.setText(dtoAgenda.getcCodigo());
                    txtCorreoCliente.setText(dtoAgenda.getcCorreo());
                    txtDireccionNegocio.setText(dtoAgenda.getlDireccion());
                    txtEncargadoNegocio.setText(dtoAgenda.getlEncargado());
                    txtMunicipioNegocio.setText(dtoAgenda.getMuNombre());
                    txtNitNegocio.setText(dtoAgenda.getlNit());
                    txtNombreCliente.setText(dtoAgenda.getcNombre());
                    txtNombreNegocio.setText(dtoAgenda.getlNombreNegocio());
                    txtObservacion.setText(dtoAgenda.getsObservacion());
                    txtTipoCliente.setText(dtoAgenda.getcTipo());
                    txtHoraAgenda.setText(dtoAgenda.getaHora());
                    txtConfirmacionAgenda.setText(dtoAgenda.getaConfirmacion());
                    txtObservacionesAgenda.setText(dtoAgenda.getaObservacion());

                    fecha1 = dtoAgenda.getsFecha();
                    fecha = format.parse(fecha1);
                    jcFechaRealizo.setDate(fecha);

                    fecha2 = dtoAgenda.getaFecha();
                    fechaRefuerzo = format.parse(fecha2);
                    jcRefuerzo.setDate(fechaRefuerzo);
                    fechaRefuerzoVieja = fecha2;
                    

                    cbPeriocidad.setSelectedItem(dtoAgenda.getsPeriocidad());
                    cbTipoServicio.setSelectedItem(dtoAgenda.getsTipoServicio());
                    cbPago.setSelectedItem(dtoAgenda.getsPago());
                    cbRefuerzo.setSelectedItem(dtoAgenda.getsRefuerzo());

                    codigoEditar = dtoAgenda.getsNroFactura();

                } else {

                    valor1 = Integer.parseInt(dtoAgenda.getsValor());
                    valor = miles.separarMiles(valor1);

                    txtFactura.setText(dtoAgenda.getsNroFactura());
                    txtTecnico.setText(dtoAgenda.getsTecnico());
                    txtProximaFecha.setText(dtoAgenda.getsProxFecha());
                    txtValor.setText(valor);
                    txtObservacion.setText(dtoAgenda.getsObservacion());
                    txtApellidoCliente.setText(dtoAgenda.getcApellido());
                    txtCelularCliente.setText(dtoAgenda.getcCelular());
                    txtCiudadNegocio.setText(dtoAgenda.getCiNombre());
                    txtCodigoCliente.setText(dtoAgenda.getcCodigo());
                    txtCorreoCliente.setText(dtoAgenda.getcCorreo());
                    txtDireccionNegocio.setText(dtoAgenda.getlDireccion());
                    txtEncargadoNegocio.setText(dtoAgenda.getlEncargado());
                    txtMunicipioNegocio.setText(dtoAgenda.getMuNombre());
                    txtNitNegocio.setText(dtoAgenda.getlNit());
                    txtNombreCliente.setText(dtoAgenda.getcNombre());
                    txtNombreNegocio.setText(dtoAgenda.getlNombreNegocio());
                    txtObservacion.setText(dtoAgenda.getsObservacion());
                    txtTipoCliente.setText(dtoAgenda.getcTipo());
                    txtHoraAgenda.setText(dtoAgenda.getaHora());
                    txtConfirmacionAgenda.setText(dtoAgenda.getaConfirmacion());
                    txtObservacionesAgenda.setText(dtoAgenda.getaObservacion());

                    fecha1 = dtoAgenda.getsFecha();
                    fecha = format.parse(fecha1);
                    jcFechaRealizo.setDate(fecha);

                    cbPeriocidad.setSelectedItem(dtoAgenda.getsPeriocidad());
                    cbTipoServicio.setSelectedItem(dtoAgenda.getsTipoServicio());
                    cbPago.setSelectedItem(dtoAgenda.getsPago());
                    cbRefuerzo.setSelectedItem(dtoAgenda.getsRefuerzo());

                    codigoEditar = dtoAgenda.getsNroFactura();

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }
    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        int valor;
        String nroFactura, tipoServicio, refuerzo, tecnico, fecha, periocidad, proxFecha, pago,
                observacion, valorCadena, direccion, ciudad, fechaRefuerzo, hora, confirmacion, observaciones;

        valorCadena = txtValor.getText();
        nroFactura = txtFactura.getText();
        tipoServicio = (String) cbTipoServicio.getSelectedItem();
        refuerzo = (String) cbRefuerzo.getSelectedItem();
        tecnico = txtTecnico.getText();
        fecha = ((JTextField) jcFechaRealizo.getDateEditor().getUiComponent()).getText();
        periocidad = (String) cbPeriocidad.getSelectedItem();
        proxFecha = txtProximaFecha.getText();
        pago = (String) cbPago.getSelectedItem();
        observacion = txtObservacion.getText();
        direccion = txtDireccionNegocio.getText();
        ciudad = txtCiudadNegocio.getText();
        hora = txtHoraAgenda.getText();
        confirmacion = txtConfirmacionAgenda.getText();
        observaciones = txtObservacionesAgenda.getText();
        fechaRefuerzo = ((JTextField) jcRefuerzo.getDateEditor().getUiComponent()).getText();

        if (valorCadena.isEmpty() || nroFactura.isEmpty() || tipoServicio.equals("Seleccione")
                || tecnico.isEmpty() || fecha.isEmpty() || periocidad.equals("Seleccione")
                || proxFecha.isEmpty() || pago.isEmpty() || observacion.isEmpty() || direccion.isEmpty()
                || ciudad.isEmpty() || refuerzo.equals("Seleccione")) {

            JOptionPane.showMessageDialog(null, "porfavor llenar los "
                    + "datos del servicio que quiere registrar");

        } else {

            try {

                if (refuerzo.equals("Si")) {

                    String num = valorCadena.replace(".", "");
                    valor = Integer.parseInt(num);

                    Servicio servicio = new Servicio(0, 0, valor, nroFactura, tipoServicio,
                            refuerzo, tecnico, fecha, periocidad, proxFecha, pago, vendedor, observacion);

                    Agenda agenda = new Agenda(0, 0,
                            hora, confirmacion, observaciones, fechaRefuerzo);

                    ctlServicio.editarServicio(servicio, direccion, ciudad, codigoEditar);
                    ctlAgenda.edtarAgendaRefuerzo(agenda, nroFactura, fechaRefuerzoVieja);
                    JOptionPane.showMessageDialog(null, "se ha guardado correctamente");
                    limpiarCampos();
                    generarCodigo();

                } else {

                    String num = valorCadena.replace(".", "");
                    valor = Integer.parseInt(num);

                    Servicio servicio = new Servicio(0, 0, valor, nroFactura, tipoServicio,
                            refuerzo, tecnico, fecha, periocidad, proxFecha, pago, vendedor, observacion);

                    Agenda agenda = new Agenda(0, 0,
                            hora, confirmacion, observaciones, fecha);

                    ctlServicio.editarServicio(servicio, direccion, ciudad, codigoEditar);
                    ctlAgenda.edtarAgenda(agenda, nroFactura);
                    JOptionPane.showMessageDialog(null, "se ha guardado correctamente");
                    limpiarCampos();
                    generarCodigo();
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        String nroFactura, refuerzo;

        nroFactura = txtFactura.getText();
        refuerzo = (String) cbRefuerzo.getSelectedItem();

        if (nroFactura.isEmpty() || refuerzo.equals("Seleccione")) {

            JOptionPane.showMessageDialog(null, "porfavor llenar los "
                    + "datos del servicio que eliminar editar");

        } else {

            try {

                if (refuerzo.equals("Si")) {

                    String fecha = ((JTextField) jcRefuerzo.getDateEditor().getUiComponent()).getText();
                    ctlAgenda.eliminarAgenda(nroFactura, fecha);
                    ctlServicio.eliminarServicio(nroFactura);
                    JOptionPane.showMessageDialog(null, "se ha eliminado correctamente");
                    limpiarCampos();

                } else {

                    String fecha = ((JTextField) jcFechaRealizo.getDateEditor().getUiComponent()).getText();
                    ctlAgenda.eliminarAgenda(nroFactura, fecha);
                    ctlServicio.eliminarServicio(nroFactura);
                    JOptionPane.showMessageDialog(null, "se ha eliminado correctamente");
                    limpiarCampos();

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFacturaKeyTyped
        // TODO add your handling code here:

        char enter = evt.getKeyChar();

        if (enter == KeyEvent.VK_ENTER) {

            BtnBuscar.doClick();

        }
    }//GEN-LAST:event_txtFacturaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JComboBox<String> cbPago;
    private javax.swing.JComboBox<String> cbPeriocidad;
    private javax.swing.JComboBox<String> cbRefuerzo;
    private javax.swing.JComboBox<String> cbTipoServicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jcFechaRealizo;
    private com.toedter.calendar.JDateChooser jcRefuerzo;
    private javax.swing.JTable tbLocal;
    private javax.swing.JTextField txtApellidoCliente;
    private javax.swing.JTextField txtCelularCliente;
    private javax.swing.JTextField txtCiudadNegocio;
    private javax.swing.JTextField txtCodigoCliente;
    private javax.swing.JTextField txtConfirmacionAgenda;
    private javax.swing.JTextField txtCorreoCliente;
    private javax.swing.JTextField txtDireccionNegocio;
    private javax.swing.JTextField txtEncargadoNegocio;
    private javax.swing.JTextField txtFactura;
    private javax.swing.JTextField txtHoraAgenda;
    private javax.swing.JTextField txtMunicipioNegocio;
    private javax.swing.JTextField txtNitNegocio;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreNegocio;
    private javax.swing.JTextField txtObservacion;
    private javax.swing.JTextField txtObservacionesAgenda;
    private javax.swing.JTextField txtProximaFecha;
    private javax.swing.JTextField txtTecnico;
    private javax.swing.JTextField txtTipoCliente;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
