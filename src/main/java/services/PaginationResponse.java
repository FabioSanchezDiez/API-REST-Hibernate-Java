package services;

import java.util.List;

public class PaginationResponse<T> {
    private List<T> elements;
    private long elementsNumber;
    private int pageNumber;
    private int pageSize;

    public PaginationResponse() {
    }

    public PaginationResponse(List<T> elements, long elementsNumber, int pageNumber, int pageSize) {
        this.elements = elements;
        this.elementsNumber = elementsNumber;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public List<T> getElements() {
        return elements;
    }

    public void setElements(List<T> elements) {
        this.elements = elements;
    }

    public long getElementsNumber() {
        return elementsNumber;
    }

    public void setElementsNumber(long elementsNumber) {
        this.elementsNumber = elementsNumber;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
