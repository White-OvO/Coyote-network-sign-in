package members.entity;



import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;





@Data

@Builder
public class SignIn {


			int  date;
			int studentNumber;
			String studentName;
			String description;


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



