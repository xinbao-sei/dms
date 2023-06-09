package com.changhong.sei.dms.general.entity;

import com.changhong.sei.core.dto.IRank;
import com.changhong.sei.core.entity.BaseAuditableEntity;
import com.changhong.sei.core.entity.ICodeUnique;
import com.changhong.sei.core.entity.ITenant;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 国家(Country)实体类
 *
 * @author sei
 * @since 2020-08-17 14:02:39
 */
@Entity
@Table(name = "country")
@DynamicInsert
@DynamicUpdate
public class Country extends BaseAuditableEntity implements Serializable, ICodeUnique, IRank {
    private static final long serialVersionUID = 180242575737929170L;
    /**
     * 代码
     */
    @Column(name = "code")
    private String code;
    /**
     * 名称
     */
    @Column(name = "name")
    private String name;
    /**
     * 国家货币代码
     */
    @Column(name = "currency_code")
    private String currencyCode;
    /**
     * 国家货币名称
     */
    @Column(name = "currency_name")
    private String currencyName;
    /**
     * 是否国外
     */
    @Column(name = "to_foreign")
    private Boolean toForeign = Boolean.FALSE;
    /**
     * 排序
     */
    @Column(name = "rank")
    private Integer rank = 0;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public Boolean getToForeign() {
        return toForeign;
    }

    public void setToForeign(Boolean toForeign) {
        this.toForeign = toForeign;
    }

    @Override
    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}