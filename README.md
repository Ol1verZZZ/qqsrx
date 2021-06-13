
## 迷你豆瓣系统

软件系统分析与设计项目作业





# API

## 热映电影列表

路径：'/movies/gethotmovlist'

方法：GET

| 参数名 | 类型 | 说明 |
| :----: | :--: | :--: |
|   -    |  -   |  -   |

返回：

```json
{
    "hotmovlist": [
        {
            "imgsrc": "http://www.yylp.xyz/movie_pic/1.jpg",
            "chName": "黑白魔女库伊拉"
        },
        {
            "imgsrc": "http://www.yylp.xyz/movie_pic/2.jpg",
            "chName": "智取威虎山"
        }
    ],
    "IMDb": "tt3228774",
    "code": 20000
}
```

|   参数名   |   值   |     含义     |
| :--------: | :----: | :----------: |
| hotmovlist |  list  | 热映电影列表 |
|   imgsrc   |  url   |   图片地址   |
|   chName   | string |  电影中文名  |
|    IMDb    | string |  电影标识符  |
|    code    | 20000  |  状态正确码  |



## 一部电影的详情

路径：'movies/getmovie'

方法：GET

| 参数名 |  类型  |    说明    |
| :----: | :----: | :--------: |
|  IMDb  | string | 电影标识符 |

返回：

```json
{
    "movie": {
        "chName": "黑白魔女库伊拉",
        "enName": "Cruella",
        "mtype": "喜剧犯罪",
        "rate": "6.9",
        "country": "美国",
        "date": "2021-06-06",
        "mlen": "134",
        "IMDb": "tt3228774"
    },
    "code": 20000
}
```

| 参数名 |  值   |    含义    |
| :----: | :---: | :--------: |
| movie  |   -   |  电影详情  |
|  code  | 20000 | 状态正确码 |

