import axios, { AxiosResponse } from 'axios';
import { SaleDto } from '../types';

const instance = axios.create({
  baseURL: 'https://linkflix.link:5001/',
  timeout: 15000,
});

const responseBody = (response: AxiosResponse) => response.data;

const requests = {
  get: (url: string) => instance.get(url).then(responseBody),
  post: (url: string, body: {}) => instance.post(url, body).then(responseBody),
  put: (url: string, body: {}) => instance.put(url, body).then(responseBody),
  delete: (url: string) => instance.delete(url).then(responseBody),
};

export const ProductSaleApi = {
  getProductSales: (keyword: string): Promise<SaleDto> =>
    requests.get(`get?name=${keyword}`),
};
