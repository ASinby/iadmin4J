# 一、工程简介

+ 统计行车各种作业时长

# 二、延伸阅读

```text
    考虑一下使用程序逻辑统计行车一些时间信息（用于自动配包）
    
    对于工位点的行车一些时间如下：
    准备时间：从行车到达吊运点开始，到行车吊起东西的时间
    
    吊起时间：从吊起包开始，到离开工位的时间
    
    避让时间：行车实际作业时长-行车预计作业时间（两点之间距离除以行车行驶速度）
```

# 三、拆解分析

## 1、准备时长

    吊起时间 - 到达工位点时间（大车位置不变）
    
    吊起时间在行车指令里面；    √
    到达工位点时间（大车位置有变到不变）——以吊起时间为切入点，向前找到大车坐标发生变化的拐点

## 2、吊起时长

    离开工位点时间（大车位置有不变到变） - 吊起时间
    
    离开工位点时间（大车位置有不变到变）——以吊起时间为切入点，向后找到大车坐标发生变化的拐点
    吊起时间在行车指令里面；    √

## 3、避让时长

+ A、实际作业时长


    行车作业指令表中，放下时间-吊起时间即是！   √

+ B、不发生避让作业时长


    取每对工位行车的‘实际作业时长’中最短的    √

# 四、表结构设计

## 1、CRANE_TIME_CENSUS  行车时间统计
```sql
    CMDNO       DECIMAL 8   命令号
    CRNO        VARCHAR 8   行车号
    LDNO        VARCHAR 8   包号
    START_LOC   VARCHAR 8   起点
    DEST_LOC    VARCHAR 8   终点
    ARRIVE_TIME TIMESTAMP 0 到达作业点时间
    UP_TIME     TIMESTAMP 0 吊起时刻
    LEAVE_TIME  TIMESTAMP 0 离开作业点时间
    DOWN_TIME   TIMESTAMP 0 放下时刻
    WORK_TM     DECIMAL 8   作业时长（秒）
    PREPARE_TM  DECIMAL 8   准备时长（秒）
    UP_TM       DECIMAL 8   吊起时长（秒）
    AVOID_TM    DECIMAL 8   避让时长（秒）
```

## 2、CRANE_WORK_MIN_TM  行车各工位点间最小作业时长
```sql
    SD_ID           INTEGER     序号  自增
    START_DEST_LOC  VARCHAR 20  路径
    MIN_TM          DECIMAL 8   最小作业时长（秒）
    KUANO           DECIMAL 6   跨号
```

