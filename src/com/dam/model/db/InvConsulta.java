package com.dam.model.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.dam.model.data.;

public class InvConsulta {
	
	private AccesoDB adb;

	public InvConsulta() {
		adb = new AccesoDB();
	}
	
	// consultar las regiones de la tabla REATAURANTES:
	// SELECT DISTINCT REGION FROM RESTAURANTES;
	public ArrayList<String> obtenerRegiones() {
		ArrayList<String> listaRegiones = new ArrayList<String>();
		
		String query = "SELECT DISTINCT " + RestaurantesContract.COL_REGION 
				+ " FROM " + RestaurantesContract.NOM_TABLA;
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rslt = null;
		
		try {
			con = adb.getConexion();
			
			stmt = con.createStatement();
			
			rslt = stmt.executeQuery(query);
			
			while (rslt.next()) {
				listaRegiones.add(rslt.getString(1));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null) {
					rslt.close();
				}
				
				if (stmt != null) {
					stmt.close();
				}
				
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return listaRegiones;
	}
	
	// consultar restaurantes 
	// SELECT * FROM RESTAURANTES
	public ArrayList<Restaurante> obtenerRestaurantes() {
		ArrayList<Restaurante> listaRestaurantes = new ArrayList<Restaurante>();
		
		String query = "SELECT * FROM " + RestaurantesContract.NOM_TABLA;
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rslt = null;
		
		try {
			con = adb.getConexion();
			
			stmt = con.createStatement();
			
			rslt = stmt.executeQuery(query);
			
			Restaurante rest = null;
			while (rslt.next()) {
				rest = new Restaurante(rslt.getInt(1), rslt.getString(2), 
						rslt.getString(3), rslt.getString(4), rslt.getInt(5), 
						rslt.getString(6), rslt.getDouble(7), rslt.getDouble(8), 
						rslt.getString(9), rslt.getString(10), rslt.getString(11));
				listaRestaurantes.add(rest);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null) {
					rslt.close();
				}
				
				if (stmt != null) {
					stmt.close();
				}
				
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return listaRestaurantes;
	}

	// consultar restaurantes por region
	// SELECT * FROM RESTAURANTES WHERE REGION = ?
	public ArrayList<Restaurante> obtenerRestaurantesReg(String region) {
		ArrayList<Restaurante> listaRestaurantes = new ArrayList<Restaurante>();
		
		String query = "SELECT * FROM " + RestaurantesContract.NOM_TABLA 
				+ " WHERE " + RestaurantesContract.COL_REGION + " = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try {
			con = adb.getConexion();
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, region);
			
			rslt = pstmt.executeQuery();
			
			Restaurante rest = null;
			while (rslt.next()) {
				rest = new Restaurante(rslt.getInt(1), rslt.getString(2), 
						rslt.getString(3), rslt.getString(4), rslt.getInt(5), 
						rslt.getString(6), rslt.getDouble(7), rslt.getDouble(8), 
						rslt.getString(9), rslt.getString(10), rslt.getString(11));
				listaRestaurantes.add(rest);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null) {
					rslt.close();
				}
				
				if (pstmt != null) {
					pstmt.close();
				}
				
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return listaRestaurantes;
	}

	public ArrayList<Restaurante> obtenerRestaurantesDist(String distincion) {
		ArrayList<Restaurante> listaRestaurantes = new ArrayList<Restaurante>();
		
		String query = "SELECT * FROM " + RestaurantesContract.NOM_TABLA 
				+ " WHERE " + RestaurantesContract.COL_DISTINCION + " = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try {
			con = adb.getConexion();
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(distincion.substring(0, 1)));
			
			rslt = pstmt.executeQuery();
			
			Restaurante rest = null;
			while (rslt.next()) {
				rest = new Restaurante(rslt.getInt(1), rslt.getString(2), 
						rslt.getString(3), rslt.getString(4), rslt.getInt(5), 
						rslt.getString(6), rslt.getDouble(7), rslt.getDouble(8), 
						rslt.getString(9), rslt.getString(10), rslt.getString(11));
				listaRestaurantes.add(rest);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null) {
					rslt.close();
				}
				
				if (pstmt != null) {
					pstmt.close();
				}
				
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return listaRestaurantes;
	}

	public ArrayList<Restaurante> obtenerRestaurantesFiltro(String region, String distincion) {
		ArrayList<Restaurante> listaRestaurantes = new ArrayList<Restaurante>();
		
		String query = "SELECT * FROM " + RestaurantesContract.NOM_TABLA 
				+ " WHERE " + RestaurantesContract.COL_REGION + " = ? AND " 
				+ RestaurantesContract.COL_DISTINCION + " = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try {
			con = adb.getConexion();
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, region);
			pstmt.setInt(2, Integer.parseInt(distincion.substring(0, 1)));
			
			rslt = pstmt.executeQuery();
			
			Restaurante rest = null;
			while (rslt.next()) {
				rest = new Restaurante(rslt.getInt(1), rslt.getString(2), 
						rslt.getString(3), rslt.getString(4), rslt.getInt(5), 
						rslt.getString(6), rslt.getDouble(7), rslt.getDouble(8), 
						rslt.getString(9), rslt.getString(10), rslt.getString(11));
				listaRestaurantes.add(rest);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null) {
					rslt.close();
				}
				
				if (pstmt != null) {
					pstmt.close();
				}
				
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return listaRestaurantes;
	}

	// INSERT INTO COLUMNAS VALUES (VALORES)
	public int insertarRestaurante(Restaurante rest) {
		int res = 0;
		
		String query = "INSERT INTO " + RestaurantesContract.NOM_TABLA + "(" 
						+ RestaurantesContract.COL_NOMBRE + ", " 
						+ RestaurantesContract.COL_REGION + ", "
						+ RestaurantesContract.COL_CIUDAD + ", "
						+ RestaurantesContract.COL_DISTINCION + ", "
						+ RestaurantesContract.COL_DIRECCION + ", "
						+ RestaurantesContract.COL_PREC_MIN + ", "
						+ RestaurantesContract.COL_PREC_MAX + ", "
						+ RestaurantesContract.COL_COCINA + ", "
						+ RestaurantesContract.COL_TELEF + ", "
						+ RestaurantesContract.COL_WEB 
						+ ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = adb.getConexion();
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, rest.getNombre());
			pstmt.setString(2, rest.getRegion());
			pstmt.setString(3, rest.getCiudad());
			pstmt.setInt(4, rest.getDistincion());
			pstmt.setString(5, rest.getDireccion());
			pstmt.setDouble(6, rest.getPrecioMin());
			pstmt.setDouble(7, rest.getPrecioMax());
			pstmt.setString(8, rest.getCocina());
			pstmt.setString(9, rest.getTelefono());
			pstmt.setString(10, rest.getWeb());
			
			res = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}

	public Restaurante consultarRestauranteNombre(String nombre) {
		Restaurante restaurante = null;
		
		String query = "SELECT * FROM " + RestaurantesContract.NOM_TABLA 
				+ " WHERE UPPER(" + RestaurantesContract.COL_NOMBRE + ") LIKE ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try {
			con = adb.getConexion();
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, nombre.toUpperCase() + "%");
			
			rslt = pstmt.executeQuery();
			
			if (rslt.next()) {
				restaurante = new Restaurante(rslt.getInt(1), rslt.getString(2), 
						rslt.getString(3), rslt.getString(4), rslt.getInt(5), 
						rslt.getString(6), rslt.getDouble(7), rslt.getDouble(8), 
						rslt.getString(9), rslt.getString(10), rslt.getString(11));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null) {
					rslt.close();
				}
				
				if (pstmt != null) {
					pstmt.close();
				}
				
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return restaurante;
	}

	// UPDATE NOM_TABLA SET NOM_COL = ?, NOM_COL2 = ? WHERE NOM_COL_3 = ?
	public int modificarRestaurante(Restaurante rest) {
		int res = 0;
		
		String query = "UPDATE " + RestaurantesContract.NOM_TABLA + " SET " 
						+ RestaurantesContract.COL_REGION + " = ?, "
						+ RestaurantesContract.COL_CIUDAD + " = ?, "
						+ RestaurantesContract.COL_DIRECCION + " = ?, "
						+ RestaurantesContract.COL_COCINA + " = ?, "
						+ RestaurantesContract.COL_DISTINCION + " = ?, "
						+ RestaurantesContract.COL_PREC_MIN + " = ?, "
						+ RestaurantesContract.COL_PREC_MAX + " = ?, "
						+ RestaurantesContract.COL_TELEF + " = ?, "
						+ RestaurantesContract.COL_WEB + " = ? "
						+ " WHERE " + RestaurantesContract.COL_ID + " = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = adb.getConexion();
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, rest.getRegion());
			pstmt.setString(2, rest.getCiudad());
			pstmt.setString(3, rest.getDireccion());
			pstmt.setString(4, rest.getCocina());
			pstmt.setInt(5, rest.getDistincion());
			pstmt.setDouble(6, rest.getPrecioMin());
			pstmt.setDouble(7, rest.getPrecioMax());
			pstmt.setString(8, rest.getTelefono());
			pstmt.setString(9, rest.getWeb());
			pstmt.setInt(10, rest.getId());
			
			res = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}

	// delete from tabla where col = ?
	public int borrarRestaurante(String nombre) {
		int res = 0;
		
		String query = "DELETE FROM " + RestaurantesContract.NOM_TABLA 
				+ " WHERE " + RestaurantesContract.COL_NOMBRE + " = ?";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = adb.getConexion();
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, nombre);
			
			res = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}

}
