/*
 * This file is generated by jOOQ.
*/
package db.tables.records;


import db.tables.Takedraft;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TakedraftRecord extends UpdatableRecordImpl<TakedraftRecord> implements Record3<Integer, Integer, Integer> {

    private static final long serialVersionUID = 1599547158;

    /**
     * Setter for <code>public.takedraft.id</code>.
     */
    public TakedraftRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.takedraft.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.takedraft.user_id</code>.
     */
    public TakedraftRecord setUserId(Integer value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.takedraft.user_id</code>.
     */
    public Integer getUserId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>public.takedraft.last_revision</code>.
     */
    public TakedraftRecord setLastRevision(Integer value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.takedraft.last_revision</code>.
     */
    public Integer getLastRevision() {
        return (Integer) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, Integer> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row3<Integer, Integer, Integer> valuesRow() {
        return (Row3) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Takedraft.TAKEDRAFT.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Takedraft.TAKEDRAFT.USER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field3() {
        return Takedraft.TAKEDRAFT.LAST_REVISION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component2() {
        return getUserId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component3() {
        return getLastRevision();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getUserId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value3() {
        return getLastRevision();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TakedraftRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TakedraftRecord value2(Integer value) {
        setUserId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TakedraftRecord value3(Integer value) {
        setLastRevision(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TakedraftRecord values(Integer value1, Integer value2, Integer value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TakedraftRecord
     */
    public TakedraftRecord() {
        super(Takedraft.TAKEDRAFT);
    }

    /**
     * Create a detached, initialised TakedraftRecord
     */
    public TakedraftRecord(Integer id, Integer userId, Integer lastRevision) {
        super(Takedraft.TAKEDRAFT);

        set(0, id);
        set(1, userId);
        set(2, lastRevision);
    }
}