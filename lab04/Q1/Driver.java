



public class Driver {
    public static void main(String[] args){

        String[] passwords = {
            "abc","abcdefgh","Abcdefgh","Abcd1234","Abcd1234!"
        };

        for(String pw : passwords){
            System.out.println("Password: " + pw);

            System.out.println("Length: " + PasswordChecker.Minlength(pw));
            System.out.println("Uppercase: " + PasswordChecker.Uppercase(pw));
            System.out.println("Digit: "+ PasswordChecker.Digit(pw));
            System.out.println("Special Character: " + PasswordChecker.SpecialChar(pw));
            System.out.println("Strength: "+ PasswordChecker.strength(pw));
            System.out.println("                                        ");
        }
    }
} 
