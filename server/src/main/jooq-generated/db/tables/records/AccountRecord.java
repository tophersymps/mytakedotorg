/*
 * This file is generated by jOOQ.
 */
package db.tables.records;


import db.tables.Account;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AccountRecord extends UpdatableRecordImpl<AccountRecord> implements Record11<Integer, String, String, String, LocalDateTime, String, LocalDateTime, String, LocalDateTime, String, LocalDateTime> {

    private static final long serialVersionUID = 1700210925;

    /**
     * Setter for <code>public.account.id</code>.
     */
    public AccountRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.account.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.account.username</code>.
     */
    public AccountRecord setUsername(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.account.username</code>.
     */
    public String getUsername() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.account.email</code>.
     */
    public AccountRecord setEmail(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.account.email</code>.
     */
    public String getEmail() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.account.name</code>.
     */
    public AccountRecord setName(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.account.name</code>.
     */
    public String getName() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.account.created_at</code>.
     */
    public AccountRecord setCreatedAt(LocalDateTime value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.account.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(4);
    }

    /**
     * Setter for <code>public.account.created_ip</code>.
     */
    public AccountRecord setCreatedIp(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.account.created_ip</code>.
     */
    public String getCreatedIp() {
        return (String) get(5);
    }

    /**
     * Setter for <code>public.account.updated_at</code>.
     */
    public AccountRecord setUpdatedAt(LocalDateTime value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>public.account.updated_at</code>.
     */
    public LocalDateTime getUpdatedAt() {
        return (LocalDateTime) get(6);
    }

    /**
     * Setter for <code>public.account.updated_ip</code>.
     */
    public AccountRecord setUpdatedIp(String value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>public.account.updated_ip</code>.
     */
    public String getUpdatedIp() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.account.last_seen_at</code>.
     */
    public AccountRecord setLastSeenAt(LocalDateTime value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>public.account.last_seen_at</code>.
     */
    public LocalDateTime getLastSeenAt() {
        return (LocalDateTime) get(8);
    }

    /**
     * Setter for <code>public.account.last_seen_ip</code>.
     */
    public AccountRecord setLastSeenIp(String value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>public.account.last_seen_ip</code>.
     */
    public String getLastSeenIp() {
        return (String) get(9);
    }

    /**
     * Setter for <code>public.account.last_emailed_at</code>.
     */
    public AccountRecord setLastEmailedAt(LocalDateTime value) {
        set(10, value);
        return this;
    }

    /**
     * Getter for <code>public.account.last_emailed_at</code>.
     */
    public LocalDateTime getLastEmailedAt() {
        return (LocalDateTime) get(10);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row11<Integer, String, String, String, LocalDateTime, String, LocalDateTime, String, LocalDateTime, String, LocalDateTime> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    @Override
    public Row11<Integer, String, String, String, LocalDateTime, String, LocalDateTime, String, LocalDateTime, String, LocalDateTime> valuesRow() {
        return (Row11) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Account.ACCOUNT.ID;
    }

    @Override
    public Field<String> field2() {
        return Account.ACCOUNT.USERNAME;
    }

    @Override
    public Field<String> field3() {
        return Account.ACCOUNT.EMAIL;
    }

    @Override
    public Field<String> field4() {
        return Account.ACCOUNT.NAME;
    }

    @Override
    public Field<LocalDateTime> field5() {
        return Account.ACCOUNT.CREATED_AT;
    }

    @Override
    public Field<String> field6() {
        return Account.ACCOUNT.CREATED_IP;
    }

    @Override
    public Field<LocalDateTime> field7() {
        return Account.ACCOUNT.UPDATED_AT;
    }

    @Override
    public Field<String> field8() {
        return Account.ACCOUNT.UPDATED_IP;
    }

    @Override
    public Field<LocalDateTime> field9() {
        return Account.ACCOUNT.LAST_SEEN_AT;
    }

    @Override
    public Field<String> field10() {
        return Account.ACCOUNT.LAST_SEEN_IP;
    }

    @Override
    public Field<LocalDateTime> field11() {
        return Account.ACCOUNT.LAST_EMAILED_AT;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getUsername();
    }

    @Override
    public String component3() {
        return getEmail();
    }

    @Override
    public String component4() {
        return getName();
    }

    @Override
    public LocalDateTime component5() {
        return getCreatedAt();
    }

    @Override
    public String component6() {
        return getCreatedIp();
    }

    @Override
    public LocalDateTime component7() {
        return getUpdatedAt();
    }

    @Override
    public String component8() {
        return getUpdatedIp();
    }

    @Override
    public LocalDateTime component9() {
        return getLastSeenAt();
    }

    @Override
    public String component10() {
        return getLastSeenIp();
    }

    @Override
    public LocalDateTime component11() {
        return getLastEmailedAt();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getUsername();
    }

    @Override
    public String value3() {
        return getEmail();
    }

    @Override
    public String value4() {
        return getName();
    }

    @Override
    public LocalDateTime value5() {
        return getCreatedAt();
    }

    @Override
    public String value6() {
        return getCreatedIp();
    }

    @Override
    public LocalDateTime value7() {
        return getUpdatedAt();
    }

    @Override
    public String value8() {
        return getUpdatedIp();
    }

    @Override
    public LocalDateTime value9() {
        return getLastSeenAt();
    }

    @Override
    public String value10() {
        return getLastSeenIp();
    }

    @Override
    public LocalDateTime value11() {
        return getLastEmailedAt();
    }

    @Override
    public AccountRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public AccountRecord value2(String value) {
        setUsername(value);
        return this;
    }

    @Override
    public AccountRecord value3(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public AccountRecord value4(String value) {
        setName(value);
        return this;
    }

    @Override
    public AccountRecord value5(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public AccountRecord value6(String value) {
        setCreatedIp(value);
        return this;
    }

    @Override
    public AccountRecord value7(LocalDateTime value) {
        setUpdatedAt(value);
        return this;
    }

    @Override
    public AccountRecord value8(String value) {
        setUpdatedIp(value);
        return this;
    }

    @Override
    public AccountRecord value9(LocalDateTime value) {
        setLastSeenAt(value);
        return this;
    }

    @Override
    public AccountRecord value10(String value) {
        setLastSeenIp(value);
        return this;
    }

    @Override
    public AccountRecord value11(LocalDateTime value) {
        setLastEmailedAt(value);
        return this;
    }

    @Override
    public AccountRecord values(Integer value1, String value2, String value3, String value4, LocalDateTime value5, String value6, LocalDateTime value7, String value8, LocalDateTime value9, String value10, LocalDateTime value11) {
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
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached AccountRecord
     */
    public AccountRecord() {
        super(Account.ACCOUNT);
    }

    /**
     * Create a detached, initialised AccountRecord
     */
    public AccountRecord(Integer id, String username, String email, String name, LocalDateTime createdAt, String createdIp, LocalDateTime updatedAt, String updatedIp, LocalDateTime lastSeenAt, String lastSeenIp, LocalDateTime lastEmailedAt) {
        super(Account.ACCOUNT);

        set(0, id);
        set(1, username);
        set(2, email);
        set(3, name);
        set(4, createdAt);
        set(5, createdIp);
        set(6, updatedAt);
        set(7, updatedIp);
        set(8, lastSeenAt);
        set(9, lastSeenIp);
        set(10, lastEmailedAt);
    }
}
