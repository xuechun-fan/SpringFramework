package cn.luischen.constant;

/**
 * Created by Donghua.Chen on 2018/4/30.
 */
public enum Types {

    /** 标签 */
    TAG("tag"),
    /** 类别 */
    CATEGORY("category"),
    /** 提交 */
    ARTICLE("post"),
    /** 发布 */
    PUBLISH("publish"),
    /** 分页 */
    PAGE("page"),
    /** 编辑 */
    DRAFT("draft"),
    /** 链接 */
    LINK("link"),
    /** 图片 */
    IMAGE("image"),
    /** 文件 */
    FILE("file"),
    /** CSRF */
    CSRF_TOKEN("csrf_token"),
    /** 评论频率 */
    COMMENTS_FREQUENCY("comments:frequency"),
    /** 照片 */
    PHOTO("photo"),
    /** 附件存放的URL，默认为网站地址，如集成第三方则为第三方CDN域名 */
    ATTACH_URL("attach_url"),
    /** 网站要过滤，禁止访问的ip列表 */
    BLOCK_IPS("site_block_ips");


    private String type;

    Types(java.lang.String type) {
        this.type = type;
    }

    public java.lang.String getType() {
        return type;
    }

    public void setType(java.lang.String type) {
        this.type = type;
    }
}
