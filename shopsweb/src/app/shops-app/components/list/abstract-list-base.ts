import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class AbstractListBase {

    // consts

    public PRICE_SORT = 'priceSort';

    public DATE_SORT = 'dateSort';

    // functions

    public getNextSortType(sortType: string) {
        switch (sortType) {
            case "":
                return "ASC";
            case "ASC":
                return "DESC";
            case "DESC":
                return "";
            default:
                return "";
        }
    }

}