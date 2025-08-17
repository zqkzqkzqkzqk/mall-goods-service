# Mall Goods Domain Layer

## 架构概述

本模块采用领域驱动设计（DDD）和六边形架构模式，实现了商品服务的领域层。

## 目录结构

```
src/main/java/com/mall/goods/domain/
├── model/                    # 领域模型
│   ├── goods/               # 商品聚合根
│   │   ├── GoodsCommon.java     # 商品通用信息聚合根
│   │   ├── Goods.java           # 商品SKU聚合根
│   │   ├── GoodsCommonId.java   # 商品通用信息ID值对象
│   │   ├── GoodsId.java         # 商品SKU ID值对象
│   │   ├── GoodsName.java       # 商品名称值对象
│   │   └── StoreId.java         # 店铺ID值对象
│   ├── category/            # 分类聚合根
│   │   ├── Category.java        # 分类聚合根
│   │   └── CategoryId.java      # 分类ID值对象
│   ├── brand/               # 品牌聚合根
│   │   ├── Brand.java           # 品牌聚合根
│   │   └── BrandId.java         # 品牌ID值对象
│   ├── spec/                # 规格聚合根
│   │   ├── Spec.java            # 规格聚合根
│   │   ├── SpecValue.java       # 规格值值对象
│   │   ├── SpecId.java          # 规格ID值对象
│   │   └── SpecValueId.java     # 规格值ID值对象
│   └── unit/                # 单位聚合根
│       ├── Unit.java            # 单位聚合根
│       └── UnitId.java          # 单位ID值对象
├── repository/              # 仓储接口
│   ├── GoodsRepository.java     # 商品仓储接口
│   ├── CategoryRepository.java  # 分类仓储接口
│   ├── BrandRepository.java     # 品牌仓储接口
│   ├── SpecRepository.java      # 规格仓储接口
│   ├── SpecValueRepository.java # 规格值仓储接口
│   └── UnitRepository.java      # 单位仓储接口
├── service/                 # 领域服务
│   ├── GoodsDomainService.java      # 商品领域服务
│   ├── CategoryDomainService.java   # 分类领域服务
│   ├── BrandDomainService.java      # 品牌领域服务
│   ├── SpecDomainService.java       # 规格领域服务
│   └── UnitDomainService.java       # 单位领域服务
└── event/                   # 领域事件
    ├── DomainEvent.java         # 领域事件基类
    ├── GoodsCreatedEvent.java   # 商品创建事件
    ├── GoodsUpdatedEvent.java   # 商品更新事件
    ├── GoodsDeletedEvent.java   # 商品删除事件
    ├── GoodsStateChangedEvent.java # 商品状态变更事件
    ├── CategoryCreatedEvent.java   # 分类创建事件
    ├── BrandCreatedEvent.java      # 品牌创建事件
    ├── SpecCreatedEvent.java       # 规格创建事件
    └── UnitCreatedEvent.java       # 单位创建事件
```

## 聚合根说明

### 1. Goods（商品聚合根）
- **GoodsCommon**: 商品通用信息聚合根，包含商品的基本信息、价格、分类、品牌等
- **Goods**: 商品SKU聚合根，包含具体的规格、库存、价格等信息

### 2. Category（分类聚合根）
- 支持多级分类结构
- 包含分类名称、排序、层级深度等信息
- 支持分类的增删改查操作

### 3. Brand（品牌聚合根）
- 包含品牌名称、英文名、图片、排序等信息
- 支持品牌申请状态管理
- 支持推荐品牌功能

### 4. Spec（规格聚合根）
- 包含规格名称、规格值等信息
- 支持按店铺管理规格
- 支持规格值的批量操作

### 5. Unit（单位聚合根）
- 包含单位名称、排序等信息
- 支持商品计量单位管理

## 领域服务说明

### 1. GoodsDomainService
- 商品名称和序列号重复性检查
- 分类和品牌有效性验证
- 商品价格计算
- 商品状态变更验证

### 2. CategoryDomainService
- 分类名称重复性检查
- 分类路径计算
- 分类删除验证
- 分类层级深度计算

### 3. BrandDomainService
- 品牌名称和英文名重复性检查
- 品牌删除验证
- 品牌申请状态验证
- 品牌名称格式验证

### 4. SpecDomainService
- 规格名称重复性检查
- 规格值名称重复性检查
- 规格删除验证
- 规格名称格式验证

### 5. UnitDomainService
- 单位名称重复性检查
- 单位删除验证
- 单位名称格式验证
- 排序值验证

## 领域事件说明

领域事件用于在聚合根状态发生变化时通知其他聚合根或外部系统：

- **GoodsCreatedEvent**: 商品创建时触发
- **GoodsUpdatedEvent**: 商品更新时触发
- **GoodsDeletedEvent**: 商品删除时触发
- **GoodsStateChangedEvent**: 商品状态变更时触发
- **CategoryCreatedEvent**: 分类创建时触发
- **BrandCreatedEvent**: 品牌创建时触发
- **SpecCreatedEvent**: 规格创建时触发
- **UnitCreatedEvent**: 单位创建时触发

## 设计原则

1. **聚合根设计**: 每个聚合根都有明确的边界和职责
2. **值对象**: 使用值对象封装不可变的概念
3. **领域服务**: 处理跨聚合的业务逻辑
4. **仓储接口**: 定义数据访问的抽象接口
5. **领域事件**: 实现聚合根之间的解耦通信

## 使用说明

1. 聚合根通过构造函数进行业务验证
2. 业务操作通过聚合根的方法实现
3. 领域服务处理复杂的业务逻辑
4. 仓储接口由基础设施层实现
5. 领域事件通过事件总线发布 