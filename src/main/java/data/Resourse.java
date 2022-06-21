package data;

import java.util.List;

/**
 * Класс для работы с данными ответа сервера
 */
public class Resourse {

    private Integer page;
    private Integer per_page;
    private Integer total;
    private Integer total_pages;
    private List<DataUser> data;
    private Support support;

    public Integer getPage() {
        return page;
    }

    public Integer getPer_page() {
        return per_page;
    }

    public Integer getTotal() {
        return total;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public List<DataUser> getData() {
        return data;
    }

    public Support getSupport() {
        return support;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public void setPer_page(Integer per_page) {
        this.per_page = per_page;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public void setData(List<DataUser> data) {
        this.data = data;
    }

    public void setSupport(Support support) {
        this.support = support;
    }
}
