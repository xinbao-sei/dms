package com.changhong.sei.dms.general.dto;

import com.changhong.sei.core.dto.BaseEntityDto;
import com.changhong.sei.dms.annotation.MasterData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 总帐科目(LedgerAccount)DTO类
 *
 * @author sei
 * @since 2021-04-16 16:16:42
 */
@MasterData(code = "LedgerAccount", name = "总帐科目")
@ApiModel(description = "总帐科目DTO")
public class LedgerAccountDto extends BaseEntityDto {
    private static final long serialVersionUID = -20597707472993289L;
    /**
     * 代码
     */
    @NotBlank
    @Size(max = 10)
    @ApiModelProperty(value = "代码")
    private String code;
    /**
     * 名称
     */
    @NotBlank
    @Size(max = 200)
    @ApiModelProperty(value = "名称")
    private String name;
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

    public String getTenantCode() {
        return tenantCode;
    }

    public void setTenantCode(String tenantCode) {
        this.tenantCode = tenantCode;
    }

}