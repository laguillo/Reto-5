
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

public class Conexion {

    //IMPORTANTE, ESTA BASE ES PUBLICA POR MEDIO DE INTERNET, EL PROGRMA ESTA LISTO PARA USAR
    /* String conString = "jdbc:mysql://192.254.189.137:3306/laguillo_reto5";
    String username = "laguillo_reto5";
    String password = "reto5"; */
    
    //BASE DE DATOS LOCAL
    String conString = "jdbc:mysql://localhost:3306/reto5";
    String username = "root";
    String password = "Brigard2113";

    //Fabricantes
    public Boolean addFabrica(String name) {
        //SQL STATEMENT
        String sql = "insert into fabricantes (fabricante) values (?)";

        try {
            //GET COONECTION
            Connection con = java.sql.DriverManager.getConnection(conString, username, password);
            // PREPARED STMT
            PreparedStatement s = con.prepareStatement(sql);
            s.setString(1, name);
            s.execute();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public DefaultTableModel getDataFabricas() {
        //ADD COLUMNS TO TABLE MODEL
        DefaultTableModel dm = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;//This causes all cells to be not editable
            }
        };

        dm.addColumn("Fabricantes");
        String sql = "SELECT * FROM fabricantes";

        try {
            Connection con = DriverManager.getConnection(conString, username, password);

            //PREPARED STMT
            PreparedStatement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery();

            //LOOP THRU GETTING ALL VALUES
            while (rs.next()) {
                //GET VALUES

                String name = rs.getString(1);
                dm.addRow(new String[]{name});

            }
            return dm;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;

    }
    public void getDataFabricas(JComboBox micb) {
        //ADD COLUMNS TO TABLE MODEL

        micb.removeAllItems();

        String sql = "SELECT * FROM fabricantes";

        try {
            Connection con = DriverManager.getConnection(conString, username, password);

            //PREPARED STMT
            PreparedStatement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery();

            //LOOP THRU GETTING ALL VALUES
            while (rs.next()) {
                //GET VALUES

                String name = rs.getString(1);
                micb.addItem(name);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    public Boolean deleteFabricas(String fabrica) {
        //SQL STMT
        String sql = "DELETE FROM fabricantes WHERE fabricante =?";

        try {
            //GET COONECTION
            Connection con = DriverManager.getConnection(conString, username, password);

            //STATEMENT
            PreparedStatement s = con.prepareStatement(sql);
            s.setString(1, fabrica);
            //EXECUTE
            s.execute();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public Boolean updateFabricas(String nombreantiguo, String nombreNuevo) {
        //SQL STMT
        String sql = "UPDATE fabricantes SET fabricante = ? WHERE fabricante= ? ";

        try {
            //GET COONECTION
            Connection con = DriverManager.getConnection(conString, username, password);

            //STATEMENT
            PreparedStatement s = con.prepareStatement(sql);
            s.setString(1, nombreNuevo);
            s.setString(2, nombreantiguo);

            //EXECUTE
            s.execute();

            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    //Clientes
    public Boolean addClientes(String fecha, String contrasena, String celular, String email, String apellido, String nombre, String alias) {
        //SQL STATEMENT
        String sql = "insert into clientes (clientes.fecha_nacimiento,"
                + "clientes.contrasena,"
                + "clientes.celular,"
                + "clientes.email,"
                + "clientes.apellido,"
                + "clientes.nombre,"
                + "clientes.alias) VALUES (?,?,?,?,?,?,?)";

        try {
            //GET COONECTION
            Connection con = java.sql.DriverManager.getConnection(conString, username, password);

            // PREPARED STMT
            PreparedStatement s = con.prepareStatement(sql);

            s.setDate(1, java.sql.Date.valueOf(fecha));
            s.setString(2, contrasena);
            s.setString(3, celular);
            s.setString(4, email);
            s.setString(5, apellido);
            s.setString(6, nombre);
            s.setString(7, alias);

            s.execute();
            JOptionPane.showMessageDialog(null, "Regstro agregado, actualice la lista de clientes.");
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo agregar \r\n" + ex.getMessage());
        }
        return false;
    }
    public DefaultTableModel getDataClientes() {
        //ADD COLUMNS TO TABLE MODEL
        DefaultTableModel dm = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;//This causes all cells to be not editable
            }
        };

        dm.addColumn("Alias");
        dm.addColumn("Nombre");
        dm.addColumn("Apellido");
        dm.addColumn("Email");
        dm.addColumn("Celular");
        dm.addColumn("Fecha de Nacimiento");

        String sql = "SELECT * FROM clientes";

        try {
            Connection con = DriverManager.getConnection(conString, username, password);

            //PREPARED STMT
            PreparedStatement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery();

            //LOOP THRU GETTING ALL VALUES
            while (rs.next()) {
                //GET VALUES

                dm.addRow(new String[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(7)});

            }
            return dm;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;

    }
    public Boolean deleteClientes(String alias) {

//SQL STMT
        String sql = "DELETE FROM clientes WHERE alias =?";

        try {
            //GET COONECTION
            Connection con = DriverManager.getConnection(conString, username, password);

            //STATEMENT
            PreparedStatement s = con.prepareStatement(sql);
            s.setString(1, alias);

            //EXECUTE
            s.execute();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public Boolean updateFClientes(String fecha, String contrasena, String celular, String email, String apellido, String nombre, String alias) {
        //SQL STATEMENT
        String sql = "update clientes set clientes.fecha_nacimiento = ?,"
                + "clientes.contrasena= ?,"
                + "clientes.celular= ?,"
                + "clientes.email= ?,"
                + "clientes.apellido= ?,"
                + "clientes.nombre= ? where "
                + "clientes.alias= ? ";

        try {
            //GET COONECTION
            Connection con = java.sql.DriverManager.getConnection(conString, username, password);

            // PREPARED STMT
            PreparedStatement s = con.prepareStatement(sql);

            s.setDate(1, java.sql.Date.valueOf(fecha));
            s.setString(2, contrasena);
            s.setString(3, celular);
            s.setString(4, email);
            s.setString(5, apellido);
            s.setString(6, nombre);
            s.setString(7, alias);

            s.execute();
            JOptionPane.showMessageDialog(null, "Regstro actualizado, actualice la lista de clientes.");
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo actualizar \r\n" + ex.getMessage());
        }
        return false;
    }

    //Proveedor
    public Boolean addProveedor(String prov_id, String prov_nombre, String prov_direccion, String prov_telefono) {
        //SQL STATEMENT
        String sql = "insert into proveedor (proveedor.prov_id, proveedor.prov_nombre, proveedor.prov_direccion, proveedor.prov_telefono) VALUES (?,?,?,?)";

        try {
            //GET COONECTION
            Connection con = java.sql.DriverManager.getConnection(conString, username, password);

            // PREPARED STMT
            PreparedStatement s = con.prepareStatement(sql);

            s.setInt(1, Integer.parseInt(prov_id));
            s.setString(2, prov_nombre);
            s.setString(3, prov_direccion);
            s.setString(4, prov_telefono);

            s.execute();
            JOptionPane.showMessageDialog(null, "Regstro agregado, actualice la lista de proveedores.");
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo agregar \r\n" + ex.getMessage());
        }
        return false;
    }
    public DefaultTableModel getDataProveedor() {
        //ADD COLUMNS TO TABLE MODEL
        DefaultTableModel dm = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;//This causes all cells to be not editable
            }
        };

        dm.addColumn("prov_id");
        dm.addColumn("prov_nombre");
        dm.addColumn("prov_direccion");
        dm.addColumn("prov_telefono");

        String sql = "SELECT * FROM proveedor";

        try {
            Connection con = DriverManager.getConnection(conString, username, password);

            //PREPARED STMT
            PreparedStatement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery();

            //LOOP THRU GETTING ALL VALUES
            while (rs.next()) {
                //GET VALUES

                dm.addRow(new String[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)});

            }
            return dm;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;

    }
    public void getDataProveedores(JComboBox micbProveedores) {
        //ADD COLUMNS TO TABLE MODEL

        micbProveedores.removeAllItems();

        String sql = "SELECT * FROM proveedor";

        try {
            Connection con = DriverManager.getConnection(conString, username, password);

            //PREPARED STMT
            PreparedStatement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery();

            //LOOP THRU GETTING ALL VALUES
            while (rs.next()) {
                //GET VALUES

                String value = rs.getString(1);
                String name = rs.getString(2);
                micbProveedores.addItem(new ObjetoComboBox(value, name));

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    public Boolean deleteProveedor(String prov_id) {

//SQL STMT
        String sql = "DELETE FROM proveedor WHERE prov_id =?";

        try {
            //GET COONECTION
            Connection con = DriverManager.getConnection(conString, username, password);

            //STATEMENT
            PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1, Integer.parseInt(prov_id));

            //EXECUTE
            s.execute();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public Boolean updateFProveedor(String prov_id, String prov_nombre, String prov_direccion, String prov_telefono) {
        //SQL STATEMENT
        String sql = "update proveedor set  proveedor.prov_nombre= ?, proveedor.prov_direccion= ?, proveedor.prov_telefono= ? where "
                + "prov_id = ? ";

        try {
            //GET COONECTION
            Connection con = java.sql.DriverManager.getConnection(conString, username, password);

            // PREPARED STMT
            PreparedStatement s = con.prepareStatement(sql);

            s.setString(1, prov_nombre);
            s.setString(2, prov_direccion);
            s.setString(3, prov_telefono);
            s.setInt(4, Integer.valueOf(prov_id));

            s.execute();
            JOptionPane.showMessageDialog(null, "Regstro actualizado, actualice la lista de proveedores.");
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo actualizar \r\n" + ex.getMessage());
        }
        return false;
    }

    //Bicicletas
    public Boolean addBicicletas(String fabricante, String precio_unit, String ano_fab) {
        //SQL STATEMENT
        String sql = "insert into bicicletas ( bicicletas.fabricante, bicicletas.precio_unit, bicicletas.ano_fab) VALUES (?,?,?)";

        try {
            //GET COONECTION
            Connection con = java.sql.DriverManager.getConnection(conString, username, password);

            // PREPARED STMT
            PreparedStatement s = con.prepareStatement(sql);

            s.setString(1, fabricante);
            s.setString(2, precio_unit);
            s.setString(3, ano_fab);

            s.execute();
            JOptionPane.showMessageDialog(null, "Regstro agregado, actualice la lista de bicicletas.");
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo agregar \r\n" + ex.getMessage());
        }
        return false;
    }
    public DefaultTableModel getDataBicicletas() {
        //ADD COLUMNS TO TABLE MODEL
        DefaultTableModel dm = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;//This causes all cells to be not editable
            }
        };

        dm.addColumn("Id");
        dm.addColumn("Fabricante");
        dm.addColumn("Precio Unidad");
        dm.addColumn("Año de Fabricación");

        String sql = "SELECT * FROM bicicletas";

        try {
            Connection con = DriverManager.getConnection(conString, username, password);

            //PREPARED STMT
            PreparedStatement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery();

            //LOOP THRU GETTING ALL VALUES
            while (rs.next()) {
                //GET VALUES

                dm.addRow(new String[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)});

            }
            return dm;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;

    }
    public Boolean deleteBicicletas(String prov_id) {

//SQL STMT
        String sql = "DELETE FROM bicicletas WHERE id =?";

        try {
            //GET COONECTION
            Connection con = DriverManager.getConnection(conString, username, password);

            //STATEMENT
            PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1, Integer.parseInt(prov_id));

            //EXECUTE
            s.execute();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public Boolean updateBicicletas(String id, String fabricante, String precio_unit, String ano_fab) {
        //SQL STATEMENT
        String sql = "update bicicletas set  bicicletas.fabricante= ?, bicicletas.precio_unit= ?, bicicletas.ano_fab= ? where "
                + "id = ? ";

        try {
            //GET COONECTION
            Connection con = java.sql.DriverManager.getConnection(conString, username, password);

            // PREPARED STMT
            PreparedStatement s = con.prepareStatement(sql);

            s.setString(1, fabricante);
            s.setString(2, precio_unit);
            s.setString(3, ano_fab);
            s.setInt(4, Integer.valueOf(id));

            s.execute();
            JOptionPane.showMessageDialog(null, "Registro actualizado, actualice la lista de bicicletas.");
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo actualizar \r\n" + ex.getMessage());
        }
        return false;
    }

    //Motocicletas
    public Boolean addMotocicletas(String fabricante, String precio_unit, String autonomia, String proveedor) {
        //SQL STATEMENT
        String sql = "insert into motos_elec ( motos_elec.fabricante, motos_elec.precio_unit, motos_elec.autonomia, motos_elec.proveedor) VALUES (?,?,?,?)";

        try {
            //GET COONECTION
            Connection con = java.sql.DriverManager.getConnection(conString, username, password);

            // PREPARED STMT
            PreparedStatement s = con.prepareStatement(sql);

            s.setString(1, fabricante);
            s.setString(2, precio_unit);
            s.setString(3, autonomia);
            s.setString(3, proveedor);

            s.execute();
            JOptionPane.showMessageDialog(null, "Regstro agregado, actualice la lista de Motocicletas.");
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo agregar \r\n" + ex.getMessage());
        }
        return false;
    }
    public DefaultTableModel getDataMotocicletas() {
        //ADD COLUMNS TO TABLE MODEL
        DefaultTableModel dm = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;//This causes all cells to be not editable
            }
        };

        dm.addColumn("Id");
        dm.addColumn("Fabricante");
        dm.addColumn("Precio Unidad");
        dm.addColumn("Autonomia");
        dm.addColumn("Proveedor");
        dm.addColumn("Proveedor_nombre");
        String sql = "SELECT motos_elec.*, proveedor.prov_nombre FROM motos_elec inner join proveedor on proveedor.prov_id = motos_elec.Proveedor  ";

        try {
            Connection con = DriverManager.getConnection(conString, username, password);

            //PREPARED STMT
            PreparedStatement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery();

            //LOOP THRU GETTING ALL VALUES
            while (rs.next()) {
                //GET VALUES
                dm.addRow(new String[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)});
            }
            return dm;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public Boolean deleteMotocicletas(String prov_id) {

//SQL STMT
        String sql = "DELETE FROM motos_elec WHERE id =?";

        try {
            //GET COONECTION
            Connection con = DriverManager.getConnection(conString, username, password);

            //STATEMENT
            PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1, Integer.parseInt(prov_id));

            //EXECUTE
            s.execute();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public Boolean updateMotocicletas(String id, String fabricante, String precio_unit, String autonomia, String proveedor) {
        //SQL STATEMENT
        String sql = "update motos_elec set  motos_elec.fabricante= ?, motos_elec.precio_unit= ?, motos_elec.autonomia= ?, motos_elec.proveedor=? where "
                + "id = ? ";

        try {
            //GET COONECTION
            Connection con = java.sql.DriverManager.getConnection(conString, username, password);

            // PREPARED STMT
            PreparedStatement s = con.prepareStatement(sql);

            s.setString(1, fabricante);
            s.setString(2, precio_unit);
            s.setString(3, autonomia);
            s.setString(4, proveedor);
            s.setString(5, id);
            s.execute();
            JOptionPane.showMessageDialog(null, "Registro actualizado, actualice la lista de Motocicletas.");
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo actualizar \r\n" + ex.getMessage());
        }
        return false;
    }

    //Consultas Punto 5
    public DefaultTableModel getDataConsulta(String sql) {
        //ADD COLUMNS TO TABLE MODEL
        DefaultTableModel dm = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;//This causes all cells to be not editable
            }
        };

        try {
            Connection con = DriverManager.getConnection(conString, username, password);

            //PREPARED STMT
            PreparedStatement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery();

            ResultSetMetaData meta = null;
            meta = rs.getMetaData();

            //get column names
            int colCount = meta.getColumnCount();

            for (int i = 1; i <= colCount; ++i) {
                dm.addColumn(meta.getColumnClassName(i)); // Or even rs.getObject()
            }
            Object[] row = new Object[colCount];

            //LOOP THRU GETTING ALL VALUES
            while (rs.next()) {
                //GET VALUES
                for (int i = 1; i <= colCount; ++i) {
                    row[i - 1] = rs.getString(i); // Or even rs.getObject()
                }
                dm.addRow(row);
            }
            return dm;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public DefaultTableModel getDataCompras() {
        //ADD COLUMNS TO TABLE MODEL
        DefaultTableModel dm = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;//This causes all cells to be not editable
            }
        };

        dm.addColumn("Id");
        dm.addColumn("Cliente");
        dm.addColumn("Fabricante");
        dm.addColumn("Fecha");
        String sql = "SELECT * FROM compras   ";

        try {
            Connection con = DriverManager.getConnection(conString, username, password);

            //PREPARED STMT
            PreparedStatement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery();

            //LOOP THRU GETTING ALL VALUES
            while (rs.next()) {
                //GET VALUES
                dm.addRow(new String[]{rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)});
            }
            return dm;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void getDataClientes(JComboBox CLientes) {
        //ADD COLUMNS TO TABLE MODEL
        CLientes.removeAllItems();
        String sql = "SELECT * FROM clientes";

        try {
            Connection con = DriverManager.getConnection(conString, username, password);

            //PREPARED STMT
            PreparedStatement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery();

            //LOOP THRU GETTING ALL VALUES
            while (rs.next()) {
                //GET VALUES
                CLientes.addItem(rs.getString(1));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public Boolean deleteCompras(String Compra_id) {

//SQL STMT
        String sql = "DELETE FROM compras WHERE id =?";

        try {
            //GET COONECTION
            Connection con = DriverManager.getConnection(conString, username, password);

            //STATEMENT
            PreparedStatement s = con.prepareStatement(sql);
            s.setInt(1, Integer.parseInt(Compra_id));

            //EXECUTE
            s.execute();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Boolean addCompras(String alias, String fabricante, String fecha) {
        //SQL STATEMENT
        String sql = "insert into compras ( alias, fabricante, fecha_hora) VALUES (?,?,?)";

        try {
            //GET COONECTION
            Connection con = java.sql.DriverManager.getConnection(conString, username, password);

            // PREPARED STMT
            PreparedStatement s = con.prepareStatement(sql);

            s.setString(1, alias);
            s.setString(2, fabricante);
            s.setString(3, fecha);

            s.execute();
            JOptionPane.showMessageDialog(null, "Regstro agregado, actualice la lista de bicicletas.");
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo agregar \r\n" + ex.getMessage());
        }
        return false;
    }

}
