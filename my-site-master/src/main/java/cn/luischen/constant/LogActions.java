package cn.luischen.constant;

/**
 * 日志表的action字段
 *
 * @author Donghua.Chen
 * @date 2018/4/30
 */
public enum LogActions {

    /** 登录动作 */
    LOGIN("登录后台"),
    /** 修改密码动作 */
    UP_PWD("修改密码"),
    /** 修改个人信息动作 */
    UP_INFO("修改个人信息"),
    /** 删除文章动作 */
    DEL_ARTICLE("删除文章"),
    /** 删除页面动作 */
    DEL_PAGE("删除页面"),
    /** 系统备份动作 */
    SYS_BACKUP("系统备份"),
    /** 保存系统设置动作 */
    SYS_SETTING("保存系统设置"),
    /** 初始化站点动作 */
    INIT_SITE("初始化站点");

    private String action;

    LogActions(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
