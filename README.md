# 数据迁移

> 该项目主要用户新老项目数据迁移。

## 实现思路

<img height="100%" src="https://resource.liulingfengyu.cn/img/数据迁移流程图.jpg" width="800"/>

## 扩展

1. 实现`DataMigrationService`接口（参考`UserInfoImportProcess`类）
2. 扩展`DataMigrationTypeEnum`枚举类
3. 新增目标数据库操作类（参考`UserInfoLoadData`类）

## 注意

1. `UserInfoImportProcess`类中获取源数据需要在方法上标注数据源`@DS("output")`
2. `UserInfoLoadData`类需要标注目标数据源`@DS("master")`
3. 上面两个类不可合并为一个类，否则会导致切换数据源失败
