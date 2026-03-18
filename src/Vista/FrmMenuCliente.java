/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
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
import Modelo.Ciudad;
import Modelo.Cliente;
import Modelo.Local;
import Modelo.Miles;
import Modelo.Municipio;
import Modelo.Servicio;
import Modelo.Usuario;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class FrmMenuCliente extends javax.swing.JFrame {

    /**
     * Creates new form FrmMenuCliente
     */
    String ciudadEditar, direccionActual;
    CtlLocal ctlLocal;
    CtlCliente ctlCliente;
    CtlServicio ctlServicio;
    CtlAgenda ctlAgenda;
    CtlUsuario ctlUsuario;

    public String usuarioIniciado;
    String vendedor, codigoEditar, fechaRefuerzoVieja, codigoViejo, fechaRealizoPeriocidad;

    public FrmMenuCliente() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Menu Cliente");
        this.setSize(new Dimension(1600, 720));
        setIconImage(getIconImage());
        ctlLocal = new CtlLocal();
        ctlCliente = new CtlCliente();
        ctlServicio = new CtlServicio();
        ctlAgenda = new CtlAgenda();
        ctlUsuario = new CtlUsuario();
        Inicio usuarioInicio = new Inicio();
        usuarioIniciado = usuarioInicio.usuarioIniciado;
        cargarCampos();
        llenarComboMunicipio();
        cargarCombo();
        generarCodigo();
        buscarVendedor();
    }

    @Override
    public Image getIconImage() {
        Image retImage = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("IMG/logo.jpg"));
        return retImage;
    }

    public void limiteSpinner() {

        int valor = 1;
        SpinnerNumberModel modelo = new SpinnerNumberModel();

        modelo.setMaximum(12);
        modelo.setMinimum(1);

        jsHora.setModel(modelo);
        jsHora.setValue(valor);

    }

    public void limpiarCamposServicio() {

        txtFactura.setText("");
        txtTecnico1.setText("");
        txtProximaFecha1.setText("");
        txtValor1.setText("");
        txtObservacion1.setText("");
        jcFechaRealizo.setCalendar(null);
        llenarCombo1();
        llenarCombo2();
        llenarCombo3();
        llenarCombo4();
        //txtHoraAgenda.setText("");
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
        cbTipoServicio.addItem("Inmunizacion");
        cbTipoServicio.addItem("Termonebulizacion");
        cbTipoServicio.addItem("Control + Termo");

    }

    public void llenarCombo2() {

        cbPeriocidad.removeAllItems();
        cbPeriocidad.addItem("Seleccione");
        cbPeriocidad.addItem("Quincenal");
        cbPeriocidad.addItem("Mensual");
        cbPeriocidad.addItem("Bimensual");
        cbPeriocidad.addItem("Trimestral");
        cbPeriocidad.addItem("Cuatrimestral");
        cbPeriocidad.addItem("Quinquemestral");
        cbPeriocidad.addItem("Semestral");
        cbPeriocidad.addItem("Anual");
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

    public void buscarVendedor() {

        Usuario usuario = ctlUsuario.buscarUsuario(usuarioIniciado);
        vendedor = usuario.getNombre();

    }

    public void llenarComboMunicipio() {

        ArrayList<Municipio> lista = ctlLocal.cargarMunicipio();

        jcDepartamento.removeAllItems();
        jcDepartamento.addItem("Seleccione");

        jcCiudad.removeAllItems();
        jcCiudad.addItem("Seleccione");

        for (Municipio municipio : lista) {

            jcDepartamento.addItem(municipio.getNombre());

        }

    }

    public void cargarCombo() {

        cbTipo.removeAllItems();
        cbTipo.addItem("Seleccione");
        cbTipo.addItem("Comercial");
        cbTipo.addItem("Residencial");
    }

    public void limpiarCamposCliente() {

        txtApellido.setText("");
        txtCodigo.setText("");
        txtNombre.setText("");
        txtCelular.setText("");
        txtCorreo.setText("");
        cargarCombo();

    }

    public void limpiarCampos() {

        txtNombreNegocio.setText("");
        txtDireccion.setText("");
        txtNit.setText("");
        txtEncargado.setText("");
        txtTelefonoEncargado.setText("");
        llenarComboMunicipio();

    }

    public void refrescarDatos(String codigo) {

        Cliente cliente = ctlCliente.buscarCliente(codigo);

        //llenar los campos de texto y combobox
        txtNombre.setText(cliente.getNombre());
        txtApellido.setText(cliente.getApellido());
        txtCelular.setText(cliente.getCelular());
        txtCodigo.setText(cliente.getCodigo());
        txtCorreo.setText(cliente.getCorreo());
        cbTipo.setSelectedItem(cliente.getTipo());

        listaLocales(txtCodigo.getText());

        txtCodigoCliente.setText(cliente.getCodigo());
        txtTipoCliente.setText(cliente.getTipo());
        txtNombreCliente.setText(cliente.getNombre());
        txtApellidoCliente.setText(cliente.getApellido());
        txtCorreoCliente.setText(cliente.getCorreo());
        txtCelularCliente.setText(cliente.getCelular());

    }

    public void cargarCampos() {

        int valor = 0;
        String codigo, ventanaEjecutada, fecha;
        Miles miles = new Miles();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        ventanaEjecutada = ctlServicio.ventanaEjecutada;

        if (ventanaEjecutada.equals("cliente")) {

            codigo = ctlServicio.codigoAlmacenado;

            Cliente cliente = ctlCliente.buscarCliente(codigo);

            //llenar los campos de texto y combobox
            txtNombre.setText(cliente.getNombre());
            txtApellido.setText(cliente.getApellido());
            txtCelular.setText(cliente.getCelular());
            txtCodigo.setText(cliente.getCodigo());
            txtCorreo.setText(cliente.getCorreo());
            cbTipo.setSelectedItem(cliente.getTipo());

            listaLocales(txtCodigo.getText());

            txtCodigoCliente.setText(cliente.getCodigo());
            txtTipoCliente.setText(cliente.getTipo());
            txtNombreCliente.setText(cliente.getNombre());
            txtApellidoCliente.setText(cliente.getApellido());
            txtCorreoCliente.setText(cliente.getCorreo());
            txtCelularCliente.setText(cliente.getCelular());

        } else {

            codigo = ctlServicio.facturaAlmacenada;
            DtoServicio dtoServicio = ctlServicio.buscarDtoServicio(codigo);

            //llenar los campos de texto y combobox
            txtNombre.setText(dtoServicio.getNombre());
            txtApellido.setText(dtoServicio.getApellido());
            txtCelular.setText(dtoServicio.getCelular());
            txtCodigo.setText(dtoServicio.getCodigo());
            txtCorreo.setText(dtoServicio.getCorreo());
            cbTipo.setSelectedItem(dtoServicio.getTipo());

            listaLocales(txtCodigo.getText());

            txtCodigoCliente.setText(dtoServicio.getCodigo());
            txtTipoCliente.setText(dtoServicio.getTipo());
            txtNombreCliente.setText(dtoServicio.getNombre());
            txtApellidoCliente.setText(dtoServicio.getApellido());
            txtCorreoCliente.setText(dtoServicio.getCorreo());
            txtCelularCliente.setText(dtoServicio.getCelular());

            codigoViejo = dtoServicio.getNroFactura();
            txtServicio.setText(dtoServicio.getNroFactura());
            cbTipoServicio1.setSelectedItem(dtoServicio.getTipoServicio());
            cbRefuerzo1.setSelectedItem(dtoServicio.getRefuerzo());
            txtProximaFecha.setText(dtoServicio.getProxFecha());
            cbPago1.setSelectedItem(dtoServicio.getPago());
            txtValor.setText(dtoServicio.getValor());
            txtObservacion.setText(dtoServicio.getObservacion());
            txtObsevacionAgenda.setText(dtoServicio.getaObservacion());
            txtTecnico.setText(dtoServicio.getTecnico());
            txtLlamadaCalidad.setText(dtoServicio.getCalidadLlamada());
            txtGestionLlamada.setText(dtoServicio.getGestionLlamada());
            cbPeriocidad1.setSelectedItem(dtoServicio.getPeriocidad());
            txtTiempoServicio.setText(dtoServicio.getTiempoServicio());

            fecha = dtoServicio.getFecha();
            try {
                jcFechaRealizo1.setDate(format.parse(fecha));
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }

            String[] separarTodo = dtoServicio.getAhora().split(":");

            if (separarTodo.length > 1) {
                String letra1, letra2, formato;
                letra1 = separarTodo[0];
                letra2 = separarTodo[1];

                int hora, min;

                hora = Integer.parseInt(letra1);

                jsHora1.setValue(hora);

                String[] separar = letra2.split(" ");

                if (separar.length > 1) {

                    min = Integer.parseInt(separar[0]);
                    formato = separar[1];

                    jsMinutos1.setValue(min);
                    jcFormato13.setSelectedItem(formato);

                } else {
                    System.out.println("nada");
                }

            } else {

                System.out.println("nada");

            }

        }

    }

    public void listaLocales(String codigo) {

        ArrayList<DTOLocal> lista = ctlLocal.listarLocalPorCliente(codigo);

        //lista gestionar cliente
        DefaultTableModel modelo = (DefaultTableModel) tbLocal.getModel();
        modelo.setRowCount(0);

        for (DTOLocal dTOLocal : lista) {

            modelo.addRow(new Object[]{dTOLocal.getNombreNegocio(), dTOLocal.getDireccion(),
                dTOLocal.getNit(), dTOLocal.getEncargado(), dTOLocal.getCelEncargado(),
                dTOLocal.getMunicipio(), dTOLocal.getCiudad()});

        }

        //lista historial servicio
        DefaultTableModel modelo1 = (DefaultTableModel) tbLocal1.getModel();
        modelo1.setRowCount(0);

        for (DTOLocal dTOLocal : lista) {

            modelo1.addRow(new Object[]{dTOLocal.getNombreNegocio(), dTOLocal.getDireccion(),
                dTOLocal.getNit(), dTOLocal.getEncargado(), dTOLocal.getCelEncargado(),
                dTOLocal.getMunicipio(), dTOLocal.getCiudad()});

        }

        //gestionar servicio
        DefaultTableModel modelo2 = (DefaultTableModel) tbLocal2.getModel();
        modelo2.setRowCount(0);

        for (DTOLocal dTOLocal : lista) {

            modelo2.addRow(new Object[]{dTOLocal.getNombreNegocio(), dTOLocal.getDireccion(),
                dTOLocal.getNit(), dTOLocal.getEncargado(), dTOLocal.getMunicipio(), dTOLocal.getCiudad()});

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

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        cbTipo = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtNombreNegocio = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtNit = new javax.swing.JTextField();
        txtEncargado = new javax.swing.JTextField();
        jcDepartamento = new javax.swing.JComboBox<>();
        jcCiudad = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbLocal = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel56 = new javax.swing.JLabel();
        txtTelefonoEncargado = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbServicios = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbLocal1 = new javax.swing.JTable();
        txtValor = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtTecnico = new javax.swing.JTextField();
        txtObservacion = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtProximaFecha = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtServicio = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        cbTipoServicio1 = new javax.swing.JComboBox<>();
        cbRefuerzo1 = new javax.swing.JComboBox<>();
        jcFechaRealizo1 = new com.toedter.calendar.JDateChooser();
        cbPeriocidad1 = new javax.swing.JComboBox<>();
        cbPago1 = new javax.swing.JComboBox<>();
        jLabel52 = new javax.swing.JLabel();
        txtObsevacionAgenda = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        txtLlamadaCalidad = new javax.swing.JTextField();
        txtTiempoServicio = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        txtGestionLlamada = new javax.swing.JTextField();
        jsHora1 = new javax.swing.JSpinner();
        jsMinutos1 = new javax.swing.JSpinner();
        jcFormato13 = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtCodigoCliente = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTipoCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtApellidoCliente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCorreoCliente = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCelularCliente = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtDireccionNegocio = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtNitNegocio = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtEncargadoNegocio = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtMunicipioNegocio = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txtCiudadNegocio = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        txtNombreNegocio1 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbLocal2 = new javax.swing.JTable();
        jLabel38 = new javax.swing.JLabel();
        txtFactura = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        cbTipoServicio = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        txtTecnico1 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        cbRefuerzo = new javax.swing.JComboBox<>();
        jLabel42 = new javax.swing.JLabel();
        jcFechaRealizo = new com.toedter.calendar.JDateChooser();
        jLabel43 = new javax.swing.JLabel();
        cbPeriocidad = new javax.swing.JComboBox<>();
        jLabel44 = new javax.swing.JLabel();
        txtProximaFecha1 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        cbPago = new javax.swing.JComboBox<>();
        jLabel46 = new javax.swing.JLabel();
        txtValor1 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        txtObservacion1 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        txtObservacionesAgenda = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jcRefuerzo = new com.toedter.calendar.JDateChooser();
        jButton8 = new javax.swing.JButton();
        BtnBuscar = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jsHora = new javax.swing.JSpinner();
        jsMinutos = new javax.swing.JSpinner();
        jLabel31 = new javax.swing.JLabel();
        jcFormato12 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Datos del cliente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Historial de Servicios");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Gestionar Servicio");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(213, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(252, 252, 252))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 190, 580));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Menu Del Cliente");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Codigo");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 23, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Tipo de Cliente");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 73, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Nombre");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 123, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Apellido");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 173, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Correo");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 223, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Celular");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 273, -1, -1));

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        jPanel3.add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 20, 150, -1));
        jPanel3.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 120, 150, -1));
        jPanel3.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 170, 150, -1));
        jPanel3.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 220, 150, -1));
        jPanel3.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 270, 150, -1));

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 70, 150, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Razon Social");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 23, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Direccion");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 73, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Nit");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 123, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Encargado");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 173, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Departamento");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 273, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Ciudad");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 23, -1, -1));
        jPanel3.add(txtNombreNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, 150, -1));
        jPanel3.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 70, 150, -1));
        jPanel3.add(txtNit, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 150, -1));
        jPanel3.add(txtEncargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 150, -1));

        jcDepartamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcDepartamento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcDepartamentoItemStateChanged(evt);
            }
        });
        jPanel3.add(jcDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, 150, -1));

        jcCiudad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(jcCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(765, 20, 150, -1));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("Editar Cliente");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 130, -1));

        tbLocal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Razon Social", "Direccion", "Nit", "Encargado", "Telefono Encargado", "Municipio", "Ciudad"
            }
        ));
        tbLocal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLocalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbLocal);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 1300, 240));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("Guardar Local");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 120, -1, -1));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setText("Editar Local");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(835, 120, -1, -1));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton7.setText("Eliminar Local");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 120, -1, -1));

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel56.setText("Telefono Encargado");
        jPanel3.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 223, -1, -1));
        jPanel3.add(txtTelefonoEncargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, 150, -1));

        jTabbedPane1.addTab("", jPanel3);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nro Servicio", "Tipo de servicio", "Refuerzo", "Tecnico", "Fecha de Realizo", "Periocidad", "Proxima fecha", "pago", "Valor", "observacion"
            }
        ));
        tbServicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbServiciosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbServicios);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 1340, 140));

        tbLocal1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Razon Social", "Direccion", "Nit", "Encargado", "Telefono Encargado", "Municipio", "Ciudad"
            }
        ));
        tbLocal1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLocal1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbLocal1);

        jPanel4.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1340, 110));
        jPanel4.add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 420, 170, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Refuerzo");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 423, -1, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Observacion");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 473, -1, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Pago");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 373, -1, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Proxima Fecha");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 323, -1, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Nro Servicio");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 323, -1, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("Tipo De Servicio");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 373, -1, -1));
        jPanel4.add(txtTecnico, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 320, 170, -1));
        jPanel4.add(txtObservacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 470, 170, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("Valor");
        jPanel4.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 423, -1, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("Tecnico");
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 323, -1, -1));
        jPanel4.add(txtProximaFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 320, 170, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("Hora");
        jPanel4.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 523, -1, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setText("Fecha de Realizo");
        jPanel4.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 473, -1, -1));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setText("Periocidad");
        jPanel4.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 523, -1, -1));
        jPanel4.add(txtServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 170, -1));

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton11.setText("Editar");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 320, -1, -1));

        cbTipoServicio1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Control Integral", "Desratizacion", "Lavado de Tanques", "Mantenimiento de cebaderos", "Refuerzo", "Garantia", "Seguimiento", "Trampa pegante", "Trampa de grasa", "Estaciones de Cebado", "Desinfeccion", "Inmunizacion", "Termonebulizacion", "Control + Termo" }));
        jPanel4.add(cbTipoServicio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 170, -1));

        cbRefuerzo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Si", "No" }));
        jPanel4.add(cbRefuerzo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, 170, -1));

        jcFechaRealizo1.setDateFormatString("yyyy-MM-dd");
        jcFechaRealizo1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jcFechaRealizo1PropertyChange(evt);
            }
        });
        jPanel4.add(jcFechaRealizo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, 170, -1));

        cbPeriocidad1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Quincenal", "Mensual", "Bimensual", "Trimestral", "Cuatrimestral", "Quinquemestral", "Semestral", "Anual", "Unica vez" }));
        cbPeriocidad1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbPeriocidad1ItemStateChanged(evt);
            }
        });
        jPanel4.add(cbPeriocidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 520, 170, -1));

        cbPago1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Pago", "Pendiente" }));
        jPanel4.add(cbPago1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 170, -1));

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel52.setText("Observacion(Agenda)");
        jPanel4.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 373, -1, -1));
        jPanel4.add(txtObsevacionAgenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 370, 170, -1));

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel53.setText("Llamada de calidad");
        jPanel4.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 423, -1, -1));

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel54.setText("Tiempo de Servicio");
        jPanel4.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 473, -1, -1));
        jPanel4.add(txtLlamadaCalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 420, 170, -1));
        jPanel4.add(txtTiempoServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 470, 170, -1));

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel55.setText("Gestion Llamada");
        jPanel4.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 523, -1, -1));
        jPanel4.add(txtGestionLlamada, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 520, 170, -1));

        jsHora1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsHora1StateChanged(evt);
            }
        });
        jPanel4.add(jsHora1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 520, 50, -1));

        jsMinutos1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsMinutos1StateChanged(evt);
            }
        });
        jPanel4.add(jsMinutos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 520, 50, -1));

        jcFormato13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));
        jPanel4.add(jcFormato13, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 520, -1, -1));

        jTabbedPane1.addTab("", jPanel4);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Codigo");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 23, -1, -1));

        txtCodigoCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoClienteKeyTyped(evt);
            }
        });
        jPanel5.add(txtCodigoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 150, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Tipo de Cliente");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 73, -1, -1));
        jPanel5.add(txtTipoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 150, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Nombre");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 123, -1, -1));
        jPanel5.add(txtNombreCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 150, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Apellido");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 173, -1, -1));
        jPanel5.add(txtApellidoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 150, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Correo");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 223, -1, -1));
        jPanel5.add(txtCorreoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 150, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Celular");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 273, -1, -1));
        jPanel5.add(txtCelularCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 150, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Direccion");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 73, -1, -1));
        jPanel5.add(txtDireccionNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 70, 150, -1));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setText("Nit");
        jPanel5.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 123, -1, -1));
        jPanel5.add(txtNitNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 120, 150, -1));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel34.setText("Encargado");
        jPanel5.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 173, -1, -1));
        jPanel5.add(txtEncargadoNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 170, 150, -1));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel35.setText("Departamento");
        jPanel5.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 223, -1, -1));
        jPanel5.add(txtMunicipioNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 220, 150, -1));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel36.setText("Ciudad");
        jPanel5.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 273, -1, -1));
        jPanel5.add(txtCiudadNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 270, 150, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel37.setText("Razon Social");
        jPanel5.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 23, -1, -1));
        jPanel5.add(txtNombreNegocio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 20, 150, -1));

        tbLocal2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Razon Social", "Direccion", "Nit", "Encargado", "Departamento", "Ciudad"
            }
        ));
        tbLocal2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLocal2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbLocal2);

        jPanel5.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 630, 110));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel38.setText("Nro Servicio");
        jPanel5.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 20, -1, -1));

        txtFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFacturaKeyTyped(evt);
            }
        });
        jPanel5.add(txtFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 160, -1));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel39.setText("Tipo de Servicio");
        jPanel5.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, -1, -1));

        cbTipoServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Control Integral", "Desratizacion", "Lavado de Tanques", "Mantenimiento de cebaderos", "Refuerzo", "Garantia", "Seguimiento", "Trampa pegante", "Trampa de grasa", "Estaciones de Cebado", "Desinfeccion", "Inmunizacion", "Termonebulizacion", "Control + Termo" }));
        jPanel5.add(cbTipoServicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 70, 160, -1));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel40.setText("Tecnico");
        jPanel5.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 120, -1, -1));
        jPanel5.add(txtTecnico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 120, 160, -1));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel41.setText("Refuerzo");
        jPanel5.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 170, -1, -1));

        cbRefuerzo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Si", "No" }));
        jPanel5.add(cbRefuerzo, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 170, 160, -1));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel42.setText("Fecha de Realizo");
        jPanel5.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 220, -1, -1));

        jcFechaRealizo.setDateFormatString("yyyy-MM-dd");
        jcFechaRealizo.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jcFechaRealizoInputMethodTextChanged(evt);
            }
        });
        jcFechaRealizo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jcFechaRealizoPropertyChange(evt);
            }
        });
        jPanel5.add(jcFechaRealizo, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 220, 160, -1));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel43.setText("Periocidad");
        jPanel5.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 270, -1, -1));

        cbPeriocidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Quincenal", "Mensual", "Bimensual", "Trimestral", "Cuatrimestral", "Quinquemestral", "Semestral", "Anual", "Unica vez" }));
        cbPeriocidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbPeriocidadItemStateChanged(evt);
            }
        });
        jPanel5.add(cbPeriocidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 270, 160, -1));

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel44.setText("Proxima Fecha");
        jPanel5.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 320, -1, -1));
        jPanel5.add(txtProximaFecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 320, 160, -1));

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel45.setText("Pago");
        jPanel5.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 370, -1, -1));

        cbPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Pago", "Pendiente" }));
        jPanel5.add(cbPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 370, 160, -1));

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel46.setText("Valor");
        jPanel5.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 420, -1, -1));

        txtValor1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtValor1KeyReleased(evt);
            }
        });
        jPanel5.add(txtValor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 420, 160, -1));

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel47.setText("Observacion");
        jPanel5.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 470, -1, -1));
        jPanel5.add(txtObservacion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 470, 160, -1));

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel51.setText("Fecha refuerzo");
        jPanel5.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 123, -1, -1));

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel48.setText("Hora");
        jPanel5.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 23, -1, -1));
        jPanel5.add(txtObservacionesAgenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 70, 160, -1));

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel50.setText("Observaciones");
        jPanel5.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 73, -1, -1));

        jcRefuerzo.setDateFormatString("yyyy-MM-dd");
        jPanel5.add(jcRefuerzo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 120, 160, -1));

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setText("Guardar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 173, -1, -1));

        BtnBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });
        jPanel5.add(BtnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 173, -1, -1));

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton9.setText("Editar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 173, -1, -1));

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton10.setText("Eliminar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 223, -1, -1));

        jsHora.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsHoraStateChanged(evt);
            }
        });
        jPanel5.add(jsHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 20, 50, -1));

        jsMinutos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jsMinutosStateChanged(evt);
            }
        });
        jPanel5.add(jsMinutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 20, 50, -1));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText(":");
        jPanel5.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(1205, 23, -1, -1));

        jcFormato12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));
        jPanel5.add(jcFormato12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 20, -1, -1));

        jTabbedPane1.addTab("", jPanel5);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 90, 1380, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtCodigoKeyTyped

    private void jcDepartamentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcDepartamentoItemStateChanged
        // TODO add your handling code here:

        String datoSeleccionado;

        if (evt.getStateChange() == ItemEvent.SELECTED) {

            datoSeleccionado = (String) evt.getItem();

            if (datoSeleccionado.equals("Seleccione")) {

            } else {

                jcCiudad.removeAllItems();
                jcCiudad.addItem("Seleccione");

                ArrayList<Ciudad> lista = ctlLocal.cargarCiudad(datoSeleccionado);

                for (Ciudad ciudad : lista) {

                    jcCiudad.addItem(ciudad.getNombre());

                }

            }
        }
    }//GEN-LAST:event_jcDepartamentoItemStateChanged

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

        String codigo, tipo, nombre, apellido, celular, correo;

        codigo = txtCodigo.getText();
        tipo = (String) cbTipo.getSelectedItem();
        nombre = txtNombre.getText();
        apellido = txtApellido.getText();
        celular = txtCelular.getText();
        correo = txtCorreo.getText();

        if (codigo.isEmpty() || tipo.equals("Seleccione") || nombre.isEmpty()
                || apellido.isEmpty()) {

            JOptionPane.showMessageDialog(null, "por favor llenar los datos");

        } else {

            try {

                Cliente cliente = new Cliente(0, codigo, tipo, nombre, apellido, celular, correo);
                ctlCliente.editarCliente(cliente);
                JOptionPane.showMessageDialog(null, "se ha editado correctamente");
                limpiarCampos();
                refrescarDatos(codigo);
                //buscarUltimoCodigo();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tbLocalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLocalMouseClicked
        // TODO add your handling code here:

        int seleccionar;

        seleccionar = tbLocal.rowAtPoint(evt.getPoint());

        txtNombreNegocio.setText(String.valueOf(tbLocal.getValueAt(seleccionar, 0)));
        txtDireccion.setText(String.valueOf(tbLocal.getValueAt(seleccionar, 1)));
        txtNit.setText(String.valueOf(tbLocal.getValueAt(seleccionar, 2)));
        txtEncargado.setText(String.valueOf(tbLocal.getValueAt(seleccionar, 3)));
        txtTelefonoEncargado.setText(String.valueOf(tbLocal.getValueAt(seleccionar, 4)));
        ciudadEditar = String.valueOf(tbLocal.getValueAt(seleccionar, 6));
        direccionActual = String.valueOf(tbLocal.getValueAt(seleccionar, 1));

        jcDepartamento.setSelectedItem(String.valueOf(tbLocal.getValueAt(seleccionar, 5)));
        jcCiudad.setSelectedItem(String.valueOf(tbLocal.getValueAt(seleccionar, 6)));
    }//GEN-LAST:event_tbLocalMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        String nombreNegocio, direccion, nit, encargado, codigo, ciudad, celEncargado;

        nombreNegocio = txtNombreNegocio.getText();
        direccion = txtDireccion.getText();
        nit = txtNit.getText();
        encargado = txtEncargado.getText();
        codigo = txtCodigo.getText();
        ciudad = (String) jcCiudad.getSelectedItem();
        celEncargado = txtTelefonoEncargado.getText();

        if (nombreNegocio.isEmpty() || direccion.isEmpty() || nit.isEmpty()
                || encargado.isEmpty() || codigo.isEmpty() || ciudad.equals("Seleccione")
                || celEncargado.isEmpty()) {

            JOptionPane.showMessageDialog(null, "porfavor llenar los "
                    + "datos del local que quiere registrar");
        } else {

            try {

                Local local = new Local(0, 0, 0, nombreNegocio,
                        direccion, nit, encargado, celEncargado);
                ctlLocal.guardarLocal(local, ciudad, codigo);
                JOptionPane.showMessageDialog(null, "se ha guardado correctamente");
                listaLocales(codigo);
                limpiarCampos();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:

        String nombreNegocio, direccion, nit, encargado, codigo, ciudad, celEncargado;

        nombreNegocio = txtNombreNegocio.getText();
        direccion = txtDireccion.getText();
        nit = txtNit.getText();
        encargado = txtEncargado.getText();
        codigo = txtCodigo.getText();
        ciudad = (String) jcCiudad.getSelectedItem();
        celEncargado = txtTelefonoEncargado.getText();

        if (nombreNegocio.isEmpty() || direccion.isEmpty() || nit.isEmpty()
                || encargado.isEmpty() || codigo.isEmpty() || ciudad.equals("Seleccione")) {

            JOptionPane.showMessageDialog(null, "porfavor llenar los "
                    + "datos del local que quiere registrar");
        } else {

            try {

                Local local = new Local(0, 0, 0, nombreNegocio, direccion,
                        nit, encargado, celEncargado);
                ctlLocal.editarLocal(local, ciudad, codigo, ciudadEditar, direccionActual);
                JOptionPane.showMessageDialog(null, "se ha editado correctamente");
                listaLocales(codigo);
                limpiarCampos();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:

        String direccion, ciudad, codigo;

        direccion = txtDireccion.getText();
        codigo = txtCodigo.getText();

        if (direccion.isEmpty()) {

            JOptionPane.showMessageDialog(null, "porfavor llenar los "
                    + "datos del local que quiere registrar");
        } else {

            ctlLocal.eliminarLocal(direccion, ciudadEditar);
            JOptionPane.showMessageDialog(null, "se ha editado correctamente");
            listaLocales(codigo);
            limpiarCampos();

        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void txtCodigoClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoClienteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoClienteKeyTyped

    private void tbLocal2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLocal2MouseClicked
        // TODO add your handling code here:

        int seleccionar;

        seleccionar = tbLocal2.rowAtPoint(evt.getPoint());

        txtNombreNegocio1.setText(String.valueOf(tbLocal2.getValueAt(seleccionar, 0)));
        txtDireccionNegocio.setText(String.valueOf(tbLocal2.getValueAt(seleccionar, 1)));
        txtNitNegocio.setText(String.valueOf(tbLocal2.getValueAt(seleccionar, 2)));
        txtEncargadoNegocio.setText(String.valueOf(tbLocal2.getValueAt(seleccionar, 3)));
        txtMunicipioNegocio.setText(String.valueOf(tbLocal2.getValueAt(seleccionar, 4)));
        txtCiudadNegocio.setText(String.valueOf(tbLocal2.getValueAt(seleccionar, 5)));
    }//GEN-LAST:event_tbLocal2MouseClicked

    private void txtFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFacturaKeyTyped
        // TODO add your handling code here:

        char enter = evt.getKeyChar();

        if (enter == KeyEvent.VK_ENTER) {

            BtnBuscar.doClick();

        }
    }//GEN-LAST:event_txtFacturaKeyTyped

    private void cbPeriocidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbPeriocidadItemStateChanged
        // TODO add your handling code here:

        String datoSeleccionado, proxFecha;

        if (evt.getStateChange() == ItemEvent.SELECTED) {

            datoSeleccionado = (String) evt.getItem();

            if (datoSeleccionado.equals("Seleccione") || fechaRealizoPeriocidad.isEmpty()) {

            } else {

                proxFecha = ctlServicio.proximaFecha(datoSeleccionado, fechaRealizoPeriocidad);

                txtProximaFecha1.setText(proxFecha);

            }
        }
    }//GEN-LAST:event_cbPeriocidadItemStateChanged

    private void txtValor1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValor1KeyReleased
        // TODO add your handling code here:

        Miles op = new Miles();

        if (!txtValor1.getText().isEmpty()) {

            double numero;
            String num = txtValor1.getText();
            String numeracion = num.replace(".", "");
            numero = Double.parseDouble(numeracion);
            txtValor1.setText(op.separarMiles(numero));

        } else {
            txtValor1.setText("");
        }
    }//GEN-LAST:event_txtValor1KeyReleased

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:

        int valor, h, m;
        String nroFactura, tipoServicio, refuerzo, tecnico, fecha, periocidad, proxFecha, pago,
                observacion, valorCadena, direccion, ciudad, fechaRefuerzo, hora, observaciones, codigo,
                formato;

        valorCadena = txtValor1.getText();
        nroFactura = txtFactura.getText();
        tipoServicio = (String) cbTipoServicio.getSelectedItem();
        refuerzo = (String) cbRefuerzo.getSelectedItem();
        tecnico = txtTecnico1.getText();
        fecha = ((JTextField) jcFechaRealizo.getDateEditor().getUiComponent()).getText();
        periocidad = (String) cbPeriocidad.getSelectedItem();
        proxFecha = txtProximaFecha1.getText();
        pago = (String) cbPago.getSelectedItem();
        observacion = txtObservacion1.getText();
        direccion = txtDireccionNegocio.getText();
        ciudad = txtCiudadNegocio.getText();
        observaciones = txtObservacionesAgenda.getText();
        codigo = txtCodigoCliente.getText();
        fechaRefuerzo = ((JTextField) jcRefuerzo.getDateEditor().getUiComponent()).getText();
        h = (int) jsHora.getValue();
        m = (int) jsMinutos.getValue();
        formato = (String) jcFormato12.getSelectedItem();

        if (valorCadena.isEmpty() || nroFactura.isEmpty() || tipoServicio.equals("Seleccione")
                || tecnico.isEmpty() || fecha.isEmpty() || periocidad.equals("Seleccione")
                || proxFecha.isEmpty() || pago.isEmpty() || observacion.isEmpty() || direccion.isEmpty()
                || ciudad.isEmpty() || refuerzo.equals("Seleccione")) {

            JOptionPane.showMessageDialog(null, "porfavor llenar los "
                    + "datos del servicio que quiere registrar");

        } else {

            try {

                if (refuerzo.equals("Si")) {

                    hora = h + ":" + m + " " + formato;
                    String num = valorCadena.replace(".", "");
                    valor = Integer.parseInt(num);

                    Servicio servicio = new Servicio(0, 0, valor, nroFactura, tipoServicio,
                            refuerzo, tecnico, fecha, periocidad, proxFecha, pago, vendedor, observacion,
                            "NA", "NA", "NA");

                    Agenda agenda = new Agenda(0, 0,
                            hora, observaciones, fecha);

                    Agenda agendaRefuerzo = new Agenda(0, 0,
                            hora, observacion, fechaRefuerzo);

                    ctlServicio.guardarServicio(servicio, direccion, ciudad, codigo);
                    ctlAgenda.guardarAgenda(agenda, nroFactura);
                    ctlAgenda.guardarAgenda(agendaRefuerzo, nroFactura);
                    JOptionPane.showMessageDialog(null, "se ha guardado correctamente");
                    limpiarCamposServicio();
                    generarCodigo();

                } else {

                    hora = h + ":" + m + " " + formato;
                    String num = valorCadena.replace(".", "");
                    valor = Integer.parseInt(num);

                    Servicio servicio = new Servicio(0, 0, valor, nroFactura, tipoServicio,
                            refuerzo, tecnico, fecha, periocidad, proxFecha, pago, vendedor, observacion,
                            "NA", "NA", "NA");

                    Agenda agenda = new Agenda(0, 0,
                            hora, observaciones, fecha);

                    ctlServicio.guardarServicio(servicio, direccion, ciudad, codigo);
                    ctlAgenda.guardarAgenda(agenda, nroFactura);
                    JOptionPane.showMessageDialog(null, "se ha guardado correctamente");
                    limpiarCamposServicio();
                    generarCodigo();
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }
    }//GEN-LAST:event_jButton8ActionPerformed

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
                    txtTecnico1.setText(dtoAgenda.getsTecnico());
                    txtProximaFecha1.setText(dtoAgenda.getsProxFecha());
                    txtValor1.setText(valor);
                    txtObservacion1.setText(dtoAgenda.getsObservacion());
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
                    txtNombreNegocio1.setText(dtoAgenda.getlNombreNegocio());
                    txtObservacion1.setText(dtoAgenda.getsObservacion());
                    txtTipoCliente.setText(dtoAgenda.getcTipo());
                    txtObservacionesAgenda.setText(dtoAgenda.getaObservacion());

                    String[] separarTodo = dtoAgenda.getaHora().split(":");

                    if (separarTodo.length > 1) {
                        String letra1, letra2, formato;
                        letra1 = separarTodo[0];
                        letra2 = separarTodo[1];

                        int hora, min;

                        hora = Integer.parseInt(letra1);

                        jsHora.setValue(hora);

                        String[] separar = letra2.split(" ");

                        if (separar.length > 1) {

                            min = Integer.parseInt(separar[0]);
                            formato = separar[1];

                            jsMinutos.setValue(min);
                            jcFormato12.setSelectedItem(formato);

                        } else {
                            System.out.println("nada");
                        }

                    } else {

                        System.out.println("nada");

                    }

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

                    codigoEditar = dtoAgenda.getcCodigo();

                } else {

                    valor1 = Integer.parseInt(dtoAgenda.getsValor());
                    valor = miles.separarMiles(valor1);

                    txtFactura.setText(dtoAgenda.getsNroFactura());
                    txtTecnico1.setText(dtoAgenda.getsTecnico());
                    txtProximaFecha1.setText(dtoAgenda.getsProxFecha());
                    txtValor1.setText(valor);
                    txtObservacion1.setText(dtoAgenda.getsObservacion());
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
                    txtNombreNegocio1.setText(dtoAgenda.getlNombreNegocio());
                    txtObservacion1.setText(dtoAgenda.getsObservacion());
                    txtTipoCliente.setText(dtoAgenda.getcTipo());
                    txtObservacionesAgenda.setText(dtoAgenda.getaObservacion());

                    String[] separarTodo = dtoAgenda.getaHora().split(":");

                    if (separarTodo.length > 1) {
                        String letra1, letra2, formato;
                        letra1 = separarTodo[0];
                        letra2 = separarTodo[1];

                        int hora, min;

                        hora = Integer.parseInt(letra1);

                        jsHora.setValue(hora);

                        String[] separar = letra2.split(" ");

                        if (separar.length > 1) {

                            min = Integer.parseInt(separar[0]);
                            formato = separar[1];

                            jsMinutos.setValue(min);
                            jcFormato12.setSelectedItem(formato);

                        } else {
                            System.out.println("nada");
                        }

                    } else {

                        System.out.println("nada");

                    }

                    fecha1 = dtoAgenda.getsFecha();
                    fecha = format.parse(fecha1);
                    jcFechaRealizo.setDate(fecha);

                    cbPeriocidad.setSelectedItem(dtoAgenda.getsPeriocidad());
                    cbTipoServicio.setSelectedItem(dtoAgenda.getsTipoServicio());
                    cbPago.setSelectedItem(dtoAgenda.getsPago());
                    cbRefuerzo.setSelectedItem(dtoAgenda.getsRefuerzo());

                    codigoEditar = dtoAgenda.getcCodigo();

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }
    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:

        int valor, h, m;
        String nroFactura, tipoServicio, refuerzo, tecnico, fecha, periocidad, proxFecha, pago,
                observacion, valorCadena, direccion, ciudad, fechaRefuerzo, hora, observaciones, codigo,
                formato;

        valorCadena = txtValor1.getText();
        nroFactura = txtFactura.getText();
        tipoServicio = (String) cbTipoServicio.getSelectedItem();
        refuerzo = (String) cbRefuerzo.getSelectedItem();
        tecnico = txtTecnico1.getText();
        fecha = ((JTextField) jcFechaRealizo.getDateEditor().getUiComponent()).getText();
        periocidad = (String) cbPeriocidad.getSelectedItem();
        proxFecha = txtProximaFecha1.getText();
        pago = (String) cbPago.getSelectedItem();
        observacion = txtObservacion1.getText();
        direccion = txtDireccionNegocio.getText();
        ciudad = txtCiudadNegocio.getText();
        observaciones = txtObservacionesAgenda.getText();
        fechaRefuerzo = ((JTextField) jcRefuerzo.getDateEditor().getUiComponent()).getText();
        codigo = txtCodigoCliente.getText();
        h = (int) jsHora.getValue();
        m = (int) jsMinutos.getValue();
        formato = (String) jcFormato12.getSelectedItem();

        if (valorCadena.isEmpty() || nroFactura.isEmpty() || tipoServicio.equals("Seleccione")
                || tecnico.isEmpty() || fecha.isEmpty() || periocidad.equals("Seleccione")
                || proxFecha.isEmpty() || pago.isEmpty() || observacion.isEmpty() || direccion.isEmpty()
                || ciudad.isEmpty() || refuerzo.equals("Seleccione")) {

            JOptionPane.showMessageDialog(null, "porfavor llenar los "
                    + "datos del servicio que quiere registrar");

        } else {

            try {

                if (refuerzo.equals("Si")) {

                    hora = h + ":" + m + " " + formato;
                    String num = valorCadena.replace(".", "");
                    valor = Integer.parseInt(num);

                    Servicio servicio = new Servicio(0, 0, valor, nroFactura, tipoServicio,
                            refuerzo, tecnico, fecha, periocidad, proxFecha, pago, vendedor, observacion,
                            "NA", "NA", "NA");

                    Agenda agenda = new Agenda(0, 0,
                            hora, observaciones, fechaRefuerzo);

                    ctlServicio.editarServicio(servicio, direccion, ciudad, codigoEditar, codigo);
                    ctlAgenda.edtarAgendaRefuerzo(agenda, nroFactura, fechaRefuerzoVieja);
                    JOptionPane.showMessageDialog(null, "se ha editado correctamente");
                    limpiarCamposServicio();
                    generarCodigo();

                } else {

                    hora = h + ":" + m + " " + formato;
                    String num = valorCadena.replace(".", "");
                    valor = Integer.parseInt(num);

                    Servicio servicio = new Servicio(0, 0, valor, nroFactura, tipoServicio,
                            refuerzo, tecnico, fecha, periocidad, proxFecha, pago, vendedor, observacion,
                            "NA", "NA", "NA");

                    Agenda agenda = new Agenda(0, 0,
                            hora, observaciones, fecha);

                    ctlServicio.editarServicio(servicio, direccion, ciudad, codigoEditar, codigo);
                    ctlAgenda.edtarAgenda(agenda, nroFactura);
                    JOptionPane.showMessageDialog(null, "se ha editado correctamente");
                    limpiarCamposServicio();
                    generarCodigo();
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
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
                    limpiarCamposServicio();

                } else {

                    String fecha = ((JTextField) jcFechaRealizo.getDateEditor().getUiComponent()).getText();
                    ctlAgenda.eliminarAgenda(nroFactura, fecha);
                    ctlServicio.eliminarServicio(nroFactura);
                    JOptionPane.showMessageDialog(null, "se ha eliminado correctamente");
                    limpiarCamposServicio();

                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jcFechaRealizoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jcFechaRealizoPropertyChange
        // TODO add your handling code here:

        Date enviarFecha;
        String fecha, refuerzo, periocidad;

        if (evt.getNewValue() != null) {

            fecha = ((JTextField) jcFechaRealizo.getDateEditor().getUiComponent()).getText();

            if (fecha.isEmpty()) {

            } else {

                refuerzo = (String) cbRefuerzo.getSelectedItem();

                if (refuerzo.equals("Si")) {

                    fechaRealizoPeriocidad = ((JTextField) jcFechaRealizo.getDateEditor().getUiComponent()).getText();

                    DateTimeFormatter format = new DateTimeFormatterBuilder().append(DateTimeFormatter.ofPattern("yyyy-MM-dd")).toFormatter();

                    LocalDate fecha_I = LocalDate.parse(fecha, format);

                    fecha_I = fecha_I.plusDays(20);

                    refuerzo = fecha_I + "";

                    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");

                    try {

                        enviarFecha = format1.parse(refuerzo);
                        jcRefuerzo.setDate(enviarFecha);

                        periocidad = (String) cbPeriocidad.getSelectedItem();

                        if (periocidad.equals("Seleccione")) {

                        } else {

                            txtProximaFecha1.setText(ctlServicio.proximaFecha(periocidad, fechaRealizoPeriocidad));
                        }

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                } else {

                    fechaRealizoPeriocidad = ((JTextField) jcFechaRealizo.getDateEditor().getUiComponent()).getText();

                    periocidad = (String) cbPeriocidad.getSelectedItem();

                    if (periocidad.equals("Seleccione")) {

                    } else {

                        txtProximaFecha1.setText(ctlServicio.proximaFecha(periocidad, fechaRealizoPeriocidad));
                    }

                    fechaRealizoPeriocidad = ((JTextField) jcFechaRealizo.getDateEditor().getUiComponent()).getText();
                    jcRefuerzo.setDate(null);

                }

            }
        }
    }//GEN-LAST:event_jcFechaRealizoPropertyChange

    private void jcFechaRealizoInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jcFechaRealizoInputMethodTextChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_jcFechaRealizoInputMethodTextChanged

    private void cbPeriocidad1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbPeriocidad1ItemStateChanged
        // TODO add your handling code here:

        String datoSeleccionado, fecha, proxFecha;

        fecha = ((JTextField) jcFechaRealizo1.getDateEditor().getUiComponent()).getText();

        if (evt.getStateChange() == ItemEvent.SELECTED) {

            datoSeleccionado = (String) evt.getItem();

            if (datoSeleccionado.equals("Seleccione") || fecha.isEmpty()) {

            } else {

                proxFecha = ctlServicio.proximaFecha(datoSeleccionado, fecha);

                txtProximaFecha.setText(proxFecha);

            }
        }
    }//GEN-LAST:event_cbPeriocidad1ItemStateChanged

    private void jcFechaRealizo1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jcFechaRealizo1PropertyChange
        // TODO add your handling code here:

        Date enviarFecha;
        String fecha, refuerzo, periocidad;

        if (evt.getNewValue() != null) {

            fecha = ((JTextField) jcFechaRealizo1.getDateEditor().getUiComponent()).getText();

            if (fecha.isEmpty()) {

            } else {

                refuerzo = (String) cbRefuerzo1.getSelectedItem();

                if (refuerzo.equals("Si")) {

                    fechaRealizoPeriocidad = ((JTextField) jcFechaRealizo1.getDateEditor().getUiComponent()).getText();

                    try {

                        periocidad = (String) cbPeriocidad1.getSelectedItem();

                        if (periocidad.equals("Seleccione")) {

                        } else {

                            txtProximaFecha.setText(ctlServicio.proximaFecha(periocidad, fechaRealizoPeriocidad));
                        }

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                } else {

                    fechaRealizoPeriocidad = ((JTextField) jcFechaRealizo1.getDateEditor().getUiComponent()).getText();

                    periocidad = (String) cbPeriocidad1.getSelectedItem();

                    if (periocidad.equals("Seleccione")) {

                    } else {

                        txtProximaFecha.setText(ctlServicio.proximaFecha(periocidad, fechaRealizoPeriocidad));
                    }

                    fechaRealizoPeriocidad = ((JTextField) jcFechaRealizo1.getDateEditor().getUiComponent()).getText();
                    jcRefuerzo.setDate(null);

                }

            }
        }
    }//GEN-LAST:event_jcFechaRealizo1PropertyChange

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:

        int valor, h, m;
        String nroFactura, tipoServicio, refuerzo, tecnico, fecha, periocidad, proxFecha, pago,
                observacion, valorCadena, hora, observaciones, calidadLlamada,
                tiempoServicio, gestionLlamada, formato;

        valorCadena = txtValor.getText();
        nroFactura = txtServicio.getText();
        tipoServicio = (String) cbTipoServicio1.getSelectedItem();
        refuerzo = (String) cbRefuerzo1.getSelectedItem();
        tecnico = txtTecnico.getText();
        fecha = ((JTextField) jcFechaRealizo1.getDateEditor().getUiComponent()).getText();
        periocidad = (String) cbPeriocidad1.getSelectedItem();
        proxFecha = txtProximaFecha.getText();
        pago = (String) cbPago1.getSelectedItem();
        observacion = txtObservacion.getText();
        observaciones = txtObsevacionAgenda.getText();
        calidadLlamada = txtLlamadaCalidad.getText();
        tiempoServicio = txtTiempoServicio.getText();
        gestionLlamada = txtGestionLlamada.getText();
        h = (int) jsHora1.getValue();
        m = (int) jsMinutos1.getValue();
        formato = (String) jcFormato13.getSelectedItem();

        if (valorCadena.isEmpty() || nroFactura.isEmpty() || tipoServicio.equals("Seleccione")
                || refuerzo.equals("Seleccione") || tecnico.isEmpty() || fecha.isEmpty()
                || periocidad.equals("Selecione") || proxFecha.isEmpty()
                || pago.equals("Seleccione") || observacion.isEmpty()
                || observaciones.isEmpty() || calidadLlamada.isEmpty()
                || tiempoServicio.isEmpty() || gestionLlamada.isEmpty()) {

            JOptionPane.showMessageDialog(null, "por favor llene los campos");

        } else {

            hora = h + ":" + m + " " + formato;
            String num = valorCadena.replace(".", "");
            valor = Integer.parseInt(num);

            Servicio servicio = new Servicio(0, 0, valor, nroFactura, tipoServicio,
                    refuerzo, tecnico, fecha, periocidad, proxFecha, pago, vendedor, observacion,
                    calidadLlamada, tiempoServicio, gestionLlamada);

            Agenda agenda = new Agenda(0, 0,
                    hora, observaciones, fecha);

            ctlServicio.editarServicioHistorial(servicio, codigoViejo);
            ctlAgenda.edtarAgenda(agenda, nroFactura);
            JOptionPane.showMessageDialog(null, "se ha editado correctamente");
            limpiarCamposServicio();
            generarCodigo();

        }

    }//GEN-LAST:event_jButton11ActionPerformed

    private void tbLocal1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLocal1MouseClicked
        // TODO add your handling code here:

        int seleccionar, valor;
        String direccion;
        Miles miles = new Miles();

        seleccionar = tbLocal.rowAtPoint(evt.getPoint());

        direccion = String.valueOf(tbLocal1.getValueAt(seleccionar, 1));

        ArrayList<DtoServicio> servicios = ctlServicio.listarServicios(txtCodigo.getText(), direccion);

        DefaultTableModel modelo = (DefaultTableModel) tbServicios.getModel();
        modelo.setRowCount(0);

        for (DtoServicio servicio : servicios) {

            valor = Integer.parseInt(servicio.getValor());

            modelo.addRow(new Object[]{servicio.getNroFactura(), servicio.getTipoServicio(),
                servicio.getRefuerzo(), servicio.getTecnico(), servicio.getFecha(),
                servicio.getPeriocidad(), servicio.getProxFecha(), servicio.getPago(),
                miles.separarMiles(valor), servicio.getObservacion()});

        }
    }//GEN-LAST:event_tbLocal1MouseClicked

    private void tbServiciosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbServiciosMouseClicked
        // TODO add your handling code here:

        int seleccionar, valor;
        String nroServicio, fecha1, fecha;
        Miles miles = new Miles();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        seleccionar = tbServicios.rowAtPoint(evt.getPoint());

        nroServicio = String.valueOf(tbServicios.getValueAt(seleccionar, 0));

        DtoServicio dtoServicio = ctlServicio.buscarDtoServicio(nroServicio);

        codigoViejo = dtoServicio.getNroFactura();

        txtServicio.setText(dtoServicio.getNroFactura());
        cbTipoServicio1.setSelectedItem(dtoServicio.getTipoServicio());
        cbRefuerzo1.setSelectedItem(dtoServicio.getRefuerzo());
        cbPeriocidad1.setSelectedItem(dtoServicio.getPeriocidad());
        txtProximaFecha.setText(dtoServicio.getProxFecha());
        cbPago1.setSelectedItem(dtoServicio.getPago());
        txtObservacion.setText(dtoServicio.getObservacion());
        txtObsevacionAgenda.setText(dtoServicio.getaObservacion());
        txtTecnico.setText(dtoServicio.getTecnico());
        txtTiempoServicio.setText(dtoServicio.getTiempoServicio());
        txtLlamadaCalidad.setText(dtoServicio.getCalidadLlamada());
        txtGestionLlamada.setText(dtoServicio.getGestionLlamada());
        txtCelularCliente.setText(dtoServicio.getCelEncargado());

        fecha1 = dtoServicio.getFecha();
        try {
            jcFechaRealizo1.setDate(format.parse(fecha1));
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }

        valor = Integer.parseInt(dtoServicio.getValor());

        txtValor.setText(miles.separarMiles(valor));
        String[] separarTodo = dtoServicio.getAhora().split(":");

        if (separarTodo.length > 1) {
            String letra1, letra2, formato;
            letra1 = separarTodo[0];
            letra2 = separarTodo[1];

            int hora, min;

            hora = Integer.parseInt(letra1);

            jsHora1.setValue(hora);

            String[] separar = letra2.split(" ");

            if (separar.length > 1) {

                min = Integer.parseInt(separar[0]);
                formato = separar[1];

                jsMinutos1.setValue(min);
                jcFormato13.setSelectedItem(formato);

            } else {
                System.out.println("nada");
            }

        } else {

            System.out.println("nada");

        }
    }//GEN-LAST:event_tbServiciosMouseClicked

    private void jsHoraStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsHoraStateChanged
        // TODO add your handling code here:

        int valor = (int) jsHora.getValue();

        if (valor < 1) {
            jsHora.setValue(1);

        }

        if (valor > 12) {
            jsHora.setValue(12);

        }
    }//GEN-LAST:event_jsHoraStateChanged

    private void jsMinutosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsMinutosStateChanged
        // TODO add your handling code here:

        int valor = (int) jsMinutos.getValue();

        if (valor < 0) {
            jsMinutos.setValue(0);

        }

        if (valor > 59) {
            jsMinutos.setValue(59);

        }
    }//GEN-LAST:event_jsMinutosStateChanged

    private void jsHora1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsHora1StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jsHora1StateChanged

    private void jsMinutos1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jsMinutos1StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jsMinutos1StateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenuCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JComboBox<String> cbPago;
    private javax.swing.JComboBox<String> cbPago1;
    private javax.swing.JComboBox<String> cbPeriocidad;
    private javax.swing.JComboBox<String> cbPeriocidad1;
    private javax.swing.JComboBox<String> cbRefuerzo;
    private javax.swing.JComboBox<String> cbRefuerzo1;
    private javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JComboBox<String> cbTipoServicio;
    private javax.swing.JComboBox<String> cbTipoServicio1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
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
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> jcCiudad;
    private javax.swing.JComboBox<String> jcDepartamento;
    private com.toedter.calendar.JDateChooser jcFechaRealizo;
    private com.toedter.calendar.JDateChooser jcFechaRealizo1;
    private javax.swing.JComboBox<String> jcFormato12;
    private javax.swing.JComboBox<String> jcFormato13;
    private com.toedter.calendar.JDateChooser jcRefuerzo;
    private javax.swing.JSpinner jsHora;
    private javax.swing.JSpinner jsHora1;
    private javax.swing.JSpinner jsMinutos;
    private javax.swing.JSpinner jsMinutos1;
    private javax.swing.JTable tbLocal;
    private javax.swing.JTable tbLocal1;
    private javax.swing.JTable tbLocal2;
    private javax.swing.JTable tbServicios;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtApellidoCliente;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCelularCliente;
    private javax.swing.JTextField txtCiudadNegocio;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoCliente;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtCorreoCliente;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDireccionNegocio;
    private javax.swing.JTextField txtEncargado;
    private javax.swing.JTextField txtEncargadoNegocio;
    private javax.swing.JTextField txtFactura;
    private javax.swing.JTextField txtGestionLlamada;
    private javax.swing.JTextField txtLlamadaCalidad;
    private javax.swing.JTextField txtMunicipioNegocio;
    private javax.swing.JTextField txtNit;
    private javax.swing.JTextField txtNitNegocio;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreCliente;
    private javax.swing.JTextField txtNombreNegocio;
    private javax.swing.JTextField txtNombreNegocio1;
    private javax.swing.JTextField txtObservacion;
    private javax.swing.JTextField txtObservacion1;
    private javax.swing.JTextField txtObservacionesAgenda;
    private javax.swing.JTextField txtObsevacionAgenda;
    private javax.swing.JTextField txtProximaFecha;
    private javax.swing.JTextField txtProximaFecha1;
    private javax.swing.JTextField txtServicio;
    private javax.swing.JTextField txtTecnico;
    private javax.swing.JTextField txtTecnico1;
    private javax.swing.JTextField txtTelefonoEncargado;
    private javax.swing.JTextField txtTiempoServicio;
    private javax.swing.JTextField txtTipoCliente;
    private javax.swing.JTextField txtValor;
    private javax.swing.JTextField txtValor1;
    // End of variables declaration//GEN-END:variables

}
