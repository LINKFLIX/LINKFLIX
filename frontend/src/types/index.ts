export interface Timeline {
  start: string;
  end: string;
}

export interface Product {
  id: string;
  productName: string;
  imgSrc: string;
  price: string;
  timeline: Timeline[];
}
