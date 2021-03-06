package software.lawyer.service.model.base;

/**
 * 分页model
 * 
 * @author 曲波
 */
public class PageModel {

    private int pageSize = 10;
    private int currentPage;// 当前页
    private long nextPage;// 下一页
    private long prePage;// 上一页
    private long totalCount;// 总数
    private long pageCount;// 总页数
    private boolean isHasNext = true;// 是否有下一页
    private int beginIndex;// 起始点
    private int endIndex;// 结束点
    
    public PageModel() {
    }

    public PageModel(String currentPage) {
        int tmp = 1;
        if (currentPage == null || currentPage.trim().equals("")) {

        } else {
            tmp = Integer.parseInt(currentPage);
            if (tmp <= 0) {
                tmp = 1;
            }
        }
        this.currentPage = tmp;
    }

    public PageModel(int currentPage) {
        if (currentPage <= 0) {
            currentPage = 1;
        }
        this.currentPage = currentPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getBeginIndex() {
        if(beginIndex==0){
            beginIndex = (currentPage - 1) * pageSize;
        }
        return beginIndex;
    }

    public void setBeginIndex(int beginIndex) {
        this.beginIndex = beginIndex;
    }

    public int getEndIndex() {
        endIndex = getBeginIndex() + pageSize;
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        pageCount = totalCount / pageSize + (totalCount % pageSize == 0 ? 0 : 1);
        if (pageCount <= currentPage) {
            isHasNext = false;
        } else {
            isHasNext = true;
        }
        if (pageCount == 0) {
            pageCount = 1;
        }
        this.totalCount = totalCount;
        changePage();
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public long getNextPage() {
        return nextPage;
    }

    public void setNextPage(long nextPage) {
        this.nextPage = nextPage;
    }

    public long getPrePage() {
        return prePage;
    }

    public void setPrePage(long prePage) {
        this.prePage = prePage;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    public void changePage() {
        ++nextPage;
        --prePage;
        if (nextPage > pageCount) {
            nextPage = pageCount;
        }
        if (prePage < 1) {
            prePage = 1;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isHasNext() {
        return isHasNext;
    }

    public void setHasNext(boolean isHasNext) {
        this.isHasNext = isHasNext;
    }

}
