package com.example.Biblioteka.Biblioteka;

import com.example.Biblioteka.Grad.GradEntity;
import com.example.Biblioteka.Grad.GradRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class BibliotekaRepositoryImpl {
    @Autowired
    private EntityManager entityManager;

    public List<BibliotekaEntity> pretragaPoGradu(Integer grad) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<BibliotekaEntity> criteriaQuery = criteriaBuilder.createQuery(BibliotekaEntity.class);
        Root<BibliotekaEntity> root = criteriaQuery.from(BibliotekaEntity.class);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.equal(root.get("grad"), grad));
        criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public List<BibliotekaEntity> gradBiblioteka(Integer grad_id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<BibliotekaEntity> criteriaQuery = criteriaBuilder.createQuery(BibliotekaEntity.class);
        Root<BibliotekaEntity> root = criteriaQuery.from(BibliotekaEntity.class);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteriaBuilder.equal(root.join("grad").get("id"), grad_id));
        criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
