package br.com.exaltasamba.enterprisechallenge.domain.auth;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * A classe `AuthUtils` fornece utilitários para operações relacionadas à autenticação, com destaque para a criptografia
 * de senhas utilizando o algoritmo SHA-256. Essa classe é projetada para aumentar a segurança do sistema ao armazenar e
 * verificar senhas de forma mais resiliente contra ataques de força bruta e engenharia reversa.
 *
 * ## Criptografia de Senha (SHA-256):
 * A principal funcionalidade da `AuthUtils` é a criptografia de senhas no formato SHA-256. Este é um algoritmo de hash
 * amplamente utilizado que produz uma sequência de bytes irreversível a partir da senha original. Este processo ajuda a
 * proteger as senhas armazenadas no banco de dados, uma vez que mesmo se os dados forem comprometidos, a senha real
 * permanece segura.
 *
 * A `AuthUtils` oferece uma camada de segurança essencial ao lidar com senhas de usuários, sendo uma prática recomendada
 * para proteger informações sensíveis. No entanto, é crucial complementar essas práticas com outras medidas de segurança,
 * como o uso de HTTPS, proteção contra injeção de SQL e gestão adequada de credenciais de acesso.
 */

public class AuthUtils {

    public static String hash256(String data) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(data.getBytes());
            return bytesToHex(md.digest());
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte byt : bytes) result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
        return result.toString();
    }
}
