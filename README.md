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
        posterURL: 'http://www.yylp.xyz/movie_pic/1.jpg',
        chName: '黑白魔女库伊拉',
        enName: 'Cruella',
        mtype: '喜剧犯罪',
        rate: '6.9',
        country: '美国',
        date: '2021-06-06',
        mlen: '134',
        IMDb: 'tt3228774',
        intro: '影片改编自道迪·史密斯的小说，故事设定在20世纪70年代朋克摇滚革命时期的伦敦，讲述了一个名叫艾丝黛拉（艾玛·斯通 饰）的年轻骗子的故事。艾丝黛拉是一个聪明又有创意的女孩，她决心用自己的设计让自己出名。',
        actor_list: [
         { IMDb: 'IMDb1', chName: '小明', imgsrc: 'http://www.yylp.xyz/actor_pic/1.jpg' },
         { IMDb: 'IMDb2', chName: '小明', imgsrc: 'http://www.yylp.xyz/actor_pic/2.jpg' },
         { IMDb: 'IMDb3', chName: '小明', imgsrc: 'http://www.yylp.xyz/actor_pic/3.jpg' },
         { IMDb: 'IMDb4', chName: '小明', imgsrc: 'http://www.yylp.xyz/actor_pic/4.jpg' },
         { IMDb: 'IMDb5', chName: '小明', imgsrc: 'http://www.yylp.xyz/actor_pic/5.jpg' },
         { IMDb: 'IMDb6', chName: '小明', imgsrc: 'http://www.yylp.xyz/actor_pic/6.jpg' }
        ],
        img_list: [
          'http://www.yylp.xyz/pic_in_movie/1.jpg',
          'http://www.yylp.xyz/pic_in_movie/2.jpg',
          'http://www.yylp.xyz/pic_in_movie/3.jpg',
          'http://www.yylp.xyz/pic_in_movie/4.jpg',
          'http://www.yylp.xyz/pic_in_movie/5.jpg',
          'http://www.yylp.xyz/pic_in_movie/6.jpg'
        ]
    },
    "code": 20000
}
```

| 参数名 |  值   |    含义    |
| :----: | :---: | :--------: |
| movie  |   -   |  电影详情  |
|  code  | 20000 | 状态正确码 |





## 一个Artist的详情

路径：'artists/getartist'

方法：GET

| 参数名 |  类型  |      说明      |
| :----: | :----: | :------------: |
|  IMDb  | string | 影视人员标识符 |

返回：

```
{
    "code": 20000,
    "artist": {
        "IMDb": "nm1297015",
        "birthPlace": "美国,亚利桑那,斯科茨代尔",
        "gender": "女",
        "intro": "艾玛·斯通出生在美国亚利桑那州的Scottsdale，他的父母拥有一家高尔夫俱乐部。11岁起，她就开始在当地剧团演出，14岁时，她制作了一份名为“好莱坞计划”的PPT（背景乐是麦当娜的《好莱坞》）展示给父母，表明自己的理想。2004年，15岁的艾玛从中学退学，和母亲一起搬到洛杉矶，在这里她白天外出试镜，晚上复习功课。艾玛起先得到了几份电视剧工作，2007年被贾德·阿帕图挑中出演《超级坏》，在他的建议下把本身的金发染成了红发，从此星运大展。",
        "enName": "Emma Stone",
        "birthDate": "1988-11-06",
        "chName": "艾玛·斯通"
    }
}
```

| 参数名 |    值    |         含义          |
| :----: | :------: | :-------------------: |
|  code  | 20000/-1 | 状态正确码/状态错误码 |
| artist |    -     |     影视人员详情      |



## 标记“想看”

路径：'intention'

方法：POST

|   参数名    |  类型  |        说明        |
| :---------: | :----: | :----------------: |
|   userId    | string |     用户标识符     |
|    IMDb     | string |     电影标识符     |
| description | string | 用户描述想看的理由 |

返回：

```
{
    "result": "add succeeded",
    "code": 20000
}
```

| 参数名 |     值     |                 含义                 |
| :----: | :--------: | :----------------------------------: |
|  code  | 20000/0/-1 | 状态正确码/数据库插入失败/状态错误码 |
| result |     -      |             说明操作结果             |



## 删除“想看”

路径：'intention/delete'

方法：DELETE

| 参数名 |  类型  |    说明    |
| :----: | :----: | :--------: |
| userId | string | 用户标识符 |
|  IMDb  | string | 电影标识符 |

返回：

```
{
    "result": "delete succeeded",
    "code": 20000
}
```

| 参数名 |     值     |                 含义                 |
| :----: | :--------: | :----------------------------------: |
|  code  | 20000/0/-1 | 状态正确码/数据库删除失败/状态错误码 |
| result |     -      |             说明操作结果             |



## 标记“看过”，生成短评

路径：'shortreview'

方法：POST

|  参数名   |  类型  |    说明    |
| :-------: | :----: | :--------: |
|  userId   | string | 用户标识符 |
|   IMDb    | string | 电影标识符 |
|   rate    | string |    评分    |
| srContent | string |  短评内容  |

返回：

```
{
    "result": "add succeeded",
    "code": 20000
}
```

| 参数名 |     值     |                 含义                 |
| :----: | :--------: | :----------------------------------: |
|  code  | 20000/0/-1 | 状态正确码/数据库插入失败/状态错误码 |
| result |     -      |             说明操作结果             |



## 删除短评

路径：'shortreview/delete'

方法：DELETE

| 参数名 |  类型  |    说明    |
| :----: | :----: | :--------: |
| userId | string | 用户标识符 |
|  IMDb  | string | 电影标识符 |

返回：

```
{
    "result": "delete succeeded",
    "code": 20000
}
```

| 参数名 |     值     |                 含义                 |
| :----: | :--------: | :----------------------------------: |
|  code  | 20000/0/-1 | 状态正确码/数据库删除失败/状态错误码 |
| result |     -      |             说明操作结果             |



## 更新短评

路径：'shortreview/update'

方法：PUT

|  参数名   |  类型  |       说明       |
| :-------: | :----: | :--------------: |
|  userId   | string |    用户标识符    |
|   IMDb    | string |    电影标识符    |
|   rate    | string |   更新后的评分   |
| srContent | string | 更新后的短评内容 |

返回：

```
{
    "result": "update succeeded",
    "code": 20000
}
```

| 参数名 |     值     |                 含义                 |
| :----: | :--------: | :----------------------------------: |
|  code  | 20000/0/-1 | 状态正确码/数据库更新失败/状态错误码 |
| result |     -      |             说明操作结果             |



## 根据IMDb编号获取该电影的所有短评

路径：'shortreview/getsrbyIMDb'

方法：GET

| 参数名 |  类型  |    说明    |
| :----: | :----: | :--------: |
|  IMDb  | string | 电影标识符 |

返回：

```
{
    "IMDb": "tt3950078",
    "code": 20000,
    "shortreviewlist": [
        {
            "postTime": "2021-06-14 20:57:23",
            "rate": 5,
            "srContent": "第二次看感觉有点不值5星了",
            "userId": 1
        },
        {
            "postTime": "2021-06-15 10:11:23",
            "rate": 4,
            "srContent": "稍微欠点意思。",
            "userId": 2
        }
    ]
}
```

|     参数名      |    值    |         含义          |
| :-------------: | :------: | :-------------------: |
|      code       | 20000/-1 | 状态正确码/状态错误码 |
| shortreviewlist |    -     |       短评列表        |
|      IMDb       |    -     | 所查询电影的IMDb编号  |

