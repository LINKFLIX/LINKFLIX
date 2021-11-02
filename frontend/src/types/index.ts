export interface Timeline {
  startTime: string;
}

export interface Product {
  id: number;
  name: string;
  imagePath: string;
  searchKeyword: string;
  timeline: Timeline[];
}

export interface Sale {
  seller: string;
  price: string;
  link: string;
}
export interface ProductWithPriceList {
  product: Product;
  priceList: Sale[];
}

export interface TimelineDto {
  id: number;
  product: {
    createdAt: string;
    id: number;
    imagePath: string;
    name: string;
    searchKeyword: string;
    updatedAt: string;
  };
  startTime: string;
}
