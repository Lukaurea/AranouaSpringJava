package testeManual;

import dao.cidadeDao;
import model.Cidade;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TestaCidadeDao {

    public static void inserirDao() {
        cidadeDao cidadeDao = new cidadeDao();
        Cidade cidade = new Cidade();
        cidade.setNome("Campinas");
        cidadeDao.inserir(cidade);
    }

    public static void listarDao(){
        cidadeDao cidadeDao = new cidadeDao();
        List<Cidade> cidades = cidadeDao.listar();
        for(Cidade c: cidades){
            System.out.println(c.getNome());
        }
    }
    public static void consultarDao() {
        EntityManager em = JPAUtil.getEntityManager();
        Cidade cidadeEncontrada = em.find(Cidade.class,5L);
        System.out.println(cidadeEncontrada.getNome());
        em.close();
    }

    public static void removerDao() {
        Cidade cidadeDao = new Cidade();
        System.out.println(cidadeDao.getNome());
    }
    public static void main(String[] args) {
        inserirDao();
        listarDao();
    }
}
