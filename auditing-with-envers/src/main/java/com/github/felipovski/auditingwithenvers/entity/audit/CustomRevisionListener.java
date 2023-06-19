package com.github.felipovski.auditingwithenvers.entity.audit;

import org.hibernate.envers.RevisionListener;

public class
CustomRevisionListener implements RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
        CustomAuditRevision customAuditRevision = (CustomAuditRevision) revisionEntity;

        customAuditRevision.setUsername("currentUser");
    }
}

