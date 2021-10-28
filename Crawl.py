from flask import Flask
app = Flask(__name__)
 
@app.route('/')
def hello_world():
    return 'Hello World!'
 
if __name__ == '__main__':
    app.run()


# import requests
# from bs4 import BeautifulSoup
# from pprint import pprint
# from flask import Flask

# app = Flask(__name__)

# @app.route("/")
# def linkflix():
#     item_name = '신민아 원피스'
#     # 쇼핑 주소
#     r = requests.get(f'https://search.shopping.naver.com/search/all?frm=NVSHMDL&origQuery={item_name}&pagingIndex=1&pagingSize=40&productSet=model&query={item_name}&sort=rel&timestamp=&viewType=list')
#     # soup parsing
#     soup = BeautifulSoup(r.content, 'html.parser')
#     # 최상단 상품 url
#     goods_url = soup.find('a', "thumbnail_thumb__3Agq6")['href']
#     goods_soup = BeautifulSoup(requests.get(goods_url).content, 'html.parser')
#     image_path = goods_soup.select('#__next > div > div.style_container__3iYev > div.style_inner__1Eo2z > div.style_content_wrap__2VTVx > div.style_content__36DCX > div > div.image_thumb_area__1dzNx > div.image_photo_area__44Fqz > div > img')[0]['src']
#     data = {'id' : item_name, 'image_path' : image_path}
#     print(data)
#     return 'data'

# if __name__ == "__main__":
#     app.run()

