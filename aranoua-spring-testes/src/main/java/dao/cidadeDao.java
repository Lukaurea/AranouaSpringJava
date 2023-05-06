package dao;

import model.Cidade;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class cidadeDao {
    public void inserir(Cidade cidade){

        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();

        em.persist(cidade);

        em.getTransaction().commit();

        em.close();
    }

    public List<Cidade> listar(){
        EntityManager em = JPAUtil.getEntityManager();

        Query consulta = em.createQuery("select cidade from Cidade cidade");

        List<Cidade> cidades = consulta.getResultList();
        em.close();

        return cidades;

    }
    public Cidade consultar(Long id){
        EntityManager em = JPAUtil.getEntityManager();

        Cidade cidadeEncontrada = em.find(Cidade.class, id);

        em.close();

        return cidadeEncontrada;
    }
    public Cidade remover(){
        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();

        Cidade cidadeEncontrada=em.find(Cidade.class,5L);

        em.remove(cidadeEncontrada);

        em.getTransaction().commit();

        em.close();
        return cidadeEncontrada;
    }

}
