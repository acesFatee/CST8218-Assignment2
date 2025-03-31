/*
 * Copyright (c), Eclipse Foundation, Inc. and its licensors.
 *
 * All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v1.0, which is available at
 * https://www.eclipse.org/org/documents/edl-v10.php
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */
package cst8218.assignment2.soha0021_bhan0075.service;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import cst8218.assignment2.soha0021_bhan0075.entity.Bouncer;
import jakarta.transaction.Transactional;

/**
 *
 * @author bhan
 */
@Stateless
public class BouncerFacade extends AbstractFacade<Bouncer> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BouncerFacade() {
        super(Bouncer.class);
    }

    @Transactional
    public void edit(Bouncer entity) {
        em.merge(entity); // Merges changes into the database
        em.flush(); // Forces commit to the database
    }
}