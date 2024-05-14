package it.meteo.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import io.jsonwebtoken.security.Keys;
import it.meteo.dto.UtenteLoginResponseDTO;
import it.meteo.model.Utente;
import it.meteo.service.UtenteService;
import it.meteo.dto.UtenteRegisterDTO;
import it.meteo.dto.UtenteLoginRequestDTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import io.jsonwebtoken.*;
import java.security.Key;
import java.time.LocalDateTime;

@Path("/utente")
public class UtenteController
{
	private long MIN = 15L;
	private String FIRMA = "HUCASHGJGCHASUIG£432423rfeYGDagudafdsau";
	
	@Autowired
	private UtenteService utenteService;
	
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginUtente(@RequestBody UtenteLoginRequestDTO utenteLoginRequestDTO) 
	{
		try 
		{
			
			if (utenteService.loginUtente(utenteLoginRequestDTO)) 
			{
				return Response.ok(issueToken(utenteLoginRequestDTO.getEmail())).build();
			}
			
			return Response.status(Response.Status.BAD_REQUEST).build();
		} 
		catch (Exception e) 
		{
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addUser(@Valid @RequestBody UtenteRegisterDTO user) 
	{
		try 
		{
			if (!Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^\\da-zA-Z]).{8,}$", user.getPassword())) 
			{
				return Response.status(Response.Status.BAD_REQUEST).build();
			}
			
			if (utenteService.existByEmail(user.getEmail())) 
			{
				return Response.ok().build();
			}
			
			utenteService.utenteRegistration(user);
			
			return Response.ok().build();
		} 
		catch (Exception e) 
		{
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	}
	
	private UtenteLoginResponseDTO issueToken(String email) 
	{
		byte[] secretKey = FIRMA.getBytes();
		
		Key key = Keys.hmacShaKeyFor(secretKey);
		
		Utente infoUtente = utenteService.getUserByEmail(email);
		
		Map<String, Object> map = new HashMap<>();
		map.put("id", infoUtente.getId());
		map.put("email", email);
		map.put("nome", infoUtente.getNome());
		map.put("cognome", infoUtente.getCognome());
		
		
		//data di creazione e ttl
		Date creationDate = new Date();
		Date end = java.sql.Timestamp.valueOf(LocalDateTime.now().plusMinutes(MIN));
		
		//creazione del token firmato con la chiave segreta creata prima
		String jwtToken = Jwts.builder()
			.setClaims(map)
			.setIssuer("http://localhost:8080")
			.setIssuedAt(creationDate)
			.setExpiration(end)
			.signWith(key)
			.compact();
		
		UtenteLoginResponseDTO token = new UtenteLoginResponseDTO();
		token.setToken(jwtToken);
		token.setTokenCreationTime(creationDate);
		token.setTtl(end);
			
		return token;
	}
	
}
