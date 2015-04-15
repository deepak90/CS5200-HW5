package dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import model.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

//javax.ws.rs
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("/site")
public class SiteDAO {
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("DBHW5");
	EntityManager em = null;
	
	public SiteDAO() {
		em = factory.createEntityManager();
	} 
	
	//CREATE
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> createSite(Site site) {
		
		em.getTransaction().begin();
		em.persist(site);
		
		Query query = em.createNamedQuery("Site.findAll");
		List<Site> sites = query.getResultList();
		
		em.getTransaction().commit();
		
		return sites;
	}
	
	//READ
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Site findSite(@PathParam("id") int siteId) {
		
		em.getTransaction().begin();
		Site site = em.find(Site.class,siteId);
		
		em.getTransaction().commit();
		
		return site;
	}
	
	//READ
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> findAllSites() {
		
		em.getTransaction().begin();
		Query query = em.createNamedQuery("Site.findAll");
		
		List<Site> sites = query.getResultList();
		em.getTransaction().commit();
		
		return sites;
	}
	
	//UPDATE
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> updateSite(@PathParam("id") int siteId, Site site) {
		
		em.getTransaction().begin();
		Site s = em.find(Site.class,siteId);
		
		s.setName(site.getName());
		em.merge(s);
		
		Query query = em.createNamedQuery("Site.findAll");
		List<Site> sites = query.getResultList();
		
		em.getTransaction().commit();
		
		return sites;
	}
	
	//DELETE
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Site> deleteSite(@PathParam("id") int siteId) {
		
		em.getTransaction().begin();
		Site site = em.find(Site.class, siteId);
		
		em.remove(site);
		Query query = em.createNamedQuery("Site.findAll");
		
		List<Site> sites = query.getResultList();
		em.getTransaction().commit();
		
		return sites;
	}
}
