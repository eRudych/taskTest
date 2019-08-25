/*
 * This file is generated by jOOQ.
 */
package com.example.demo.db.automobiles.tables;


import com.example.demo.db.automobiles.Automobiles;
import com.example.demo.db.automobiles.tables.records.DatabasechangelogRecord;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.12"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Databasechangelog extends TableImpl<DatabasechangelogRecord> {

    private static final long serialVersionUID = 1905573648;

    /**
     * The reference instance of <code>automobiles.databasechangelog</code>
     */
    public static final Databasechangelog DATABASECHANGELOG = new Databasechangelog();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DatabasechangelogRecord> getRecordType() {
        return DatabasechangelogRecord.class;
    }

    /**
     * The column <code>automobiles.databasechangelog.ID</code>.
     */
    public final TableField<DatabasechangelogRecord, String> ID = createField("ID", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>automobiles.databasechangelog.AUTHOR</code>.
     */
    public final TableField<DatabasechangelogRecord, String> AUTHOR = createField("AUTHOR", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>automobiles.databasechangelog.FILENAME</code>.
     */
    public final TableField<DatabasechangelogRecord, String> FILENAME = createField("FILENAME", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>automobiles.databasechangelog.DATEEXECUTED</code>.
     */
    public final TableField<DatabasechangelogRecord, Timestamp> DATEEXECUTED = createField("DATEEXECUTED", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>automobiles.databasechangelog.ORDEREXECUTED</code>.
     */
    public final TableField<DatabasechangelogRecord, Integer> ORDEREXECUTED = createField("ORDEREXECUTED", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>automobiles.databasechangelog.EXECTYPE</code>.
     */
    public final TableField<DatabasechangelogRecord, String> EXECTYPE = createField("EXECTYPE", org.jooq.impl.SQLDataType.VARCHAR(10).nullable(false), this, "");

    /**
     * The column <code>automobiles.databasechangelog.MD5SUM</code>.
     */
    public final TableField<DatabasechangelogRecord, String> MD5SUM = createField("MD5SUM", org.jooq.impl.SQLDataType.VARCHAR(35), this, "");

    /**
     * The column <code>automobiles.databasechangelog.DESCRIPTION</code>.
     */
    public final TableField<DatabasechangelogRecord, String> DESCRIPTION = createField("DESCRIPTION", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>automobiles.databasechangelog.COMMENTS</code>.
     */
    public final TableField<DatabasechangelogRecord, String> COMMENTS = createField("COMMENTS", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>automobiles.databasechangelog.TAG</code>.
     */
    public final TableField<DatabasechangelogRecord, String> TAG = createField("TAG", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>automobiles.databasechangelog.LIQUIBASE</code>.
     */
    public final TableField<DatabasechangelogRecord, String> LIQUIBASE = createField("LIQUIBASE", org.jooq.impl.SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>automobiles.databasechangelog.CONTEXTS</code>.
     */
    public final TableField<DatabasechangelogRecord, String> CONTEXTS = createField("CONTEXTS", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>automobiles.databasechangelog.LABELS</code>.
     */
    public final TableField<DatabasechangelogRecord, String> LABELS = createField("LABELS", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>automobiles.databasechangelog.DEPLOYMENT_ID</code>.
     */
    public final TableField<DatabasechangelogRecord, String> DEPLOYMENT_ID = createField("DEPLOYMENT_ID", org.jooq.impl.SQLDataType.VARCHAR(10), this, "");

    /**
     * Create a <code>automobiles.databasechangelog</code> table reference
     */
    public Databasechangelog() {
        this(DSL.name("databasechangelog"), null);
    }

    /**
     * Create an aliased <code>automobiles.databasechangelog</code> table reference
     */
    public Databasechangelog(String alias) {
        this(DSL.name(alias), DATABASECHANGELOG);
    }

    /**
     * Create an aliased <code>automobiles.databasechangelog</code> table reference
     */
    public Databasechangelog(Name alias) {
        this(alias, DATABASECHANGELOG);
    }

    private Databasechangelog(Name alias, Table<DatabasechangelogRecord> aliased) {
        this(alias, aliased, null);
    }

    private Databasechangelog(Name alias, Table<DatabasechangelogRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Databasechangelog(Table<O> child, ForeignKey<O, DatabasechangelogRecord> key) {
        super(child, key, DATABASECHANGELOG);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Automobiles.AUTOMOBILES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Databasechangelog as(String alias) {
        return new Databasechangelog(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Databasechangelog as(Name alias) {
        return new Databasechangelog(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Databasechangelog rename(String name) {
        return new Databasechangelog(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Databasechangelog rename(Name name) {
        return new Databasechangelog(name, null);
    }
}
