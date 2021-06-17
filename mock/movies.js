/* eslint-disable */
//模拟电影
const movies_mock = {
  code: "20000",
  shortReviews: [
    {
      "date": "2021-06-06",
      "IMDb": "tt3228774",
      "mtype": "喜剧犯罪",
      "country": "美国",
      "postTime": "2021-06-16 18:48:06",
      "posterURL": "http://www.yylp.xyz/movie_pic/1.jpg",
      "rate": 4,
      "intro": "影片改编自道迪·史密斯的小说，故事设定在20世纪70年代朋克摇滚革命时期的伦敦，讲述了一个名叫艾丝黛拉（艾玛·斯通 饰）的年轻骗子的故事。艾丝黛拉是一个聪明又有创意的女孩，她决心用自己的设计让自己出名。",
      "enName": "Cruella",
      "srContent": "这次没问题",
      "mlen": "134",
      "chName": "黑白魔女库伊拉"
    },
    {
      "date": "2014-12-23",
      "IMDb": "tt3950078",
      "mtype": "剧情动作",
      "country": "中国大陆",
      "postTime": "2021-06-15 10:11:23",
      "posterURL": "http://www.yylp.xyz/movie_pic/1.jpg",
      "rate": 4,
      "enName": "The Taking of Tiger Mountain",
      "srContent": "稍微欠点意思。",
      "mlen": "143",
      "chName": "智取威虎山"
    }
  ]
};

const hot_movie_list_mock = [
  {
    IMDb: "tt3228774",
    imgsrc: "http://www.yylp.xyz/res/posters/tt3228774.jpg",
    chName: "黑白魔女库伊拉"
  },
  {
    IMDb: "tt7069210",
    imgsrc: "http://www.yylp.xyz/res/posters/tt7069210.jpg",
    chName: "招魂3"
  },
  {
    IMDb: "tt14466064",
    imgsrc: "http://www.yylp.xyz/res/posters/tt14466064.jpg",
    chName: "追虎擒龙"
  },
  {
    IMDb: "tt13655044",
    imgsrc: "http://www.yylp.xyz/res/posters/tt13655044.jpg",
    chName: "扫黑·决战"
  },
  {
    IMDb: "tt11083552",
    imgsrc: "http://www.yylp.xyz/res/posters/tt11083552.jpg",
    chName: "人之怒"
  }
]

const good_movie_list_mock = [
  {
    IMDb: "tt0111161",
    imgsrc: "http://www.yylp.xyz/res/posters/tt0111161.jpg",
    chName: "肖申克的救赎"
  },
  {
    IMDb: "tt0120338",
    imgsrc: "http://www.yylp.xyz/res/posters/tt0120338.jpg",
    chName: "泰坦尼克号"
  },
  {
    IMDb: "tt0110413",
    imgsrc: "http://www.yylp.xyz/res/posters/tt0110413.jpg",
    chName: "这个杀手不太冷"
  },
  {
    IMDb: "tt0109830",
    imgsrc: "http://www.yylp.xyz/res/posters/tt0109830.jpg",
    chName: "阿甘正传"
  },
  {
    IMDb: "tt0245429",
    imgsrc: "http://www.yylp.xyz/res/posters/tt0245429.jpg",
    chName: "千与千寻"
  }
]

const chinese_movie_list_mock = [
  {
    IMDb: "tt7362036",
    imgsrc: "http://www.yylp.xyz/res/posters/tt7362036.jpg",
    chName: "我不是药神"
  },
  {
    IMDb: "tt9586294",
    imgsrc: "http://www.yylp.xyz/res/posters/tt9586294.jpg",
    chName: "少年的你"
  },
  {
    IMDb: "tt10627720",
    imgsrc: "http://www.yylp.xyz/res/posters/tt10627720.jpg",
    chName: "哪吒之魔童降世"
  },
  {
    IMDb: "tt1533117",
    imgsrc: "http://www.yylp.xyz/res/posters/tt1533117.jpg",
    chName: "让子弹飞"
  },
  {
    IMDb: "tt0106332",
    imgsrc: "http://www.yylp.xyz/res/posters/tt0106332.jpg",
    chName: "霸王别姬"
  }
]

export {
  movies_mock,
  chinese_movie_list_mock,
  good_movie_list_mock,
  hot_movie_list_mock
}
