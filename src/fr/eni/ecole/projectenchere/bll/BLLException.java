package fr.eni.ecole.projectenchere.bll;

public class BLLException extends Exception {

		public BLLException() {
			super();
		}
		
		public BLLException(String message) {
			super(message);
		}
		
		public BLLException(String message, Throwable exception) {
			super(message, exception);
		}
		
		@Override
		public String getMessage() {
			return " "+ super.getMessage();
		}
		
		
}

