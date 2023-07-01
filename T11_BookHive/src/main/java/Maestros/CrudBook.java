package Maestros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Acceso.AccesoDB;
import Modelos.ModeloBook;
import Plantilla.RowMapper;
import Plantilla.CRUD.CrudServiceSpec;

public class CrudBook implements CrudServiceSpec<ModeloBook>, RowMapper<ModeloBook> {

    private final String SQL_SELECT_BASE = "SELECT id, names, author, descriptions, quantity, states FROM book";
    private final String SQL_INSERT = "INSERT INTO book (id, names, author, descriptions, quantity, states) VALUES (?, ?, ?, ?, ?, ?)";
    private final String SQL_UPDATE = "UPDATE book SET names = ?, author = ?, descriptions = ?, quantity = ?, states = ? WHERE id = ?";
    private final String SQL_DELETE = "DELETE FROM book WHERE id = ?";

    
    /**
     * Mostrar toda la tabla book.
     */
    @Override
    public List<ModeloBook> getAll() {
        // Variables
        Connection cn = null;
        List<ModeloBook> lista = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ModeloBook bean;
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
    public ModeloBook getForId(String id) {
        // Variables
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ModeloBook bean = null;
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
     * Realiza la búsqueda por nombre del libro.
     */
    @Override
    public List<ModeloBook> get(ModeloBook bean) {
        // Variables
        Connection cn = null;
        List<ModeloBook> lista = new ArrayList<>();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ModeloBook item;
        String sql;
        String names;
        // Preparar los datos
        names = "%" + UtilService.setStringVacio(bean.getNames()) + "%";
        // Proceso
        try {
            // Conexión
            cn = AccesoDB.getConnection();
            // Query
            sql = SQL_SELECT_BASE + " WHERE names LIKE ?";
            pstm = cn.prepareStatement(sql);
            pstm.setString(1, names);
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
    public void insert(ModeloBook bean) {
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
            pstm.setString(2, bean.getNames());
            pstm.setString(3, bean.getAuthor());
            pstm.setString(4, bean.getDescriptions());
            pstm.setInt(5, bean.getQuantity());
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
    public void update(ModeloBook bean) {
        // Variables
        Connection cn = null;
        PreparedStatement pstm = null;
        int filas;
        // Proceso
        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            pstm = cn.prepareStatement(SQL_UPDATE);
            pstm.setString(1, bean.getNames());
            pstm.setString(2, bean.getAuthor());
            pstm.setString(3, bean.getDescriptions());
            pstm.setInt(4, bean.getQuantity());
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
     * Mapea el ResultSet a un objeto ModeloBook.
     */
    @Override
    public ModeloBook mapRow(ResultSet rs) throws SQLException {
        // Variables
        ModeloBook bean = new ModeloBook();
        // Proceso
        bean.setId(rs.getInt("id"));
        bean.setNames(rs.getString("names"));
        bean.setAuthor(rs.getString("author"));
        bean.setDescriptions(rs.getString("descriptions"));
        bean.setQuantity(rs.getInt("quantity"));
        bean.setStates(rs.getString("states"));
        // Retorna
        return bean;
    }

	public void setId(int parseInt) {
		// TODO Auto-generated method stub
		
	}

	public void setNames(String parameter) {
		// TODO Auto-generated method stub
		
	}

	public void setAuthor(String parameter) {
		// TODO Auto-generated method stub
		
	}

	public void setDescriptions(String parameter) {
		// TODO Auto-generated method stub
		
	}

	public void setQuantity(int parseInt) {
		// TODO Auto-generated method stub
		
	}

	public void setStates(String parameter) {
		// TODO Auto-generated method stub
		
	}

	public void insert(CrudBook bean) {
		// TODO Auto-generated method stub
		
	}

	public void update(CrudBook bean) {
		// TODO Auto-generated method stub
		
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<CrudBook> get(CrudBook bean) {
		// TODO Auto-generated method stub
		return null;
	}

}
