/*
 * This file is generated by jOOQ.
 */
package com.example.demo.db.automobiles.tables;


import com.example.demo.db.automobiles.Automobiles;
import com.example.demo.db.automobiles.Indexes;
import com.example.demo.db.automobiles.Keys;
import com.example.demo.db.automobiles.tables.records.DatabasechangeloglockRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
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
public class Databasechangeloglock extends TableImpl<DatabasechangeloglockRecord> {

    private static final long serialVersionUID = 780740892;

    /**
     * The reference instance of <code>automobiles.databasechangeloglock</code>
     */
    public static final Databasechangeloglock DATABASECHANGELOGLOCK = new Databasechangeloglock();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<DatabasechangeloglockRecord> getRecordType() {
        return DatabasechangeloglockRecord.class;
    }

    /**
     * The column <code>automobiles.databasechangeloglock.ID</code>.
     */
    public final TableField<DatabasechangeloglockRecord, Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>automobiles.databasechangeloglock.LOCKED</code>.
     */
    public final TableField<DatabasechangeloglockRecord, Boolean> LOCKED = createField("LOCKED", org.jooq.impl.SQLDataType.BIT.nullable(false), this, "");

    /**
     * The column <code>automobiles.databasechangeloglock.LOCKGRANTED</code>.
     */
    public final TableField<DatabasechangeloglockRecord, Timestamp> LOCKGRANTED = createField("LOCKGRANTED", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>automobiles.databasechangeloglock.LOCKEDBY</code>.
     */
    public final TableField<DatabasechangeloglockRecord, String> LOCKEDBY = createField("LOCKEDBY", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * Create a <code>automobiles.databasechangeloglock</code> table reference
     */
    public Databasechangeloglock() {
        this(DSL.name("databasechangeloglock"), null);
    }

    /**
     * Create an aliased <code>automobiles.databasechangeloglock</code> table reference
     */
    public Databasechangeloglock(String alias) {
        this(DSL.name(alias), DATABASECHANGELOGLOCK);
    }

    /**
     * Create an aliased <code>automobiles.databasechangeloglock</code> table reference
     */
    public Databasechangeloglock(Name alias) {
        this(alias, DATABASECHANGELOGLOCK);
    }

    private Databasechangeloglock(Name alias, Table<DatabasechangeloglockRecord> aliased) {
        this(alias, aliased, null);
    }

    private Databasechangeloglock(Name alias, Table<DatabasechangeloglockRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> Databasechangeloglock(Table<O> child, ForeignKey<O, DatabasechangeloglockRecord> key) {
        super(child, key, DATABASECHANGELOGLOCK);
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
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.DATABASECHANGELOGLOCK_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<DatabasechangeloglockRecord> getPrimaryKey() {
        return Keys.KEY_DATABASECHANGELOGLOCK_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<DatabasechangeloglockRecord>> getKeys() {
        return Arrays.<UniqueKey<DatabasechangeloglockRecord>>asList(Keys.KEY_DATABASECHANGELOGLOCK_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Databasechangeloglock as(String alias) {
        return new Databasechangeloglock(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Databasechangeloglock as(Name alias) {
        return new Databasechangeloglock(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Databasechangeloglock rename(String name) {
        return new Databasechangeloglock(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Databasechangeloglock rename(Name name) {
        return new Databasechangeloglock(name, null);
    }
}
