package it.noah.crawler.exception;

public class NoahCrawlerException extends Exception {

	private static final long serialVersionUID = 1L;

	private String message;

	public NoahCrawlerException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
