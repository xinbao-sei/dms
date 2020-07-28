package com.changhong.sei.mdms.api;

import com.changhong.sei.core.api.BaseEntityApi;
import com.changhong.sei.mdms.dto.LabelLibraryDto;
import org.springframework.cloud.openfeign.FeignClient;

import javax.validation.Valid;

/**
 * 标签库(LabelLibrary)API
 *
 * @author sei
 * @since 2020-07-28 17:34:28
 * TODO @FeignClient(name = "请修改为项目服务名")
 */
@Valid
@FeignClient(name = "mdms", path = "labelLibrary")
public interface LabelLibraryApi extends BaseEntityApi<LabelLibraryDto> {

}