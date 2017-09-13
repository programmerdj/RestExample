package hello;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.log4j.Logger;
 

@Path("/customers")
public class HelloWorldService {
 
	final static Logger logger = Logger.getLogger(HelloWorldService.class);
	
	private static final String FILE_PATH = "d:\\CommunicationMapping.txt";
	
  @GET
  @Produces("text/html")
  public Response getLocalCust() {
 
           String output = "I am from 'getLocalCust' method Deepak";
           return Response.status(200).entity(output).build();
  }
 
  @GET
  @Path("/nri")
  @Produces("text/html")
  public Response getNriCust() {
	  logger.warn("This is warn : ");
	  runMe("Deepak");
            String output = "I am from 'getNriCust' method";
            return Response.status(200).entity(output).build();
  }
  
  @GET
	@Path("/get")
	@Produces("text/plain")
	public Response getFile() {

		File file = new File(FILE_PATH);

		
		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
				"attachment; filename=CommunicationMapping.pdf");
		return response.build();

		
	}
  
  private void runMe(String parameter){

		if(logger.isDebugEnabled()){
			logger.debug("This is debug : " + parameter);
		}

		if(logger.isInfoEnabled()){
			logger.info("This is info : " + parameter);
		}

		logger.warn("This is warn : " + parameter);
		logger.error("This is error : " + parameter);
		logger.fatal("This is fatal : " + parameter);

	}
  
}