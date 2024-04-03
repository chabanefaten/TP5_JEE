package dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import metier.entities.Parfum;
import util.JPAutil;

public class ParfumDaoImpl implements IParfumDao {
private EntityManager entityManager=JPAutil.getEntityManager("TP5_JEE_Parfum2");
@Override
public Parfum save(Parfum p) {

EntityTransaction tx = entityManager.getTransaction();
tx.begin();
entityManager.persist(p);
tx.commit();
return p;
}
@SuppressWarnings("unchecked")
@Override
public List<Parfum> parfumsParMC(String mc) {
List<Parfum> pars =
entityManager.createQuery("select p from Parfum p where p.nomParfum like :mc").setParameter("mc", "%"+mc+"%").getResultList();

return pars;
}
@Override
public Parfum getParfum(Long id) {
return entityManager.find(Parfum.class, id);
}
@Override
public Parfum updateParfum(Parfum p) {
EntityTransaction tx = entityManager.getTransaction();
tx.begin();
entityManager.merge(p);
tx.commit();
return p;
}
@Override
public void deleteParfum(Long id) {
Parfum parfum = entityManager.find(Parfum.class, id);
entityManager.getTransaction().begin();
entityManager.remove(parfum);
entityManager.getTransaction().commit();
}
}