package utilities;

public class TryResult<T> {
	
	private boolean success = true;
	private T result;
	private String message;

	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public boolean isSuccessful() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}
}
