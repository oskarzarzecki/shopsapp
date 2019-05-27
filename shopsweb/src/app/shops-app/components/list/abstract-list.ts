import { PaginationData } from './pagination-data';

export class AbstractList<T> {
    items: T[];
    paginationData: PaginationData;
}