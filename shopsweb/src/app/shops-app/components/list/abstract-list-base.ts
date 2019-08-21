import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class AbstractListBase {

    // consts

    public PRICE_SORT = 'priceSort';

    public DATE_SORT = 'dateSort';

    public PRICE_FROM = 'priceFrom';

    public PRICE_TO = 'priceTo';

    public DATE_FROM = 'dateFrom';

    public DATE_TO = 'dateTo';

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