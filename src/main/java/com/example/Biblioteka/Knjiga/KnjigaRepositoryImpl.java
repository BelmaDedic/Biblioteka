package com.example.Biblioteka.Knjiga;

import com.example.Biblioteka.Clan.ClanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class KnjigaRepositoryImpl {
    @Autowired
    EntityManager entityManager;

    public List<KnjigaEntity> pretragaPoKategoriji(String kategorija) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<KnjigaEntity> criteriaQuery = criteriaBuilder.createQuery(KnjigaEntity.class);
        Root<KnjigaEntity> root = criteriaQuery.from(KnjigaEntity.class);

        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(criteriaBuilder.equal(root.get("kategorija"), kategorija));
        criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public KnjigaEntity pretragaPoNazivu(String naziv) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<KnjigaEntity> criteriaQuery = criteriaBuilder.createQuery(KnjigaEntity.class);
        Root<KnjigaEntity> root = criteriaQuery.from(KnjigaEntity.class);

        Predicate predicate = criteriaBuilder.equal(root.get("naziv"), naziv);
        criteriaQuery.where(predicate);
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }
}
