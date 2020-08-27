/*
 * This file is generated by jOOQ.
 */
package db.tables.records;


import db.tables.Confirmaccountlink;

import java.time.LocalDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ConfirmaccountlinkRecord extends UpdatableRecordImpl<ConfirmaccountlinkRecord> implements Record6<String, LocalDateTime, LocalDateTime, String, String, String> {

    private static final long serialVersionUID = 659759243;

    /**
     * Setter for <code>public.confirmaccountlink.code</code>.
     */
    public ConfirmaccountlinkRecord setCode(String value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>public.confirmaccountlink.code</code>.
     */
    public String getCode() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.confirmaccountlink.created_at</code>.
     */
    public ConfirmaccountlinkRecord setCreatedAt(LocalDateTime value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>public.confirmaccountlink.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(1);
    }

    /**
     * Setter for <code>public.confirmaccountlink.expires_at</code>.
     */
    public ConfirmaccountlinkRecord setExpiresAt(LocalDateTime value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>public.confirmaccountlink.expires_at</code>.
     */
    public LocalDateTime getExpiresAt() {
        return (LocalDateTime) get(2);
    }

    /**
     * Setter for <code>public.confirmaccountlink.requestor_ip</code>.
     */
    public ConfirmaccountlinkRecord setRequestorIp(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>public.confirmaccountlink.requestor_ip</code>.
     */
    public String getRequestorIp() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.confirmaccountlink.username</code>.
     */
    public ConfirmaccountlinkRecord setUsername(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>public.confirmaccountlink.username</code>.
     */
    public String getUsername() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.confirmaccountlink.email</code>.
     */
    public ConfirmaccountlinkRecord setEmail(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>public.confirmaccountlink.email</code>.
     */
    public String getEmail() {
        return (String) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<String, LocalDateTime, LocalDateTime, String, String, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<String, LocalDateTime, LocalDateTime, String, String, String> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Confirmaccountlink.CONFIRMACCOUNTLINK.CODE;
    }

    @Override
    public Field<LocalDateTime> field2() {
        return Confirmaccountlink.CONFIRMACCOUNTLINK.CREATED_AT;
    }

    @Override
    public Field<LocalDateTime> field3() {
        return Confirmaccountlink.CONFIRMACCOUNTLINK.EXPIRES_AT;
    }

    @Override
    public Field<String> field4() {
        return Confirmaccountlink.CONFIRMACCOUNTLINK.REQUESTOR_IP;
    }

    @Override
    public Field<String> field5() {
        return Confirmaccountlink.CONFIRMACCOUNTLINK.USERNAME;
    }

    @Override
    public Field<String> field6() {
        return Confirmaccountlink.CONFIRMACCOUNTLINK.EMAIL;
    }

    @Override
    public String component1() {
        return getCode();
    }

    @Override
    public LocalDateTime component2() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime component3() {
        return getExpiresAt();
    }

    @Override
    public String component4() {
        return getRequestorIp();
    }

    @Override
    public String component5() {
        return getUsername();
    }

    @Override
    public String component6() {
        return getEmail();
    }

    @Override
    public String value1() {
        return getCode();
    }

    @Override
    public LocalDateTime value2() {
        return getCreatedAt();
    }

    @Override
    public LocalDateTime value3() {
        return getExpiresAt();
    }

    @Override
    public String value4() {
        return getRequestorIp();
    }

    @Override
    public String value5() {
        return getUsername();
    }

    @Override
    public String value6() {
        return getEmail();
    }

    @Override
    public ConfirmaccountlinkRecord value1(String value) {
        setCode(value);
        return this;
    }

    @Override
    public ConfirmaccountlinkRecord value2(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public ConfirmaccountlinkRecord value3(LocalDateTime value) {
        setExpiresAt(value);
        return this;
    }

    @Override
    public ConfirmaccountlinkRecord value4(String value) {
        setRequestorIp(value);
        return this;
    }

    @Override
    public ConfirmaccountlinkRecord value5(String value) {
        setUsername(value);
        return this;
    }

    @Override
    public ConfirmaccountlinkRecord value6(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public ConfirmaccountlinkRecord values(String value1, LocalDateTime value2, LocalDateTime value3, String value4, String value5, String value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached ConfirmaccountlinkRecord
     */
    public ConfirmaccountlinkRecord() {
        super(Confirmaccountlink.CONFIRMACCOUNTLINK);
    }

    /**
     * Create a detached, initialised ConfirmaccountlinkRecord
     */
    public ConfirmaccountlinkRecord(String code, LocalDateTime createdAt, LocalDateTime expiresAt, String requestorIp, String username, String email) {
        super(Confirmaccountlink.CONFIRMACCOUNTLINK);

        set(0, code);
        set(1, createdAt);
        set(2, expiresAt);
        set(3, requestorIp);
        set(4, username);
        set(5, email);
    }
}
