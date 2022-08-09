public class ConsultasResultado extends javax.swing.JFrame {

    public ConsultasResultado() {

        initComponents();
        Actualizar();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaResultadoConsulta = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        CB_Item = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        Consultar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        LB_Consulta = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        LB_Definicion = new javax.swing.JTextArea();

        setTitle("Consultas");
        setLocationByPlatform(true);

        TablaResultadoConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane1.setViewportView(TablaResultadoConsulta);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Consultas Punto 5");

        CB_Item.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));

        jLabel2.setText("Consulta");

        Consultar.setText("Consultar");
        Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarActionPerformed(evt);
            }
        });

        LB_Consulta.setEditable(false);
        LB_Consulta.setColumns(20);
        LB_Consulta.setLineWrap(true);
        LB_Consulta.setRows(5);
        jScrollPane2.setViewportView(LB_Consulta);

        LB_Definicion.setEditable(false);
        LB_Definicion.setColumns(20);
        LB_Definicion.setLineWrap(true);
        LB_Definicion.setRows(5);
        jScrollPane3.setViewportView(LB_Definicion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12)
                        .addComponent(CB_Item, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Consultar))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(jLabel1)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                    .addGap(20, 20, 20)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CB_Item, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(Consultar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(103, 103, 103)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(306, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarActionPerformed
        // TODO add your handling code here:
        Actualizar();

    }//GEN-LAST:event_ConsultarActionPerformed

    public void Actualizar() {
        switch (CB_Item.getSelectedItem().toString()) {
                case "1":
                LB_Definicion.setText("1. Mostrar el nombre de los fabricantes de todas las bicicletas y motocicletas eléctricas ordenadas alfabéticamente.");
                LB_Consulta.setText("SELECT fabricante FROM fabricantes ORDER BY fabricante");
                TablaResultadoConsulta.setModel((new Conexion()).getDataConsulta("SELECT fabricante FROM fabricantes ORDER BY fabricante"));
                break;
            case "2":
                LB_Definicion.setText("2. Mostrar la información de las bicicletas (fabricante, precio unitario, año) que se han estrenado posteriormente al año 2019, ordenadas por Fabricante.");
                LB_Consulta.setText("SELECT fabricante, precio_unit, ano_fab FROM bicicletas WHERE ano_fab >= 2019 ORDER BY fabricante");
                TablaResultadoConsulta.setModel((new Conexion()).getDataConsulta("SELECT fabricante, precio_unit, ano_fab FROM bicicletas WHERE ano_fab >= 2019 ORDER BY fabricante"));
                break;
            case "3":
                LB_Definicion.setText("3. Mostrar los fabricantes de las motocicletas eléctricas donde Auteco les provee el motor.");
                LB_Consulta.setText("SELECT fabricante FROM motos_elec WHERE proveedor=101");
                TablaResultadoConsulta.setModel((new Conexion()).getDataConsulta("SELECT fabricante FROM motos_elec WHERE proveedor=101"));
                break;
            case "4":
                LB_Definicion.setText("4. Mostrar la información de las bicicletas y motocicletaseléctricas (solo los fabricantes) que ha visto un cliente con alias \"lucky\", ordenadas por fabricante.");
                LB_Consulta.setText("SELECT fabricante FROM compras WHERE alias=\"lucky\" ORDER BY fabricante");
                TablaResultadoConsulta.setModel((new Conexion()).getDataConsulta("SELECT fabricante FROM compras WHERE alias=\"lucky\" ORDER BY fabricante"));
                break;
            case "5":
                LB_Definicion.setText("5. Mostrar la información de los clientes (alias y nombre y apellidos) que tienen la intención de comprar la bicicleta \"Yeti\" ordenados alfabéticamente.");
                LB_Consulta.setText("SELECT c.alias, c.nombre, c.apellido FROM clientes c, compras p WHERE p.alias=c.alias AND p.fabricante=\"Yeti\" ORDER BY nombre");
                TablaResultadoConsulta.setModel((new Conexion()).getDataConsulta("SELECT c.alias, c.nombre, c.apellido FROM clientes c, compras p WHERE p.alias=c.alias AND p.fabricante=\"Yeti\" ORDER BY nombre"));
                break;
            case "6":
                LB_Definicion.setText("6. Mostrar cuantas bicicletas se han fabricado después del año 2019.");
                LB_Consulta.setText("SELECT COUNT(fabricante) FROM bicicletas WHERE ano_fab>=2019");
                TablaResultadoConsulta.setModel((new Conexion()).getDataConsulta("SELECT COUNT(fabricante) FROM bicicletas WHERE ano_fab>=2019"));
                break;

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_Item;
    private javax.swing.JButton Consultar;
    private javax.swing.JTextArea LB_Consulta;
    private javax.swing.JTextArea LB_Definicion;
    private javax.swing.JTable TablaResultadoConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
