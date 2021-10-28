export interface Timeline {
  netflixEpisodeId: string;
  startTime: string;
  endTime: string;
}

export interface Product {
  id: string;
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
