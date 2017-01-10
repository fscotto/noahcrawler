package it.noah.crawler.exception;

public class ObjectNotFoundException extends Exception {

	private static final long serialVersionUID = -4004459574648431770L;

	private String message;

	public ObjectNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
