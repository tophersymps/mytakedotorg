/*
 * This file is generated by jOOQ.
*/
package db.tables;


import db.Indexes;
import db.Keys;
import db.Public;
import db.bindings.PostgresInetBinding;
import db.bindings.PostgresJsonStringBinding;
import db.tables.records.TakepublishedRecord;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
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
        "jOOQ version:3.10.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Takepublished extends TableImpl<TakepublishedRecord> {

    private static final long serialVersionUID = 1769452543;

    /**
     * The reference instance of <code>public.takepublished</code>
     */
    public static final Takepublished TAKEPUBLISHED = new Takepublished();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TakepublishedRecord> getRecordType() {
        return TakepublishedRecord.class;
    }

    /**
     * The column <code>public.takepublished.id</code>.
     */
    public final TableField<TakepublishedRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('takepublished_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.takepublished.user_id</code>.
     */
    public final TableField<TakepublishedRecord, Integer> USER_ID = createField("user_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.takepublished.title</code>.
     */
    public final TableField<TakepublishedRecord, String> TITLE = createField("title", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>public.takepublished.title_slug</code>.
     */
    public final TableField<TakepublishedRecord, String> TITLE_SLUG = createField("title_slug", org.jooq.impl.SQLDataType.VARCHAR(255).nullable(false), this, "");

    /**
     * The column <code>public.takepublished.blocks</code>.
     */
    public final TableField<TakepublishedRecord, String> BLOCKS = createField("blocks", org.jooq.impl.DefaultDataType.getDefaultDataType("jsonb"), this, "", new PostgresJsonStringBinding());

    /**
     * The column <code>public.takepublished.published_at</code>.
     */
    public final TableField<TakepublishedRecord, Timestamp> PUBLISHED_AT = createField("published_at", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>public.takepublished.published_ip</code>.
     */
    public final TableField<TakepublishedRecord, String> PUBLISHED_IP = createField("published_ip", org.jooq.impl.DefaultDataType.getDefaultDataType("inet"), this, "", new PostgresInetBinding());

    /**
     * The column <code>public.takepublished.deleted_at</code>.
     */
    public final TableField<TakepublishedRecord, Timestamp> DELETED_AT = createField("deleted_at", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>public.takepublished.deleted_ip</code>.
     */
    public final TableField<TakepublishedRecord, String> DELETED_IP = createField("deleted_ip", org.jooq.impl.DefaultDataType.getDefaultDataType("inet"), this, "", new PostgresInetBinding());

    /**
     * The column <code>public.takepublished.count_view</code>.
     */
    public final TableField<TakepublishedRecord, Integer> COUNT_VIEW = createField("count_view", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.takepublished.count_like</code>.
     */
    public final TableField<TakepublishedRecord, Integer> COUNT_LIKE = createField("count_like", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.takepublished.count_bookmark</code>.
     */
    public final TableField<TakepublishedRecord, Integer> COUNT_BOOKMARK = createField("count_bookmark", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.takepublished.count_spam</code>.
     */
    public final TableField<TakepublishedRecord, Integer> COUNT_SPAM = createField("count_spam", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.takepublished.count_illegal</code>.
     */
    public final TableField<TakepublishedRecord, Integer> COUNT_ILLEGAL = createField("count_illegal", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.takepublished.image_url</code>.
     */
    public final TableField<TakepublishedRecord, String> IMAGE_URL = createField("image_url", org.jooq.impl.SQLDataType.CLOB.nullable(false).defaultValue(org.jooq.impl.DSL.field("''::text", org.jooq.impl.SQLDataType.CLOB)), this, "");

    /**
     * Create a <code>public.takepublished</code> table reference
     */
    public Takepublished() {
        this(DSL.name("takepublished"), null);
    }

    /**
     * Create an aliased <code>public.takepublished</code> table reference
     */
    public Takepublished(String alias) {
        this(DSL.name(alias), TAKEPUBLISHED);
    }

    /**
     * Create an aliased <code>public.takepublished</code> table reference
     */
    public Takepublished(Name alias) {
        this(alias, TAKEPUBLISHED);
    }

    private Takepublished(Name alias, Table<TakepublishedRecord> aliased) {
        this(alias, aliased, null);
    }

    private Takepublished(Name alias, Table<TakepublishedRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.TAKEPUBLISHED_PKEY, Indexes.TAKEPUBLISHED_TITLE_USER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<TakepublishedRecord, Integer> getIdentity() {
        return Keys.IDENTITY_TAKEPUBLISHED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<TakepublishedRecord> getPrimaryKey() {
        return Keys.TAKEPUBLISHED_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<TakepublishedRecord>> getKeys() {
        return Arrays.<UniqueKey<TakepublishedRecord>>asList(Keys.TAKEPUBLISHED_PKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<TakepublishedRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<TakepublishedRecord, ?>>asList(Keys.TAKEPUBLISHED__TAKEPUBLISHED_USER_ID_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Takepublished as(String alias) {
        return new Takepublished(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Takepublished as(Name alias) {
        return new Takepublished(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Takepublished rename(String name) {
        return new Takepublished(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Takepublished rename(Name name) {
        return new Takepublished(name, null);
    }
}
