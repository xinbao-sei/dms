package com.changhong.sei.dms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import com.changhong.sei.dms.annotation.MasterData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 成本中心(CostCenter)DTO类
 *
 * @author sei
 * @since 2021-04-16 11:18:10
 */
@MasterData(code = "CostCenter", name = "成本中心")
@ApiModel(description = "成本中心DTO")
public class CostCenterDto extends BaseEntityDto {
    private static final long serialVersionUID = 814932228066565165L;
    /**
     * 代码
     */
    @ApiModelProperty(value = "代码")
    private String code;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;
    /**
     * 公司代码
     */
    @ApiModelProperty(value = "ERP公司代码")
    private String erpCorporationCode;
    /**
     * 分类码
     */
    @ApiModelProperty(value = "分类码")
    private String categoryCode;
    /**
     * 货币代码
     */
    @ApiModelProperty(value = "货币代码")
    private String currency;
    /**
     * 起始日期
     */
    @ApiModelProperty(value = "起始日期")
    private Date startDate;
    /**
     * 截止日期
     */
    @ApiModelProperty(value = "截止日期")
    private Date endDate;
    /**
     * 业务范围
     */
    @ApiModelProperty(value = "业务范围")
    private String costRange;
    /**
     * 负责人
     */
    @ApiModelProperty(value = "负责人")
    private String keyPerson;
    /**
     * 利润中心代码
     */
    @ApiModelProperty(value = "利润中心代码")
    private String profitCenterCode;
    /**
     * 功能范围
     */
    @ApiModelProperty(value = "功能范围")
    private String featureRange;
    /**
     * 已冻结
     */
    @NotNull
    @ApiModelProperty(value = "已冻结", required = true)
    private Boolean frozen = Boolean.FALSE;
    /**
     * 租户代码
     */
    @ApiModelProperty(value = "租户代码")
    private String tenantCode;


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

    public String getErpCorporationCode() {
        return erpCorporationCode;
    }

    public void setErpCorporationCode(String erpCorporationCode) {
        this.erpCorporationCode = erpCorporationCode;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCostRange() {
        return costRange;
    }

    public void setCostRange(String costRange) {
        this.costRange = costRange;
    }

    public String getKeyPerson() {
        return keyPerson;
    }

    public void setKeyPerson(String keyPerson) {
        this.keyPerson = keyPerson;
    }

    public String getProfitCenterCode() {
        return profitCenterCode;
    }

    public void setProfitCenterCode(String profitCenterCode) {
        this.profitCenterCode = profitCenterCode;
    }

    public String getFeatureRange() {
        return featureRange;
    }

    public void setFeatureRange(String featureRange) {
        this.featureRange = featureRange;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

}