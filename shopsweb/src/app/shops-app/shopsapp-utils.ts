import { Router } from '@angular/router';

export default class ShopsappUtils {

    static get0ToNArray(N: number): number[] {
        return Array.apply(null, { length: N }).map(Number.call, Number);
    }

    static getRangeArray(start: number, end: number): number[] {
        var list = [];
        for (var i = start; i <= end; i++) {
            list.push(i);
        }
        return list;
    }

}