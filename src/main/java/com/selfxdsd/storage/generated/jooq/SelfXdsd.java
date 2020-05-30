/*
 * This file is generated by jOOQ.
 */
package com.selfxdsd.storage.generated.jooq;


import com.selfxdsd.storage.generated.jooq.tables.SlfContractsXdsd;
import com.selfxdsd.storage.generated.jooq.tables.SlfContributorsXdsd;
import com.selfxdsd.storage.generated.jooq.tables.SlfPmsXdsd;
import com.selfxdsd.storage.generated.jooq.tables.SlfProjectsXdsd;
import com.selfxdsd.storage.generated.jooq.tables.SlfTasksXdsd;
import com.selfxdsd.storage.generated.jooq.tables.SlfUsersXdsd;

import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SelfXdsd extends SchemaImpl {

    private static final long serialVersionUID = 1149413801;

    /**
     * The reference instance of <code>self_xdsd</code>
     */
    public static final SelfXdsd SELF_XDSD = new SelfXdsd();

    /**
     * The table <code>self_xdsd.slf_contracts_xdsd</code>.
     */
    public final SlfContractsXdsd SLF_CONTRACTS_XDSD = SlfContractsXdsd.SLF_CONTRACTS_XDSD;

    /**
     * The table <code>self_xdsd.slf_contributors_xdsd</code>.
     */
    public final SlfContributorsXdsd SLF_CONTRIBUTORS_XDSD = SlfContributorsXdsd.SLF_CONTRIBUTORS_XDSD;

    /**
     * The table <code>self_xdsd.slf_pms_xdsd</code>.
     */
    public final SlfPmsXdsd SLF_PMS_XDSD = SlfPmsXdsd.SLF_PMS_XDSD;

    /**
     * The table <code>self_xdsd.slf_projects_xdsd</code>.
     */
    public final SlfProjectsXdsd SLF_PROJECTS_XDSD = SlfProjectsXdsd.SLF_PROJECTS_XDSD;

    /**
     * The table <code>self_xdsd.slf_tasks_xdsd</code>.
     */
    public final SlfTasksXdsd SLF_TASKS_XDSD = SlfTasksXdsd.SLF_TASKS_XDSD;

    /**
     * The table <code>self_xdsd.slf_users_xdsd</code>.
     */
    public final SlfUsersXdsd SLF_USERS_XDSD = SlfUsersXdsd.SLF_USERS_XDSD;

    /**
     * No further instances allowed
     */
    private SelfXdsd() {
        super("self_xdsd", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            SlfContractsXdsd.SLF_CONTRACTS_XDSD,
            SlfContributorsXdsd.SLF_CONTRIBUTORS_XDSD,
            SlfPmsXdsd.SLF_PMS_XDSD,
            SlfProjectsXdsd.SLF_PROJECTS_XDSD,
            SlfTasksXdsd.SLF_TASKS_XDSD,
            SlfUsersXdsd.SLF_USERS_XDSD);
    }
}
