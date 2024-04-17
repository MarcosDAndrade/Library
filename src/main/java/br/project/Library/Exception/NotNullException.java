package br.project.Library.Exception;

public class NotNullException extends NullPointerException{

    public NotNullException(){super("Campo não pode ser nulo!");}

    public NotNullException(String message) {super(message);}
}
