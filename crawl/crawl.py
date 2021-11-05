import requests
from bs4 import BeautifulSoup

def crawl_test(name):
    item_name = name
    # 쇼핑 주소
    r = requests.get(f'https://search.shopping.naver.com/search/all?frm=NVSHMDL&origQuery={item_name}&pagingIndex=1&pagingSize=40&productSet=model&query={item_name}&sort=rel&timestamp=&viewType=list')
    # soup parsing
    soup = BeautifulSoup(r.content, 'html.parser')
    # 최상단 상품 url
    goods_url = soup.find('a', "thumbnail_thumb__3Agq6")['href']
    # print(goods_url)
    # print(goods_url)
    goods_soup = BeautifulSoup(requests.get(goods_url).content, 'html.parser')
    # 요청 데이터
    seller = goods_soup.findAll('a', "productByMall_mall__1ITj0")
    seller_list = []
    for s in seller:
        if s.find('img') == None:
            seller_list.append(s.text)
        else:
            seller_list.append(s.find('img')['src'])
    # seller_list = [s.find('img')['src'] for s in seller if s.find('img') != None]
    # print(seller_list)
    price_low = goods_soup.find_all('td', 'productByMall_price__3F_YF productByMall_low__2FyuG')
    price_list = []
    # for p in price_low:
    #     price_list.append(p.text[3:])
    
    price = goods_soup.find_all('td', 'productByMall_price__3F_YF')
    for p in price:
        if p.text[0] == '최':
            price_list.append(p.text[3:])
        else:
            price_list.append(p.text)

    link = goods_soup.findAll('a', "productByMall_mall__1ITj0")
    link_list = []
    for l in link:
        link_list.append(l['href'])
    
    # seller = goods_soup.select('#__next > div > div.style_container__3iYev > div.style_inner__1Eo2z > div.style_content_wrap__2VTVx > div.style_content__36DCX > div > div.summary_info_area__3XT5U > div.condition_area > table > tbody > tr:nth-child(1) > td.productByMall_mall_area__1oEU_')['src']
    # price = goods_soup.find('td', 'productByMall_price__3F_YF productByMall_low__2FyuG').find('em')
    data = {'seller': seller_list, 'price': price_list, 'link': link_list}
    print(seller_list)
    # return data

crawl_test('이에르로르 에리떼')