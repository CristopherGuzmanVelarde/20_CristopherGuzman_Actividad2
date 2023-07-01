package Maestros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Acceso.AccesoDB;
import Modelos.ModeloPerson;
import Plantilla.RowMapper;
import Plantilla.CRUD.CrudServiceSpec;

public class CrudPerson implements CrudServiceSpec<ModeloPerson>, RowMapper<ModeloPerson> {

	private final String SQL_SELECT_BASE = "SELECT id, first_name, last_name, identity_document, grade, section, states, person_type, cellphone FROM person";
	private final String SQL_INSERT = "INSERT INTO person (id, first_name, last_name, identity_document, grade, section, states, person_type, cellphone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String SQL_UPDATE = "UPDATE person SET first_name = ?, last_name = ?, identity_document = ?, grade = ?, section = ?, states = ?, person_type = ?, cellphone = ? WHERE id = ?";
	private final String SQL_DELETE = "DELETE FROM person WHERE id = ?";

	
	/**
	 * Mostrar toda la tabla person.
	 */
	@Override
	public List<ModeloPerson> getAll() {
		// Variables
		Connection cn = null;
		List<ModeloPerson> lista = new ArrayList<>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ModeloPerson bean;
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
	public ModeloPerson getForId(String id) {
		// Variables
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ModeloPerson bean = null;
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
	public List<ModeloPerson> get(ModeloPerson bean) {
		// Variables
		Connection cn = null;
		List<ModeloPerson> lista = new ArrayList<>();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ModeloPerson item;
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
	public void insert(ModeloPerson bean) {
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
			pstm.setString(5, bean.getGrade());
			pstm.setString(6, bean.getSection());
			pstm.setString(7, bean.getStates());
			pstm.setString(8, bean.getPerson_type());
			pstm.setString(9, bean.getCellphone());
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
	public void update(ModeloPerson bean) {
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
			pstm.setString(4, bean.getGrade());
			pstm.setString(5, bean.getSection());
			pstm.setString(6, bean.getStates());
			pstm.setString(7, bean.getPerson_type());
			pstm.setString(8, bean.getCellphone());
			pstm.setInt(9, bean.getId());
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
	 * Mapea el ResultSet a un objeto ModeloPerson.
	 */
	@Override
	public ModeloPerson mapRow(ResultSet rs) throws SQLException {
		// Variables
		ModeloPerson bean = new ModeloPerson();
		// Proceso
		bean.setId(rs.getInt("id"));
		bean.setFirst_name(rs.getString("first_name"));
		bean.setLast_name(rs.getString("last_name"));
		bean.setIdentity_document(rs.getString("identity_document"));
		bean.setGrade(rs.getString("grade"));
		bean.setSection(rs.getString("section"));
		bean.setStates(rs.getString("states"));
		bean.setPerson_type(rs.getString("person_type"));
		bean.setCellphone(rs.getString("cellphone"));
		// Retorna
		return bean;
	}

	public void setId(int parseInt) {
		// TODO Auto-generated method stub
		
	}

	public void setFirst_name(String parameter) {
		// TODO Auto-generated method stub
		
	}

	public void setIdentity_document(String parameter) {
		// TODO Auto-generated method stub
		
	}

	public void setLast_name(String parameter) {
		// TODO Auto-generated method stub
		
	}

	public void setGrade(String parameter) {
		// TODO Auto-generated method stub
		
	}

	public void setSection(String parameter) {
		// TODO Auto-generated method stub
		
	}

	public void setStates(String parameter) {
		// TODO Auto-generated method stub
		
	}

	public void setPerson_type(String parameter) {
		// TODO Auto-generated method stub
		
	}

	public void setCellphone(String parameter) {
		// TODO Auto-generated method stub
		
	}

	public List<CrudPerson> get(CrudPerson bean) {
		// TODO Auto-generated method stub
		return null;
	}

	public void insert(CrudPerson bean) {
		// TODO Auto-generated method stub
		
	}

	public void update(CrudPerson bean) {
		// TODO Auto-generated method stub
		
	}

	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setCellphone_librarian(String parameter) {
		// TODO Auto-generated method stub
		
	}

}
