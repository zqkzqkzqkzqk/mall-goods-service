package com.mall.goods.adapter.in.web.controller;

import com.mall.goods.adapter.in.web.dto.CreateBrandRequest;
import com.mall.goods.application.command.CreateBrandCommand;
import com.mall.goods.application.port.in.BrandCreateUseCase;
import com.mall.goods.common.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 品牌管理控制器
 * 提供品牌的完整CRUD操作
 * @author zhangqiankai
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/brand")
@RequiredArgsConstructor
@Tag(name = "品牌管理", description = "品牌管理相关接口")
public class BrandController {

    private final BrandCreateUseCase brandCreateUseCase;

    /**
     * 品牌创建
     * @param command
     * @return
     */
    @PostMapping("/create")
    @Operation(summary = "品牌创建", description = "管理员通过管理界面创建品牌")
    public Result<Long> create(@Valid @RequestBody CreateBrandRequest command) {
        CreateBrandCommand createBrandCommand = new CreateBrandCommand(command.brandEnglish(), command.brandImage(), command.brandInitial(), command.brandName(), command.brandSort(), command.isRecommend(), command.showType(), command.createBy());
        Long brand = brandCreateUseCase.createBrand(createBrandCommand);
        return Result.success(brand);
    }
}