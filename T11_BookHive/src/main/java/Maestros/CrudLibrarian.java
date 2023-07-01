package Maestros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Acceso.AccesoDB;
import Modelos.ModeloLibrarian;
import Plantilla.RowMapper;
import Plantilla.CRUD.CrudServiceSpec;

public class CrudLibrarian implements CrudServiceSpec<ModeloLibrarian>, RowMapper<ModeloLibrarian> {

    private final String SQL_SELECT_BASE = "SELECT id, first_name, last_name, identity_document, cellphone_librarian, states FROM librarian";
    private final String SQL_INSERT = "INSERT INTO librarian (id, first_name, last_name, identity_document, cellphone_librarian, states) VALUES (?, ?, ?, ?, ?, ?)";
    private final String SQL_UPDATE = "UPDATE librarian SET first_name = ?, last_name = ?, identity_document = ?, cellphone_librarian = ?, states = ? WHERE id = ?";
    private final String SQL_DELETE = "DELETE FROM librarian WHERE id = ?";


    /**
     * Mostrar toda la tabla librarian.
     */
    @Override
    public List<ModeloLibrarian> getAll() {
        // Variables
        Connection cn = null;
        List<ModeloLibrarian> lista = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ModeloLibrarian bean;
        // Proceso
        try {
            cn = AccesoDB.getConnection();
            pstm = cn.prepareStatement(SQL_SELECT_BASE);
            rs = pstm.executeQuery();
            while (rs.next()) {
                bean = mapRow(rs);
                lista.add(bean);
            }
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception e2) {
            }
        }
        return lista;
    }

    /**
     * Realiza la búsqueda por ID.
     */
    @Override
    public ModeloLibrarian getForId(String id) {
        // Variables
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ModeloLibrarian bean = null;
        String sql;
        // Proceso
        try {
            cn = AccesoDB.getConnection();
            sql = SQL_SELECT_BASE + " WHERE id=?";
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(id));
            rs = pstm.executeQuery();
            if (rs.next()) {
                bean = mapRow(rs);
            }
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception e2) {
            }
        }
        return bean;
    }

    /**
     * Realiza la búsqueda por apellido y nombre.
     */
    @Override
    public List<ModeloLibrarian> get(ModeloLibrarian bean) {
        // Variables
        Connection cn = null;
        List<ModeloLibrarian> lista = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ModeloLibrarian item;
        String sql;
        String last_name;
        String first_name;
        // Preparar los datos
        last_name = "%" + UtilService.setStringVacio(bean.getLast_name()) + "%";
        first_name = "%" + UtilService.setStringVacio(bean.getFirst_name()) + "%";
        // Proceso
        try {
            // Conexión
            cn = AccesoDB.getConnection();
            // Query
            sql = SQL_SELECT_BASE + " WHERE last_name LIKE ? AND first_name LIKE ? ";
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, last_name);
            pstm.setString(2, first_name);
            // Ejecución
            rs = pstm.executeQuery();
            // Recorrido de los registros
            while (rs.next()) {
                item = mapRow(rs);
                lista.add(item);
            }
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception e2) {
            }
        }
        return lista;
    }

    /**
     * Inserta un nuevo registro.
     */
    @Override
    public void insert(ModeloLibrarian bean) {
        // Variables
        Connection cn = null;
        PreparedStatement pstm = null;
        int filas;
        // Proceso
        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            pstm = cn.prepareStatement(SQL_INSERT);
            pstm.setInt(1, bean.getId());
            pstm.setString(2, bean.getFirst_name());
            pstm.setString(3, bean.getLast_name());
            pstm.setString(4, bean.getIdentity_document());
            pstm.setString(5, bean.getCellphone_librarian());
            pstm.setString(6, bean.getStates());
            filas = pstm.executeUpdate();
            pstm.close();
            if (filas != 1) {
                throw new SQLException("Error en la transacción.");
            }
            cn.commit();
        } catch (SQLException e) {
            try {
                cn.rollback();
            } catch (Exception e2) {
            }
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception e2) {
            }
        }
    }

    /**
     * Actualiza un registro existente.
     */
    @Override
    public void update(ModeloLibrarian bean) {
        // Variables
        Connection cn = null;
        PreparedStatement pstm = null;
        int filas;
        // Proceso
        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            pstm = cn.prepareStatement(SQL_UPDATE);
            pstm.setString(1, bean.getFirst_name());
            pstm.setString(2, bean.getLast_name());
            pstm.setString(3, bean.getIdentity_document());
            pstm.setString(4, bean.getCellphone_librarian());
            pstm.setString(5, bean.getStates());
            pstm.setInt(6, bean.getId());
            filas = pstm.executeUpdate();
            pstm.close();
            if (filas != 1) {
                throw new SQLException("Error en la transacción.");
            }
            cn.commit();
        } catch (SQLException e) {
            try {
                cn.rollback();
            } catch (Exception e2) {
            }
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception e2) {
            }
        }
    }

    /**
     * Elimina un registro existente.
     */
    @Override
    public void delete(String id) {
        // Variables
        Connection cn = null;
        PreparedStatement pstm = null;
        int filas;
        // Proceso
        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            pstm = cn.prepareStatement(SQL_DELETE);
            pstm.setInt(1, Integer.parseInt(id));
            filas = pstm.executeUpdate();
            pstm.close();
            if (filas != 1) {
                throw new SQLException("Error en la transacción.");
            }
            cn.commit();
        } catch (SQLException e) {
            try {
                cn.rollback();
            } catch (Exception e2) {
            }
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception e2) {
            }
        }
    }

    /**
     * Mapea el ResultSet a un objeto ModeloLibrarian.
     */
    @Override
    public ModeloLibrarian mapRow(ResultSet rs) throws SQLException {
        // Variables
        ModeloLibrarian bean = new ModeloLibrarian();
        // Proceso
        bean.setId(rs.getInt("id"));
        bean.setFirst_name(rs.getString("first_name"));
        bean.setLast_name(rs.getString("last_name"));
        bean.setIdentity_document(rs.getString("identity_document"));
        bean.setCellphone_librarian(rs.getString("cellphone_librarian"));
        bean.setStates(rs.getString("states"));
        // Retorna
        return bean;
    }

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
}
