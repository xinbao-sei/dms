package com.changhong.sei.dms.management.entity;

import com.changhong.sei.core.entity.BaseAuditableEntity;
import com.changhong.sei.core.entity.ICodeUnique;
import com.changhong.sei.core.entity.IFrozen;
import com.changhong.sei.dms.management.dto.DataStructureEnum;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.StringJoiner;

/**
 * 主数据UI配置(MasterDataUiConfig)实体类
 *
 * @author sei
 * @since 2020-08-13 22:47:16
 */
@Entity
@Table(name = "_data_definition")
@DynamicInsert
@DynamicUpdate
public class DataDefinition extends BaseAuditableEntity implements Serializable, ICodeUnique, IFrozen {
    private static final long serialVersionUID = -55502538661881172L;
    public static final String CATEGORY_ID = "categoryId";
    /**
     * 代码(表名)
     */
    @Column(name = "code", nullable = false)
    private String code;
    /**
     * 名称
     */
    @Column(name = "name")
    private String name;
    /**
     * 数据结构
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "data_structure", nullable = false)
    private DataStructureEnum dataStructure;
    /**
     * 分类id
     */
    @Column(name = "category_id", nullable = false)
    private String categoryId;
    /**
     * 分类名称
     */
    @Column(name = "category_name")
    private String categoryName;
    /**
     * 自定义UI
     */
    @Column(name = "customize")
    private Boolean customize = Boolean.FALSE;
    /**
     * 冻结
     * 取消注册即冻结
     */
    @Column(name = "frozen")
    private Boolean frozen = Boolean.FALSE;
    /**
     * 描述说明
     */
    @Column(name = "remark")
    private String remark;

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

    public DataStructureEnum getDataStructure() {
        return dataStructure;
    }

    public void setDataStructure(DataStructureEnum dataStructure) {
        this.dataStructure = dataStructure;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Boolean getCustomize() {
        return customize;
    }

    public void setCustomize(Boolean customize) {
        this.customize = customize;
    }

    @Override
    public Boolean getFrozen() {
        return frozen;
    }

    @Override
    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", DataDefinition.class.getSimpleName() + "[", "]")
                .add("code='" + code + "'")
                .add("name='" + name + "'")
                .toString();
    }
}