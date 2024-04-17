package br.project.Library.Exception;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

public class EmptySpaceException extends RuntimeException {

    public EmptySpaceException(){super("ID não encontrado");}

}
