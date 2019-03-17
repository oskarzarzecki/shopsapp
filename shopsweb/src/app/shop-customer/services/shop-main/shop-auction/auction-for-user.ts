export class AuctionForUser {
    id: number;
    description: string;
    descriptionShort: string;
    name: string;
    priceBrutto: number;
    auctionDeliveryOptions: AuctionDeliveryOption[];
    product: Product;
}

export class Product {
    id: number;
    name: string;
    productPropertyValues: ProductPropertyValue[];
    productVariants: ProductVariant[];
}

export class ProductPropertyValue {
    name: string;
    description: string;
}

export class AuctionDeliveryOption {
    name: string;
    price: number;
    timeFrom: Date;
    timeTo: Date;
    paymentOption: string;
}

export class ProductVariant {
    id: number;
    name: string;
    productImages: ProductImage[];
}

export class ProductImage {
    id: string;
    path: string;
}