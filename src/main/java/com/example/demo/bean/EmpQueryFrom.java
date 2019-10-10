package com.example.demo.bean;

/**
 * @Author:LiuKangwei
 * @Date:2019/9/22 16:43
 * @Description:
 */
public class EmpQueryFrom {
    /**
     * 员工编号
     */
    private Integer empno;

    /**
     * 员工名称
     */
    private String ename;

   /**
    * @Author:LiuKangwei
    * @param null
    * @Return:
    * @Date:2019/9/22 17:58
    * @Description:每页数据条数
    */
    private Integer pageSize;

    /**
     * @Author:LiuKangwei
     * @param null
     * @Return:
     * @Date:2019/9/22 17:58
     * @Description: 当前页码
     */
    private Integer currPage;

   /**
    * @Author:LiuKangwei
    * @param null
    * @Return:
    * @Date:2019/9/22 17:59
    * @Description: 关键字
    */
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }
}
