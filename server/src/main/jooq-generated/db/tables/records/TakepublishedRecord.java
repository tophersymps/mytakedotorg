/*
 * This file is generated by jOOQ.
*/
package db.tables.records;


import db.tables.Takepublished;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record14;
import org.jooq.Row14;
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
public class TakepublishedRecord extends UpdatableRecordImpl<TakepublishedRecord> implements Record14<Integer, Integer, String, String, String, Timestamp, String, Timestamp, String, Integer, Integer, Integer, Integer, Integer> {

    private static final long serialVersionUID = -1360102029;

    /**
     * Setter for <code>public.takepublished.id</code>.
     */
    public TakepublishedRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.takepublished.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.takepublished.user_id</code>.
     */
    public TakepublishedRecord setUserId(Integer value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.takepublished.user_id</code>.
     */
    public Integer getUserId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>public.takepublished.title</code>.
     */
    public TakepublishedRecord setTitle(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.takepublished.title</code>.
     */
    public String getTitle() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.takepublished.title_slug</code>.
     */
    public TakepublishedRecord setTitleSlug(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.takepublished.title_slug</code>.
     */
    public String getTitleSlug() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.takepublished.blocks</code>.
     */
    public TakepublishedRecord setBlocks(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.takepublished.blocks</code>.
     */
    public String getBlocks() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.takepublished.published_at</code>.
     */
    public TakepublishedRecord setPublishedAt(Timestamp value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.takepublished.published_at</code>.
     */
    public Timestamp getPublishedAt() {
        return (Timestamp) get(5);
    }

    /**
     * Setter for <code>public.takepublished.published_ip</code>.
     */
    public TakepublishedRecord setPublishedIp(String value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.takepublished.published_ip</code>.
     */
    public String getPublishedIp() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.takepublished.deleted_at</code>.
     */
    public TakepublishedRecord setDeletedAt(Timestamp value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>public.takepublished.deleted_at</code>.
     */
    public Timestamp getDeletedAt() {
        return (Timestamp) get(7);
    }

    /**
     * Setter for <code>public.takepublished.deleted_ip</code>.
     */
    public TakepublishedRecord setDeletedIp(String value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>public.takepublished.deleted_ip</code>.
     */
    public String getDeletedIp() {
        return (String) get(8);
    }

    /**
     * Setter for <code>public.takepublished.count_view</code>.
     */
    public TakepublishedRecord setCountView(Integer value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>public.takepublished.count_view</code>.
     */
    public Integer getCountView() {
        return (Integer) get(9);
    }

    /**
     * Setter for <code>public.takepublished.count_like</code>.
     */
    public TakepublishedRecord setCountLike(Integer value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>public.takepublished.count_like</code>.
     */
    public Integer getCountLike() {
        return (Integer) get(10);
    }

    /**
     * Setter for <code>public.takepublished.count_bookmark</code>.
     */
    public TakepublishedRecord setCountBookmark(Integer value) {
        set(11, value);
        return this;
    }

    /**
     * Getter for <code>public.takepublished.count_bookmark</code>.
     */
    public Integer getCountBookmark() {
        return (Integer) get(11);
    }

    /**
     * Setter for <code>public.takepublished.count_spam</code>.
     */
    public TakepublishedRecord setCountSpam(Integer value) {
        set(12, value);
        return this;
    }

    /**
     * Getter for <code>public.takepublished.count_spam</code>.
     */
    public Integer getCountSpam() {
        return (Integer) get(12);
    }

    /**
     * Setter for <code>public.takepublished.count_illegal</code>.
     */
    public TakepublishedRecord setCountIllegal(Integer value) {
        set(13, value);
        return this;
    }

    /**
     * Getter for <code>public.takepublished.count_illegal</code>.
     */
    public Integer getCountIllegal() {
        return (Integer) get(13);
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
    // Record14 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row14<Integer, Integer, String, String, String, Timestamp, String, Timestamp, String, Integer, Integer, Integer, Integer, Integer> fieldsRow() {
        return (Row14) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row14<Integer, Integer, String, String, String, Timestamp, String, Timestamp, String, Integer, Integer, Integer, Integer, Integer> valuesRow() {
        return (Row14) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return Takepublished.TAKEPUBLISHED.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return Takepublished.TAKEPUBLISHED.USER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return Takepublished.TAKEPUBLISHED.TITLE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return Takepublished.TAKEPUBLISHED.TITLE_SLUG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return Takepublished.TAKEPUBLISHED.BLOCKS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field6() {
        return Takepublished.TAKEPUBLISHED.PUBLISHED_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field7() {
        return Takepublished.TAKEPUBLISHED.PUBLISHED_IP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field8() {
        return Takepublished.TAKEPUBLISHED.DELETED_AT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field9() {
        return Takepublished.TAKEPUBLISHED.DELETED_IP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field10() {
        return Takepublished.TAKEPUBLISHED.COUNT_VIEW;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field11() {
        return Takepublished.TAKEPUBLISHED.COUNT_LIKE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field12() {
        return Takepublished.TAKEPUBLISHED.COUNT_BOOKMARK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field13() {
        return Takepublished.TAKEPUBLISHED.COUNT_SPAM;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field14() {
        return Takepublished.TAKEPUBLISHED.COUNT_ILLEGAL;
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
    public String component3() {
        return getTitle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component4() {
        return getTitleSlug();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component5() {
        return getBlocks();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component6() {
        return getPublishedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component7() {
        return getPublishedIp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp component8() {
        return getDeletedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String component9() {
        return getDeletedIp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component10() {
        return getCountView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component11() {
        return getCountLike();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component12() {
        return getCountBookmark();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component13() {
        return getCountSpam();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer component14() {
        return getCountIllegal();
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
    public String value3() {
        return getTitle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getTitleSlug();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getBlocks();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value6() {
        return getPublishedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value7() {
        return getPublishedIp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value8() {
        return getDeletedAt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value9() {
        return getDeletedIp();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value10() {
        return getCountView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value11() {
        return getCountLike();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value12() {
        return getCountBookmark();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value13() {
        return getCountSpam();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value14() {
        return getCountIllegal();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TakepublishedRecord value1(Integer value) {
        setId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TakepublishedRecord value2(Integer value) {
        setUserId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TakepublishedRecord value3(String value) {
        setTitle(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TakepublishedRecord value4(String value) {
        setTitleSlug(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TakepublishedRecord value5(String value) {
        setBlocks(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TakepublishedRecord value6(Timestamp value) {
        setPublishedAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TakepublishedRecord value7(String value) {
        setPublishedIp(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TakepublishedRecord value8(Timestamp value) {
        setDeletedAt(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TakepublishedRecord value9(String value) {
        setDeletedIp(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TakepublishedRecord value10(Integer value) {
        setCountView(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TakepublishedRecord value11(Integer value) {
        setCountLike(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TakepublishedRecord value12(Integer value) {
        setCountBookmark(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TakepublishedRecord value13(Integer value) {
        setCountSpam(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TakepublishedRecord value14(Integer value) {
        setCountIllegal(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TakepublishedRecord values(Integer value1, Integer value2, String value3, String value4, String value5, Timestamp value6, String value7, Timestamp value8, String value9, Integer value10, Integer value11, Integer value12, Integer value13, Integer value14) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TakepublishedRecord
     */
    public TakepublishedRecord() {
        super(Takepublished.TAKEPUBLISHED);
    }

    /**
     * Create a detached, initialised TakepublishedRecord
     */
    public TakepublishedRecord(Integer id, Integer userId, String title, String titleSlug, String blocks, Timestamp publishedAt, String publishedIp, Timestamp deletedAt, String deletedIp, Integer countView, Integer countLike, Integer countBookmark, Integer countSpam, Integer countIllegal) {
        super(Takepublished.TAKEPUBLISHED);

        set(0, id);
        set(1, userId);
        set(2, title);
        set(3, titleSlug);
        set(4, blocks);
        set(5, publishedAt);
        set(6, publishedIp);
        set(7, deletedAt);
        set(8, deletedIp);
        set(9, countView);
        set(10, countLike);
        set(11, countBookmark);
        set(12, countSpam);
        set(13, countIllegal);
    }
}