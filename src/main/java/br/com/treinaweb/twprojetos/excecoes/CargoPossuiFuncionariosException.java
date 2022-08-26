package br.com.treinaweb.twprojetos.excecoes;

public class CargoPossuiFuncionariosException extends RuntimeException {

    public CargoPossuiFuncionariosException(Long id) {
        super(String.format("Cargo com ID %s possui funcionario(s) relacionados", id));
    }
    
}
