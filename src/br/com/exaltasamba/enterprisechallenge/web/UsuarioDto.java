package br.com.exaltasamba.enterprisechallenge.web;

/**
 * A classe `UsuarioDto` adota o padrão de transferência de dados (DTO - Data Transfer Object) como uma abordagem
 * eficiente para evitar a "poluição" da classe `Usuario`. O padrão DTO é utilizado para encapsular dados específicos
 * relacionados à transferência entre diferentes camadas do sistema, promovendo uma separação clara entre a lógica de
 * negócios e a camada de apresentação ou persistência.
 *
 * ## Propósito do UsuarioDto:
 * O `UsuarioDto` é projetado para conter apenas os atributos necessários para a comunicação e transferência de dados,
 * evitando a inclusão de detalhes internos ou excessivos da classe `Usuario`. Essa prática contribui para manter a
 * classe `Usuario` mais limpa e focada em suas responsabilidades principais.
 *
 * ## Atributos do UsuarioDto:
 * - `idUsuario`: Um identificador associado ao usuário no sistema.
 * - `nome`: Uma string que armazena o nome do usuário.
 * - Outros atributos necessários para a transferência de dados específicos do usuário, excluindo detalhes sensíveis ou
 *   internos.
 *
 * ## Exemplo de Uso:
 * Para utilizar o `UsuarioDto` em operações de transferência de dados, basta criar instâncias desta classe e
 * preenchê-las com os dados necessários antes de enviar ou receber informações entre as camadas do sistema.
 *
 * A adoção do padrão DTO contribui para a manutenção da coesão e baixo acoplamento no sistema, permitindo uma
 * evolução mais flexível e facilitando a integração com diferentes camadas ou componentes.
 */
public record UsuarioDto(String username, String perfil, String token) { }
