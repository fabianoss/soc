package br.com.soc.sistema.soap.exception;

public class ExameException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3853575374320944169L;
	
	private String detail;
	
	public ExameException(String message, String detail) {
        super(message);
        this.detail = detail;
    }

    public String getFaultInfo() {
        return detail;
    }

	
}
