package members.login.Controller;
//import java.util.List;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;
import members.login.entity.SignIn;



@Validated
@RequestMapping("Members")
@OpenAPIDefinition(info = @Info(title = " Sign in sheet""), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.")})

public interface SignInController {

	@Operation(
			summary = "Returns the list table for todays sign in log,
			description = "Check todays sign in ",
			responses = {
				@ApiResponse(
					responseCode = "200",
					description = "The created memory for log in is returned",
					content = @Content (
							mediaType = "application/json",
							schema = @Schema(implementation = signIn.class))),
				@ApiResponse(
						responseCode = "400",
						description = "A sign in data entry component was not found with the input criteria",
						content = @Content (mediaType = "application/json")),
				
	
	
				@ApiResponse(
						
						responseCode = "500",
						description = "An unplanned error occured.",
						content = @Content (mediaType = "application/json")),

			}
	)	
	
	@GetMapping
	//@GetMapping("inventory_id") = to get by inventory id
	
	@ResponseStatus(code = HttpStatus.OK)
	List<SignIn> fetchAllSignIn(
			
			);
	
	
////////////////////////
	/////////
	
//	create  //
//////////////////////////
	
	@Operation(
			summary = "Creates a new sign-in member",
			description = "Returns the created member ",
			responses = {
					@ApiResponse(
							responseCode = "201",
							description = "A new sign in sheet has been added to the data for today",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation =SignIn.class))),
					@ApiResponse(
							responseCode = "400",
							description = "The request parameters are invalid",
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404",
							description = "No members were found.",
							content = @Content(mediaType = "application/json")),
		
					@ApiResponse(
							responseCode = "500",
							description = "An unplanned error occured.",
							content = @Content(mediaType = "application/json")),
			}

		)
	@PostMapping("/create sign-in member")
	@ResponseStatus(code = HttpStatus.CREATED)	
	
	SignIn createSignIn(int date, int studentNumber, String studentName, String description);	
	
//////////////////////// 
	// update //
	//////////////////////
	@Operation(
			summary = "Updates an existing member",
			description = "Returns updated existing member",
			responses = {
					@ApiResponse(
							responseCode = "200",
							description = "Returns updated existing members",
							content = @Content(
									mediaType = "application/json",
									schema = @Schema(implementation = SignIn.class))),
					@ApiResponse(
							responseCode = "400",
							description = "The request parameters are invalid",
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404",
							description = "No members were found.",
							content = @Content(mediaType = "application/json")),
		
					@ApiResponse(
							responseCode = "500",
							description = "An unplanned error occured.",
							content = @Content(mediaType = "application/json")),

			},
			parameters = {
					@Parameter(name = "member_id",
							allowEmptyValue = false,
							required = false,
							description = "the students Id number within the inventory database"),

			}
			)
	

    @PutMapping("/updateinventory")

    @ResponseStatus(code = HttpStatus.OK)
    SignIn updateSignIn(int date, int studentNumber, String studentName, String description);	
	
	@Operation(
				summary = "Deletes an existing student report",
				description = "Deletes an existing memebr",
				responses = {
	@ApiResponse(
				responseCode = "200",
				description = "memebr in records was deleted",
				content = @Content(
				mediaType = "application/json",
				schema = @Schema(implementation = SignIn.class))),
	@ApiResponse(
				responseCode = "400",
				description = "The request parameters are invalid",
				content = @Content(mediaType = "application/json")),
	@ApiResponse(
				responseCode = "404",
				description = "No exisiting student numer in data base were found.",
				content = @Content(mediaType = "application/json")),

	@ApiResponse(
				responseCode = "500",
				description = "An unplanned error occured.",
				content = @Content(mediaType = "application/json")),

},
	parameters = {
				@Parameter (name = "memberId",
				allowEmptyValue = false,
				required = false,
				description = "memberId (i.e., 2)"),
}
)

@DeleteMapping("/deletemembers")
@ResponseStatus(code = HttpStatus.OK)

	void deleteSignIn(int signInId);




		
}


	
	
	
	