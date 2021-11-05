import requests
from bs4 import BeautifulSoup
from flask import Flask, request
from flask_cors import CORS

app = Flask(__name__)
CORS(app)

@app.route('/')
def hello():
    return 'Hello, LINKFLIX! Please Use Get Method ^_^'


@app.route('/')
def crawl(name):
    item_name = name
    # 쇼핑 주소
    r = requests.get(f'https://search.shopping.naver.com/search/all?frm=NVSHMDL&origQuery={item_name}&pagingIndex=1&pagingSize=40&productSet=model&query={item_name}&sort=rel&timestamp=&viewType=list')
    # soup parsing
    soup = BeautifulSoup(r.content, 'html.parser')
    # 최상단 상품 url
    goods_url = soup.find('a', "thumbnail_thumb__3Agq6")['href']
    goods_soup = BeautifulSoup(requests.get(goods_url).content, 'html.parser')
    # 판매처
    seller = goods_soup.findAll('a', "productByMall_mall__1ITj0")
    seller_list = []
    for s in seller:
        # 이미지 없는 판매처
        if s.find('img') == None:
            seller_list.append(s.text)
        else:
            seller_list.append(s.find('img')['src'])
    # 가격
    price_list = []    
    price = goods_soup.find_all('td', 'productByMall_price__3F_YF')
    for p in price:
        # 최저 표시 제외
        if p.text[0] == '최':
            price_list.append(p.text[3:])
        else:
            price_list.append(p.text)

    # 링크
    link = goods_soup.findAll('a', "productByMall_mall__1ITj0")
    link_list = []
    for l in link:
        link_list.append(l['href'])
    
    data = {'seller': seller_list, 'price': price_list, 'link': link_list}
    print(data)
    return data

@app.route('/get', methods=['GET'])
def method():
    if request.method == 'GET':
        args_dict = request.args.to_dict()
        return crawl(args_dict['name'])



if __name__ == "__main__": 
    app.run(host='0.0.0.0', port='5001', debug=True)

