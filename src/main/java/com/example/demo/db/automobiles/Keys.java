/*
 * This file is generated by jOOQ.
 */
package com.example.demo.db.automobiles;


import com.example.demo.db.automobiles.tables.Auto;
import com.example.demo.db.automobiles.tables.records.AutoRecord;

import javax.annotation.Generated;

import org.jooq.UniqueKey;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables of 
 * the <code>automobiles</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.12"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // IDENTITY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AutoRecord> KEY_AUTO_PRIMARY = UniqueKeys0.KEY_AUTO_PRIMARY;
    public static final UniqueKey<AutoRecord> KEY_AUTO_ID = UniqueKeys0.KEY_AUTO_ID;
    public static final UniqueKey<AutoRecord> KEY_AUTO_MODEL = UniqueKeys0.KEY_AUTO_MODEL;

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------


    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class UniqueKeys0 {
        public static final UniqueKey<AutoRecord> KEY_AUTO_PRIMARY = Internal.createUniqueKey(Auto.AUTO, "KEY_auto_PRIMARY", Auto.AUTO.ID);
        public static final UniqueKey<AutoRecord> KEY_AUTO_ID = Internal.createUniqueKey(Auto.AUTO, "KEY_auto_id", Auto.AUTO.ID);
        public static final UniqueKey<AutoRecord> KEY_AUTO_MODEL = Internal.createUniqueKey(Auto.AUTO, "KEY_auto_model", Auto.AUTO.MODEL);
    }
}