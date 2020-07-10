package alla.shtokal.dto;

import java.util.ArrayList;

public class AllEventsDto {
    ArrayList<EventDto> content = new ArrayList<EventDto>();
    Pageable PageableObject;
    private boolean last;
    private float totalElements;
    private float totalPages;
    private float number;
    private float size;
    Sort SortObject;
    private float numberOfElements;
    private boolean first;
    private boolean empty;


// Getter Methods

    public ArrayList<EventDto> getContent() {
        return content;
    }

    public void setContent(ArrayList<EventDto> content) {
        this.content = content;
    }

    public Pageable getPageable() {
        return PageableObject;
    }

    public boolean getLast() {
        return last;
    }

    public float getTotalElements() {
        return totalElements;
    }

    public float getTotalPages() {
        return totalPages;
    }

    public float getNumber() {
        return number;
    }

    public float getSize() {
        return size;
    }

    public Sort getSort() {
        return SortObject;
    }

    public float getNumberOfElements() {
        return numberOfElements;
    }

    public boolean getFirst() {
        return first;
    }

    public boolean getEmpty() {
        return empty;
    }

// Setter Methods

    public void setPageable(Pageable pageableObject) {
        this.PageableObject = pageableObject;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public void setTotalElements(float totalElements) {
        this.totalElements = totalElements;
    }

    public void setTotalPages(float totalPages) {
        this.totalPages = totalPages;
    }

    public void setNumber(float number) {
        this.number = number;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public void setSort(Sort sortObject) {
        this.SortObject = sortObject;
    }

    public void setNumberOfElements(float numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
}


