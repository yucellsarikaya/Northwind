package kodlamaio.northwind.core.utilities.results;

public class Result {
	private boolean success; // islem sonucu true/false
	private String message; // sonuca gore mesaj

	public Result(boolean success) {
		this.success = success;
	}

	public Result(boolean success, String message) {
		this(success);
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

}
