package members.login.entity;
import lombok.Builder;
import lombok.Data;





@Data

@Builder
public class SignIn {

	public static void main(String[] args) {
private int date;
private int studentNumber;
private String studentName;
private String description;


	}

}


/* Current date and time output
 * 
 * import java.time.LocalDateTime; // import the LocalDateTime class

public class Main {
  public static void main(String[] args) {
    LocalDateTime myObj = LocalDateTime.now();
    System.out.println(myObj);
  }
}
 * 
 * 
 * 
 * 
 * print local date 
 * 
 * 
 * 
 * import java.time.LocalDate; // import the LocalDate class

public class Main {
  public static void main(String[] args) {
    LocalDate myObj = LocalDate.now(); // Create a date object
    System.out.println(myObj); // Display the current date
  }
}
 * 
 */



