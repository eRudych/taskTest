/*
 * This file is generated by jOOQ.
 */
package com.example.demo.db.automobiles;


import com.example.demo.db.automobiles.tables.Auto;

import javax.annotation.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>automobiles</code> schema.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.12"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index AUTO_ID = Indexes0.AUTO_ID;
    public static final Index AUTO_MODEL = Indexes0.AUTO_MODEL;
    public static final Index AUTO_PRIMARY = Indexes0.AUTO_PRIMARY;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index AUTO_ID = Internal.createIndex("id", Auto.AUTO, new OrderField[] { Auto.AUTO.ID }, true);
        public static Index AUTO_MODEL = Internal.createIndex("model", Auto.AUTO, new OrderField[] { Auto.AUTO.MODEL }, true);
        public static Index AUTO_PRIMARY = Internal.createIndex("PRIMARY", Auto.AUTO, new OrderField[] { Auto.AUTO.ID }, true);
    }
}