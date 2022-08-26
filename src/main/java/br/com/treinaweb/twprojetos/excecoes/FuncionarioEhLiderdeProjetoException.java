package br.com.treinaweb.twprojetos.excecoes;

public class FuncionarioEhLiderdeProjetoException extends RuntimeException {

    public FuncionarioEhLiderdeProjetoException(Long id) {
        super(String.format("Funcionario com ID %s é Lider de projeto(s)", id));
    }
    
}