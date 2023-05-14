package com.example.Biblioteka.Grad;

import com.example.Biblioteka.Clan.ClanEntity;
import com.example.Biblioteka.Knjiga.KnjigaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class GradRepositoryImpl {
    @Autowired
    EntityManager entityManager;

    public GradEntity pretragaPoNazivu(String naziv) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<GradEntity> criteriaQuery = criteriaBuilder.createQuery(GradEntity.class);
        Root<GradEntity> root = criteriaQuery.from(GradEntity.class);

        Predicate predicate = criteriaBuilder.equal(root.get("naziv"), naziv);
        criteriaQuery.where(predicate);
        return entityManager.createQuery(criteriaQuery).getSingleResult();
    }

    public List<KnjigaEntity> pretragaPoVise(String naziv, String imeClana, String knjiga) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<KnjigaEntity> criteriaQuery = criteriaBuilder.createQuery(KnjigaEntity.class);
        Root<GradEntity> root = criteriaQuery.from(GradEntity.class);

        Join<GradEntity, ClanEntity> gradClan = root.join("clan");
        Join<ClanEntity, KnjigaEntity> clanKnjiga = gradClan.join("knjige");

        criteriaQuery.select(clanKnjiga);

        List<Predicate> predicates = new ArrayList<>();
        Predicate getNaziv = criteriaBuilder.equal(root.get("naziv"), naziv);
        predicates.add(getNaziv);

        Predicate getIme = criteriaBuilder.equal(gradClan.get("ime"), imeClana);
        predicates.add(getIme);

        Predicate getKnjiga = criteriaBuilder.equal(clanKnjiga.get("naziv"), knjiga);
        predicates.add(getKnjiga);

        criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
