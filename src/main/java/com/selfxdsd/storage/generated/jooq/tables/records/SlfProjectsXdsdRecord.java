/*
 * This file is generated by jOOQ.
 */
package com.selfxdsd.storage.generated.jooq.tables.records;


import com.selfxdsd.storage.generated.jooq.tables.SlfProjectsXdsd;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SlfProjectsXdsdRecord extends UpdatableRecordImpl<SlfProjectsXdsdRecord> implements Record4<String, String, String, Integer> {

    private static final long serialVersionUID = 228336106;

    /**
     * Setter for <code>self_xdsd.slf_projects_xdsd.repo_fullname</code>.
     */
    public void setRepoFullname(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>self_xdsd.slf_projects_xdsd.repo_fullname</code>.
     */
    public String getRepoFullname() {
        return (String) get(0);
    }

    /**
     * Setter for <code>self_xdsd.slf_projects_xdsd.provider</code>.
     */
    public void setProvider(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>self_xdsd.slf_projects_xdsd.provider</code>.
     */
    public String getProvider() {
        return (String) get(1);
    }

    /**
     * Setter for <code>self_xdsd.slf_projects_xdsd.username</code>.
     */
    public void setUsername(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>self_xdsd.slf_projects_xdsd.username</code>.
     */
    public String getUsername() {
        return (String) get(2);
    }

    /**
     * Setter for <code>self_xdsd.slf_projects_xdsd.pmid</code>.
     */
    public void setPmid(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>self_xdsd.slf_projects_xdsd.pmid</code>.
     */
    public Integer getPmid() {
        return (Integer) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<String, String> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<String, String, String, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<String, String, String, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return SlfProjectsXdsd.SLF_PROJECTS_XDSD.REPO_FULLNAME;
    }

    @Override
    public Field<String> field2() {
        return SlfProjectsXdsd.SLF_PROJECTS_XDSD.PROVIDER;
    }

    @Override
    public Field<String> field3() {
        return SlfProjectsXdsd.SLF_PROJECTS_XDSD.USERNAME;
    }

    @Override
    public Field<Integer> field4() {
        return SlfProjectsXdsd.SLF_PROJECTS_XDSD.PMID;
    }

    @Override
    public String component1() {
        return getRepoFullname();
    }

    @Override
    public String component2() {
        return getProvider();
    }

    @Override
    public String component3() {
        return getUsername();
    }

    @Override
    public Integer component4() {
        return getPmid();
    }

    @Override
    public String value1() {
        return getRepoFullname();
    }

    @Override
    public String value2() {
        return getProvider();
    }

    @Override
    public String value3() {
        return getUsername();
    }

    @Override
    public Integer value4() {
        return getPmid();
    }

    @Override
    public SlfProjectsXdsdRecord value1(String value) {
        setRepoFullname(value);
        return this;
    }

    @Override
    public SlfProjectsXdsdRecord value2(String value) {
        setProvider(value);
        return this;
    }

    @Override
    public SlfProjectsXdsdRecord value3(String value) {
        setUsername(value);
        return this;
    }

    @Override
    public SlfProjectsXdsdRecord value4(Integer value) {
        setPmid(value);
        return this;
    }

    @Override
    public SlfProjectsXdsdRecord values(String value1, String value2, String value3, Integer value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SlfProjectsXdsdRecord
     */
    public SlfProjectsXdsdRecord() {
        super(SlfProjectsXdsd.SLF_PROJECTS_XDSD);
    }

    /**
     * Create a detached, initialised SlfProjectsXdsdRecord
     */
    public SlfProjectsXdsdRecord(String repoFullname, String provider, String username, Integer pmid) {
        super(SlfProjectsXdsd.SLF_PROJECTS_XDSD);

        set(0, repoFullname);
        set(1, provider);
        set(2, username);
        set(3, pmid);
    }
}
