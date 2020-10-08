package org.acme.resteasy.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.resteasy.models.Summary;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class SummaryRepository implements PanacheRepository<Summary> {

    @Transactional
    public void create(Summary summary) {
        persist(summary);
    }

}
