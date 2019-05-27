export class PaginationData {
    itemsCount: number;
    pageSize: number;
    adjacentPages: number;
    showArrows: boolean;

    constructor(itemsCount: number, pageSize: number, adjacentPages: number, showArrows: boolean) {
        this.itemsCount = itemsCount;
        this.pageSize = pageSize;
        this.adjacentPages = adjacentPages;
        this.showArrows = showArrows;
    };
}