package com.baiyun.entity;

/**
 * 持久化对象
 * 1.列名对应属性名
 * 2.表名对应类名
 * 3.提供共无参构造方法
 * 4.提供get set方法
 */
public class User {
    /**
     * 主键
     */
    private Integer id;
    /**
     *用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 是否启用 1启用 0禁用
     */
    private Integer enable;
    /**
     *角色id
     */
    private Integer role;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", enable=" + enable +
                ", role=" + role +
                '}';
    }
}
