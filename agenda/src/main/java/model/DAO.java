package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {

	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";

	/** The url. */
	private String url = "jdbc:mysql://localhost/dbagenda?useTimezone=true&serverTimezone=UTC";

	/** The user. */
	private String user = "root";

	/** The password. */
	private String password = "4d3c2b1a";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	/**
	 * Inserir contato.
	 *
	 * @param contato the contato
	 */
	public void inserirContato(JavaBeans contato) {
		String sql = "INSERT INTO contatos (nome,fone,email) VALUES (?,?,?)";

		try {
			Connection con = conectar();
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getFone());
			pstm.setString(3, contato.getEmail());

			pstm.execute();

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Listar contatos.
	 *
	 * @return the list
	 */
	public List<JavaBeans> listarContatos() {
		String sql = "SELECT * FROM contatos";
		List<JavaBeans> contatos = new ArrayList<>();
		try {
			Connection con = conectar();
			PreparedStatement pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				JavaBeans contato = new JavaBeans();
				contato.setIdcon(rs.getString("idcont"));
				contato.setNome(rs.getString("nome"));
				contato.setFone(rs.getString("fone"));
				contato.setEmail(rs.getString("email"));

				contatos.add(contato);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
			;
		}

		return contatos;
	}

	/**
	 * Selecionar contato.
	 *
	 * @param contato the contato
	 */
	public void selecionarContato(JavaBeans contato) {
		String sql = "SELECT * FROM contatos WHERE idcont = ?";

		try {
			Connection con = conectar();
			PreparedStatement pstm = con.prepareStatement(sql);

			pstm.setString(1, contato.getIdcon());
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				contato.setIdcon(rs.getString("idcont"));
				contato.setNome(rs.getString("nome"));
				contato.setFone(rs.getString("fone"));
				contato.setEmail(rs.getString("email"));

			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Alterar contato.
	 *
	 * @param contato the contato
	 */
	public void alterarContato(JavaBeans contato) {
		String sql = "UPDATE contatos set nome=?,fone=?,email=? WHERE idcont = ?";

		try {
			Connection con = conectar();
			PreparedStatement pstm = con.prepareStatement(sql);

			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getFone());
			pstm.setString(3, contato.getEmail());
			pstm.setString(4, contato.getIdcon());
			pstm.executeUpdate();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	/**
	 * Deletar contato.
	 *
	 * @param contato the contato
	 */
	public void deletarContato(JavaBeans contato) {
		String sql = "DELETE FROM contatos WHERE idcont = ?";

		try {
			Connection con = conectar();
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, contato.getIdcon());
			pstm.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
