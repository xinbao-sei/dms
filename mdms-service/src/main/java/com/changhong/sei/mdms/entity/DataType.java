package com.changhong.sei.mdms.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 数据类型(DataType)实体类
 *
 * @author sei
 * @since 2020-07-28 17:31:45
 */
@Entity
@Table(name = "data_type")
@DynamicInsert
@DynamicUpdate
public class DataType extends BaseAuditableEntity implements Serializable {
    private static final long serialVersionUID = 524019926391293272L;
    /**
     * 标识符
     */
    @Column(name = "code")
    private String code;
    /**
     * 名称
     */
    @Column(name = "name")
    private String name;
    /**
     * 长度
     */
    @Column(name = "data_length")
    private Integer dataLength;
    /**
     * 精度
     */
    @Column(name = "precision")
    private Integer precision;
    /**
     * java类型
     */
    @Column(name = "java_type")
    private String javaType;
    /**
     * mysql类型
     */
    @Column(name = "mysql_type")
    private String mysqlType;
    /**
     * postgre类型
     */
    @Column(name = "postgre_type")
    private String postgreType;
    /**
     * oracle类型
     */
    @Column(name = "oracle_type")
    private String oracleType;
    /**
     * mssql类型
     */
    @Column(name = "mssql_type")
    private String mssqlType;
    /**
     * 描述说明
     */
    @Column(name = "remark")
    private String remark;
    /**
     * 冻结
     */
    @Column(name = "frozen")
    private Boolean frozen;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDataLength() {
        return dataLength;
    }

    public void setDataLength(Integer dataLength) {
        this.dataLength = dataLength;
    }

    public Integer getPrecision() {
        return precision;
    }

    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getMysqlType() {
        return mysqlType;
    }

    public void setMysqlType(String mysqlType) {
        this.mysqlType = mysqlType;
    }

    public String getPostgreType() {
        return postgreType;
    }

    public void setPostgreType(String postgreType) {
        this.postgreType = postgreType;
    }

    public String getOracleType() {
        return oracleType;
    }

    public void setOracleType(String oracleType) {
        this.oracleType = oracleType;
    }

    public String getMssqlType() {
        return mssqlType;
    }

    public void setMssqlType(String mssqlType) {
        this.mssqlType = mssqlType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

}