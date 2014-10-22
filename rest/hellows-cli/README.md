# Hello World! Client
This project contains a demonstration of a consumer of a REST web service.

Run the code with ```gradle client```. The code invokes a service that and then navigate to [http://localhost:8080/helloWorld/sayHello/World](http://localhost:8080/helloWorld/sayHello/World) to 
retrieve a text containing the word `World`. 

The code of the service is:
```java
@Path("sayHello/{name}")
public class HelloWebService {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage(@PathParam("name") String name) {
		return "Hello "+name;
	}
}
```

Therefore, if `World` is changed by `me`, the returned message will be `Hello me`.

