

###本项目基于mybatis-plus二次封装，致力于简化多表查询，特殊场景查询
####目前只针对多表查询使用（单表查询plus框架足以胜任）


###使用方式：
>场景一： 多表分页查询

Controller
```
@RequestMapping("/page")
    public R<IPage<SysUserVO>> page(SysUserVO sysUserVO) {
        Page<SysUserVO> page = new Page(1,10);
        return R.ok(sysUserService.findPage(page, sysUserVO));
    }
```
Service
```
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
    @Override
    public IPage<SysUserVO> findPage(Page<SysUserVO> page, SysUserVO sysUserVO) {

        return baseMapper.findPage(page, Condition.get(sysUserVO));
    }

}
```
Mapper
```java
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    @Select("${ew.sqlSelect} " +
            "from sys_user u " +
            "left join sys_user_role ur on ur.user_id=u.id " +
            "left join sys_role r on ur.role_id=r.id " +
            " ${ew.customSqlSegment}")
    IPage<SysUserVO> findPage(Page<SysUserVO> page, @Param(Constants.WRAPPER) Wrapper wrapper);
}
```
也可以使用xml
```xml
 <select id="findPage" resultType="com.example.demo.entity.vo.SysUserVO">
    ${ew.sqlSelect}
    from sys_user u
    left join sys_user_role ur on ur.user_id=u.id
    left join sys_role r on ur.role_id=r.id
    ${ew.customSqlSegment}
 </select>
```
 ###注意：
 多表查询在查询的字段和条件中通常要使用表别名，避免字段冲突
 ```java
public class SysUserVO extends SysUser {
    @TableField("r.name")
    private String roleName;
    @TableField("u.id")
    private String id;
    @TableField("u.create_date")
    private String createDate;
    @TableField("u.modify_date")
    private String modifyDate;
    @TableField("u.name")
    private String name;
}
```
使用plus原生注解@TableField("u.name") 指定别名，如果VO类继承父类的属性中要使用别名需重写该属性，如果觉得麻烦可以不使用自动封装的查询字段（默认查询VO类所有属性字段，包括继承的）
> Condition.get(sysUserVO).select("xxxx") 可以覆盖默认的查询字段

>场景二

###自定义注解@Conditions灵活性
```java
/**
 * @author ljd
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Conditions {
    SqlKeywords value() default SqlKeywords.EQUAL;
}
```
类似于plus原生注解@TableField(condition = SqlCondition.LIKE)
> 封装多条件查询，自定义日期查询方式，格式转化，可扩展==
#####例：title字段不包含某字符
```java
    @Conditions(SqlKeywords.NOT_LIKE)
    private String title;
```
#####创建日期在某个时间区间内
```java
@Conditions(SqlKeywords.BETWEEN)
    private String createDate;
```
前端传两个时间用‘，’逗号分隔开，这样后台只需要加个注解而不用写其他代码简化了很多
```java
BETWEEN(){
        @Override
        public void approve(QueryWrapper<?> qw, String k, Object v) {
            String[] doubleStr = Convert.toStr(v).split(",");
            qw.between(k,doubleStr[0],doubleStr[1]);
        }
```
单个日期模糊匹配，查询2020-05-07创建的用户
```java
    @Conditions(SqlKeywords.LIKE_DATE)
    private String createDate;
```
使用右模糊查询不影响索引使用
```java
LIKE_DATE(){
        @Override
        public void approve(QueryWrapper<?> qw, String k, Object v) {
            qw.likeRight(k, DateUtil.formatDate(Convert.toDate(v)));
        }
    },
```
有值不想加入查询条件的字段
```java
    @Conditions(SqlKeywords.IGNORE)
    private String name;
```
加入查询条件但是不加入查询结果的字段，可命名为DTO字段，例：
```java
    private String nameDTO;
```
其余查询场景可自行扩展
>场景三
#####多表查询代码拼接sql
```java
return baseMapper.findPage(page, Condition.get(sysUserVO).from(SysUser.class,"u")
                .leftJoin(SysUserRole.class,"ur","ur.user_id=u.id")
                .leftJoin(SysRole.class,"r","ur.role_id=r.id"));
```
后续拼接条件改为Lambda 表达式(持续开发中..)

>场景四
####查询用户列表及角色名称以及角色下所拥有的菜单资源列表
。。。。。。。。。。。。。

>由于个人能力有限，如果本项目有什么不对的地方欢迎留言指正
#如果本项目对你有帮助请给我一个Star
###相关内容会更新至Blog [https://mumudadi.top](https://mumudadi.top)
