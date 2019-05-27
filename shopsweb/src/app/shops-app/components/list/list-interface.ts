import { Observable } from 'rxjs';
import { AbstractList } from './abstract-list';

export interface ListInterface {

    listData$: Observable<AbstractList<any>>;
    basePath: string;

    getBasePath(): string;

}