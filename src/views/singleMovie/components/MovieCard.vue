/* eslint-disable */

<template>
  <el-card style="margin-bottom:20px;">
    <!--    <div slot="header" class="clearfix text-center">-->
    <!--      <span>电影详情</span>-->
    <!--    </div>-->

    <!-- 电影海报以及文字介绍栏 -->
    <el-row style="margin-top: 2%">
      <!-- 电影海报介绍栏 -->
      <el-col :span="12"> <el-image
        style="width: 200px; height: 300px; float: right; margin-right: 10%"
        :src="url"
        :preview-src-list="srcList"
      />
      </el-col>
      <!-- 电影文字介绍栏 -->
      <el-col :span="12">
        <div>
          <div class="movie-cname">{{ movie.chName }}</div>
          <div class="movie-ename">{{ movie.enName }}</div>
          <!-- 评分 -->
          <el-rate
            v-model="value"
            disabled
            show-score
            text-color="#ff9900"
            :score-template="movie.rate"
          />
          <!-- 类型 -->
          <div class="movie-info" style="margin-top: 2%">类型：{{ movie.mtype }}</div>
          <!-- 国家  -->
          <div class="movie-info">国家：{{ movie.country }}</div>
          <!-- 日期 -->
          <div class="movie-info">日期：{{ movie.date }}</div>
          <!-- 片长 -->
          <div class="movie-info">片长：{{ movie.mlen }}</div>
          <!-- IMDb -->
          <div class="movie-info">IMDb：{{ movie.IMDb }}</div>

        </div>
      </el-col>
    </el-row>

    <div class="user-bio">
      <div class="user-education user-bio-section" style="margin-right: 6%; margin-left: 6%">
        <div class="user-bio-section-header"><svg-icon icon-class="education" /><span>剧情简介</span></div>
        <div class="movie-intro">
          影片改编自道迪·史密斯的小说，故事设定在20世纪70年代朋克摇滚革命时期的伦敦，讲述了一个名叫艾丝黛拉（艾玛·斯通 饰）的年轻骗子的故事。艾丝黛拉是一个聪明又有创意的女孩，她决心用自己的设计让自己出名。她和一对欣赏她的恶作剧嗜好的小偷交上了朋友，并能够一起在伦敦的街道上建立自己的生活。有一天，艾丝黛拉的时尚品味吸引了冯·赫尔曼男爵夫人（艾玛·汤普森 饰）的眼球，她是一位时尚界的传奇人物，拥有毁灭性的时尚和可怕的高雅，但他们的关系引发了一系列事件，导致艾丝黛拉去拥抱她的邪恶一面，成为了兼具疯狂、时尚和报复心的库伊拉。
        </div>
      </div>

      <!-- 演职人员表 -->
      <div class="user-education user-bio-section" style="margin-right: 6%; margin-left: 6%">
        <div class="user-bio-section-header"><svg-icon icon-class="education" /><span>演职人员表</span></div>
        <div class="box-center">
          <el-row :gutter="24">
            <el-col v-for="actor_pic in actor_pic_list" :key="actor_pic" :span="4" style="height: 40%;">
              <el-image
                style="width: 100%; height: 100%;"
                :src="actor_pic"
                :preview-src-list="srcList"
              />
              <p class="text-center">我是大导演</p>
            </el-col>

          </el-row>
        </div>
      </div>

      <!-- 相关图片 -->
      <div class="user-education user-bio-section" style="margin-right: 6%; margin-left: 6%">
        <div class="user-bio-section-header"><svg-icon icon-class="education" /><span>相关图片</span></div>

        <el-carousel :interval="4000" type="card" height="250px" style="">
          <el-carousel-item v-for="image in image_list" :key="image">
            <el-image :src="image" style="height: 100%" />
          </el-carousel-item>
        </el-carousel>
      </div>

    </div>

  </el-card>

</template>

<script>

export default {
  props: {
    movie: {
      type: Object,
      default: () => {
        return {
          chName: '',
          enName: '',
          mtype: '',
          rate: '',
          country: '',
          date: '',
          mlen: '',
          IMDb: ''
        }
      }
    }
  },
  data() {
    return {
      url: 'http://www.yylp.xyz/movie_pic/1.jpg',
      srcList: [
        'http://www.yylp.xyz/movie_pic/1.jpg',
        'http://www.yylp.xyz/movie_pic/2.jpg'
      ],
      actor_pic_list: [
        'http://www.yylp.xyz/actor_pic/1.jpg',
        'http://www.yylp.xyz/actor_pic/2.jpg',
        'http://www.yylp.xyz/actor_pic/3.jpg',
        'http://www.yylp.xyz/actor_pic/4.jpg',
        'http://www.yylp.xyz/actor_pic/5.jpg',
        'http://www.yylp.xyz/actor_pic/6.jpg'
      ],
      value: 3.7,
      fits: ['fill', 'contain', 'cover', 'none', 'scale-down'],
      actor_url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
      image_list: [
        'http://www.yylp.xyz/pic_in_movie/1.jpg',
        'http://www.yylp.xyz/pic_in_movie/2.jpg',
        'http://www.yylp.xyz/pic_in_movie/3.jpg',
        'http://www.yylp.xyz/pic_in_movie/4.jpg',
        'http://www.yylp.xyz/pic_in_movie/5.jpg',
        'http://www.yylp.xyz/pic_in_movie/6.jpg'
      ]
    }
  }
}
</script>

<style lang="scss" scoped>
.el-row {
  margin-bottom: 20px;
  &:last-child {
    margin-bottom: 0;
  }
}
.el-col {
  border-radius: 4px;
}
.bg-purple-dark {
  background: #99a9bf;
}
.bg-purple {
  background: #d3dce6;
}
.bg-purple-light {
  background: #e5e9f2;
}
.grid-content {
  border-radius: 4px;
  min-height: 36px;
}
.row-bg {
  padding: 10px 0;
  background-color: #f9fafc;
}
.box-center {
  margin: 0 auto;
  display: table;
}

.text-muted {
  color: #777;
}

.movie-cname {
  font-weight: bold;
  font-size: 30px;
}

.movie-ename {
  margin-top: 1%;
  margin-bottom: 1%;
  font-weight: bold;
  font-size: 24px;
  color: #777;
}

.movie-info {
  font-size: 20px;
  line-height: 2;
  color: #777;
  text-align: justify; //两边对齐
}

.movie-intro {
  font-size: 18px;
  line-height: 2;
  color: #777;
  text-align: justify; //两边对齐
}

.user-profile {
  .user-name {
    font-weight: bold;
  }

  .box-center {
    padding-top: 10px;
  }

  .user-role {
    padding-top: 10px;
    font-weight: 400;
    font-size: 14px;
  }

  .box-social {
    padding-top: 30px;

    .el-table {
      border-top: 1px solid #dfe6ec;
    }
  }

  .user-follow {
    padding-top: 20px;
  }
}

.user-bio {
  margin-top: 20px;
  color: #606266;

  span {
    padding-left: 4px;
  }

  .user-bio-section {
    font-size: 14px;
    padding: 15px 0;

    .user-bio-section-header {
      border-bottom: 1px solid #dfe6ec;
      padding-bottom: 10px;
      margin-bottom: 10px;
      font-weight: bold;
    }
  }
}
</style>
