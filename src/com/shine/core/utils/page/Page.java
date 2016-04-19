package com.shine.core.utils.page;

import java.util.List;
import java.util.regex.Pattern;


public class Page<E> {

    private static final Pattern pattern = Pattern.compile("(\\?|&).+?=(.+?)((?=&)|$)");

    private int pageSize = 10; // 每页多少条,默认10
    private int pageNum; // 页码 ，从1开始
    private int totalCount; // 总条数
    private List<E> data; // 数据集合
    private int maxLabelCount = 8; // 分页标签最多个数,默认10个
    private int totalPage; // 总页数
    private String url; // 查询条件url
    private String condition;
    private boolean post;

    public Page() {
    }

    /**
     * @param data
     *            结果集
     * @param pageSize
     *            每页多少条
     * @param pageNum
     *            页码
     * @param totalCount
     *            总条数
     */
    public Page(List<E> data, int pageSize, int pageNum, int totalCount) {
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = this.totalCount / this.pageSize + (this.totalCount % this.pageSize == 0 ? 0 : 1);
        this.data = data;
        if (pageNum < 1 || pageNum > totalPage) {
            pageNum = 1;
        }
        this.pageNum = pageNum;
    }

    public int getTotalPage() {
        return totalPage;
    }

    private String createInput(String name, Object value, String type) {
        return "<input type=\"" + type + "\" name=\"" + name + "\" value=\"" + String.valueOf(value) + "\"/>";
    }

    public String toHtml() {
        StringBuffer sb = new StringBuffer();
        if (post) {
            sb.append("<script type=\"text/javascript\">function goPage(pageNum){document.getElementsByName('page')[0].value=pageNum;document.pageFrm.submit();}</script>");
            sb.append("<form name=\"pageFrm\" action=\"" + url + "\" method=\"post\">");
            if (condition != null && !condition.equals("")) {
                String strs[] = condition.split("&");
                for (String string : strs) {
                    String[] c = string.split("=");
                    if (c.length == 2) {
                        sb.append(createInput(c[0], c[1], "hidden"));
                    } else if (c.length == 1) {
                        sb.append(createInput(c[0], "", "hidden"));
                    }
                }
            }
            sb.append(createInput("rows", pageSize, "hidden"));
            sb.append(createInput("page", pageNum, "hidden"));
        }
        if(totalPage == 1){
            return "";
        }
        sb.append("<div class=\"paging clearfix pr15\">");
        sb.append("<div class=\"fr\">");
        // 拼接页码样式
        sb.append("<ul class=\"pagingNum fl\">");
        if (pageNum > 1) {
            sb.append(createB("pagingLast", "上一页", pageNum - 1));
            //sb.append(createA(1));
        }
        int start =pageNum - maxLabelCount / 2;
        if(start < 1) {
            start = 1;
        }
        int end = start + maxLabelCount - 1;
        if(end > getTotalPage()){
            end = getTotalPage();
            if(end - 7 > 0){
                start = end - 7;
            }
            if(end <= 8){
                start = 1;
            }
        }
        for(int i = start;i <= end;i++){
            if(i == pageNum) {
                sb.append("<li class=\"pagingCur\">" + i + "</li>");
            }else {
                sb.append(createA(i));
            }
        }
        sb.append("</ul>");
        if(pageNum < getTotalPage()){
            sb.append(createB("pagingNext", "下一页", pageNum + 1));
        }
        sb.append("</div>");
        sb.append("</div>");
        if (post) {
            sb.append("</form>");
        }
        return sb.toString();
    }

    // 页码生成
    private String createA(int currentNum) {
        if (post) {
            return "<li onclick=\"goPage(" + currentNum + ")\">" + currentNum + "</li>";
        } else {
            StringBuffer sb = join(currentNum);
            return "<li onclick=\"window.location.href=\'" + sb.toString() + "\'\">" + currentNum + "</li>";
        }
    }

    // 上一页/下一页
    private String createB(String css, String text, int currentNum) {
        if (post) {
            return "<div class=\"" + css + "\" onclick=\"goPage(" + currentNum + ")\">" + text + "</div>";
        } else {
            StringBuffer sb = join(currentNum);
            return "<div class=\"" + css + "\" onclick=\"window.location.href=\'" + sb.toString() + "\'\">" + text +
                   "</div>";
        }
    }

    private StringBuffer join(int currentNum) {
        StringBuffer sb = null;
        if (currentNum == 0) {
            sb = new StringBuffer(this.url + "?" + "&rows=" + pageSize);
        } else {
            sb = new StringBuffer(this.url + "?page=" + currentNum + "&rows=" + pageSize);
        }
        sb.append("&" + condition);
        return sb;
    }


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        if (this.pageNum == 0)
            pageNum = 1;
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }

    public int getMaxLabelCount() {
        return maxLabelCount;
    }

    protected void setMaxLabelCount(int maxLabelCount) {
        this.maxLabelCount = maxLabelCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    protected String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    protected void setPost(boolean post) {
        this.post = post;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
