/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dto.PersonStyleDTO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author fh
 */
public class Tester {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        Persons p1 = new Persons("John", 1991);
        Persons p2 = new Persons("Svend", 1829);
        
        Address a1 = new Address ("Aalborg", 9000, "Danmarksgade");
        Address a2 = new Address ("København", 1113, "Silkegade"); 
        
        p1.setAddress(a1);
        p2.setAddress(a2);
        
        Fee f1 = new Fee(200);
        Fee f2 = new Fee(2900);
        Fee f3 = new Fee(230);
        
        p1.addFees(f1);
        p2.addFees(f2);
        p2.addFees(f3);
        
        SwimStyle s1 = new SwimStyle("Crawl");
        SwimStyle s2 = new SwimStyle("Butterfly");
        SwimStyle s3 = new SwimStyle("Breast Stroke");
        
        p1.addSwimStyle(s1);
        p2.addSwimStyle(s2);
        p1.addSwimStyle(s3);
        
        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.getTransaction().commit();
        
        
        em.getTransaction().begin();
        p1.removeSwimStyle(s3);
        em.getTransaction().commit();
        
        
        

        System.out.println("p1: " + p1.getId() + ", " + p1.getName());
        System.out.println("p2: " + p2.getId() + ", " + p2.getName());
        
        System.out.println("John's gade: " + p1.getAddress().getStreet());
        
        System.out.println("Lad os se om to-vejs virker: " + a1.getPerson().getName());
        
        System.out.println("lad os se om det virker med fees " + p1.getFees().get(0).getAmount());
        System.out.println("lad os se om det virker med fees " + p2.getFees().get(0).getAmount());
        
        System.out.println("Hvem har betalt f1? : " + f1.getPerson().getName());
        
        TypedQuery<Fee> q1 = em.createQuery("Select f FROM Fee f", Fee.class);
        List<Fee> fees = q1.getResultList();
                
        for(Fee f : fees){
            System.out.println(f.getAmount() + "kr. was paid by " + f.getPerson().getName() + " on the " + f.getPayDate());
            
        }
        
        Query q3 = em.createQuery("SELECT new dto.PersonStyleDTO(p.name, p.year, s.styleName) FROM Persons p JOIN p.styles s");
        
        List<PersonStyleDTO> personDetails = q3.getResultList();
        
        for(PersonStyleDTO pDTO : personDetails){
            System.out.println("Name: " + pDTO.getName() + ", " + pDTO.getYear() + ", " + pDTO.getSwimStyle());
        }
    }

}
