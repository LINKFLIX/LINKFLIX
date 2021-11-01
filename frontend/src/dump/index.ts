import { Product, Sale } from '../types';

export const testProductList: Product[] = [
  {
    id: '1',
    name: '[엘무드] 오디너리 크롭 가디건 네이비',
    searchKeyword: '엘무드 오디너리 크롭 가디건 네이비',
    imagePath:
      'https://image.musinsa.com/images/goods_img/20200827/1567182/1567182_4_320.jpg',
    timeline: [
      {
        netflixEpisodeId: '3612481234',
        startTime: '20:12',
        endTime: '23:01',
      },
    ],
  },
  {
    id: '2',
    name: '에이스침대 BMA 1139-E 침대 D (CA)',
    searchKeyword: '에이스침대 BMA 1139-E 침대',
    imagePath:
      'http://img.danawa.com/prod_img/500000/419/105/img/5105419_1.jpg',
    timeline: [
      {
        netflixEpisodeId: '3612481234',
        startTime: '19:52',
        endTime: '20:00',
      },
      {
        netflixEpisodeId: '3612481234',
        startTime: '1:46:13',
        endTime: '1:50:09',
      },
      {
        netflixEpisodeId: '3612481234',
        startTime: '2:01:57',
        endTime: '2:02:01',
      },
    ],
  },
  {
    id: '3',
    name: '[노메뉴얼] PPS HAIRY CARDIGAN - BLACK',
    searchKeyword: '노메뉴얼 가디건 블랙',
    imagePath:
      'https://image.musinsa.com/images/goods_img/20210808/2052492/2052492_1_320.jpg',
    timeline: [
      {
        netflixEpisodeId: '3612481234',
        startTime: '43:02',
        endTime: '44:10',
      },
      {
        netflixEpisodeId: '3612481234',
        startTime: '1:01:52',
        endTime: '1:07:33',
      },
    ],
  },
  {
    id: '4',
    name: '[테스트] 데이터가 없는 아이템',
    searchKeyword: 'No Data',
    imagePath: '',
    timeline: [],
  },
  {
    id: '5',
    name: '[테스트] 데이터가 없는 아이템',
    searchKeyword: 'No Data',
    imagePath: '',
    timeline: [],
  },
  {
    id: '6',
    name: '[테스트] 데이터가 없는 아이템',
    searchKeyword: 'No Data',
    imagePath: '',
    timeline: [],
  },
  {
    id: '7',
    name: '[테스트] 데이터가 없는 아이템',
    searchKeyword: 'No Data',
    imagePath: '',
    timeline: [],
  },
];

export const testPriceList: { keyword: string; priceList: Sale[] }[] = [
  {
    keyword: '엘무드 오디너리 크롭 가디건 네이비',
    priceList: [
      {
        seller: '무신사',
        price: '210,400',
        link: 'https://store.musinsa.com/app/',
      },
      {
        seller: '<span><b>SSG.COM</b></span>',
        price: '199,900',
        link: 'http://www.ssg.com/',
      },
      {
        seller: '더블유컨셉',
        price: '189,000',
        link: 'https://www.wconcept.co.kr/',
      },
      {
        seller:
          '<a target="_blank" class="productByMall_mall__1ITj0" data-nclick="N=a:smr*m.name,i:27613394415,r:4" data-evcr="evcr" data-i="27613394415" data-t="PROD" data-ms="301045" href="https://cr.shopping.naver.com/adcr.nhn?x=GCcYhNYH06zZ%2BmISqQ1tHf%2F%2F%2Fw%3D%3DsW%2Fyf8rm9LrvQJdE7xfldy%2BLY8Vs0xoA%2F2c7Uz%2B3G%2BpUdRol%2BRjLbBoQG8yYZXEvA4xMFovckWopoRdICAE3juj%2B9zAKZzdOOyFfymht7oBRxssDXYuqelH235YW1Exax334rL%2BbR36BhYe0R%2FrUmjiGtfuLxE5ESI1uVaiTb4zgM3PHM41AmvpqFfOCtxdfs5wZlcK3w1gbKtdNEvwLKqFifOvjHqyFNYBCKw5Lqd4%2BzMoujDsq%2F%2FiX6O%2Fu8%2BoJAIuTqNsv%2BNz8t6reOdIQgz%2B%2FKnwFYLenNnwNXWkxpL8OHYjDtBLqywI%2FHgKfKQiby3BceyHjHXhGNGK9BHU9ngweOSUCjfe4GrXgCoC77%2Blhs%2Bh5muNvyW9mCW9TZDJ1OouP69Jc9aEpPQFvKsxbFL6Tq%2FbD2MGowZHhNOyBhpCdb4jWR1qJjuvMNWBglA7libTfeiTDaBFWPGYdQKCzfkFlteUwjzlLGC%2B1M5ZNWK6OGR0ocb%2BnQg4Q3i50B7voZhSImaPJ8NutJrJuLgl3WTMRkZA5FYRZL6W6OoaIe4MHzl9p7hcSC8CdpLvhz2XNCufSjgXncY07FlOCkQes%2Btfm28nHVIM0WtHBuLCjz3swyseZ77yTk5Yvfce3NdlMIA8Oz83%2FDSjEro0OQ2Xf1AC4dpDrZOlxfFF%2BZFUKxcuJ7DvS5tpOpWRBebGDGLZL3sO0qQfQ5D3HB6abSXvUiN1c7b0b60TgYPzwU0b3Ip1jUGbMEuBm%2BqHMcaY8775K8YMWrm%2BzqOyVMxNJyod8SvGpYCOCmEhHM5fo2sCfDVPbXWrWigt7%2Bvj%2Fr9UrUoaWoJYtuwqZ0HeM1lnlI7XsBkmdNBJdvz0H0ToxvsTwYzr9iKWXDMAKE3sxtFjYELYK5&amp;nvMid=27613394415&amp;catId=50000803"><img src="https://shopping-phinf.pstatic.net/20180724_12/dade0457-b67a-4889-aa4b-0ee5cd79a3ff.jpg" loading="lazy" alt="SSF샵" height="15"></a>',
        price: '199,900',
        link: 'https://www.ssfshop.com/main',
      },
    ],
  },
  {
    keyword: '에이스침대 BMA 1139-E 침대',
    priceList: [
      {
        seller: '무신사',
        price: '1,210,400',
        link: 'https://store.musinsa.com/app/',
      },
      {
        seller: '다나와',
        price: '1,289,000',
        link: 'http://www.danawa.com/',
      },
    ],
  },
  {
    keyword: '노메뉴얼 가디건 블랙',
    priceList: [
      {
        seller: '무신사',
        price: '62,400',
        link: 'https://store.musinsa.com/app/',
      },
      {
        seller: '다나와',
        price: '19,000',
        link: 'http://www.danawa.com/',
      },
    ],
  },
];

/*


*/
