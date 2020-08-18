package com.changhong.sei.mdms.general.service;

import com.changhong.sei.core.context.ContextUtil;
import com.changhong.sei.core.dao.BaseTreeDao;
import com.changhong.sei.core.service.BaseTreeService;
import com.changhong.sei.core.service.bo.OperateResultWithData;
import com.changhong.sei.mdms.general.dao.RegionDao;
import com.changhong.sei.mdms.general.entity.Region;
import com.changhong.sei.util.IdGenerator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


/**
 * 行政区域(Region)业务逻辑实现类
 *
 * @author sei
 * @since 2020-08-17 14:02:48
 */
@Service("regionService")
public class RegionService extends BaseTreeService<Region> {
    @Autowired
    private RegionDao dao;

    @Override
    protected BaseTreeDao<Region> getDao() {
        return dao;
    }


    public List<Region> getRegionTree() {
        List<Region> rootTree = getAllRootNode();
        List<Region> rootRegionTree = new ArrayList<>();
        for (Region aRootTree : rootTree) {
            Region region = getTree(aRootTree.getId());
            rootRegionTree.add(region);
        }
        return rootRegionTree;
    }

    /**
     * 通过国家id查询行政区域树
     *
     * @param countryId 国家id
     * @return 行政区域树清单
     */
    public List<Region> getRegionTreeByCountry(String countryId) {
        //获取根节点-国家
        Region region = dao.findByCountryIdAndNodeLevel(countryId, 0);
        if (region == null) {
            return Collections.emptyList();
        }
        return buildTree(dao.findByCodePathStartingWithAndIdNot(region.getCodePath(), region.getId()));
    }

    public List<Region> getProvinceByCountry(String countryId) {
        if (StringUtils.isEmpty(countryId)) {
            return Collections.emptyList();
        }
        //获取根节点-国家
        Region region = dao.findByCountryIdAndNodeLevel(countryId, 0);
        if (region == null) {
            return Collections.emptyList();
        }
        return dao.findListByProperty("parentId", region.getId());
    }

    public List<Region> getCityByProvince(String provinceId) {
        if (StringUtils.isEmpty(provinceId)) {
            return Collections.emptyList();
        }
        return dao.findListByProperty("parentId", provinceId);
    }

    /**
     * 保存前检查代码唯一性
     *
     * @param entity 待保存的行政区域
     * @return 操作结果
     */
    @Override
    public OperateResultWithData<Region> save(Region entity) {
        if (StringUtils.isBlank(entity.getCountryId())) {
            // 该行政区域对应国家属性为空！
            return OperateResultWithData.operationFailure("00010");
        }
        String id = IdGenerator.uuid();
        if (StringUtils.isNotBlank(entity.getId())) {
            id = entity.getId();
        }
        if (dao.isCodeExists(ContextUtil.getTenantCode(), entity.getCode(), id)) {
            // 该行政区域代码已存在，不能重复！
            return OperateResultWithData.operationFailure("00011");
        }
        //根节点未国家，因此需要检查是否重复添加国家根节点
        if (StringUtils.isBlank(entity.getParentId())) {
            //获取根节点-国家
            Region region = dao.findByCountryIdAndNodeLevel(entity.getCountryId(), 0);
            if (Objects.nonNull(region) && !Objects.equals(region.getId(), entity.getId())) {
                // 国家根节点，不能重复！
                return OperateResultWithData.operationFailure("00012", region.getName());
            }
        }
        return super.save(entity);
    }
}