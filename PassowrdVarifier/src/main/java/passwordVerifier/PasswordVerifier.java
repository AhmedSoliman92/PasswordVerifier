package passwordVerifier;

import java.util.regex.Pattern;

import passwordExceptions.PasswordShouldBeLargerThanEight_Exception;
import passwordExceptions.PasswordShouldHaveOneLowerCaseAtLeast_Exception;
import passwordExceptions.PasswordShouldHaveOneNumberAtLeast_Exception;
import passwordExceptions.PasswordShouldHaveOneUpperCaseLetterAtLeast_Exception;

	
	public class PasswordVerifier{
		
		public boolean verify(String password) throws PasswordShouldBeLargerThanEight_Exception,PasswordShouldHaveOneUpperCaseLetterAtLeast_Exception,PasswordShouldHaveOneLowerCaseAtLeast_Exception,PasswordShouldHaveOneNumberAtLeast_Exception {
			if(password==null) {
				throw new IllegalArgumentException("Password should not be null");
			}
			verifyPasswordLargerThanEight(password);
			verifyPasswordHasOneUpperCaseLetterAtLeast(password);
			verifyPasswordHasOneLowerCaseAtLeast(password);
			verifyPasswordHasOneNumberAtLeast(password);
			 return true;
		}

		
		public boolean verifyPasswordLargerThanEight(String password)throws PasswordShouldBeLargerThanEight_Exception {
			if(password.length()>8) {
				return true;
			}
			throw new PasswordShouldBeLargerThanEight_Exception("Password should be larger than 8 chars");
		}
		
		public boolean verifyPasswordHasOneUpperCaseLetterAtLeast(String password)throws PasswordShouldHaveOneUpperCaseLetterAtLeast_Exception {
			Pattern upperCasePattern=Pattern.compile("[A-Z]");
			if(upperCasePattern.matcher(password).find()) {
				return true;
			}
			throw new PasswordShouldHaveOneUpperCaseLetterAtLeast_Exception("Password should have one uppercase letter at least");
		}
		
		public boolean verifyPasswordHasOneLowerCaseAtLeast(String password) throws PasswordShouldHaveOneLowerCaseAtLeast_Exception {
			Pattern lowerCasePattern=Pattern.compile("[a-z]");
			if(lowerCasePattern.matcher(password).find()) {
				return true;
			}
			throw new PasswordShouldHaveOneLowerCaseAtLeast_Exception("Password should have one lowercase letter at least");
		}
		public boolean verifyPasswordHasOneNumberAtLeast(String password) throws PasswordShouldHaveOneNumberAtLeast_Exception {
			Pattern digitPattern=Pattern.compile("[0-9]");
			if(digitPattern.matcher(password).find()) {
	                return true;
	                }
			throw new PasswordShouldHaveOneNumberAtLeast_Exception("The password MUST have minimum a digit case");
			}
		public boolean checkConditions(String password) {
			int counter=0;
			Pattern lowerCasePattern=Pattern.compile("[a-z]");
			if(lowerCasePattern.matcher(password).find())
				counter+=1;
			else
				return false;
			if(password.length()>8)
				counter+=1;
			Pattern upperCasePattern=Pattern.compile("[A-Z]");
			if(upperCasePattern.matcher(password).find())
				counter+=1;
			
			Pattern digitPattern=Pattern.compile("[0-9]");
			if(digitPattern.matcher(password).find())
				counter+=1;
			return counter>=3;
		}
}