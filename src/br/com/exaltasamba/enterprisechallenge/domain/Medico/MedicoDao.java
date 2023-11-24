package br.com.exaltasamba.enterprisechallenge.domain.Medico;

import br.com.exaltasamba.enterprisechallenge.utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicoDao {

    private static final String LISTA_MEDICOS = "SELECT * FROM medico";
    private static final String BUSCAR_MEDICO_POR_ID = "SELECT * FROM medico WHERE id = ?";
    private static final String BUSCAR_MEDICO_POR_CRM = "SELECT * FROM medico WHERE crm = ?";
    private static final String INSERIR_MEDICO = "INSERT INTO medico (nome, crm, idUsuario) VALUES (?, ?, ?)";
    private static final String ATUALIZAR_MEDICO = "UPDATE medico SET nome = ?, crm = ?, idUsuario = ? WHERE id = ?";
    private static final String EXCLUIR_MEDICO = "DELETE FROM medico WHERE id = ?";

    public Medico buscaMedicoPorId(int id) {
        Medico medico = null;
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(BUSCAR_MEDICO_POR_ID)) {

            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    medico = new Medico(
                            resultSet.getInt("id"),
                            resultSet.getString("nome"),
                            resultSet.getString("crm"),
                            resultSet.getInt("idUsuario")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return medico;
    }

    public List<Medico> listaMedicos() {
        List<Medico> medicos = new ArrayList<>();
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(LISTA_MEDICOS)) {

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nome = rs.getString("nome");
                    String crm = rs.getString("crm");
                    int idUsuario = rs.getInt("idUsuario");
                    medicos.add(new Medico(id, nome, crm, idUsuario));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return medicos;
    }

    public Medico buscaMedicoPorCRM(String crm) {
        Medico medico = null;
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(BUSCAR_MEDICO_POR_CRM)) {

            preparedStatement.setString(1, crm);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    medico = new Medico(
                            resultSet.getInt("id"),
                            resultSet.getString("nome"),
                            resultSet.getString("crm"),
                            resultSet.getInt("idUsuario")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return medico;
    }

    public void insereMedico(Medico medico) {
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERIR_MEDICO)) {

            preparedStatement.setString(1, medico.getNome());
            preparedStatement.setString(2, medico.getCrm());
            preparedStatement.setInt(3, medico.getIdUsuario());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizaMedico(Medico medico) {
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ATUALIZAR_MEDICO)) {

            preparedStatement.setString(1, medico.getNome());
            preparedStatement.setString(2, medico.getCrm());
            preparedStatement.setInt(3, medico.getIdUsuario());
            preparedStatement.setInt(4, medico.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluiMedico(int id) {
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(EXCLUIR_MEDICO)) {

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
