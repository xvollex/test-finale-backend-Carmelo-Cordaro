package it.meteo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import io.jsonwebtoken.security.Keys;
import it.meteo.dto.MeteoDTO;
import it.meteo.service.MeteoService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import io.jsonwebtoken.*;
import java.security.Key;
import java.time.LocalDateTime;

@Path("/meteo")
public class MeteoController 
{

	
	@Autowired
	private MeteoService meteoService;
	
	@POST
	@Path("/salva")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response utenteRegistration(MeteoDTO meteoDto)
	{	
		try 
		{
			
			meteoService.salvaMeteo(meteoDto);
			
			return Response.status(Response.Status.OK).build();
				
		} 
		catch (Exception e) 
		{
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
		
	}
	

	
}
