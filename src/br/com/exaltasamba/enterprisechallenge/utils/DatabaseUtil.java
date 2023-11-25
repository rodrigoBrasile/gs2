package br.com.exaltasamba.enterprisechallenge.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * A classe `DataBaseUtil` representa uma abordagem direta e "pura" para a conexão com um banco de dados em Java, sem a
 * utilização de frameworks adicionais. Ela encapsula as operações básicas necessárias para estabelecer uma conexão com o
 * banco de dados, realizar consultas e gerenciar recursos associados.
 *
 * ## Utilização da DataBaseUtil:
 * Para utilizar a `DataBaseUtil` e estabelecer uma conexão com o banco de dados, siga os passos abaixo:
 *
 * 1. **Configuração de Parâmetros:**
 *    Configure os parâmetros necessários, como URL do banco de dados, nome de usuário e senha, diretamente na classe ou
 *    por meio de métodos de configuração.
 *
 * 2. **Estabelecimento da Conexão:**
 *    Utilize o método `conectar` para estabelecer a conexão com o banco de dados.
 *
 * 3. **Execução de Consultas:**
 *    Execute consultas SQL utilizando a conexão estabelecida, e lembre-se de fechar a conexão após o uso.
 *    ResultSet resultado = DataBaseUtil.executarConsulta(conexao, "SELECT * FROM minha_tabela");
 *
 * A `DataBaseUtil` fornece uma abstração básica para a interação com bancos de dados em Java, sendo uma alternativa
 * simples e direta para casos em que a utilização de frameworks adicionais é indesejada ou impraticável. É importante
 * ressaltar que, em ambientes de produção ou projetos mais complexos, a consideração de frameworks de persistência e
 * segurança deve ser avaliada.
 */

public class DatabaseUtil {
    private static final String URL = "jdbc:mysql://avnadmin:AVNS_s0-yY6ssoExBf3r-fgn@enterprise-challenge-digo-a0d1.aivencloud.com:15825/defaultdb?ssl-mode=REQUIRED";
    private static final String USER = "avnadmin";
    private static final String PASSWORD = "AVNS_s0-yY6ssoExBf3r-fgn";
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Outros métodos úteis, como fechar conexões, statements, etc.
}
